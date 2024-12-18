package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
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

    private IDaoUser iDaoUser;

    /**
     * Default constructor of the class
     */
    public UserService(){}

    /**
     * Setter of the dao
     * @param iDaoUser
     */
    @Autowired
    public void setIDaoUser(IDaoUser iDaoUser) {
        this.iDaoUser = iDaoUser;
    }

    @Override
    public boolean addUpdate(UserDTO userDTO) {
        if (userDTO == null){
            return false;
        }
        iDaoUser.save(IUserMapper.INSTANCE.toEntity(userDTO));
        return true;
    }


    @Override
    public List<UserDTO> getAll() {
        List<User> users = iDaoUser.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users){
            userDTOS.add(IUserMapper.INSTANCE.toDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO getById(int id) {
        if (!iDaoUser.existsById(id)) {
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
        if (!iDaoUser.existsById(id)) {
            return false;
        }
        iDaoUser.deleteById(id);
        return true;
    }
}
