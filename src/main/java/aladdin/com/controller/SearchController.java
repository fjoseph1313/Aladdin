package aladdin.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import aladdin.com.HibernateUtil;
import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.dao.ProductDAOImpl;
import aladdin.com.model.Product;
import aladdin.com.model.ProductCategory;

@Controller
public class SearchController {

	@Autowired
	private ProductDAOImpl productDAO;
	@Autowired
	private ProductCategoryDAOImpl productCategoryDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	@RequestMapping(value = "/search")
	public String search(Model model) {

		productCategoryDAO.beginTransaction();
		List<ProductCategory> productcategoryList = productCategoryDAO.findAll(
				0, 1000);
		productCategoryDAO.commitTransaction();
		model.addAttribute("productcategoryList", productcategoryList);
		return "search";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String showImage(@RequestParam("pKey") String key,
			@RequestParam("pCat") String cat, HttpServletResponse response,
			HttpServletRequest request, Model model) throws ServletException,
			IOException {

		productDAO.beginTransaction();
		String hql = "FROM Product p WHERE p.productName LIKE :searchKey AND p.productCategory.categoryName = :searchCat";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("searchKey", "%" + key + "%");
		query.setParameter("searchCat", cat);
		List<Product> ps = query.list();
		productDAO.commitTransaction();

		List<String> b64Images = new ArrayList<String>();
		for (Product p : ps) {
			b64Images.add(b64Converter(p.getProductImage()));
		}

		model.addAttribute("b64s", b64Images);

		return "search";
	}

	// this can be a service
	public String b64Converter(byte[] bytes) throws IOException {

		BufferedImage bufferedImage = null;
		try {
			InputStream inputStream = new ByteArrayInputStream(bytes);
			bufferedImage = ImageIO.read(inputStream);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", baos);
		baos.flush();
		byte[] imageInByteArray = baos.toByteArray();
		baos.close();
		return javax.xml.bind.DatatypeConverter
				.printBase64Binary(imageInByteArray);
	}

}
