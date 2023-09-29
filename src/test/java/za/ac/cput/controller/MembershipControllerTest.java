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
import za.ac.cput.domain.Membership;
import za.ac.cput.domain.Subscription;
import za.ac.cput.domain.User;
import za.ac.cput.factory.MemberFactory;
import za.ac.cput.factory.MembershipFactory;
import za.ac.cput.factory.SubscriptionFactory;
import za.ac.cput.factory.UserFactory;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MembershipControllerTest {
    private Date startDate = Date.valueOf("2023-02-02");
    private Date endDate = Date.valueOf("2024-02-02");

    private User user = UserFactory.createUser("Lehlogonolo","Rakgetse","0633708515","Cape Town","rakgetsenolo@gmail.com","121212");
    private Member member = MemberFactory.createMember(12343, user);
    private Subscription subscription = SubscriptionFactory.createSubscription(212,member,"Standard");
    private Membership membership = MembershipFactory.createMembership(112,subscription,"Standard",startDate,endDate,"Active");
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8084/membership/";
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Membership> responseEntity = testRestTemplate.postForEntity(url, membership, Membership.class);
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