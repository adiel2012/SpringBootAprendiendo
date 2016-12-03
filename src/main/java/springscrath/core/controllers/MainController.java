package springscrath.core.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttribute;
import springscrath.core.model.entities.User;

@Controller
@RequestMapping("/main")
public class MainController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public User greeting(User message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new User(message.getEmail(), message.getName() + " 33");
    }

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

    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(System.getProperty("user.dir") + "\\src\\main\\resources\\public\\download\\" + "requestProcess.pdf");
    }

    @RequestMapping(value = "/logueado", method = RequestMethod.GET)
    public String logueado(HttpServletRequest request) {
        request.getSession().setAttribute("usuario", new User("adiel2008@gmail.com", "Adiel"));
        return "redirect:/main/aaa";
    }
//    

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    @ResponseBody
    public String aaa(HttpServletRequest request)//HttpServletRequest request)
    {
        return ((User) request.getSession().getAttribute("usuario")).getEmail();
    }

//    @RequestMapping("/displayuser")
//    @ResponseBody
//    public String handle(@SessionAttribute User user) {
//        return user.getEmail();
//    }
}
