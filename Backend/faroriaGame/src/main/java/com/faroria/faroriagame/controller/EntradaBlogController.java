package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.EntradaBlogDAO;
import com.faroria.faroriagame.model.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class EntradaBlogController {

    @Autowired
    private EntradaBlogDAO dao;

    @GetMapping
    public List<EntradaBlog> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public EntradaBlog obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody EntradaBlog e) {
        dao.save(e);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody EntradaBlog e) {
        e.setId(id);
        dao.update(e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
