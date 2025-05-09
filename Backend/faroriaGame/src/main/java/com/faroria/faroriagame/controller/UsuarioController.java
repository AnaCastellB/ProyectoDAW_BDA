package com.faroria.faroriagame.controller;

import com.faroria.faroriagame.dao.UsuarioDAO;
import com.faroria.faroriagame.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Para permitir llamadas desde tu frontend
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable int id) {
        return usuarioDAO.findById(id);
    }

    @PostMapping
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioDAO.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioDAO.delete(id);
    }
}
