package com.pm.colorapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pm.colorapp.R;
import com.pm.colorapp.databinding.ItemColorCardBinding;
import com.pm.colorapp.model.Color;

import java.util.List;


public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
     Context context;
    private List<Color> colorList;

    public ColorAdapter(Context context, List<Color> colorList) {
        this.context = context;
        this.colorList = colorList;
    }

    public void updateColorList(List<Color> colorList) {
        this.colorList = colorList;
        notifyItemChanged(colorList.size()-1);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_color_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Color color = colorList.get(position);
        holder.binding.setItemColor(color);
        holder.binding.cardBackground.setBackgroundColor(android.graphics.Color.parseColor(color.getColorCode()));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemColorCardBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}

