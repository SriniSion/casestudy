package casestudy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "vendor_master")
public class Vendor implements Serializable {
	@Id
	@NaturalId
	private String vendorId;

	private String vendorName;

	private int vContactNo;

	private String vEmail;
	private String vAddress;

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getvContactNo() {
		return vContactNo;
	}

	public void setvContactNo(int vContactNo) {
		this.vContactNo = vContactNo;
	}

	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvAddress() {
		return vAddress;
	}

	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}

	@Override
	public String toString() {
		return "vendor_master [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vContactNo=" + vContactNo
				+ ", vEmail=" + vEmail + ", vAddress=" + vAddress + "]";
	}

}
