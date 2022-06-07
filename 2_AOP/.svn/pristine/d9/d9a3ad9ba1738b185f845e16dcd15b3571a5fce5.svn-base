package edu.biz.aop1;

import org.springframework.aop.framework.ProxyFactory;

public class HelloApp {
	public static void main(String[] args) {
		HelloInter hello1 = new Hello(); // 인스턴스 직접생성
		hello1.sayHello();
		
		System.out.println("=======================");
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MsgDecorator());
		pf.addAdvice(new MsgDecorator());
		pf.setTarget(hello1);
		HelloInter hello2 = (HelloInter) pf.getProxy(); // proxy 팩토리를 사용해 인스턴스 생성
		
		hello2.sayHello();
		
		System.out.println("=======================");
		System.out.println(hello1.toString()); // 가시성인것은 모두 toString이 포함된 것이다.
		System.out.println(String.format("%x", hello1.hashCode()));
		
		System.out.println(hello2); // 위와 같은말
		System.out.println(String.format("%x", hello2.hashCode()));
		
		System.out.println(hello1 == hello2); // 주소는 같지만 완전히 같은 건 아님.
		
		
	}
}
