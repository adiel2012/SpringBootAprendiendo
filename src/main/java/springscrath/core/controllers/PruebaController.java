/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author adiel
 */
@Controller
@RequestMapping("/sipiti")
public class PruebaController {
    
        @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        return "user/userlist";
    }
    
}
