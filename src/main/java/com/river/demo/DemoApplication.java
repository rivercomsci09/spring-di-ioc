package com.river.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("After IoC container init");
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Before IoC container init");

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

		/**
		 * Bean Life Cycle:
		 * IoC container = ApplicationContext find Bean and init by constructor
		 * inject dependencies Bean by Setter
		 * Method mark @PostConstruct will be call
		 * Some handling after @PostConstruct
		 * Bean ready
		 * after @PreDestroy
		 * Delete Bean
		 */
//		System.out.println("After IoC Container destroy Girl");
//		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
//		System.out.println("Before IoC Container destroy Girl");
	}
}
