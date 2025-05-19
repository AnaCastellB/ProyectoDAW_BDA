package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.EntradaBlog;
import java.util.List;

public interface EntradaBlogDAO {
    List<EntradaBlog> findAll();
    EntradaBlog findById(int id);
    void save(EntradaBlog entrada);
    void update(EntradaBlog entrada);
    void delete(int id);
}
