package kr.co.jhta.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
		
		//1번째 방식
//		Weapon w = ac.getBean("w",Weapon.class);
		
		//2번째 방식
		Weapon w = ac.getBean("imple",Weapon.class);
		
		w.tire();
		w.reload();
		
	}

}
