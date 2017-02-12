
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import springscrath.model.repositories.UserRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adiel
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@RestClientTest(UserRepository.class)
public class TestSet1 {

    //  https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
    //   https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
//    @Autowired
//    private TestRestTemplate restTemplate;

    
//    @Autowired
//    private UserRepository repository;
    
    @Before
    public void Antes() {
        System.out.println("Empezando");

    }

    @Test
    public void Prueba1() {
        System.out.println("Prueba 1 Ejecutando");
//        this.restTemplate.getForEntity(
//                "/userapi/user", int.class, "Phil");

    }
// https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
    @After
    public void Despues() {

        System.out.println("Terminando");
    }
}
