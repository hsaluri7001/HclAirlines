package com.datamig.conf;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datamig.processor.UserItemProcessor;
import com.datamig.reader.UserItemReader;
import com.datamig.writer.UserItemWriter;

/**
 * @author saluri
 *
 */
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
		return stepBuilderFactory.get("createUserStep").chunk(1).reader(userItemReader.createUserItemReader()).processor((ItemProcessor)userItemProcessor).writer(userItemWriter.createUserItemWriter()).build();
	}
	@Bean
	public Job createUserJob() {
		return  jobBuilderFactory.get("createUserJob").flow(createUserStep()).end().build();
	}
}
