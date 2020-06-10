package com.luyuze.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("com.luyuze.missyou.api")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            this.getPrefix(handlerType);
        }
        return null;
    }

    private String getPrefix(Class<?> handlerType) {
        String packageName = handlerType.getPackage().getName();
        packageName.replaceAll(this.apiPackagePath, "");
//        return dotPath.replace(".", "/");
        return null;
    }
}
