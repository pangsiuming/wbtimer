package com.eshore.wbtimer.common.datasource;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.eshore.wbtimer.common.datasource.annotation.DataSource;
import com.eshore.wbtimer.common.utils.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 描述:数据源切入
 *
 * @author Yangjinming
 * @create 2018-01-05 19:25
 */
public class DataSourceAdvice  implements MethodBeforeAdvice {
    private String dataSoureTye;
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        javax.sql.DataSource dataSource;
        if(method.isAnnotationPresent(DataSource.class)){ //如果用了@DataSource注解标注
            DataSource dataSourceAnn = method.getAnnotation(DataSource.class);
            String key = dataSourceAnn.value();
            dataSource = (javax.sql.DataSource) SpringContextUtil.getBean(key);//获取数据源
        }else{
            //如果没有标注则默认使用A_DataSource的数据源
            dataSource = (javax.sql.DataSource)SpringContextUtil.getBean(getDataSoureTye()); //获取数据源
        }

        //修改MyBatis的数据源
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = SpringContextUtil.getApplicationContext().getBean(MybatisSqlSessionFactoryBean.class);
        Environment environment = sqlSessionFactoryBean.getObject().getConfiguration().getEnvironment();
        Field dataSourceField = environment.getClass().getDeclaredField("dataSource");
        dataSourceField.setAccessible(true);//跳过检查
        dataSourceField.set(environment,dataSource);//修改mybatis的数据源
    }

    public String getDataSoureTye() {
        if (StringUtils.isEmpty(dataSoureTye)){
            dataSoureTye = DataSourceType.DATASOURCE;
        }
        return dataSoureTye;
    }

    public void setDataSoureTye(String dataSoureTye) {
        this.dataSoureTye = dataSoureTye;
    }
}
