package com.river.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
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

		/**
		 * Annotation @Configuration
		 * SpringBoot in the first run: find Component + find class Configuration
		 * Create instance of class is marked @Configuration
		 * Store Bean to context
		 */
		//Demo @Bean (difference @Component)
		SimpleBean simpleBean = context.getBean(SimpleBean.class);
		System.out.println("Simple Bean Example: "+simpleBean.toString());

		//Can replace by @Autowire in difference class
		RiverAppProperties riverAppProperties = context.getBean(RiverAppProperties.class);
		System.out.println("Global variable:");
		System.out.println("\t Email: " + riverAppProperties.getEmail());
		System.out.println("\t GA ID: " + riverAppProperties.getGoogleAnalyticsId());
		System.out.println("\t Authors: " + riverAppProperties.getAuthors());
		System.out.println("\t Example Map: " + riverAppProperties.getExampleMap());

	}
}
