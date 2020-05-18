package com.ecs.monitor.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@ConfigurationProperties(prefix = "spring.datasource",ignoreInvalidFields = true)
public class DruidConfig {

    private String url="jdbc:mysql://118.190.203.107:3306/sys_monitor?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    private String username="root";
    private String password="jubaokj@2019.";

    @Bean
    @ConditionalOnMissingBean
    public DataSource druid() {
          DruidDataSource  druidDataSource = new DruidDataSource();

          druidDataSource.setUrl(url);
          druidDataSource.setUsername(username);
          druidDataSource.setPassword(password);

        return druidDataSource;
    }
}
