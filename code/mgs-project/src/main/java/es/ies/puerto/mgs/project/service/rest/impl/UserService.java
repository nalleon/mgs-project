package es.ies.puerto.mgs.project.service.rest.impl;


import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nalleon
 */
@Component
@Transactional
public class UserService implements IService<User> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private IDaoUser repository;

    /**
     * Default constructor of the class
     */
    public UserService(){}

    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoUser repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(User user) {
        if (user == null){
            return false;
        }

        if(repository.existsById(user.getId())){
            return false;
        }

        repository.save((user));
        return true;
    }

    @Override
    public boolean update(int id, User user) throws Exception {
        try {
            User toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setName(user.getName());
                toUpdate.setEmail(user.getEmail());
                toUpdate.setRole(user.getRole());
                toUpdate.setPassword(user.getPassword());
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
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getByName(String name) {
        return repository.findUserByName(name).orElse(null);
    }

    public User getByEmail(String email) {
        return repository.findUserByEmail(email).orElse(null);
    }


    @Override
    public boolean delete(int id) {
        if(id == 1){
            return false;
        }
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
