package com.pm.colorapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pm.colorapp.adapter.ColorAdapter;
import com.pm.colorapp.databinding.ActivityMainBinding;
import com.pm.colorapp.model.Color;
import com.pm.colorapp.viewmodel.ColorMainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Color> colorList;
    ColorMainView mainViewModel;
    ColorAdapter colorAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new ColorMainView(getApplication());
        binding.setColorMainView(mainViewModel);
        colorList=new ArrayList<>();
        colorAdapter = new ColorAdapter(this, colorList);

        recyclerView = findViewById(R.id.colorRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(colorAdapter);


        mainViewModel.getColorList().observe(this, colors -> {
            if (colors != null) {
                colorList = colors;
                colorAdapter.updateColorList(colors);
            }
        });

        mainViewModel.getPendingColorCount().observe(this, s -> binding.setSyncView(s));

    }
}