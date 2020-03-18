package com.hcl.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.hcl.datamig.bean.User;

@Service
public class UserItemProcessor implements ItemProcessor {

	@Override
	public Object process(Object item) throws Exception {
		// TODO Auto-generated method stub
		User user=(User)item;
		return null;
	}


}
