package aladdin.com.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String productName;
	private String productDescription;
	private Double price;
	private boolean activeState;

	@Transient
	private MultipartFile multiPartToByte;
	@Transient
	private String byteString;
	@Lob
	private byte[] productImage;
	private Integer productQuantity;
	@ManyToOne
	@JoinColumn(name = "productCat")
	private ProductCategory productCategory;
	@OneToMany(mappedBy = "product", targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cart> cart; // cart as order_details

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}


	public boolean isActiveState() {
		return activeState;
	}

	public void setActiveState(boolean activeState) {
		this.activeState = activeState;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public MultipartFile getMultiPartToByte() {
		return multiPartToByte;
	}

	public void setMultiPartToByte(MultipartFile multiPartToByte) {
		this.multiPartToByte = multiPartToByte;
	}

	public String getByteString() {
		return byteString;
	}
	
	public void setByteString(String byteString) {
		this.byteString = byteString;
	}
	
	public byte[] byteConversion(MultipartFile m) {

		try {
			byte[] bytes = m.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ m.getOriginalFilename());
			BufferedOutputStream stream;

			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			return bytes;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
