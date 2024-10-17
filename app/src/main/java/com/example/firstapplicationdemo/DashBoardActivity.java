package com.example.firstapplicationdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DashBoardActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText usernameEditText;
    EditText passwordEditText;
    Button btnLogin;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 20, 20, 20);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        linearLayout.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParamsForViews = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        usernameEditText = new EditText(this);
        usernameEditText.setLayoutParams(layoutParamsForViews);
        usernameEditText.setHint("Enter username");
        usernameEditText.setBackgroundColor(R.color.pink);
        usernameEditText.setTextSize(20.0F);

        linearLayout.addView(usernameEditText);

        passwordEditText = new EditText(this);
        passwordEditText.setLayoutParams(layoutParamsForViews);
        passwordEditText.setHint("Enter password");
        passwordEditText.setBackgroundColor(R.color.pink);
        passwordEditText.setTextSize(20.0F);

        linearLayout.addView(passwordEditText);

        btnLogin = new Button(this);
        btnLogin.setText("Login");
        btnLogin.setBackgroundColor(R.color.blue);
        btnLogin.setTextSize(20.0F);
        btnLogin.setLayoutParams(layoutParamsForViews);

        linearLayout.addView(btnLogin);

        //way 3 -- creating reference of listener and initializing it with object of inner class
        View.OnClickListener listener = new MyBtnClickListener();
        btnLogin.setOnClickListener(listener);

        setContentView(linearLayout);
    }

    class MyBtnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (usernameEditText.getText().toString().equals("bitcode") &&
                    (passwordEditText.getText().toString().equals("bitcode@1234"))){
                Toast.makeText(DashBoardActivity.this, "Login Success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(DashBoardActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}