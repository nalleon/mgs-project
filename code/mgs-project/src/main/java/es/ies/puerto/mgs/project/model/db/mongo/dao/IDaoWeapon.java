package es.ies.puerto.mgs.project.model.db.mongo.dao;

import es.ies.puerto.mgs.project.model.entities.Weapon;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author nalleon
 */
@Repository
public interface IDaoWeapon extends MongoRepository<Weapon, Integer> {
    @Modifying
    @Query("DELETE FROM Weapon w WHERE w.id=:id")
    int deleteItemById(@Param("id") Integer id);
}
