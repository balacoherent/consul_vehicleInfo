package com.springconsul.userservice.Controller;

import com.springconsul.userservice.UserServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@EnableDiscoveryClient
@RestController
public class UserServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/getAll")
    public String invokeAddressDetail(){
        URI uri = discoveryClient.getInstances("vehiclelInfo")
                .stream().map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map(s -> s.resolve("/user/getAll")).get();
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping("/getAllLoad")
    public String getLoad(){
        URI uri = discoveryClient.getInstances("vehiclelInfo")
                .stream().map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map(s -> s.resolve("/loads/getAllLoad")).get();
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping("/vehicleId/{id}")
    public String getVehicle(){
        URI uri = discoveryClient.getInstances("vehiclelInfo")
                .stream().map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map(s -> s.resolve("/vehicle/vehicleId/{id}")).get();
        return restTemplate.getForObject(uri, String.class);
    }

    @GetMapping("/getAllType")
    public String getVehicleType(){
        URI uri = discoveryClient.getInstances("vehiclelInfo")
                .stream().map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map(s -> s.resolve("/vehicleType/getAllType")).get();
        return restTemplate.getForObject(uri, String.class);
    }

}
