package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author nalleon
 */
@Component
public class UserService implements IServiceJPA<UserDTO> {
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
     * @param repository
     */
    @Autowired
    public void setIDaoUser(IDaoUser repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(UserDTO userDTO) {
        if (userDTO == null){
            return false;
        }
        repository.save(IUserMapper.INSTANCE.toEntity(userDTO));
        return true;
    }

    @Override
    public boolean update(int id, UserDTO userDTO) throws Exception {
        try {
            User toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            User aux = IUserMapper.INSTANCE.toEntity(userDTO);
            toUpdate.setName(aux.getName());
            toUpdate.setEmail(aux.getEmail());
            toUpdate.setRole(aux.getRole());
            toUpdate.setPassword(aux.getPassword());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<UserDTO> getAll() {
        List<User> users = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users){
            userDTOS.add(IUserMapper.INSTANCE.toDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO getById(int id) {
        if (!repository.existsById(id)) {
            return null;
        }

        UserDTO result = null;

        List<UserDTO> list = getAll();

        for (UserDTO userDTO: list){
            if (userDTO.getId() == id){
                result = userDTO;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
