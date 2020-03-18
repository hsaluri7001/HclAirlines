package com.hcl.datamig.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.datamig.bean.User;
import com.hcl.datamig.sql.SqlConstants;

@Repository
public class UserItemWriter {
	@Autowired
	private DataSource dataSource;
	
public ItemWriter<User> createAccountItemWriter(){
JdbcBatchItemWriter<User> itemWriter=new JdbcBatchItemWriter<>();
  itemWriter.setDataSource(dataSource);
  
  itemWriter.setSql(SqlConstants.INSERT_INTO_USER);
  itemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<User>() {

	@Override
	public void setValues(User user, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getAge());
		ps.setString(4, user.getEmail());
	}
  });
return itemWriter;
}
}
