package service;

/**
 * Created by epcm on 2017/6/22.
 */


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.println("doFilter");



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