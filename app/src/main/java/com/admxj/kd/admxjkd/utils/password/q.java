package com.admxj.kd.admxjkd.utils.password;


import java.security.MessageDigest;

public class q {
    public static String a(byte[] var0) {
        try {
            String var2 = b(MessageDigest.getInstance("MD5").digest(var0));
            return var2;
        } catch (Exception var1) {
            System.out.println("MD5 failure!!!");
            return "";
        }
    }

    private static String b(byte[] var0) {
        StringBuilder var4 = new StringBuilder();

        for(int var1 = 0; var1 < var0.length; ++var1) {
            String var3 = Integer.toHexString(var0[var1] & 255);
            String var2 = var3;
            if (var3.length() == 1) {
                StringBuilder var5 = new StringBuilder();
                var5.append('0');
                var5.append(var3);
                var2 = var5.toString();
            }

            var4.append(var2.toLowerCase());
        }

        return var4.toString();
    }
}