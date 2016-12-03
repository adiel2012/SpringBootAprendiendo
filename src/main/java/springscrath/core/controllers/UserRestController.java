/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.controllers;

/**
 *
 * @author adiel
 */
import com.fasterxml.jackson.annotation.JsonView;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import springscrath.core.model.entities.User;

@RestController
@RequestMapping(value = "/userapi/")
public class UserRestController {

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = new LinkedList<>();
        users.add(new User("adiel2008@gmail.com", "adiel"));
        users.add(new User("raul@gmail.com", "emi"));
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/samplebinding", method = RequestMethod.GET)
    @JsonView(User.WithoutName.class)
    public User getUser() {
        return new User("jesus@gmail.com", "eric");
    }

}
// http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
