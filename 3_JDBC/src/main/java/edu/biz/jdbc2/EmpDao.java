package edu.biz.jdbc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Setter @Service
public class EmpDao {
	// CRUD
	@Autowired
	private JdbcTemplate template;
	
	public int register(Emp emp){
		return template.update("INSERT INTO EMP VALUES "
				+ "(?, ?, ?, ?, SYSDATE, ?, ?, ?)"
				, emp.getEmpno()
				, emp.getEname()
				, emp.getJob()
				, emp.getMgr()
				, emp.getSal()
				, emp.getComm()
				, emp.getDeptno()
				);
	}
}
