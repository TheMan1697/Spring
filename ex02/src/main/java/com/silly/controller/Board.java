package com.silly.controller;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component @ToString @Setter @Getter
public class Board {
	private Long bno;
	private String title;
}
