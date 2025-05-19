package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ForoDAOImpl implements ForoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Foro> findAll() {
        return jdbcTemplate.query("SELECT * FROM foros", new ForoRowMapper());
    }

    @Override
    public Foro findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM foros WHERE id = ?", new ForoRowMapper(), id);
    }

    @Override
    public void save(Foro foro) {
        jdbcTemplate.update(
                "INSERT INTO foros (titulo, descripcion, usuario_id, categoria_id) VALUES (?, ?, ?, ?)",
                foro.getTitulo(), foro.getDescripcion(), foro.getUsuarioId(), foro.getCategoriaId()
        );
    }

    @Override
    public void update(Foro foro) {
        jdbcTemplate.update(
                "UPDATE foros SET titulo = ?, descripcion = ?, usuario_id = ?, categoria_id = ? WHERE id = ?",
                foro.getTitulo(), foro.getDescripcion(), foro.getUsuarioId(), foro.getCategoriaId(), foro.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM foros WHERE id = ?", id);
    }

    private static class ForoRowMapper implements RowMapper<Foro> {
        @Override
        public Foro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Foro f = new Foro();
            f.setId(rs.getInt("id"));
            f.setTitulo(rs.getString("titulo"));
            f.setDescripcion(rs.getString("descripcion"));
            f.setUsuarioId(rs.getInt("usuario_id"));
            f.setCategoriaId(rs.getObject("categoria_id") != null ? rs.getInt("categoria_id") : null);
            f.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
            return f;
        }
    }
}
