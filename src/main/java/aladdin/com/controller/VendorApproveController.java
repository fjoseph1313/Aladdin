package aladdin.com.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.MailMail;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.VendorDAO;
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
		
		Vendor vendor = vDao.findByPrimaryKey(id);
		
		String fullName = vendor.getFirstName() + " " + vendor.getLastName();
		String emailAddress = vendor.getEmailAddress();
		
		String emailSubject = "Account Activated";
		String emailBody = "Welcome " + fullName + ",\n\n"
				+ "Your account is already activated to Aladdin.\n\n";
				
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	MailMail mm = (MailMail) context.getBean("mailMail");
    	mm.sendMail("Aladdin <aladdin.mscs@gmail.com>", emailAddress, "aladdin.mscs@gmail.com", emailSubject, emailBody);
    	
		vDao.commitTransaction();
		return "redirect:/vendor/";
	}

}
