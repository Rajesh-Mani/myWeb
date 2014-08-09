package au.com.rajesh.controller.pokerTest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.rajesh.service.pokerTest.PokerService;
import au.com.rajesh.model.pokerTest.Card;

@RequestMapping({"/api/poker"})
@Controller
public class PokerController {
	private static final Logger LOG = Logger.getLogger(PokerController.class.toString());
	
	@Autowired
	private PokerService pokerService;
	
    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    @ResponseBody   
	public List<Card> getCards( @RequestParam("size") Integer size ){
    	LOG.log( Level.INFO, "Requested Size :"+ size);
		return pokerService.getDeck(size);
	}
    
    //Below api follows Restful definition
    @RequestMapping(value = "/cards/{size}", method = RequestMethod.GET)
    @ResponseBody   
	public List<Card> getCardsInRESTfulPattern( @PathVariable("size") Integer size ){;
		return pokerService.getDeck(size);
	}
    
}
