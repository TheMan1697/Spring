package edu.biz.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service @Setter @Slf4j
public class HumanApp {
	@Value("#{human.name}") // 와우 human에 있는 값을 불러와부렀다잉
	private String name;
	@Value("#{human.age + human.age}") // el의 기본 문법을 충실히 따라감 // @value안엔 #을 이용한 값만 가능
	private int age;
	
	
//	@Value("#{human}")
	@Autowired // 위 문장대체
	private Human human;
	
	public static void main(String[] args) {
		HumanApp humanApp = new ClassPathXmlApplicationContext("human.xml")
				.getBean("humanApp", HumanApp.class);
		log.info(humanApp.name);
		log.info(humanApp.age + "");
		
		log.info(humanApp.human.getName());
		log.info(humanApp.human.getAge() + "");
	}
}
