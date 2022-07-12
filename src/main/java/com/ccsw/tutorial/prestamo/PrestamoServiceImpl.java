package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    GameService gameService;

    @Autowired
    ClientService clientService;

    /**
     * {@inheritDoc}
     */

    @Override
    public Page<Prestamo> find(Long gameId, Long clientId, Date fecha, PrestamoSearchDto dto) {

        return this.prestamoRepository.find(gameId, clientId, fecha, dto.getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, PrestamoDto dto) {

        Prestamo prestamo = null;

        if (id == null)
            prestamo = new Prestamo();
        else
            prestamo = this.prestamoRepository.findById(id).orElse(null);

        BeanUtils.copyProperties(dto, prestamo, "id", "game", "client");

        prestamo.setGame(gameService.get(dto.getGame().getId()));
        prestamo.setClient(clientService.get(dto.getClient().getId()));

        this.prestamoRepository.save(prestamo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.prestamoRepository.deleteById(id);

    }

    /**
     * {@inheritDoc}
     */
    /*
     * @Override public Page<Prestamo> findPage(PrestamoSearchDto dto) {
     * 
     * return this.prestamoRepository.findAll(dto.getPageable()); }
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Prestamo> findAll() {

        return (List<Prestamo>) this.prestamoRepository.findAll();
    }

    public boolean findClient(Long clientId, Date fecha) {
        if (this.prestamoRepository.findClient(clientId, fecha) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findGame(Long gameId, Date fecha) {
        if (this.prestamoRepository.findGame(gameId, fecha) != null) {
            return true;
        } else {
            return false;
        }
    }
}
