package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.CategoriaForoDAO;
import com.faroria.faroriagame.model.CategoriaForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaForoController {

    @Autowired
    private CategoriaForoDAO dao;

    @GetMapping
    public List<CategoriaForo> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaForo obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody CategoriaForo c) {
        dao.save(c);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody CategoriaForo c) {
        c.setId(id);
        dao.update(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
