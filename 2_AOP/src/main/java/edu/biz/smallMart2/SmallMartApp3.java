package edu.biz.smallMart2;

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
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small2.xml");
		
//		SmallMart mart1 = new SmallMartImpl(); // getBean 으로 대체 > xml만들러 가자~
//		
//		
//		System.err.println("====================");
//		ProxyFactory pf = new ProxyFactory();
//		
//		AspectJExpressionPointcut apc = new AspectJExpressionPointcut();
//		apc.setExpression("execution(* *2(..))");
//		
//		pf.addAdvisor(new DefaultPointcutAdvisor(apc, new BeforeLog()));
//		pf.setTarget(mart1);
		
		SmallMart mart2 = ctx.getBean("mart2", SmallMart.class);
		try {
			mart2.getProduct("전자제품");
			mart2.getProduct2("생필품");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
