package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.ForoDAO;
import com.faroria.faroriagame.model.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
@CrossOrigin(origins = "*")
public class ForoController {

    @Autowired
    private ForoDAO foroDAO;

    @GetMapping
    public List<Foro> obtenerTodos() {
        return foroDAO.findAll();
    }

    @GetMapping("/{id}")
    public Foro obtenerPorId(@PathVariable int id) {
        return foroDAO.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody Foro foro) {
        foroDAO.save(foro);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Foro foro) {
        foro.setId(id);
        foroDAO.update(foro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        foroDAO.delete(id);
    }
}
