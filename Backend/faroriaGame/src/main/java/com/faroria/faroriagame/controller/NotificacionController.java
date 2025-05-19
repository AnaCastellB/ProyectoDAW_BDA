package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.NotificacionDAO;
import com.faroria.faroriagame.model.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class NotificacionController {

    @Autowired
    private NotificacionDAO dao;

    @GetMapping
    public List<Notificacion> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Notificacion obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody Notificacion noti) {
        dao.save(noti);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Notificacion noti) {
        noti.setId(id);
        dao.update(noti);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
