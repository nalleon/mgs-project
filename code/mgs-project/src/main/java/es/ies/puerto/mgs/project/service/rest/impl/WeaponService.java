package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Weapon;

import es.ies.puerto.mgs.project.service.interfaces.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class WeaponService implements IService<Weapon> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    private IDaoWeapon repository;

    /**
     * Default constructor of the class
     */
    public WeaponService(){}

    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoWeapon repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Weapon weapon) {
        if (weapon == null){
            return false;
        }
        if(repository.existsById(weapon.getId())){
            return false;
        }

        repository.save(weapon);
        return true;
    }

    @Override
    public boolean update(int id, Weapon weapon) {
        try {
            Weapon toUpdate = repository.findById(id).orElse(null);
            if(toUpdate!= null) {
                toUpdate.setName(weapon.getName());
                toUpdate.setType(weapon.getType());
                repository.save(toUpdate);
                return true;
            } else {
                return false;
            }

        } catch (RuntimeException e){
            return false;
        }
    }

    @Override
    public List<Weapon> getAll() {
        return repository.findAll();
    }

    @Override
    public Weapon getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
