
package com.admxj.kd.admxjkd.utils.password;


import java.io.PrintStream;

public class PassWord {
  private final byte[] a = new byte[256];
  private final byte[] b = new byte[256];
  private final int c;

  public PassWord(byte[] var1) {
    if (var1.length >= 1 && var1.length <= 256) {
      this.c = var1.length;
      byte var5 = 0;

      int var3;
      for(var3 = 0; var3 < 256; ++var3) {
        this.a[var3] = (byte)var3;
        this.b[var3] = var1[var3 % this.c];
      }

      int var4 = 0;

      for(var3 = var5; var3 < 256; ++var3) {
        var4 = var4 + this.a[var3] + this.b[var3] & 255;
        byte var2 = this.a[var4];
        this.a[var4] = this.a[var3];
        this.a[var3] = var2;
      }

    } else {
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    }
  }

  private static byte a(char var0) {
    byte var1 = 0;
    if (var0 != 'c') {
      switch(var0) {
        case '0':
          break;
        case '1':
          return 1;
        case '2':
          return 2;
        case '3':
          return 3;
        case '4':
          return 4;
        case '5':
          return 5;
        case '6':
          return 6;
        case '7':
          return 7;
        case '8':
          return 8;
        case '9':
          return 9;
        default:
          switch(var0) {
            case 'A':
              return 10;
            case 'B':
              return 11;
            default:
              switch(var0) {
                case 'D':
                  return 13;
                case 'E':
                  return 14;
                case 'F':
                  return 15;
                default:
                  return 0;
              }
          }
      }
    } else {
      var1 = 12;
    }

    return var1;
  }

  /**
   * 密码加密
   * @param var0 p.a()
   * @param var1 密码
   * @return
   */
  public static String a(String var0, String var1) {
    PrintStream var2 = System.out;
    StringBuilder var3 = new StringBuilder();
    var3.append("k=");
    var3.append(var0);
    var3.append(" ,s=");
    var3.append(var1);
    var2.println(var3.toString());
    return q.a((new PassWord(a(var0))).a(var1.getBytes()));
  }

  private static byte[] a(String var0) {
    byte[] var2 = new byte[var0.length()];

    for(int var1 = 0; var1 < var0.length(); ++var1) {
      var2[var1] = a(var0.charAt(var1));
    }

    return var2;
  }

  public static byte[] a(String var0, byte[] var1) {
    return (new PassWord(a(var0))).a(var1);
  }

  public static String b(String var0, byte[] var1) {
    byte[] var2 = (new PassWord(a(var0))).a(var1);
    return (new b()).a(var2).replaceAll("\r|\n", "");
  }

  public byte[] a(byte[] var1) {
    byte[] var8 = new byte[var1.length];
    int var3 = 0;
    int var5 = 0;

    for(int var4 = 0; var3 < var1.length; ++var3) {
      var5 = var5 + 1 & 255;
      var4 = var4 + this.a[var5] & 255;
      byte var2 = this.a[var4];
      this.a[var4] = this.a[var5];
      this.a[var5] = var2;
      byte var6 = this.a[var5];
      byte var7 = this.a[var4];
      var8[var3] = (byte)(this.a[var6 + var7 & 255] ^ var1[var3]);
    }

    return var8;
  }
}
