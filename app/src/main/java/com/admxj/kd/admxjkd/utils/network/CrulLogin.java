package com.admxj.kd.admxjkd.utils.network;


import android.util.Log;

import com.admxj.kd.admxjkd.utils.GenerUtils;
import com.admxj.kd.admxjkd.utils.password.PassWord;
import com.admxj.kd.admxjkd.utils.password.PassWordTime;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by admxj on 2018/10/24.
 */
public class CrulLogin {

    private static final String NET_STATUS = "curl -X GET http://captive.apple.com/hotspot-detect.html -H 'User-Agent: CDMA+WLAN(macos)'";

    private static final String GET_LOGIN_URL = "curl -X GET '%s' -H 'User-Agent: CDMA+WLAN(macos)'";

    private static final String LOGIN_URL = "curl -X POST '%s' -H 'Content-Type: application/x-www-form-urlencoded' -H 'User-Agent: CDMA+WLAN(macos)' -d '%s'";
    private static final String LOGIN_OUT = "curl -X GET '%s' -H 'User-Agent: CDMA+WLAN(macos)'";
    GenerUtils generUtils = new GenerUtils();

    public void login(String kd_username, String kd_password){

            String s = generUtils.curl(NET_STATUS);
            if (s.indexOf("Success")!=-1){
                System.out.println(s);
                System.out.println("已在线状态");
                return;
            }
            System.out.println(s);
            s = StringUtils.substringBetween(s,"<NextURL>","</NextURL>");
            Log.i("CrulLogin","URL" + s);
            s = StringUtils.substringBefore(s, "?userip=100.64")+"/"+StringUtils.substringAfter(s, "http://58.53.199.144:8001")+"&aidcauthtype=0";
            Log.i("CrulLogin","重定向URL" + s);
            s = generUtils.curl(String.format(GET_LOGIN_URL,s));

            s = StringUtils.substringBetween(s,"<LoginURL><![CDATA[","]]></LoginURL>");
            Log.i("CrulLogin","拨号URL" + s);
            String passwd = PassWord.a(PassWordTime.a(), kd_password);
            String data = "button=Login&UserName=!^A6EA0%s&Password=%s&FNAME=0&OriginatingServer=http://www.sina.com.cn/";
            data = String.format(data,kd_username,passwd);

            s = generUtils.curl(String.format(LOGIN_URL, s, data));


            String logout = StringUtils.substringBetween(s, "<LogoffURL><![CDATA[","]]></LogoffURL>");
//            s = generUtils.curl(String.format(LOGIN_OUT,logout));
//            System.out.println(s);

    }

}
