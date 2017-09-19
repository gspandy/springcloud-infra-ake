import de.codecentric.boot.admin.config.EnableAdminServer;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */


@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@RefreshScope

public class AdminServerApplication {

	private static final Logger LOG = Logger.getLogger(AdminServerApplication.class.getName());
	


//	@Bean
//	public AlwaysSampler defaultSampler() {
//		return new AlwaysSampler();
//	}

    public static void main( String[] args )
    {
//    	System.out.print("+++++++++++++"+new ConfigRead().getName());
        SpringApplication.run(AdminServerApplication.class, args);

    }
}
