package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class RolDAOImpl implements RolDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Rol> findAll() {
        return jdbcTemplate.query("SELECT * FROM roles", new RolRowMapper());
    }

    @Override
    public Rol findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM roles WHERE id = ?", new RolRowMapper(), id);
    }

    @Override
    public void save(Rol rol) {
        jdbcTemplate.update("INSERT INTO roles (nombre) VALUES (?)", rol.getNombre());
    }

    @Override
    public void update(Rol rol) {
        jdbcTemplate.update("UPDATE roles SET nombre = ? WHERE id = ?", rol.getNombre(), rol.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM roles WHERE id = ?", id);
    }

    private static class RolRowMapper implements RowMapper<Rol> {
        public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rol rol = new Rol();
            rol.setId(rs.getInt("id"));
            rol.setNombre(rs.getString("nombre"));
            return rol;
        }
    }
}
