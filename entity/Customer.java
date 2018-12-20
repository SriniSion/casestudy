package casestudy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_master")
public class Customer {

	@Id
	private String customerId;

	private String customerName;

	private int cContactNo;
	private String cEmail;
	private String cAddress;
	private String customerType;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getcContactNo() {
		return cContactNo;
	}

	public void setcContactNo(int cContactNo) {
		this.cContactNo = cContactNo;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "customer_master [customerId=" + customerId + ", customerName=" + customerName + ", cContactNo="
				+ cContactNo + ", cEmail=" + cEmail + ", cAddress=" + cAddress + ", customerType=" + customerType + "]";
	}

}
