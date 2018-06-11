package com.magnetowang.configclient;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

public class ShowController {
    @Value("${sang}")
    String sang;


    @RequestMapping("/sang")
    public String sang() {
        return this.sang;
    }

}
