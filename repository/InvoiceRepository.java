package casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Sales;

@Repository
public interface InvoiceRepository extends JpaRepository<Sales, String> {


	@Query("select s from Sales s where s.invoiceNo=:string")
	List<Sales> fetchByInvoice(@Param("string") String string);

	@Query("select p from Sales p where p.productId =:string")
	List<Sales> getById(@Param("string") String string);

}
