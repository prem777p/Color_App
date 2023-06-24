package com.pm.colorapp.Room_Database.respository;

import android.app.Application;

import com.pm.colorapp.Room_Database.Dao.ColorDao;
import com.pm.colorapp.Room_Database.Dao.ColorServerDao;
import com.pm.colorapp.Room_Database.Database.ColorDb;
import com.pm.colorapp.model.Color;
import com.pm.colorapp.model.ColorServer;

import java.util.List;

public class ColorRepository {
    private ColorDb colorDb;
    private ColorDao colorDao;
    private ColorServerDao colorServerDao;
    public ColorRepository(Application application)
    {
            colorDb = ColorDb.getInstance(application);
            colorDao = colorDb.colorDao();
            colorServerDao = colorDb.colorServerDaoDao();
    }

    public void insert(Color color){
        colorDao.insert(color);
    }
    public List<Color> getAllColor(){
        return  colorDao.getAllColor();
    }

    public void insertServer(ColorServer colorServer){ colorServerDao.insert(colorServer); }
    public List<Color> getAllColorServer(){
        return  colorServerDao.getAllColorServer();
    }
    public void deleteAll(){
        colorServerDao.deleteAll();
    }

}