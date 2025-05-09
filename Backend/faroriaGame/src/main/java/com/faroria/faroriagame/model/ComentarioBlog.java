package com.faroria.faroriagame.model;
import java.sql.Timestamp;

public class ComentarioBlog {
    private int id;
    private int entradaId;
    private int usuarioId;
    private String contenido;
    private Timestamp fecha;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEntradaId() { return entradaId; }
    public void setEntradaId(int entradaId) { this.entradaId =  entradaId;}

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }

}