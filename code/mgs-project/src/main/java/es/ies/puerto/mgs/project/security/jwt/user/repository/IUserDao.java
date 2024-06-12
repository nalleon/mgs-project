package es.ies.puerto.mgs.project.security.jwt.user.repository;

import es.ies.puerto.mgs.project.security.jwt.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//extends JpaRepository<User, Integer>
public interface IUserDao  {
    //Optional<User> findByUsername(String username);
}
