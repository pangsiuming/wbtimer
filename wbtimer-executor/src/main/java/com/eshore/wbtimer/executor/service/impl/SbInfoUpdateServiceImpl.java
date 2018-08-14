package com.eshore.wbtimer.executor.service.impl;

import com.eshore.emall.pub.util.DateUtil;
import com.eshore.wbtimer.common.enums.ResponseCode;
import com.eshore.wbtimer.common.exception.GlobalException;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.constants.CommConstants;
import com.eshore.wbtimer.executor.common.utils.DateUtils;
import com.eshore.wbtimer.executor.mapper.SbInfoUpdateMapper;
import com.eshore.wbtimer.executor.service.SbInfoUpdateService;
import com.eshore.wbtimer.executor.service.bean.ApplyOrderAlertBean;
import com.eshore.wbtimer.executor.service.bean.CommonResultBean;
import com.eshore.wbtimer.executor.service.bean.SpecProgramExtBean;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * 描述:申办表字段剩余天数、预警状态、承诺应办结时间更新进程
 *
 * @author Yangjinming
 * @create 2018/1/29 10:40
 */
@Service
public class SbInfoUpdateServiceImpl implements SbInfoUpdateService {
    private static List<Map<String, Object>> holidayList = new ArrayList<>();
    @Autowired
    SbInfoUpdateMapper sbInfoUpdateMapper;

    @Override
    public void startUpdate() throws Exception {
        List<Long> hjslbsList = sbInfoUpdateMapper.qryDoingMissionSblsh();
        Long hjslbs;
        //默认更新
        boolean updateDalayDayFlag = true;
        Map<String, Object> map;
        if (CollectionUtils.isEmpty(hjslbsList)) {
            throw new GlobalException(ResponseCode.SUCCESS, "更新失败，环节受理办事列表为空");
        }
        WbtimerJobLogger.log("开始更新，数据量为:"+hjslbsList.size());
        for (int loop = 0; loop < hjslbsList.size(); loop++) {
            hjslbs = hjslbsList.get(loop);
            try {
                ApplyOrderAlertBean applyOrderAlertInfo = findApplyOrderAlertInfo(hjslbs);
                if (null != applyOrderAlertInfo) {
                    map = new HashMap<>();
                    map.put("delayDay", applyOrderAlertInfo.getDelayDay());
                    map.put("alertFlag", applyOrderAlertInfo.getAlertFlag());
                    map.put("realPromiseDay", applyOrderAlertInfo.getRealPromiseDay());
                    map.put("promiseBjDate", applyOrderAlertInfo.getPromiseBjDate());
                    map.put("zcx_alert_type", applyOrderAlertInfo.getAlertType());
                    map.put("zcx_rest_day", applyOrderAlertInfo.getRestDay());
                    map.put("zcx_qx", applyOrderAlertInfo.getZcxsx());
                    map.put("hjslbs", hjslbs);
                    sbInfoUpdateMapper.updateWsbsSbPromiseBjTime(map);
                    WbtimerJobLogger.log("插入成功，当前插入数为："+loop);
                }
            } catch (Exception e) {
                e.printStackTrace();
                WbtimerJobLogger.log(e);
            }
        }
    }

