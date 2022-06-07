package com.silly.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.silly.domain.Criteria;
import com.silly.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping({"sample","/sample/*"})
@Log4j
public class SampleController {
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public void basic(HttpServletRequest req, HttpSession session, Board board){
		log.info("basic ..........");
		log.info(req);
		log.info(req.getSession());
		log.info(session);
		log.info(board);
		
	}
	
	@GetMapping("get") @PostMapping("get")
	public void basic2(){
		log.info("basic2 ..........");
	}
	@GetMapping("ex01")
	public String ex01(SampleDTO dto){
		log.info(dto);
		return "ex01";
	}
	@GetMapping("ex02")
	public String ex02(String name, int age){
		log.info(name);
		log.info(age);
		return "ex02";
	}
	@GetMapping("ex02List")
	public void ex02List(@RequestParam("ids")HashSet<String> ids){
		log.info(ids);
	}
	@GetMapping("ex02Array")
	public void ex02List(@RequestParam("ids") String[] ids){
		log.info(Arrays.toString(ids));
	}
	@GetMapping("cri")
	public void cri(Criteria criteria, Board board){
		log.info(criteria);
	}
	
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,false));
	}
	@GetMapping("ex04")
	public void ex04(SampleDTO dto, @ModelAttribute(value="page") Integer page, Model model){
		log.info(dto);
		log.info(page);
		model.addAttribute("amount",25);
	}
	
	@GetMapping("ex04Rttr")
	public String ex04Rttr(RedirectAttributes rttr){
//		return "sample/ex04";
		rttr.addAttribute("page",4);
		return "redirect:ex04";
	}
	@GetMapping("ex05_1") @ResponseBody
	public Board ex05_1(Board board){
		return board;
	}
	
	@GetMapping("exUpload")
		public void exUpload(){
			log.info("exUpload...........");
		
	}
		@PostMapping("exUpload")
			public void exUploadPost(ArrayList<MultipartFile> files){
				log.info("exUpload...........");
				files.forEach(file -> {
					log.info("=============");
					log.info("name: "+file.getOriginalFilename());
					log.info("size: " + file.getSize());
					
				});
			}
		

}
