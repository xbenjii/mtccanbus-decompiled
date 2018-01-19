package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class dl extends a
{
  public dl(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label44: label70: label87: boolean bool1;
    label164: label214: boolean bool2;
    label255: AirCondition localAirCondition5;
    if (((0x80 & paramArrayOfByte[0]) != 0) || ((0x7 & paramArrayOfByte[0]) > 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label333;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label344;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.modeAuto = 1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label362;
      this.d.windRear = true;
      switch (0x7F & paramArrayOfByte[1])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        this.d.windLevel = (0x7 & paramArrayOfByte[0]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[2];
        AirCondition localAirCondition2 = this.d;
        if ((0x80 & paramArrayOfByte[1]) != 0)
        {
          bool1 = true;
          localAirCondition2.tempLeft = a(bool1, i);
          int j = 0xFF & paramArrayOfByte[3];
          AirCondition localAirCondition3 = this.d;
          if ((0x80 & paramArrayOfByte[1]) == 0)
            break label568;
          bool2 = true;
          localAirCondition3.tempRight = a(bool2, j);
          if ((0x20 & paramArrayOfByte[0]) == 0)
            break label574;
          localAirCondition5 = this.d;
        }
        break;
      case 2:
      case 7:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      }
    }
    label333: label344: label362: AirCondition localAirCondition4;
    for (localAirCondition5.windLoop = 1; ; localAirCondition4.windLoop = 0)
    {
      this.d.seatHotLeft = ((0x30 & paramArrayOfByte[4]) >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[4]);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label44;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label70;
      this.d.windRear = false;
      break label87;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label164;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label164;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label164;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label164;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label164;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label164;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label164;
      bool1 = false;
      break label214;
      label568: bool2 = false;
      break label255;
      label574: localAirCondition4 = this.d;
    }
  }

  int a(boolean paramBoolean, int paramInt)
  {
    int i = -1;
    if (paramInt == 255);
    while (true)
    {
      return i;
      if (paramBoolean)
      {
        if (paramInt == 128)
          i = 0;
        else if (paramInt == 157)
          i = 65535;
        else if ((paramInt > 128) && (paramInt < 157))
          i = 180 + 10 * (paramInt - 128) / 2;
      }
      else
        i = paramInt * 10;
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
    this.cv.d(1);
    this.cv.e(1);
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

  public void ap()
  {
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    Locale localLocale;
    Object[] arrayOfObject;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 40:
    case 48:
    case 3:
      do
        while (true)
        {
          return;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
          {
            byte[] arrayOfByte2 = new byte[1];
            arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
            {
              int m = (0xFF & paramArrayOfByte[(paramInt1 + 4)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8);
              if (m >= 32768)
                m += 0;
              int n = m * 30 / 5500;
              Intent localIntent2 = new Intent("com.microntek.canbusbackview");
              localIntent2.putExtra("canbustype", this.e);
              localIntent2.putExtra("lfribackview", n);
              this.mContext.sendBroadcast(localIntent2);
            }
          }
        }
      while (paramArrayOfByte[(paramInt1 + 2)] < 6);
      byte[] arrayOfByte1 = new byte[6];
      int j = 0;
      if (j < 6)
      {
        if (j == 5);
        while (true)
        {
          j++;
          break;
          arrayOfByte1[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
        }
      }
      if (j(arrayOfByte1))
      {
        m(arrayOfByte1);
        this.cv.a(this.d);
      }
      int k = 0x7F & paramArrayOfByte[(paramInt1 + 8)];
      if ((0xFF & paramArrayOfByte[(paramInt1 + 8)]) != 255)
      {
        if ((0x80 & paramArrayOfByte[(paramInt1 + 8)]) != 0)
          k = 0 - k;
        localStringBuilder = new StringBuilder();
        localLocale = Locale.US;
        arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(k);
      }
      break;
    case 34:
    case 7:
    case 9:
    case 13:
    }
    for (String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651); ; str = "")
    {
      Intent localIntent1 = new Intent("com.canbus.temperature");
      localIntent1.putExtra("temperature", str);
      this.mContext.sendBroadcast(localIntent1);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] < 2)
        break;
      int[] arrayOfInt = new int[2];
      int i = 0;
      if (i < 2)
      {
        arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]);
        if ((arrayOfInt[i] >= 1) && (arrayOfInt[i] <= 3))
          arrayOfInt[i] = (0 - (-4 + arrayOfInt[i]));
        while (true)
        {
          i++;
          break;
          arrayOfInt[i] = 0;
        }
      }
      if (this.cv.l() == 0);
      for (this.aY.zero_show = false; ; this.aY.zero_show = true)
      {
        this.aY.max = 3;
        this.aY.back_cnt = 2;
        this.aY.b1 = arrayOfInt[0];
        this.aY.b2 = arrayOfInt[1];
        this.cv.a(this.aY);
        break;
      }
      e(paramArrayOfByte, paramInt1, paramInt2);
      break;
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
 * Qualified Name:     android.microntek.canbus.c.dl
 * JD-Core Version:    0.6.2
 */