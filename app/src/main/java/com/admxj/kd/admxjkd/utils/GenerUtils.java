package com.admxj.kd.admxjkd.utils;

import com.jcraft.jsch.JSchException;

import java.io.IOException;

/**
 * Created by admxj on 2018/10/27.
 */
public class GenerUtils {

    private static String ip = "192.168.1.1";

    private static String username = "root";
    private static String password = "admin123";

    public GenerUtils() {
    }
    public GenerUtils(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public GenerUtils(String ip, String username, String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
    }

    public String curl(String exec) {
        DestHost destHost = new DestHost(ip, username, password);
        SSHUtils admxj = new SSHUtils(destHost);
        String result = null;
        try {
            result = admxj.execCommandByJSch(exec);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        }

        return result;
    }
}
