package com.example.myhero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rvHero;
    private ArrayList<ModelHero> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHero = findViewById(R.id.rv_hero);
        rvHero.setHasFixedSize(true);
        data.addAll(DataHero.takeDataHero());
        showDataCard();
    }
    private void showDataCard()
    {
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard varAdapterCard = new AdapterCard(data);
        rvHero.setAdapter(varAdapterCard);
    }
}