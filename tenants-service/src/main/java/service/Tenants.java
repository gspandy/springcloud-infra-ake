package service;

import feign.Headers;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients

public class Tenants {


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(Tenants.class, args);

	}


	@Configuration
	public class FeignClientConfiguration {
		@Bean
		public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
			return new BasicAuthRequestInterceptor("admin", "123456");
		}
	}


	@FeignClient(name="app-service", configuration = FeignClientConfiguration.class)

	public interface AppInfoClient{
		@Headers("MSP-AppKey: {appkey}")
		@RequestMapping(value = "/apps/{appID}" , method = RequestMethod.GET)
		public String getAppInfo(@PathVariable("appID") String appID, @RequestHeader("MSP-AppKey") String appkey) ;
	}



}
