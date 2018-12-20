package casestudy;

import java.time.LocalDate;
import java.util.Date;

public class ListWrapperClass {
	private String custid;
	private String custtype;
	private String prodid;
	private String prodname;
	private String prodtype;
	private int qty;
	private double price;
	private LocalDate date;
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid1) {
		this.prodid = prodid1;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProdtype() {
		return prodtype;
	}
	public void setProdtype(String prodtype) {
		this.prodtype = prodtype;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date2) {
		this.date = date2;
	}
	public String getCusttype() {
		return custtype;
	}
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}
	

}
