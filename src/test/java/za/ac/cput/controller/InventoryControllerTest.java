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
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryControllerTest {
    private Inventory inventory = InventoryFactory.createInventory("Lu", "Dumbbells",
            "Short Bar With Rubber Handles", "20");

    //private Inventory inventory1 = InventoryFactory.createInventory("2235543", "Treadmill",
        //    "With handles and adjustable incline", "15",
        //    "1 - 2 recovery jogs");

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/inventory/";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Inventory> responseEntity = testRestTemplate.postForEntity(url, inventory, Inventory.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
        System.out.println("Successfully Created!");
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
