package edu.biz.jdbc2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc2.xml");
		EmpDao dao = ctx.getBean("empDao", EmpDao.class);
		Emp emp = new Emp(8000, "javaman", "CLECK", 7902, null, 1000, null, 20);
		dao.register(emp);
	}
}
