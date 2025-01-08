package es.ies.puerto.mgs.project.service.soap;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Component
public class RoleServiceSopa implements IServiceJPA<RoleDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleServiceSopa.class);

    private IDaoRole repository;

    /**
     * Default constructor of the class
     */
    public RoleServiceSopa(){}

    /**
     * Setter of the dao
     * @param repository
     */
    @Autowired
    public void setIDaoRole(IDaoRole repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(RoleDTO roleDTO) {
        if (roleDTO == null){
            return false;
        }
        repository.save(IRoleMapper.INSTANCE.toEntity(roleDTO));
        return true;
    }

    @Override
    public boolean update(int id, RoleDTO roleDTO) throws Exception {
        try {
            Role toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            Role aux = IRoleMapper.INSTANCE.toEntity(roleDTO);
            toUpdate.setName(aux.getName());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = repository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles){
            roleDTOS.add(IRoleMapper.INSTANCE.toDTO(role));
        }
        return roleDTOS;
    }

    @Override
    public RoleDTO getById(int id) {
        if (!repository.existsById(id)) {
            return null;
        }

        RoleDTO result = null;

        List<RoleDTO> list = getAll();

        for (RoleDTO roleDTO: list){
            if (roleDTO.getId() == id){
                result = roleDTO;
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
