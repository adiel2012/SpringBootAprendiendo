package springscrath.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springscrath.core.model.entities.User;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Proudly handcrafted by "
                + "<a href='http://netgloo.com/en'>netgloo</a> :)";
    }

    @RequestMapping(value = "/sample1", method = RequestMethod.GET)
    public String sample1() {
        return "pag1";
    }

    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    public String sample1(@ModelAttribute("mimodelo") User user, BindingResult result, @RequestParam("nom") String nom, @RequestParam("ppr") Integer ppr, ModelMap model) {
        model.addAttribute("ppr", ppr);
        model.addAttribute("nom", nom);
        model.addAttribute("model", user);
        return "details";
    }

}
