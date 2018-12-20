package casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import casestudy.bo.ProductBean;
import casestudy.vo.ProductVO;

@RestController
public class ProductContoller {
	@Autowired
	ProductBean b = null;

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public @ResponseBody String addProduct(@RequestBody ProductVO msg) {

		String status = b.registerProduct(msg);

		return status;

	}
}
