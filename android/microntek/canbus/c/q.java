package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class q extends a
{
  private byte[] dj = new byte[13];

  public q(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void aM()
  {
    for (int i = 0; i < 13; i++)
      this.dj[i] = 32;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label60: label204: if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label354;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label365;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[1]) == 0)
        break label383;
      this.d.modeDual = 1;
      label76: if ((0x10 & paramArrayOfByte[2]) == 0)
        break label394;
      this.d.windFrontMax = true;
      label93: if ((0x20 & paramArrayOfByte[2]) == 0)
        break label405;
      this.d.windRear = true;
      label110: switch (0xF & paramArrayOfByte[4])
      {
      case 4:
      case 7:
      case 8:
      case 9:
      case 10:
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        this.d.windLevel = (0xF & paramArrayOfByte[5]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[6];
        this.d.tempLeft = v(i);
        int j = 0xFF & paramArrayOfByte[7];
        this.d.tempRight = v(j);
        if ((0x10 & paramArrayOfByte[1]) != 0)
        {
          AirCondition localAirCondition3 = this.d;
          localAirCondition3.windLoop = 1;
          if ((0x20 & paramArrayOfByte[0]) == 0)
            break label625;
        }
        break;
      case 3:
      case 5:
      case 6:
      case 11:
      case 12:
      case 13:
      case 14:
      }
    }
    label298: label354: label365: label625: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[2]);
      this.d.seatHotRight = ((0xC & paramArrayOfByte[2]) >> 2);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      label383: this.d.modeDual = 0;
      break label76;
      this.d.windFrontMax = false;
      break label93;
      this.d.windRear = false;
      break label110;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label204;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label204;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label204;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label204;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label204;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label204;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label204;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label298;
    }
  }

  private int v(int paramInt)
  {
    int i;
    if (paramInt == 254)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 255)
        i = 65535;
      else if (paramInt < 100)
        i = paramInt * 5;
      else
        i = -1;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    aM();
    this.dj[0] = ((byte)(paramByte1 + 1));
    this.dj[1] = ((byte)(48 + paramByte2 / 10 % 10));
    this.dj[2] = ((byte)(48 + paramByte2 % 10));
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
      if (paramInt > 9999)
      {
        this.dj[4] = ((byte)(48 + paramInt / 10000));
        this.dj[5] = ((byte)(48 + paramInt / 1000 % 10));
        this.dj[6] = ((byte)(48 + paramInt / 100 % 10));
        this.dj[7] = 46;
        this.dj[8] = ((byte)(48 + paramInt / 10 % 10));
        this.dj[9] = 77;
        this.dj[10] = 72;
        this.dj[11] = 90;
      }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-111, this.dj, 13);
        return;
        this.dj[5] = ((byte)(48 + paramInt / 1000));
        this.dj[6] = ((byte)(48 + paramInt / 100 % 10));
        this.dj[7] = 46;
        this.dj[8] = ((byte)(48 + paramInt / 10 % 10));
      }
    if (paramInt > 999)
    {
      this.dj[4] = ((byte)(48 + paramInt / 1000));
      this.dj[5] = ((byte)(48 + paramInt / 100 % 10));
      this.dj[6] = ((byte)(48 + paramInt / 10 % 10));
      this.dj[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      this.dj[9] = 75;
      this.dj[10] = 72;
      this.dj[11] = 90;
      break;
      this.dj[4] = 48;
      this.dj[5] = ((byte)(48 + paramInt / 100));
      this.dj[6] = ((byte)(48 + paramInt / 10 % 10));
      this.dj[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    ak();
  }

  public void a(String paramString, int paramInt)
  {
    aM();
    an();
  }

  public int[][] aA()
  {
    return new int[][] { { 3842, 23205, 15618, 2, 0 }, { 3842, 23205, 15618, 2, 1 }, { 3845, 23205, 15618, 7, 0 }, { 3845, 23205, 15618, 7, 1 }, { 3846, 23205, 15618, 4, 0 }, { 3846, 23205, 15618, 4, 1 }, { 3847, 23205, 15618, 13, 0 }, { 3847, 23205, 15618, 13, 1 }, { 3848, 23205, 15618, 14, 0 }, { 3848, 23205, 15618, 14, 1 }, { 3849, 23205, 15618, 15, 0 }, { 3849, 23205, 15618, 15, 1 }, { 3850, 23205, 15618, 16, 0 }, { 3850, 23205, 15618, 16, 1 }, { 3853, 23205, 15618, 1, 0 }, { 3853, 23205, 15618, 1, 1 }, { 3855, 23205, 15618, 12, 0 }, { 3855, 23205, 15618, 12, 1 }, { 3856, 23205, 15618, 11, 0 }, { 3856, 23205, 15618, 11, 1 }, { 3857, 23205, 15618, 3, 0 }, { 3857, 23205, 15618, 3, 1 }, { 3858, 23205, 15618, 28, 0 }, { 3858, 23205, 15618, 28, 1 }, { 3860, 23205, 15618, 25, 0 }, { 3860, 23205, 15618, 25, 1 }, { 3861, 23205, 15618, 27, 0 }, { 3861, 23205, 15618, 27, 1 }, { 3863, 23205, 15618, 26, 0 }, { 3863, 23205, 15618, 26, 1 }, { 3872, 23205, 15618, 5, 0 }, { 3872, 23205, 15618, 5, 1 } };
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    ai();
    int i;
    switch (this.cv.y)
    {
    default:
      i = 18;
    case 4:
    case 3:
    case 2:
    case 1:
    }
    while (true)
    {
      this.cv.f((byte)36, new byte[] { i, 53 }, 2);
      return;
      i = 20;
      continue;
      i = 19;
      continue;
      i = 14;
      continue;
      i = 11;
    }
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      this.cv.f((byte)-102, new byte[] { 1, 2 }, 2);
    while (true)
    {
      return;
      if (str.equals("en"))
        this.cv.f((byte)-102, new byte[] { 1, 1 }, 2);
      else
        this.cv.f((byte)-102, new byte[] { 1, 0 }, 2);
    }
  }

  public void aj()
  {
    int i = 1;
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[i] = ((byte)(0xFF & this.hour));
    arrayOfByte[2] = ((byte)(0xFF & this.minute));
    if (bool);
    while (true)
    {
      arrayOfByte[5] = ((byte)i);
      this.cv.f((byte)-53, arrayOfByte, 10);
      return;
      i = 0;
    }
  }

  public void ak()
  {
    aM();
    this.dj[0] = 12;
    this.cv.f((byte)-111, this.dj, 13);
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
    aM();
    this.dj[0] = -123;
    this.cv.f((byte)-111, this.dj, 13);
  }

  public void ap()
  {
    aM();
    this.dj[0] = 0;
    this.cv.f((byte)-111, this.dj, 13);
  }

  public void az()
  {
    this.cv.f((byte)106, new byte[] { 5, 1, 49 }, 3);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ak();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    aM();
    this.dj[0] = 25;
    this.cv.f((byte)-111, this.dj, 13);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 17:
    case 18:
    case 49:
    case 65:
    case -121:
    case -24:
    case -16:
    case 38:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 10)
      {
        int n = (0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 10)];
        if (n != 0)
        {
          if (n >= 32768)
            n += 0;
          o(n * 30 / 10000);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 10)
          {
            byte[] arrayOfByte2 = new byte[1];
            arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 5)];
            n(arrayOfByte2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
            {
              byte[] arrayOfByte1 = f(paramArrayOfByte, paramInt1 + 3, paramInt2 - 1);
              if (j(arrayOfByte1))
              {
                m(arrayOfByte1);
                this.cv.a(this.d);
              }
              int m = 0xFF & paramArrayOfByte[(paramInt1 + 14)];
              String str = "";
              if (m <= 214)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                Locale localLocale = Locale.US;
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = Float.valueOf(m / 2.0F - 40.0F);
                str = String.format(localLocale, "  %.1f", arrayOfObject) + this.mContext.getString(2131099651);
              }
              f(str);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
              {
                int i = paramArrayOfByte[(paramInt1 + 14)];
                int[] arrayOfInt = new int[12];
                int j = 0;
                if (j < 11)
                {
                  arrayOfInt[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                  if (i == 0)
                    if (arrayOfInt[j] >= 4)
                      arrayOfInt[j] = 0;
                  while (true)
                  {
                    j++;
                    break;
                    if (arrayOfInt[j] <= 150)
                      arrayOfInt[j] = (20 * arrayOfInt[j] / 150);
                    else
                      arrayOfInt[j] = 0;
                  }
                }
                if (arrayOfInt[10] == 1)
                {
                  ax();
                  Radar localRadar = this.aY;
                  if (i == 0);
                  for (int k = 3; ; k = 20)
                  {
                    localRadar.max = k;
                    this.aY.back_cnt = 4;
                    this.aY.b1 = arrayOfInt[0];
                    this.aY.b2 = arrayOfInt[1];
                    this.aY.b3 = arrayOfInt[2];
                    this.aY.b4 = arrayOfInt[3];
                    this.aY.front_cnt = 4;
                    this.aY.f1 = arrayOfInt[4];
                    this.aY.f2 = arrayOfInt[5];
                    this.aY.f3 = arrayOfInt[6];
                    this.aY.f4 = arrayOfInt[7];
                    this.cv.a(this.aY);
                    break;
                  }
                  e(paramArrayOfByte, paramInt1, paramInt2);
                }
              }
            }
          }
        }
      }
    }
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
      label68: if ((0x1 & paramArrayOfByte[0]) == 0)
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
 * Qualified Name:     android.microntek.canbus.c.q
 * JD-Core Version:    0.6.2
 */