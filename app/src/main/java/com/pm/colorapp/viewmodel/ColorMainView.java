package com.pm.colorapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pm.colorapp.Room_Database.respository.ColorRepository;
import com.pm.colorapp.Room_Database.respository.FirebaseDb;
import com.pm.colorapp.model.Color;
import com.pm.colorapp.model.ColorServer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ColorMainView extends ViewModel {
    MutableLiveData<ArrayList<Color>> colorList;
    MutableLiveData<String> pendingColorCount;
    ArrayList<Color> value;
    ColorRepository colorRepository;
    Application application;

    public ColorMainView(Application application) {
        colorList = new MutableLiveData<>();
        pendingColorCount = new MutableLiveData<>();
        colorRepository = new ColorRepository(application);

        pendingColorCount.postValue(String.valueOf(colorRepository.getAllColorServer().size()));
        this.application = application;
        value = new ArrayList<>();
        getAllColor();
        colorList.postValue(value);
    }

    public MutableLiveData<ArrayList<Color>> getColorList() {
        return colorList;
    }
    public MutableLiveData<String> getPendingColorCount() {
        return pendingColorCount;
    }

    public void addColorItem(View view){
        String randomColor = generateRandomColor();
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date todayDate = new Date();
        String currDate = currentDate.format(todayDate);

        Color color = new Color(randomColor, currentTime, currDate);
        ColorServer colorServer = new ColorServer(randomColor, currentTime, currDate);
        value.add(color);

//          Save color to local RoomDB
            insert(color);
            insertLocalToServer(colorServer);

        colorList.postValue(value);
        pendingColorCount.postValue(String.valueOf(colorRepository.getAllColorServer().size()));

    }


    private String generateRandomColor() {
        Random random = new Random();
        String ranColor = String.format("#%06x", random.nextInt(256*256*256));
        return ranColor.toUpperCase();
    }

    public void insert(Color color){
        colorRepository.insert(color);
    }
    private void insertLocalToServer(ColorServer colorServer) {
        colorRepository.insertServer(colorServer);
    }
    public void getAllColor(){
       value.addAll(colorRepository.getAllColor());
    }


    public void saveToServer(View view){
        boolean isConnected = isNetworkAvailable(view.getContext());

        if (isConnected ) {
            List<Color> colorListServer = colorRepository.getAllColorServer();
            if (colorListServer.size() != 0){
                FirebaseDb firebaseDb = new FirebaseDb();
                // sent to data base
                for (Color color : colorListServer) {
                    firebaseDb.addColorToServer(color);
                }
                Toast.makeText(application, "Data Send to Server Successfully!", Toast.LENGTH_SHORT).show();
                colorRepository.deleteAll();
                pendingColorCount.postValue("0");
            } else {
                Toast.makeText(application, "No Pending Data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(application, "Internet Connection Not Fount!", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

}
