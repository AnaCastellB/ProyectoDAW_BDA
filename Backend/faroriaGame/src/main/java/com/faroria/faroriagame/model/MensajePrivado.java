package com.faroria.faroriagame.model;
import java.sql.Timestamp;

public class MensajePrivado {
    private int id;
    private int remitenteId;
    private int destinatarioId;
    private String contenido;
    private boolean leido;
    private Timestamp fecha;

    // Getters y Setters


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRemitenteId() {
        return remitenteId;
    }
    public void setRemitenteId(int remitenteId) {
        this.remitenteId = remitenteId;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }
    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isLeido() {
        return leido;
    }
    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public Timestamp getFecha() {
        return fecha;
    }

}