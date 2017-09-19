package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by epcm on 2017/6/22.
 */


@RestController
@EnableFeignClients
@Configuration

public class AppController {

    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);

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




    @ApiName("getAPP")
    @RequestMapping(value="/apps/{appID}" , method=RequestMethod.GET)
    public String showAppInfo(@PathVariable String appID){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        System.out.println("APP-service: ~~~~~~  app:   "+appID);
        String appInfo = appID+"'s detail";

        LOG.info("{ \"uri\": \" " + uri +" \" ,  \"method\" : \""+method+"\" }" );
//        L.info("method:  " + method);

//        L.info("appID:  " + appID);
//        L.info("trace:  " + "%X{X-B3-TraceId:-}");


        return appInfo;

    }



    @Autowired
    private Apps.BookInfoClient bookInfoClient;

    @RequestMapping(value="/sidecar/books/{bookID}" , method=RequestMethod.GET)
    public String callSidecarService(@PathVariable String bookID){

        System.out.println("Call sidecar-service: ~~~~~~  book:   "+bookID);

        String bookInfo = bookInfoClient.getBookInfo(bookID) +": this is from app service";

        return bookInfo;

    }

}
