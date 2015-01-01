package aladdin.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.ProductCategoryDAO;


@Controller
public class ProductCategoryController {

	DAOFactory factory = DAOFactory.getFactory();
	ProductCategoryDAO  pcDao = factory.getProductCategoryDAO();
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/cars";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String getAll(Model model) {
		pcDao.beginTransaction();
		List categories = pcDao.findAll(0, 100);
		model.addAttribute("categories", categories);
		pcDao.commitTransaction();
		return "categoryList";
	}
}
