package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.prestamo.model.Prestamo;
import com.ccsw.tutorial.prestamo.model.PrestamoDto;
import com.ccsw.tutorial.prestamo.model.PrestamoSearchDto;

/**
 * @author ccsw
 */
public interface PrestamoService {

    /**
     * Recupera los juegos filtrando opcionalmente por título y/o categoría
     * 
     * @param title
     * @param idCategory
     * @return
     */
    Page<Prestamo> find(Long gameId, Long clientId, Date fecha, PrestamoSearchDto dto);

    /**
     * Guarda o modifica un juego, dependiendo de si el id está o no informado
     * 
     * @param id
     * @param dto
     */
    void save(Long id, PrestamoDto dto);

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param id
     */
    void delete(Long id);

    /**
     * Recupera un listado de autores
     * 
     * @return
     */
    List<Prestamo> findAll();

    /**
     * Recupera un listado de autores
     * 
     * @return
     */
    boolean findClient(Long clientId, Date fecha);

    boolean findGame(Long gameId, Date fecha);

}
