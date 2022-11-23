package com.example.myhero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        AdapterCard varAdapterCard = new AdapterCard(data, MainActivity.this);
        rvHero.setAdapter(varAdapterCard);
    }
    private void showDataGrid()
    {
        rvHero.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid varAdapterGrid = new AdapterGrid(data, MainActivity.this);
        rvHero.setAdapter(varAdapterGrid);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.modemenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.modemenu_card:
                showDataCard();
                break;
                case R.id.modemenu_grid:
                    showDataGrid();
                    break;
        }
        return super.onOptionsItemSelected(item);
    }
}