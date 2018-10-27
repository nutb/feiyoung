package com.admxj.kd.admxjkd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login, cancel;
    private CheckBox checkBox, checkBox2;
    private EditText editName, editPassword;
    //声明一个SharedPreferences对象和一个Editor对象
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        //获取preferences和editor对象
        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editor = preferences.edit();

    /*
    启动程序时首先检查sharedPreferences中是否储存有用户名和密码
    若无，则将checkbox状态显示为未选中
    若有，则直接中sharedPreferences中读取用户名和密码，并将checkbox状态显示为已选中
    这里getString()方法需要两个参数，第一个是键，第二个是值。
    启动程序时我们传入需要读取的键，值填null即可。若有值则会自动显示，没有则为空。
     */
        String name = preferences.getString("userName", null);
        if (name == null) {
            checkBox.setChecked(false);
        } else {
            editName.setText(name);
            checkBox.setChecked(true);
        }
        String password = preferences.getString("userPassword", null);
        if (password == null) {
            checkBox2.setChecked(false);
        } else {
            editPassword.setText(password);
            checkBox2.setChecked(true);
        }

        //为login和cancel设置监听事件
        login.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //判断用户是进行的是登陆操作还是取消操作
        switch (v.getId()) {
            case R.id.login:
                String name = editName.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                //验证用户名和密码，若为admin-123456即可登录
                if (name.equals("admin") && password.equals("123456")) {
                    if (checkBox.isChecked()) {
                        //如果用户选择了记住用户名
                        //将用户输入的用户名存入储存中，键为userName
                        editor.putString("userName", name);
                        editor.commit();
                    } else {
                        //否则将用户名清除
                        editor.remove("userName");
                        editor.commit();
                    }
                    if (checkBox2.isChecked()) {
                        //如果用户选择了记住密码
                        //将用户输入的密码存入储存中，键为userName
                        editor.putString("userPassword", password);
                        editor.commit();
                    } else {
                        //否则将密码清除
                        editor.remove("userPassword");
                        editor.commit();
                    }
                    //提示登陆成功
                    Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
                } else {
                    //若登陆不成功，则将错误的用户名和密码清除，并提示登陆失败
                    editor.remove("userName");
                    editor.remove("userPassword");
                    editor.commit();
                    Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
                }
                break;
            //若用户选择了取消，则直接退出登录
            case R.id.cancel:
                finish();
        }
    }
}