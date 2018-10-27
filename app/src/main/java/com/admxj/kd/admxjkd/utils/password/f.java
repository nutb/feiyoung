package com.admxj.kd.admxjkd.utils.password;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class f {
    protected PrintStream a;

    public f() {
    }

    protected abstract int a() throws IOException;

    protected int a(InputStream var1, byte[] var2) throws IOException {
        for(int var3 = 0; var3 < var2.length; ++var3) {
            int var4 = var1.read();
            if (var4 == -1) {
                return var3;
            }

            var2[var3] = (byte)var4;
        }

        return var2.length;
    }

    public String a(byte[] var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        ByteArrayInputStream var4 = new ByteArrayInputStream(var1);

        try {
            this.a(var4, (OutputStream)var2);
            String var5 = var2.toString("8859_1");
            return var5;
        } catch (Exception var3) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    public void a(InputStream var1, OutputStream var2) throws IOException {
        byte[] var6 = new byte[this.b()];
        this.a(var2);

        while(true) {
            int var5 = this.a(var1, var6);
            if (var5 == 0) {
                break;
            }

            this.a(var2, var5);

            for(int var3 = 0; var3 < var5; var3 += this.a()) {
                int var4;
                if (this.a() + var3 <= var5) {
                    var4 = this.a();
                } else {
                    var4 = var5 - var3;
                }

                this.a(var2, var6, var3, var4);
            }

            if (var5 < this.b()) {
                break;
            }

            this.c(var2);
        }

        this.b(var2);
    }

    protected void a(OutputStream var1) {
        this.a = new PrintStream(var1);
    }

    protected void a(OutputStream var1, int var2) {
    }

    protected abstract void a(OutputStream var1, byte[] var2, int var3, int var4) throws IOException;

    protected abstract int b();

    protected void b(OutputStream var1) {
    }

    protected void c(OutputStream var1) {
        this.a.println();
    }
}

