package com.river.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//		Outfit outfit = new Bikini();
		/**
		 * Run application
		 * Create container (SpringApplication.run(DemoApplication.class, args))
		 * Find dependentcy and store to container
		 * container = ApplicationContext
		 * depentdency = Bean (Component)
		 * @Component (new Bikini()) store to ApplicationContext.
		 */
		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);

		outfit.wear();

		/**
		 * @Autowired inject instance of Outfit into constructor Girl.
		 */
		Girl girl = context.getBean(Girl.class);

		System.out.println("Girl instance: " + girl);

		System.out.println("Girl outfit: " + girl.getOutfit());

		girl.getOutfit().wear();

	}
}
