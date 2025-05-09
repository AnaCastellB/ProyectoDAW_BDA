package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Notificacion;
import java.util.List;

public interface NotificacionDAO {
    List<Notificacion> findAll();
    Notificacion findById(int id);
    void save(Notificacion noti);
    void update(Notificacion noti);
    void delete(int id);
}
