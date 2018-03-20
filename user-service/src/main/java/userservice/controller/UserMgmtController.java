package userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.service.UserMgmtService;

import java.util.Random;

/**
 * Created by mujiang on 2017/9/12.
 */

@Configuration
@RefreshScope
@RestController
@RequestMapping("/users")
public class UserMgmtController {

    private Logger logger = LoggerFactory.getLogger(UserMgmtController.class);


    @Value( "${flag}" )
    private String flag;

    @Autowired
    private UserMgmtService userMgmtService;

    @GetMapping(value= "/{userid}")
    public String  getUser(@PathVariable String userid){

        logger.info("Enter getUserInfo controller");

        String userinfo = userMgmtService.getUserInfo(userid);

        String output = userinfo;

        return output;

     }

    @GetMapping(value= "/{userid}/unstable")
    public String  getUserByUnstable(@PathVariable String userid){
        String userinfo = "";

        logger.info("Enter getUserInfo controller");
        try {
            Thread.sleep(3000);
            userinfo = userMgmtService.getUserInfo(userid);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userinfo;
    }

    @GetMapping(value= "/flag")
    public String  getFlag(){

        if(flag ==null ){
            flag = "=null";
        }

        return flag + " - " + new Random().nextInt(100);
    }


}
