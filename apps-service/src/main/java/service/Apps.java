package service;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;


@SpringBootApplication
@EnableEurekaClient

public class Apps {


//	private static final Logger LOG = LoggerFactory.getLogger(Apps.class);

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Apps.class);

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

//		PropertyConfigurator.configure("log4j2.properties");
//		PropertyConfigurator.configure( PropertyConfigurator.class.getResource("log4j2.properties") );

		LOG.info("{ ********************* }" );

		SpringApplication.run(Apps.class, args);

	}

//	@Bean
//	public FilterRegistrationBean testFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean(new ServerRequestAuthFilter());
//		System.out.println("output from internal filter");
//		registration.addUrlPatterns("/apps/*");
//		return registration;
//	}



	@FeignClient(name="sidecar-agent")
	public interface BookInfoClient{
		@RequestMapping(value = "/books/{bookID}" , method = RequestMethod.GET)
		public String getBookInfo(@PathVariable("bookID") String id) ;
	}


}
