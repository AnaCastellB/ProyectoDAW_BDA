package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.ComentarioBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ComentarioBlogImpl implements ComentarioBlogDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ComentarioBlog> findAll() {
        return jdbcTemplate.query("SELECT * FROM comentarios_blog", new ComentarioBlogRowMapper());
    }

    @Override
    public ComentarioBlog findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM comentarios_blog WHERE id = ?", new ComentarioBlogRowMapper(), id);
    }

    @Override
    public void save(ComentarioBlog c) {
        jdbcTemplate.update(
                "INSERT INTO comentarios_blog (entrada_id, usuario_id, contenido) VALUES (?, ?, ?)",
                c.getEntradaId(), c.getUsuarioId(), c.getContenido()
        );
    }

    @Override
    public void update(ComentarioBlog c) {
        jdbcTemplate.update(
                "UPDATE comentarios_blog SET contenido = ? WHERE id = ?",
                c.getContenido(), c.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM comentarios_blog WHERE id = ?", id);
    }

    private static class ComentarioBlogRowMapper implements RowMapper<ComentarioBlog> {
        @Override
        public ComentarioBlog mapRow(ResultSet rs, int rowNum) throws SQLException {
            ComentarioBlog c = new ComentarioBlog();
            c.setId(rs.getInt("id"));
            c.setEntradaId(rs.getInt("entrada_id"));
            c.setUsuarioId(rs.getInt("usuario_id"));
            c.setContenido(rs.getString("contenido"));
            c.setFecha(rs.getTimestamp("fecha"));
            return c;
        }
    }
}
