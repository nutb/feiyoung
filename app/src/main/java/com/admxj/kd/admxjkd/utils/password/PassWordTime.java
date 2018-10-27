package com.admxj.kd.admxjkd.utils.password;

import java.util.Calendar;

public class PassWordTime
{
  public static String a()
  {
    return DateEnum.getKeyByIndex(Calendar.getInstance().get(5));
  }
  
  public static String b()
  {
    return DateEnum2.getKeyByIndex(Calendar.getInstance().get(5));
  }
}
