package service;

/**
 * Created by epcm on 2017/6/22.
 */

/*

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public class ServerRequestAuthFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.println("begin Filter");
        System.out.println(arg0.getRemoteAddr());
        System.out.println(arg0.getRemotePort());

        Map pm = arg0.getParameterMap();
        Iterator<Map.Entry<String, String>> entries = pm.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest)arg0;

        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getMethod());
        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        while(headers.hasMoreElements()){
            System.out.println("params in  header: "+headers.nextElement());
        }

        System.out.println("header of msp-appkey: >>>>>>>>>  "+httpServletRequest.getHeader("msp-appkey"));






//        System.out.println(httpServletRequest.getParameterNames());
        System.out.println("-----------done-----------");

//        this.destroy();

        arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}

*/