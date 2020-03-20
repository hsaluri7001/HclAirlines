package com.hcl.loan.itemwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.loan.bean.Customer;
import com.hcl.loan.utils.SqlConstants;

/**
 * @author saluri
 *
 */
@Repository
public class CustomerItemWriter {

	@Autowired
	 DataSource dataSource;

	public ItemWriter<Customer> createCustomerItemWriter() {
		JdbcBatchItemWriter<Customer> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SqlConstants.INSERTINTOCUSTOMER);
		itemWriter.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<Customer>() {
			@Override
			public void setValues(Customer item, PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, item.getId());
				ps.setString(2, item.getUserName());
				ps.setString(3, item.getGender());
				ps.setInt(4, item.getAge());
				ps.setString(5, item.getPan());
				ps.setString(6, item.getAadhar());
			}

		});
		return itemWriter;
	}

}
