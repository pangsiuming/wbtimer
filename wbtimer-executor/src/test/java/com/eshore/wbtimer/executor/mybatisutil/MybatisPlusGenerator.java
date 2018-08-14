package com.eshore.wbtimer.executor.mybatisutil;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 描述: mybatis-plus 生成器
 * 通过配置@Value 读取yml文件属性 生成类需要加入@SpringBootTest 和 @RunWith注解
 * 也可以不配置 自己定义 生成类不需要加注解
 * @create 2018-04-10 上午9:09
 */
public class MybatisPlusGenerator {
    private final String applicationName = "wbtimer-executor";
    private final String url = "jdbc:oracle:thin:@14.215.113.76:1521:orcl";
    private final String username = "zh_yx_zcsp";
    private final String password = "zhwb";
    private final String myFileOutPutDir = "C:\\Users\\Administrator\\Desktop\\new";
    private final String dbDriverName = "oracle.jdbc.driver.OracleDriver";
    private final String myTableName = "WSBS_FGBL_INFO";
    private final String myName = "wyf";
    /**
     * 模块名
     */
    private String modulename=".mymodule";

    /**
     * 生成代码
     */
    @Test
    public void generatorCode(){
        String author = myName;
        String packageName = "com."+applicationName.replace("-",".");
        String outPutDir = myFileOutPutDir;
        String driverName = dbDriverName;
        String tableName = myTableName;
//        String tableName2="sys_role_menu_button_mapp";
        boolean serviceCreate = false;
        boolean controllerCreate = false;
        generateByTable(author,packageName,outPutDir,driverName,serviceCreate,controllerCreate,tableName);
    }

    /**
     * 通过表名生成controller，service，dao，dao-xml，entity等包
     * @param author  文件注释的用户名
     * @param packageName 生成的包名
     * @param outPutDir 代码生成输出的目录
     * @param driverName 数据库连接驱动
     * @param serviceCreate 是否创建service包
     * @param controllerCreate 是否创建controller包
     * @param tableNames  不传入 则是数据库中所有表
     */
    public void generateByTable(String author,
                                String packageName,
                                String outPutDir,
                                String driverName,
                                boolean serviceCreate,
                                boolean controllerCreate,
                                String... tableNames){
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driverName)
                .setTypeConvert(new OracleTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        return super.processTypeConvert(fieldType);
                    }
                });  ;
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  //是否大写命名
                .setEntityLombokModel(false) //是否为lombok模型
                .setDbColumnUnderline(true)  //表名、字段名、是否使用下划线命名
                .setNaming(NamingStrategy.underline_to_camel)//下划线转驼峰命名
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组  tableNames为空时 即所有表

        //生成模板配置  可以控制输出的目录  设置为null即不生成该目录 , sting可以随意输入
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setService(serviceCreate?"service":null)
                .setServiceImpl(serviceCreate?"serviceImpl":null)
                //.setEntity(null)
                //.setMapper(null)
                //.setXml(null)
                .setController(controllerCreate?"controller":null);

        //全局配置
        GlobalConfig config=new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor(author)
                .setOutputDir(outPutDir) //输出的目录
                .setMapperName("%sDao")
                .setXmlName("%sDao")
                .setBaseResultMap(true)//生成baseresultmap
                .setBaseColumnList(true) //生成basecolumnlist
                .setEnableCache(false) //开启二级缓存 需要导入mybatis-ehcache.jar
                .setFileOverride(true);
        //开始生成 packageconfig设置生成的包名称规则
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller"+modulename)
                                .setService("service"+modulename)
                                .setServiceImpl("service"+modulename+".impl")
                                .setMapper("dao"+modulename) //设置生成的Mapper的包名称
                                .setEntity("entity"+modulename)
                ).execute();
    }
}
