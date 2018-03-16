package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverServerApplication {


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(DiscoverServerApplication.class, args);
	}


}
