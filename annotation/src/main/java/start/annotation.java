package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: paste
 * @description: 测试注解类
 * @author: MagnetoWang
 * @create: 2018-08-02 14:51
 **/
@RestController
@EnableAutoConfiguration
public class annotation {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(annotation.class, args);
    }

}
