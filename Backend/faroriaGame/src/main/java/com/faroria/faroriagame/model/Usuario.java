package com.faroria.faroriagame.model;
import java.sql.Timestamp;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String avatarUrl;
    private int rolId;
    private Timestamp fechaCreacion;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public int getRolId() { return rolId; }
    public void setRolId(int rolId) { this.rolId = rolId; }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
