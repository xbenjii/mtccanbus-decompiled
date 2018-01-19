package a.a;

import java.lang.reflect.Method;

public class a
{
  private static Class<?> eh = null;
  private static Method ei = null;
  private static Method ej = null;
  private static Method ek = null;

  public static String get(String paramString1, String paramString2)
  {
    init();
    try
    {
      str = (String)ei.invoke(eh, new Object[] { paramString1 });
      return str;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        String str = paramString2;
      }
    }
  }

  private static void init()
  {
    try
    {
      if (eh == null)
      {
        eh = Class.forName("android.os.SystemProperties");
        ei = eh.getDeclaredMethod("get", new Class[] { String.class });
        Class localClass = eh;
        Class[] arrayOfClass = new Class[2];
        arrayOfClass[0] = String.class;
        arrayOfClass[1] = Integer.TYPE;
        ej = localClass.getDeclaredMethod("getInt", arrayOfClass);
        ek = eh.getDeclaredMethod("set", new Class[] { String.class, String.class });
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     a.a.a
 * JD-Core Version:    0.6.2
 */