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

public class bq extends a
{
  private boolean dA;
  private byte[] dB = new byte[11];
  private byte[] dC = new byte[16];
  private byte[] dD = new byte[13];
  private byte[] dj = new byte[14];
  private int dz = 0;

  public bq(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 58;
  }

  private int C(int paramInt)
  {
    int i;
    if (paramInt == 1)
      i = -1;
    while (true)
    {
      return i;
      if (paramInt == 2)
        i = -256;
      else
        i = -65536;
    }
  }

  private int d(byte paramByte)
  {
    if ((paramByte & 0xFF) >= 166);
    for (int i = 0; ; i = 1 + (-1 + (paramByte & 0xFF)) / 15)
      return i;
  }

  private int e(byte paramByte)
  {
    int i = 8;
    int j;
    if ((paramByte & 0xFF) >= 166)
    {
      j = 0;
      if (j < i)
        break label39;
    }
    while (true)
    {
      return i;
      j = 1 + (-1 + (paramByte & 0xFF)) / 15;
      break;
      label39: i = j;
    }
  }

  private int f(byte paramByte)
  {
    int i = 4;
    int j;
    if ((paramByte & 0xFF) >= 166)
    {
      j = 0;
      if (j < i)
        break label38;
    }
    while (true)
    {
      return i;
      j = 1 + (-1 + (paramByte & 0xFF)) / 15;
      break;
      label38: i = j;
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    AirCondition localAirCondition1 = this.d;
    localAirCondition1.modeDual = -1;
    AirCondition localAirCondition2 = this.d;
    localAirCondition2.acMax = -1;
    AirCondition localAirCondition3 = this.d;
    localAirCondition3.rearLock = -1;
    this.d.wind_FrameShow = false;
    this.d.windRearShow = false;
    label109: int i;
    label135: label154: label184: label221: int j;
    label256: int k;
    if (((0x80 & paramArrayOfByte[0]) != 0) && ((0x40 & paramArrayOfByte[0]) != 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label330;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label341;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.modeAuto = 1;
      i = paramArrayOfByte[4];
      if (i != 2)
        break label361;
      this.d.windFrontMax = true;
      if (i != 3)
        break label372;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      this.d.windLevel = (0x7 & paramArrayOfByte[5]);
      this.d.windLevelMax = 7;
      if (this.dz != 0)
        break label602;
      this.d.tempUnit = false;
      j = 0xFF & paramArrayOfByte[6];
      if (j != 254)
        break label613;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      k = 0xFF & paramArrayOfByte[7];
      if (k != 254)
        break label723;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
    }
    while (true)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[2]);
      this.d.seatHotRight = ((0xC & paramArrayOfByte[2]) >> 2);
      return;
      this.d.onOff = false;
      break;
      label330: this.d.modeAc = false;
      break label109;
      label341: AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 0;
      break label135;
      label361: this.d.windFrontMax = false;
      break label154;
      label372: if (i == 5)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = true;
        break label184;
      }
      if (i == 6)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = false;
        break label184;
      }
      if (i == 11)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = false;
        break label184;
      }
      if (i == 12)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = true;
        break label184;
      }
      if (i == 13)
      {
        this.d.windUp = true;
        this.d.windMid = true;
        this.d.windDown = false;
        break label184;
      }
      if (i == 14)
      {
        this.d.windUp = true;
        this.d.windMid = true;
        this.d.windDown = true;
        break label184;
      }
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label184;
      label602: this.d.tempUnit = true;
      break label221;
      label613: if (j == 255)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label256;
      }
      if (j <= 199)
      {
        if (!this.d.tempUnit)
        {
          this.d.tempLeft = (j * 10 / 2);
          break label256;
        }
        this.d.tempLeft = (320 + 9 * (j * 10 / 2) / 5);
        break label256;
      }
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.tempLeft = -1;
      break label256;
      label723: if (k == 255)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
      }
      else if (k <= 199)
      {
        if (!this.d.tempUnit)
          this.d.tempRight = (k * 10 / 2);
        else
          this.d.tempRight = (320 + 9 * (k * 10 / 2) / 5);
      }
      else
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempRight = -1;
      }
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    aM();
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
      if (paramInt > 9999)
      {
        this.dj[2] = ((byte)(48 + paramInt / 10000));
        this.dj[3] = ((byte)(48 + paramInt / 1000 % 10));
        this.dj[4] = ((byte)(48 + paramInt / 100 % 10));
        this.dj[5] = 46;
        this.dj[6] = ((byte)(48 + paramInt / 10 % 10));
        this.dj[7] = ((byte)(48 + paramInt % 10));
        this.dj[8] = 77;
        this.dj[9] = 72;
        this.dj[10] = 90;
        this.dD[1] = 70;
        this.dD[2] = 77;
        this.dD[3] = ((byte)(paramByte1 + 49));
      }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-110, this.dD, 13);
        this.cv.f((byte)-111, this.dj, 14);
        return;
        this.dj[3] = ((byte)(48 + paramInt / 1000));
        this.dj[4] = ((byte)(48 + paramInt / 100 % 10));
        this.dj[5] = 46;
        this.dj[6] = ((byte)(48 + paramInt / 10 % 10));
        this.dj[7] = ((byte)(48 + paramInt % 10));
      }
    if (paramInt > 999)
    {
      this.dj[2] = ((byte)(48 + paramInt / 1000));
      this.dj[3] = ((byte)(48 + paramInt / 100 % 10));
      this.dj[4] = ((byte)(48 + paramInt / 10 % 10));
      this.dj[5] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      this.dj[6] = 75;
      this.dj[7] = 72;
      this.dj[8] = 90;
      this.dD[1] = 65;
      this.dD[2] = 77;
      this.dD[3] = ((byte)(-3 + (paramByte1 + 49)));
      break;
      this.dj[3] = ((byte)(48 + paramInt / 100));
      this.dj[4] = ((byte)(48 + paramInt / 10 % 10));
      this.dj[5] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    aM();
    int i = paramInt3 / 1000;
    this.dj[2] = ((byte)(48 + paramInt2 / 100));
    this.dj[3] = ((byte)(48 + paramInt2 / 10 % 10));
    this.dj[4] = ((byte)(48 + paramInt2 % 100 % 10));
    this.dj[6] = ((byte)(48 + i / 60 / 60 / 10));
    this.dj[7] = ((byte)(48 + i / 60 / 60 % 10));
    this.dj[8] = 58;
    this.dj[9] = ((byte)(48 + i / 60 % 60 / 10));
    this.dj[10] = ((byte)(48 + i / 60 % 60 % 10));
    this.dj[11] = 58;
    this.dj[12] = ((byte)(48 + i % 60 / 10));
    this.dj[13] = ((byte)(48 + i % 60 % 10));
    this.dD[1] = 73;
    this.dD[2] = 80;
    this.dD[3] = 79;
    this.dD[4] = 68;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void a(String paramString, int paramInt)
  {
    aM();
    this.dD[1] = 66;
    this.dD[2] = 108;
    this.dD[3] = 117;
    this.dD[4] = 101;
    this.dD[5] = 84;
    this.dD[6] = 111;
    this.dD[7] = 111;
    this.dD[8] = 116;
    this.dD[9] = 104;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  void aM()
  {
    int j;
    for (int i = 0; ; i++)
    {
      j = 0;
      if (i >= 14)
        break;
      this.dj[i] = 32;
    }
    while (j < 13)
    {
      this.dD[j] = 32;
      j++;
    }
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.endsWith("zh"))
    {
      byte[] arrayOfByte1 = { 1, 2 };
      this.cv.f((byte)-102, arrayOfByte1, 2);
    }
    while (true)
    {
      return;
      if (str.endsWith("de"))
      {
        byte[] arrayOfByte2 = { 1, 3 };
        this.cv.f((byte)-102, arrayOfByte2, 2);
      }
      else if (str.endsWith("it"))
      {
        byte[] arrayOfByte3 = { 1, 4 };
        this.cv.f((byte)-102, arrayOfByte3, 2);
      }
      else if (str.endsWith("fr"))
      {
        byte[] arrayOfByte4 = { 1, 5 };
        this.cv.f((byte)-102, arrayOfByte4, 2);
      }
      else if (str.endsWith("sv"))
      {
        byte[] arrayOfByte5 = { 1, 6 };
        this.cv.f((byte)-102, arrayOfByte5, 2);
      }
      else if (str.endsWith("es"))
      {
        byte[] arrayOfByte6 = { 1, 7 };
        this.cv.f((byte)-102, arrayOfByte6, 2);
      }
      else if (str.endsWith("pt"))
      {
        byte[] arrayOfByte7 = { 1, 9 };
        this.cv.f((byte)-102, arrayOfByte7, 2);
      }
      else
      {
        byte[] arrayOfByte8 = { 1, 1 };
        this.cv.f((byte)-102, arrayOfByte8, 2);
      }
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
    arrayOfByte[0] = -128;
    arrayOfByte[i] = ((byte)(0xFF & this.hour));
    arrayOfByte[2] = ((byte)(0xFF & this.minute));
    if (bool);
    while (true)
    {
      arrayOfByte[5] = ((byte)i);
      arrayOfByte[6] = ((byte)(0xFF & -2000 + localTime.year));
      arrayOfByte[7] = ((byte)(0xFF & 1 + localTime.month));
      arrayOfByte[8] = ((byte)(0xFF & localTime.monthDay));
      arrayOfByte[9] = 2;
      this.cv.f((byte)-53, arrayOfByte, 10);
      return;
      i = 0;
    }
  }

  public void ak()
  {
    aM();
    this.dD[1] = 65;
    this.dD[2] = 86;
    this.dD[3] = 73;
    this.dD[4] = 78;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void al()
  {
    aM();
    this.dD[1] = 84;
    this.dD[2] = 86;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void am()
  {
    aM();
    this.dD[1] = 84;
    this.dD[2] = 86;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void an()
  {
    aM();
    this.dD[1] = 65;
    this.dD[2] = 50;
    this.dD[3] = 68;
    this.dD[4] = 80;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void ao()
  {
    aM();
    this.dD[1] = 83;
    this.dD[2] = 68;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void ap()
  {
    aM();
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    aM();
    this.dj[2] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    this.dj[3] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    this.dj[4] = 58;
    this.dj[5] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    this.dj[6] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    this.dj[7] = 58;
    this.dj[8] = ((byte)(48 + paramInt2 % 60 / 10));
    this.dj[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.dD[1] = 68;
    this.dD[2] = 86;
    this.dD[3] = 68;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    aM();
    int i = paramInt3 / 1000;
    this.dj[2] = ((byte)(48 + paramInt2 / 100));
    this.dj[3] = ((byte)(48 + paramInt2 / 10 % 10));
    this.dj[4] = ((byte)(48 + paramInt2 % 100 % 10));
    this.dj[6] = ((byte)(48 + i / 60 / 60 / 10));
    this.dj[7] = ((byte)(48 + i / 60 / 60 % 10));
    this.dj[8] = 58;
    this.dj[9] = ((byte)(48 + i / 60 % 60 / 10));
    this.dj[10] = ((byte)(48 + i / 60 % 60 % 10));
    this.dj[11] = 58;
    this.dj[12] = ((byte)(48 + i % 60 / 10));
    this.dj[13] = ((byte)(48 + i % 60 % 10));
    this.dD[1] = 83;
    this.dD[2] = 68;
    this.cv.f((byte)-110, this.dD, 13);
    this.cv.f((byte)-111, this.dj, 14);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    byte[] arrayOfByte5;
    int i3;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        arrayOfByte5 = new byte[2 + (0xFF & paramArrayOfByte[(paramInt1 + 2)])];
        arrayOfByte5[0] = ((byte)(0xFF & paramArrayOfByte[(paramInt1 + 1)]));
        arrayOfByte5[1] = ((byte)(0xFF & paramArrayOfByte[(paramInt1 + 2)]));
        i3 = 0;
      }
      break;
    case 18:
      while (true)
        if (i3 < paramArrayOfByte[(paramInt1 + 2)])
        {
          arrayOfByte5[(i3 + 2)] = paramArrayOfByte[(i3 + (paramInt1 + 3))];
          i3++;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 10)
          {
            byte[] arrayOfByte3 = new byte[2];
            arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 5)];
            n(arrayOfByte3);
            byte[] arrayOfByte4 = new byte[12];
            arrayOfByte4[0] = 18;
            arrayOfByte4[1] = 10;
            while (i < 10)
            {
              arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            this.cv.d(arrayOfByte4);
          }
        }
    case 65:
    case 49:
    case 17:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 16)
      {
        if (this.cv.l() == 0);
        byte[] arrayOfByte2;
        int i2;
        for (this.aY.zero_show = false; ; this.aY.zero_show = true)
        {
          arrayOfByte2 = new byte[16];
          int i1 = 0;
          i2 = 0;
          while (i1 < 16)
          {
            arrayOfByte2[i1] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
            if (arrayOfByte2[i1] != this.dC[i1])
              i2 = 1;
            this.dC[i1] = arrayOfByte2[i1];
            i1++;
          }
        }
        if ((i2 != 0) && (this.dA))
        {
          this.aY.mode = 1;
          this.aY.front_cnt = 4;
          this.aY.fmax1 = 4;
          this.aY.fmax2 = 8;
          this.aY.fmax3 = 8;
          this.aY.fmax4 = 4;
          this.aY.f1 = f(arrayOfByte2[4]);
          this.aY.f2 = e(arrayOfByte2[5]);
          this.aY.f3 = e(arrayOfByte2[6]);
          this.aY.f4 = f(arrayOfByte2[7]);
          this.aY.fc1 = C(0x3 & arrayOfByte2[12]);
          this.aY.fc2 = C(0x3 & arrayOfByte2[13]);
          this.aY.fc3 = C(0x3 & arrayOfByte2[14]);
          this.aY.fc4 = C(0x3 & arrayOfByte2[15]);
          this.aY.back_cnt = 4;
          this.aY.bmax1 = 4;
          this.aY.bmax2 = 11;
          this.aY.bmax3 = 11;
          this.aY.bmax4 = 4;
          this.aY.b1 = f(arrayOfByte2[0]);
          this.aY.b2 = d(arrayOfByte2[1]);
          this.aY.b3 = d(arrayOfByte2[2]);
          this.aY.b4 = f(arrayOfByte2[3]);
          this.aY.bc1 = C(0x3 & arrayOfByte2[8]);
          this.aY.bc2 = C(0x3 & arrayOfByte2[9]);
          this.aY.bc3 = C(0x3 & arrayOfByte2[10]);
          this.aY.bc4 = C(0x3 & arrayOfByte2[11]);
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 12)
          {
            this.dz = Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.controlsettings.unit", 0);
            byte[] arrayOfByte1 = new byte[11];
            int m = 0;
            int n = 0;
            while (m < 11)
            {
              arrayOfByte1[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
              if (arrayOfByte1[m] != this.dB[m])
                n = 1;
              this.dB[m] = arrayOfByte1[m];
              m++;
            }
            if (n != 0)
            {
              m(arrayOfByte1);
              this.cv.a(this.d);
            }
            float f = (float)(0.5D * (0xFF & paramArrayOfByte[(11 + (paramInt1 + 3))])) - 40.0F;
            String str = "";
            StringBuilder localStringBuilder1;
            Locale localLocale1;
            Object[] arrayOfObject1;
            if ((f >= -40.0F) && (f <= 85.0F))
            {
              if (this.dz != 1)
                break label997;
              localStringBuilder1 = new StringBuilder();
              localLocale1 = Locale.US;
              arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = Float.valueOf(32.0F + f * 9.0F / 5.0F);
            }
            label997: StringBuilder localStringBuilder2;
            Locale localLocale2;
            Object[] arrayOfObject2;
            for (str = String.format(localLocale1, " %.0f", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %.1f", arrayOfObject2) + this.mContext.getString(2131099651))
            {
              Intent localIntent2 = new Intent("com.canbus.temperature");
              localIntent2.putExtra("temperature", str);
              this.mContext.sendBroadcast(localIntent2);
              break;
              localStringBuilder2 = new StringBuilder();
              localLocale2 = Locale.US;
              arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = Float.valueOf(f);
            }
            if (paramArrayOfByte[(paramInt1 + 2)] == 10)
            {
              if ((0x20 & paramArrayOfByte[(paramInt1 + 3)]) != 0);
              for (this.dA = true; ; this.dA = false)
              {
                int j = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8);
                if (j >= 32768)
                  j += 0;
                int k = j * 30 / 450;
                Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                localIntent1.putExtra("canbustype", this.e);
                localIntent1.putExtra("lfribackview", k);
                this.mContext.sendBroadcast(localIntent1);
                break;
              }
              this.cv.d(arrayOfByte5);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bq
 * JD-Core Version:    0.6.2
 */