package edu.biz.aop4;

public class MyDependency {
	public void hello(int intValue) {
		System.out.println("hello :: " + intValue);
	}
	
	public void goodBye() {
		System.out.println("goodbye");
	}
}
