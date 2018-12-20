package casestudy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import casestudy.bo.BillBean;
import casestudy.bo.CustomerBean;
import casestudy.bo.ProductBean;
import casestudy.entity.Customer;
import casestudy.entity.Invoice;
import casestudy.entity.Product;
import casestudy.entity.Sales;

@SpringBootApplication
@EnableJpaAuditing
public class BillApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = SpringApplication.run(BillApplication.class, args);
	

		CustomerBean custbean = ctx.getBean(CustomerBean.class);
		// SalesBean b = ctx.getBean(SalesBean.class);
		ProductBean prodbean = ctx.getBean(ProductBean.class);
		String custid = "C-0007";
		String type0 = custbean.getDetails(custid);
		System.out.println(type0);
		String prodid = "D0001";
		Product prod = prodbean.getProdDetails(prodid);
		String name = prod.getProductName();
		String prodtype = prod.getProductType();
		double price = prod.getPrice();
		System.out.println(name);
		System.out.println(prodtype);
		System.out.println(price);
		int qty = 2;
		LocalDate date = java.time.LocalDate.now();
		ListWrapperClass li = new ListWrapperClass();
		li.setCustid(custid);
		li.setCusttype(type0);
		li.setProdid(prodid);
		li.setProdname(name);
		li.setProdtype(prodtype);
		li.setPrice(price);
		li.setQty(qty);
		li.setDate(date);

		String prodid1 = "D0000";
		Product prod1 = prodbean.getProdDetails(prodid1);
		String name1 = prod1.getProductName();
		String prodtype1 = prod1.getProductType();
		double price1 = prod.getPrice();
		System.out.println(name1);
		System.out.println(prodtype1);
		System.out.println(price1);
		int qty1 = 2;
		LocalDate date1 = java.time.LocalDate.now();
		ListWrapperClass li2 = new ListWrapperClass();

		li2.setProdid(prodid1);
		li2.setProdname(name1);
		li2.setProdtype(prodtype1);
		li2.setPrice(price1);
		li2.setQty(qty1);
		li2.setDate(date1);
		List<ListWrapperClass> list = new ArrayList<ListWrapperClass>();
		list.add(li);
		list.add(li2);
		BillBean billbean = ctx.getBean(BillBean.class);
		double total = billbean.generatebill(list);
		String type = li.getCusttype();
		double discount = 0;
		double totalamt = 0;
		if (type.equals("Gold")) {
			if (total <= 1000) {
				discount = (total / 100) * 1;
				totalamt = total - discount;

			} else if (total > 1000 && total < 3000) {
				discount = (total / 100) * 2.5;
				totalamt = total - discount;
			} else if (total >= 3000 && total < 5000) {
				discount = (total / 100) * 3;
				totalamt = total - discount;
			} else if (total >= 5000) {
				discount = (total / 100) * 4;
				totalamt = total - discount;
			}
		} else if (type.equals("Silver")) {
			if (total <= 1000) {
				discount = (total / 100) * 0.5;
				totalamt = total - discount;
			} else if (total > 1000 && total < 3000) {
				discount = (total / 100) * 2;
				totalamt = total - discount;
			} else if (total >= 3000 && total < 5000) {
				discount = (total / 100) * 2.5;
				totalamt = total - discount;
			} else if (total >= 5000) {
				discount = (total / 100) * 3;
				totalamt = total - discount;
			}
		} else if (type.equals("Platinum")) {
			if (total <= 1000) {
				discount = (total / 100) * 1.5;
				totalamt = total - discount;
			} else if (total > 1000 && total < 3000) {
				discount = (total / 100) * 3;
				totalamt = total - discount;
			} else if (total >= 3000 && total < 5000) {
				discount = (total / 100) * 3.5;
				totalamt = total - discount;
			} else if (total >= 5000) {
				discount = (total / 100) * 5;
				totalamt = total - discount;
			}
		} else if (type.equals("Guest")) {
			if (total <= 1000) {
				discount = (total / 100) * 0.25;
				totalamt = total - discount;
			} else if (total > 1000 && total < 3000) {
				discount = (total / 100) * 0.5;
				totalamt = total - discount;
			} else if (total >= 3000 && total < 5000) {
				discount = (total / 100) * 0.75;
				totalamt = total - discount;
			} else if (total >= 5000) {
				discount = (total / 100) * 1;
				totalamt = total - discount;
			}
		}

		long id = billbean.generateinvoiceno();
		String invoiceno = String.format("%04d", id);

		Invoice im = new Invoice();
		im.setInvoiceNo(invoiceno);
		im.setDiscountAmt(discount);
		im.setTotal(totalamt);

		billbean.addbill(im);

		Sales sm = new Sales();

		Iterator<ListWrapperClass> it = list.iterator();

		while (it.hasNext()) {
			ListWrapperClass liw = it.next();

			sm.setInvoiceNo(im);
			String pro = liw.getProdid();
			Product p = new Product();
			p.setProductId(pro);
			sm.setProductNo(p);
			sm.setQty(liw.getQty());
			sm.setUnitPrice(liw.getPrice());

			billbean.addtosales(sm);

		}

	}

}
