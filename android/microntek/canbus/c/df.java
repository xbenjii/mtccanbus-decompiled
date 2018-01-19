package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class df extends a
{
  private boolean dX;

  public df(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 88;
  }

  private int H(int paramInt)
  {
    if (this.d.tempUnit);
    for (int i = (int)(32.0D + 1.8D * (paramInt * 10)); ; i = paramInt * 10)
      return i;
  }

  private void c(byte paramByte)
  {
    this.cv.a((byte)-58, new byte[] { 0, paramByte }, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label52: label69: label87: label104: label121: boolean bool1;
    label158: boolean bool2;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label287;
      this.d.modeAc = true;
      if ((0x1 & paramArrayOfByte[6]) == 0)
        break label298;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label309;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label320;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label331;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label342;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition1 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label353;
      bool1 = true;
      localAirCondition1.tempUnit = bool1;
      if ((0x2 & paramArrayOfByte[4]) == 0)
        break label358;
      bool2 = true;
      label174: this.dX = bool2;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = x(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = x(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label364;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 1;
      label250: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label384;
    }
    label384: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      label287: this.d.modeAc = false;
      break label35;
      label298: this.d.windFrontMax = false;
      break label52;
      label309: this.d.windRear = false;
      break label69;
      label320: this.d.windUp = false;
      break label87;
      label331: this.d.windMid = false;
      break label104;
      label342: this.d.windDown = false;
      break label121;
      label353: bool1 = false;
      break label158;
      label358: bool2 = false;
      break label174;
      label364: AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label250;
    }
  }

  private int s(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0 - paramInt;
    try
    {
      int i = Settings.System.getInt(this.cv.getContentResolver(), "canbus1_angle", 450);
      if (paramInt > i)
        Settings.System.putInt(this.cv.getContentResolver(), "canbus1_angle", paramInt);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 1));
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte[5] = ((byte)(paramByte2 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 8);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[2] = ((byte)(16 + (paramByte1 - 2)));
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[5] = ((byte)(paramByte2 + 1));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    ap();
  }

  public void ah()
  {
    this.cv.e(1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("en"))
      c((byte)1);
    while (true)
    {
      return;
      if (str.equals("de"))
        c((byte)3);
      else if (str.equals("it"))
        c((byte)5);
      else if (str.equals("fr"))
        c((byte)2);
      else if (str.equals("es"))
        c((byte)4);
      else if (str.equals("nl"))
        c((byte)6);
      else if (str.equals("pt"))
        c((byte)8);
      else if (str.equals("pl"))
        c((byte)7);
      else if (str.equals("tr"))
        c((byte)9);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[6];
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
      this.hour = (0x80 | this.hour);
    }
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-57, arrayOfByte, 6);
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 7;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void al()
  {
    ak();
  }

  public void am()
  {
    ak();
  }

  public void an()
  {
    ak();
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 2;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[5] = ((byte)(paramInt2 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt2 % 60));
    ak();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = 17;
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[4] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[5] = ((byte)(0xFF & paramInt2 >> 8));
    int i = paramInt3 / 1000;
    arrayOfByte[6] = ((byte)(i / 60 % 60));
    arrayOfByte[7] = ((byte)(i % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
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
    case 33:
    case 36:
    case 41:
    case 39:
    case 64:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
      {
        byte[] arrayOfByte3 = new byte[7];
        while (i < 7)
        {
          arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        if ((0x10 & arrayOfByte3[1]) != 0)
        {
          m(arrayOfByte3);
          this.cv.a(this.d);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && ((0x1 & paramArrayOfByte[(paramInt1 + 3)]) != 0))
          {
            byte[] arrayOfByte2 = new byte[1];
            arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 2)
            {
              int n = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
              if (n >= 32768)
                n += 0;
              int i1 = n * 30 / s(n);
              Intent localIntent2 = new Intent("com.microntek.canbusbackview");
              localIntent2.putExtra("canbustype", this.e);
              localIntent2.putExtra("lfribackview", i1);
              this.mContext.sendBroadcast(localIntent2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int k = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
                String str = "";
                int m;
                StringBuilder localStringBuilder1;
                Locale localLocale1;
                Object[] arrayOfObject1;
                if (k > 0)
                {
                  m = -39 + k / 2;
                  if (paramArrayOfByte[(paramInt1 + 4)] != 0)
                    break label423;
                  localStringBuilder1 = new StringBuilder();
                  localLocale1 = Locale.US;
                  arrayOfObject1 = new Object[1];
                  arrayOfObject1[0] = Integer.valueOf(m);
                }
                label423: StringBuilder localStringBuilder2;
                Locale localLocale2;
                Object[] arrayOfObject2;
                for (str = String.format(localLocale1, " %d", arrayOfObject1) + this.mContext.getString(2131099651); ; str = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099652))
                {
                  Intent localIntent1 = new Intent("com.canbus.temperature");
                  localIntent1.putExtra("temperature", str);
                  this.mContext.sendBroadcast(localIntent1);
                  break;
                  localStringBuilder2 = new StringBuilder();
                  localLocale2 = Locale.US;
                  arrayOfObject2 = new Object[1];
                  arrayOfObject2[0] = Integer.valueOf((int)(32.0D + 1.8D * m));
                }
                if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                {
                  byte[] arrayOfByte1 = new byte[6];
                  arrayOfByte1[0] = 64;
                  arrayOfByte1[1] = 4;
                  for (int j = 0; j < 4; j++)
                    arrayOfByte1[(j + 2)] = paramArrayOfByte[(j + (paramInt1 + 3))];
                  this.cv.d(arrayOfByte1);
                }
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
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x80 & paramArrayOfByte[0]) == 0)
        break label112;
      bool3 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label118;
      bool4 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label124;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label130;
      bool6 = bool1;
      label68: if ((0x0 & paramArrayOfByte[0]) == 0)
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
    if (paramInt == 0)
      paramInt = 0;
    while (true)
    {
      return paramInt;
      if (paramInt == 255)
        paramInt = 65535;
      else if ((paramInt >= 1) && (paramInt <= 254))
      {
        if (this.dX)
          switch (paramInt >> 6)
          {
          default:
            break;
          case 0:
          case 3:
            paramInt = H(26);
            break;
          case 1:
            paramInt = H(18);
            break;
          case 2:
            paramInt = H(28);
            break;
          }
        else if (this.d.tempUnit)
          paramInt *= 10;
        else
          paramInt = paramInt * 10 / 2;
      }
      else
        paramInt = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.df
 * JD-Core Version:    0.6.2
 */