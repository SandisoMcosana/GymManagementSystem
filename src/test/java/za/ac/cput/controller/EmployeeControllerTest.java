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
import za.ac.cput.domain.User;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    private User user = UserFactory.createUser("Luphiwe","Sikupela","0633608515","Cape Town","lu@gmail.com","habibi");

    private Employee employee= EmployeeFactory.createEmployee(9.0,5,user);

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/user/";
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Employee> responseEntity = testRestTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
        System.out.println("Successfully Created!!");
    }

    @Test
    void read() {
    }

    @Test
    void update() {
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