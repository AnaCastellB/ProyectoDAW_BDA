package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.ComentarioBlogDAO;
import com.faroria.faroriagame.model.ComentarioBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioBlogController {

    @Autowired
    private ComentarioBlogDAO dao;

    @GetMapping
    public List<ComentarioBlog> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public ComentarioBlog obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody ComentarioBlog c) {
        dao.save(c);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody ComentarioBlog c) {
        c.setId(id);
        dao.update(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
