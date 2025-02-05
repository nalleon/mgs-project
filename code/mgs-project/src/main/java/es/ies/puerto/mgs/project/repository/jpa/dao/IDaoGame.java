package es.ies.puerto.mgs.project.repository.jpa.dao;

import es.ies.puerto.mgs.project.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoGame extends JpaRepository<Game, Integer> {
    @Modifying
    @Query("DELETE FROM Game g WHERE g.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
