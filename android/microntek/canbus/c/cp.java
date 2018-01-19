package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class cp extends a
{
  public cp(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label79: label96: AirCondition localAirCondition3;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label264;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label275;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0x80 & paramArrayOfByte[3]) == 0)
        break label293;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[3]) == 0)
        break label304;
      this.d.windRear = true;
      switch (paramArrayOfByte[1] >> 4)
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        label160: this.d.windLevel = (0x7 & paramArrayOfByte[1]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[2];
        this.d.tempLeft = t(i);
        this.d.tempRight = this.d.tempLeft;
        if ((0x20 & paramArrayOfByte[0]) != 0)
          localAirCondition3 = this.d;
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    label264: label275: label293: label304: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      this.d.windFrontMax = false;
      break label79;
      this.d.windRear = false;
      break label96;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label160;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label160;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label160;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label160;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label160;
      localAirCondition2 = this.d;
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
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    if (bool);
    for (int i = this.hour; ; i = 0x80 | this.hour)
    {
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & this.minute));
      this.cv.a((byte)-90, arrayOfByte, 5);
      return;
    }
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
    int i = 0;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 33:
      case 34:
      case 36:
      case 39:
      case 41:
      case 64:
      case 80:
      case 81:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 4)
      {
        byte[] arrayOfByte6 = new byte[4];
        while (i < 4)
        {
          arrayOfByte6[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        m(arrayOfByte6);
        this.cv.a(this.d);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
        {
          byte[] arrayOfByte5 = new byte[4];
          for (int i5 = 0; i5 < 4; i5++)
            arrayOfByte5[i5] = paramArrayOfByte[(i5 + (paramInt1 + 3))];
          this.aY.max = 7;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfByte5[0];
          this.aY.b2 = arrayOfByte5[1];
          this.aY.b3 = arrayOfByte5[2];
          this.aY.b4 = arrayOfByte5[3];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 2)
          {
            byte[] arrayOfByte4 = new byte[1];
            arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte4);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 1)
            {
              int i4 = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
              if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
                i4 = 0 - i4;
              StringBuilder localStringBuilder = new StringBuilder();
              Locale localLocale = Locale.US;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Integer.valueOf(i4);
              String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
              Intent localIntent2 = new Intent("com.canbus.temperature");
              localIntent2.putExtra("temperature", str);
              this.mContext.sendBroadcast(localIntent2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int m = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
                int n = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
                int i1 = m + (n << 8);
                if ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) >= 128);
                for (int i2 = 0 - i1; ; i2 = m + (128 - n << 8))
                {
                  int i3 = i2 * 30 / 7700;
                  Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                  localIntent1.putExtra("canbustype", this.e);
                  localIntent1.putExtra("lfribackview", i3);
                  this.mContext.sendBroadcast(localIntent1);
                  break;
                }
                if (paramArrayOfByte[(paramInt1 + 2)] == 4)
                {
                  byte[] arrayOfByte3 = new byte[6];
                  arrayOfByte3[0] = 64;
                  arrayOfByte3[1] = 4;
                  while (i < 4)
                  {
                    arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.d(arrayOfByte3);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 14)
                  {
                    byte[] arrayOfByte2 = new byte[16];
                    arrayOfByte2[0] = 80;
                    arrayOfByte2[1] = 14;
                    while (i < 14)
                    {
                      arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.d(arrayOfByte2);
                    continue;
                    int j = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
                    byte[] arrayOfByte1 = new byte[j + 2];
                    arrayOfByte1[0] = 81;
                    arrayOfByte1[1] = ((byte)j);
                    for (int k = 0; k < j; k++)
                      arrayOfByte1[(k + 2)] = paramArrayOfByte[(k + (paramInt1 + 3))];
                    this.cv.d(arrayOfByte1);
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

  int t(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 15)
        i = 65535;
      else if (paramInt <= 10)
        i = 10 * (paramInt + 16);
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cp
 * JD-Core Version:    0.6.2
 */