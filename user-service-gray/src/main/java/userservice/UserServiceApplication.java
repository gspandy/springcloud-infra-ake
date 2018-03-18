package userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient

public class UserServiceApplication {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(UserServiceApplication.class, args);
	}

}