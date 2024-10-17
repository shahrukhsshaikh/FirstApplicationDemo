package com.example.firstapplicationdemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    Resources resources;
    int [] images = {R.drawable.test_image_1,
            R.drawable.test_image_2,
            R.drawable.test_image_3,
            R.drawable.city_icon};

    int currentIndex = 0;

    ImageView imgView;
    TextView txtFirstName;
    TextView txtLastName;
    TextView txtStateName;
    TextView txtCityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews(){
        imgView = findViewById(R.id.imgView);
        imgView.setImageResource(images[currentIndex]);

        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtCityName = findViewById(R.id.txtCityName);
        txtStateName = findViewById(R.id.txtStateName);
    }

    private void initializeListeners(){
        imgView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentIndex = ++currentIndex % images.length;
                        imgView.setImageResource(images[currentIndex]);
                    }
                }
        );
    }
}