package org.itformacion.apicourse.client;


import lombok.Getter;
import lombok.Setter;
import org.itformacion.apicourse.config.FeingConfig;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="api-student")
//@LoadBalancerClient(value="api-student", configuration = FeingConfig.class)
public interface StudentClient {

    @GetMapping("/api/v1/students/{id}")
    Student getById(@PathVariable Long id) ;


    @Getter
    @Setter
    class Student {
        private Long studentId;
        private String name;
        private String lastName;
    }

}
