package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;

public class a extends android.microntek.canbus.b.a
{
  public a(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 1;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label77: label93: label109: label127: int i;
    label144: label161: label214: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label353;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label364;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label411;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label422;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label433;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label444;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label455;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label466;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label477;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label555;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
      label245: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label653;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label633;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 2;
      label281: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label673;
      this.d.rearLock = 1;
      label298: if ((0x4 & paramArrayOfByte[4]) == 0)
        break label684;
    }
    label411: label422: label555: label684: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = ((0x30 & paramArrayOfByte[4]) >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[4]);
      return;
      this.d.onOff = false;
      break;
      label353: this.d.modeAc = false;
      break label35;
      label364: if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.modeAuto = 1;
        break label61;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      this.d.modeDual = 0;
      break label77;
      this.d.windFrontMax = false;
      break label93;
      label433: this.d.windRear = false;
      break label109;
      label444: this.d.windUp = false;
      break label127;
      label455: this.d.windMid = false;
      break label144;
      label466: this.d.windDown = false;
      break label161;
      label477: if (i == 31)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label214;
      }
      if ((i >= 1) && (i <= 17))
      {
        this.d.tempLeft = (5 * (i + 35));
        break label214;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label214;
      if (j == 31)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
        break label245;
      }
      if ((j >= 1) && (j <= 17))
      {
        this.d.tempRight = (5 * (j + 35));
        break label245;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label245;
      label633: AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 1;
      break label281;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 0;
      break label281;
      this.d.rearLock = 0;
      break label298;
    }
  }

  private int s(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0 - paramInt;
    int i = Settings.System.getInt(this.cv.getContentResolver(), "canbus1_angle", 450);
    if (paramInt > i * 2)
      Settings.System.putInt(this.cv.getContentResolver(), "canbus1_angle", 12376);
    return i;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte2[0] = ((byte)(paramByte1 + 1));
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if (paramByte1 == 3)
      {
        arrayOfByte2[0] = 17;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
      else if (paramByte1 == 4)
      {
        arrayOfByte2[0] = 18;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte1 = { 6, 18 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[3] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[2] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[1] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[0] = ((byte)(0xFF & paramInt2 >> 8));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 0, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ah()
  {
    Settings.System.putInt(this.cv.getContentResolver(), "com.microntek.controlinfo.door", 0);
    byte[] arrayOfByte = { 65, 1 };
    this.cv.a((byte)-112, arrayOfByte, 2);
    this.cv.d(1);
    this.cv.e(1);
    arrayOfByte[0] = 39;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-112, arrayOfByte, 2);
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte1 = { 7, 48 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 34;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void al()
  {
    byte[] arrayOfByte1 = { 10, 48 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 34;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void am()
  {
    byte[] arrayOfByte1 = { 10, 48 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 34;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void an()
  {
    byte[] arrayOfByte = { 11, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ap()
  {
    byte[] arrayOfByte1 = { 0, 34 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 34;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 2, 34 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 34;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 9, 16 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 0;
    arrayOfByte2[1] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[3] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte2[4] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 22:
    case 33:
    case 34:
    case 35:
    case 36:
    case 65:
    case 38:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        Intent localIntent2 = new Intent("com.microntek.canbus.speed");
        int i2 = ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 3)]) / 16;
        localIntent2.putExtra("speed", "" + i2);
        this.mContext.sendBroadcast(localIntent2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
        {
          byte[] arrayOfByte7 = new byte[5];
          while (i < 5)
          {
            arrayOfByte7[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          if ((0x10 & arrayOfByte7[1]) != 0)
          {
            m(arrayOfByte7);
            this.cv.a(this.d);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
            {
              byte[] arrayOfByte6 = new byte[4];
              for (int i1 = 0; i1 < 4; i1++)
                arrayOfByte6[i1] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
              ax();
              this.aY.max = 10;
              this.aY.back_cnt = 4;
              this.aY.b1 = arrayOfByte6[0];
              this.aY.b2 = arrayOfByte6[1];
              this.aY.b3 = arrayOfByte6[2];
              this.aY.b4 = arrayOfByte6[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
              {
                byte[] arrayOfByte5 = new byte[4];
                for (int n = 0; n < 4; n++)
                  arrayOfByte5[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
                ax();
                this.aY.max = 10;
                this.aY.front_cnt = 4;
                this.aY.f1 = arrayOfByte5[0];
                this.aY.f2 = arrayOfByte5[1];
                this.aY.f3 = arrayOfByte5[2];
                this.aY.f4 = arrayOfByte5[3];
                this.cv.a(this.aY);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                {
                  byte[] arrayOfByte3 = new byte[2];
                  for (int m = 0; m < 2; m++)
                    arrayOfByte3[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
                  if (Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.controlinfo.door", 0) != 1)
                  {
                    n(arrayOfByte3);
                    CanBusServer localCanBusServer = this.cv;
                    byte[] arrayOfByte4 = new byte[4];
                    arrayOfByte4[0] = 36;
                    arrayOfByte4[1] = 2;
                    arrayOfByte4[2] = paramArrayOfByte[(paramInt1 + 3)];
                    arrayOfByte4[3] = paramArrayOfByte[(paramInt1 + 4)];
                    localCanBusServer.d(arrayOfByte4);
                    continue;
                    byte[] arrayOfByte1 = new byte[20];
                    while (i < 20)
                    {
                      arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 1))];
                      i++;
                    }
                    this.cv.d(arrayOfByte1);
                    if (paramArrayOfByte[(paramInt1 + 3)] == 1)
                    {
                      byte[] arrayOfByte2 = new byte[2];
                      arrayOfByte2[1] = paramArrayOfByte[(paramInt1 + 4)];
                      arrayOfByte2[1] = ((byte)(0x1F & arrayOfByte2[1]));
                      n(arrayOfByte2);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                      {
                        int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                        if (j >= 32768)
                          j += 0;
                        int k = j * 30 / s(j);
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
      }
    }
  }

  public void l(int paramInt)
  {
  }

  void n(byte[] paramArrayOfByte)
  {
    int i = 1;
    if (this.cv.y == i)
    {
      Door localDoor2 = this.aB;
      if ((0x2 & paramArrayOfByte[i]) != 0)
      {
        int j = i;
        if ((0x1 & paramArrayOfByte[i]) == 0)
          break label138;
        int m = i;
        label41: if ((0x4 & paramArrayOfByte[i]) == 0)
          break label144;
        int i1 = i;
        label52: if ((0x8 & paramArrayOfByte[i]) == 0)
          break label150;
        int i3 = i;
        label64: if ((0x10 & paramArrayOfByte[i]) == 0)
          break label156;
        int i5 = i;
        label76: if ((0x20 & paramArrayOfByte[i]) == 0)
          break label162;
        label85: if ((localDoor2.a(j, m, i1, i3, i5, i)) && (Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.controlinfo.door", 0) == 0))
          this.cv.a(this.aB);
      }
    }
    label138: label144: label150: label156: label162: label183: label316: label319: 
    while (true)
    {
      return;
      int k = 0;
      break;
      int n = 0;
      break label41;
      int i2 = 0;
      break label52;
      int i4 = 0;
      break label64;
      int i6 = 0;
      break label76;
      boolean bool1 = false;
      break label85;
      Door localDoor1 = this.aB;
      boolean bool2;
      boolean bool3;
      label194: boolean bool4;
      label205: boolean bool5;
      label217: boolean bool6;
      if ((0x1 & paramArrayOfByte[bool1]) != 0)
      {
        bool2 = bool1;
        if ((0x2 & paramArrayOfByte[bool1]) == 0)
          break label292;
        bool3 = bool1;
        if ((0x4 & paramArrayOfByte[bool1]) == 0)
          break label298;
        bool4 = bool1;
        if ((0x8 & paramArrayOfByte[bool1]) == 0)
          break label304;
        bool5 = bool1;
        if ((0x10 & paramArrayOfByte[bool1]) == 0)
          break label310;
        bool6 = bool1;
        label229: if ((0x20 & paramArrayOfByte[bool1]) == 0)
          break label316;
      }
      while (true)
      {
        if ((!localDoor1.a(bool2, bool3, bool4, bool5, bool6, bool1)) || (Settings.System.getInt(this.cv.getContentResolver(), "com.microntek.controlinfo.door", 0) != 0))
          break label319;
        this.cv.a(this.aB);
        break;
        bool2 = false;
        break label183;
        bool3 = false;
        break label194;
        bool4 = false;
        break label205;
        bool5 = false;
        break label217;
        bool6 = false;
        break label229;
        bool1 = false;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.a
 * JD-Core Version:    0.6.2
 */