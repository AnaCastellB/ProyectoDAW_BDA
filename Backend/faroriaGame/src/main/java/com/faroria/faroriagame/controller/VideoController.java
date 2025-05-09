package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.VideoDAO;
import com.faroria.faroriagame.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "*")
public class VideoController {

    @Autowired
    private VideoDAO dao;

    @GetMapping
    public List<Video> obtenerTodos() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Video obtenerPorId(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void crear(@RequestBody Video v) {
        dao.save(v);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody Video v) {
        v.setId(id);
        dao.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        dao.delete(id);
    }
}
