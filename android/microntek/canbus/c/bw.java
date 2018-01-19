package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.d.b;
import android.microntek.canbus.serializable.Door;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;

public class bw extends a
{
  private boolean dH = true;
  private int dI = 0;
  Handler mHandler = new bx(this);

  public bw(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 64;
  }

  private int F(int paramInt)
  {
    int i = 4;
    if (paramInt == 1);
    while (true)
    {
      return i;
      if (paramInt == 2)
        i = 3;
      else if (paramInt == 3)
        i = 2;
      else if (paramInt == i)
        i = 1;
      else
        i = 0;
    }
  }

  private void c(boolean paramBoolean)
  {
    b.a(new String[] { "com.microntek.controlinfo" }, paramBoolean, this.cv.getPackageManager());
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
        arrayOfByte[10] = 77;
        arrayOfByte[11] = 72;
        arrayOfByte[12] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-31, arrayOfByte, 13);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 + 1));
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 32;
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[9] = 75;
      arrayOfByte[10] = 72;
      arrayOfByte[11] = 90;
      break;
      arrayOfByte[5] = ((byte)(48 + paramInt / 100));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 11, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    int i = Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.control64settings", 1);
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 2;
    arrayOfByte[1] = ((byte)i);
    this.cv.f((byte)45, arrayOfByte, 2);
    this.mHandler.removeMessages(0);
    this.mHandler.sendEmptyMessageDelayed(0, 0L);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = ((byte)(0xFF & this.hour));
    arrayOfByte[1] = ((byte)(0xFF & this.minute));
    this.cv.f((byte)-75, arrayOfByte, 3);
    if (this.dH)
    {
      this.dH = false;
      arrayOfByte[0] = 5;
      arrayOfByte[1] = 1;
      arrayOfByte[2] = 97;
      this.cv.f((byte)106, arrayOfByte, 3);
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 32, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 12, 32, 109, 111, 118, 105, 101, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if (paramInt3 == 2);
    for (int i = 7; ; i = 6)
    {
      arrayOfByte[0] = i;
      arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
      arrayOfByte[6] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
      arrayOfByte[7] = 58;
      arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
      arrayOfByte[9] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
      arrayOfByte[10] = 58;
      arrayOfByte[11] = ((byte)(48 + paramInt2 % 60 / 10));
      arrayOfByte[12] = ((byte)(48 + paramInt2 % 60 % 10));
      this.cv.f((byte)-31, arrayOfByte, 13);
      return;
    }
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 12, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    int k = 0;
    int i2;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
        i2 = paramInt2 - paramInt1;
        if ((i2 > 3) && (i2 <= 40))
          break;
      case 17:
      case 18:
      case 65:
      case 97:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = i;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 10)
      {
        int n = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0x7F & paramArrayOfByte[(paramInt1 + 9)]) << 8);
        if (paramArrayOfByte[(paramInt1 + 9)] < 0)
          n = 0 - n;
        int i1 = 30 * (n / 10) / 520;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", i1);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 10)
        {
          byte[] arrayOfByte1 = new byte[i];
          arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 5)];
          n(arrayOfByte1);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 12)
          {
            int[] arrayOfInt = new int[12];
            for (int m = 0; m < 12; m++)
              arrayOfInt[m] = (0xFF & paramArrayOfByte[(m + (paramInt1 + 3))]);
            if (arrayOfInt[10] == i)
            {
              this.aY.max = 4;
              this.aY.back_cnt = 4;
              this.aY.b1 = F(arrayOfInt[0]);
              this.aY.b2 = F(arrayOfInt[i]);
              this.aY.b3 = F(arrayOfInt[2]);
              this.aY.b4 = F(arrayOfInt[3]);
              this.aY.front_cnt = 2;
              this.aY.f1 = F(arrayOfInt[4]);
              this.aY.f2 = F(arrayOfInt[7]);
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 9)
              {
                if ((0x10 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
                {
                  Settings.System.putInt(this.cv.getContentResolver(), "CanBusBackViewDownViewDis", i);
                  label471: if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) == 0)
                    break label509;
                }
                while (true)
                {
                  c(i);
                  break;
                  Settings.System.putInt(this.cv.getContentResolver(), "CanBusBackViewDownViewDis", 0);
                  break label471;
                  label509: int j = 0;
                }
                byte[] arrayOfByte2 = new byte[i2];
                while (k < i2)
                {
                  arrayOfByte2[k] = paramArrayOfByte[(k + (paramInt1 + 1))];
                  k++;
                }
                this.cv.d(arrayOfByte2);
              }
            }
          }
        }
      }
    }
  }

  public void l(int paramInt)
  {
  }

  void n(byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    Door localDoor = this.aB;
    boolean bool2;
    boolean bool3;
    label32: boolean bool4;
    label44: boolean bool5;
    label56: boolean bool6;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label112;
      bool3 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label118;
      bool4 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label124;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label130;
      bool6 = bool1;
      label68: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label136;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label112: bool3 = false;
      break label32;
      label118: bool4 = false;
      break label44;
      label124: bool5 = false;
      break label56;
      label130: bool6 = false;
      break label68;
      label136: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bw
 * JD-Core Version:    0.6.2
 */