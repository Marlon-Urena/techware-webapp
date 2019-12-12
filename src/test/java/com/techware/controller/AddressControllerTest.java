package com.techware.controller;

import com.techware.model.Address;
import com.techware.services.AddressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
class AddressControllerIntegrationTest {
    @MockBean
    private AddressService addressService;

    @Autowired
    private MockMvc mvc;

    @DisplayName("Test for true if Addresses are found using UserAccountId")
    @Test
    void isAddressResourcesReturnedWithUserAccountIdTrue() throws Exception {
        /*
        Address address = new Address.AddressBuilder().addressId(1).userAccountId(2).streetAddress("Where ever ville").city("Staten Island").state("New York").postCode("10301").country("USA").build();

        List<Address> allEmployees = Arrays.asList(alex);

        given(addressService.getAllAddressesByUserAccountId()).willReturn(allEmployees);

        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));

         */
    }

    @DisplayName("Test for false if Addresses are not found using UserAccountId")
    @Test
    void isAddressResourcesReturnedWithUserAccountIdFalse() {
    }

    @DisplayName("Test for true if Address is returned using AddressId")
    @Test
    void isAddressResourceReturnedWithAddressIdTrue() {

    }

    @DisplayName("Test for false if Address is not returned using AddressId")
    @Test
    void isAddressResourceReturnedWithAddressIdFalse() {

    }

    @DisplayName("Test for true if Address is successfully updated")
    @Test
    void updateAddressResourceSuccessful() {
    }

    @DisplayName("Test for false if Address is unsuccessfully updated")
    @Test
    void updateAddressResourceUnsuccessful() {
    }

    @DisplayName("Test for true if Address has been successfully deleted")
    @Test
    void deleteAddressResourceSuccessful() {

    }

    @DisplayName("Test for false if Address has been unsuccessfully deleted")
    @Test
    void deleteAddressResourceUnsuccessful() {

    }

    @DisplayName("Test for true if Address has been successfully created")
    @Test
    void createAddressResourceSuccessful() {

    }

    @DisplayName("Test for false if Address has been unsuccessfully created")
    @Test
    void createAddressResourceUnsuccessful() {

    }


}
