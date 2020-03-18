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

@Repository
public class UserItemReader {

	public ItemReader<User> createAccountItemReader() {
		FlatFileItemReader<User> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("E://HCL CLEARANCE/user.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createAccountLineMapper());
		return itemReader;
	}

	private LineMapper<User> createAccountLineMapper() {
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(createAccountLineTokenizer());
		lineMapper.setFieldSetMapper(createAccountFieldSetMapper());
		return lineMapper;
	}

	private LineTokenizer createAccountLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setNames(new String[] { "id", "name", "age", "email", "mobile" });
		return lineTokenizer;
	}

	private FieldSetMapper<User> createAccountFieldSetMapper() {
		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);
		return fieldSetMapper;
	}
}
