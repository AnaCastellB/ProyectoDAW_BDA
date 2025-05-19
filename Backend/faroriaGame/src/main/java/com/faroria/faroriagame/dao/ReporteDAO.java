package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Reporte;
import java.util.List;

public interface ReporteDAO {
    List<Reporte> findAll();
    Reporte findById(int id);
    void save(Reporte reporte);
    void update(Reporte reporte);
    void delete(int id);
}
