package casestudy.vo;

import java.util.List;

public class StockReport {
	Object object;
	String productid;
	String productname;
	double price;
	int stock;
	String producttype;
	String trend;
	String status;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public String getTrend() {
		return trend;
	}
	public void setTrend(String trend) {
		this.trend = trend;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StockReport (Object object,String productid,String productname,double price,int stock, String producttype,String trend, String status) {
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.stock = stock;
		this.producttype = producttype;
		this.trend = trend;
		this.status = status;
	}
	public StockReport() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StockReport [object=" + object + ", productid=" + productid + ", productname=" + productname
				+ ", price=" + price + ", stock=" + stock + ", producttype=" + producttype + ", trend=" + trend
				+ ", status=" + status + "]";
	}
	
	

}
