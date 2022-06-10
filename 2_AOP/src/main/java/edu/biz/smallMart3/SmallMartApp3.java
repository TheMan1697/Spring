package edu.biz.smallMart3;

import java.lang.reflect.Method;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.biz.smallMart.advice.BeforeLog;

public class SmallMartApp3 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small3.xml");
		
		SmallMart mart2 = ctx.getBean("mart", SmallMart.class);
		try {
			mart2.getProduct("전자제품");
			mart2.getProduct2("생필품");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
