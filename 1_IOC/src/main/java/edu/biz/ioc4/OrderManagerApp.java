package edu.biz.ioc4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc4.xml");
		OrderManager manager = (OrderManager) ctx.getBean("orderManager");
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		System.out.println(manager);
		manager.order();
		ctx.close();
	}
}
