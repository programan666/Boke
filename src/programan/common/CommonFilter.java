package programan.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ͨ�ù�����
 * 
 * @author Administrator
 *
 */

public class CommonFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		  HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
	        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
	        httpServletResponse.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");  
	        httpServletResponse.setHeader("Access-Control-Max-Age","3600");  
	        httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");  
	        filterChain.doFilter(servletRequest,httpServletResponse);
	}

	@Override
	public void destroy() {

	}

}