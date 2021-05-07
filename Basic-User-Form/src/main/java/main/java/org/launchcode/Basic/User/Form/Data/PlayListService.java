package main.java.org.launchcode.Basic.User.Form.Data;

import main.java.org.launchcode.Basic.User.Form.Models.Playlists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component
public class PlayListService {

    @Autowired
    private PlayListRepository playlistrepository;

    public List<Playlists> listAll(){
        return playlistrepository.findAll();
    }

    public void save(Playlists playlists){
        playlistrepository.save(playlists);
    }

    public Playlists get(Long id){
        return playlistrepository.findById(id).get();
    }

    public void delete(Long id){
        playlistrepository.deleteById(id);
    }
}
