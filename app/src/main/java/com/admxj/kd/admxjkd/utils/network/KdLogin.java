package com.admxj.kd.admxjkd.utils.network;

import android.content.Context;

public class KdLogin implements Runnable {

    private Context context;
    private String kd_user;
    private String kd_pass;

    public KdLogin(Context context, String kd_user, String kd_pass) {
        this.context = context;
        this.kd_user = kd_user;
        this.kd_pass = kd_pass;
    }

    @Override
    public void run() {
        CrulLogin crulLogin = new CrulLogin();
        crulLogin.login(kd_user, kd_pass);
    }
}
