package model;
import java.sql.Timestamp;

public class Foros {
    private int id;
    private String titulo;
    private String descripcion;
    private int usuarioId;
    private int categoriaId;
    private Timestamp fechaCreacion;


    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String nombre) { this.descripcion = descripcion; }

    public int getUsuarioIdId() { return usuarioId; }
    public void setUsuarioIdId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }

    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
