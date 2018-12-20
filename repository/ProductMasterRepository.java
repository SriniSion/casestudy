package casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Product;

@Repository
public interface ProductMasterRepository extends JpaRepository<Product, String> {

	@Query("select count(p) from Product p where p.productType =?1")
	Long countByName(String string);

	@Query("select p from Product p where p.productId=?1")
	Product findDetailsById(String string);

	@Query("select case when count(p) > 0 then true else false end from Product p where p.productName=:product")
	boolean checkByProduct(@Param("product") String product);

}
