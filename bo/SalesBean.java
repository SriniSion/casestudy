package casestudy.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.entity.Product;
import casestudy.entity.Sales;
import casestudy.repository.SalesRepository;
import casestudy.repository.StockRepository;

@Service
public class SalesBean {

	@Autowired
	SalesRepository repo;

	@Autowired
	StockRepository repository;

	public List<Sales> getSaleData(String fromdate, String todate, String productid) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = format.parse(fromdate);
		Date d2 = format.parse(todate);
		return repo.findDetailsBYType(d1, d2, productid);
	}

	public String calculateproductName(String string) {
		// TODO Auto-generated method stub
		Product list = repository.findByStringId(string);
		
		return null;
	}

	/*public List<Sales> getSaleDatabytype(String fromdate, String todate, String producttype) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = format.parse(fromdate);
		Date d2 = format.parse(todate);
		String prod = null;
		if (producttype.equals("Diary")) {
			prod = "D";
		} else if (producttype.equals("Clothes")) {
			prod = "C";
		}
		if (producttype.equals("Home Appliances")) {
			prod = "H";
		}
		if (producttype.equals("Mobile")) {
			prod = "M";
		}
		return repo.findDetailsBYId(d1, d2, prod);
	}
*/
}
