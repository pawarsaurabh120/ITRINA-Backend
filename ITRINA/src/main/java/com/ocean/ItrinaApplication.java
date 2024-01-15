package com.ocean;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
@EnableEurekaClient
public class ItrinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItrinaApplication.class, args);
	}
//	@Bean
//	 public OpenAPI openApiInformation() {
//	  Server localServer = new Server()
//	                      .url("http://localhost:8081")
//	                      .description("Localhost Server URL");
//
//	  Contact contact = new Contact()
//	                    .email("tulsisethiya@gmail.com")
//	                    .name("Tulsi Sethiya");
//
//	  Info info = new Info()
//	              .contact(contact)
//	              .description("Spring Boot 3 + Open API 3")
//	              .summary("")
//	              .title("ITRINA")
//	              .version("V1.0.0")
//	              .license(new License().name("Apache 2.0").url("http://ITRINA"));
//
//	  return new OpenAPI().info(info).addServersItem(localServer);
//	 }

}
