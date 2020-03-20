package com.hcl.loan.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.loan.itemprocessor.CustomerItemProcessor;
import com.hcl.loan.itemreader.CustomerItemReader;
import com.hcl.loan.itemwriter.CustomerItemWriter;

/**
 * @author saluri
 *
 */
@Configuration
public class CustomerJobConfiguration {

	@Autowired
	private CustomerItemReader customerItemReader;
	@Autowired
	private CustomerItemProcessor customerItemProcessor;
	@Autowired
	private CustomerItemWriter customerItemWriter;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step createCustomerStep() {
		return stepBuilderFactory.get("createCustomerStep").chunk(1).reader(customerItemReader.createUserItemReader()).processor((ItemProcessor)customerItemProcessor).writer(customerItemWriter.createCustomerItemWriter()).build();
	}
	
	@Bean
	public Job createCustomerJob() {
		return jobBuilderFactory.get("createCustomerJob").flow(createCustomerStep()).end().build();
		
	}
}