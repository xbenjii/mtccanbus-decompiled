package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
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

public class cj extends a
{
  private boolean dL = false;
  byte[] di = new byte[31];

  public cj(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 75;
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
      arrayOfByte3 = new byte[31];
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

  private void aQ()
  {
    if (this.cv.l() == 0);
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
    {
      this.cv.a(this.aY);
      return;
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label288;
      this.d.modeAc = true;
      label35: if ((0x10 & paramArrayOfByte[0]) == 0)
        break label299;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      label61: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label317;
      this.d.windFrontMax = true;
      label77: if ((0x2 & paramArrayOfByte[0]) == 0)
        break label328;
      this.d.windRear = true;
      label93: if ((0x40 & paramArrayOfByte[2]) == 0)
        break label339;
      this.d.windUp = true;
      label110: if ((0x10 & paramArrayOfByte[2]) == 0)
        break label350;
      this.d.windMid = true;
      label127: if ((0x20 & paramArrayOfByte[2]) == 0)
        break label361;
      this.d.windDown = true;
      label144: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      this.d.tempLeft = t(0xFF & paramArrayOfByte[3]);
      this.d.tempRight = t(0xFF & paramArrayOfByte[4]);
      if ((0x8 & paramArrayOfByte[0]) != 8)
        break label372;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 2;
      label230: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label421;
    }
    label288: label421: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[5] >> 6);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[5] >> 2);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      label299: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label317: this.d.windFrontMax = false;
      break label77;
      label328: this.d.windRear = false;
      break label93;
      label339: this.d.windUp = false;
      break label110;
      label350: this.d.windMid = false;
      break label127;
      label361: this.d.windDown = false;
      break label144;
      label372: if ((0x4 & paramArrayOfByte[0]) == 4)
      {
        AirCondition localAirCondition3 = this.d;
        localAirCondition3.windLoop = 1;
        break label230;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label230;
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
      this.cv.a((byte)-112, a(b, str), 31);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        str = "AM" + (paramByte1 - 2) + " " + paramInt + "KHz";
        b = 2;
      }
      else
      {
        str = "";
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    String str = "IPOD " + paramInt2;
    this.cv.a((byte)-112, a((byte)4, str), 31);
  }

  public void a(String paramString, int paramInt)
  {
    this.cv.a((byte)-112, a((byte)5, "  BLUETOOTH "), 31);
  }

  public void ah()
  {
    ai();
    this.cv.d(1);
    this.cv.e(1);
    ak();
  }

