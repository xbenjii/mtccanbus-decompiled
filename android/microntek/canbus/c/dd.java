package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class dd extends a
{
  public dd(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 86;
  }

  public void ah()
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case -48:
    case -96:
    }
    do
      while (true)
      {
        return;
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          byte[] arrayOfByte = new byte[1];
          arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
          n(arrayOfByte);
        }
      }
    while (paramArrayOfByte[(paramInt1 + 2)] != 2);
    int i = 0x1 & paramArrayOfByte[(paramInt1 + 3)];
    int j = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
    StringBuilder localStringBuilder;
    Locale localLocale;
    Object[] arrayOfObject;
    if (j <= 59)
    {
      localStringBuilder = new StringBuilder();
      localLocale = Locale.US;
      arrayOfObject = new Object[1];
      if (i == 1)
        j = 0 - j;
      arrayOfObject[0] = Integer.valueOf(j);
    }
    for (String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651); ; str = "")
    {
      Intent localIntent = new Intent("com.canbus.temperature");
      localIntent.putExtra("temperature", str);
      this.mContext.sendBroadcast(localIntent);
      break;
    }
  }

  void n(byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    Door localDoor = this.aB;
    boolean bool2;
    boolean bool3;
    label29: boolean bool4;
    label40: boolean bool5;
    label52: boolean bool6;
    if ((0x1 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label108;
      bool3 = bool1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label114;
      bool4 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label120;
      bool5 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label126;
      bool6 = bool1;
      label64: if ((0x0 & paramArrayOfByte[0]) == 0)
        break label132;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label108: bool3 = false;
      break label29;
      label114: bool4 = false;
      break label40;
      label120: bool5 = false;
      break label52;
      label126: bool6 = false;
      break label64;
      label132: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dd
 * JD-Core Version:    0.6.2
 */