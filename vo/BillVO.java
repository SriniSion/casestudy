package casestudy.vo;

import java.util.Iterator;

import casestudy.ListWrapperClass;

public class BillVO {
	String customerID;
	String prodictID;
	String productName;
	String productType;
	double price;
	int quantity;
	String date;
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getProdictID() {
		return prodictID;
	}
	public void setProdictID(String prodictID) {
		this.prodictID = prodictID;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
