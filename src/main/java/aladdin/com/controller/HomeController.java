package aladdin.com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.dao.ProductDAOImpl;
import aladdin.com.model.Product;
import aladdin.com.model.ProductCategory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private ProductCategoryDAOImpl productCategoryDAO;
	@Autowired
	private ProductDAOImpl productDAO;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		productCategoryDAO.beginTransaction();
		List<ProductCategory> productcategoryList = productCategoryDAO.findAll(
				0, 1000);
		productCategoryDAO.commitTransaction();

		productDAO.beginTransaction();

		List<Product> resultList = new ArrayList<Product>();
		List<Product> randomProductList = productDAO.findRandomProducts();
		productDAO.commitTransaction();

		for (Product p : randomProductList) {
			try {
				p.setByteString(b64Converter(p.getProductImage()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultList.add(p);
		}

		model.addAttribute("randomProductList", resultList);
		httpSession.setAttribute("productcategoryList", productcategoryList);
		return "index";
	}

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
