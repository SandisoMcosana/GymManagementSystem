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
import za.ac.cput.domain.Member;
import za.ac.cput.domain.Programme;
import za.ac.cput.domain.Subscription;
import za.ac.cput.domain.User;
import za.ac.cput.factory.MemberFactory;
import za.ac.cput.factory.ProgrammeFactory;
import za.ac.cput.factory.SubscriptionFactory;
import za.ac.cput.factory.UserFactory;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProgrammeControllerTest {
    Date currentDate = new Date();
    private User user = UserFactory.createUser("Lehlogonolo","Rakgetse","0633708515","Cape Town","rakgetsenolo@gmail.com","121212");
    private Member member = MemberFactory.createMember(12343, user);
    private final Subscription subscription = SubscriptionFactory.createSubscription(212,member,"Standard");
    private Programme programme = ProgrammeFactory.createProgramme(31231, subscription, member, "Strength", currentDate);

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/programme/";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Programme> responseEntity = testRestTemplate.postForEntity(url, programme, Programme.class);
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