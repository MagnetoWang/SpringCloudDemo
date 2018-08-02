package get.up.spring.boot.I.am.angry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloudDemo
 * @description: 我只要一个启动类
 * @author: MagnetoWang
 * @create: 2018-08-02 18:46
 **/
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class onlyOneApplication {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(onlyOneApplication.class, args);
    }
}
