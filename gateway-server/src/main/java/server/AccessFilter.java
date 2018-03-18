package server;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.apache.RibbonApacheHttpRequest;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by chenxl7 on 2017/10/10.
 */
@RefreshScope
public class AccessFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(getClass().getName());


	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String userType = request.getHeader("UserType");
		if(userType != null ){
			return true;
		}else {
			return false;
		}
	}


	@Override
	public Object run() {

//0. 获取 request拦截到的 URL请求 及日志内容初始化

		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();

//		String requestURI = request.getRequestURI().toString();
//		String appKey = request.getHeader("MSP-AppKey");
//		String authKey = request.getHeader("MSP-AuthKey");


		if (request.getHeader("UserType").equals("gray") ) {
			RibbonFilterContextHolder.getCurrentContext()
					.add("lancher", "gray");
		}

		return null;
	}

}
