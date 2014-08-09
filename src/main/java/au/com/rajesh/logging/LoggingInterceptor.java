package au.com.rajesh.logging;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor{
	 
    private Logger LOG = Logger.getLogger(this.getClass().toString());

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
        LOG.info("Request :" + request.getRequestURL().toString());
        LOG.info("Request :" + request.toString());
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//StringBuilder msg = new StringBuilder();
		//msg.append(response.getWriter());
		//LOG.info("Response =="+ msg.toString());
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
		
		LOG.info("Response =="+ wrapper.toString());
	}
 
	
}