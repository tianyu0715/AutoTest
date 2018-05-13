package org.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application {
	
	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		Application.context = SpringApplication.run(Application.class, args);
	}
	
	public void close() {
		Application.context.close();
	}
}
