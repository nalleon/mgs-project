package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
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
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class RoleServiceSoap implements IServiceSoap<RoleDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleServiceSoap.class);

    private IService<RoleDTO> service;

    /**
     * Default constructor of the class
     */
    public RoleServiceSoap(){}

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(RoleService service) {
        this.service = service;
    }

    @Override
    public boolean add(RoleDTO roleDTO) {
        return service.add(roleDTO);
    }

    @Override
    public boolean update(RoleDTO roleDTO) throws Exception {
        return service.update(roleDTO.getId(), roleDTO);
    }

    @WebResult(name="role")
    @Override
    public List<RoleDTO> getAll() {
        return service.getAll();
    }

    @Override
    public RoleDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
