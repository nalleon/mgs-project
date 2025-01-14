package es.ies.puerto.mgs.project.service.soap.impl;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
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
public class GameServiceSoap implements IServiceSoap<GameDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(GameServiceSoap.class);

    private IService<GameDTO> service;

    /**
     * Default constructor of the class
     */
    public GameServiceSoap(){}

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(GameService service) {
        this.service = service;
    }

    @Override
    public boolean add(GameDTO gameDTO) {
        return service.add(gameDTO);
    }

    @Override
    public boolean update(GameDTO gameDTO) throws Exception {
        return service.update(gameDTO.getId(), gameDTO);
    }

    @WebResult(name="game")

    @Override
    public List<GameDTO> getAll() {
        return service.getAll();
    }

    @Override
    public GameDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
