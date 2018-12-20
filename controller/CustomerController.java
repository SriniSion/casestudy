package casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import casestudy.bo.CustomerBean;
import casestudy.entity.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerBean b = null;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public @ResponseBody String addVendor(@RequestBody Customer msg) {

		String status = b.registerCustomer(msg);

		return status;

	}
}
