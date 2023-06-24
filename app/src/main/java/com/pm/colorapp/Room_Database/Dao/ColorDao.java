package com.pm.colorapp.Room_Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.pm.colorapp.model.Color;

import java.util.List;

@Dao
public interface ColorDao {
    @Query("SELECT * FROM color")
    List<Color> getAllColor();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Color color);

}
