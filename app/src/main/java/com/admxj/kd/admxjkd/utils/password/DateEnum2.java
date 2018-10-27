package com.admxj.kd.admxjkd.utils.password;


public enum DateEnum2 {
    EIGHT(8, "7134089265"),
    EIGHTEEN(18, "1498053672"),
    ELEVEN(11, "1648092357"),
    FIFTEEN(15, "7082436519"),
    FIVE(5, "6235810479"),
    FOUR(4, "8706254139"),
    FOURTEEN(14, "2930518647"),
    NINE(9, "6908534172"),
    NINETEEN(19, "6852093471"),
    ONE(1, "5348729601"),
    SEVEN(7, "4128506973"),
    SEVENTEEN(17, "1079234568"),
    SIX(6, "0352481679"),
    SIXTEEN(16, "6318250947"),
    TEN(10, "4516893702"),
    THIRTEEN(13, "6904283157"),
    THIRTY(30, "7528413960"),
    THIRTYONE(31, "9072846135"),
    THREE(3, "7951420386"),
    TWELVE(12, "5072483169"),
    TWENTY(20, "8746395021"),
    TWENTYEIGHT(28, "5892176304"),
    TWENTYFIVE(25, "7451628903"),
    TWENTYFOUR(24, "5174230896"),
    TWENTYNINE(29, "8395604721"),
    TWENTYONE(21, "9283417605"),
    TWENTYSEVEN(27, "4965287130"),
    TWENTYSIX(26, "5936820714"),
    TWENTYTHREE(23, "9745216038"),
    TWENTYTWO(22, "0583924176"),
    TWO(2, "7829463150");

    private int index;
    private String key;

    private DateEnum2(int var3, String var4) {
        this.index = var3;
        this.key = var4;
    }

    public static DateEnum2 getDateEnumByIndex(int var0) {
        DateEnum2[] var3 = values();
        int var2 = var3.length;

        for(int var1 = 0; var1 < var2; ++var1) {
            DateEnum2 var4 = var3[var1];
            if (var4.getIndex() == var0) {
                return var4;
            }
        }

        return null;
    }

    public static String getKeyByIndex(int var0) {
        DateEnum2[] var3 = values();
        int var2 = var3.length;

        for(int var1 = 0; var1 < var2; ++var1) {
            DateEnum2 var4 = var3[var1];
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
