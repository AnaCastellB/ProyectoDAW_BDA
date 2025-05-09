package model;
import java.sql.Timestamp;

public class MensajeForo {
    private int id;
    private int foroId;
    private int usuarioId;
    private String contenido;
    private Timestamp fecha;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getForoId() { return foroId; }
    public void setForoId(int foroId) { this.foroId = foroId; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public Timestamp getFecha() { return fecha; }
    public  void setFecha(Timestamp fecha) { this.fecha = fecha; }
}