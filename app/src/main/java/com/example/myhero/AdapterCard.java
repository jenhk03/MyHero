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

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder>
{
    private ArrayList<ModelHero> dataHero;
    private Context ctx;
    public AdapterCard(ArrayList<ModelHero> dataHero, Context ctx)
    {
        this.dataHero = dataHero;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }
    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position)
    {
        ModelHero hero = dataHero.get(position);
        holder.tvName.setText(hero.getName());
        holder.tvAbout.setText(hero.getAbout());
        Glide
                .with(ctx)
                .load(hero.getPhoto())
                .centerCrop()
                .into(holder.ivPhoto);
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
                Intent send = new Intent(holder.itemView.getContext(), DetailActivity.class);
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