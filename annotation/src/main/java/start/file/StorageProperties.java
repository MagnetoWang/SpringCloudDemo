package start.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("storage")
@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "D:\\wangzixian002\\Documents\\Tencent Files\\542573612\\FileRecv\\软件工程报告";
    public static String PUBLIC_LOCATION = "D:\\wangzixian002\\Documents\\Tencent Files\\542573612\\FileRecv\\软件工程报告";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}