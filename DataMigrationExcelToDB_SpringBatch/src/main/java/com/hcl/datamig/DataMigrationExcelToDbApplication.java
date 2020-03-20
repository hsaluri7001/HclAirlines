package com.hcl.datamig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author saluri
 *
 */
@SpringBootApplication
public class DataMigrationExcelToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMigrationExcelToDbApplication.class, args);
	}

}
