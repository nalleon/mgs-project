package es.ies.puerto.mgs.project.model.db.jpa.dao;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoMGSCharacter extends JpaRepository<MGSCharacter, Integer> {
    @Modifying
    @Query("DELETE FROM MGSCharacter mc WHERE mc.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
