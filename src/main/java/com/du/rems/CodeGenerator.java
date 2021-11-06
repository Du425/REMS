package com.du.rems;



import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:33060/rems",
            "root",
            "DST773344");


    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder ->
                        builder.author("Du425")
                                .fileOverride()
                                .enableSwagger()
                                .dateType(DateType.TIME_PACK)
                                .commentDate("yyyy-MM-dd")
                                .outputDir("D://java-code/REMS/src/main/java"))
                // 包配置
                .packageConfig(builder ->
                        builder.parent("com.du.rems")
                                .service("service")
                                .serviceImpl("service.impl")
                                .mapper("mapper")
                                .controller("controller")
                                .other("other")
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://java-code/REMS/src/main/resources/mapper")))
                // 策略配置
                .strategyConfig(builder -> builder.addInclude("account","record","user","category"))

//

                .execute();
    }

}