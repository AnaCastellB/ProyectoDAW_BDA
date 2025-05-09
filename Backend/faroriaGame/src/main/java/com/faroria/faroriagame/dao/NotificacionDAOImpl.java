package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class NotificacionDAOImpl implements NotificacionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Notificacion> findAll() {
        return jdbcTemplate.query("SELECT * FROM notificaciones", new NotiRowMapper());
    }

    @Override
    public Notificacion findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM notificaciones WHERE id = ?", new NotiRowMapper(), id);
    }

    @Override
    public void save(Notificacion n) {
        jdbcTemplate.update(
                "INSERT INTO notificaciones (usuario_id, mensaje, leido) VALUES (?, ?, ?)",
                n.getUsuarioId(), n.getMensaje(), n.isLeido()
        );
    }

    @Override
    public void update(Notificacion n) {
        jdbcTemplate.update(
                "UPDATE notificaciones SET mensaje = ?, leido = ? WHERE id = ?",
                n.getMensaje(), n.isLeido(), n.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM notificaciones WHERE id = ?", id);
    }

    private static class NotiRowMapper implements RowMapper<Notificacion> {
        @Override
        public Notificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Notificacion n = new Notificacion();
            n.setId(rs.getInt("id"));
            n.setUsuarioId(rs.getInt("usuario_id"));
            n.setMensaje(rs.getString("mensaje"));
            n.setLeido(rs.getBoolean("leido"));
            n.setFecha(rs.getTimestamp("fecha"));
            return n;
        }
    }
}
