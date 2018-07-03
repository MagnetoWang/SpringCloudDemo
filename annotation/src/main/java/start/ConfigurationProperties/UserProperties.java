package start.ConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 参考网站
 * https://www.jianshu.com/p/df57fefe0ab7
 *https://blog.csdn.net/u010454030/article/details/78378457
 *
 *
 * 注意： 似乎静态变量才可以
 */

@Component
@PropertySource("classpath:user.properties")
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private  String name;
    private  String account;
    @Override
    public String toString(){
        return getAccount()+"  "+getName();
    }

}
