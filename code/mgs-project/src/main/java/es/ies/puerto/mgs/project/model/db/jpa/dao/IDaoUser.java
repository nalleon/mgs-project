package es.ies.puerto.mgs.project.model.db.jpa.dao;

import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoUser extends JpaRepository<User, Integer> {
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
