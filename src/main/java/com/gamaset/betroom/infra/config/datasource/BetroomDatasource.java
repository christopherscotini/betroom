package com.gamaset.betroom.infra.config.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BetroomDatasource {
	
	@Bean(name = "betroomDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.betroom")
	public DataSource publicadorDataSource() {
		return DataSourceBuilder.create().build();
	}

}
