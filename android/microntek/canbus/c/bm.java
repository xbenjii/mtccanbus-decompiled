package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;

public class bm extends a
{
  byte[] cB = new byte[6];

  public bm(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 54;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label101: label118: int i;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label303;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label314;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label361;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label372;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label383;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label394;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      label152: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 8;
      i = 0x7F & paramArrayOfByte[2];
      if (paramArrayOfByte[2] >= 0)
        break label654;
      if (i != 0)
        break label529;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      label210: this.d.tempRight = this.d.tempLeft;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label807;
      if ((0x20 & paramArrayOfByte[4]) == 0)
        break label787;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 2;
      label259: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label827;
      this.d.rearLock = 1;
      label275: if ((0x4 & paramArrayOfByte[4]) == 0)
        break label838;
    }
    label303: label314: label827: label838: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label43;
      if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.modeAuto = 1;
        break label69;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label361: this.d.modeDual = 0;
      break label85;
      label372: this.d.windFrontMax = false;
      break label101;
      label383: this.d.windRear = false;
      break label118;
      if ((0x40 & paramArrayOfByte[1]) != 0)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = false;
        break label152;
      }
      if ((0x20 & paramArrayOfByte[1]) != 0)
      {
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = true;
        break label152;
      }
      if ((0x10 & paramArrayOfByte[1]) != 0)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = true;
        break label152;
      }
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label152;
      if (i == 31)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label210;
      }
      if ((i >= 1) && (i <= 28))
      {
        if (i <= 3)
          i = 3;
        this.d.tempLeft = (10 * (17 + i / 3));
        if (this.d.tempUnit != true)
          break label210;
        this.d.tempLeft = ((int)(320.0D + 1.8D * this.d.tempLeft));
        break label210;
      }
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempLeft = -1;
      break label210;
      if (i == 0)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempLeft = 0;
        break label210;
      }
      if (i == 31)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempLeft = 65535;
        break label210;
      }
      if (i <= 9)
      {
        this.d.tempLeft = (10 * (i + 17));
        if (this.d.tempUnit != true)
          break label210;
        this.d.tempLeft = ((int)(320.0D + 1.8D * this.d.tempLeft));
        break label210;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label210;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      break label259;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label259;
      this.d.rearLock = 0;
      break label275;
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
    int i = Settings.System.getInt(this.cv.getContentResolver(), "canbus54_mInstrument_style", 0);
    CanBusServer localCanBusServer = this.cv;
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = ((byte)i);
    arrayOfByte[2] = 0;
    arrayOfByte[3] = 0;
    localCanBusServer.a((byte)-103, arrayOfByte, 4);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[7];
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      this.hour = (0x80 | this.hour);
    }
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-90, arrayOfByte, 7);
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
    int i = 1;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      case 37:
      case 38:
      case 39:
      case 40:
      default:
      case 33:
      case 34:
      case 35:
      case 36:
      case 41:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = i;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
      {
        byte[] arrayOfByte4 = new byte[5];
        int m = 0;
        int n = 0;
        while (m < 5)
        {
          arrayOfByte4[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
          if (arrayOfByte4[m] != this.cB[m])
            n = i;
          this.cB[m] = arrayOfByte4[m];
          m++;
        }
        AirCondition localAirCondition = this.d;
        label181: int i1;
        if ((0x1 & arrayOfByte4[4]) != 0)
        {
          localAirCondition.tempUnit = i;
          if (n != 0)
          {
            m(arrayOfByte4);
            this.cv.a(this.d);
          }
          i1 = 0x7F & paramArrayOfByte[(paramInt1 + 8)];
          if ((0x80 & paramArrayOfByte[(paramInt1 + 8)]) != 0)
            i1 = 0 - i1;
          if (this.d.tempUnit)
            break label318;
        }
        label318: for (String str = i1 + this.mContext.getString(2131099651); ; str = (int)(32.0D + 1.8D * i1) + this.mContext.getString(2131099652))
        {
          Intent localIntent2 = new Intent("com.canbus.temperature");
          localIntent2.putExtra("temperature", str);
          this.mContext.sendBroadcast(localIntent2);
          break;
          i = 0;
          break label181;
        }
        if (paramArrayOfByte[(paramInt1 + 2)] == i)
        {
          byte[] arrayOfByte3 = new byte[i];
          arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 3)];
          this.aY.max = 9;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfByte3[0];
          this.aY.b2 = arrayOfByte3[0];
          this.aY.b3 = arrayOfByte3[0];
          this.aY.b4 = arrayOfByte3[0];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == i)
          {
            byte[] arrayOfByte2 = new byte[i];
            arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
            this.aY.max = 9;
            this.aY.front_cnt = 4;
            this.aY.f1 = arrayOfByte2[0];
            this.aY.f2 = arrayOfByte2[0];
            this.aY.f3 = arrayOfByte2[0];
            this.aY.f4 = arrayOfByte2[0];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 2)
            {
              byte[] arrayOfByte1 = new byte[i];
              arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 3)];
              n(arrayOfByte1);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                if ((j >= 24576) && (j <= 40959))
                {
                  int k = 35 * (j - 32768) / 8191;
                  Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                  localIntent1.putExtra("canbustype", this.e);
                  localIntent1.putExtra("lfribackview", 0 - k);
                  this.mContext.sendBroadcast(localIntent1);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bm
 * JD-Core Version:    0.6.2
 */