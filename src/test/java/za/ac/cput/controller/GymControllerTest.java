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
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GymControllerTest {

    private User user = UserFactory.createUser("Lehlogonolo","Rakgetse","0633708515","Cape Town","lehlogonolorakgetse31@gmail.com","rakgetse");
    private Employee employee= EmployeeFactory.createEmployee(9.0,5,user);
    private Manager manager = ManagerFactory.createManager(1234, employee);
    private final Trainer trainer = TrainerFactory.createTrainer(121,employee);
    private Gym gym = GymFactory.createGym(1122664, manager, trainer, "Ozone Fitness", 200);


    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/gym/";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Gym> responseEntity = testRestTemplate.postForEntity(url, gym, Gym.class);
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
