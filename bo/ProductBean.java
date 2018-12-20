package casestudy.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.entity.Product;
import casestudy.entity.Vendor;
import casestudy.repository.ProductMasterRepository;
import casestudy.repository.VendorRepository;
import casestudy.vo.ProductVO;

@Service
public class ProductBean {

	@Autowired
	VendorRepository repo;

	@Autowired
	ProductMasterRepository repository;

	public void addProduct(Product p) {

		repository.save(p);

	}

	public void addVendor(Vendor v) {
		// TODO Auto-generated method stub
		repo.save(v);
	}

	public String calculateproductType(Product p) {
		// TODO Auto-generated method stub
		String type = p.getProductType();
		String prod = null;
		if (type.equals("Milk") || type.equals("Butter")) {
			prod = "Diary";
		} else if (type.equals("Tv") || type.equals("SoundSystem")) {
			prod = "Home Appliances";
		} else if (type.equals("Jeans") || type.equals("T-shirt")) {
			prod = "Clothes";
		} else if (type.equals("Mobile") || type.equals("MobileAccessories")) {
			prod = "Mobile";
		}
		return prod;
	}


	public String getCountType() {
		long count = repo.count();
		count++;
		String vendorId = String.format("%04d", count);
		System.out.println(vendorId);
		return vendorId;
	}

	public long generateid(Product p) {
		// TODO Auto-generated method stub
		return repository.count();
	}

	public String fetchproductByName(String string) {
		// TODO Auto-generated method stub

		long count1 = repository.countByName(string);
		String id = null;
		String pid = string;
		if (pid.equals("Diary")) {
			id = "D";
		} else if (pid.equals("Home Appliances")) {
			id = "H";
		} else if (pid.equals("Clothes")) {
			id = "C";
		} else if (pid.equals("Mobile")) {
			id = "M";
		}

		String productid = id.concat(String.format("%04d", count1));
		return productid;
	}

	public Product getProdDetails(String string) {
		// TODO Auto-generated method stub
		return repository.findDetailsById(string);
	}

	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return repo.checkBYEmail(email);

	}

	public boolean checkProduct(String productname) {
		// TODO Auto-generated method stub
		return repository.checkByProduct(productname);
	}

	public String getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getIdBYEmail(email);
	}

	public String registerProduct(ProductVO msg) {
		// TODO Auto-generated method stub
		String status = null;
		boolean checkmail = checkEmail(msg.getEmail());
		if (checkmail) {
			String vendorid = getIdByEmail(msg.getEmail());
			status = "You are Already registered" + vendorid;

		} else {

			Vendor v = new Vendor();
			String vendorId = getCountType();
			System.out.println(vendorId);
			v.setVendorId(vendorId);
			v.setVendorName(msg.getVendorName());
			v.setvAddress(msg.getAddress());
			v.setvContactNo(msg.getContactNo());
			v.setvEmail(msg.getEmail());

			String productname = msg.getProductName();
			Product p = new Product();
			p.setProductName(productname);
			boolean checkproduct = checkProduct(productname);
			if (checkproduct) {
				status = "Product already exists";
			} else {
				p.setVendor(v);
				p.setProductType(msg.getProductType());

				String type = calculateproductType(p);
				p.setProductType(type);

				p.setPrice(msg.getPrice());
				p.setCurrentStock(msg.getQuantity());

				String productid = fetchproductByName(p.getProductType());
				System.out.println(productid);
				p.setProductId(productid);
				addVendor(v);
				addProduct(p);
				status = "Successfully registered. Your ProductId is " + productid;
			}
		}
		return status;

	}
}
