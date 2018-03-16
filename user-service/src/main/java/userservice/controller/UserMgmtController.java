package userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mujiang on 2017/9/12.
 */

@Configuration
@RefreshScope
@RestController
public class UserMgmtController {

    @Value( "${flag}" )
    private String flag;

    @GetMapping(value= "/users/{userid}")
    public String  getUser(@PathVariable String userid){

        String output = "flag: " + flag + "\r\n" + "user: " + userid;

        return output;

     }


}
