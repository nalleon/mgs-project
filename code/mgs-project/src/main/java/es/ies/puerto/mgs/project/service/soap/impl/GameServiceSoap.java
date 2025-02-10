package es.ies.puerto.mgs.project.service.soap.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private IService<Game> service;

    /**
     * Default constructor of the class
     */
    public GameServiceSoap(){}


    /**
     * Setter of the service
     * @param service restfull
     */
    @Autowired
    public void setService(IService<Game> service) {
        this.service = service;
    }
    @Override
    public boolean add(GameDTO gameDTO) {
        return service.add(IGameMapper.INSTANCE.toEntity(gameDTO));
    }

    @Override
    public boolean update(GameDTO gameDTO) throws Exception {
        return service.update(gameDTO.getId(), IGameMapper.INSTANCE.toEntity(gameDTO));
    }

    @WebResult(name="game")

    @Override
    public List<GameDTO> getAll() {
        return service.getAll().stream()
                .map(IGameMapper.INSTANCE::toDTO).toList();

        /*new GameDTO(
                        item.getId(),
                        item.getName(),
                        item.getGameCharacters().stream()
                                .map(ch -> new MGSCharacterDTO(
                                        ch.getId(),
                                        ch.getName(),
                                        ch.getCodename(),
                                        ch.getAge(),
                                        ch.isStatus(),
                                        IArtistMapper.INSTANCE.toDTO(ch.getArtist())
                                ))
                                .collect(Collectors.toSet()),
                        new DirectorDTO(item.getDirector().getDirectorId(), item.getDirector().getFullName())
                ))
                .collect(Collectors.toList());*/
    }

    @Override
    public GameDTO getById(int id) {
        return IGameMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
