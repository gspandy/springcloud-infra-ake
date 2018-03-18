package vehicleservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vehicleservice.service.UserMgmtServiceBreaker;
import vehicleservice.service.UserMgmtServiceClient;
import vehicleservice.service.VehicleMgmtService;

/**
 * Created by mujiang on 2017/9/12.
 */

@Configuration
@RestController
public class VehicleMgmtController {

    private Logger logger = LoggerFactory.getLogger(VehicleMgmtController.class);


    @Autowired
    private VehicleMgmtService carMgmtService;

    @Autowired
    private UserMgmtServiceClient userMgmtServiceClient;

    @Autowired
    private UserMgmtServiceBreaker userMgmtServiceBreaker;


    @GetMapping(value= "/users/{userid}/cars/{carid}")
    public String  getCarInfo(@PathVariable String userid, @PathVariable String carid){

        logger.info("Enter getCarInfo controller");

        String userinfo = userMgmtServiceClient.getUserInfo(userid);

        String carinfo = carMgmtService.getCarInfo(carid);

        String output = "user "+ userinfo + "'s car is " + carinfo;

        return output;

     }


    @GetMapping(value= "/users/{userid}/cars/{carid}/stable")
    public String  getCarInfoWithBreaker(@PathVariable String userid, @PathVariable String carid){

        logger.info("Enter getCarInfo controller");

        String userinfo = userMgmtServiceBreaker.getUserInfo(userid);

        String carinfo = carMgmtService.getCarInfo(carid);

        String output = "user "+ userinfo + "'s car is " + carinfo;

        return output;

    }




}