    private ApplyOrderAlertBean findApplyOrderAlertInfo(Long hjslbs) {
        //如果是无期限A类的，审批不通过的，不处理
        /**2014-10-14 需求：
         * 预警类型分3种：正常、预警（默认提前1天）、超时；管理员可对预警天数做修改   修改方式不要使用百分比，使用天数。
         * 预警设置：把承诺天数带过来。可以设置预警天数，但是不能超过承诺天数。
         *  2016-8-8
         * 1. 无期限：A类特别程序（无期限）、补齐补正（不论有无期限），挂起后，提示特别程序挂起，剩余天数冻结不再计算，解挂后按实际挂起天数（即 挂起天数=解挂日期-挂起日期 ）延长 承诺应办结日期
         2. 有期限：B类特别程序、A类特别程序（有期限）：
         1) 挂起后，提示特别程序挂起， 承诺应办结日期按“挂起期限”延长时间
         a) 挂起期限内：剩余天数在挂起期限内 承诺办结剩余天数不变
         b) 超过挂起期限：超过挂起期限承诺办结剩余天数逐天递减
         2) 解挂后
         a) 挂起期限内：  承诺应办结日期 按按实际发生挂起天数（即 挂起天数=解挂日期-挂起日期 ）延长时间，剩余天数=发起挂起操作当天的承诺办结剩余天数
         b) 挂起期限外： 超过挂起期限：
         i)  承诺应办结日期 按 挂起期限延长时间
         ii) 超过挂起期限承诺办结剩余天数逐天递减
         3. 注：B类特别程序的 期限为0的算A类特别程序（无期限）
         4. 备注：B类特别程序、补齐补正的 期限为0 的情况主要是外部业务系统交换回数据管理平台时产生的数据
         5、网办审批系统中增加特别程序、补齐补正挂起时的倒计时功能，包括部门申请的挂起天数（静态）、剩余天数（动态倒计时），一则方便部门查看，二则从系统角度对部门的挂起剩余天数做出提醒。
         即针对特别程序、补齐补正，网办审批系统应存在两个倒计时，一是针对承诺办结剩余天数的，二是针对挂起剩余天数的。
         6、计算B类特别程序时限时注意工作日与自然日的区别。
         **/

        // 获取当前工单相关预警配置信息
        List<ApplyOrderAlertBean> alertBeanList = sbInfoUpdateMapper.getOrderAlertInfo(hjslbs);
        // 查询不到时不做处理
        if (alertBeanList == null || alertBeanList.size() == 0) {
            return null;
        }
        ApplyOrderAlertBean alertBean = alertBeanList.get(0);
        // 如果个性预警配置为空，取参数默认配置
        if (alertBean.getAlertRed() == null) {
            alertBean.setAlertRed(75);// 红色预警默认为75%
        }
        if (alertBean.getAlertYellow() == null) {
            alertBean.setAlertYellow(50);// 黄色预警默认为50%
        }
        if (alertBean.getPromisedPeriod() == null) {
            alertBean.setPromisedPeriod(1);
        }
        if (alertBean.getAlertDay() == null) {
            alertBean.setAlertDay(1);//提前预警天数默认为1
        }
        /* 如果没有受理时间，表示还没受理或拒绝受理，不需要更新预警监控 */
        if (alertBean.getSlsj() == null) {
            return null;
        }
        /* 如果工单已经结束，或者在领证环节，取消预警监控，剩余天数保留在办结时的剩余天数，预警状态置为正常 ,承诺办结时间为空的工单，只计算承诺办结时间*/
        if (("finishActivity".equals(alertBean.getActivitydefid()) || "LICENSE".equals(alertBean.getActivitydefid())) && alertBean.getRealPromiseDay() != null && null != alertBean.getPromiseBjDate()) {
            alertBean.setAlertFlag(CommConstants.ALERT_STATE.NORMAL);
            return alertBean;
        }
        boolean isBjnull = false;
        /* 如果工单已经结束，或者在领证环节，承诺办结时间为空 取消预警监控，剩余天数保留在办结时的剩余天数，预警状态置为正常 */
        if (("finishActivity".equals(alertBean.getActivitydefid()) || "LICENSE".equals(alertBean.getActivitydefid())) && null == alertBean.getPromiseBjDate()) {
            isBjnull = true;
        }
        CommonResultBean resultBean = new CommonResultBean();
        /*
         * 计算已经过去的时间start
         * 返回的天数以承诺时间的单位一致 （如承诺时间为5工作日，返回为已经过X工作日） （如承诺时间为5自然日，返回为已经过X自然日）
         * 按受理之后第二天开始算剩余天数
         */
        int passDays = 0;
        String slrq = DateUtils.formatDate(alertBean.getSlsj(), "yyyyMMdd");
        String dqrq = DateUtils.formatDate(new Date(), "yyyyMMdd");
        if (Long.valueOf(slrq) < Long.valueOf(dqrq)) {
            passDays = calPassedDays(alertBean.getPromisedPeriodType(), alertBean.getSlsj(), new Date());
        }
        /*计算已经过去的时间end*/
        int specProgramDays = 0;
        int realPromiseDay = 0;
        /* 已经过去的时间-补正挂起时间  start*/
        int suppDays = 0;
        String startDateStart = DateUtil.convertDateToString(alertBean.getSlsj(), DateUtil.pattern19);
         List<SpecProgramExtBean> suppBeanList = sbInfoUpdateMapper.getSuppInfo(alertBean.getSblsh(),startDateStart);
        // 补齐补正的时间加入实际承诺日期
        if (suppBeanList != null && suppBeanList.size() > 0) {
            suppDays = this.getSuppPeriod(alertBean.getPromisedPeriodType(), suppBeanList, resultBean);
        }
		/*realPromiseDay = alertBean.getPromisedPeriod() +suppDays;
		alertBean.setRealPromiseDay(realPromiseDay);
		setPromiseBjDate(alertBean);*/
        realPromiseDay = alertBean.getPromisedPeriod() + suppDays;

        if (alertBean.getPromiseBjDate() == null || alertBean.getRealPromiseDay() == null || realPromiseDay != alertBean.getRealPromiseDay()) {
            alertBean.setRealPromiseDay(realPromiseDay);
            setPromiseBjDate(alertBean);
        }

        passDays -= suppDays;
        /* 已经过去的时间-补正挂起时间  end*/
        /* 已经过去的时间-特别程序时间 start */
        List<SpecProgramExtBean> specBeanList =  sbInfoUpdateMapper.getSpecProgramInfo(alertBean.getSblsh());

        if (specBeanList != null && specBeanList.size() > 0) {
            specProgramDays = this.getSpecProgramPeriod(alertBean.getSblsh(), alertBean.getPromisedPeriodType(), specBeanList, resultBean);

        }
        // 特别程序延长的时间加入实际承诺日期
        realPromiseDay = alertBean.getRealPromiseDay() + specProgramDays;

	  /*  alertBean.setRealPromiseDay(realPromiseDay);
	    setPromiseBjDate(alertBean);*/
        if (alertBean.getPromiseBjDate() == null || alertBean.getRealPromiseDay() == null || realPromiseDay != alertBean.getRealPromiseDay()) {
            alertBean.setRealPromiseDay(realPromiseDay);
            setPromiseBjDate(alertBean);
        }

        passDays -= specProgramDays;
        /* 已经过去的时间-特别程序时间 end */


        //NumberFormat numberFormat = NumberFormat.getInstance();
        //numberFormat.setMaximumFractionDigits(2);
        int promiseDay = alertBean.getPromisedPeriod();
        int restDay = alertBean.getPromisedPeriod() - passDays;
        if (!"finishActivity".equals(alertBean.getActivitydefid()) && promiseDay == 1) {
            // 如果承诺天数等于1天直接为红色预警
            if (passDays > alertBean.getPromisedPeriod()) {
                // 超期预警
                alertBean.setAlertFlag(CommConstants.ALERT_STATE.DELAY);
            } else {
                alertBean.setAlertFlag(CommConstants.ALERT_STATE.WARNING_YELLOW);
            }
        } else {
            /**老的预警规则，2014-10-14后改为三种预警状态
             //		Double alertYellow = Double.parseDouble(numberFormat.format((float) alertBean.getAlertYellow() / (float) 100));
             //		Double alertRed = Double.parseDouble(numberFormat.format((float) alertBean.getAlertRed() / (float) 100));
             //			if (passDays >= (promiseDay * alertYellow) && passDays < (promiseDay * alertRed)) {
             //				// 大于等于黄色预警，小于红色预警 (过半预警)
             //				alertBean.setAlertFlag(CommConstants.ALERT_STATE.WARNING_YELLOW);
             //			} else if (passDays >= (promiseDay * alertRed) && passDays <= promiseDay) {
             //				// 大于等于红色预警，小于等于承诺天数（到期预警）
             //				alertBean.setAlertFlag(CommConstants.ALERT_STATE.WARNING_RED);
             //			} else if (passDays >= promiseDay) {
             //				// 超期预警（超时）
             //				alertBean.setAlertFlag(CommConstants.ALERT_STATE.DELAY);
             //			} else {
             //				alertBean.setAlertFlag(CommConstants.ALERT_STATE.NORMAL);
             //			}*/
            //<=预警天数
            if (restDay <= alertBean.getAlertDay() && restDay >= 0) {
                // 小于等于提前预警天数，大于等于0，开始预警
                alertBean.setAlertFlag(CommConstants.ALERT_STATE.WARNING_YELLOW);
            } else if (restDay < 0) {
                // 超期预警（超时）
                alertBean.setAlertFlag(CommConstants.ALERT_STATE.DELAY);
            } else {
                alertBean.setAlertFlag(CommConstants.ALERT_STATE.NORMAL);
            }

        }
        // 剩余天数更新，承诺天数－已经过去的天数
        alertBean.setDelayDay(alertBean.getPromisedPeriod() - passDays);
        // 如果工单已经结束，或者在领证环节，承诺办结时间为空 取消预警监控，剩余天数保留在办结时的剩余天数，预警状态置为正常
        if (isBjnull) {
            alertBean.setAlertFlag(CommConstants.ALERT_STATE.NORMAL);
            alertBean.setAlertDay(null);
            alertBean.setDelayDay(null);
        }
        holidayList.clear();
        //更新子程序告警状态,子程序有期限时
        if ((resultBean.isBjFlag() || resultBean.isTbFlag()) && resultBean.getZcxsx() != 0) {
            alertBean.setAlertType(resultBean.getAlertType());
            alertBean.setRestDay(resultBean.getRestDay());
            alertBean.setZcxsx(resultBean.getZcxsx());
            if (resultBean.getRestDay() <= 0) {//主程序剩余时间解挂

            } else {
                alertBean.setDelayDay(null);//在子程序期限内，主程序剩余时间不变
                alertBean.setAlertFlag(null);//主程序的告警状态不变
            }
            //控制主程序剩余时间计算
        } else if ((resultBean.isBjFlag() || resultBean.isTbFlag()) && resultBean.getZcxsx() == 0) {
            //主程序承诺办结时间设置为null,剩余天数不变
            alertBean.setPromiseBjDate(null);
            alertBean.setDelayDay(null);//无限期的挂起，主程序剩余时间不变
            alertBean.setAlertFlag(null);//主程序的告警状态不变
        } else if (!resultBean.isBjFlag() && !resultBean.isTbFlag()) {//解挂，子程序清空
            alertBean.setAlertType(null);
            alertBean.setRestDay(null);
            alertBean.setZcxsx(null);
        }
        return alertBean;
    }

