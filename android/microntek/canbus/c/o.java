package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class o extends a
{
  byte[] di = new byte[37];

  public o(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private byte[] a(byte paramByte, String paramString)
  {
    String str = paramString + "                          ";
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    int i;
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte2 = str.getBytes("unicode");
      arrayOfByte3 = new byte[37];
      arrayOfByte3[0] = paramByte;
      if (arrayOfByte2 != null)
        for (i = 1; ; i++)
        {
          if (i >= -1 + arrayOfByte3.length)
            break label93;
          if (i != 1)
            break;
        }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      arrayOfByte1 = this.di;
    }
    while (true)
    {
      return arrayOfByte1;
      arrayOfByte3[i] = arrayOfByte2[i];
      break;
      label93: arrayOfByte1 = arrayOfByte3;
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label184: if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label315;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label326;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      label60: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label344;
      this.d.modeDual = 1;
      label76: if ((0x10 & paramArrayOfByte[2]) == 0)
        break label355;
      this.d.windFrontMax = true;
      label93: if ((0x20 & paramArrayOfByte[2]) == 0)
        break label366;
      this.d.windRear = true;
      label110: switch (0xF & paramArrayOfByte[4])
      {
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
            break label505;
        }
        break;
      case 3:
      case 5:
      case 6:
      case 12:
      }
    }
    label278: label315: label326: label344: label355: label366: label505: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      this.d.modeDual = 0;
      break label76;
      this.d.windFrontMax = false;
      break label93;
      this.d.windRear = false;
      break label110;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label184;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label184;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label184;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label184;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label278;
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
    byte b = 1;
    String str;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("FM").append(paramByte1 + 1).append(" ");
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[b];
      arrayOfObject[0] = Float.valueOf(paramInt / 100.0F);
      str = String.format(localLocale, " %.1f", arrayOfObject) + "MHz";
    }
    while (true)
    {
      this.cv.f((byte)-107, a(b, str), 37);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        str = "AM" + (paramByte1 - 2) + " " + paramInt + "KHz";
        b = 4;
      }
      else
      {
        str = "";
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    String str = "USB " + paramInt2;
    this.cv.f((byte)-107, a((byte)13, str), 37);
  }

  public void a(String paramString, int paramInt)
  {
    this.cv.f((byte)-107, a((byte)10, "  BLUETOOTH "), 37);
  }

  public int[][] aA()
  {
    return new int[][] { { 3841, 23205, 15618, 30, 0 }, { 3841, 23205, 15618, 30, 1 }, { 3842, 23205, 15618, 2, 0 }, { 3842, 23205, 15618, 2, 1 }, { 3844, 23205, 15618, 6, 0 }, { 3844, 23205, 15618, 6, 1 }, { 3845, 23205, 15618, 7, 0 }, { 3845, 23205, 15618, 7, 1 }, { 3846, 23205, 15618, 4, 0 }, { 3846, 23205, 15618, 4, 1 }, { 3847, 23205, 15618, 13, 0 }, { 3847, 23205, 15618, 13, 1 }, { 3848, 23205, 15618, 14, 0 }, { 3848, 23205, 15618, 14, 1 }, { 3849, 23205, 15618, 15, 0 }, { 3849, 23205, 15618, 15, 1 }, { 3850, 23205, 15618, 16, 0 }, { 3850, 23205, 15618, 16, 1 }, { 3853, 23205, 15618, 1, 0 }, { 3853, 23205, 15618, 1, 1 }, { 3855, 23205, 15618, 12, 0 }, { 3855, 23205, 15618, 12, 1 }, { 3856, 23205, 15618, 11, 0 }, { 3856, 23205, 15618, 11, 1 }, { 3857, 23205, 15618, 3, 0 }, { 3857, 23205, 15618, 3, 1 }, { 3858, 23205, 15618, 29, 0 }, { 3858, 23205, 15618, 29, 1 }, { 3860, 23205, 15618, 26, 0 }, { 3860, 23205, 15618, 26, 1 }, { 3861, 23205, 15618, 28, 0 }, { 3861, 23205, 15618, 28, 1 }, { 3863, 23205, 15618, 27, 0 }, { 3863, 23205, 15618, 27, 1 }, { 3872, 23205, 15618, 5, 0 }, { 3872, 23205, 15618, 5, 1 } };
  }

  public void ah()
  {
    ai();
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
      arrayOfByte[6] = ((byte)(0xFF & -2000 + localTime.year));
      arrayOfByte[7] = ((byte)(0xFF & 1 + localTime.month));
      arrayOfByte[8] = ((byte)(0xFF & localTime.monthDay));
      this.cv.f((byte)-53, arrayOfByte, 10);
      return;
      i = 0;
    }
  }

  public void ak()
  {
    this.cv.f((byte)-107, a((byte)12, "    AUX      "), 37);
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
    this.cv.f((byte)-107, a((byte)10, "    A2DP      "), 37);
  }

  public void ap()
  {
    ak();
  }

  public void aq()
  {
    this.cv.f((byte)-107, a((byte)0, ""), 37);
  }

  public void ar()
  {
    ak();
  }

  public void az()
  {
    this.cv.f((byte)106, new byte[] { 5, 1, 49 }, 3);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "CDTOTAL " + paramInt1;
    this.cv.f((byte)-107, a((byte)6, str), 37);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "USB " + paramInt2;
    this.cv.f((byte)-107, a((byte)13, str), 37);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "USB " + paramInt2;
    this.cv.f((byte)-107, a((byte)13, str), 37);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 18:
    case 49:
    case 65:
    case 50:
    case -63:
    case -16:
    case 67:
    case 96:
    case 98:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 10)
      {
        byte[] arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 5)];
        n(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
        {
          byte[] arrayOfByte1 = f(paramArrayOfByte, paramInt1 + 3, paramInt2);
          if (j(arrayOfByte1))
          {
            m(arrayOfByte1);
            this.cv.a(this.d);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
            {
              ax();
              int[] arrayOfInt = new int[4];
              int j = 0;
              if (j < 4)
              {
                arrayOfInt[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                if (arrayOfInt[j] >= 7)
                  arrayOfInt[j] = 0;
                while (true)
                {
                  j++;
                  break;
                  if (((j == 0) || (j == 3)) && (arrayOfInt[j] == 1))
                    arrayOfInt[j] = 3;
                  else if (((j == 0) || (j == 3)) && (arrayOfInt[j] == 2))
                    arrayOfInt[j] = 6;
                }
              }
              this.aY.max = 6;
              this.aY.back_cnt = 4;
              this.aY.b1 = arrayOfInt[0];
              this.aY.b2 = arrayOfInt[1];
              this.aY.b3 = arrayOfInt[2];
              this.aY.b4 = arrayOfInt[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 14)
              {
                int i = (0xFF & paramArrayOfByte[(paramInt1 + 7)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 8)];
                if (i != 65535)
                {
                  p(i);
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
 * Qualified Name:     android.microntek.canbus.c.o
 * JD-Core Version:    0.6.2
 */