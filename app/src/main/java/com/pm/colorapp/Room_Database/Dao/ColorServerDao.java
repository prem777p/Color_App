package com.pm.colorapp.Room_Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pm.colorapp.model.Color;
import com.pm.colorapp.model.ColorServer;

import java.util.List;

@Dao
public interface ColorServerDao {

    @Query("SELECT * FROM `color server`")
    List<Color> getAllColorServer();

    @Insert
    void insert(ColorServer colorServer);

    @Query("DELETE FROM `color server`")
    void deleteAll();

}
