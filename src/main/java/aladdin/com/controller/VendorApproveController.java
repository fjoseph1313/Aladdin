package aladdin.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.VendorDAO;
import aladdin.com.model.ProductCategory;
import aladdin.com.model.Vendor;

@Controller
@RequestMapping("/vendor")
public class VendorApproveController {
	
	private DAOFactory factory = DAOFactory.getFactory();
	private VendorDAO vDao = factory.getVendorDAO();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(Model model) {
		vDao.beginTransaction();
		List<Vendor> list= vDao.getVendorForApproval(false);
		model.addAttribute("lists", list);
		vDao.commitTransaction();
		return "vendorList";
		
	}
	@RequestMapping(value="/vendor/edit/{id}", method = RequestMethod.GET)
	public String editVendorById(@PathVariable Long id, Model model){
		vDao.beginTransaction();
		vDao.editVendor(id);
		List<Vendor> list= vDao.getVendorForApproval(false);
		model.addAttribute("lists", list);
		vDao.commitTransaction();
		return "redirect:/vendor/";
	}

}
