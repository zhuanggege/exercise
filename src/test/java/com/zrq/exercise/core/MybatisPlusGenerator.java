package com.zrq.exercise.core;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author:
 * @CreateDate: 2020/10/18
 * @Version: 类说明：
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) throws InterruptedException {
            // 获取Mybatis-Plus.properties文件的配置信息
            final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            //全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir(rb.getString("OutputDir"));
            gc.setOpen(false); gc.setBaseResultMap(true);
            gc.setBaseColumnList(true);
            gc.setAuthor(rb.getString("author"));
            gc.setMapperName("%sMapper");
            gc.setXmlName("%sMapper");
            gc.setServiceName("%sService");
//            gc.setServiceImplName("%sServiceImpl");
            gc.setControllerName("%sController");
            mpg.setGlobalConfig(gc);
            //dataSource配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setUrl(rb.getString("url"));
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername(rb.getString("userName"));
            dsc.setPassword(rb.getString("password"));
            mpg.setDataSource(dsc);
            //package配置
            PackageConfig pc = new PackageConfig();
            pc.setParent(rb.getString("parent"));
            pc.setController("controller");
//            pc.setService("service");
            pc.setServiceImpl("service");
            pc.setEntity("entity");
            pc.setMapper("mapper");
            mpg.setPackageInfo(pc);
            //自定义配置
            InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            /* ... */
            } };
            //如果模板引擎是freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            //自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            //自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(com.baomidou.mybatisplus.generator.config.po.TableInfo tableInfo) {
                //自定义输入文件名称
                return rb.getString("OutputDirXml") + "/mapper/" + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            //设置需要创建的表
            strategy.setInclude(new String[]{rb.getString("tableName")});
            mpg.setStrategy(strategy);
            //设置模板引擎
            TemplateConfig tc = new TemplateConfig();
            tc.setController(null);       //设置不需要创建controller
//            tc.setServiceImpl(null);      //设置不需要创建serviceImpl
            tc.setService(null);          //设置不需要创建service
            tc.setXml(null);
            mpg.setTemplate(tc);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
            System.out.println("done,fresh engineering");
    }

}
