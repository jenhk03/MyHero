package com.example.myhero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder>
{
    private ArrayList<ModelHero> dataHero;
    public AdapterCard(ArrayList<ModelHero> dataHero)
    {
        this.dataHero = dataHero;
    }
    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View varView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position)
    {
        ModelHero hero = dataHero.get(position);
        holder.tvName.setText(hero.getName());
        holder.tvAbout.setText(hero.getAbout());
        Glide
                .with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .centerCrop()
                .into(holder.ivPhoto);
    }
    @Override
    public int getItemCount()
    {
        return dataHero.size();
    }
    public class ClassViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPhoto;
        TextView tvName, tvAbout;
        public ClassViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAbout = itemView.findViewById(R.id.tv_about);
        }
    }
}