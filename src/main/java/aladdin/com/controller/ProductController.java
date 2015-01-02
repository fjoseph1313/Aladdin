package aladdin.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@RequestMapping
	public String landingPage() {

		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct() {

		return "addProduct";
	}

}
