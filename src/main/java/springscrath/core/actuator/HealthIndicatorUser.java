/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.actuator;

import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import springscrath.core.model.entities.User;
import springscrath.model.repositories.UserRepository;

/**
 *
 * @author adiel
 */
@Component
public class HealthIndicatorUser implements HealthIndicator{

    @Autowired
    private UserRepository repo;
    
    @Override
    public Health health() {
        Iterable<User> list = repo.findAll();
        
        if(list==null){
            return Health.down().withDetail("count", 0).build();
        }
        
        ArrayList<User> coll = new ArrayList<>();
        for (User user : list) {
            coll.add(user);
        }
        
        if(coll.isEmpty()){
           return Health.down().withDetail("count", 0).build();
        }
        
        return Health.up().withDetail("count", coll.size()).build();
        
    }
    
}
