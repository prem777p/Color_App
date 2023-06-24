package com.pm.colorapp.Room_Database.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pm.colorapp.Room_Database.Dao.ColorDao;
import com.pm.colorapp.Room_Database.Dao.ColorServerDao;
import com.pm.colorapp.model.Color;
import com.pm.colorapp.model.ColorServer;

@Database(entities = {Color.class, ColorServer.class}, version = 1)
public abstract class ColorDb extends RoomDatabase {
  private static final String DATABASE_NAME = "ColorDb";
  public abstract ColorDao colorDao();
  public abstract ColorServerDao colorServerDaoDao();
  private static ColorDb INSTANCE;

  public static synchronized ColorDb getInstance(Context context){
      if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ColorDb.class,DATABASE_NAME)
                          .allowMainThreadQueries()
                          .fallbackToDestructiveMigration()
                          .build();
      }
      return INSTANCE;
  }
}
