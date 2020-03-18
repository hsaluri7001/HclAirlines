package com.hcl.datamig.conf;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.datamig.reader.UserItemReader;
import com.hcl.datamig.writer.UserItemWriter;
import com.hcl.processor.UserItemProcessor;

@Configuration
@EnableBatchProcessing
public class UserConfiguration {

	@Autowired
	UserItemReader userItemReader;
	@Autowired
	UserItemProcessor  userItemProcessor;
	@Autowired
	UserItemWriter userItemWriter;
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public Step createUserStep() {
		return stepBuilderFactory.get("createUserStep").chunk(1).reader(userItemReader.createAccountItemReader()).processor((ItemProcessor)userItemProcessor).writer(userItemWriter.createAccountItemWriter()).build();
	}
	@Bean
	public Job createUserJob() {
		return  jobBuilderFactory.get("createUserJob").flow(createUserStep()).end().build();
	}
}
