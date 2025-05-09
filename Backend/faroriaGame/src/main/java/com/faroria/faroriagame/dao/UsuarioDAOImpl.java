package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        return jdbcTemplate.query(sql, new UsuarioRowMapper());
    }

    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UsuarioRowMapper(), id);
    }

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, password, avatar_url, rol_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getAvatarUrl(),
                usuario.getRolId());
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, password = ?, avatar_url = ?, rol_id = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getAvatarUrl(),
                usuario.getRolId(),
                usuario.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setAvatarUrl(rs.getString("avatar_url"));
            u.setRolId(rs.getInt("rol_id"));
            u.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
            return u;
        }
    }
}
