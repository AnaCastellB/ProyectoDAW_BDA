package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.HistorialLoginDAO;
import com.faroria.faroriagame.model.HistorialLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
@CrossOrigin(origins = "*")
public class HistorialLoginController {

    @Autowired
    private HistorialLoginDAO dao;

    @GetMapping
    public List<HistorialLogin> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public HistorialLogin obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody HistorialLogin login) {
        dao.save(login);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
