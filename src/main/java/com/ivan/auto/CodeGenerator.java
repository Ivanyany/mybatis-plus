package com.ivan.auto;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 * @Auther: Ivan
 * @Date: 2020/3/22 16:05
 * @Description:
 */
public class CodeGenerator {

    public static void main(String[] args){
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("Ivan") // 作者
                .setOutputDir("G:\\00mybatisplus\\src\\main\\java") // 生成路径
                .setFileOverride(true) // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService") // 设置生成的service接口的名字是否为I
                                        // IUserService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) // 数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8&serverTimezone=GMT%2B8")
                .setUsername("root")
                .setPassword("123456");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) // 指定表名字段是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据表映射到实体类的命名策略
                .setTablePrefix("tbl_") // 数据库表的前缀
                .setInclude("tbl_user"); // 生成的表

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.ivan.auto").
                setMapper("mapper").
                setService("service").
                setController("controller")
                .setEntity("beans")
                .setXml("xml");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();//执行生成代码
    }
}
