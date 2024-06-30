package org.itformacion.apicourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCourseApplication.class, args);
    }

}
