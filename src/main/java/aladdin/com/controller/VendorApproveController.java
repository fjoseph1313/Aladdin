package aladdin.com.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;

import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.VendorDAO;

@Controller
@RequestMapping("/vendor")
public class VendorApproveController {
	
	private DAOFactory factory = DAOFactory.getFactory();
	private VendorDAO vDao = factory.getVendorDAO();
	
	
	

}
