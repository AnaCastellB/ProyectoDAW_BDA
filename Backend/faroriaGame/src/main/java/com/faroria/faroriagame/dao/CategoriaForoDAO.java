package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.CategoriaForo;
import java.util.List;

public interface CategoriaForoDAO {
    List<CategoriaForo> findAll();
    CategoriaForo findById(int id);
    void save(CategoriaForo categoria);
    void update(CategoriaForo categoria);
    void delete(int id);
}
