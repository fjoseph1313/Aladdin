package aladdin.com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.dao.ProductDAOImpl;
import aladdin.com.model.Product;
import aladdin.com.model.ProductCategory;

/**
 * Handles requests for the application file upload requests
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductDAOImpl productDAO;
	@Autowired
	private ProductCategoryDAOImpl productCategoryDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	/**
	 * Upload single file using Spring Controller
	 */

	@RequestMapping
	public String getProductPage() {

		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {

		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		System.out.print(newProduct);
		productCategoryDAO.beginTransaction();
		List<ProductCategory> productcategoryList = productCategoryDAO.findAll(
				0, 1000);
		productCategoryDAO.commitTransaction();
		model.addAttribute("productcategoryList", productcategoryList);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(
			@ModelAttribute("newProduct") Product newProduct,
			BindingResult result) {

		byte[] bytes = newProduct.byteConversion(newProduct
				.getMultiPartToByte());
		newProduct.setProductImage(bytes);
		System.out.println(newProduct.getProductCategory());
		productDAO.beginTransaction();
		productDAO.save(newProduct);
		productDAO.commitTransaction();
		return "redirect:/product";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategory(Model model) {

		ProductCategory newCategory = new ProductCategory();

		model.addAttribute("newCategory", newCategory);

		return "addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String ProcessAddCategoryFrom(
			@ModelAttribute("newCategory") ProductCategory newCategory,
			BindingResult result) {

		productCategoryDAO.beginTransaction();
		productCategoryDAO.save(newCategory);
		productCategoryDAO.commitTransaction();
		return "redirect:/product";
	}

	// @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String uploadFileHandler(
	//
	// @RequestParam("file") MultipartFile file,
	// @RequestParam("productName") String pName,
	// @RequestParam("productDescription") String pDesc,
	// @RequestParam("price") Double pprice,
	// @RequestParam("quantity") Integer quantity,
	// @RequestParam("availabilty") boolean availability) {
	//
	// System.out.println(file.getOriginalFilename());
	// if (!file.isEmpty()) {
	// try {
	// byte[] bytes = file.getBytes();
	//
	// // Creating the directory to store file
	// String rootPath = System.getProperty("catalina.home");
	// File dir = new File(rootPath + File.separator + "tmpFiles");
	// if (!dir.exists())
	// dir.mkdirs();
	//
	// // Create the file on server
	// File serverFile = new File(dir.getAbsolutePath()
	// + File.separator + file.getOriginalFilename());
	// BufferedOutputStream stream = new BufferedOutputStream(
	// new FileOutputStream(serverFile));
	// stream.write(bytes);
	// stream.close();
	//
	// logger.info("Server File Location="
	// + serverFile.getAbsolutePath());
	// Product p = new Product();
	// p.setPrice(pprice);
	// p.setProductName(pName);
	// p.setProductDescription(pDesc);
	// p.setProductImage(bytes);
	// p.setProductQuantity(quantity);
	// p.setActive(availability);
	//
	// productDAO.beginTransaction();
	// productDAO.save(p);
	// productDAO.commitTransaction();
	//
	// return "product";
	// } catch (Exception e) {
	// return "You failed to upload " + file.getOriginalFilename()
	// + " => " + e.getMessage();
	// }
	// } else {
	// return "You failed to upload " + file.getOriginalFilename()
	// + " because the file was empty.";
	// }
	// }
}
