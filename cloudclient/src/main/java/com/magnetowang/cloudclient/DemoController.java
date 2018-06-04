package com.magnetowang.cloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Value("${server.port}")
    String port;

    @ResponseBody
    @RequestMapping("/hi")
    public String home( String name) {
//        System.out.println("haha");
        return "hi "+name+",i am from port:" +port;
    }
}
