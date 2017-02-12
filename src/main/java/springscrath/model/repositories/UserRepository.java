/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.model.repositories;

/**
 *
 * @author adiel
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springscrath.core.model.entities.User;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);
}
