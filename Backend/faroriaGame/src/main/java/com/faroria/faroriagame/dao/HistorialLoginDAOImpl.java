package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.HistorialLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class HistorialLoginDAOImpl implements HistorialLoginDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HistorialLogin> findAll() {
        return jdbcTemplate.query("SELECT * FROM historial_login", new LoginRowMapper());
    }

    @Override
    public HistorialLogin findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM historial_login WHERE id = ?", new LoginRowMapper(), id);
    }

    @Override
    public void save(HistorialLogin login) {
        jdbcTemplate.update(
                "INSERT INTO historial_login (usuario_id, ip) VALUES (?, ?)",
                login.getUsuarioId(), login.getIp()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM historial_login WHERE id = ?", id);
    }

    private static class LoginRowMapper implements RowMapper<HistorialLogin> {
        @Override
        public HistorialLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
            HistorialLogin l = new HistorialLogin();
            l.setId(rs.getInt("id"));
            l.setUsuarioId(rs.getInt("usuario_id"));
            l.setIp(rs.getString("ip"));
            l.setFecha(rs.getTimestamp("fecha"));
            return l;
        }
    }
}
