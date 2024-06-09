package es.ies.puerto.mgs.project.model.db.jpa.dao;

import es.ies.puerto.mgs.project.model.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nalleon
 */
public interface IDaoArtist extends JpaRepository<Artist, Integer> {
}
