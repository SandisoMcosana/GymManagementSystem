package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {
    private Address address = AddressFactory.createAddress("12 Heron Cove","Table View","WesternCape",7441);
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/address/";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Address> responseEntity = testRestTemplate.postForEntity(url, address, Address.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
        System.out.println("Successfully Created!!");
    }

    @Test
    void read() {
//        String url = baseURL + "/read/" + address.getAddressId();
//        System.out.println("URl: " + url);
//        ResponseEntity<Address> response = testRestTemplate.getForEntity(url,Address.class);
//        assertEquals(address.getAddressId(),response.getBody().getAddressId());
//        System.out.println(response.getBody());
    }


    @Test
    void update() {

//        String url = baseURL + "/update";
//        System.out.println("URL: " + url);
//        System.out.println("Updated Data: " + updatedBooking);
//        ResponseEntity<Booking> response = restTemplate.postForEntity(url,updatedBooking, Booking.class);
//        assertNotNull(response.getBody());
    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
    }
