package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;

public class db extends a
{
  private static long de = 0L;
  private boolean dH = true;
  private int dI = 0;
  Handler mHandler = new dc(this);

  public db(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 85;
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

  private boolean aK()
  {
    long l = SystemClock.uptimeMillis();
    if (l - de > 1200L)
      de = l;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label41: label67: label87: label104: AirCondition localAirCondition3;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label254;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label265;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0xFF & paramArrayOfByte[4]) != 10)
        break label283;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[2]) == 0)
        break label294;
      this.d.windRear = true;
      switch (0xFF & paramArrayOfByte[4])
      {
      default:
        label148: this.d.windLevel = (0x7 & paramArrayOfByte[5]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[6];
        this.d.tempLeft = x(i);
        int j = 0xFF & paramArrayOfByte[7];
        this.d.tempRight = x(j);
        if ((0x10 & paramArrayOfByte[1]) != 0)
          localAirCondition3 = this.d;
        break;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    }
    label254: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label41;
      label265: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label67;
      label283: this.d.windFrontMax = false;
      break label87;
      label294: this.d.windRear = false;
      break label104;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label148;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label148;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label148;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label148;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label148;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label148;
      localAirCondition2 = this.d;
    }
  }

  private void y(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.microntek.controlsettings", "com.microntek.controlsettings.canbus21air"));
    localIntent.addFlags(807600128);
    localIntent.putExtra("cftype", paramInt);
    try
    {
      this.cv.startActivityAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        Log.e("Canbus21", "controlinfo activity not found! " + localActivityNotFoundException.getMessage());
    }
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
    int i = 0;
    int i1;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
        i1 = paramInt2 - paramInt1;
        if ((i1 > 3) && (i1 <= 40))
          break;
      case 17:
      case 18:
      case 65:
      case 49:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 10)
      {
        int m = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0x7F & paramArrayOfByte[(paramInt1 + 9)]) << 8);
        if (paramArrayOfByte[(paramInt1 + 9)] < 0)
          m = 0 - m;
        int n = 30 * (m / 10) / 520;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", n);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 10)
        {
          byte[] arrayOfByte3 = new byte[1];
          arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 5)];
          n(arrayOfByte3);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 12)
          {
            int[] arrayOfInt = new int[12];
            for (int k = 0; k < 12; k++)
              arrayOfInt[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
            if (arrayOfInt[10] == 1)
            {
              this.aY.max = 4;
              this.aY.back_cnt = 4;
              this.aY.b1 = F(arrayOfInt[0]);
              this.aY.b2 = F(arrayOfInt[1]);
              this.aY.b3 = F(arrayOfInt[2]);
              this.aY.b4 = F(arrayOfInt[3]);
              this.aY.front_cnt = 2;
              this.aY.f1 = F(arrayOfInt[4]);
              this.aY.f2 = F(arrayOfInt[7]);
              this.cv.a(this.aY);
              continue;
              if (a(paramArrayOfByte[(paramInt1 + 2)], 12))
              {
                byte[] arrayOfByte1 = new byte[this.mLength];
                for (int j = 0; j < this.mLength; j++)
                  arrayOfByte1[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
                if (((0x1 & arrayOfByte1[3]) != 0) && (aK()))
                  y(1);
                if (j(arrayOfByte1))
                {
                  m(arrayOfByte1);
                  this.cv.a(this.d);
                }
                byte[] arrayOfByte2 = new byte[2 + this.mLength];
                arrayOfByte2[0] = 49;
                arrayOfByte2[1] = ((byte)this.mLength);
                while (i < this.mLength)
                {
                  arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte2);
                continue;
                byte[] arrayOfByte4 = new byte[i1];
                while (i < i1)
                {
                  arrayOfByte4[i] = paramArrayOfByte[(i + (paramInt1 + 1))];
                  i++;
                }
                this.cv.d(arrayOfByte4);
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 254)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 255)
        i = 65535;
      else if ((paramInt >= 38) && (paramInt <= 62))
        i = paramInt * 10 / 2;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.db
 * JD-Core Version:    0.6.2
 */