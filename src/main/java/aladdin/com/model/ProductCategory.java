package aladdin.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;
	private String categoryDescription;
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Product.class)
	private List<Product> products;

	public ProductCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String toString() {

		return this.categoryName;
	}

}
