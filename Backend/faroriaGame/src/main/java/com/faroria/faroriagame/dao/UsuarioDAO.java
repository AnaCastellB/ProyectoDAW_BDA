package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    List<Usuario> findAll();
    Usuario findById(int id);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(int id);
}
