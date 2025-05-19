package com.faroria.faroriagame.dao;

import com.faroria.faroriagame.model.Video;
import java.util.List;

public interface VideoDAO {
    List<Video> findAll();
    Video findById(int id);
    void save(Video video);
    void update(Video video);
    void delete(int id);
}
