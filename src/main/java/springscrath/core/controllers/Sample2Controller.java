/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author adiel
 */
@RequestMapping("/sample2")
@Controller
public class Sample2Controller {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @RequestMapping(value = "/miadd", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/sample2/resultado";
    }
    
    @RequestMapping(value = "/resultado", method = RequestMethod.GET)
    public String resultado(PersonForm personForm) {
        return "results";
    }
}
