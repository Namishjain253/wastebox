package com.skillassure.wastebox.configuration;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceConfig {
	
	private String driverclassname;
	private String url;
	private String username;
	private String password;
	
	
	public String getDriverclassname() {
		return driverclassname;
	}
	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}
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
	
	/**
	 * DataSourceConnection method will return data source object based on active profile set from application.properties.
	 */
	@Bean
    public DataSource DatasourceConnection() 
    {
		 final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverclassname);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
    }
}
