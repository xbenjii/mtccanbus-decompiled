package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;

public class bs extends a
{
  private boolean dA;

  public bs(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 60;
  }

  private int g(byte paramByte)
  {
    if ((paramByte & 0xFF) == 255);
    for (int i = 0; ; i = paramByte & 0xFF)
      return i;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    this.d.wind_FrameShow = false;
    AirCondition localAirCondition1 = this.d;
    localAirCondition1.modeDual = -1;
    label65: label91: label108: label125: int i;
    label142: label159: label176: label230: int j;
    if ((0xF & paramArrayOfByte[4]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label274;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label285;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.modeAuto = 2;
      if ((0x10 & paramArrayOfByte[1]) == 0)
        break label334;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label345;
      this.d.windRear = true;
      if ((0x10 & paramArrayOfByte[4]) == 0)
        break label356;
      this.d.windUp = true;
      if ((0x20 & paramArrayOfByte[4]) == 0)
        break label367;
      this.d.windMid = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label378;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[4]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 1)
        break label389;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 1)
        break label474;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.tempRight = 0;
    }
    while (true)
    {
      return;
      this.d.onOff = false;
      break;
      label274: this.d.modeAc = false;
      break label65;
      label285: if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.modeAuto = 1;
        break label91;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeAuto = 0;
      break label91;
      label334: this.d.windFrontMax = false;
      break label108;
      label345: this.d.windRear = false;
      break label125;
      label356: this.d.windUp = false;
      break label142;
      label367: this.d.windMid = false;
      break label159;
      label378: this.d.windDown = false;
      break label176;
      label389: if (i == 255)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempLeft = 65535;
        break label230;
      }
      if ((i >= 116) && (i <= 144))
      {
        this.d.tempLeft = (-400 + i * 10 / 2);
        break label230;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label230;
      label474: if (j == 255)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.tempRight = 65535;
      }
      else if ((j >= 116) && (j <= 144))
      {
        this.d.tempRight = (-400 + j * 10 / 2);
      }
      else
      {
        AirCondition localAirCondition4 = this.d;
        localAirCondition4.tempRight = -1;
      }
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
    int i = Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.controlsettings.car.type", 1);
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = ((byte)i);
    this.cv.f((byte)45, arrayOfByte, 2);
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
    int i = 0;
    byte[] arrayOfByte4;
    int n;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        arrayOfByte4 = new byte[2 + (0xFF & paramArrayOfByte[(paramInt1 + 2)])];
        arrayOfByte4[0] = ((byte)(0xFF & paramArrayOfByte[(paramInt1 + 1)]));
        arrayOfByte4[1] = ((byte)(0xFF & paramArrayOfByte[(paramInt1 + 2)]));
        n = 0;
      }
      break;
    case 17:
      while (true)
        if (n < paramArrayOfByte[(paramInt1 + 2)])
        {
          arrayOfByte4[(n + 2)] = paramArrayOfByte[(n + (paramInt1 + 3))];
          n++;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 8)
          {
            byte[] arrayOfByte3 = new byte[2];
            arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 7)];
            n(arrayOfByte3);
            int k = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8);
            if (k >= 32768)
              k += 0;
            int m = k * 35 / 540;
            Intent localIntent = new Intent("com.microntek.canbusbackview");
            localIntent.putExtra("canbustype", this.e);
            localIntent.putExtra("lfribackview", m);
            this.mContext.sendBroadcast(localIntent);
            if ((0x20 & paramArrayOfByte[(paramInt1 + 3)]) == 0)
              break label270;
            this.dA = true;
          }
        }
    case 65:
    case -126:
    }
    while (true)
    {
      return;
      label270: this.dA = false;
      continue;
      if ((this.dA) && (paramArrayOfByte[(paramInt1 + 2)] == 12))
      {
        if (this.cv.l() == 0);
        byte[] arrayOfByte2;
        for (this.aY.zero_show = false; ; this.aY.zero_show = true)
        {
          arrayOfByte2 = new byte[12];
          for (int j = 0; j < 12; j++)
            arrayOfByte2[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
        }
        this.aY.max = 4;
        this.aY.back_cnt = 3;
        this.aY.b1 = g(arrayOfByte2[0]);
        this.aY.b2 = g(arrayOfByte2[1]);
        this.aY.b3 = g(arrayOfByte2[3]);
        this.aY.max = 4;
        this.aY.front_cnt = 3;
        this.aY.f1 = arrayOfByte2[4];
        this.aY.f2 = arrayOfByte2[5];
        this.aY.f3 = arrayOfByte2[7];
        if ((0x1 & arrayOfByte2[10]) != 0)
        {
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 8)
          {
            byte[] arrayOfByte1 = new byte[8];
            while (i < 8)
            {
              arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            m(arrayOfByte1);
            this.cv.a(this.d);
            continue;
            this.cv.d(arrayOfByte4);
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
 * Qualified Name:     android.microntek.canbus.c.bs
 * JD-Core Version:    0.6.2
 */