  public void ai()
  {
    if (this.cv.getResources().getConfiguration().locale.getLanguage().equals("zh"))
      this.cv.a((byte)-105, new byte[] { 83, 9 }, 2);
    while (true)
    {
      return;
      this.cv.a((byte)-105, new byte[] { 83, 1 }, 2);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte1 = new byte[4];
    arrayOfByte1[0] = 80;
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
      this.hour = (0x80 | this.hour);
    }
    arrayOfByte1[1] = ((byte)(0xFF & this.hour));
    arrayOfByte1[2] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-58, arrayOfByte1, 4);
    byte[] arrayOfByte2 = new byte[7];
    arrayOfByte2[0] = 80;
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
      this.hour = (0x80 | this.hour);
    }
    arrayOfByte2[1] = ((byte)(0xFF & this.hour));
    arrayOfByte2[2] = ((byte)(0xFF & this.minute));
    arrayOfByte2[4] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte2[5] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte2[6] = ((byte)(0xFF & localTime.monthDay));
    this.cv.a((byte)-58, arrayOfByte2, 7);
  }

  public void ak()
  {
    this.cv.a((byte)-112, a((byte)7, "    AUX      "), 31);
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
    this.cv.a((byte)-112, a((byte)5, "    A2DP      "), 31);
  }

  public void ap()
  {
    ak();
  }

  public void aq()
  {
    this.cv.a((byte)-112, a((byte)0, ""), 31);
  }

  public void ar()
  {
    ak();
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "CDTOTAL " + paramInt1;
    this.cv.a((byte)-112, a((byte)3, str), 31);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "USB " + paramInt2;
    this.cv.a((byte)-112, a((byte)4, str), 31);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "USB " + paramInt2;
    this.cv.a((byte)-112, a((byte)4, str), 31);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 10:
    case 5:
    case 9:
    case 7:
    case 11:
    case 16:
    case 17:
    case 34:
    case 35:
    case 21:
    case 0:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        byte[] arrayOfByte8 = new byte[1];
        arrayOfByte8[0] = paramArrayOfByte[(paramInt1 + 4)];
        n(arrayOfByte8);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 8)
        {
          byte[] arrayOfByte6 = new byte[7];
          for (int i5 = 0; i5 < 7; i5++)
            arrayOfByte6[i5] = paramArrayOfByte[(i5 + (paramInt1 + 3))];
          m(arrayOfByte6);
          if (j(arrayOfByte6))
            this.cv.a(this.d);
          int i6 = 0xFF & paramArrayOfByte[(7 + (paramInt1 + 3))];
          String str2 = "";
          int i7;
          StringBuilder localStringBuilder3;
          Locale localLocale3;
          Object[] arrayOfObject3;
          if (i6 <= 125)
          {
            i7 = i6 - 40;
            if (!this.d.tempUnit)
              break label401;
            localStringBuilder3 = new StringBuilder();
            localLocale3 = Locale.US;
            arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = Float.valueOf(32.0F + 1.8F * i7);
          }
          byte[] arrayOfByte7;
          label401: StringBuilder localStringBuilder4;
          Locale localLocale4;
          Object[] arrayOfObject4;
          for (str2 = String.format(localLocale3, " %.1f", arrayOfObject3) + this.mContext.getString(2131099652); ; str2 = String.format(localLocale4, " %d", arrayOfObject4) + this.mContext.getString(2131099651))
          {
            Intent localIntent2 = new Intent("com.canbus.temperature");
            localIntent2.putExtra("temperature", str2);
            this.mContext.sendBroadcast(localIntent2);
            arrayOfByte7 = new byte[10];
            arrayOfByte7[0] = 5;
            arrayOfByte7[1] = 8;
            while (i < 8)
            {
              arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            localStringBuilder4 = new StringBuilder();
            localLocale4 = Locale.US;
            arrayOfObject4 = new Object[1];
            arrayOfObject4[0] = Integer.valueOf(i7);
          }
          this.cv.d(arrayOfByte7);
          continue;
          int i4;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
          {
            i4 = ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8) + (0xFF & paramArrayOfByte[(paramInt1 + 4)]);
            if (this.cv.y != 2)
              break label617;
            o(0 - 30 * (-1792 + (i4 - 616)) / 1199);
          }
          byte[] arrayOfByte5;
          while (a(paramArrayOfByte[(paramInt1 + 2)], 12))
          {
            arrayOfByte5 = new byte[2 + this.mLength];
            arrayOfByte5[0] = 7;
            arrayOfByte5[1] = ((byte)this.mLength);
            for (int i2 = 0; i2 < this.mLength; i2++)
              arrayOfByte5[(i2 + 2)] = paramArrayOfByte[(i2 + (paramInt1 + 3))];
            label617: if (i4 >= 32768)
              i4 += 0;
            o(0 - i4 * 30 / 540);
          }
          continue;
          this.cv.d(arrayOfByte5);
          if (this.mLength > 12)
          {
            int i3 = 0x10 & arrayOfByte5[12];
            boolean bool = false;
            if (i3 != 0)
              bool = true;
            this.dL = bool;
            continue;
            if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && (goto 108) && (paramArrayOfByte[(paramInt1 + 2)] >= 10))
            {
              byte[] arrayOfByte4 = new byte[12];
              arrayOfByte4[0] = 16;
              arrayOfByte4[1] = 10;
              while (i < 10)
              {
                arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte4);
              continue;
              if ((paramArrayOfByte[(paramInt1 + 2)] >= 3) && (paramArrayOfByte[(paramInt1 + 2)] <= 67))
              {
                int i1 = 0x7F & paramArrayOfByte[(paramInt1 + 2)];
                byte[] arrayOfByte3 = new byte[i1 + 2];
                arrayOfByte3[0] = 17;
                arrayOfByte3[1] = ((byte)i1);
                while (i < i1)
                {
                  arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte3);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
                {
                  byte[] arrayOfByte2 = new byte[5];
                  for (int n = 0; n < 5; n++)
                    arrayOfByte2[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
                  this.aY.max = 5;
                  this.aY.back_cnt = 4;
                  this.aY.b1 = arrayOfByte2[0];
                  this.aY.b2 = arrayOfByte2[1];
                  this.aY.b3 = arrayOfByte2[2];
                  this.aY.b4 = arrayOfByte2[3];
                  if ((0x80 & arrayOfByte2[4]) != 0)
                  {
                    aQ();
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
                    {
                      byte[] arrayOfByte1 = new byte[5];
                      for (int m = 0; m < 5; m++)
                        arrayOfByte1[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
                      this.aY.max = 5;
                      this.aY.front_cnt = 4;
                      this.aY.f1 = arrayOfByte1[0];
                      this.aY.f2 = arrayOfByte1[1];
                      this.aY.f3 = arrayOfByte1[2];
                      this.aY.f4 = arrayOfByte1[3];
                      if ((0x80 & arrayOfByte1[4]) != 0)
                      {
                        aQ();
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                        {
                          int j = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
                          String str1 = "";
                          int k;
                          StringBuilder localStringBuilder1;
                          Locale localLocale1;
                          Object[] arrayOfObject1;
                          if (j <= 125)
                          {
                            k = j - 40;
                            if (this.dL)
                              break label1249;
                            localStringBuilder1 = new StringBuilder();
                            localLocale1 = Locale.US;
                            arrayOfObject1 = new Object[1];
                            arrayOfObject1[0] = Integer.valueOf(k);
                          }
                          label1249: StringBuilder localStringBuilder2;
                          Locale localLocale2;
                          Object[] arrayOfObject2;
                          for (str1 = String.format(localLocale1, " %d", arrayOfObject1) + this.mContext.getString(2131099651); ; str1 = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099652))
                          {
                            Intent localIntent1 = new Intent("com.canbus.temperature");
                            localIntent1.putExtra("temperature", str1);
                            this.mContext.sendBroadcast(localIntent1);
                            break;
                            localStringBuilder2 = new StringBuilder();
                            localLocale2 = Locale.US;
                            arrayOfObject2 = new Object[1];
                            arrayOfObject2[0] = Integer.valueOf((int)(32.0D + 1.8D * k));
                          }
                          if (paramArrayOfByte[(paramInt1 + 2)] != 8);
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
    int i = 0;
    if (paramInt == 0);
    while (true)
    {
      return i;
      if (paramInt == 127)
      {
        i = 65535;
      }
      else if (paramInt <= 30)
      {
        this.d.tempUnit = false;
        i = paramInt * 10;
      }
      else if (paramInt <= 84)
      {
        this.d.tempUnit = true;
        i = paramInt * 10;
      }
      else
      {
        i = -1;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cj
 * JD-Core Version:    0.6.2
 */