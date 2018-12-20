package casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import casestudy.bo.ProductBean;
import casestudy.entity.Product;
import casestudy.entity.Vendor;

@SpringBootApplication
@EnableJpaAuditing
public class ProductApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ProductApplication.class, args);

		ProductBean b = ctx.getBean(ProductBean.class);
		Product p = new Product();
		Vendor v = new Vendor();

		v.setVendorName("s srinivas");
		v.setvContactNo(12345789);
		String email = "sms@gmailcom";

		boolean checkmail = b.checkEmail(email);
		if (checkmail) {
			System.out.println("You are Already registered");
			String vendorid = b.getIdByEmail(email);
			System.out.println("Your Vendor id is" + vendorid);
		} else {

			v.setvEmail(email);
			v.setvAddress("hhinjef");
			p.setVendor(v);

			String vendorId = b.getCountType();
			System.out.println(vendorId);

			v.setVendorId(vendorId);
			b.addVendor(v);
			String productname = "Panasonic";
			p.setProductName(productname);
			boolean checkproduct = b.checkProduct(productname);
			if (checkproduct) {
				System.out.println("Product already exists");
			} else {
				p.setProductType("Mobile");

				String type = b.calculateproductType(p);
				p.setProductType(type);

				p.setPrice(10);
				p.setCurrentStock(50);

				String productid = b.fetchproductByName(p.getProductType());
				System.out.println(productid);
				p.setProductId(productid);

				b.addProduct(p);
			}
		}

	}

}
