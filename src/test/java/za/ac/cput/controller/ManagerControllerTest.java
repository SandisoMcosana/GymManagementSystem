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
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Manager;
import za.ac.cput.domain.User;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.ManagerFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ManagerControllerTest {
    private User user = UserFactory.createUser("Luphiwe","Sikupela","0633608515","Cape Town","lu@gmail.com","habibi");
    private Employee employee= EmployeeFactory.createEmployee(9.0,5,user);
    private Manager manager = ManagerFactory.createManager(1234, employee);

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/manager/";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Manager> responseEntity = testRestTemplate.postForEntity(url, manager, Manager.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
        System.out.println("Successfully created!");
    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}