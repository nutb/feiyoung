package com.admxj.kd.admxjkd.utils.network;

public abstract class LoginImpl {

    Object object = null;
    public LoginImpl(Object object){
        this.object = object;
    }

    public abstract void start();
}
