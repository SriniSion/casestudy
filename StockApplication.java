package casestudy;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import casestudy.bo.StockBean;
import casestudy.entity.Product;

@SpringBootApplication
@EnableJpaAuditing
public class StockApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(StockApplication.class, args);
		
		StockBean b = ctx.getBean(StockBean.class);
		Product p = new Product();

		String productid="H0000";
		String producttype = "Clothes";
		System.out.println("************Stock Report****************");
		List list1= b.getAllProductDetails(producttype);
		
		Iterator<Product> it1 = list1.iterator();
		int currentstock=0;
		while(it1.hasNext()) {

			Product li1 = it1.next();
			currentstock = currentstock+li1.getCurrentStock();
		}
		List list= b.getAllProductDetails(producttype);
		Iterator<Product> it = list.iterator();
		
		while(it.hasNext())
		{
			Product li = it.next();
			System.out.print(li.getProductId());
			System.out.print(" ");
			
			
			System.out.print(li.getProductName());
			System.out.print(" ");
			
			System.out.print(li.getPrice());
			System.out.print(" ");
			
			System.out.print(li.getCurrentStock());
			System.out.print(" ");
			System.out.print(li.getProductType());
			System.out.print(" ");
			String status = b.calculatestatus(currentstock);
			System.out.print(status);
			System.out.print(" ");
			String trend=b.getTotalSale(li.getProductId());
			System.out.print(trend);
			System.out.println(" ");
			
		
		}
		
		
		Product pro = b.getAllProductDetailsbyId(productid);
		
		
			System.out.print(pro.getProductId());
			System.out.print(" ");
			
			
			
			System.out.print(pro.getProductName());
			System.out.print(" ");
			
			System.out.print(pro.getPrice());
			System.out.print(" ");
			
			System.out.print(pro.getCurrentStock());
			System.out.print(" ");
			System.out.print(pro.getProductType());
			System.out.print(" ");
			String status = b.calculatestatus(pro.getCurrentStock());
			System.out.print(status);
			System.out.print(" ");
			String trend=b.getTotalSale(pro.getProductId());
			System.out.print(trend);
			System.out.println(" ");
			
		
		

List list4= b.getAllDetails();
		
		Iterator<Product> it4 = list4.iterator();
		int currentstock4=0;
		while(it4.hasNext()) {

			Product li2 = it4.next();
			currentstock4 = currentstock4+li2.getCurrentStock();
		}
		List list5= b.getAllDetails();
		Iterator<Product> it5 = list5.iterator();
		
		while(it5.hasNext())
		{
			Product li = it5.next();
			System.out.print(li.getProductId());
			System.out.print(" ");
			
			
			
			System.out.print(li.getProductName());
			System.out.print(" ");
			
			System.out.print(li.getPrice());
			System.out.print(" ");
			
			System.out.print(li.getCurrentStock());
			System.out.print(" ");
			System.out.print(li.getProductType());
			System.out.print(" ");
			String status1 = b.calculatestatus(currentstock4);
			System.out.print(status1);
			System.out.print(" ");
			String trend1=b.getTotalSale(li.getProductId());
			System.out.print(trend1);
			System.out.println(" ");
			
		}
		
}	
	
}
