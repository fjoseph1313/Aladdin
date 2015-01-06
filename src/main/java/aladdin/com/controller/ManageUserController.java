package aladdin.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.PersonDAO;
import aladdin.com.model.Person;

@Controller
@RequestMapping("/user")

public class ManageUserController {
	
	private DAOFactory factory = DAOFactory.getFactory();
	private PersonDAO pDao = factory.getPersonDAO();
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(Model model) {
		pDao.beginTransaction();
		List<Person> list= pDao.getPerson();
		model.addAttribute("lists", list);
		pDao.commitTransaction();
		return "userList";
		
	}
	@RequestMapping(value="/user/status/{id}&&{flag}", method = RequestMethod.GET)
	public String setStatusPersonById(@PathVariable Long id,@PathVariable Boolean flag,  Model model){
		
		System.out.print(flag);
		pDao.beginTransaction();
		pDao.activatePerson(id,flag);
		List<Person> list= pDao.getPerson();
		model.addAttribute("lists", list);
		pDao.commitTransaction();
		return "redirect:/user/";
	}
}
