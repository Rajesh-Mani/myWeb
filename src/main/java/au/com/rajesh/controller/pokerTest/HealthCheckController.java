package au.com.rajesh.controller.pokerTest;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({"/api/healthChecker"})
@Controller
public class HealthCheckController {

	private static final Logger LOG = Logger.getLogger(HealthCheckController.class.toString());
  
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ResponseBody
	public String healthCheck(){
		return "Ok";
	}
	
}
