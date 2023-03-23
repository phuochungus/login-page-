package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

class Account {
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String username;
    String password;
}

public class MainActivity extends AppCompatActivity {

    static final Account[] accounts = {new Account("username", "12345"), new Account("user", "12345")};
    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.edtUsername);
        etPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            final String username = etUsername.getText().toString();
            final String password = etPassword.getText().toString();
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].username.equals(username) && accounts[i].password.equals(password)) {
                    Snackbar.make(this, v, "LOGIN SUCCESS", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
            }
            Snackbar.make(this, v, "LOGIN FAIL", BaseTransientBottomBar.LENGTH_LONG).show();
        });
    }

}