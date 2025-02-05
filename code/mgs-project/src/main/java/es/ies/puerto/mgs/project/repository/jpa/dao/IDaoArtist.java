package es.ies.puerto.mgs.project.repository.jpa.dao;
import es.ies.puerto.mgs.project.model.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoArtist extends JpaRepository<Artist, Integer> {
    @Modifying
    @Query("DELETE FROM Artist a WHERE a.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
