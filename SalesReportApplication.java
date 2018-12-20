package casestudy;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import casestudy.bo.SalesBean;
import casestudy.entity.Product;
import casestudy.entity.Sales;

@SpringBootApplication
@EnableJpaAuditing
public class SalesReportApplication {

	

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = SpringApplication.run(SalesReportApplication.class, args);
		
		SalesBean b = ctx.getBean(SalesBean.class);
		Product p = new Product();

		String productid="D0001";
		String producttype = "Mobile";
		String fromdate ="2018-11-23";
		String todate = "2018-11-23";
		
		List<Sales> list = b.getSaleData(fromdate,todate,productid) ;
Iterator<Sales> it = list.iterator();
		double grandtotal=0;
		while(it.hasNext())
		{
			Sales li = it.next();
			System.out.print(li.getInvoiceNo());
			System.out.print(" ");
			
			Product id = li.getProductNo();
			System.out.print(id.getProductId());
			System.out.print(" ");
			String productname=b.calculateproductName(id.getProductId());
			System.out.print(productname);
			System.out.print(" ");
			System.out.print(li.getSaleDate());
			System.out.print(" ");
			
			System.out.print(li.getUnitPrice());
			System.out.print(" ");
			System.out.print(li.getQty());
			System.out.print(" ");
			
			double totalsaleprice = li.getUnitPrice()*li.getQty();
			System.out.println(totalsaleprice);
			
			System.out.println(" ");
			grandtotal = grandtotal+totalsaleprice;
		
		}
		System.out.println("GrandTotalPrice " +grandtotal);
		
	/*	List<Sales> list1 = b.getSaleDatabytype(fromdate,todate,producttype) ;
		Iterator<Sales> it1 = list1.iterator();
		double grandtotal1=0;
		while(it1.hasNext())
		{
			Sales li = it1.next();
			System.out.print(li.getInvoiceNo());
			System.out.print(" ");
			
			Product id = li.getProductNo();
			System.out.print(id.getProductId());
			System.out.print(" ");
			String productname=b.calculateproductName(id.getProductId());
			System.out.print(productname);
			System.out.print(" ");
			System.out.print(li.getSaleDate());
			System.out.print(" ");
			
			System.out.print(li.getUnitPrice());
			System.out.print(" ");
			System.out.print(li.getQty());
			System.out.print(" ");
			
			double totalsaleprice = li.getUnitPrice()*li.getQty();
			System.out.println(totalsaleprice);
			
			System.out.println(" ");
			grandtotal1 = grandtotal1+totalsaleprice;
		
		}
		System.out.println("GrandTotalPrice1 " +grandtotal1);*/
	}

}
