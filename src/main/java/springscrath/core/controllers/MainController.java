package springscrath.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
