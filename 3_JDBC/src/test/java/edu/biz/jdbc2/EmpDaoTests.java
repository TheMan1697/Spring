package edu.biz.jdbc2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/jdbc1.xml", "file:src/main/resources/jdbc2.xml"})
@Slf4j
public class EmpDaoTests {
	@Setter @Autowired
	private EmpDao dao;
	
	@Test
	public void textExist(){
		assertNotNull(dao);
		System.out.println(dao.toString());
	}
}
