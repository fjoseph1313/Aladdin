package aladdin.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.ProductCategoryDAO;
import aladdin.com.model.ProductCategory;


@Controller
public class ProductCategoryController {

	DAOFactory factory = DAOFactory.getFactory();
	ProductCategoryDAO  pcDao = factory.getProductCategoryDAO();
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/categories";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String getAll(Model model) {
		pcDao.beginTransaction();
		List<ProductCategory> categories = pcDao.findAll(0, 100);
		model.addAttribute("categories", categories);
		pcDao.commitTransaction();
		return "categoryList";
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String registerCategory(ProductCategory category)
	{
		pcDao.beginTransaction();
		pcDao.save(category);
		pcDao.commitTransaction();
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/categories/delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable Long id)
	{
		pcDao.beginTransaction();
		ProductCategory cat = (ProductCategory) pcDao.findByPrimaryKey(id);
		pcDao.delete(cat);
		pcDao.commitTransaction();
		return "redirect:/categories";
	}
}
