package server.authUtil;

/**
 * Created by epcm on 2017/6/22.
 */



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ClientRegisterAuthFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.println("doFilter");
//        System.out.printf(arg0.getRemoteAddr());

        System.out.println(arg0.getRemotePort());

//        System.out.println(arg0.getParameterNames());

        HttpServletRequest httpServletRequest = (HttpServletRequest)arg0;

        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getMethod());
//        System.out.println(httpServletRequest.getParameterNames());
        System.out.println("-----------done-----------");

//        if(httpServletRequest.getRequestURI().contains("/eureka/apps/APP-SERVICE") )
//            throw new ServletException("403: unAuthed appname or IP! ");

        arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}