package com.luyuze.missyou.core.configuration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class AutoPrefixConfiguration implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return null;
    }
}
