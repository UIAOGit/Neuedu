package com.neusoft.neuedu.edu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.neusoft.neuedu.R;
import com.neusoft.neuedu.data.GetData;
import com.neusoft.neuedu.data.ParseJson;
import com.neusoft.neuedu.data.PostLogin;


public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText username,password,captcha;
    private Bitmap bitmap;
    private TextView refresh;
    private ImageView captchaImage;
    private CheckBox checkBox;
    private Button login;
    private String userName,passWord,CAPTCHA;
    private TextView test;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0x001:
                    captchaImage.setImageBitmap(bitmap);
                    Toast.makeText(Login.this, "验证码已加载", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
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
        test = (TextView) findViewById(R.id.test);
        this.onClick(refresh);
        refresh.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                userName = username.getText().toString();
                passWord = password.getText().toString();
                CAPTCHA = captcha.getText().toString();
                test.setText(userName+" "+passWord+" "+CAPTCHA);
                new Thread() {
                    public void run() {
                        String result = PostLogin.LoginByPost(userName,passWord,CAPTCHA);
                        handler.sendEmptyMessage(0x123);
                    };
                }.start();

                break;
            case R.id.refresh:
                final String path = "http://www.neuedu.cn/imgcode";
                new Thread() {
                    public void run() {
                        try {
                            byte[] data = GetData.getImage(path);
                            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        handler.sendEmptyMessage(0x001);
                    }
                }.start();
                break;

        }
    }
}
