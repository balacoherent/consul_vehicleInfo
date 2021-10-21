package com.vehicleManagement.vehicleInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VehicleInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleInfoApplication.class, args);
	}

}
