package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.HistorialLogin;
import java.util.List;

public interface HistorialLoginDAO {
    List<HistorialLogin> findAll();
    HistorialLogin findById(int id);
    void save(HistorialLogin login);
    void delete(int id);
}
