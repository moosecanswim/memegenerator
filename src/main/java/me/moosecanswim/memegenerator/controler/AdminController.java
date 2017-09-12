package me.moosecanswim.memegenerator.controler;

import com.cloudinary.utils.ObjectUtils;
import me.moosecanswim.memegenerator.config.CloudinaryConfig;
import me.moosecanswim.memegenerator.model.CurrentUser;
import me.moosecanswim.memegenerator.model.InputImage;
import me.moosecanswim.memegenerator.service.InputImageService;
import me.moosecanswim.memegenerator.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CurrentUser currentUser;
    @Autowired
    CloudinaryConfig cloudinaryConfig;
    @Autowired
    InputImageService inputImageService;
    @Autowired
    UzerService userService;

    @RequestMapping("/home")
    public String adminHome(Model model){
        //well to add a meme

        //view all memes
        model.addAttribute("listInputImages",inputImageService.findAll());
        return "AdminPages/home";
    }
    @RequestMapping("/addinputimage")
    public String addinputimage(Model model){
        model.addAttribute("anInputImage",new InputImage());
        return "AdminPages/addinputimage";
    }
    @RequestMapping("/processinputimage")
    public String processInputImage(@Valid InputImage anInputImage, BindingResult result, @RequestParam("file") MultipartFile aFile){
        if(result.hasErrors()){
            System.out.println("AdminController/processInputImage: error in validating new input image");
            return "AdminPages/addinputimage";
        }
        try{
            Map uploadResult=cloudinaryConfig.upload(aFile.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
            anInputImage.setImageLocation(uploadResult.get("url").toString());
            if(currentUser!=null){
                //dont set a user
            }
            else{
                anInputImage.setAuthor(userService.findByUsername(currentUser.getUser().getUsername()));
            }
            inputImageService.save(anInputImage);
        }catch(IOException e){
            e.printStackTrace();
            return "AdminPages/addinputimage";
        }
        return"redirect:/admin/home";
    }
}
