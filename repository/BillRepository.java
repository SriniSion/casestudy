package casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import casestudy.entity.Invoice;
import casestudy.entity.Sales;

@Repository
public interface BillRepository extends JpaRepository<Invoice, String> {

	void save(Sales sm);

}
