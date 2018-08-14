package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.common.utils.StringUtil;
import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.mapper.*;
import com.eshore.wbtimer.executor.mapper.bean.*;
import com.eshore.wbtimer.executor.service.ProcessSlFailToSpService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author Zhangqian
 * @create 2018/1/26 16:18
 */
@Service
public class ProcessSlFailToSpServiceImpl implements ProcessSlFailToSpService {

    private static class processSlState{
        private static final String SLFAIL = "2";	//受理不通过
        private static final String SLNOT = "3";	//不予受理
        private static final String SLBACK = "11";	//退回办结
    }

    private static class processWSYSlState{
        private static final String WSYSLFAIL = "2";	//预受理不通过
        private static final String WSYSLBACK = "11";	//预受理退回办结
    }
    @Autowired
    WsbsSlBeanMapper wsbsSlBeanMapper;
    @Autowired
    WsbsSpclBeanMapper wsbsSpclBeanMapper;
    @Autowired
    WsbsWsyslBeanMapper wsbsWsyslBeanMapper;
    @Autowired
    WsbsTbcxspBeanMapper wsbsTbcxspBeanMapper;
    @Autowired
    WsbsSbBeanMapper wsbsSbBeanMapper;
    @Autowired
    WsbsTbcxjgBeanMapper wsbsTbcxjgBeanMapper;
    @Autowired
    WsbsTbcxsqBeanMapper wsbsTbcxsqBeanMapper;

    @Override
    public void startProcessSlFailToSp() throws Exception {
        WbtimerJobLogger.log("自动过某环节时补齐必要的环节数据 开始 ....");
        /**受理**/
        //受理不通过，补审批环节数据
        processService("SLFAIL");
        //不予受理，补审批环节数据
        processService("SLNOT");
        //退回办结，补审批环节数据
        processService("SLBACK");


        /**预受理**/
        //预受理不通过，补审批环节数据
        processService("WSYSLFAIL");
        //预受理退回办结，补审批环节数据
        processService("WSYSLBACK");

        /**特别程序**/
        //A类无期限审批不通过，补特别程序结果数据
        processService("SPECIAL_A0_N");
        System.out.println("process成功");
        WbtimerJobLogger.log("自动过某环节时补齐必要的环节数据 结束 ....");
    }

