package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ReporteDAOImpl implements ReporteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Reporte> findAll() {
        return jdbcTemplate.query("SELECT * FROM reportes", new ReporteRowMapper());
    }

    @Override
    public Reporte findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM reportes WHERE id = ?", new ReporteRowMapper(), id);
    }

    @Override
    public void save(Reporte r) {
        jdbcTemplate.update(
                "INSERT INTO reportes (tipo, referencia_id, usuario_id, razon) VALUES (?, ?, ?, ?)",
                r.getTipo(), r.getReferenciaId(), r.getUsuarioId(), r.getRazon()
        );
    }

    @Override
    public void update(Reporte r) {
        jdbcTemplate.update(
                "UPDATE reportes SET tipo = ?, referencia_id = ?, razon = ? WHERE id = ?",
                r.getTipo(), r.getReferenciaId(), r.getRazon(), r.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM reportes WHERE id = ?", id);
    }

    private static class ReporteRowMapper implements RowMapper<Reporte> {
        @Override
        public Reporte mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reporte r = new Reporte();
            r.setId(rs.getInt("id"));
            r.setTipo(rs.getString("tipo"));
            r.setReferenciaId(rs.getInt("referencia_id"));
            r.setUsuarioId(rs.getInt("usuario_id"));
            r.setRazon(rs.getString("razon"));
            r.setFecha(rs.getTimestamp("fecha"));
            return r;
        }
    }
}
