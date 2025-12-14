package com.zhb.zhbspringboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


/**
 * 这里用于创建多数据源功能
 */

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.ecology")
@MapperScan(basePackages = "com.zhb.zhbspringboot.ecology.mapper", sqlSessionFactoryRef = "ecologySqlSessionFactory")
public class EcologySourceConfig {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @Bean(name = "ecologyDataSource")
    @Primary
    public DataSource ecologyDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }

    @Bean(name = "ecologySqlSessionFactory")
    @Primary
    public SqlSessionFactory ecologySqlSessionFactory(@Qualifier("ecologyDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean(name = "ecologyTransactionManager")
    @Primary
    public DataSourceTransactionManager ecologyTransactionManager(@Qualifier("ecologyDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // Getter 和 Setter 方法
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}