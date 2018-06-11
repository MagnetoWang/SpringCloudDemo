package com.magnetowang.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@PropertySource(value={"classpath:bootstrap.properties"})
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

//    @Value("#{config['foo']}")
    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
//     @Bean
//     public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//         PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//         c.setIgnoreUnresolvablePlaceholders(true);
//         return c;
//     }
}
