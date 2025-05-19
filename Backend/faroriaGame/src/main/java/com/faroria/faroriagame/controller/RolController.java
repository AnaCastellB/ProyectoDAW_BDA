package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.RolDAO;
import com.faroria.faroriagame.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolDAO dao;

    @GetMapping
    public List<Rol> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Rol obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody Rol rol) {
        dao.save(rol);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Rol rol) {
        rol.setId(id);
        dao.update(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
