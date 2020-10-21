package springfamework.api.v1.mapper;

import org.junit.Test;
import springfamework.api.v1.model.CustomerDTO;
import springfamework.domain.Customer;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    private static final String FIRST_NAME = "Joe";
    private static final String LAST_NAME = "Davis";
    private static final long ID = 1L;
    private static final String URL = "SomeURL";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception{

        //GIVEN
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(ID);

        //WHEN
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //THEN
        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRST_NAME,customerDTO.getFirstName());
        assertEquals(LAST_NAME,customerDTO.getLastName());
    }
}