    public void processService(String processStep) {
        try {
            if(processStep.equals( "SLFAIL")){
                //受理不通过补审批环节数据
                WsbsSlBean param = new WsbsSlBean();
                param.setCljgdm( processSlState.SLFAIL);
                param.setAutostate("0");
                List<WsbsSlBean> result = wsbsSlBeanMapper.selectFromSelective(param);
                if(CollectionUtils.isNotEmpty(result)){
                    int count = 0;
                    for(Object object:result){
                        WsbsSlBean wsbsSlBean = (WsbsSlBean)object;

                        WsbsSpclBean spParam = new WsbsSpclBean();
                        spParam.setSblsh(wsbsSlBean.getSblsh());
                        spParam.setSxbm(wsbsSlBean.getSxbm());
                        List<WsbsSpclBean> check = wsbsSpclBeanMapper.selectBySblsh(spParam);
                        if( CollectionUtils.isEmpty(check)){
                            WsbsSpclBean bean = new WsbsSpclBean();
                            bean.setSblsh(wsbsSlBean.getSblsh());
                            bean.setSxbm(wsbsSlBean.getSxbm());
                            bean.setSphjmc("批准");
                            bean.setSpbzh( "1");
                            bean.setBmmc(wsbsSlBean.getBmmc());
                            bean.setSprxm(wsbsSlBean.getClrxm());
                            bean.setStaffId(wsbsSlBean.getClrgh());
                            bean.setSphjdm("3"); //审批环节代码
                            bean.setCljgdm( "2"); //审批环节状态代码
                            bean.setCljgms( ""); //审批意见
                            bean.setSprzwdm(""); //审批人职务代码
                            bean.setSprzwmc( "");//审批人职务名称
                            bean.setZzjgdm( wsbsSlBean.getZzjgdm());//审批部门组织结构代码
                            bean.setXzqhdm( wsbsSlBean.getXzqhdm());
                            bean.setBz( "受理不通过办结,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsSlBean.getProcessinstid());
                            bean.setClrgh( wsbsSlBean.getClrgh());
                            bean.setClrxm(wsbsSlBean.getClrxm());
                            bean.setHjslbs(wsbsSlBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsSlBean.getCreateTime());
                            c.add(Calendar.SECOND, 10);
                            bean.setCreateTime(c.getTime());

                            wsbsSpclBeanMapper.insert(bean);
                            System.out.println("slfail插入");
                        }else{
                            count++;
                        }
                        WsbsSlBean ssl=new WsbsSlBean();
                        ssl.setHjslbs(wsbsSlBean.getHjslbs());
                        ssl.setAutostate("1");
                        ssl.setAutotime(new Date());
                        wsbsSlBeanMapper.updateByPrimaryKeySelective(ssl);
                    }
                }
            }else if(processStep.equals( "SLNOT")){
                //不予受理补审批环节数据
                WsbsSlBean param = new WsbsSlBean();
                param.setCljgdm( processSlState.SLNOT);
                param.setAutostate("0");
                List<WsbsSlBean> result = wsbsSlBeanMapper.selectFromSelective(param);
                if(CollectionUtils.isNotEmpty(result)){
                    int count = 0;
                    for(Object object:result){
                        WsbsSlBean wsbsSlBean = (WsbsSlBean)object;

                        WsbsSpclBean spParam = new WsbsSpclBean();
                        spParam.setSblsh(wsbsSlBean.getSblsh());
                        spParam.setSxbm(wsbsSlBean.getSxbm());
                        List<WsbsSpclBean> check = wsbsSpclBeanMapper.selectBySblsh(spParam);
                        if( CollectionUtils.isNotEmpty(check)){
                            WsbsSpclBean bean = new WsbsSpclBean();
                            bean.setSblsh(wsbsSlBean.getSblsh());
                            bean.setSxbm(wsbsSlBean.getSxbm());
                            bean.setSphjmc("批准");
                            bean.setSpbzh( "1");
                            bean.setBmmc(wsbsSlBean.getBmmc());
                            bean.setSprxm(wsbsSlBean.getClrxm());
                            bean.setStaffId(wsbsSlBean.getClrgh());
                            bean.setSphjdm("3"); //审批环节代码
                            bean.setCljgdm("2"); //审批环节状态代码
                            bean.setCljgms(""); //审批意见
                            bean.setSprzwdm(""); //审批人职务代码
                            bean.setSprzwmc("");//审批人职务名称
                            bean.setZzjgdm( wsbsSlBean.getZzjgdm());//审批部门组织结构代码
                            bean.setXzqhdm( wsbsSlBean.getXzqhdm());
                            bean.setBz( "不予受理办结,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsSlBean.getProcessinstid());
                            bean.setClrgh( wsbsSlBean.getClrgh());
                            bean.setClrxm(wsbsSlBean.getClrxm());
                            bean.setHjslbs(wsbsSlBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsSlBean.getCreateTime());
                            c.add(Calendar.SECOND, 10);
                            bean.setCreateTime(c.getTime());

                            wsbsSpclBeanMapper.insert(bean);
                            System.out.println("slnot插入");
                        }else{
                            count++;
                        }
                        WsbsSlBean ssl=new WsbsSlBean();
                        ssl.setHjslbs(wsbsSlBean.getHjslbs());
                        ssl.setAutostate("1");
                        ssl.setAutotime(new Date());
                        wsbsSlBeanMapper.updateByPrimaryKeySelective(ssl);
                    }
                }
            }else if(processStep.equals( "SLBACK")){
                //退回办结补审批环节数据
                WsbsSlBean param = new WsbsSlBean();
                param.setCljgdm( processSlState.SLBACK);
                param.setAutostate("0");
                List<WsbsSlBean> result = wsbsSlBeanMapper.selectFromSelective(param);
                if(CollectionUtils.isNotEmpty(result)){
                    int count = 0;
                    for(Object object:result){
                        WsbsSlBean wsbsSlBean = (WsbsSlBean)object;

                        WsbsSpclBean spParam = new WsbsSpclBean();
                        spParam.setSblsh(wsbsSlBean.getSblsh());
                        spParam.setSxbm(wsbsSlBean.getSxbm());
                        List<WsbsSpclBean> check = wsbsSpclBeanMapper.selectBySblsh(spParam);
                        if(CollectionUtils.isNotEmpty(check)){
                            WsbsSpclBean bean = new WsbsSpclBean();
                            bean.setSblsh(wsbsSlBean.getSblsh());
                            bean.setSxbm(wsbsSlBean.getSxbm());
                            bean.setSphjmc("批准");
                            bean.setSpbzh( "1");
                            bean.setBmmc(wsbsSlBean.getBmmc());
                            bean.setSprxm(wsbsSlBean.getClrxm());
                            bean.setStaffId(wsbsSlBean.getClrgh());
                            bean.setSphjdm("3"); //审批环节代码
                            bean.setCljgdm( "2"); //审批环节状态代码
                            bean.setCljgms( ""); //审批意见
                            bean.setSprzwdm(""); //审批人职务代码
                            bean.setSprzwmc( "");//审批人职务名称
                            bean.setZzjgdm( wsbsSlBean.getZzjgdm());//审批部门组织结构代码
                            bean.setXzqhdm( wsbsSlBean.getXzqhdm());
                            bean.setBz( "退回办结,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsSlBean.getProcessinstid());
                            bean.setClrgh( wsbsSlBean.getClrgh());
                            bean.setClrxm(wsbsSlBean.getClrxm());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsSlBean.getCreateTime());
                            c.add(Calendar.SECOND, 10);
                            bean.setCreateTime(c.getTime());

                            wsbsSpclBeanMapper.insert(bean);
                            System.out.println("slblack插入");
                        }else{
                            count++;
                        }
                        WsbsSlBean ssl=new WsbsSlBean();
                        ssl.setHjslbs(wsbsSlBean.getHjslbs());
                        ssl.setAutostate("1");
                        ssl.setAutotime(new Date());
                        wsbsSlBeanMapper.updateByPrimaryKeySelective(ssl);
                    }
                }
            }else if(processStep.equals( "WSYSLFAIL")){
                //预受理不通过 补受理和审批环节数据
                WsbsWsyslBean param = new WsbsWsyslBean();
                param.setCljgdm( processWSYSlState.WSYSLFAIL);
                param.setAutostate("0");
                List<WsbsWsyslBean> result = wsbsWsyslBeanMapper.selectByState(param);
                if(CollectionUtils.isNotEmpty(result)){
                    int count = 0;
                    for(Object object:result){
                        WsbsWsyslBean wsbsWsyslBean = (WsbsWsyslBean)object;
                        //补受理数据
                        WsbsSlBean paramSl = new WsbsSlBean();
                        paramSl.setSblsh( wsbsWsyslBean.getSblsh());
                        paramSl.setSxbm(wsbsWsyslBean.getSxbm());
                        List<WsbsSlBean> sl = wsbsSlBeanMapper.selectFromSelective(paramSl);
                        if( CollectionUtils.isNotEmpty(sl)){
                            WsbsSlBean bean = new WsbsSlBean();
                            bean.setSblsh(wsbsWsyslBean.getSblsh());
                            bean.setSxbm(wsbsWsyslBean.getSxbm());
                            bean.setBmmc(wsbsWsyslBean.getBmmc());
                            bean.setBlrxm(wsbsWsyslBean.getClrxm());
                            bean.setBlrgh(wsbsWsyslBean.getClrgh());
                            bean.setCljgdm( "2"); //环节状态代码
                            bean.setCljgms( ""); //意见
                            bean.setZzjgdm( wsbsWsyslBean.getZzjgdm());//部门组织结构代码
                            bean.setXzqhdm( wsbsWsyslBean.getXzqhdm());
                            bean.setBz( "预受理不通过,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsWsyslBean.getProcessinstid());
                            bean.setClrgh( wsbsWsyslBean.getClrgh());
                            bean.setClrxm(wsbsWsyslBean.getClrxm());
                            bean.setHjslbs(wsbsWsyslBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsWsyslBean.getCreateTime());
                            c.add(Calendar.SECOND, 10);
                            bean.setCreateTime(c.getTime());

                            wsbsSlBeanMapper.insert(bean);
                            System.out.println("wysyfial插入");
                        }


                        //补审批数据
                        WsbsSpclBean spParam = new WsbsSpclBean();
                        spParam.setSblsh(wsbsWsyslBean.getSblsh());
                        spParam.setSxbm(wsbsWsyslBean.getSxbm());
                        List<WsbsSpclBean> check = wsbsSpclBeanMapper.selectBySblsh(spParam);
                        if(CollectionUtils.isNotEmpty(check)){
                            WsbsSpclBean bean = new WsbsSpclBean();
                            bean.setSblsh(wsbsWsyslBean.getSblsh());
                            bean.setSxbm(wsbsWsyslBean.getSxbm());
                            bean.setSphjmc("批准");
                            bean.setSpbzh( "1");
                            bean.setBmmc(wsbsWsyslBean.getBmmc());
                            bean.setSprxm(wsbsWsyslBean.getClrxm());
                            bean.setStaffId(wsbsWsyslBean.getClrgh());
                            bean.setSphjdm("3"); //审批环节代码
                            bean.setCljgdm( "2"); //审批环节状态代码
                            bean.setCljgms( ""); //审批意见
                            bean.setSprzwdm(""); //审批人职务代码
                            bean.setSprzwmc( "");//审批人职务名称
                            bean.setZzjgdm( wsbsWsyslBean.getZzjgdm());//审批部门组织结构代码
                            bean.setXzqhdm( wsbsWsyslBean.getXzqhdm());
                            bean.setBz( "预受理不通过办结,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsWsyslBean.getProcessinstid());
                            bean.setClrgh( wsbsWsyslBean.getClrgh());
                            bean.setClrxm(wsbsWsyslBean.getClrxm());
                            bean.setHjslbs(wsbsWsyslBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsWsyslBean.getCreateTime());
                            c.add(Calendar.SECOND, 20);
                            bean.setCreateTime(c.getTime());

                            wsbsSpclBeanMapper.insert(bean);
                            System.out.println("插入");
                        }else{
                            count++;
                        }
                        WsbsWsyslBean ssl=new WsbsWsyslBean();
                        ssl.setHjslbs(wsbsWsyslBean.getHjslbs());
                        ssl.setAutostate("1");
                        ssl.setAutotime(new Date());
                        wsbsWsyslBeanMapper.updateByPrimaryKeySelective(ssl);
                    }
                }
            }else if(processStep.equals( "WSYSLBACK")){
                //预受理退回办结 补审批环节数据
                WsbsWsyslBean param = new WsbsWsyslBean();
                param.setCljgdm( processWSYSlState.WSYSLBACK);
                param.setAutostate("0");
                List<WsbsWsyslBean> result = wsbsWsyslBeanMapper.selectByState(param);
                if(CollectionUtils.isNotEmpty(result)){
                    int count = 0;
                    for(Object object:result){
                        WsbsWsyslBean wsbsWsyslBean = (WsbsWsyslBean)object;
                        //补受理数据
                        WsbsSlBean paramSl = new WsbsSlBean();
                        paramSl.setSblsh( wsbsWsyslBean.getSblsh());
                        paramSl.setSxbm(wsbsWsyslBean.getSxbm());
                        List<WsbsSlBean> sl = wsbsSlBeanMapper.selectFromSelective(paramSl);
                        if(CollectionUtils.isNotEmpty(sl)){
                            WsbsSlBean bean = new WsbsSlBean();
                            bean.setSblsh(wsbsWsyslBean.getSblsh());
                            bean.setSxbm(wsbsWsyslBean.getSxbm());
                            bean.setBmmc(wsbsWsyslBean.getBmmc());
                            bean.setBlrxm(wsbsWsyslBean.getClrxm());
                            bean.setBlrgh(wsbsWsyslBean.getClrgh());
                            bean.setCljgdm( "2"); //环节状态代码
                            bean.setCljgms( ""); //意见
                            bean.setZzjgdm( wsbsWsyslBean.getZzjgdm());//部门组织结构代码
                            bean.setXzqhdm( wsbsWsyslBean.getXzqhdm());
                            bean.setBz( "预受理不通过,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsWsyslBean.getProcessinstid());
                            bean.setClrgh( wsbsWsyslBean.getClrgh());
                            bean.setClrxm(wsbsWsyslBean.getClrxm());
                            bean.setHjslbs(wsbsWsyslBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsWsyslBean.getCreateTime());
                            c.add(Calendar.SECOND, 10);
                            bean.setCreateTime(c.getTime());

                            wsbsSlBeanMapper.insert(bean);
                            System.out.println("wsysblack插入");
                        }
                        //补审批数据
                        WsbsSpclBean spParam = new WsbsSpclBean();
                        spParam.setSblsh(wsbsWsyslBean.getSblsh());
                        spParam.setSxbm(wsbsWsyslBean.getSxbm());
                        List<WsbsSpclBean> check = wsbsSpclBeanMapper.selectBySblsh(spParam);
                        if( CollectionUtils.isNotEmpty(check)){
                            WsbsSpclBean bean = new WsbsSpclBean();
                            bean.setSblsh(wsbsWsyslBean.getSblsh());
                            bean.setSxbm(wsbsWsyslBean.getSxbm());
                            bean.setSphjmc("批准");
                            bean.setSpbzh( "1");
                            bean.setBmmc(wsbsWsyslBean.getBmmc());
                            bean.setSprxm(wsbsWsyslBean.getClrxm());
                            bean.setStaffId(wsbsWsyslBean.getClrgh());
                            bean.setSphjdm("3"); //审批环节代码
                            bean.setCljgdm( "2"); //审批环节状态代码
                            bean.setCljgms( ""); //审批意见
                            bean.setSprzwdm(""); //审批人职务代码
                            bean.setSprzwmc( "");//审批人职务名称
                            bean.setZzjgdm( wsbsWsyslBean.getZzjgdm());//审批部门组织结构代码
                            bean.setXzqhdm( wsbsWsyslBean.getXzqhdm());
                            bean.setBz( "预受理退回办结,系统自动处理");
                            bean.setDataSource("");
                            bean.setProcessinstid(wsbsWsyslBean.getProcessinstid());
                            bean.setClrgh( wsbsWsyslBean.getClrgh());
                            bean.setClrxm(wsbsWsyslBean.getClrxm());
                            bean.setHjslbs(wsbsWsyslBean.getHjslbs());

                            //门户是按处理时间对环节进行排序，自动补的数据需要在操作环节处理时间之后
                            Calendar c = Calendar.getInstance();
                            c.setTime(wsbsWsyslBean.getCreateTime());
                            c.add(Calendar.SECOND, 20);
                            bean.setCreateTime(c.getTime());

                            wsbsSpclBeanMapper.insert(bean);
                            System.out.println("插入2");
                        }else{
                            count++;
                        }
                        WsbsWsyslBean ssl=new WsbsWsyslBean();
                        ssl.setHjslbs(wsbsWsyslBean.getHjslbs());
                        ssl.setAutostate("1");
                        ssl.setAutotime(new Date());
                        wsbsWsyslBeanMapper.updateByPrimaryKeySelective(ssl);
                    }
                }
            }else if(processStep.equals("SPECIAL_A0_N")){
                //A类无期限审批不通过补特别程序结果
                WsbsTbcxspBean param = new WsbsTbcxspBean();
                param.setCljgdm("2");
                //查询没有产生结果环节数据的A类无期限特别程序审批
                List<WsbsTbcxspBean> result = wsbsTbcxspBeanMapper.selectNotPassList(param);
                for(WsbsTbcxspBean t : result){
                    //查询申办信息
                    WsbsSbBean wsbsSbBean =new WsbsSbBean();
                    wsbsSbBean.setSblsh(t.getSblsh());
                    List<WsbsSbBean> sbl=wsbsSbBeanMapper.selectBySblsh(wsbsSbBean);
                    WsbsSbBean sb= new WsbsSbBean();
                    if(CollectionUtils.isNotEmpty(sbl)){
                        sb = sbl.get(0);
                    }else{
                        continue;
                    }
                    //查询特别程序申请信息
                    WsbsTbcxsqBean wsbsTbcxsqBean =new WsbsTbcxsqBean();
                    wsbsTbcxsqBean.setSblsh(t.getSblsh());
                    wsbsTbcxsqBean.setProcessinstid(t.getProcessinstid());
                    List<WsbsTbcxsqBean> spl = wsbsTbcxsqBeanMapper.selectBySblah(wsbsTbcxsqBean);
                    WsbsTbcxsqBean sp= new WsbsTbcxsqBean();
                    if(CollectionUtils.isNotEmpty(spl)){
                        sp = spl.get(0);
                    }else{
                        continue;
                    }

                    WsbsTbcxjgBean jg =new WsbsTbcxjgBean();
                    jg.setSblsh(t.getSblsh());
                    jg.setSxbm(sb.getSxbm());
                    jg.setClrgh(t.getClrgh());
                    jg.setCljgms(t.getCljgms());
                    jg.setBz("特别程序申请不通过");
                    jg.setClrxm(t.getClrxm());
                    jg.setXh(sp.getXh());
                    jg.setXzqhdm(sb.getXzqhdm());
                    jg.setTbcxjg(StringUtil.handleNULL(t.getCljgms(), "无"));
                    jg.setCreateTime(new Date());
                    jg.setTbcxjsrq(new Date());
                    jg.setTbcxsfje("0");
                    jg.setJedwdm("CNY");
                    jg.setProcessinstid(new BigDecimal(t.getProcessinstid()));
                    jg.setHjslbs(t.getHjslbs());
                    //把结果产生时间==申请时间（在数据管理平台承诺办结时间计算时，如果时间相等，不处理）
                    jg.setJgcsrq(sp.getCreateTime());
                    wsbsTbcxjgBeanMapper.insert(jg);
                    System.out.println("SPECIAL_A0_N插入");
                }

            }



        } catch (Exception e) {
            WbtimerJobLogger.log(e);
        }
    }

}
