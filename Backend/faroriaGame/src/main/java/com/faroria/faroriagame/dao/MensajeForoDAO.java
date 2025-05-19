package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.MensajeForo;
import java.util.List;

public interface MensajeForoDAO {
    List<MensajeForo> findAll();
    MensajeForo findById(int id);
    void save(MensajeForo mensaje);
    void update(MensajeForo mensaje);
    void delete(int id);
}
