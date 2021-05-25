package main.java.org.launchcode.Basic.User.Form.Controllers;

import main.java.org.launchcode.Basic.User.Form.Data.FileUploadUtil;
import main.java.org.launchcode.Basic.User.Form.Data.UserRepository;
import main.java.org.launchcode.Basic.User.Form.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
public class FormController {
 

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users/save")
    public RedirectView saveUser(User user,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhoto(fileName);

        User savedUser = userRepository.save(user);

        String uploadDir = "user-photo/" + savedUser.getUserId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/users", true);
    }
  

    @GetMapping("/register")
    public String showForm(Model model){
        User user= new User();
        model.addAttribute("user", user);

        List<String> listMusicPreference = Arrays.asList("Heavy Metal", "Pop/indie", "Rock", "Hip-hop/rap/R&B", "Country", "Classical", "Jazz", "Techno/dance");
        model.addAttribute("listMusicPreference", listMusicPreference);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(Model model, User user){
       //Redoing this for use in a rest api with Repository.
        model.addAttribute("user", user);
        return "register_success";
    }

}
