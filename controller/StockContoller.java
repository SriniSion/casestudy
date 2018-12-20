package casestudy.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import casestudy.bo.StockBean;
import casestudy.entity.Product;
import casestudy.vo.StockReport;

@RestController
public class StockContoller {
	@Autowired
	StockBean b = null;

	@RequestMapping(value = "/stockreport", method = RequestMethod.POST)
	public @ResponseBody StockReport stockreport(@RequestBody StockReport msg) {
		
		return b.getStockReport(msg.getProductid());
	}
	@RequestMapping(value = "/stockreportbytype", method = RequestMethod.POST)
	public @ResponseBody List<StockReport> stockreportbytype(@RequestBody StockReport msg) {
		
		return b.getStockReportbyType(msg.getProducttype());
	}

}
