package springfamework.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import springfamework.api.v1.mapper.CustomerMapper;
import springfamework.api.v1.model.CustomerDTO;
import springfamework.domain.Customer;
import springfamework.repositories.CustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    private static final Long ID = 1L;
    private static final String FIRST_NAME = "Joe";
    private static final String LAST_NAME = "Davis";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception{

        //GIVEN
        List<Customer> customers = Arrays.asList(new Customer(),new Customer(),new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //WHEN
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //THEN
        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName(FIRST_NAME);
        customer1.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals(FIRST_NAME, customerDTO.getFirstName());
    }

    @Test
    public void createNewCustomer() throws Exception{
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setId(ID);

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(customerDTO.getId());

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/v1/customers/1", savedDto.getCustomerUrl());
    }

}