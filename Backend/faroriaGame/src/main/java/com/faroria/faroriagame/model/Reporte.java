package com.faroria.faroriagame.model;

import java.sql.Timestamp;

public class Reporte {
    private int id;
    private String tipo; // 'usuario', 'foro', etc.
    private int referenciaId;
    private int usuarioId;
    private String razon;
    private Timestamp fecha;

    // Getters y Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getReferenciaId() {
        return referenciaId;
    }
    public void setReferenciaId(int referenciaId) {
        this.referenciaId = referenciaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}