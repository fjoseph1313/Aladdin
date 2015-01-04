package aladdin.com.converter;
import java.util.List;

import org.hibernate.exception.spi.ConversionContext;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.model.ProductCategory;


public class NameToProductCategoryConverter implements Converter<String, ProductCategory> {

	 @Autowired 
	 private ProductCategoryDAOImpl productCategoryDAO;
	 
	 @Override  
	 public ProductCategory convert(String name) {
		   System.out.print("here");
		 	productCategoryDAO.beginTransaction();
			ProductCategory productcategory= productCategoryDAO.findProductCategoryByName(name);
			productCategoryDAO.commitTransaction();
	    	System.out.print("here");
	        return productcategory;
	    }

}
