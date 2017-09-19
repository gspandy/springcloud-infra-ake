package server.authUtil;
//
//import org.springframework.entity.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
///**
// * Created by epcm on 2017/6/23.
// */
//
//
//@Configuration
//@EnableWebSecurity
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
////    @Bean
////    public ClientUserDetailsService springDataUserDetailsService() {
////        System.out.println("~~~~~~~~~~: Bingo! enter defined Auth service! ");
////        return new ClientUserDetailsService();
////    }
//
//
//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                // 设置UserDetailsService
//                .userDetailsService(this.userDetailsService);
////                .passwordEncoder(passwordEncoder());
//    }
//
////    // 装载BCrypt密码编码器
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//////    @Override
//////    protected void configure(HttpSecurity httpSecurity) throws Exception {
//////        httpSecurity
//////                // 由于使用的是JWT，我们这里不需要csrf
//////                .csrf().disable()
//////
//////                // 基于token，所以不需要session
//////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//////
//////                .authorizeRequests()
//////                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//////
//////                // 允许对于网站静态资源的无授权访问
//////                .antMatchers(
//////                        HttpMethod.GET,
//////                        "/",
//////                        "/*.html",
//////                        "/favicon.ico",
//////                        "/**/*.html",
//////                        "/**/*.css",
//////                        "/**/*.js"
//////                ).permitAll()
//////                // 对于获取token的rest api要允许匿名访问
//////                .antMatchers("/auth/**").permitAll()
//////                // 除上面外的所有请求全部需要鉴权认证
//////                .anyRequest().authenticated();
//////
//////        // 禁用缓存
//////        httpSecurity.headers().cacheControl();
//////    }
////
//
//}