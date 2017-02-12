/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.controllers;

import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springscrath.core.model.entities.User;

/**
 *
 * @author adiel
 */
@Controller
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserDAO userDAO;
    List<User> users = new LinkedList<>();

    public UserController() {
        users.add(new User("adiel2008@gmail.com", "Adiel", 1));
        users.add(new User("luis@gmail.com", "Juan", 2));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("model", users);
        return "user/userlist";
    }

    /* @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String details(@PathVariable Long id, ModelMap model) {

        for (User user : users) {
            if (user.getId() == id) {
                model.addAttribute("model", user);
                return "/user/details";
            }
        }

        return "notfound";
    }*/

 /* @RequestMapping(value = "/create1", method = RequestMethod.GET)
    public String create1(ModelMap model) {
        model.addAttribute("model", new User());
        return "/user/create";
    }*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("/user/createform", "model", new User());
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public ModelAndView docreate(@ModelAttribute("User") @Valid User user, BindingResult result) {
        System.out.println(user.getEmail());
        ModelAndView mv;
        
        boolean f = result.hasFieldErrors("email");

        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println(fieldError.getField() + "  " + fieldError.getDefaultMessage());
            }
            mv = new ModelAndView("/user/createform", "model", user);
            mv.addObject("bindingresults", result);
            
        } else {
            mv = new ModelAndView("redirect:/user/list");
        }

        return mv;
    }

    /* 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }
    
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "denied";
    }
     */
}
