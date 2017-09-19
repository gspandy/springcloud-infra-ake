package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by epcm on 2017/6/22.
 */

@RestController
public class TenantController {

    @Autowired
    private Tenants.AppInfoClient appInfoClient;

    @RequestMapping(value="/tenants/{tenantID}/apps/{appID}" , method=RequestMethod.GET)
    public String showApp(@PathVariable String tenantID, @PathVariable String appID){

        System.out.println("~~~~~~tenant:  "+tenantID+"   app:   "+appID);


        String appInfo = appInfoClient.getAppInfo(appID, "DDFD456ASFADFDS5AFDDSF");


        return "~~~~~~ tenant : "+tenantID+"   ||||    and app detail  : "+ appInfo;

    }




//    @Autowired
//    private EurekaClient discoveryClient;
//
//    public String serviceUrl() {
//        InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
//        return instance.getHomePageUrl();
//    }

}
