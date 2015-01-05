package aladdin.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.AdminDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.model.Admin;

@Controller
@RequestMapping(value = "/admin")
public class AdminDashBoardController {

	private DAOFactory factory = DAOFactory.getFactory();
	private AdminDAO aDao = factory.getAdminDAO();

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest  request) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    aDao.beginTransaction();
		Admin admin = aDao.findAdminByEmail(auth.getName());
		//System.out.println(admin.getClass().getSimpleName() +"..........");
		HttpSession session = request.getSession(true); // create a new session		
		session.setAttribute("userDetails", admin);
		session.setAttribute("userType", admin.getClass().getSimpleName());
		aDao.commitTransaction();
		return "dashBoardAdmin";
	}
}
