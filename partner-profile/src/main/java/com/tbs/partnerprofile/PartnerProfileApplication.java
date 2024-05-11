package com.tbs.partnerprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PartnerProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerProfileApplication.class, args);
	}

}
