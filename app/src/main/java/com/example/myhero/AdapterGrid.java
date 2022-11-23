package com.example.myhero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<com.example.myhero.AdapterGrid.ClassViewHolder>
{
    private ArrayList<ModelHero> dataHero;
    private Context ctx;
    public AdapterGrid(ArrayList<ModelHero> dataHero, Context ctx)
    {
        this.dataHero = dataHero;
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false);
        return new ClassViewHolder(varView);
    }
    @Override
    public void onBindViewHolder(@NonNull com.example.myhero.AdapterGrid.ClassViewHolder holder, int position)
    {
        ModelHero hero = dataHero.get(position);
        Glide
                .with(ctx)
                .load(hero.getPhoto())
                .centerCrop()
                .into(holder.ivGrid);
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String xName, xAbout, xPhoto;
                xName = hero.getName();
                xAbout = hero.getAbout();
                xPhoto = hero.getPhoto();
                //Log.d("CHECKANDRECHECK", xName + " | " + xAbout + " | " + xPhoto);
                Intent send = new Intent(ctx, DetailActivity.class);
                send.putExtra("xName", xName);
                send.putExtra("xAbout", xAbout);
                send.putExtra("xPhoto", xPhoto);
                ctx.startActivity(send);
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return dataHero.size();
    }
    public class ClassViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivGrid;
        TextView tvName, tvAbout;
        public ClassViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAbout = itemView.findViewById(R.id.tv_about);
        }
    }
}