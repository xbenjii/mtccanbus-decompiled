package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import java.util.Locale;

public class af extends a
{
  private static long de = 0L;
  byte[] cB = new byte[9];
  private boolean dn = false;

  public af(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 21;
    this.d = new AirCondition();
  }

  private boolean aK()
  {
    long l = SystemClock.uptimeMillis();
    if (l - de > 1200L)
      de = l;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private int aO()
  {
    if (this.cv.y == 2);
    for (int i = 10; ; i = 4)
      return i;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label103: label121: boolean bool;
    label138: label155: label194: int i;
    label232: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label334;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label345;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label363;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label374;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label385;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label396;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label407;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label418;
      bool = true;
      localAirCondition2.tempUnit = bool;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label424;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label506;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.tempRight = 0;
      label263: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label588;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 1;
      label289: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label608;
    }
    label334: label345: label608: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label43;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label363: this.d.modeDual = 0;
      break label85;
      label374: this.d.windFrontMax = false;
      break label103;
      this.d.windUp = false;
      break label121;
      this.d.windMid = false;
      break label138;
      this.d.windDown = false;
      break label155;
      bool = false;
      break label194;
      if (i == 255)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempLeft = 65535;
        break label232;
      }
      if ((i < 1) || (i > 254))
        break label232;
      if (this.d.tempUnit)
      {
        this.d.tempLeft = (i * 10);
        break label232;
      }
      this.d.tempLeft = (i * 5);
      break label232;
      label506: if (j == 255)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempRight = 65535;
        break label263;
      }
      if ((j < 1) || (j > 254))
        break label263;
      if (this.d.tempUnit)
      {
        this.d.tempRight = (j * 10);
        break label263;
      }
      this.d.tempRight = (j * 5);
      break label263;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label289;
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
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 1))
    {
      arrayOfByte2[0] = ((byte)(paramByte1 + 1));
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if (paramByte1 == 2)
      {
        arrayOfByte2[0] = 2;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
      else if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte2[0] = 16;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte1 = { 6, 18 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[4] = -1;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 5, 64 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    ai();
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      this.cv.a((byte)-58, new byte[] { 85, 0 }, 2);
    while (true)
    {
      return;
      if (str.equals("en"))
        this.cv.a((byte)-58, new byte[] { 85, 1 }, 2);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 80;
    if (!bool)
      if (this.hour <= 12)
        break label113;
    label113: for (this.hour = (128 + (-12 + this.hour)); ; this.hour = (128 + this.hour))
    {
      arrayOfByte[1] = ((byte)(0xFF & this.hour));
      arrayOfByte[2] = ((byte)(0xFF & this.minute));
      arrayOfByte[3] = 0;
      this.cv.a((byte)-58, arrayOfByte, 4);
      return;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 7, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void al()
  {
    byte[] arrayOfByte = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void am()
  {
    byte[] arrayOfByte = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void an()
  {
    byte[] arrayOfByte = { 11, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 8, 32 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 2, 16 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 0;
    arrayOfByte2[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[4] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 8, 17 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[4] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 36:
    case 34:
    case 35:
    case 33:
    case 51:
    case 41:
    case -48:
    case 50:
    case 38:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte10 = new byte[1];
        arrayOfByte10[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte10);
        if ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 4)]) == 1)
        {
          this.dn = true;
        }
        else
        {
          this.dn = false;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte9 = new byte[4];
            for (int i8 = 0; i8 < 4; i8++)
              arrayOfByte9[i8] = paramArrayOfByte[(i8 + (paramInt1 + 3))];
            ax();
            this.aY.max = aO();
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte9[0];
            this.aY.b2 = arrayOfByte9[1];
            this.aY.b3 = arrayOfByte9[2];
            this.aY.b4 = arrayOfByte9[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte8 = new byte[4];
              for (int i6 = 0; i6 < 4; i6++)
                arrayOfByte8[i6] = paramArrayOfByte[(i6 + (paramInt1 + 3))];
              int i7 = this.cv.l();
              if (i7 == 0);
              for (this.aY.zero_show = false; ; this.aY.zero_show = true)
              {
                this.aY.max = aO();
                this.aY.front_cnt = 4;
                this.aY.f1 = arrayOfByte8[0];
                this.aY.f2 = arrayOfByte8[1];
                this.aY.f3 = arrayOfByte8[2];
                this.aY.f4 = arrayOfByte8[3];
                if ((this.aY.f1 == 0) && (this.aY.f2 == 0) && (this.aY.f3 == 0) && (this.aY.f4 == 0) && (i7 != 1))
                  break;
                this.cv.a(this.aY);
                break;
              }
              if (paramArrayOfByte[(paramInt1 + 2)] == 6)
              {
                byte[] arrayOfByte6 = new byte[6];
                for (int i5 = 0; i5 < 6; i5++)
                  arrayOfByte6[i5] = paramArrayOfByte[(i5 + (paramInt1 + 3))];
                if ((0x10 & arrayOfByte6[1]) != 0)
                {
                  m(arrayOfByte6);
                  this.cv.a(this.d);
                }
                byte[] arrayOfByte7 = new byte[8];
                arrayOfByte7[0] = 33;
                arrayOfByte7[1] = 6;
                while (i < 6)
                {
                  arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte7);
              }
              else if (paramArrayOfByte[(paramInt1 + 2)] >= 9)
              {
                byte[] arrayOfByte4 = new byte[9];
                int i3 = 0;
                int i4 = 0;
                if (i3 < 9)
                {
                  arrayOfByte4[i3] = paramArrayOfByte[(i3 + (paramInt1 + 3))];
                  if (i3 >= 6);
                  while (true)
                  {
                    i3++;
                    break;
                    if (arrayOfByte4[i3] != this.cB[i3])
                      i4 = 1;
                    this.cB[i3] = arrayOfByte4[i3];
                  }
                }
                if (((0x40 & arrayOfByte4[4]) != 0) && (aK()))
                  y(1);
                if ((i4 != 0) && ((0x10 & arrayOfByte4[1]) != 0))
                {
                  m(arrayOfByte4);
                  this.cv.a(this.d);
                }
                byte[] arrayOfByte5 = new byte[11];
                arrayOfByte5[0] = 33;
                arrayOfByte5[1] = 9;
                while (i < 9)
                {
                  arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte5);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 15) || (paramArrayOfByte[(paramInt1 + 2)] == 18))
                {
                  byte[] arrayOfByte3 = new byte[1 + paramArrayOfByte[(paramInt1 + 2)]];
                  for (int i2 = 0; i2 < 1 + paramArrayOfByte[(paramInt1 + 2)]; i2++)
                    arrayOfByte3[i2] = paramArrayOfByte[(i2 + (paramInt1 + 2))];
                  this.cv.d(arrayOfByte3);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                  {
                    int n = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                    if (n >= 32768)
                      n += 0;
                    int i1 = n * 30 / 4500;
                    Intent localIntent2 = new Intent("com.microntek.canbusbackview");
                    localIntent2.putExtra("canbustype", this.e);
                    localIntent2.putExtra("lfribackview", i1);
                    this.mContext.sendBroadcast(localIntent2);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                    {
                      byte[] arrayOfByte2 = new byte[4];
                      arrayOfByte2[0] = -48;
                      arrayOfByte2[1] = 2;
                      while (i < 2)
                      {
                        arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.d(arrayOfByte2);
                      continue;
                      int m = 0xF & paramArrayOfByte[(paramInt1 + 2)];
                      byte[] arrayOfByte1 = new byte[m + 2];
                      arrayOfByte1[0] = 50;
                      arrayOfByte1[1] = ((byte)m);
                      while (i < m)
                      {
                        arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.d(arrayOfByte1);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                      {
                        int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                        if (j >= 32768)
                          j += 0;
                        int k = j * 30 / 450;
                        Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                        localIntent1.putExtra("canbustype", this.e);
                        localIntent1.putExtra("lfribackview", 0 - k);
                        this.mContext.sendBroadcast(localIntent1);
                      }
                    }
                  }
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
    new byte[1][0] = ((byte)(paramInt & 0x3F));
  }

  void n(byte[] paramArrayOfByte)
  {
    int i = 1;
    if (this.cv.y == i)
    {
      Door localDoor2 = this.aB;
      if ((0x80 & paramArrayOfByte[0]) != 0)
      {
        int j = i;
        if ((0x40 & paramArrayOfByte[0]) == 0)
          break label125;
        int m = i;
        label44: if ((0x20 & paramArrayOfByte[0]) == 0)
          break label131;
        int i1 = i;
        label56: if ((0x10 & paramArrayOfByte[0]) == 0)
          break label137;
        int i3 = i;
        label68: if ((0x8 & paramArrayOfByte[0]) == 0)
          break label143;
        int i5 = i;
        label80: if ((0x4 & paramArrayOfByte[0]) == 0)
          break label149;
        label88: if (localDoor2.a(j, m, i1, i3, i5, i))
          this.cv.a(this.aB);
      }
    }
    label131: label137: label143: label149: label278: label284: label290: label293: 
    while (true)
    {
      return;
      int k = 0;
      break;
      label125: int n = 0;
      break label44;
      int i2 = 0;
      break label56;
      int i4 = 0;
      break label68;
      int i6 = 0;
      break label80;
      boolean bool1 = false;
      break label88;
      Door localDoor1 = this.aB;
      boolean bool2;
      label171: boolean bool3;
      label184: boolean bool4;
      label196: boolean bool5;
      label208: boolean bool6;
      if ((0x40 & paramArrayOfByte[0]) != 0)
      {
        bool2 = bool1;
        if ((0x80 & paramArrayOfByte[0]) == 0)
          break label266;
        bool3 = bool1;
        if ((0x10 & paramArrayOfByte[0]) == 0)
          break label272;
        bool4 = bool1;
        if ((0x20 & paramArrayOfByte[0]) == 0)
          break label278;
        bool5 = bool1;
        if ((0x8 & paramArrayOfByte[0]) == 0)
          break label284;
        bool6 = bool1;
        label220: if ((0x4 & paramArrayOfByte[0]) == 0)
          break label290;
      }
      while (true)
      {
        if (!localDoor1.a(bool2, bool3, bool4, bool5, bool6, bool1))
          break label293;
        this.cv.a(this.aB);
        break;
        bool2 = false;
        break label171;
        bool3 = false;
        break label184;
        bool4 = false;
        break label196;
        bool5 = false;
        break label208;
        bool6 = false;
        break label220;
        bool1 = false;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.af
 * JD-Core Version:    0.6.2
 */