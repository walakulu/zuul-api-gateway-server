package com.demo.microservice.zuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter extends ZuulFilter {

    private final static Logger LOGGER= LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public String filterType() {
        //When should the filter execute (before request or after request or when errors ?)
        return "pre";
    }

    @Override
    public int filterOrder() {
        //set priority if we have multiple filters
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //Could check evaluate weather we need to execute this filter or not
        return true;
    }

    @Override
    public Object run()  {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("Request URI : {}",request.getRequestURI());
        return null;
    }
}
