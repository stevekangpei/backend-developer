package com.kangpei.dynamic.config;

import com.kangpei.dynamic.constant.DSConstant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * description: DataSourceConfig <br>
 * date: 2020/8/18 10:59 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Configuration
@PropertySource("classpath:config/jdbc.properties")
@MapperScan(basePackages = "com.kangpei.dynamic")
public class DataSourceConfig {

    @Bean(DSConstant.MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean(DSConstant.SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {

        Map<Object, Object> dataSources = new HashMap<>(2);
        dataSources.put(DSConstant.MASTER, master());
        dataSources.put(DSConstant.SLAVE, slave());

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSources);
        dynamicDataSource.setDefaultTargetDataSource(master());
        return dynamicDataSource;
    }
}
