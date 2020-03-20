package com.hcl.datamig.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import com.hcl.datamig.bean.User;

/**
 * @author saluri
 *
 */
@Repository
public class UserItemReader {

	public ItemReader<User> createUserItemReader() {
		FlatFileItemReader<User> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("D://HCL CLEARANCE/AccountTransactions.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createUserLineMapper());
		return itemReader;
	}

	private LineMapper<User> createUserLineMapper() {
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(createUserLineTokenizer());
		lineMapper.setFieldSetMapper(createUserFieldSetMapper());
		return lineMapper;
	}

	private LineTokenizer createUserLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "name", "age", "email", "mobile" });
		return lineTokenizer;
	}

	private FieldSetMapper<User> createUserFieldSetMapper() {
		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);
		return fieldSetMapper;
	}
}
