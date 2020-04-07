package com.loan.itemreader;

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

import com.loan.bean.Customer;

/**
 * @author saluri
 *
 */
@Repository
public class CustomerItemReader {
	public ItemReader<Customer> createUserItemReader() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("D://HCL CLEARANCE/AccountTransactions.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(createUserLineMapper());
		return itemReader;
	}

	private LineMapper<Customer> createUserLineMapper() {
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(createUserLineTokenizer());
		lineMapper.setFieldSetMapper(createUserFieldSetMapper());
		return lineMapper;
	}

	private LineTokenizer createUserLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "userName", "gender", "age", "salary","pan","aadhar" });
		return lineTokenizer;
	}

	private FieldSetMapper<Customer> createUserFieldSetMapper() {
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);
		return fieldSetMapper;
	}

}