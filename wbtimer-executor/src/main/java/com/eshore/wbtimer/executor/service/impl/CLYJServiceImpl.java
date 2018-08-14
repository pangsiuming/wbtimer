package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.constants.CommConstants;
import com.eshore.wbtimer.executor.mapper.CLYJMapper;
import com.eshore.wbtimer.executor.mapper.PackageInoutProcessMapper;
import com.eshore.wbtimer.executor.mapper.bean.PackageInoutProcess;
import com.eshore.wbtimer.executor.service.CLYJService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:综合接办材料交接的预警service
 *
 * @author Zhangqian
 * @create 2018/1/19 15:18
 */
@Service
public class CLYJServiceImpl implements CLYJService {
    @Autowired
    CLYJMapper clyjMapper;
    @Autowired
    PackageInoutProcessMapper packageInoutProcessMapper;

    @Override
    public void clyj() throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("status", "0");
        params.put("extraCondition", "  not exists (select 1 from PACKAGE_INOUT_PROCESS wi where wi.PACKAGE_PROCESS_ID=A.PACKAGE_PROCESS_ID and wi.FROM_WORKPOST='ZHJB_SPG' and wi.TO_WORKPOST='ZHJB_LZG' ) ");
        List<PackageInoutProcess> list = clyjMapper.queryPackageInout(params);


