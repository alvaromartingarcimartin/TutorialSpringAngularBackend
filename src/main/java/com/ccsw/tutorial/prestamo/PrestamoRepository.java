package com.ccsw.tutorial.prestamo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.prestamo.model.Prestamo;

/**
 * @author ccsw
 */
public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param page
     * @return
     */
    Page<Prestamo> findAll(Pageable pageable);

    @Query(value = "select p from Prestamo p where (:gameId is null or p.game.id = :gameId) and (:clientId is null or p.client.id = :clientId) and (:fecha is null or (p.fechainicio <= :fecha and p.fechafin >= :fecha))")
    Page<Prestamo> find(@Param("gameId") Long gameId, @Param("clientId") Long clientId, @Param("fecha") Date fecha,
            Pageable pageable);

    @Query(value = "select p from Prestamo p where (p.client.id = :clientId) and (p.fechafin >= :fecha)")
    Prestamo findClient(@Param("clientId") Long clientId, @Param("fecha") Date fecha);

    @Query(value = "select p from Prestamo p where (p.game.id = :gameId) and (p.fechafin >= :fecha)")
    Prestamo findGame(@Param("gameId") Long gameId, @Param("fecha") Date fecha);

}
