package com.eshore.wbtimer.executor.common.utils;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.common.code.dataplatform.bean.FieldBean;
import com.eshore.wbtimer.executor.common.code.dataplatform.bean.WsbsSbSubBean;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:36
 */
public class ReflectUtil {

    /**
     * 数据平台接口字段设置
     *
     * @param fields
     *            模版字段集合
     * @param obj
     *            数据来源
     */
    public static void setBeanFields(List<FieldBean> fields, Object obj) {
        try {
            Class<?> cls = obj.getClass();
            ///cls.getName();
            String beanName = cls.getSimpleName();	//拿到具体bean名
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                for (FieldBean fieldBean : fields) {
                    //这4个是公共的
                    if( fieldBean.getFieldName().equalsIgnoreCase("SBLSH")
                            && field.getName().equalsIgnoreCase( "sblsh")){
                        fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                    }
                    if( fieldBean.getFieldName().equalsIgnoreCase("SXBM")
                            && field.getName().equalsIgnoreCase( "sxbm")){
                        fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                    }
                    if( fieldBean.getFieldName().equalsIgnoreCase("BZ")
                            && field.getName().equalsIgnoreCase( "bz")){
                        fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                    }
                    if( fieldBean.getFieldName().equalsIgnoreCase("BYZD")
                            && field.getName().equalsIgnoreCase( "byzd")){
                        fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                    }
                    if( beanName.equals( "WsbsWsyslBean")){ //网上预受理,比较WsbsWsyslBean和sx_gdbs_wsysl.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBLSH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SXBM")
                                && field.getName().equalsIgnoreCase( "sxbm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YWLSH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YSLBMMC")
                                && field.getName().equalsIgnoreCase( "bmmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YSLBMZZJGDM")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BLRXM")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BLRGH")
                                && field.getName().equalsIgnoreCase( "clrgh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YSLZTDM")
                                && field.getName().equalsIgnoreCase( "cljgdm")){
                            String cljgdm=StringHelperUtil.handleNull(field.get(obj));
                            if("1".equals(cljgdm)){
                                cljgdm="1";
                            }else if("2".equals(cljgdm)){
                                cljgdm="2";
                            } else if("3".equals(cljgdm)){
                                cljgdm="3";
                            } else{
                                cljgdm="2";
                            }

                            fieldBean.setFieldValue(cljgdm);
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BSLYY")
                                && field.getName().equalsIgnoreCase( "cljgms")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YSLJTDD")
                                && field.getName().equalsIgnoreCase( "ysljtdd")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BZ")
                                && field.getName().equalsIgnoreCase( "bz")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YSLSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }

                    }else if(beanName.equals( "WsbsSbBean")){ //申办 比较ex_gdbs_sb.xml和WsbsSbBean
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBLSH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBHZH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBCLQD")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue("无");
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBJTWD")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue("珠海分厅");
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SXBM")
                                && field.getName().equalsIgnoreCase( "sxbm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SXMC")
                                && field.getName().equalsIgnoreCase( "sxmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SQRLX")
                                && field.getName().equalsIgnoreCase( "sqrlx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SQRMC")
                                && field.getName().equalsIgnoreCase( "sqrmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SQRZJHM")
                                && field.getName().equalsIgnoreCase( "sqrzjhm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SQRZJLX")
                                && field.getName().equalsIgnoreCase( "sqrzjlx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LXRXM")
                                && field.getName().equalsIgnoreCase( "lxrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LXRZJLX")
                                && field.getName().equalsIgnoreCase( "lxrzjlx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LXRSFZJHM")
                                && field.getName().equalsIgnoreCase( "lxrsfzjhm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LXRSJ")
                                && field.getName().equalsIgnoreCase( "lxrsj")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LXRYX")
                                && field.getName().equalsIgnoreCase( "lxryx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBXMMC")
                                && field.getName().equalsIgnoreCase( "sbxmmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
//						if( fieldBean.getFieldName().equalsIgnoreCase("SBCLQD")
//								&& field.getName().equalsIgnoreCase( "sbclqd")){
//							fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
//						}
                        if( fieldBean.getFieldName().equalsIgnoreCase("TJFS")
                                && field.getName().equalsIgnoreCase( "tjfs")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBSJ")
                                && field.getName().equalsIgnoreCase( "sbsj")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BZ")
                                && field.getName().equalsIgnoreCase( "bz")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LOGINNAME")
                                && field.getName().equalsIgnoreCase( "loginname")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBBMZZJGDM")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BMZZJDDM")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("QDFS")
                                && field.getName().equalsIgnoreCase( "qdfs")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                    }else if(beanName.equals( "WsbsSlBean")){		//受理 比较WsbsSlBean和ex_gdbs_sl.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("SBLSH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SXBM")
                                && field.getName().equalsIgnoreCase( "sxbm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("YWLSH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SLHZH")
                                && field.getName().equalsIgnoreCase( "sblsh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SLBMMC")
                                && field.getName().equalsIgnoreCase( "bmmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SLBMZZJDDM")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("GXDXZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BLRXM")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BLRGH")
                                && field.getName().equalsIgnoreCase( "clrgh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }if( fieldBean.getFieldName().equalsIgnoreCase("SLZTDM")
                                && field.getName().equalsIgnoreCase( "cljgdm")){
                            String cljgdm=StringHelperUtil.handleNull(field.get(obj));
//							受理	进入承办的待办列表；申报省厅数据的状态标示为“受理“	上报省厅数据取值为“受理“
//							不受理	自动通过办结，结束流程；系统自动产生办结数据，状态为办结。	上报省厅数据取值为“不受理”
//							不予受理	自动通过办结，结束流程；系统自动产生办结数据，状态为办结。	上报省厅数据取值为“不受理”
//							退回办结	自动通过办结，结束流程；系统自动产生一条办结数据；	上报省厅数据取值为“不受理”；
                            if("3".equals(cljgdm)||"11".equals(cljgdm)){
                                cljgdm="2";
                            }

                            fieldBean.setFieldValue(cljgdm);
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BSLYY")
                                && field.getName().equalsIgnoreCase( "cljgms")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SLSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BZ")
                                && field.getName().equalsIgnoreCase( "bz")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BYZD")
                                && field.getName().equalsIgnoreCase( "byzd")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                    }else if(beanName.equals( "WsbsSpclBean")){	//审批受理 比较WsbsSpclBean和ex_gdbs_spcl.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPHJDM")
                                && field.getName().equalsIgnoreCase( "sphjdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }

                        if( fieldBean.getFieldName().equalsIgnoreCase("SPHJMC")
                                && field.getName().equalsIgnoreCase( "sphjdm")){

                            String sphjdm=StringHelperUtil.handleNull(field.get(obj));
                            if("1".equals(sphjdm)){
                                fieldBean.setFieldValue("承办");
                            }else if("2".equals(sphjdm)){
                                fieldBean.setFieldValue("审核");
                            } else if("3".equals(sphjdm)){
                                fieldBean.setFieldValue("批准");
                            }

                        }

//						if( fieldBean.getFieldName().equalsIgnoreCase("SPHJMC")
//								&& field.getName().equalsIgnoreCase( "sphjmc")){
//							fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
//						}
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPBMMC")
                                && field.getName().equalsIgnoreCase( "bmmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPBMZZJDMD")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPRXM")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPRZWDM")
                                && field.getName().equalsIgnoreCase( "sprzwdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"无"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPRZWMC")
                                && field.getName().equalsIgnoreCase( "sprzwmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"无"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPYJ")
                                && field.getName().equalsIgnoreCase( "cljgms")){
                            //替换尖括号为小括号
                            String spyj=StringHelperUtil.handleNULL(field.get(obj),"无");
                            spyj=spyj.replace("<", "(");
                            spyj=spyj.replace(">", ")");
                            fieldBean.setFieldValue(spyj);
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SPHJZTDM")
                                && field.getName().equalsIgnoreCase( "cljgdm")){
                            String cljgdm=StringHelperUtil.handleNull(field.get(obj));
                            if("1".equals(cljgdm)){
                                cljgdm="1";
                            }else if("2".equals(cljgdm)){
                                cljgdm="2";
                            } else if("3".equals(cljgdm)){
                                cljgdm="3";
                            } else{
                                cljgdm="9";
                            }

                            fieldBean.setFieldValue(cljgdm);
                        }

                    }else if(beanName.equals( "WsbsBzgzBean")){	//补正告知 比较WsbsBzgzBean和ex_gdbs_bjgz.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJGZFCRXM")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJGZYY")
                                && field.getName().equalsIgnoreCase( "bzgzyy")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJCLQD")
                                && field.getName().equalsIgnoreCase( "bjclqd")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"无"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJGZSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XH")
                                && field.getName().equalsIgnoreCase( "xh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BZSX")
                                && field.getName().equalsIgnoreCase( "BZSX")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }

                    }else if(beanName.equals( "WsbsBzslBean")){ //补证受理 比较WsbsBzslBean和ex_gdbs_bjsl.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJSLBLRXM")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJCLQD")
                                && field.getName().equalsIgnoreCase( "bjclqd")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"无"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJSLJTDD")
                                && field.getName().equalsIgnoreCase( "bzsljtdd")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XH")
                                && field.getName().equalsIgnoreCase( "xh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }

                    }else if(beanName.equals( "WsbsTbcxsqBean")){ //特别程序申请 比较WsbsTbcxsqBean和ex_gdbs_tbcxsq.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("XH")
                                && field.getName().equalsIgnoreCase( "xh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXZL")
                                && field.getName().equalsIgnoreCase( "tbcxzl")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXZLMC")
                                && field.getName().equalsIgnoreCase( "tbcxzlmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXKSRQ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        //单位内部对该业务进入特别程序的批准（负责）人，不一定是具体经办人。
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXPZR")
                                && field.getName().equalsIgnoreCase( "clrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXQDLY")
                                && field.getName().equalsIgnoreCase( "tbcxqdly")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"-"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SQNR")
                                && field.getName().equalsIgnoreCase( "sqnr")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"-"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXSX")
                                && field.getName().equalsIgnoreCase( "tbcxsx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"0"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXSXDW")
                                && field.getName().equalsIgnoreCase( "tbcxsxdw")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"G"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                    }else if(beanName.equals( "WsbsTbcxjgBean")){ //特别程序结果 比较WsbsTbcxjgBean和ex_gdbs_tbcxjg.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("XH")
                                && field.getName().equalsIgnoreCase( "xh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXJG")
                                && field.getName().equalsIgnoreCase( "tbcxjg")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("JGCSRQ")
                                && field.getName().equalsIgnoreCase( "jgcsrq")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXJSRQ")
                                && field.getName().equalsIgnoreCase( "tbcxjsrq")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("TBCXSFJE")
                                && field.getName().equalsIgnoreCase( "tbcxsfje")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"0"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("JEDWDM")
                                && field.getName().equalsIgnoreCase( "jedwdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"CNY"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                    }else if(beanName.equals( "WsbsBjBean")){ //办结 比较WsbsBjBean和EX_GDBS_BJ.xml
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJBMMC")
                                && field.getName().equalsIgnoreCase( "bmmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJBMZZJDDM")
                                && field.getName().equalsIgnoreCase( "zzjgdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJJGMS")
                                && field.getName().equalsIgnoreCase( "cljgms")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("ZJGZMC")
                                && field.getName().equalsIgnoreCase( "zjgzmc")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("ZJBH")
                                && field.getName().equalsIgnoreCase( "zjbh")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("ZJYXQX")
                                && field.getName().equalsIgnoreCase( "zjyxqx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("FZGZDW")
                                && field.getName().equalsIgnoreCase( "fzgzdw")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("SFJE")
                                && field.getName().equalsIgnoreCase( "sfje")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("JEDWDM")
                                && field.getName().equalsIgnoreCase( "jedwdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNULL(field.get(obj),"CNY"));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("BJSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }


                        if( fieldBean.getFieldName().equalsIgnoreCase("BJJGDM")
                                && field.getName().equalsIgnoreCase( "cljgdm")){
                            String cljgdm=StringHelperUtil.handleNull(field.get(obj));
                            if("1".equals(cljgdm)){
                                cljgdm="1";
                            }else if("2".equals(cljgdm)){
                                cljgdm="2";
                            } else if("3".equals(cljgdm)){
                                cljgdm="3";
                            } else if("4".equals(cljgdm)){
                                cljgdm="4";
                            } else if("5".equals(cljgdm)){
                                cljgdm="5";
                            } else if("6".equals(cljgdm)){
                                cljgdm="6";
                            } else if("7".equals(cljgdm)){
                                cljgdm="6";
                            } else if("0".equals(cljgdm)){
                                cljgdm="0";
                            } else{
                                cljgdm="6";
                            }
                            fieldBean.setFieldValue(cljgdm);
                        }

                    }else if(beanName.equals( "WsbsLqdjBean")){ //登记领证 比较WsbsLqdjBean和
                        if( fieldBean.getFieldName().equalsIgnoreCase("LQRXM")
                                && field.getName().equalsIgnoreCase( "lqrxm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LQRZJLX")
                                && field.getName().equalsIgnoreCase( "lqrzjlx")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LQRSFZJHM")
                                && field.getName().equalsIgnoreCase( "lqrsfzjhm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LQFS")
                                && field.getName().equalsIgnoreCase( "lqfs")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("LQSJ")
                                && field.getName().equalsIgnoreCase( "createTime")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                        if( fieldBean.getFieldName().equalsIgnoreCase("XZQHDM")
                                && field.getName().equalsIgnoreCase( "xzqhdm")){
                            fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
                        }
                    }
                    /* 审批系统处表字段和目标处表字段变量不同,需要根据对应的bean和ex_gdbs_***对应 */
					/*
					// 接口字段设置
					if (fieldBean.getFieldName().equalsIgnoreCase(field.getName())) {
						fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
						break;
					}
					// 不同字段设置
					if (null != fieldBean.getTargetName() && fieldBean.getTargetName().equalsIgnoreCase(field.getName())) {
						fieldBean.setFieldValue(StringHelperUtil.handleNull(field.get(obj)));
						break;
					}
					*/
                }
            }
        } catch (IllegalArgumentException e) {
            WbtimerJobLogger.log(e);
        } catch (IllegalAccessException e) {
            WbtimerJobLogger.log(e);
        }
    }

    /**
     * 验证环节是否送数据
     *
     * @param obj
     *            数据来源
     * @return sbStepType "NO"：验证YES，需送数据；"NO"：验证失败，无需送数据
     */
    public static String checkSbStepType(WsbsSbSubBean obj) {
        String sbStepType = "NO";
        try {
            Class<?> cls = obj.getClass();
            Field f_activitydefid = cls.getDeclaredField("activitydefid");
            f_activitydefid.setAccessible(true);
            if (null == f_activitydefid)
                return sbStepType;
            String activitydefid = f_activitydefid.get(obj).toString(); // 当前状态
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                // 非这个属性的字段
                if (!"activitydefid".equals(field.getName())) {
                    field.setAccessible(true);
                    // System.out.println(activitydefid + "--" +
                    // field.getName().toUpperCase() + "--" +
                    // field.get(obj).toString());
                    if (null != field.getName() && (activitydefid.equals(field.getName().toUpperCase()) && field.get(obj).toString().equals("1"))) {
                        // activitydefid=当前环节，且半交换数据表配置值为1
                        sbStepType = activitydefid;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            sbStepType = "NO";
        }
        return sbStepType;
    }

}

