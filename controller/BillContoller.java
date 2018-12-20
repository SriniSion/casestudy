package casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import casestudy.bo.BillBean;
import casestudy.entity.Invoice;
import casestudy.vo.BillVO;

@RestController
public class BillContoller {
	@Autowired
	BillBean b = null;

	@RequestMapping(value = "/GenerateBill", method = RequestMethod.POST)
	public @ResponseBody Invoice generateBill(@RequestBody List<BillVO> msg) {

		return b.generatebill2(msg);

	}

}
