package edu.biz.ioc1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc1.xml");
		OrderManager manager = (OrderManager) ctx.getBean("orderManager");
		manager.order();
		ctx.close();
	}
}
