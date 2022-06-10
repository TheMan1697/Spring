package edu.biz.jdkproxy;

import java.lang.reflect.Proxy;

public class HelloWorldApp {
	public static void main(String[] args) {
		HelloWorld helloworld1 = new HelloWorldImpl();
		helloworld1.sayHello("원본객체");
		
		System.out.println("==============================================================");
		HelloWorld helloWorld2 = (HelloWorld) Proxy.newProxyInstance( // proxy > 대리객체
				HelloWorld.class.getClassLoader(), new Class[] {HelloWorld.class}, new HelloWorldHandler(helloworld1));
		helloWorld2.sayHello("대리객체");

		System.out.println("==============================================================");
		System.out.println(helloworld1);
		System.out.println(helloWorld2);
	}
}
