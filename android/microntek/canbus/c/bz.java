package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.text.format.DateFormat;
import android.text.format.Time;

public class bz extends a
{
  public bz(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 66;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = 1;
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = 0;
        arrayOfByte[10] = 0;
        arrayOfByte[11] = 0;
        arrayOfByte[12] = 0;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.b((byte)-31, arrayOfByte, 13);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
      }
    arrayOfByte[0] = 4;
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[8] = 0;
      arrayOfByte[9] = 0;
      arrayOfByte[10] = 0;
      arrayOfByte[11] = 0;
      arrayOfByte[12] = 0;
      break;
      arrayOfByte[4] = ((byte)(48 + paramInt / 100));
      arrayOfByte[5] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt % 10));
      arrayOfByte[7] = 0;
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void ah()
  {
  }

  public void aj()
  {
    int i = 12;
    Time localTime = new Time();
    localTime.setToNow();
    int j = localTime.hour;
    int k = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[3];
    if (!bool)
    {
      if (j > i)
        j -= 12;
      if (j != 0);
    }
    while (true)
    {
      arrayOfByte[0] = ((byte)i);
      arrayOfByte[1] = ((byte)k);
      this.cv.b((byte)-75, arrayOfByte, 3);
      return;
      i = j;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 65, 50, 68, 80, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 7, 32, 32, 32, 32, 32, 32, 58, 32, 32, 32, 32, 32 };
    if (paramInt3 == 0)
      arrayOfByte[0] = 6;
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 % 60 % 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    arrayOfByte[0] = 13;
    arrayOfByte[1] = ((byte)(48 + paramInt2 / 100 % 10));
    arrayOfByte[2] = ((byte)(48 + paramInt2 / 10 % 10));
    arrayOfByte[3] = ((byte)(48 + paramInt2 % 10));
    int i = paramInt3 / 1000;
    arrayOfByte[5] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[7] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[8] = ((byte)(48 + i % 60 % 10));
    this.cv.b((byte)-31, arrayOfByte, 13);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case -92:
    case -79:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 11)
      {
        byte[] arrayOfByte2 = new byte[13];
        arrayOfByte2[0] = -92;
        arrayOfByte2[1] = 11;
        while (i < 11)
        {
          arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.e(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
        {
          byte[] arrayOfByte1 = new byte[4];
          arrayOfByte1[0] = -79;
          arrayOfByte1[1] = 2;
          while (i < 2)
          {
            arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.e(arrayOfByte1);
        }
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bz
 * JD-Core Version:    0.6.2
 */