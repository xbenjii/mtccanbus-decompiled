package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;

public class dj extends a
{
  public dj(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    for (int i = 0; ; i++)
    {
      int j = paramArrayOfByte.length;
      boolean bool = false;
      if (i < j)
      {
        if (paramArrayOfByte[i] != paramInt)
          break label28;
        bool = true;
      }
      label28: int k;
      do
      {
        return bool;
        k = paramArrayOfByte[i];
        bool = false;
      }
      while (k == -1);
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
  }

  public void a(String paramString, int paramInt)
  {
  }

  public void ah()
  {
    int i = Settings.System.getInt(this.cv.getContentResolver(), "canbus92settings", 0);
    CanBusServer localCanBusServer = this.cv;
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)i);
    localCanBusServer.a((byte)-125, arrayOfByte, 1);
  }

  public void aj()
  {
  }

  public void ak()
  {
  }

  public void al()
  {
  }

  public void am()
  {
  }

  public void an()
  {
  }

  public void ao()
  {
  }

  public void aq()
  {
    this.cv.a((byte)-126, new byte[] { 0 }, 1);
  }

  public void ar()
  {
    this.cv.a((byte)-126, new byte[] { -128 }, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 2:
    }
    while (true)
    {
      e(paramArrayOfByte, paramInt1, paramInt2);
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 24)
      {
        byte[] arrayOfByte = new byte[24];
        for (int i = 0; i < 24; i++)
          arrayOfByte[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
        n(arrayOfByte);
      }
    }
  }

  public void l(int paramInt)
  {
  }

  void n(byte[] paramArrayOfByte)
  {
    if (this.aB.a(a(paramArrayOfByte, 0), a(paramArrayOfByte, 2), a(paramArrayOfByte, 1), a(paramArrayOfByte, 3), a(paramArrayOfByte, 4), a(paramArrayOfByte, 5)))
      this.cv.a(this.aB);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dj
 * JD-Core Version:    0.6.2
 */