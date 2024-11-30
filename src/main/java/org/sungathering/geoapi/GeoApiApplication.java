package org.sungathering.geoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GeoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoApiApplication.class, args);
    }

}
