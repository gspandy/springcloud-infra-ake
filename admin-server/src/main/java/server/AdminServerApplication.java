package server;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
//@EnableAutoConfiguration
public class AdminServerApplication {

    public static void main( String[] args )
    {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
