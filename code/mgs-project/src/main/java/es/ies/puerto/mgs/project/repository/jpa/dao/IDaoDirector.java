package es.ies.puerto.mgs.project.repository.jpa.dao;

import es.ies.puerto.mgs.project.model.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoDirector extends JpaRepository<Director, Integer> {
    @Modifying
    @Query("DELETE FROM Director d WHERE d.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
