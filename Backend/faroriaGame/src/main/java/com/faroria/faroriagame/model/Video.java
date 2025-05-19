package com.faroria.faroriagame.model;
import java.sql.Timestamp;

public class Video {
    private int id;
    private String titulo;
    private String url;
    private int subidoPor;
    private Timestamp fecha;

    // Getters y Setters

    public int getId() { return id;}
    public void setId(int id) { this.id = id; }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public int getSubidoPor() {
        return subidoPor;
    }
    public void setSubidoPor(int subidoPor) {
        this.subidoPor = subidoPor;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}