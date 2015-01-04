package aladdin.com.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/vendor", method = RequestMethod.GET)
public class VendorDashBoardController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String adminLogin(Locale locale, Model model) {
		
		

		return "dashBoardVendor";
	}
	
	
	

}
