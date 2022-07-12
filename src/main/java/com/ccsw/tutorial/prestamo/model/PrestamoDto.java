package com.ccsw.tutorial.prestamo.model;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * @author ccsw
 */
public class PrestamoDto {

    private Long id;

    private GameDto game;

    private ClientDto client;

    private Date fechainicio;

    private Date fechafin;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return category
     */
    public GameDto getGame() {

        return this.game;
    }

    /**
     * @param category new value of {@link #getCategory}.
     */
    public void setGame(GameDto game) {

        this.game = game;
    }

    /**
     * @return author
     */
    public ClientDto getClient() {

        return this.client;
    }

    /**
     * @param author new value of {@link #getAuthor}.
     */
    public void setClient(ClientDto client) {

        this.client = client;
    }

    /**
     * @return title
     */
    public Date getFechainicio() {

        return this.fechainicio;
    }

    /**
     * @param title new value of {@link #getTitle}.
     */
    public void setFechainicio(Date fechainicio) {

        this.fechainicio = fechainicio;
    }

    /**
     * @return age
     */
    public Date getFechafin() {

        return this.fechafin;
    }

    /**
     * @param age new value of {@link #getAge}.
     */
    public void setFechafin(Date fechafin) {

        this.fechafin = fechafin;
    }

}
