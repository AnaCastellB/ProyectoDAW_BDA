package model;
import java.sql.Timestamp;

public class HistorialLogin {
    private int id;
    private int usuarioId;
    private String ip;
    private Timestamp fecha;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getIp() { return  ip; }
    public void setIp(String ip) { this.ip = ip; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }
}