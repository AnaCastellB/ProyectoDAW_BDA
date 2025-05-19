package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.ComentarioBlog;
import java.util.List;

public interface ComentarioBlogDAO {
    List<ComentarioBlog> findAll();
    ComentarioBlog findById(int id);
    void save(ComentarioBlog comentario);
    void update(ComentarioBlog comentario);
    void delete(int id);
}
