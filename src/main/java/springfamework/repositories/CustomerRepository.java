package springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springfamework.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
