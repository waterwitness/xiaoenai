package com.nostra13.universalimageloader.b;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class c
{
  private static volatile boolean a = false;
  private static volatile boolean b = true;
  
  private static void a(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (!b) {
      return;
    }
    if (paramVarArgs.length > 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    for (;;)
    {
      if (paramThrowable == null) {}
      for (;;)
      {
        Log.println(paramInt, ImageLoader.TAG, paramString);
        return;
        paramVarArgs = paramString;
        if (paramString == null) {
          paramVarArgs = paramThrowable.getMessage();
        }
        paramString = String.format("%1$s\n%2$s", new Object[] { paramVarArgs, Log.getStackTraceString(paramThrowable) });
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {
      a(3, null, paramString, paramVarArgs);
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(6, paramThrowable, null, new Object[0]);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    a(4, null, paramString, paramVarArgs);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    a(5, null, paramString, paramVarArgs);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    a(6, null, paramString, paramVarArgs);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */