package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.ReporteDAO;
import com.faroria.faroriagame.model.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private ReporteDAO dao;

    @GetMapping
    public List<Reporte> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Reporte obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody Reporte r) {
        dao.save(r);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Reporte r) {
        r.setId(id);
        dao.update(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
