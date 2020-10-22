package springfamework.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import springfamework.api.v1.mapper.VendorMapper;
import springfamework.api.v1.model.VendorDTO;
import springfamework.controllers.v1.VendorController;
import springfamework.domain.Vendor;
import springfamework.repositories.VendorRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class VendorServiceTest {

    private static final Long ID = 1L;
    private static final String NAME = "Joe";
    public static final String VENDOR_URL = "/api/v1/vendors/1";
    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {

        //GIVEN
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());

        when(vendorRepository.findAll()).thenReturn(vendors);

        //WHEN
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        //THEN
        assertEquals(3, vendorDTOS.size());
    }

    @Test
    public void getVendorsById() throws Exception{
        //given
        Vendor vendor1 = new Vendor();
        vendor1.setId(ID);
        vendor1.setName(NAME);

        when(vendorRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(vendor1));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        assertEquals(NAME, vendorDTO.getName());
    }

    @Test
    public void createNewVendor() throws Exception{
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);
        vendorDTO.setId(ID);

        Vendor savedVendor = new Vendor();
        savedVendor.setName(vendorDTO.getName());
        savedVendor.setId(vendorDTO.getId());

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDto = vendorService.createNewVendor(vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDto.getName());
        assertEquals(VENDOR_URL, savedDto.getVendorUrl());
    }

    @Test
    public void saveVendorByDTO() throws Exception{
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);
        vendorDTO.setId(ID);

        Vendor savedVendor = new Vendor();
        savedVendor.setName(vendorDTO.getName());
        savedVendor.setId(vendorDTO.getId());

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDto = vendorService.saveVendorByDTO(ID, vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDto.getName());
        assertEquals(VENDOR_URL, savedDto.getVendorUrl());
    }

    @Test
    public void deleteVendorByID() throws Exception {
        vendorRepository.deleteById(ID);

        verify(vendorRepository, times(1)).deleteById(anyLong());
    }
}
