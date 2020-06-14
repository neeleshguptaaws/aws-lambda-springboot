package com.neel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.neel.controller.IndexController;
import com.neel.model.MyHello;

@SpringBootApplication
@Import({ IndexController.class })
public class Application extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	MyHello hello;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		System.out.println("Beans count:" + context.getBeanDefinitionCount());

		/*String[] beans = context.getBeanDefinitionNames();

		for (String bean : beans) {
			System.out.println(bean);
		}*/

		System.out.println("Hello MasterClass!");

	}
	
	public void run(String... args) throws Exception {
		
		System.out.println("=============");
		System.out.println(hello.getMsg());
		System.out.println("=============");
	}
	
}
