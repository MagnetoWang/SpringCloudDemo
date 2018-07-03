package start.ConfigurationProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrintUser {
    private static final Logger logger = LoggerFactory.getLogger(PrintUser.class);
    @Autowired
    private UserProperties userProperties=new UserProperties();
    @RequestMapping("/userProperties")
    public String print(){

        int i=0;
        while (i<5){
            logger.info(userProperties.getAccount());
            logger.info(userProperties.getName());
            i++;
        }
        return userProperties.toString();

    }
}
