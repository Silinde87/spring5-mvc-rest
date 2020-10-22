package springfamework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springfamework.domain.Category;
import springfamework.domain.Customer;
import springfamework.domain.Vendor;
import springfamework.repositories.CategoryRepository;
import springfamework.repositories.CustomerRepository;
import springfamework.repositories.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();

        System.out.println("Categories Loaded = " + categoryRepository.count() );
        System.out.println("Customers Loaded = " + customerRepository.count() );
        System.out.println("Vendors Loaded = " + vendorRepository.count() );

    }

    private void loadCategories(){
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
    }

    private void loadCustomers(){
        Customer customer1 = new Customer();
        customer1.setFirstName("David");
        customer1.setLastName("Winter");

        Customer customer2 = new Customer();
        customer2.setFirstName("Anne");
        customer2.setLastName("Hine");

        Customer customer3 = new Customer();
        customer3.setFirstName("Alice");
        customer3.setLastName("Eastman");

        Customer customer4 = new Customer();
        customer4.setFirstName("Zsolt");
        customer4.setLastName("Torok");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
    }

    private void loadVendors(){
        Vendor vendor1 = new Vendor();
        vendor1.setName("Exotic Fruits Company");

        Vendor vendor2 = new Vendor();
        vendor2.setName("Home Fruits");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Fun Fresh Fruits Ltd.");

        Vendor vendor4 = new Vendor();
        vendor4.setName("Nuts for Nuts Company");

        Vendor vendor5 = new Vendor();
        vendor5.setName("Franks Fresh Fruits from France Ltd.");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);
        vendorRepository.save(vendor5);

    }


}
