package com.ccsw.tutorial.prestamo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "fechainicio", nullable = false)
    private Date fechainicio;

    @Column(name = "fechafin", nullable = false)
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
    public Client getClient() {

        return this.client;
    }

    /**
     * @param category new value of {@link #getCategory}.
     */
    public void setClient(Client client) {

        this.client = client;
    }

    /**
     * @return author
     */
    public Game getGame() {

        return this.game;
    }

    /**
     * @param author new value of {@link #getAuthor}.
     */
    public void setGame(Game game) {

        this.game = game;
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
