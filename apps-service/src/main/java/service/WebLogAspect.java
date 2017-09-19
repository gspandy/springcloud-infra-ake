//package service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.Enumeration;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Aspect
//@Component
//public class WebLogAspect {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private static final ThreadLocal<Map> map = new ThreadLocal<Map>( ) {
//        @Override
//        protected Map initialValue() {
//            return new LinkedHashMap( );
//        }
//    };
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    @Pointcut("execution(public * service.*.*(..))")
//    public void webLog(){}
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String uri = request.getRequestURI();
//        String method = joinPoint.getSignature().getName();
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature)signature;
//        Method targetMethod = methodSignature.getMethod();
//        //获取参数
//        if ("get".equalsIgnoreCase(method)||"delete".equalsIgnoreCase( method )){
//            Map params = new LinkedHashMap();
//            Enumeration<String> enu=request.getParameterNames();
//            while(enu.hasMoreElements()){
//                String paraName= enu.nextElement();
//                params.put(paraName,request.getParameter(paraName));
//            }
//            map.get( ).put("RequestParameters",params);
//        }else{
//            WebLogAspect.map.get( ).put( "RequestParameters",mapper.writeValueAsString(joinPoint.getArgs()));
//        }
//        map.get( ).put("Tenant",splitURI(uri,"tenants"));
//        map.get( ).put("App",splitURI(uri,"apps"));
//        String service = splitURI(uri,"service");
//        String serviceName = (service ==null || "".equals(service)) ? splitURI(uri,"services"):service;
////        map.put("Service",serviceName);
//        map.get( ).put("Service","APP-service");
//        map.get( ).put("URI",uri);
//        map.get( ).put("ClientIp",request.getRemoteAddr());
//        map.get( ).put("Server", request.getLocalAddr());
//        map.get( ).put("ServerPort",request.getServerPort());
//        map.get( ).put("RequestMethod",request.getMethod().toUpperCase());
//        map.get( ).put("Logger",joinPoint.getSignature().getDeclaringTypeName());
//        map.get( ).put("Method",method);
//        ApiName annotation = targetMethod.getAnnotation( ApiName.class );
//        String value = annotation.value( );
//        map.get( ).put("apiName",value);
//        map.get().put("trace","%X{X-B3-TraceId:-}");
//        map.get().put("span","%X{X-B3-SpanId:-}");
//    }
//
//    @AfterReturning(returning = "responseEntity", pointcut = "webLog()")
//    public void doAfterReturning(ResponseEntity responseEntity) throws Throwable {
//
//        int status = responseEntity.getStatusCode().value();
//        map.get( ).put("ResponseStatus", status);
//        if (status==500){
//            map.get( ).put("Exception",responseEntity.getBody());
//        }
//        logger.info("&&&"+mapper.writeValueAsString( map.get( ) ));
//    }
//
//    //解析URI
//    public String splitURI(String uri,String split){
//        String[] arrs = uri.split(split+"/");
//        if (arrs.length<2)
//            return "";
//        return arrs[1].split("/")[0];
//    }
//
//}
