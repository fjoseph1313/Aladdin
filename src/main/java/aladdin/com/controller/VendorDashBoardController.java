package aladdin.com.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.AdminDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.VendorDAO;
import aladdin.com.model.Admin;
import aladdin.com.model.Vendor;

@Controller
@RequestMapping(value = "/vendor", method = RequestMethod.GET)
public class VendorDashBoardController {

	private DAOFactory factory = DAOFactory.getFactory();
	private VendorDAO vDao = factory.getVendorDAO();

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest  request) {
		
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		vDao.beginTransaction();
		Vendor vendor = vDao.findVendorByEmail(auth.getName());
		HttpSession session = request.getSession(true); // create a new session		
		session.setAttribute("userDetails", vendor);
		session.setAttribute("userType", vendor.getClass().getSimpleName());
		//admin.getFirstName()
		vDao.commitTransaction();
		//System.out.println(principal);
		//System.out.println(session);			
		return "dashBoardVendor";
	}

}
