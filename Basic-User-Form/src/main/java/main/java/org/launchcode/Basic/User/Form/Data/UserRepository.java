package main.java.org.launchcode.Basic.User.Form.Data;

import main.java.org.launchcode.Basic.User.Form.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {


}
