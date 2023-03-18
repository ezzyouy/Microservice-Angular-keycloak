package org.sid.billingservice.sec;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FeignClientInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    public static String getBearerTokenHeader(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {

    requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
    }
}
