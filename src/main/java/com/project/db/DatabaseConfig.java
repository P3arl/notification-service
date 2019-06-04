package com.project.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DatabaseConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);

	@Bean
	public DataSource dataSource() {
		LOG.info("HSQL Database initializing..");
		return new EmbeddedDatabaseBuilder().addScript("testdb/schema.sql").addScript("testdb/data.sql").build();
	}
}
