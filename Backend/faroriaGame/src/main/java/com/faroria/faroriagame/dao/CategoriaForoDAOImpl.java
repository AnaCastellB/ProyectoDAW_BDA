package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.CategoriaForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class CategoriaForoDAOImpl implements CategoriaForoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoriaForo> findAll() {
        return jdbcTemplate.query("SELECT * FROM categorias_foro", new CategoriaRowMapper());
    }

    @Override
    public CategoriaForo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM categorias_foro WHERE id = ?", new CategoriaRowMapper(), id);
    }

    @Override
    public void save(CategoriaForo c) {
        jdbcTemplate.update("INSERT INTO categorias_foro (nombre, descripcion) VALUES (?, ?)", c.getNombre(), c.getDescripcion());
    }

    @Override
    public void update(CategoriaForo c) {
        jdbcTemplate.update("UPDATE categorias_foro SET nombre = ?, descripcion = ? WHERE id = ?", c.getNombre(), c.getDescripcion(), c.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM categorias_foro WHERE id = ?", id);
    }

    private static class CategoriaRowMapper implements RowMapper<CategoriaForo> {
        @Override
        public CategoriaForo mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoriaForo c = new CategoriaForo();
            c.setId(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            c.setDescripcion(rs.getString("descripcion"));
            return c;
        }
    }
}
