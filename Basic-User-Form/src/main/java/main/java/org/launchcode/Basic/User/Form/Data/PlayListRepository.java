package main.java.org.launchcode.Basic.User.Form.Data;

import main.java.org.launchcode.Basic.User.Form.Models.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PlayListRepository extends JpaRepository<Playlists, Long> {

}
