package casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Product;

@Repository
public interface StockRepository extends JpaRepository<Product, String> {
	@Query("select p from Product p where p.productType=:producttype")
	List<Product> findByType(@Param("producttype") String producttype);

	@Query( "select p from Product p where p.productId=:productId")
	Product findByStringId(@Param("productId") String productId);

}
