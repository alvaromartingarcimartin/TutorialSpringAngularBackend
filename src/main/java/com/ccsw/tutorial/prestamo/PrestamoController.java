package com.ccsw.tutorial.prestamo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
@RequestMapping(value = "/prestamo")
@RestController
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @Autowired
    BeanMapper beanMapper;

    /*
     * @RequestMapping(path = "", method = RequestMethod.GET) public
     * List<PrestamoDto> find(@RequestParam(value = "gameId", required = false) Long
     * gameId,
     * 
     * @RequestParam(value = "clientId", required = false) Long clientId) {
     * 
     * 
     * List<Prestamo> prestamos = prestamoService.find(gameId, clientId);
     * 
     * return beanMapper.mapList(prestamos, PrestamoDto.class);
     * 
     * }
     */

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param dto
     * @return
     * @throws ParseException
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamoDto> findPage(@RequestParam(value = "gameId", required = false) Long gameId,
            @RequestParam(value = "clientId", required = false) Long clientId,
            @RequestParam(value = "fecha", required = false) String fecha, @RequestBody PrestamoSearchDto dto)
            throws ParseException {

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha2 = new Date();
        if (fecha.isEmpty()) {
            fecha2 = null;
        } else {
            fecha2 = df1.parse(fecha);
        }

        // System.out.println(fecha2);
        return this.beanMapper.mapPage(this.prestamoService.find(gameId, clientId, fecha2, dto), PrestamoDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id,
            @RequestParam(value = "gameId", required = false) Long gameId,
            @RequestParam(value = "clientId", required = false) Long clientId,
            @RequestParam(value = "fecha", required = false) String fecha, @RequestBody PrestamoDto dto)
            throws ParseException {

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha2 = new Date();
        if (fecha.isEmpty()) {
            fecha2 = null;
        } else {
            fecha2 = df1.parse(fecha);
        }

        if (!prestamoService.findClient(clientId, fecha2) && !prestamoService.findGame(gameId, fecha2)) {
            prestamoService.save(id, dto);
        } else {
            System.out.println("El cliente o el juego están ocupados.");
        }
    }

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param id PK de la entidad
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.prestamoService.delete(id);
    }

    /**
     * Recupera un listado de autores
     * 
     * @return
     */
    /*
     * @RequestMapping(path = "", method = RequestMethod.GET) public
     * List<PrestamoDto> findAll() {
     * 
     * List<Prestamo> prestamos = this.prestamoService.findAll();
     * 
     * return this.beanMapper.mapList(prestamos, PrestamoDto.class); }
     */

}
