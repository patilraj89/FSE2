package com.estock.zull.api.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter{
	
	public static Logger log = LoggerFactory.getLogger(PreFilter.class);

	
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object run() throws ZuulException {
		RequestContext con = RequestContext.getCurrentContext();
		HttpServletRequest req = con.getRequest();
		log.info("PreFilter:"+String.format("%s request to %s", req.getMethod(),req.getRequestURI().toString()));
		return null;
	}

	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
