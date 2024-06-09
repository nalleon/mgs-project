package es.ies.puerto.mgs.project.model.db.jpa.dao;

import es.ies.puerto.mgs.project.model.entities.Codename;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nalleon
 */
public interface IDaoCodename extends JpaRepository<Codename, String> {
}
