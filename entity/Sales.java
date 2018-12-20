package casestudy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sales_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "saleDate" }, allowGetters = true)
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "invoiceNo", referencedColumnName = "invoiceNo")
	private Invoice invoiceNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private Product productId;

	private int qty;

	private double unitPrice;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date saleDate;

	public Invoice getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Invoice invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Product getProductNo() {
		return productId;
	}

	public void setProductNo(Product productNo) {
		this.productId = productNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double d) {
		this.unitPrice = d;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Override
	public String toString() {
		return "sales_master [id=" + id + ", invoiceNo=" + invoiceNo + ", productId=" + productId + ", qty=" + qty
				+ ", unitPrice=" + unitPrice + ", saleDate=" + saleDate + "]";
	}

}
