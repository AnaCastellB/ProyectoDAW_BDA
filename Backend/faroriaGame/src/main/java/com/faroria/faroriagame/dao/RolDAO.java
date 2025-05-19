package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Rol;
import java.util.List;

public interface RolDAO {
    List<Rol> findAll();
    Rol findById(int id);
    void save(Rol rol);
    void update(Rol rol);
    void delete(int id);
}
