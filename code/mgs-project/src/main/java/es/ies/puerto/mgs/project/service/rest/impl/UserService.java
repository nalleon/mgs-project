package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nalleon
 */
@Component
@Transactional
public class UserService implements IService<UserDTO> {
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
    public boolean add(UserDTO userDTO) {
        if (userDTO == null){
            return false;
        }
        if(repository.existsById(userDTO.getId())){
            return false;
        }

        repository.save(IUserMapper.INSTANCE.toEntity(userDTO));
        return true;
    }

    @Override
    public boolean update(int id, UserDTO userDTO) throws Exception {
        try {
            User toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                User aux = IUserMapper.INSTANCE.toEntity(userDTO);
                toUpdate.setName(aux.getName());
                toUpdate.setEmail(aux.getEmail());
                toUpdate.setRole(aux.getRole());
                toUpdate.setPassword(aux.getPassword());
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
    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IUserMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public UserDTO getById(int id) {
        User result = repository.findById(id).orElse(null);;

        if(result != null) {
            return IUserMapper.INSTANCE.toDTO(result);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
