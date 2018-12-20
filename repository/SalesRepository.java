package casestudy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {

	@Query("select s from Sales s where  s.saleDate BETWEEN ?1 and ?2  AND s.productId= ?3")
	List<Sales> findDetailsBYType( Date d1, Date d2,  String productid);

	

}
