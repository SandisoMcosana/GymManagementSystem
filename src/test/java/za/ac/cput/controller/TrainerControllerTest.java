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
import za.ac.cput.domain.Trainer;
import za.ac.cput.domain.User;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.TrainerFactory;
import za.ac.cput.factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrainerControllerTest {
    private User user = UserFactory.createUser("Lehlogonolo","Rakgetse","0633708515","Cape Town","rakgetsenolo@gmail.com","121212");
    private Employee employee = EmployeeFactory.createEmployee(7.30,150,user);
    private Trainer trainer = TrainerFactory.createTrainer(121,employee);
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/trainer/";
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Trainer> responseEntity = testRestTemplate.postForEntity(url, trainer, Trainer.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        System.out.println(responseEntity.getBody());
        System.out.println("Successfully Created!!");
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