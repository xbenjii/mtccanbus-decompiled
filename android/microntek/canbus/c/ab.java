package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

public class ab extends a
{
  private static long de = 0L;

  public ab(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 17;
    this.d = new AirCondition();
  }

  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.microntek.controlsettings", "com.microntek.controlsettings.canbus17drivingMode"));
    localIntent.addFlags(807600128);
    localIntent.putExtra("cftype", paramInt);
    localIntent.putExtra("buf", paramArrayOfByte);
    try
    {
      this.cv.startActivityAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        Log.e("Canbus17", "controlsettings activity not found! " + localActivityNotFoundException.getMessage());
    }
  }

  private boolean aK()
  {
    long l = SystemClock.uptimeMillis();
    if (l - de > 1200L)
      de = l;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void b(Radar paramRadar)
  {
    if ((this.cv.l() == 0) && (this.aY.view_show));
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
    {
      this.cv.a(this.aY);
      return;
    }
  }

  private int e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt3)
    {
      i = paramInt1 * paramInt2 / paramInt3;
      if ((i != 0) || (paramInt1 == 0));
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  private void h(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[1] = ((byte)(paramInt2 & 0xFF));
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label44: label70: label86: label102: label119: int i;
    label137: label154: label171: label209: label240: int j;
    if (((0x80 & paramArrayOfByte[0]) != 0) && ((0x10 & paramArrayOfByte[1]) != 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label369;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label380;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label398;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label409;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label420;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label431;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label442;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label453;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label464;
      this.d.tempUnit = true;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label475;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label581;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
      label271: if ((0x20 & paramArrayOfByte[4]) == 0)
        break label687;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 2;
      label297: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label736;
      this.d.rearLock = 1;
      label313: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label747;
    }
    label398: label409: label420: label431: label442: label453: label464: label475: label736: label747: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = ((0x30 & paramArrayOfByte[5]) >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[5]);
      return;
      this.d.onOff = false;
      break;
      label369: this.d.modeAc = false;
      break label44;
      label380: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label70;
      this.d.modeDual = 0;
      break label86;
      this.d.windFrontMax = false;
      break label102;
      this.d.windRear = false;
      break label119;
      this.d.windUp = false;
      break label137;
      this.d.windMid = false;
      break label154;
      this.d.windDown = false;
      break label171;
      this.d.tempUnit = false;
      break label209;
      if (i == 31)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label240;
      }
      if ((i >= 1) && (i <= 29))
      {
        if (this.d.tempUnit)
        {
          this.d.tempLeft = (10 * (i + 59));
          break label240;
        }
        this.d.tempLeft = (5 * (i + 31));
        break label240;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label240;
      if (j == 31)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
        break label271;
      }
      if ((j >= 1) && (j <= 29))
      {
        if (this.d.tempUnit)
        {
          this.d.tempRight = (10 * (j + 59));
          break label271;
        }
        this.d.tempRight = (5 * (j + 31));
        break label271;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label271;
      if ((0x20 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.windLoop = 1;
        break label297;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 0;
      break label297;
      this.d.rearLock = 0;
      break label313;
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 5;
    arrayOfByte[1] = 64;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public int[][] aA()
  {
    return new int[][] { { 3841 }, { 3842 }, { 3843 }, { 3844 }, { 3845 }, { 3846 }, { 3847 }, { 3848 }, { 3849 }, { 3850 }, { 3851 }, { 3852 }, { 3853 }, { 3855 }, { 3856 }, { 3857 } };
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
    byte[] arrayOfByte = new byte[7];
    if (!bool)
      this.hour = (128 + this.hour);
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    arrayOfByte[6] = 1;
    this.cv.a((byte)-90, arrayOfByte, 7);
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 10;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 3;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void an()
  {
    a(null, 1);
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
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = 0;
    int i = paramInt3 / 1000;
    arrayOfByte[5] = ((byte)(i / 60 / 60));
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
    int j = Settings.System.getInt(this.cv.getContentResolver(), "PackingRadarEN", 1);
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
    case 38:
    case 39:
    case 41:
    case 48:
    case 64:
    case 80:
    case 96:
    case 97:
    case 98:
    case 99:
    case 100:
    case 101:
    }
    while (true)
    {
      return;
      if (a(paramArrayOfByte[(paramInt1 + 2)], 7))
      {
        byte[] arrayOfByte12 = new byte[2 + this.mLength];
        arrayOfByte12[0] = 33;
        arrayOfByte12[1] = ((byte)this.mLength);
        for (int i13 = 0; i13 < this.mLength; i13++)
          arrayOfByte12[(i13 + 2)] = paramArrayOfByte[(i13 + (paramInt1 + 3))];
        this.cv.d(arrayOfByte12);
        byte[] arrayOfByte13 = new byte[this.mLength];
        while (i < this.mLength)
        {
          arrayOfByte13[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        if (j(arrayOfByte13))
        {
          m(arrayOfByte13);
          this.cv.a(this.d);
          continue;
          if ((j != 0) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
          {
            byte[] arrayOfByte11 = new byte[6];
            int i8 = 0;
            int i9 = 0;
            while (i8 < 6)
            {
              arrayOfByte11[i8] = paramArrayOfByte[(i8 + (paramInt1 + 3))];
              if ((0xFF & arrayOfByte11[i8]) < 166)
                i9 = 1;
              i8++;
            }
            this.aY.mode = 1;
            this.aY.back_cnt = 4;
            this.aY.bmax1 = 4;
            this.aY.bmax2 = 11;
            this.aY.bmax3 = 11;
            this.aY.bmax4 = 4;
            this.aY.b1 = e(0xFF & arrayOfByte11[0], 4, 60);
            this.aY.b2 = e(0xFF & arrayOfByte11[1], 11, 165);
            this.aY.b3 = e(0xFF & arrayOfByte11[2], 11, 165);
            this.aY.b4 = e(0xFF & arrayOfByte11[3], 4, 60);
            int i10 = 0x3 & (0xF0 & arrayOfByte11[4]) >> 4;
            label560: int i11;
            label585: label599: int i12;
            if (i10 == 1)
            {
              this.aY.bc1 = -1;
              i11 = 0x3 & (0xF & arrayOfByte11[4]);
              if (i11 != 1)
                break label691;
              this.aY.bc2 = -1;
              if (i11 != 1)
                break label742;
              this.aY.bc3 = -1;
              i12 = 0x3 & (0xF & arrayOfByte11[5]);
              if (i12 != 1)
                break label793;
              this.aY.bc4 = -1;
            }
            while (true)
            {
              if (i9 == 0)
                break label842;
              b(this.aY);
              break;
              if (i10 == 2)
              {
                this.aY.bc1 = -256;
                break label560;
              }
              if (i10 == 3)
              {
                this.aY.bc1 = -65536;
                break label560;
              }
              this.aY.bc1 = -65536;
              break label560;
              label691: if (i11 == 2)
              {
                this.aY.bc2 = -256;
                break label585;
              }
              if (i11 == 3)
              {
                this.aY.bc2 = -65536;
                break label585;
              }
              this.aY.bc2 = -65536;
              break label585;
              label742: if (i11 == 2)
              {
                this.aY.bc3 = -256;
                break label599;
              }
              if (i11 == 3)
              {
                this.aY.bc3 = -65536;
                break label599;
              }
              this.aY.bc3 = -65536;
              break label599;
              label793: if (i12 == 2)
                this.aY.bc4 = -256;
              else if (i12 == 3)
                this.aY.bc4 = -65536;
              else
                this.aY.bc4 = -65536;
            }
            label842: continue;
            if ((j != 0) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
            {
              byte[] arrayOfByte10 = new byte[6];
              int i3 = 0;
              int i4 = 0;
              while (i3 < 6)
              {
                arrayOfByte10[i3] = paramArrayOfByte[(i3 + (paramInt1 + 3))];
                if ((0xFF & arrayOfByte10[i3]) < 166)
                  i4 = 1;
                i3++;
              }
              this.aY.mode = 1;
              this.aY.front_cnt = 4;
              this.aY.fmax1 = 4;
              this.aY.fmax2 = 8;
              this.aY.fmax3 = 8;
              this.aY.fmax4 = 4;
              this.aY.f1 = e(0xFF & arrayOfByte10[0], 4, 60);
              this.aY.f2 = e(0xFF & arrayOfByte10[1], 8, 120);
              this.aY.f3 = e(0xFF & arrayOfByte10[2], 8, 120);
              this.aY.f4 = e(0xFF & arrayOfByte10[3], 4, 60);
              int i5 = 0x3 & (0xF0 & arrayOfByte10[4]) >> 4;
              label1083: int i6;
              label1108: label1122: int i7;
              if (i5 == 1)
              {
                this.aY.fc1 = -1;
                i6 = 0x3 & (0xF & arrayOfByte10[4]);
                if (i6 != 1)
                  break label1214;
                this.aY.fc2 = -1;
                if (i6 != 1)
                  break label1265;
                this.aY.fc3 = -1;
                i7 = 0x3 & (0xF & arrayOfByte10[5]);
                if (i7 != 1)
                  break label1316;
                this.aY.fc4 = -1;
              }
              while (true)
              {
                if (i4 == 0)
                  break label1365;
                b(this.aY);
                break;
                if (i5 == 2)
                {
                  this.aY.fc1 = -256;
                  break label1083;
                }
                if (i5 == 3)
                {
                  this.aY.fc1 = -65536;
                  break label1083;
                }
                this.aY.fc1 = -65536;
                break label1083;
                label1214: if (i6 == 2)
                {
                  this.aY.fc2 = -256;
                  break label1108;
                }
                if (i6 == 3)
                {
                  this.aY.fc2 = -65536;
                  break label1108;
                }
                this.aY.fc2 = -65536;
                break label1108;
                label1265: if (i6 == 2)
                {
                  this.aY.fc3 = -256;
                  break label1122;
                }
                if (i6 == 3)
                {
                  this.aY.fc3 = -65536;
                  break label1122;
                }
                this.aY.fc3 = -65536;
                break label1122;
                label1316: if (i7 == 2)
                  this.aY.fc4 = -256;
                else if (i7 == 3)
                  this.aY.fc4 = -65536;
                else
                  this.aY.fc4 = -65536;
              }
              label1365: continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte9 = new byte[2];
                arrayOfByte9[0] = paramArrayOfByte[(paramInt1 + 3)];
                if ((byte)(0x1 & arrayOfByte9[0]) == 1)
                {
                  n(arrayOfByte9);
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 1) || (paramArrayOfByte[(paramInt1 + 2)] == 2))
                  {
                    byte[] arrayOfByte8 = new byte[3];
                    arrayOfByte8[0] = 37;
                    arrayOfByte8[1] = 1;
                    arrayOfByte8[2] = paramArrayOfByte[(paramInt1 + 3)];
                    this.cv.d(arrayOfByte8);
                    if ((0x2 & arrayOfByte8[2]) != 0)
                    {
                      this.aY.view_show = false;
                      this.aY.mode = 1;
                      b(this.aY);
                    }
                    else
                    {
                      this.aY.view_show = true;
                      b(this.aY);
                      continue;
                      if ((paramArrayOfByte[(paramInt1 + 2)] == 7) && (goto 172) && (paramArrayOfByte[(paramInt1 + 2)] == 3))
                      {
                        int i1 = paramArrayOfByte[(paramInt1 + 3)];
                        int i2 = (0xFF & paramArrayOfByte[(paramInt1 + 5)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 4)];
                        if (i2 >= 32768)
                          i2 += 0;
                        StringBuilder localStringBuilder1;
                        Locale localLocale1;
                        Object[] arrayOfObject1;
                        if ((byte)(i1 & 0x1) == 1)
                        {
                          localStringBuilder1 = new StringBuilder();
                          localLocale1 = Locale.US;
                          arrayOfObject1 = new Object[1];
                          arrayOfObject1[0] = Float.valueOf(0.1F * i2);
                        }
                        StringBuilder localStringBuilder2;
                        Locale localLocale2;
                        Object[] arrayOfObject2;
                        for (String str = String.format(localLocale1, " %.0f", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %.1f", arrayOfObject2) + this.mContext.getString(2131099651))
                        {
                          Intent localIntent2 = new Intent("com.canbus.temperature");
                          localIntent2.putExtra("temperature", str);
                          this.mContext.sendBroadcast(localIntent2);
                          break;
                          localStringBuilder2 = new StringBuilder();
                          localLocale2 = Locale.US;
                          arrayOfObject2 = new Object[1];
                          arrayOfObject2[0] = Float.valueOf(0.1F * i2);
                        }
                        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                        {
                          int m = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                          if (m >= 32768)
                            m += 0;
                          int n = m * 30 / 19918;
                          Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                          localIntent1.putExtra("canbustype", this.e);
                          localIntent1.putExtra("lfribackview", n);
                          this.mContext.sendBroadcast(localIntent1);
                          continue;
                          if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && (goto 172) && (paramArrayOfByte[(paramInt1 + 2)] == 5))
                          {
                            byte[] arrayOfByte7 = new byte[7];
                            arrayOfByte7[0] = 64;
                            arrayOfByte7[1] = 5;
                            while (i < 5)
                            {
                              arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.d(arrayOfByte7);
                            if ((arrayOfByte7[2] == -96) && ((0x10 & arrayOfByte7[3]) != 0) && (aK()))
                            {
                              a(1, arrayOfByte7);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                              {
                                byte[] arrayOfByte6 = new byte[8];
                                arrayOfByte6[0] = 80;
                                arrayOfByte6[1] = 6;
                                while (i < 6)
                                {
                                  arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.d(arrayOfByte6);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                {
                                  byte[] arrayOfByte5 = new byte[10];
                                  arrayOfByte5[0] = 96;
                                  arrayOfByte5[1] = 8;
                                  while (i < 8)
                                  {
                                    arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.d(arrayOfByte5);
                                  continue;
                                  byte[] arrayOfByte4 = new byte[2 + paramArrayOfByte[(paramInt1 + 2)]];
                                  arrayOfByte4[0] = 97;
                                  arrayOfByte4[1] = paramArrayOfByte[(paramInt1 + 2)];
                                  while (i < paramArrayOfByte[(paramInt1 + 2)])
                                  {
                                    arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.d(arrayOfByte4);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 4)
                                  {
                                    byte[] arrayOfByte3 = new byte[6];
                                    arrayOfByte3[0] = 98;
                                    arrayOfByte3[1] = 4;
                                    while (i < 4)
                                    {
                                      arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.d(arrayOfByte3);
                                    continue;
                                    int k = 0x7F & paramArrayOfByte[(paramInt1 + 2)];
                                    byte[] arrayOfByte2 = new byte[k + 2];
                                    arrayOfByte2[0] = 99;
                                    arrayOfByte2[1] = paramArrayOfByte[(paramInt1 + 2)];
                                    while (i < k)
                                    {
                                      arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.d(arrayOfByte2);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 5)
                                    {
                                      byte[] arrayOfByte1 = new byte[7];
                                      arrayOfByte1[0] = 100;
                                      arrayOfByte1[1] = 5;
                                      while (i < 5)
                                      {
                                        arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                        i++;
                                      }
                                      this.cv.d(arrayOfByte1);
                                      continue;
                                      if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                                        this.cv.d(Arrays.copyOfRange(paramArrayOfByte, paramInt1 + 1, paramInt2));
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
            }
          }
        }
      }
    }
  }

  public void g(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0);
    switch (paramInt1)
    {
    default:
      return;
    case 3841:
      boolean bool = this.d.onOff;
      int n = 0;
      if (bool);
      while (true)
      {
        h(178, n);
        break;
        n = 1;
      }
    case 3857:
      int k = this.d.modeDual;
      int m = 0;
      if (k == 1);
      while (true)
      {
        h(179, m);
        break;
        m = 1;
      }
    case 3846:
    }
    int i = this.d.modeAuto;
    int j = 0;
    if (i == 1);
    while (true)
    {
      h(187, j);
      break;
      j = 1;
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
 * Qualified Name:     android.microntek.canbus.c.ab
 * JD-Core Version:    0.6.2
 */