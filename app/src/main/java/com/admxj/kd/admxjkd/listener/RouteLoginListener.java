package com.admxj.kd.admxjkd.listener;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.admxj.kd.admxjkd.MainActivity;
import com.admxj.kd.admxjkd.utils.GenerUtils;

public class RouteLoginListener implements View.OnClickListener {

    private EditText username;
    private EditText password;

    public RouteLoginListener(EditText username, EditText password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void onClick(View v) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

//        GenerUtils generUtils = new GenerUtils(user, pass);
//        String curl = generUtils.curl("ls /etc/config/network");
//        if ("/etc/config/network".equals(curl)){
//            Toast.makeText(MainActivity.,"登陆成功", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(MainActivity.class,"登录失败", Toast.LENGTH_SHORT).show();
//        }
        Log.i("admxj",user);
        Log.i("admxj",pass);

    }

}
