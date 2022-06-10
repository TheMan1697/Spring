package edu.biz.getter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Designer extends Emp{
	public Emp getEmp(){
		return this;
	}
}