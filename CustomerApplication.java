package casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import casestudy.bo.CustomerBean;
import casestudy.entity.Customer;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(CustomerApplication.class, args);

		CustomerBean b = ctx.getBean(CustomerBean.class);
		Customer c = new Customer();

		c.setCustomerName("sriva");
		c.setcAddress("hehjbd");
		c.setcContactNo(12334122);
		String email = "sriva@gmail.com";
		c.setcEmail(email);
		boolean checkmail = b.checkEmail(email);
		if (checkmail) {
			System.out.println("You are Already registered");
			String customerid = b.getIdByEmail(email);
			System.out.println("Your customer id is" + customerid);
		} else {
			c.setCustomerType("1 year");
			String type = c.getCustomerType();

			String custtype = null;
			if (type.equals("1 year")) {
				custtype = "Guest";
			}
			if (type.equals("2 year") || type.equals("3 year") || type.equals("4 year")) {
				custtype = "Silver";
			}
			if (type.equals("5 year") || type.equals("6 year") || type.equals("7 year")) {
				custtype = "Gold";
			}
			if (type.equals("8 year") || type.equals("9 year") || type.equals("10 year")) {
				custtype = "Platinum";
			}

			c.setCustomerType(custtype);
			long count = b.CountType();
			String id = "C-";
			String customerId = id.concat(String.format("%04d", count));
			System.out.println(customerId);
			c.setCustomerId(customerId);
			b.addCustomer(c);
		}

	}

}