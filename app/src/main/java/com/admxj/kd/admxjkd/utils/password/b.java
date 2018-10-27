package com.admxj.kd.admxjkd.utils.password;


import java.io.IOException;
import java.io.OutputStream;

public class b extends f {
    private static final char[] b = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public b() {
    }

    protected int a() {
        return 3;
    }

    protected void a(OutputStream var1, byte[] var2, int var3, int var4) throws IOException {
        byte var6;
        if (var4 == 1) {
            var6 = var2[var3];
            var1.write(b[var6 >>> 2 & 63]);
            var1.write(b[(var6 << 4 & 48) + 0]);
            var1.write(61);
        } else {
            byte var7;
            if (var4 != 2) {
                var7 = var2[var3];
                byte var5 = var2[var3 + 1];
                var6 = var2[var3 + 2];
                var1.write(b[var7 >>> 2 & 63]);
                var1.write(b[(var7 << 4 & 48) + (var5 >>> 4 & 15)]);
                var1.write(b[(var5 << 2 & 60) + (var6 >>> 6 & 3)]);
                var1.write(b[var6 & 63]);
                return;
            }

            var7 = var2[var3];
            var6 = var2[var3 + 1];
            var1.write(b[var7 >>> 2 & 63]);
            var1.write(b[(var7 << 4 & 48) + (var6 >>> 4 & 15)]);
            var1.write(b[(var6 << 2 & 60) + 0]);
        }

        var1.write(61);
    }

    protected int b() {
        return 57;
    }
}
