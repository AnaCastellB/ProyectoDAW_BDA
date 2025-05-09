package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class EntradaDAOImpl implements EntradaBlogDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EntradaBlog> findAll() {
        return jdbcTemplate.query("SELECT * FROM entradas_blog", new EntradaBlogRowMapper());
    }

    @Override
    public EntradaBlog findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM entradas_blog WHERE id = ?", new EntradaBlogRowMapper(), id);
    }

    @Override
    public void save(EntradaBlog entrada) {
        jdbcTemplate.update(
                "INSERT INTO entradas_blog (titulo, contenido, autor_id) VALUES (?, ?, ?)",
                entrada.getTitulo(), entrada.getContenido(), entrada.getAutorId()
        );
    }

    @Override
    public void update(EntradaBlog entrada) {
        jdbcTemplate.update(
                "UPDATE entradas_blog SET titulo = ?, contenido = ? WHERE id = ?",
                entrada.getTitulo(), entrada.getContenido(), entrada.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM entradas_blog WHERE id = ?", id);
    }

    private static class EntradaBlogRowMapper implements RowMapper<EntradaBlog> {
        @Override
        public EntradaBlog mapRow(ResultSet rs, int rowNum) throws SQLException {
            EntradaBlog e = new EntradaBlog();
            e.setId(rs.getInt("id"));
            e.setTitulo(rs.getString("titulo"));
            e.setContenido(rs.getString("contenido"));
            e.setAutorId(rs.getInt("autor_id"));
            e.setFecha(rs.getTimestamp("fecha"));
            return e;
        }
    }
}
