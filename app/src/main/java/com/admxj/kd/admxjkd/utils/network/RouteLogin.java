package com.admxj.kd.admxjkd.utils.network;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.admxj.kd.admxjkd.utils.GenerUtils;

public class RouteLogin implements Runnable{

    private static final String RESTART_NETWORK = "/etc/init.d/network restart";


    private String username;
    private String password;
    private Context context;


    private Button button;
    private Button kd_button;

    public RouteLogin(Context context, String username, String password, Button button, Button kd_button) {
        this.context = context;
        this.username = username;
        this.password = password;
        this.button = button;
        this.kd_button = kd_button;
    }

    @Override
    public void run() {
        Log.i("RouteLogin", "开始登陆");
        GenerUtils generUtils = new GenerUtils(username, password);
        try {
            String curl = generUtils.curl("ls /etc/config/network");
            Log.d("RouteLogin", curl);
            String s = generUtils.curl(RESTART_NETWORK);
            Log.i("RouteLogin","路由器重新获取ip：" + s);
            if (curl.indexOf("network")>0){

                Log.i("RouteLogin","登陆成功：" + curl);
                Looper.prepare();
                kd_button.setEnabled(true);
                Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show();
                Looper.loop();

            }else{
                Log.i("RouteLogin","登陆失败：" + curl);
                Looper.prepare();
                Toast.makeText(context, "登陆失败", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.i("RouteLogin","登陆异常");
            Looper.prepare();
            Toast.makeText(context, "登陆异常", Toast.LENGTH_SHORT).show();
            Looper.loop();
        }finally {
            Looper.prepare();
            button.setEnabled(true);
            Looper.loop();
        }


    }
}
