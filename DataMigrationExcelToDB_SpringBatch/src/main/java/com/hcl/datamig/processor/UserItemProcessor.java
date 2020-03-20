package com.hcl.datamig.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.hcl.datamig.bean.User;

/**
 * @author saluri
 *
 */
@Service
public class UserItemProcessor implements ItemProcessor{

	@Override
	public Object process(Object item) throws Exception {
		// TODO Auto-generated method stub
		User user=(User)item;
		System.out.println(user);
		return user;
	}



}
