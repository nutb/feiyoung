package com.admxj.kd.admxjkd;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.admxj.kd.admxjkd.utils.DestHost;
import com.admxj.kd.admxjkd.utils.GenerUtils;
import com.admxj.kd.admxjkd.utils.SSHUtils;
import com.admxj.kd.admxjkd.utils.network.KdLogin;
import com.admxj.kd.admxjkd.utils.network.LoginImpl;
import com.admxj.kd.admxjkd.utils.network.RouteLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    //路由器信息
    private EditText username;
    private EditText password;
    private Button login_button;

    //宽带信息
    private EditText kd_username;
    private EditText kd_password;
    private Button kd_login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.route_account);
        password = findViewById(R.id.route_password);
        login_button = findViewById(R.id.login_button);

        kd_username = findViewById(R.id.kd_username);
        kd_password = findViewById(R.id.kd_password);
        kd_login_button = findViewById(R.id.kd_login_button);

        kd_login_button.setEnabled(false);

        login_button.setOnClickListener(this);
        kd_login_button.setOnClickListener(this);
        //获取preferences和editor对象
        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editor = preferences.edit();
        String user = preferences.getString("userName", null);
        String pass = preferences.getString("userPassword", null);

        String kd_user = preferences.getString("kd_userName",null);
        String kd_pass = preferences.getString("kd_userPassword",null);
        if (null!=user || "".equals(user))
            username.setText(user);
        if (null!=pass || "".equals(pass))
            password.setText(pass);
        if (null!=kd_user || "".equals(kd_user))
            kd_username.setText(kd_user);
        if (null!=kd_pass || "".equals(kd_pass))
            kd_password.setText(kd_pass);

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        if (button == login_button){
            String user = username.getText().toString();
            String pass = password.getText().toString();
            editor.putString("userName", user);
            editor.putString("userPassword", pass);
            editor.commit();
            RouteLogin routeLogin = new RouteLogin(MainActivity.this, user, pass, button,kd_login_button);
            new Thread(routeLogin).start();

        }else{
            String kd_user = kd_username.getText().toString();
            String kd_pass = kd_password.getText().toString();
            editor.putString("kd_userName", kd_user);
            editor.putString("kd_userPassword", kd_pass);
            editor.commit();

            KdLogin kdLogin = new KdLogin(MainActivity.this, kd_user, kd_pass);
            new Thread(kdLogin).start();
        }


    }


}
