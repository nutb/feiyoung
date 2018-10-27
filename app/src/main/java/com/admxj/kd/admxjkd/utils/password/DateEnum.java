package com.admxj.kd.admxjkd.utils.password;


public enum DateEnum {
    EIGHT(8, "4573819602"),
    EIGHTEEN(18, "1785043926"),
    ELEVEN(11, "4791250368"),
    FIFTEEN(15, "2508479316"),
    FIVE(5, "8174069325"),
    FOUR(4, "3401978562"),
    FOURTEEN(14, "4195768023"),
    NINE(9, "3829507461"),
    NINETEEN(19, "6178093542"),
    ONE(1, "1430782659"),
    SEVEN(7, "8957612403"),
    SEVENTEEN(17, "1876354092"),
    SIX(6, "8076142539"),
    SIXTEEN(16, "7029183654"),
    TEN(10, "9356078241"),
    THIRTEEN(13, "1938567204"),
    THIRTY(30, "0456897213"),
    THIRTYONE(31, "0954761238"),
    THREE(3, "9173268045"),
    TWELVE(12, "6721895340"),
    TWENTY(20, "5643712089"),
    TWENTYEIGHT(28, "7368240195"),
    TWENTYFIVE(25, "5364107982"),
    TWENTYFOUR(24, "7415038296"),
    TWENTYNINE(29, "8314902567"),
    TWENTYONE(21, "1958627043"),
    TWENTYSEVEN(27, "1420698537"),
    TWENTYSIX(26, "1328760549"),
    TWENTYTHREE(23, "0841267953"),
    TWENTYTWO(22, "9572314608"),
    TWO(2, "0267854319");

    private int index;
    private String key;

    private DateEnum(int var3, String var4) {
        this.index = var3;
        this.key = var4;
    }

    public static DateEnum getDateEnumByIndex(int var0) {
        DateEnum[] var3 = values();
        int var2 = var3.length;

        for(int var1 = 0; var1 < var2; ++var1) {
            DateEnum var4 = var3[var1];
            if (var4.getIndex() == var0) {
                return var4;
            }
        }

        return null;
    }

    public static String getKeyByIndex(int var0) {
        DateEnum[] var3 = values();
        int var2 = var3.length;

        for(int var1 = 0; var1 < var2; ++var1) {
            DateEnum var4 = var3[var1];
            if (var4.getIndex() == var0) {
                return var4.key;
            }
        }

        return null;
    }

    public int getIndex() {
        return this.index;
    }

    public String getKey() {
        return this.key;
    }

    public void setIndex(int var1) {
        this.index = var1;
    }

    public void setKey(String var1) {
        this.key = var1;
    }
}

