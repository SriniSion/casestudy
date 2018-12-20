package casestudy.bo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.ListWrapperClass;
import casestudy.entity.Invoice;
import casestudy.entity.Product;
import casestudy.entity.Sales;
import casestudy.repository.BillRepository;
import casestudy.repository.CustomerRepository;
import casestudy.vo.BillVO;

@Service
public class BillBean {
	@Autowired
	BillRepository repo;

	@Autowired
	CustomerRepository repos;

	public double generatebill(List<ListWrapperClass> list) {
		// TODO Auto-generated method stub

		Iterator<ListWrapperClass> it = list.iterator();
		double total = 0;
		while (it.hasNext()) {
			ListWrapperClass li = it.next();

			System.out.print(li.getProdid());
			System.out.print(" ");
			System.out.print(li.getProdname());
			System.out.print(" ");
			System.out.print(li.getProdtype());
			System.out.print(" ");
			System.out.print(li.getPrice());
			System.out.print(" ");
			System.out.print(li.getQty());
			System.out.print(" ");
			System.out.print(li.getDate());
			System.out.println();
			total = total + (li.getPrice() * li.getQty());
			System.out.println(total);

		}
		return total;
	}

	public long generateinvoiceno() {

		return repo.count();
	}

	public void addbill(Invoice im) {
		// TODO Auto-generated method stub
		repo.save(im);
	}

	public void addtosales(Sales sm) {
		// TODO Auto-generated method stub
		repo.save(sm);
	}

	public Invoice generatebill2(List<BillVO> msg) {
		// TODO Auto-generated method stub
		BillVO list = msg.get(0);

		Iterator<BillVO> it = msg.iterator();
		double ctotal = 0;
		String id = null;
		String type = null;
		while (it.hasNext()) {
			BillVO li = it.next();

			ctotal = ctotal + (li.getPrice() * li.getQuantity());
			System.out.println(ctotal);
			id = li.getCustomerID();
			type = repos.findTypeById(id);
			System.out.println(type);
		}
		double total = ctotal;
		double discount = 0, totalamt = 0;
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
		long invoiceid = generateinvoiceno();
		String invoiceno = String.format("%04d", invoiceid);
		Invoice im = new Invoice();
		im.setInvoiceNo(invoiceno);
		im.setDiscountAmt(discount);
		im.setTotal(totalamt);

		addbill(im);
		Sales sm = new Sales();

		Iterator<BillVO> it1 = msg.iterator();

		while (it1.hasNext()) {
			BillVO liw = it1.next();

			sm.setInvoiceNo(im);
			String pro = liw.getProdictID();
			Product p = new Product();
			p.setProductId(pro);
			sm.setProductNo(p);
			sm.setQty(liw.getQuantity());
			sm.setUnitPrice(liw.getPrice());

			addtosales(sm);

		}

		return im;

	}

}
