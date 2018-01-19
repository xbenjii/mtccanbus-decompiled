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

public class d extends a
{
  private int cU = 0;

  public d(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 4;
    this.d = new AirCondition();
  }

  private void g(String paramString)
  {
    Intent localIntent = new Intent("com.canbus.temperature");
    localIntent.putExtra("temperature", paramString);
    this.mContext.sendBroadcast(localIntent);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label38: label63: label79: label104: label121: int i;
    label138: label155: label226: int j;
    label257: AirCondition localAirCondition7;
    if (paramArrayOfByte[2] != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[3]) == 0)
        break label330;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[3]) == 0)
        break label341;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 1;
      if ((0x2 & paramArrayOfByte[3]) == 0)
        break label359;
      this.d.modeDual = 1;
      this.d.windFrontMax = false;
      if ((0x20 & paramArrayOfByte[3]) == 0)
        break label370;
      this.d.windRear = true;
      if ((0x40 & paramArrayOfByte[3]) == 0)
        break label381;
      this.d.windUp = true;
      if ((0x8 & paramArrayOfByte[3]) == 0)
        break label392;
      this.d.windMid = true;
      if ((0x10 & paramArrayOfByte[3]) == 0)
        break label403;
      this.d.windDown = true;
      this.d.windLevel = paramArrayOfByte[2];
      if (this.d.windLevel == 8)
        this.d.windLevel = 7;
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[0];
      if (i != 0)
        break label414;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[1];
      if (j != 0)
        break label491;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempRight = 0;
      if ((0x80 & paramArrayOfByte[3]) == 0)
        break label568;
      localAirCondition7 = this.d;
    }
    label330: label341: label359: label370: label381: AirCondition localAirCondition4;
    for (localAirCondition7.windLoop = 1; ; localAirCondition4.windLoop = 0)
    {
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.rearLock = -1;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label38;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label63;
      this.d.modeDual = 0;
      break label79;
      this.d.windRear = false;
      break label104;
      this.d.windUp = false;
      break label121;
      label392: this.d.windMid = false;
      break label138;
      label403: this.d.windDown = false;
      break label155;
      label414: if (i == 30)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempLeft = 65535;
        break label226;
      }
      if ((i > 0) && (i < 30))
      {
        this.d.tempLeft = (5 * (i + 34));
        break label226;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label226;
      label491: if (j == 30)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempRight = 65535;
        break label257;
      }
      if ((j > 0) && (j < 30))
      {
        this.d.tempRight = (5 * (j + 34));
        break label257;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label257;
      label568: localAirCondition4 = this.d;
    }
  }

  private void o(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label38: label63: label79: label104: label121: boolean bool;
    if (paramArrayOfByte[2] != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[3]) == 0)
        break label384;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[3]) == 0)
        break label395;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.modeAuto = 1;
      if ((0x2 & paramArrayOfByte[3]) == 0)
        break label413;
      this.d.modeDual = 1;
      this.d.windFrontMax = false;
      if ((0x20 & paramArrayOfByte[3]) == 0)
        break label424;
      this.d.windRear = true;
      if ((0x40 & paramArrayOfByte[3]) == 0)
        break label435;
      this.d.windUp = true;
      if ((0x8 & paramArrayOfByte[3]) == 0)
        break label446;
      this.d.windMid = true;
      label138: if ((0x10 & paramArrayOfByte[3]) == 0)
        break label457;
      this.d.windDown = true;
      label155: this.d.windLevel = paramArrayOfByte[2];
      if (this.d.windLevel == 8)
        this.d.windLevel = 7;
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[0];
      AirCondition localAirCondition2 = this.d;
      if (i < 62)
        break label468;
      bool = true;
      label220: localAirCondition2.tempUnit = bool;
      this.d.tempLeft = t(i);
      int j = 0xFF & paramArrayOfByte[1];
      this.d.tempRight = t(j);
      if ((0x80 & paramArrayOfByte[3]) == 0)
        break label474;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.windLoop = 1;
      label289: AirCondition localAirCondition4 = this.d;
      localAirCondition4.rearLock = -1;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.acMax = -1;
      if (this.cU != 1)
        break label494;
      this.d.wind_FrameShow = false;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.modeDual = -1;
      this.d.ariStateShow = false;
      this.d.modeAc = true;
    }
    while (true)
    {
      return;
      this.d.onOff = false;
      break;
      label384: this.d.modeAc = false;
      break label38;
      label395: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label63;
      label413: this.d.modeDual = 0;
      break label79;
      label424: this.d.windRear = false;
      break label104;
      label435: this.d.windUp = false;
      break label121;
      label446: this.d.windMid = false;
      break label138;
      label457: this.d.windDown = false;
      break label155;
      label468: bool = false;
      break label220;
      label474: AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label289;
      label494: this.d.wind_FrameShow = true;
      this.d.ariStateShow = true;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 2;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
      arrayOfByte[1] = ((byte)(paramByte1 + 0));
    while (true)
    {
      arrayOfByte[2] = ((byte)(0xFF & paramInt / 100));
      arrayOfByte[3] = ((byte)(0xFF & paramInt % 100));
      this.cv.c((byte)9, arrayOfByte, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[0] = 9;
        arrayOfByte[1] = 3;
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(i / 60 / 60));
    arrayOfByte[4] = ((byte)(i / 60 % 60));
    arrayOfByte[5] = ((byte)(i % 60));
    this.cv.c((byte)9, arrayOfByte, 6);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 11;
    this.cv.c((byte)9, arrayOfByte, 2);
  }

  public void ah()
  {
    this.cv.d(1);
    ai();
  }

  public void ai()
  {
    if (this.cv.getResources().getConfiguration().locale.getLanguage().equals("zh"))
    {
      byte[] arrayOfByte1 = { 1, 0 };
      this.cv.c((byte)3, arrayOfByte1, 2);
    }
    while (true)
    {
      return;
      byte[] arrayOfByte2 = { 1, 1 };
      this.cv.c((byte)3, arrayOfByte2, 2);
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
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = ((byte)(0xFF & this.minute));
    arrayOfByte[i] = ((byte)(0xFF & this.hour));
    if (bool);
    while (true)
    {
      arrayOfByte[2] = ((byte)i);
      this.cv.c((byte)6, arrayOfByte, 3);
      return;
      i = 0;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 11;
    this.cv.c((byte)9, arrayOfByte, 2);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[1];
    this.cv.c((byte)9, arrayOfByte, 1);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 12;
    arrayOfByte[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(i / 60 / 60));
    arrayOfByte[4] = ((byte)(i / 60 % 60));
    arrayOfByte[5] = ((byte)(i % 60));
    this.cv.c((byte)9, arrayOfByte, 6);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.cv.l() == 0);
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      case 2:
      case 6:
      default:
        return;
      case 1:
      case 3:
      case 4:
      case 7:
      case 8:
      case 5:
      }
    int i7;
    if (paramArrayOfByte[(paramInt1 + 2)] == 1)
    {
      i7 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
      if (i7 == 255)
        break label829;
      if ((i7 & 0x80) != 0)
        i7 = 0 - (i7 & 0x7F);
    }
    label829: for (String str2 = " " + i7 + this.mContext.getString(2131099651); ; str2 = "")
    {
      g(str2);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] != 2)
        break;
      int i5 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
      int i6 = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
      String str1;
      if ((i5 != 255) || (i6 != 255))
        if (i5 != 255)
        {
          if ((i5 & 0x80) != 0)
            i5 = 0 - (i5 & 0x7F);
          str1 = " " + i5 + this.mContext.getString(2131099651);
        }
      while (true)
      {
        g(str1);
        break;
        if (i6 != 255)
        {
          str1 = " " + i6 + this.mContext.getString(2131099652);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte3 = new byte[4];
            while (i < 4)
            {
              arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            m(arrayOfByte3);
            this.cv.a(this.d);
            break;
          }
          if ((0xF & paramArrayOfByte[(paramInt1 + 2)]) < 6)
            break;
          byte[] arrayOfByte2 = new byte[6];
          for (int i4 = 0; i4 < 6; i4++)
            arrayOfByte2[i4] = paramArrayOfByte[(i4 + (paramInt1 + 3))];
          this.cU = Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.control4settings", 0);
          if (this.cU != 0)
            break;
          o(arrayOfByte2);
          this.cv.a(this.d);
          break;
          if (paramArrayOfByte[(paramInt1 + 2)] != 2)
            break;
          int i2 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          int i3 = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
          this.aY.max = 3;
          this.aY.front_cnt = 4;
          this.aY.f1 = ((byte)(0x3 & i2 >> 6));
          this.aY.f2 = ((byte)(0x3 & i2 >> 4));
          this.aY.f3 = ((byte)(0x3 & i2 >> 2));
          this.aY.f4 = ((byte)(i2 & 0x3));
          this.aY.back_cnt = 4;
          this.aY.b1 = ((byte)(0x3 & i3 >> 6));
          this.aY.b2 = ((byte)(0x3 & i3 >> 4));
          this.aY.b3 = ((byte)(0x3 & i3 >> 2));
          this.aY.b4 = ((byte)(i3 & 0x3));
          this.cv.a(this.aY);
          break;
          if (paramArrayOfByte[(paramInt1 + 2)] != 2)
            break;
          int n = 2 * paramArrayOfByte[(paramInt1 + 3)];
          this.cv.a(-1, n);
          int i1 = 2 * paramArrayOfByte[(paramInt1 + 4)];
          this.cv.a(-1, i1);
          break;
          if (paramArrayOfByte[(paramInt1 + 2)] != 3)
            break;
          int j = paramArrayOfByte[(paramInt1 + 3)];
          this.cv.a(-1, -1, j);
          int k = paramArrayOfByte[(paramInt1 + 4)];
          this.cv.a(-1, k, -1);
          int m = paramArrayOfByte[(paramInt1 + 5)];
          this.cv.a(m, -1, -1);
          break;
          if (paramArrayOfByte[(paramInt1 + 2)] != 1)
            break;
          byte[] arrayOfByte1 = new byte[1];
          arrayOfByte1[0] = paramArrayOfByte[(0 + (paramInt1 + 3))];
          if (this.cU != 0)
            break;
          n(arrayOfByte1);
          break;
        }
        str1 = "";
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
    label29: boolean bool4;
    label40: boolean bool5;
    label52: boolean bool6;
    if ((0x1 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label109;
      bool3 = bool1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label115;
      bool4 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label121;
      bool5 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label127;
      bool6 = bool1;
      label64: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label133;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label109: bool3 = false;
      break label29;
      label115: bool4 = false;
      break label40;
      label121: bool5 = false;
      break label52;
      label127: bool6 = false;
      break label64;
      label133: bool1 = false;
    }
  }

  int t(int paramInt)
  {
    int i = -1;
    if (!this.d.tempUnit)
      if (paramInt == 0)
        i = 0;
    while (true)
    {
      return i;
      if (paramInt == 30)
      {
        i = 65535;
      }
      else if ((paramInt > 0) && (paramInt < 30))
      {
        i = 5 * (paramInt + 34);
      }
      else
      {
        continue;
        if ((paramInt >= 62) && (paramInt <= 90))
          i = paramInt * 10;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.d
 * JD-Core Version:    0.6.2
 */