/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core;

/**
 *
 * @author adiel
 */
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springscrath.core.controllers.PersonForm;


@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // registry.addViewController("/results").setViewName("results");
    }

//    @GetMapping("/")
//    public String showForm(PersonForm personForm) {
//        return "form";
//    }
//
//    @PostMapping("/")
//    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//
//        return "redirect:/results";
//    }
}