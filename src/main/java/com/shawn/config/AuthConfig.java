package com.shawn.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.shawn.filter.AuthFilter;

@Configuration
public class AuthConfig {

    @Bean
    public FilterRegistrationBean authFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("authFilter");
        registrationBean.setFilter(new DelegatingFilterProxy("authFilter"));
        registrationBean.setOrder(1);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/*");
        registrationBean.setUrlPatterns(urlList);
        return registrationBean;
    }

    @Bean
    public Filter authFilter() {
        return new AuthFilter();
    }

}
