package com.example.microservicesConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class MicroservicesConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesConfigurationApplication.class, args);
	}

}

//@Repository
//@Profile("production")
//public class DataSourceBean {
//	
//}
//
//@Repository
//@Profile("dev")
//public class LocalDataSourceBean {
//	
//}
