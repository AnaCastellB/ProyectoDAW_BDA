package model;

import java.sql.Timestamp;

public class Reporte {
    private int id;
    private String tipo; // 'usuario', 'foro', etc.
    private int referenciaId;
    private int usuarioId;
    private String razon;
    private Timestamp fecha;

    // Getters y Setters
}