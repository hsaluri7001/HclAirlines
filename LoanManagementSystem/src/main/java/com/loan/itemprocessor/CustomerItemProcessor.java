package com.loan.itemprocessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.loan.bean.Customer;

/**
 * @author saluri
 *
 */
@Service
public class CustomerItemProcessor implements ItemProcessor{

	@Override
	public Object process(Object item) throws Exception {
		// TODO Auto-generated method stub
		Customer customer=(Customer)item;
		return item;
	}
}
