package me.moosecanswim.memegenerator.controler;

import me.moosecanswim.memegenerator.service.InputImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    InputImageService inputImageService;
    @RequestMapping("/home")
    public String userHome(Model model){
        model.addAttribute("listavalibleInputImages",inputImageService.findByStatus(true));
        return "UserPages/home";
    }
    @RequestMapping("/make/{id}")
    public String makeMeme(@PathVariable("id") long id,Model model){

        model.addAttribute("anImage",inputImageService.findOne(id));
        return null;
    }
    @RequestMapping("/processmeme")
    public String processMeme(@RequestParam("toptext") String topText, @RequestParam("bottomtext") String bottomText){
        //send this stuff to processor and return the image and url to the user.  set the author of the meme to the user
        return "/";
    }
}
