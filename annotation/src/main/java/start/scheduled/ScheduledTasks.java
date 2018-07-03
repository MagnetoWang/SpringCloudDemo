package start.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试Scheduled注解的定时功能
 * 参考链接 ： https://www.jianshu.com/p/ef18af5a9c1d
 * https://logback.qos.ch/manual/layouts.html
 *疑问： 难道要在同一个包才能运行
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public final static long ONE_Minute =  60 * 1000;
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));

    }

    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println(new Date()+" >>fixedDelay执行....");

    }

    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println((new Date())+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
        System.out.println((new Date())+" >>cron执行....");
    }


}
