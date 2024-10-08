package com.ssamz.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TimeCheckFilter
 */
@WebFilter(urlPatterns = "*.do")
public class TimeCheckFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TimeCheckFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("===> TimeCheckFilter 생성");
    }
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---> init() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long startTime = System.currentTimeMillis();
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		System.out.println(path + "서블릿 수행에 소요된 시간 : " + (endTime - startTime) + "(ms)초");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---> destroy() 호출");
	}
}
