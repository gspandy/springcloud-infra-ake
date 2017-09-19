package service;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;


/**
 * Created by epcm on 2017/6/22.
 */

@RestController
@EnableFeignClients
public class SidecarServiceController {



//    @RequestMapping(value="/app-service/apps/{appID}" , method= RequestMethod.GET)
//    public String showApp( @PathVariable String appID){
//
////        Timestamp now = new Timestamp(System.currentTimeMillis());
////		System.out.println("~~~~~~  now:   "+ now.getTime() );
//
//
//
//        System.out.println("~~~~~~  app:   "+appID);
//        String appIDappInfo = "AAAAA";
////        appInfo=restTemplate.getForObject("/tenants/"+tenantID, String.class);
//        return "~~~~~~  app:   "+ appID;
//
//    }


    @GetMapping(value="health")
    public String healthCheck( ){

        String status = "{\\\"status\\\": \\\"UP\\\" }"  ;

        System.out.println(status);

        return status;

    }


    @GetMapping(value="/movies/{movieID}" )
    public String showAppInfo(@PathVariable String movieID){

        System.out.println("~~~~~~  app:   "+movieID);
        String appInfo = "Sidecar-serviceB: This is" + movieID + " 's detail";


        return appInfo;

    }
}
