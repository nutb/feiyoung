package com.admxj.kd.admxjkd.utils.network;

import android.content.Context;
import android.os.Looper;
import android.transition.Visibility;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.admxj.kd.admxjkd.utils.GenerUtils;
import com.admxj.kd.admxjkd.utils.password.PassWord;
import com.admxj.kd.admxjkd.utils.password.PassWordTime;

import org.apache.commons.lang3.StringUtils;

public class KdLogin implements Runnable {


    private static final String NET_STATUS = "curl -X GET http://captive.apple.com/hotspot-detect.html -H 'User-Agent: CDMA+WLAN(macos)'";

    private static final String GET_LOGIN_URL = "curl -X GET '%s' -H 'User-Agent: CDMA+WLAN(macos)'";

    private static final String LOGIN_URL = "curl -X POST '%s' -H 'Content-Type: application/x-www-form-urlencoded' -H 'User-Agent: CDMA+WLAN(macos)' -d '%s'";
    private static final String LOGIN_OUT = "curl -X GET '%s' -H 'User-Agent: CDMA+WLAN(macos)'";


    private Context context;
    private String kd_user;
    private String kd_pass;
    private TextView result_View;

    GenerUtils generUtils = new GenerUtils();

    public KdLogin(Context context, String kd_user, String kd_pass, TextView result_View) {
        this.context = context;
        this.kd_user = kd_user;
        this.kd_pass = kd_pass;
        this.result_View = result_View;
    }

    @Override
    public void run() {
        Log.i("CrulLogin","登录中");

        try {

            String s = generUtils.curl(NET_STATUS);
            Log.i("CrulLogin",s);
            if (s.indexOf("Success")!=-1){
                System.out.println(s);
                Log.i("CrulLogin","已在线状态");
                return;
            }
            Log.i("CrulLogin",s);
            s = StringUtils.substringBetween(s,"<NextURL>","</NextURL>");
            Log.i("CrulLogin","URL" + s);
            s = StringUtils.substringBefore(s, "?userip=100.64")+"/"+StringUtils.substringAfter(s, "http://58.53.199.144:8001")+"&aidcauthtype=0";
            Log.i("CrulLogin","重定向URL" + s);
            s = generUtils.curl(String.format(GET_LOGIN_URL,s));

            s = StringUtils.substringBetween(s,"<LoginURL><![CDATA[","]]></LoginURL>");
            Log.i("CrulLogin","拨号URL" + s);
            String passwd = PassWord.a(PassWordTime.a(), kd_pass);
            String data = "button=Login&UserName=!^A6EA0%s&Password=%s&FNAME=0&OriginatingServer=http://www.sina.com.cn/";
            data = String.format(data,kd_user,passwd);

            s = generUtils.curl(String.format(LOGIN_URL, s, data));

            System.out.println(s);
            Looper.prepare();
            result_View.setVisibility(View.VISIBLE);
//            Toast.makeText(context,s,Toast.LENGTH_LONG);
            Looper.loop();

            String logout = StringUtils.substringBetween(s, "<LogoffURL><![CDATA[","]]></LogoffURL>");
//        s = generUtils.curl(String.format(LOGIN_OUT,logout));
//        System.out.println(s);

        }catch (Exception e){

        }



    }
}
