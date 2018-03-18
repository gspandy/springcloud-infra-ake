package vehicleservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mujiang on 2018/3/16.
 */
@Component
@FeignClient(name="user-service")
public interface UserMgmtServiceClient {
    @RequestMapping(value = "/users/{userid}" , method = RequestMethod.GET)
    String getUserInfo(@PathVariable("userid") String userid ) ;

    @RequestMapping(value = "/users/{userid}/unstable" , method = RequestMethod.GET)
    String getUserInfoByUnstable(@PathVariable("userid") String userid ) ;
}