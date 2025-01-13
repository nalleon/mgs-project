package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.MGSCharacterService;
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
public class MGSCharacterServiceSoap implements IServiceSoap<MGSCharacterDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterServiceSoap.class);

    private IService<MGSCharacterDTO> service;

    /**
     * Default constructor of the class
     */
    public MGSCharacterServiceSoap(){}

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(MGSCharacterService service) {
        this.service = service;
    }

    @Override
    public boolean add(MGSCharacterDTO mgsCharacterDTO) {
        return service.add(mgsCharacterDTO);
    }

    @Override
    public boolean update(MGSCharacterDTO mgsCharacterDTO) throws Exception {
        return service.update(mgsCharacterDTO.getId(), mgsCharacterDTO);
    }

    @WebResult(name="mgsCharacter")
    @Override
    public List<MGSCharacterDTO> getAll() {
        return service.getAll();
    }

    @Override
    public MGSCharacterDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
