package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.Time;
import java.util.Locale;

public class p extends a
{
  public p(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label33: label59: label75: label92: label109: AirCondition localAirCondition3;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x3 & paramArrayOfByte[0]) == 0)
        break label333;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[1]) == 0)
        break label344;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label362;
      this.d.modeDual = 1;
      if ((0x10 & paramArrayOfByte[2]) == 0)
        break label373;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[2]) == 0)
        break label384;
      this.d.windRear = true;
      switch (0xF & paramArrayOfByte[4])
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
        label200: this.d.windLevel = (0xF & paramArrayOfByte[5]);
        this.d.windLevelMax = 8;
        int i = 0xFF & paramArrayOfByte[6];
        this.d.tempLeft = v(i);
        int j = 0xFF & paramArrayOfByte[7];
        this.d.tempRight = v(j);
        if ((0x10 & paramArrayOfByte[1]) == 0)
          localAirCondition3 = this.d;
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
    label333: label344: label362: label373: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[2]);
      this.d.seatHotRight = ((0xC & paramArrayOfByte[2]) >> 2);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label33;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label59;
      this.d.modeDual = 0;
      break label75;
      this.d.windFrontMax = false;
      break label92;
      label384: this.d.windRear = false;
      break label109;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label200;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label200;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label200;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label200;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label200;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label200;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label200;
      localAirCondition2 = this.d;
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

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[1] = ((byte)(0xFF & this.hour));
    arrayOfByte[2] = ((byte)(0xFF & this.minute));
    this.cv.f((byte)-53, arrayOfByte, 10);
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
    case -63:
    case -16:
    case 56:
    case 67:
    case 72:
    case 96:
    case 98:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 10)
      {
        int k = (0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 10)];
        if (k != 0)
        {
          if (k >= 32768)
            k += 0;
          o(k * 30 / 540);
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
              int j = 0xFF & paramArrayOfByte[(paramInt1 + 14)];
              String str = "";
              if ((j > 0) && (j <= 214))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                Locale localLocale = Locale.US;
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = Float.valueOf(j / 2.0F - 40.0F);
                str = String.format(localLocale, "  %.1f", arrayOfObject) + this.mContext.getString(2131099651);
              }
              f(str);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
              {
                int[] arrayOfInt = new int[12];
                for (int i = 0; i < 12; i++)
                {
                  arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]);
                  if (arrayOfInt[i] >= 5)
                    arrayOfInt[i] = 0;
                }
                if (arrayOfInt[10] == 1)
                {
                  ax();
                  this.aY.max = 4;
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
                  continue;
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.p
 * JD-Core Version:    0.6.2
 */