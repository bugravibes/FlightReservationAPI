package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class RequestLoggingFilterConfig extends CommonsRequestLoggingFilter {

    public RequestLoggingFilterConfig() {
        super.setIncludeClientInfo(true);
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10000);
    }
}
