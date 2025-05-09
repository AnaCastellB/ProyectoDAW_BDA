package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.MensajeForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class MensajeForoDAOImpl implements MensajeForoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MensajeForo> findAll() {
        return jdbcTemplate.query("SELECT * FROM mensajes_foro", new MensajeRowMapper());
    }

    @Override
    public MensajeForo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mensajes_foro WHERE id = ?", new MensajeRowMapper(), id);
    }

    @Override
    public void save(MensajeForo mensaje) {
        jdbcTemplate.update(
                "INSERT INTO mensajes_foro (foro_id, usuario_id, contenido) VALUES (?, ?, ?)",
                mensaje.getForoId(), mensaje.getUsuarioId(), mensaje.getContenido()
        );
    }

    @Override
    public void update(MensajeForo mensaje) {
        jdbcTemplate.update(
                "UPDATE mensajes_foro SET foro_id = ?, usuario_id = ?, contenido = ? WHERE id = ?",
                mensaje.getForoId(), mensaje.getUsuarioId(), mensaje.getContenido(), mensaje.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM mensajes_foro WHERE id = ?", id);
    }

    private static class MensajeRowMapper implements RowMapper<MensajeForo> {
        @Override
        public MensajeForo mapRow(ResultSet rs, int rowNum) throws SQLException {
            MensajeForo m = new MensajeForo();
            m.setId(rs.getInt("id"));
            m.setForoId(rs.getInt("foro_id"));
            m.setUsuarioId(rs.getInt("usuario_id"));
            m.setContenido(rs.getString("contenido"));
            m.setFecha(rs.getTimestamp("fecha"));
            return m;
        }
    }
}
