package edu.biz.setter2;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/setter2.xml")
public class DevelopeTests { // 이게 진짜 테스트입니다잉
	// @Autowired > 스프링에 의존해서 의존성 주입 // @Inject , @Resource 셋의 차이 알기.
	@Setter @Inject
	private Develope develope;
	
	@Test
	public void testExist() {
		assertNotNull(develope);
	}
	
	@Test
	public void testCoding() {
		develope.coding();
	}
}
