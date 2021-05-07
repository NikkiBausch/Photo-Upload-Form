package main.java.org.launchcode.Basic.User.Form.Controllers;

import main.java.org.launchcode.Basic.User.Form.Data.PlayListService;
import main.java.org.launchcode.Basic.User.Form.Models.Playlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlayListController {

    @Autowired
    private PlayListService playlistservice;


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



}
