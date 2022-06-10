package edu.biz.aop4;

import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public MyDependency getDependency() {
		return dependency;
	}

	public void setDependency(MyDependency dependency) {
		this.dependency = dependency;
	}

	public void run() {
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodBye();
	}
}
