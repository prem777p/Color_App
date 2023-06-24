package com.pm.colorapp.Room_Database.respository;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pm.colorapp.model.Color;

public class FirebaseDb {

    private final DatabaseReference databaseReference;

    public FirebaseDb(){
        databaseReference = FirebaseDatabase.getInstance().getReference("Color");
    }

    public void addColorToServer(Color color){
        databaseReference.push().setValue(color);
    }
}
