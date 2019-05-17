package com.teemo.bootdemo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ProjectName: bootdemo
 * @Package: com.teemo.bootdemo.util
 * @ClassName: CodeGenerator
 * @Author: Ming.Hou
 * @Description: ${description}
 * @Date: 2019/5/16 11:38
 * @Version: 1.0
 */
public class CodeGenerator {

    public static void main(String args[]){
        generatorCode();
    }
    
    
    /** 
     * @Description: 读取控制台内容
     * @Param:  
     * @return:  
     * @Author: Ming.Hou
     * @Date: 2019/5/16 
     */
    public static String scanner(String tip){

        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入"+ tip +":");
        System.out.println(help.toString());
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的："+ tip + "!");
    }

    /**
     * @Description: mybatis plus 代码生成器
     * @Param:
     * @return:
     * @Author: Ming.Hou
     * @Date: 2019/5/16
     */
    public static void generatorCode() {

        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gcConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath:" + projectPath);
        gcConfig.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("Teemo.dana")
                .setOpen(false)
                .setFileOverride(true)     //是否支持文件覆盖
                .setBaseColumnList(true)       //自动生成SQL片段
                .setBaseResultMap(true)        //自动生成结果集映射
                .setActiveRecord(true);
//                .setIdType(IdType.AUTO)     //主键策略
//                .setServiceName("%sService")       //设置生成的service接口名字的首字母是否为I


        //2.数据源配置
        DataSourceConfig dbConfig = new DataSourceConfig();
        dbConfig.setDbType(DbType.MYSQL)        //设置数据库类型
//                .setDriverName("com.mysql.jdbc.Driver")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mysql_tst?characterEncoding=utf8&useSSL=false&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("2018");

        //3.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.teemo")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setEntity("dao.domain")
                .setMapper("dao.mapper")
//                .setXml("mapper")
                .setModuleName(scanner("模块名"));


        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true)       //全局大写的命名
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)       //下划线转驼峰命名
                .setInclude(scanner("表名，多个英文逗号分割").split(","))      //逆向工程需要使用的;
                .setTablePrefix("t_")
                .setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        //5.整合配置
        mpg.setGlobalConfig(gcConfig);
        mpg.setDataSource(dbConfig);
        mpg.setPackageInfo(pkConfig);
        mpg.setStrategy(strategy);
        //注意！如果您选择了非默认引擎，需要在 AutoGenerator 中 设置模板引擎。
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        //执行代码生成
        mpg.execute();
    }



}

