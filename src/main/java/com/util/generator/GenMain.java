package com.util.generator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.util.Log;

public class GenMain {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;//如果已经生成过了是否进行覆盖
        String genCfg = "/com/util/generator/generatorConfig.xml";
        URL url = GenMain.class.getResource(genCfg);
        String file = url.getFile();
        File configFile = new File(file);
        ConfigurationParser cfgParser = new ConfigurationParser(warnings);//配置文件解析器
        Configuration config = null;
        try {
            config = cfgParser.parseConfiguration(configFile);
        } catch (IOException e) {
            Log.getLogger().error(e.getMessage(),e);
        } catch (XMLParserException e) {
            Log.getLogger().error(e.getMessage(),e);
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator generator = null;
        try {
            generator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            Log.getLogger().error(e.getMessage(),e);
        }
        try {
            generator.generate(null);
            System.out.println("mybatis 代码生成成功。。。");
        } catch (SQLException e) {
            Log.getLogger().error(e.getMessage(),e);
        } catch (IOException e) {
            Log.getLogger().error(e.getMessage(),e);
        } catch (InterruptedException e) {
            Log.getLogger().error(e.getMessage(),e);
        }
    }
}