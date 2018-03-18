package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
//@EnableDiscoveryClient


public class ZipkinServerApplication {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}