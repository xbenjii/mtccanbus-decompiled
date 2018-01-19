package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.serializable.AirCondition;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class br extends android.microntek.canbus.b.a
{
  private byte[] dB = new byte[12];
  private byte[] dj = new byte[14];

  public br(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 59;
  }

  private int D(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 6));
    for (int i = paramInt + 1; ; i = 0)
      return i;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label33: label59: label93: label110: int i;
    label145: label166: int j;
    label217: int k;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label332;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label343;
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.modeAuto = 1;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeDual = -1;
      if ((0x10 & paramArrayOfByte[2]) == 0)
        break label361;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[2]) == 0)
        break label372;
      this.d.windRear = true;
      if ((0xF & paramArrayOfByte[4]) != 14)
        break label383;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      AirCondition localAirCondition3 = this.d;
      if ((0xF & paramArrayOfByte[5]) <= 7)
        break label636;
      i = 7;
      localAirCondition3.windLevel = i;
      this.d.windLevelMax = 7;
      j = 0xFF & paramArrayOfByte[6];
      if (j != 254)
        break label647;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.tempLeft = 0;
      k = 0xFF & paramArrayOfByte[7];
      if (k != 254)
        break label759;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempRight = 0;
      label252: if ((0x10 & paramArrayOfByte[1]) == 0)
        break label871;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.windLoop = 1;
      label278: AirCondition localAirCondition7 = this.d;
      localAirCondition7.rearLock = -1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label891;
    }
    label332: label343: label361: label372: label759: label891: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label33;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label59;
      this.d.windFrontMax = false;
      break label93;
      this.d.windRear = false;
      break label110;
      label383: if ((0xF & paramArrayOfByte[4]) == 13)
      {
        this.d.windUp = true;
        this.d.windMid = true;
        this.d.windDown = false;
        break label145;
      }
      if ((0xF & paramArrayOfByte[4]) == 12)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = true;
        break label145;
      }
      if ((0xF & paramArrayOfByte[4]) == 11)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = false;
        break label145;
      }
      if ((0xF & paramArrayOfByte[4]) == 6)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = false;
        break label145;
      }
      if ((0xF & paramArrayOfByte[4]) == 5)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = true;
        break label145;
      }
      if ((0xF & paramArrayOfByte[4]) == 3)
      {
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = true;
        break label145;
      }
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label145;
      label636: i = 0xF & paramArrayOfByte[5];
      break label166;
      if (j == 255)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.tempLeft = 65535;
        break label217;
      }
      if ((j >= 0) && (j <= 99))
      {
        if ((j >= 40) && (j <= 52))
        {
          this.d.tempLeft = ((int)(10.0F * (0.5F * j)));
          break label217;
        }
        this.d.tempLeft = (10 * (j / 2));
        break label217;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempLeft = -1;
      break label217;
      if (k == 255)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempRight = 65535;
        break label252;
      }
      if ((k >= 0) && (k <= 99))
      {
        if ((k >= 40) && (k <= 52))
        {
          this.d.tempRight = ((int)(10.0F * (0.5F * k)));
          break label252;
        }
        this.d.tempRight = (10 * (k / 2));
        break label252;
      }
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.tempRight = -1;
      break label252;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 0;
      break label278;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 1;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 9;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 7;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void ah()
  {
    byte[] arrayOfByte1 = new byte[2];
    if (android.microntek.canbus.d.a.aV() > 19)
      arrayOfByte1[0] = ((byte)this.cv.y);
    while (true)
    {
      byte[] arrayOfByte2 = new byte[3];
      arrayOfByte2[0] = -128;
      this.cv.f((byte)-95, arrayOfByte2, 3);
      this.cv.d(1);
      this.cv.e(1);
      this.cv.t();
      return;
      arrayOfByte1[0] = 16;
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
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[i] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
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
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 3;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 8;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 8;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 7;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 6;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 4;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void aq()
  {
    byte[] arrayOfByte = new byte[3];
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 5;
    this.cv.f((byte)-95, arrayOfByte, 3);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = 6;
    this.cv.f((byte)-95, arrayOfByte, 3);
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
      case 65:
      case 18:
      case 54:
      case 17:
      case 49:
      case 52:
      case 53:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 12)
      {
        int[] arrayOfInt = new int[12];
        for (int i1 = 0; i1 < 12; i1++)
          arrayOfInt[i1] = D(0xFF & paramArrayOfByte[(i1 + (paramInt1 + 3))]);
        this.aY.max = 7;
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
        if (paramArrayOfByte[(paramInt1 + 2)] == 10)
        {
          new byte[1][0] = paramArrayOfByte[(paramInt1 + 5)];
          byte[] arrayOfByte4 = new byte[12];
          arrayOfByte4[0] = 18;
          arrayOfByte4[1] = 10;
          while (i < 10)
          {
            arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.d(arrayOfByte4);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 92) && (paramArrayOfByte[(paramInt1 + 2)] == 10))
          {
            int m = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8);
            if (m >= 32768)
              m += 0;
            int n = m * 30 / 540;
            Intent localIntent2 = new Intent("com.microntek.canbusbackview");
            localIntent2.putExtra("canbustype", this.e);
            localIntent2.putExtra("lfribackview", n);
            this.mContext.sendBroadcast(localIntent2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 12)
            {
              byte[] arrayOfByte3 = new byte[12];
              for (int j = 0; j < 12; j++)
              {
                arrayOfByte3[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
                if (arrayOfByte3[j] != this.dB[j]);
                this.dB[j] = arrayOfByte3[j];
              }
              m(arrayOfByte3);
              int k = 0xFF & arrayOfByte3[11];
              StringBuilder localStringBuilder = new StringBuilder();
              Locale localLocale = Locale.US;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Float.valueOf(0.5F * k - 40.0F);
              String str = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651);
              Intent localIntent1 = new Intent("com.canbus.temperature");
              localIntent1.putExtra("temperature", str);
              this.mContext.sendBroadcast(localIntent1);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 6)
              {
                byte[] arrayOfByte2 = new byte[8];
                arrayOfByte2[0] = 52;
                arrayOfByte2[1] = 6;
                while (i < 6)
                {
                  arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte2);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                {
                  byte[] arrayOfByte1 = new byte[8];
                  arrayOfByte1[0] = 53;
                  arrayOfByte1[1] = 6;
                  while (i < 6)
                  {
                    arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.br
 * JD-Core Version:    0.6.2
 */