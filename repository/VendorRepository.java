package casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import casestudy.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

	@Query("select case when count(v) > 0 then true else false end from Vendor v where v.vEmail=:email")
	boolean checkBYEmail(@Param("email") String email);

	@Query("select v.vendorId from Vendor v where v.vEmail=:email")
	String getIdBYEmail(@Param("email") String email);


}
