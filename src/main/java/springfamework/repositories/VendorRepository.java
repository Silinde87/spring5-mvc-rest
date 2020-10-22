package springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springfamework.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