        if(CollectionUtils.isEmpty(list)){
            //throws GlobalException(ResponseCode.SUCCESS,"有条0需要设置告警");
        }
        WbtimerJobLogger.log("有条"+list.size()+"需要设置告警");
        for(PackageInoutProcess bean:list){
            //计算剩余时间和设置告警状态
            PackageInoutProcess rbean=get_ALERT_STATUS_and_REST_TIME(bean);
            if(null==rbean){
                WbtimerJobLogger.log("计算剩余时间和设置告警状态错误"+bean.getPackageProcessId());
                //logger.info("计算剩余时间和设置告警状态错误"+bean.getPackageProcessId());
                continue;
            }
            //修改状态
            PackageInoutProcess param=new PackageInoutProcess();
            param.setPackageProcessId(bean.getPackageProcessId());
            param.setAlertStatus(rbean.getAlertStatus());
            param.setRestTime(rbean.getRestTime());
            packageInoutProcessMapper.updateById(param);//mp通用mapper切换
        }

    }

    /**
     * 计算剩余时间和设置告警状态
     * @param bean
     * @return
     */
    private PackageInoutProcess get_ALERT_STATUS_and_REST_TIME(PackageInoutProcess bean) {

        try {
            PackageInoutProcess bean1 =null;
            String fromWork=bean.getFromWorkpost();
            String toWork=bean.getToWorkpost();
            // if("".equals(fromWork)||"".equals(toWork)){
            if(StringUtils.isEmpty(fromWork)||StringUtils.isEmpty(toWork)){
                WbtimerJobLogger.log("fromWork:"+fromWork+"toWork:"+toWork+"数据不能为空！");
                return null;
            }
            Date InDate=bean.getInDate();
            //int AlertDay=110;
            int pasemis=0;
            int AlertDay=getAlertDate(fromWork,toWork);
            //System.out.println("AlertDay:"+AlertDay);
            //开始时间不包含
            //须规定事项工单在综合窗口受理完成后多长时间内必须进行交接
            //受理完成的时间落在前一日17:30至当日11:30，需在12:00之前完成交接；受理完成的时间落在当日11:30-17:00，
            //需在当日17:30前完成交接；受理完成时间落在当日17:00至次日11:30，需在次日12:00之前完成交接。
            //当天产生的包裹，只能落入当天的期间内。
            //1.受理岗>流转岗
            if((fromWork.equals("ZHJB_ZHSL")&&toWork.equals("ZHJB_LZG"))||(fromWork.equals("ZHJB_LZG")&&toWork.equals("ZHJB_SPG"))||(fromWork.equals("ZHJB_LZG")&&toWork.equals("ZHJB_FZG"))){
                //当前一日17:30至当日11:30 分 前一日17:30—00:00 and 00:00-11:30
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //获取时间段
                String curTime=getHour_minute(InDate);
                if(StringUtils.isEmpty(curTime)){
                    WbtimerJobLogger.log("获取时间段curTime:"+curTime+"不能为空！");
                    return null;
                }
                //12:00之前完成交接
                boolean time1=isInTime("00:00-11:30", curTime);
                if(time1){
                    //计算现在时间到12:00还有多少分钟，如果预警时间为30分
                    //获取截止时间
                    Date endDate=sdf.parse(getTime(InDate,12,0,"1"));
                    //现在的时间，和截至时间的时间差 剩余时间
                    pasemis=minsBetween(new Date(),endDate);
                    //设置状态
                    bean1 = setAlertDay_paseTime(AlertDay, pasemis);
                    return bean1;
                }
                //当日17:30前完成交接
                boolean time2=isInTime("11:30-17:00", curTime);
                if(time2){
                    //获取截止时间
                    Date endDate=sdf.parse(getTime(InDate,17,30,"1"));
                    pasemis=minsBetween(new Date(),endDate);
                    bean1 = setAlertDay_paseTime(AlertDay, pasemis);
                    return bean1;
                }
                //需在当日17:30前完成交接；受理完成时间落在当日17:00至次日11:30，（17:00-00:00 and 00:00-11:30）需在次日12:00之前完成交接
                boolean time3=isInTime("17:00-00:00", curTime);
                if(time3){
                    //获取截止时间 2表示第二天的12:00
                    Date endDate=sdf.parse(getTime(InDate,12,0,"2"));

                    pasemis=minsBetween(new Date(),endDate);
                    bean1 = setAlertDay_paseTime(AlertDay, pasemis);
                    return bean1;
                }
                /*
                 //2.流转岗>审批岗
                }else if(fromWork.equals("ZHJB_LZG")&&toWork.equals("ZHJB_SPG")){

                //审批岗>流转岗
                }else if(fromWork.equals("ZHJB_SPG")&&toWork.equals("ZHJB_LZG")){
                //4.流转岗>出件岗
                }else if(fromWork.equals("ZHJB_LZG")&&toWork.equals("ZHJB_FZG")){

                }else{
                    //System.out.println("数据错误："+bean.getPackageProcessId());
                }*/
            }else{
                WbtimerJobLogger.log("数据错误fromWork:"+fromWork+"toWork:"+fromWork);
            }
            return bean1;
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
            return null;
        }
    }

    /**
     * 获取截止时间
     * flag 1当天，2第二天
     * @param date
     * @return
     */
    public String getTime(Date date,int Hour,int minuteS,String flag){
        try {
            //日期转换为日历并获取参数
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, Hour);
            if(!"".equals(minuteS)){
                calendar.set(Calendar.MINUTE, minuteS);
            }else{
                calendar.set(Calendar.MINUTE, 0);
            }
            calendar.set(Calendar.SECOND, 0);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day=0;
            if("2".equals(flag)){
                day = calendar.get(Calendar.DAY_OF_MONTH)+1;
            }else{
                day = calendar.get(Calendar.DAY_OF_MONTH);
            }
            int hour = calendar.get(Calendar.HOUR_OF_DAY);//Calendar.HOUR为12小时制
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            // int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            //组织数据打印输出
            StringBuffer info = new StringBuffer();
            info.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour).append(":").append((minute+"").length()==1?"0"+minute:minute).append(":").append((second+"").length()==1?"0"+second:second);
            // System.out.println(info);
            //logger.info(info);
            return info.toString();
        } catch (Exception e) {
            // TODO: handle exception
            WbtimerJobLogger.log(e);
            return "";
        }
    };

    /**
     * 获取时分
     * @param date
     * @return
     */
    public String getHour_minute(Date date){
        try {
            //日期转换为日历并获取参数
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            //  int year = calendar.get(Calendar.YEAR);
            //  int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);//Calendar.HOUR为12小时制
            int minute = calendar.get(Calendar.MINUTE);
            // int second = calendar.get(Calendar.SECOND);
            // int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            //组织数据打印输出
            StringBuffer info = new StringBuffer();
            info.append(hour).append(":").append(minute);
            //System.out.println(info);
            //logger.info(info);
            return info.toString();
        } catch (Exception e) {
            // TODO: handle exception
            WbtimerJobLogger.log(e);
            return "";
        }
    };

    /**
     * 两个时间相差多少分钟
     * @param smdate
     * @param bdate
     * @return
     */
    private int minsBetween(Date smdate, Date bdate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between_mins = 0;
        try {
            String sdate=sdf.format(smdate);
            String edate=sdf.format(bdate);

            //System.out.println(sdate+"--"+edate);
            //logger.info(sdate+"--"+edate);

            smdate = sdf.parse(sdate);
            bdate = sdf.parse(edate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            between_mins = (time2 - time1) / (1000 * 60);
        } catch (ParseException e) {
            WbtimerJobLogger.log(e);
        }

        return Integer.parseInt(String.valueOf(between_mins));
    }

    /**
     * 获取预警时间 min
     * @param AlertDay
     * @param pasemis
     * @return
     */

    private PackageInoutProcess setAlertDay_paseTime(int AlertDay,
                                                         int pasemis) {
        PackageInoutProcess bean1;
        bean1=new PackageInoutProcess();
        bean1.setRestTime(Long.parseLong(pasemis+""));

        //<=预警天数
        if (pasemis<=AlertDay&&pasemis>=0) {
            // 小于等于提前预警天数，大于等于0，开始预警
            bean1.setAlertStatus(CommConstants.ALERT_STATE.WARNING_YELLOW);
        }else if (pasemis < 0) {
            // 超期预警（超时）
            bean1.setAlertStatus(CommConstants.ALERT_STATE.DELAY);
        } else {
            bean1.setAlertStatus(CommConstants.ALERT_STATE.NORMAL);

        }
        return bean1;
    }


    /**
     * 判断某一时间是否在一个区间内
     *
     * @param sourceTime
     *            时间区间,半闭合,如(10:00-20:00]
     * @param curTime
     *            需要判断的时间 如10:00   不包含10点
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceTime, String curTime) {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            // logger.info("now:"+now+"-start:"+start+"-end"+end);
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }  //43200000:43200000 now > end &&
            if (end < start) {
                if (now > end && now<=start) {
                    return false;
                } else {
                    return true;
                }
            }
            else {
                if (now > start && now <= end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            WbtimerJobLogger.log(e);
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }

    }

    public int getAlertDate(String fromWork, String toWork) {
        // TODO Auto-generated method stub

        int i=0;
        //有两条数据 网厅事项，非网厅事项 只能用网厅事项
        Map<String,String> fromParams=new HashMap<>();
        fromParams.put("fromWork",fromWork);
        fromParams.put("toWork",toWork);
        List<Map<String, String>> list=clyjMapper.getAlertDateByWork(fromParams);
        if(list!=null&&list.size()>0){
            Map<String, String> map=list.get(0);
            String ALERT_DATE = map.get("ALERT_DATE")==null?"":map.get("ALERT_DATE").toString();
            if(!StringUtils.isEmpty(ALERT_DATE)){
                i=Integer.parseInt(ALERT_DATE);
            }
        }
        //如果没查询到数据返回0
        return i;
    }

}
