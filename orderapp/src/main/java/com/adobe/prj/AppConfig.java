package com.adobe.prj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    //Handle & Send the class to Spring to manage lifecycle of object
    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/adobe_2019");
        ds.setUsername("root");
        ds.setPassword("smartwork");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEmf(DataSource ds) {
        LocalContainerEntityManagerFactoryBean emf  = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("com.adobe.prj.entity");
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update"); // Data Definition Language
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect"); // Data Definition Language
        emf.setJpaProperties(props);
        return emf;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
        return new JpaTransactionManager();
    }
}
