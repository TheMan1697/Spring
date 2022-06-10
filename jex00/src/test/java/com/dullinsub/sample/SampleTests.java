package com.dullinsub.sample;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dullinsub.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
@Log4j
public class SampleTests {
	private static final Logger log = Logger.getLogger(SampleTests.class); // @log4j 가 없다면 매번 해줘야 하는 일 
	
	@Setter @Autowired
	private Restaurant restaurant;
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Test
	public void textExist() {
		assertNotNull(restaurant);
		log.warn(restaurant);
		log.info("------------------------------------------------");
		log.info(restaurant.getChef());
	}
	
}
