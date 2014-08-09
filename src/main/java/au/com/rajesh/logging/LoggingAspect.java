package au.com.rajesh.logging;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {

	 private static final Logger LOG = Logger.getLogger(LoggingAspect.class.toString());

		 @Before("execution(* au.com.emedigital.controllers.*.*(..))" )
		 public void doLoggingBefore(JoinPoint joinPoint)  {
			 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			 LOG.info("Request :" + request.getRequestURL().toString());
		 }
	 
	 
	 	@ResponseBody
	 	@AfterReturning(pointcut="execution(* au.com.emedigital.controllers.*.*(..))", returning="result")
	    public void afterReturning(JoinPoint joinPoint , Object result ) throws JsonGenerationException, JsonMappingException, IOException  {
	 		if(result !=null){
	 		ObjectMapper mapper = new ObjectMapper();
	 		LOG.info("Response :"+  mapper.writeValueAsString(result)) ; 
	 		}
	 	}
	    
}
