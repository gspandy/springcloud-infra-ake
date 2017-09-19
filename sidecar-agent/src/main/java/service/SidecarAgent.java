package service;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;


@SpringBootApplication
@EnableSidecar
@EnableCircuitBreaker

public class SidecarAgent {


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(SidecarAgent.class, args);

	}


	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new RequestFilter());
		System.out.println("output from filterregistration");
		registration.addUrlPatterns("/*");
		return registration;
	}


	@Configuration
	public class HystrixConfiguration {

		//注册Hystrix框架的拦截器，使得框架的注解能够生效
		@Bean
		public HystrixCommandAspect hystrixAspect() {
			return new HystrixCommandAspect();
		}

		//注入servlet,拦截url="/books"
		//测试git dev commit
		@Bean
		public ServletRegistrationBean hystrixMetricsStreamServlet() {
			System.out.print("++++++++++++++***************");
			ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
			registration.addUrlMappings("/books");
			return registration;
		}
	}




}
