package com.silly.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silly.sample.SampleTests;

import oracle.jdbc.driver.OracleDriver;

public class JDBCTests {
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		final Logger log = Logger.getLogger(SampleTests.class);
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@np.dullinsub.cloud:1521:xe", "spring", "1234")) {
			log.info(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
