package casestudy.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_master")
public class Product {

	private String productName;

	private String productType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendorId", referencedColumnName = "vendorId")
	private Vendor vendor;
	private double price;
	private int currentStock;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor string) {
		this.vendor = string;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	@Id
	private String productId;

	@Override
	public String toString() {
		return "product_master [productId=" + productId + ", productName=" + productName + ", productType="
				+ productType + ", vendorId=" + vendor + ", price=" + price + ", currentStock=" + currentStock + "]";
	}

}
