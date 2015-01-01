package aladdin.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.AnnotationConfiguration;


@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue		
	private Long id;
	private String categoryName;
	private String categoryDescription;
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Product.class)
	private List<Product> products;
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
public static void main(String[] Args)
	{
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(ProductCategory.class);
		
		config.configure();
		new SchemaExport(config).create(true, true);
	}
}
