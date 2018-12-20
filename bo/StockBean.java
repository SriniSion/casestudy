package casestudy.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.entity.Product;
import casestudy.entity.Sales;
import casestudy.repository.InvoiceRepository;
import casestudy.repository.StockRepository;
import casestudy.vo.StockReport;

@Service
public class StockBean {
	@Autowired
	StockRepository repo;

	@Autowired
	InvoiceRepository repository;

	public List<Product> getAllProductDetails(String producttype) {
		// TODO Auto-generated method stub
		return (repo.findByType(producttype));
	}

	public String calculatestatus(int currentstock) {
		// TODO Auto-generated method stub
		String status = null;
		if (currentstock <= 50) {
			status = "Critically low";
		} else if (currentstock > 50 && currentstock <= 70) {
			status = " low";
		} else {
			status = "Ok";
		}
		return status;
	}

	public String getTotalSale(String productid) {
		// TODO Auto-generated method stub
		
		List list = repository.getById(productid);
		Iterator<Sales> it = list.iterator();
		int total = 0;
		String sale = null;
		while (it.hasNext()) {
			Sales li = it.next();
			total = total + li.getQty();
		}
		if (total >= 50) {
			sale = "Good";
		} else if (total >= 30 && total < 50) {
			sale = "Fair";
		} else if (total < 30) {
			sale = "Poor";
		}
		return sale;
	}

	public Product getAllProductDetailsbyId(String productid) {
		// TODO Auto-generated method stub
		return repo.findByStringId(productid);
	}

	public List<Product> getAllDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public StockReport getStockReport(String productid) {
		// TODO Auto-generated method stub
		Product p = getAllProductDetailsbyId(productid);
		
		
		
			StockReport sr = new StockReport();
			String produid=p.getProductId();
			sr.setProductid(produid);
			String productname=p.getProductName();
			sr.setProductname(productname);
			String producttype = p.getProductType();
			sr.setProducttype(producttype);
			double price = p.getPrice();
			sr.setPrice(price);
			int currentstock = p.getCurrentStock();
			sr.setStock(currentstock);
			String status = calculatestatus(currentstock);
			sr.setStatus(status);
			String trend=getTotalSale(produid);
			sr.setTrend(trend);
			
		
	
		
		return sr;
	}
	public List<StockReport> getStockReportbyType(String producttype) {
		// TODO Auto-generated method stub
		List<Product> list1 = getAllProductDetails(producttype);
		Iterator<Product> it1 = list1.iterator();
		int currentstock=0;
		while(it1.hasNext()) {

			Product li1 = it1.next();
			currentstock = currentstock+li1.getCurrentStock();
		}
		List<Product> list= getAllProductDetails(producttype);
		Iterator<Product> it = list.iterator();
		List<StockReport> srlist = new ArrayList<StockReport>();
		int i=0;
		while(it.hasNext())
		{
			Product li = it.next();
			

			StockReport sr = new StockReport();
			String produid=li.getProductId();
			sr.setProductid(produid);
			String productname=li.getProductName();
			sr.setProductname(productname);
			String producttype1 = li.getProductType();
			sr.setProducttype(producttype1);
			double price = li.getPrice();
			sr.setPrice(price);
			int currentstock1 = li.getCurrentStock();
			sr.setStock(currentstock1);
			String status = calculatestatus(currentstock1);
			sr.setStatus(status);
			String trend=getTotalSale(produid);
			sr.setTrend(trend);
			srlist.add(i++, sr);
		
		}
		
		return srlist;
	}

}
