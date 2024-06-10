package es.ies.puerto.mgs.project.model.db.mongo.dao;

import es.ies.puerto.mgs.project.model.entities.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoWeapon extends MongoRepository<Weapon, Integer> {
}
