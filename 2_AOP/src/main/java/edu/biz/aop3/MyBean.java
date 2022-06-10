package edu.biz.aop3;

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

	public void run(){
		dependency.hello();
		dependency.goodbye();
	}
}
