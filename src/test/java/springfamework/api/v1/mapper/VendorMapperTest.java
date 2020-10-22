package springfamework.api.v1.mapper;

import org.junit.Test;
import springfamework.api.v1.model.VendorDTO;
import springfamework.domain.Vendor;

import static org.junit.Assert.*;

public class VendorMapperTest {

    private static final String NAME = "Joe";
    private static final long ID = 1L;
    private static final String URL = "SomeURL";

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTOTest() throws Exception{

        //GIVEN
        Vendor vendor = new Vendor();
        vendor.setName(NAME);
        vendor.setId(ID);

        //WHEN
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        //THEN
        assertEquals(Long.valueOf(ID), vendorDTO.getId());
        assertEquals(NAME, vendorDTO.getName());
    }

    @Test
    public void vendorDTOToVendorTest() throws Exception{

        //GIVEN
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);
        vendorDTO.setId(ID);

        //WHEN
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);

        //THEN
        assertEquals(Long.valueOf(ID), vendor.getId());
        assertEquals(NAME, vendor.getName());
    }


}
