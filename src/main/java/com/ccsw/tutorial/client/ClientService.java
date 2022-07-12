package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

/**
 * @author ccsw
 *
 */
public interface ClientService {

    /**
     * Recupera una {@link com.ccsw.tutorial.client.model.Client} a partir de su ID
     * 
     * @param id
     * @return
     */
    Client get(Long id);

    /**
     * Método para recuperar todas las
     * {@link com.ccsw.tutorial.category.model.Category}
     * 
     * @return
     */
    List<Client> findAll();

    /**
     * Método para crear o actualizar una
     * {@link com.ccsw.tutorial.category.model.Category}
     * 
     * @param dto
     * @return
     */
    void save(Long id, ClientDto dto);

    /**
     * Método para borrar una {@link com.ccsw.tutorial.category.model.Category}
     * 
     * @param id
     */
    void delete(Long id);

}
