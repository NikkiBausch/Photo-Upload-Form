package main.java.org.launchcode.Basic.User.Form.Controllers;

import main.java.org.launchcode.Basic.User.Form.Data.PlayListRepository;
import main.java.org.launchcode.Basic.User.Form.Data.PlayListService;
import main.java.org.launchcode.Basic.User.Form.Models.Playlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PlayListController {

    @Autowired
    private PlayListService playlistservice;

    @Autowired
    private PlayListRepository playlistrepository;


    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Playlists>listPlaylists=playlistservice.listAll();
        model.addAttribute("listPlaylists", listPlaylists);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewPlayListPage(Model model){
        Playlists playlists = new Playlists();
        model.addAttribute("playlists", playlists);
        return "new_playlist";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String savePlaylist(@RequestParam Playlists playlists, Model model){
        playlistservice.save(playlists);
        return "/redirect";
    }
    @RequestMapping("/edit/ ${id}")
    public ModelAndView showEditProductPage(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_playlist");
        Playlists playlists = playlistservice.get(id);//Might have to modify this so that the interface has a getId method.
        mav.addObject("Playlists", playlists);
        return mav;
    }

    @RequestMapping("/delete/ ${id}")
    public String deletePlaylist(@PathVariable(name="id") Long id){
       playlistservice.delete(id);
       return "redirect:/";
    }
}
