package com.example.myhero;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity
{
    private ImageView ivPhoto;
    private TextView tvName, tvAbout;
    private String yName, yAbout, yPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivPhoto = findViewById(R.id.iv_photo);
        tvName = findViewById(R.id.tv_name);
        tvAbout = findViewById(R.id.tv_about);
        Intent take = getIntent();
        yName = take.getStringExtra("xName");
        yAbout = take.getStringExtra("xAbout");
        yPhoto = take.getStringExtra("xPhoto");
        tvName.setText(yName);
        tvAbout.setText(yAbout);
        Glide
                .with(DetailActivity.this)
                .load(yPhoto)
                .into(ivPhoto);
    }
}