package com.airlines;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author saluri
 *
 */
@Configuration
public class JpaConfiguration {
	
	@Bean
	public DataSource dataSource() {
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	ds.setUsername("bookinguser");
	ds.setPassword("aspire123");
	return ds;
	}
	
	@Bean
	public JpaVendorAdapter hibJpaVendorAdapter() {
	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	adapter.setDatabase(Database.ORACLE);
	adapter.setShowSql(true);
	adapter.setGenerateDdl(false);
	//adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
	return adapter;
	
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jpaVendorAdapter) {
	LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
	emfb.setDataSource(ds);
	emfb.setJpaVendorAdapter(jpaVendorAdapter);
	emfb.setPackagesToScan("com.hcl.airlines.*");
	return emfb;
	}

}
