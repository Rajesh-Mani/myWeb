package au.com.rajesh.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/register")
public class RegistrationController {
	Logger log = Logger.getLogger(RegistrationController.class.getName());

	@RequestMapping(value="/new",  method=RequestMethod.GET)		
	public String  getRegister(){
		log.info("new registration");
		return "Registration";
	}
	
	@RequestMapping(value="/save",  method=RequestMethod.POST, headers = "Accept=application/json")		
	@ResponseBody
	public ResponseEntity<String>  register(@RequestBody final String json){
		log.info("json =="+ json);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}
}
