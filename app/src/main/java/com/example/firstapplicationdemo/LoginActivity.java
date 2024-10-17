package com.example.firstapplicationdemo;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    LinearLayout mainContainer;
    TextView txtWelcomeMessage;
    EditText usernameEditText;
    EditText passwordEditText;
    Button btnLogin;
    String [] colours;
    int [] numbers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        initializeListeners();

        //use resources from xml files in code by using getResources() method
        Resources r = getResources();
        String welcome = r.getString(R.string.welcome);
        Log.e("tag", welcome);
        Log.e("tag", R.string.welcome + "");
        Log.e("tag", "----" + R.color.blue);
        Log.e("tag", "----" + R.integer.ten);

        colours = r.getStringArray(R.array.colours);
        numbers = r.getIntArray(R.array.numbers);
        float dimen = r.getDimension(R.dimen.corner_radius);
        int green = r.getColor(R.color.light_green);
        Log.e("tag", green + "");

        //traditional for loop
        for (int i = 0; i < 5; i++) {
            Log.e("tag",colours[i]);
        }

        for (int i = 0; i < 5; i++) {
            Log.e("tag", numbers[i] + "");
        }

        // for each loop -- modern for loop
        for (String c : colours) {
            Log.e("tag", c);
        }

        for (int n : numbers) {
            Log.e("tag", n + "");
        }
    }

    private void initializeViews(){
        mainContainer = findViewById(R.id.mainContainer);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void initializeListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usernameEditText.getText().toString().equals("bitcode") &&
                        passwordEditText.getText().toString().equals("bitcode@1234")){
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}