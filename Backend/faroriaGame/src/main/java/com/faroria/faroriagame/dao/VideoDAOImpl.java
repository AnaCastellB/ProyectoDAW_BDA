package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class VideoDAOImpl implements VideoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Video> findAll() {
        return jdbcTemplate.query("SELECT * FROM videos", new VideoRowMapper());
    }

    @Override
    public Video findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM videos WHERE id = ?", new VideoRowMapper(), id);
    }

    @Override
    public void save(Video video) {
        jdbcTemplate.update(
                "INSERT INTO videos (titulo, url, subido_por) VALUES (?, ?, ?)",
                video.getTitulo(), video.getUrl(), video.getSubidoPor()
        );
    }

    @Override
    public void update(Video video) {
        jdbcTemplate.update(
                "UPDATE videos SET titulo = ?, url = ?, subido_por = ? WHERE id = ?",
                video.getTitulo(), video.getUrl(), video.getSubidoPor(), video.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM videos WHERE id = ?", id);
    }

    private static class VideoRowMapper implements RowMapper<Video> {
        @Override
        public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
            Video v = new Video();
            v.setId(rs.getInt("id"));
            v.setTitulo(rs.getString("titulo"));
            v.setUrl(rs.getString("url"));
            v.setSubidoPor(rs.getInt("subido_por"));
            v.setFecha(rs.getTimestamp("fecha"));
            return v;
        }
    }
}
