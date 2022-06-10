package com.dullinsub.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Restaurant {
	@Autowired
	private Chef chef;

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
}
