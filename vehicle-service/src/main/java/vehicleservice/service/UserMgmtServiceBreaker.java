package vehicleservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vehicleservice.controller.VehicleMgmtController;

import java.util.Map;

/**
 * Created by mujiang on 2018/3/17.
 */


@Component
public class UserMgmtServiceBreaker {

    private Logger logger = LoggerFactory.getLogger(VehicleMgmtController.class);

    @Autowired
    private UserMgmtServiceClient userMgmtServiceClient;

    @HystrixCommand(fallbackMethod = "defaultUserInfo")
//    @HystrixCommand(fallbackMethod = "defaultUserInfo" ,
//                    commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000"),
//            @HystrixProperty(name = "execution.timeout.enabled", value = "true")} )
    public String getUserInfo(String userid) {
        String userinfo = userMgmtServiceClient.getUserInfoByUnstable(userid);
        logger.info("get userinfo success");
        return userinfo;
    }


    public String defaultUserInfo(String userid) {
        logger.info("user-service no response, use default username!");
        return "lady or sir";
    }

}
