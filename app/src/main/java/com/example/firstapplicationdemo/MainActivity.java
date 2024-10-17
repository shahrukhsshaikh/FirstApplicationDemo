package com.example.firstapplicationdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSubmit;
    EditText usernameEditText;
    EditText passwordEditText;
    TextView welcomeTextView;
    LinearLayout mainContainer;

    //Activity LifeCycle
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        mainContainer.setPadding(20,20,20,20);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        mainContainer.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParamsForViews = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        welcomeTextView = new TextView(this);
        welcomeTextView.setLayoutParams(layoutParamsForViews);
        welcomeTextView.setText("Welcome To Bitcode");
        welcomeTextView.setTextColor(R.color.black);
        welcomeTextView.setBackgroundColor(R.color.light_green);

        mainContainer.addView(welcomeTextView);

        usernameEditText = new EditText(this);
        usernameEditText.setLayoutParams(layoutParamsForViews);
        usernameEditText.setHint("Enter the username");

        mainContainer.addView(usernameEditText);

        passwordEditText = new EditText(this);
        passwordEditText.setLayoutParams(layoutParamsForViews);
        passwordEditText.setHint("Enter the password");

        mainContainer.addView(passwordEditText);

        btnSubmit = new Button(this);
        btnSubmit.setLayoutParams(layoutParamsForViews);
        btnSubmit.setText("Submit");
        btnSubmit.setTextSize(30.0F);
        btnSubmit.setBackgroundColor(R.color.light_green);
        btnSubmit.setTextColor(R.color.black);

        mainContainer.addView(btnSubmit);

        //way 1 -- by implementing interface View.OnClickListener at class level
        btnSubmit.setOnClickListener(this);

        setContentView(mainContainer);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSubmit){
            welcomeTextView.setText("Welcome To " + usernameEditText.getText().toString());
        } else {
            welcomeTextView.setText("Welcome To Android!");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}