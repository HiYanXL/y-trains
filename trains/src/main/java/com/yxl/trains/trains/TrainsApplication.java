package com.yxl.trains.trains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:styles1.xml")
@SpringBootApplication
public class TrainsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainsApplication.class, args);
    }

}
