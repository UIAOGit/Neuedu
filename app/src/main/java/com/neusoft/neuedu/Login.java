package com.neusoft.neuedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText username,password,captcha;
    private TextView refresh;
    private ImageView captchaImage;
    private CheckBox checkBox;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setView();

    }
    public void setView()
    {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        captcha = (EditText) findViewById(R.id.captcha);
        refresh = (TextView) findViewById(R.id.refresh);
        captchaImage = (ImageView) findViewById(R.id.captcha_image);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        login = (Button) findViewById(R.id.login);
    }
}
