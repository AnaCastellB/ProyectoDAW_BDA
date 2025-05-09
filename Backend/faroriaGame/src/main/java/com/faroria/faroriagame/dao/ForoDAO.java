package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Foro;

import java.util.List;

public interface ForoDAO {
    List<Foro> findAll();
    Foro findById(int id);
    void save(Foro foro);
    void update(Foro foro);
    void delete(int id);
}
