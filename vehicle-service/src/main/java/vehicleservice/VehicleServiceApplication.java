package vehicleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients

public class VehicleServiceApplication {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(VehicleServiceApplication.class, args);
	}




}