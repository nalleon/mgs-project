package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.mapper.struc.IArtistMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Service
public class ArtistService implements IService<ArtistDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ArtistService.class);

    private IDaoArtist iDaoArtist;

    /**
     * Default constructor of the class
     */
    public ArtistService (){}

    /**
     * Setter of the dao
     * @param iDaoArtist
     */
    @Autowired
    public void setiDaoArtist(IDaoArtist iDaoArtist) {
        this.iDaoArtist = iDaoArtist;
    }

    @Override
    public void add(ArtistDTO artistDTO) {
        iDaoArtist.save(IArtistMapper.INSTANCE.toEntity(artistDTO));
    }

    @Override
    public void update(ArtistDTO artistDTO) {
        Artist artist = iDaoArtist.findById(artistDTO.getArtistId()).orElseThrow(
                () -> new RuntimeException("Can not find by ID")
        );
        iDaoArtist.save(artist);
    }

    @Override
    public List<ArtistDTO> getAll() {
        List<Artist> artists = iDaoArtist.findAll();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist artist : artists){
            artistDTOS.add(IArtistMapper.INSTANCE.toDTO(artist));
        }
        return artistDTOS;
    }

    @Override
    public ArtistDTO getById(int id) {
        Artist artist = iDaoArtist.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID")
        );
        return IArtistMapper.INSTANCE.toDTO(artist);

    }

    @Override
    public void delete(int id) {
        Artist artist = iDaoArtist.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iDaoArtist.delete(artist);
    }
}