    /**
     * 计算补正补齐需要撇除的日期
     * 返回单位以事项的承诺期限为准
     * @return
     * @param promiseType
     * @param specBeanList
     * @param bean
     */
    private int getSuppPeriod(String promiseType, List<SpecProgramExtBean> specBeanList,CommonResultBean bean) {
        int datesDelay = 0;
        try {
            for (SpecProgramExtBean specBean : specBeanList) {
                int bzsx = null==specBean.getPeriodDay()?0:specBean.getPeriodDay();
                Date bjgzsj = specBean.getStartDate();
                Date bjslsj = specBean.getEndDate();
                // 无期限：A类特别程序（无期限）、补齐补正（不论有无期限），挂起后，提示特别程序挂起，剩余天数冻结不再计算，
                //解挂后按实际挂起天数（即 挂起天数=解挂日期-挂起日期 ）延长 承诺应办结日期
                if (null != bjslsj) {//有结果
                    int tbday=calPassedDays(promiseType,specBean.getStartDate(), bjslsj);
                    tbday=tbday==0?1:tbday;//tbday为0，算一天
                    datesDelay +=tbday;
                }else{//没结果，审批系统单位都默认为工作日  有期限也当无期限
                    if(bzsx!=0){//有期限
                        //int bzsx = Integer.parseInt(BZSX);
                        if("2".equals(promiseType)){//事项单位为工作日，子程序为自然日
                            bzsx=bzsx==0?1:bzsx;//tbday为0，算一天
                            datesDelay +=bzsx;
                        }else if("3".equals(promiseType)){//事项单位为自然日，子程序为工作日
                            //转换成自然日
                            Date endDate = callEndDays("2", bjgzsj, bzsx);
                            int tbday = DateUtils.getDayBetween(bjgzsj,endDate);
                            tbday=tbday==0?1:tbday;//tbday为0，算一天
                            datesDelay +=tbday;
                        }
                        //挂起后子程序的剩余时间要算
                        bean.setTbFlag(true);//特别程序挂起
                        bean.setZcxsx(bzsx);//有期限也当无期限
                        //剩余时间 = 期限- 挂起日期到今天用的工作日（期限都是工作日）
                        int passDays = calPassedDays("2", specBean.getStartDate(), new Date());
                        int restDay = bzsx- passDays;
                        bean.setRestDay(restDay);
                        //告警状态 剩余时间和告警提前天数的比较
                        //默认提前2天预警
                        int alertDay = 2;
                        if(restDay>alertDay){
                            bean.setAlertType(CommConstants.ALERT_STATE.NORMAL);
                        }else if(alertDay>=restDay && restDay>=0){
                            bean.setAlertType(CommConstants.ALERT_STATE.WARNING_YELLOW);
                        }else if(restDay<0){
                            bean.setAlertType(CommConstants.ALERT_STATE.DELAY);
                        }
                    }else{//无限期
                        //如果 特别程序申请没有特别申请结果，且该工单的特别程序时限为无期限，则不计算该工单的承诺办结时间（工单的承诺办结时间字段值设置为空）
                        //return -1;
                        bean.setTbFlag(true);//特别程序挂起
                        bean.setZcxsx(0);//无期限
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            WbtimerJobLogger.log(e);
        }
        return datesDelay;
    }
    /**
     * 计算到当天为止，已经过去的时间
     * 返回的天数以承诺时间的单位一致
     * （如承诺时间为5工作日，返回为已经过X工作日）
     * （如承诺时间为5自然日，返回为已经过X自然日）
     *
     * @param dayType
     * @param startDate
     * @param endDate
     * @return
     */
    public int calPassedDays(String dayType, Date startDate, Date endDate) {
        int passDays = 0;
        if (endDate == null)
            endDate = new Date();
        try {
            startDate = DateUtils.parseDate(DateUtils.formatDate(startDate, "yyyy-MM-dd"));
            endDate = DateUtils.parseDate(DateUtils.formatDate(endDate, "yyyy-MM-dd"));
            passDays = DateUtils.getDayBetween(startDate, endDate);
            /* 承诺天数为自然日，直接返回相差天数 */
            if ("3".equals(dayType) || CommConstants.PROCESSDAY_TYPE.WORKING_DAY.equals(dayType)) {
                return passDays;
            } else if ("0".equals(dayType)) {
                return 0;
            } else {
                /* 承诺天数为工作日，计算受理时间到当前时间经过的工作日天数 */
                int num = 0;
                Calendar d1 = Calendar.getInstance();
                d1.setTime(startDate);
                Calendar d2 = Calendar.getInstance();
                d2.setTime(endDate);
                boolean isSatSun = false;
                while (d1.before(d2)) {
                    handleDay(d1,num,isSatSun);
                }
                return num;
                }
        } catch (ParseException e) {
            e.printStackTrace();
            WbtimerJobLogger.log(e);
        }

        return passDays;
    }

    private void callIntfHolidayList() {
        if (holidayList.size() == 0) {
            holidayList = sbInfoUpdateMapper.selectZCSPHoliday();
        }
    }
    /**
     * 根据日期类型，计算从 startDate开始，经过days之后的日期
      * @param startDate
     *  @param days
     *  @return
     */
    public Date callEndDays(String dayType,Date startDate, int days) {
        int num = 0;
        Calendar d1 = Calendar.getInstance();
        d1.setTime(startDate);
        try {
            boolean isSatSun = false;
            while (num < days) {
               num=handleDay(d1,num,isSatSun);
            }
        }catch(Exception e){
                 e.printStackTrace();
                WbtimerJobLogger.log(e);
                return null;
            }
       return d1.getTime();
    }
    private int handleDay(Calendar d1,int num,boolean isSatSun) throws ParseException{
        d1.add(Calendar.DAY_OF_MONTH, 1);
        if (Calendar.SATURDAY != d1.get(Calendar.DAY_OF_WEEK) && Calendar.SUNDAY != d1.get(Calendar.DAY_OF_WEEK)) {
            // 工作日，加1
            num++;
            isSatSun = false;
        } else {
            isSatSun = true;
        }
        String d1Str = DateUtils.formatDate(d1.getTime(), "yyyy-MM-dd");
        callIntfHolidayList();
        if (holidayList != null && holidayList.size() > 0) {
            for (Map<String, Object> holidayBean : holidayList) {
                String sStr = DateUtils.formatDate((Date) holidayBean.get("START_DATE"), "yyyy-MM-dd");
                String dStr = DateUtils.formatDate((Date) holidayBean.get("END_DATE"), "yyyy-MM-dd");
                // 如果是周末调为上班,加1天
                if (StringUtils.equals(CommConstants.HOLIDAY_TYPE.WORKDAY, (String) holidayBean.get("HOLIDAY_TYPE"))
                        && DateUtil.compareDate(sStr, d1Str, DateUtil.pattern10) <= 0
                        && DateUtil.compareDate(dStr, d1Str, DateUtil.pattern10) >= 0) {
                    num++;
                    break;
                } else if (StringUtils.equals(CommConstants.HOLIDAY_TYPE.HOLIDAY, (String) holidayBean.get("HOLIDAY_TYPE"))
                        && DateUtil.compareDate(sStr, d1Str, DateUtil.pattern10) <= 0
                        && DateUtil.compareDate(dStr, d1Str, DateUtil.pattern10) >= 0) {
                    // 如果是工作日调休
                    if (!isSatSun) {
                        num--;
                    }
                    break;
                }
            }
        }
        return num;
    }
    private  void setPromiseBjDate(ApplyOrderAlertBean alertBean){
        Date promiseBjDate0 = null;
        if("3".equals(alertBean.getPromisedPeriodType())||"1".equals(alertBean.getPromisedPeriodType())){
            promiseBjDate0 = DateUtils.addDate(alertBean.getSlsj(), alertBean.getRealPromiseDay());
        }
        if("2".equals(alertBean.getPromisedPeriodType())){
            promiseBjDate0 = callEndDays(alertBean.getPromisedPeriodType(), alertBean.getSlsj(), alertBean.getRealPromiseDay());
        }
        alertBean.setPromiseBjDate(promiseBjDate0);
    }
    /**
     * 计算特别程序需要撇除的日期
     * 返回单位以事项的承诺期限为准
     * @param sblsh
     * @return
     */
    private int getSpecProgramPeriod(String sblsh,String promiseType,List<SpecProgramExtBean> specBeanList,CommonResultBean bean) {
        int datesDelay = 0;
        //boolean flag = false;//默认为解挂
        try {
            for (SpecProgramExtBean specBean : specBeanList) {
                String tbcxzl=specBean.getTbcxzl();
                String spjg=specBean.getSpjg();
                String spjga0=specBean.getSpjga0();
                Long tbcxsx= null == specBean.getTbcxsx()?0:specBean.getTbcxsx();
                Date Jgcsrq = specBean.getJgcsrq();
                //如果是无期限A类的，审批不通过的，不处理
                if("A".equals(tbcxzl) && tbcxsx==0 &&  !"1".equals(spjga0)){
                    continue;
                }
                //有结果
                if(null != Jgcsrq){//有结果产生时间
                    //flag=false;if(tbcxsx==0 && "A".equals(tbcxzl)){//没期限，有结果
                    if(tbcxsx==0 && ("A".equals(tbcxzl)||"B".equals(tbcxzl))){//没期限，有结果
                        int tbday=calPassedDays(promiseType,specBean.getStartDate(), specBean.getJgcsrq());
                        tbday=tbday==0?1:tbday;//tbday为0，算一天
                        datesDelay +=tbday;
                    }else{//有期限的AB，有结果,只有工作日
                        int tbday=calPassedDays(promiseType,specBean.getStartDate(), specBean.getJgcsrq());

                        if("2".equals(promiseType)){//工作日
                            if(tbday >=tbcxsx){
                                datesDelay +=tbcxsx;
                            }else{
                                tbday=tbday==0?1:tbday;
                                datesDelay +=tbday;
                            }
                        }else if("3".equals(promiseType)){//自然日 （工作日--》自然日）
                            //结果时间在区间内的。取结果时间，
                            Date endDate = callEndDays("2", specBean.getStartDate(), tbcxsx.intValue());
                            //zy
                            int tbday2 = DateUtils.getDayBetween(specBean.getStartDate(),endDate);
                            if(tbday >=tbday2){
                                datesDelay +=tbday2;//超出子程序承诺办结区间取子程序承诺办结区间
                            }else{
                                tbday=tbday==0?1:tbday;
                                datesDelay +=tbday;
                            }

                        }else{
                            datesDelay =0;
                        }

                    }
                }else{
                    //flag=true;
                    //如果 特别程序申请 没有对应的 特别程序结果（可能是特别程序未结束或数据错误）
                    //并且该申请 工单的特别程序时限不为无期限
                    //特别程序时间 += 特别程序申请.特别程序时限
                    //如果 特别程序申请没有特别申请结果，且该工单的特别程序时限为无期限，则不计算该工单的承诺办结时间（工单的承诺办结时间字段值设置为空）
                    if(tbcxsx!=0){//有期限
                        if("2".equals(promiseType)){//事项单位为工作日，子程序为自然日
                            tbcxsx=tbcxsx==0?1:tbcxsx;//tbday为0，算一天
                            datesDelay +=tbcxsx;
                        }else if("3".equals(promiseType)){//事项单位为自然日，子程序为工作日
                            //转换成自然日
                            Date endDate = callEndDays("2", specBean.getStartDate(), tbcxsx.intValue());
                            int tbday = DateUtils.getDayBetween(specBean.getStartDate(),endDate);
                            tbday=tbday==0?1:tbday;//tbday为0，算一天
                            datesDelay +=tbday;
                        }
                        //挂起后子程序的剩余时间要算
                        bean.setTbFlag(true);//特别程序挂起
                        bean.setZcxsx(tbcxsx.intValue());//期限
                        //剩余时间 = 期限- 挂起日期到今天用的工作日（期限都是工作日）
                        // Date d = addDate(new Date(),13);
                        int passDays = calPassedDays("2", specBean.getStartDate(),new Date() );
                        int restDay = tbcxsx.intValue()- passDays;
                        bean.setRestDay(restDay);
                        //告警状态 剩余时间和告警提前天数的比较
                        //默认提前2天预警
                        int alertDay = 2;
                        //CommConstants.ALERT_STATE
                        if(restDay>alertDay){
                            bean.setAlertType(CommConstants.ALERT_STATE.NORMAL);
                        }else if(alertDay>=restDay && restDay>=0){
                            bean.setAlertType(CommConstants.ALERT_STATE.WARNING_YELLOW);
                        }else if(restDay<0){
                            bean.setAlertType(CommConstants.ALERT_STATE.DELAY);
                        }

                    }else{//无限期
                        //如果 特别程序申请没有特别申请结果，且该工单的特别程序时限为无期限，则不计算该工单的承诺办结时间（工单的承诺办结时间字段值设置为空）
                        //return -1;
                        bean.setTbFlag(true);//特别程序挂起
                        bean.setZcxsx(tbcxsx.intValue());//期限
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            WbtimerJobLogger.log(e);
        }
        return datesDelay;
    }
}
