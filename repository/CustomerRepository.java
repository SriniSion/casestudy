package casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query("select p.customerType from Customer p where p.customerId =:id")
	String findTypeById(@Param("id") String id);

	@Query("select v.customerId from Customer v where v.cEmail=:email")
	String getIdBYEmail(@Param("email") String email);

	@Query("select case when count(v) > 0 then true else false end from Customer v where v.cEmail=:email")
	boolean checkBYEmail(@Param("email") String email);

}
