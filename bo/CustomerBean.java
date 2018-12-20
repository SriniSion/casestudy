package casestudy.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.entity.Customer;
import casestudy.repository.CustomerRepository;

@Service
public class CustomerBean {

	@Autowired
	CustomerRepository repo;

	public void addCustomer(Customer c) {

		repo.save(c);

	}

	public long CountType() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	public String getDetails(String string) {
		// TODO Auto-generated method stub
		return repo.findTypeById(string);
	}

	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return repo.checkBYEmail(email);
	}

	public String getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getIdBYEmail(email);
	}

	public String registerCustomer(Customer msg) {
		// TODO Auto-generated method stub
		String status = null;
		boolean checkmail = checkEmail(msg.getcEmail());
		if (checkmail) {

			String customerid = getIdByEmail(msg.getcEmail());
			status = "You are Already registered" + customerid;

		} else {
			long count = CountType();
			String id = "C-";
			String customerId = id.concat(String.format("%04d", count));
			System.out.println(customerId);
			msg.setCustomerId(customerId);
			String type = msg.getCustomerType();

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

			msg.setCustomerType(custtype);
			addCustomer(msg);
			status = "You're Successfully Registered. Your Customerid - " + customerId;
		}

		return status;
	}

}
