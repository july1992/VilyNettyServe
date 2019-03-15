package com.vily.demo3.config;

import com.vily.demo3.config.api.CustomRequestMappingHandlerMapping;
import com.vily.demo3.interceptor.ApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-03-15
 *  
 **/

public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public ApiInterceptor interceptor(){
        return new ApiInterceptor();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new ApiInterceptor());
    }
    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

}
