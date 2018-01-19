package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;

public class ck extends a
{
  byte[] cB = new byte[9];
  private boolean dn = false;
  private Handler mHandler;

  public ck(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 76;
    this.d = new AirCondition();
  }

  private int h(String paramString)
  {
    return Settings.System.getInt(this.cv.getContentResolver(), paramString, 0);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label103: label121: boolean bool;
    label138: label155: label194: int i;
    label232: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label334;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label345;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label363;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label374;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label385;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label396;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label407;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label418;
      bool = true;
      localAirCondition2.tempUnit = bool;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label424;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label506;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.tempRight = 0;
      label263: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label587;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 1;
      label289: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label607;
    }
    label334: label345: label607: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label43;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label363: this.d.modeDual = 0;
      break label85;
      label374: this.d.windFrontMax = false;
      break label103;
      this.d.windUp = false;
      break label121;
      this.d.windMid = false;
      break label138;
      this.d.windDown = false;
      break label155;
      bool = false;
      break label194;
      if (i == 255)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempLeft = 65535;
        break label232;
      }
      if ((i < 1) || (i > 254))
        break label232;
      if (this.d.tempUnit)
      {
        this.d.tempLeft = (i * 10);
        break label232;
      }
      this.d.tempLeft = (i * 5);
      break label232;
      label506: if (j == 31)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempRight = 65535;
        break label263;
      }
      if ((j < 1) || (j > 254))
        break label263;
      if (this.d.tempUnit)
      {
        this.d.tempRight = (j * 10);
        break label263;
      }
      this.d.tempRight = (j * 5);
      break label263;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label289;
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 6;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[5] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    this.mHandler = new cl(this);
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 65;
    arrayOfByte[1] = ((byte)h("mScreen1"));
    this.cv.a((byte)-58, arrayOfByte, 2);
    arrayOfByte[0] = 66;
    arrayOfByte[1] = ((byte)h("mScreen2"));
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[2];
    if (!bool)
      this.hour = (0x80 | this.hour);
    arrayOfByte[0] = ((byte)(0xFF & this.hour));
    arrayOfByte[1] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-119, arrayOfByte, 2);
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendEmptyMessageDelayed(0, 20000L);
    }
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
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 12;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
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
    arrayOfByte[0] = 19;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[5] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
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
      case 36:
      case 34:
      case 35:
      case 33:
      case 51:
      case 41:
      case -48:
      case 50:
      case -45:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte9 = new byte[1];
        arrayOfByte9[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte9);
        if ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 4)]) == 1)
        {
          this.dn = true;
        }
        else
        {
          this.dn = false;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte8 = new byte[4];
            for (int i1 = 0; i1 < 4; i1++)
              arrayOfByte8[i1] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte8[0];
            this.aY.b2 = arrayOfByte8[1];
            this.aY.b3 = arrayOfByte8[2];
            this.aY.b4 = arrayOfByte8[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte7 = new byte[4];
              for (int n = 0; n < 4; n++)
                arrayOfByte7[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte7[0];
              this.aY.f2 = arrayOfByte7[1];
              this.aY.f3 = arrayOfByte7[2];
              this.aY.f4 = arrayOfByte7[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 6)
              {
                byte[] arrayOfByte6 = new byte[6];
                while (i < 6)
                {
                  arrayOfByte6[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                if ((0x10 & arrayOfByte6[1]) != 0)
                {
                  m(arrayOfByte6);
                  this.cv.a(this.d);
                }
              }
              else if (paramArrayOfByte[(paramInt1 + 2)] == 9)
              {
                byte[] arrayOfByte5 = new byte[9];
                int m = 0;
                if (m < 9)
                {
                  arrayOfByte5[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
                  if (m >= 6);
                  while (true)
                  {
                    m++;
                    break;
                    if (arrayOfByte5[m] != this.cB[m])
                      i = 1;
                    this.cB[m] = arrayOfByte5[m];
                  }
                }
                if ((i != 0) && ((0x10 & arrayOfByte5[1]) != 0))
                {
                  m(arrayOfByte5);
                  this.cv.a(this.d);
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 15) || (paramArrayOfByte[(paramInt1 + 2)] == 18))
                  {
                    byte[] arrayOfByte4 = new byte[1 + paramArrayOfByte[(paramInt1 + 2)]];
                    while (i < 1 + paramArrayOfByte[(paramInt1 + 2)])
                    {
                      arrayOfByte4[i] = paramArrayOfByte[(i + (paramInt1 + 2))];
                      i++;
                    }
                    this.cv.d(arrayOfByte4);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                    {
                      int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                      if (j >= 32768)
                        j += 0;
                      int k = j * 30 / 4500;
                      Intent localIntent = new Intent("com.microntek.canbusbackview");
                      localIntent.putExtra("canbustype", this.e);
                      localIntent.putExtra("lfribackview", k);
                      this.mContext.sendBroadcast(localIntent);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                      {
                        byte[] arrayOfByte3 = new byte[4];
                        arrayOfByte3[0] = -48;
                        arrayOfByte3[1] = 2;
                        while (i < 2)
                        {
                          arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte3);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
                        {
                          byte[] arrayOfByte2 = new byte[6];
                          arrayOfByte2[0] = 50;
                          arrayOfByte2[1] = 4;
                          while (i < 4)
                          {
                            arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.d(arrayOfByte2);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
                          {
                            byte[] arrayOfByte1 = new byte[6];
                            arrayOfByte1[0] = -45;
                            arrayOfByte1[1] = 4;
                            while (i < 4)
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
          }
        }
      }
    }
  }

  public void l(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    if (paramInt == 0);
    for (int i = -128; ; i = (byte)paramInt)
    {
      arrayOfByte[0] = i;
      this.cv.a((byte)-60, arrayOfByte, 1);
      return;
    }
  }

  void n(byte[] paramArrayOfByte)
  {
    int i = 1;
    if (this.cv.y == i)
    {
      Door localDoor2 = this.aB;
      if ((0x80 & paramArrayOfByte[0]) != 0)
      {
        int j = i;
        if ((0x40 & paramArrayOfByte[0]) == 0)
          break label125;
        int m = i;
        label44: if ((0x20 & paramArrayOfByte[0]) == 0)
          break label131;
        int i1 = i;
        label56: if ((0x10 & paramArrayOfByte[0]) == 0)
          break label137;
        int i3 = i;
        label68: if ((0x8 & paramArrayOfByte[0]) == 0)
          break label143;
        int i5 = i;
        label80: if ((0x4 & paramArrayOfByte[0]) == 0)
          break label149;
        label88: if (localDoor2.a(j, m, i1, i3, i5, i))
          this.cv.a(this.aB);
      }
    }
    label131: label137: label143: label149: label278: label284: label290: label293: 
    while (true)
    {
      return;
      int k = 0;
      break;
      label125: int n = 0;
      break label44;
      int i2 = 0;
      break label56;
      int i4 = 0;
      break label68;
      int i6 = 0;
      break label80;
      boolean bool1 = false;
      break label88;
      Door localDoor1 = this.aB;
      boolean bool2;
      label171: boolean bool3;
      label184: boolean bool4;
      label196: boolean bool5;
      label208: boolean bool6;
      if ((0x40 & paramArrayOfByte[0]) != 0)
      {
        bool2 = bool1;
        if ((0x80 & paramArrayOfByte[0]) == 0)
          break label266;
        bool3 = bool1;
        if ((0x10 & paramArrayOfByte[0]) == 0)
          break label272;
        bool4 = bool1;
        if ((0x20 & paramArrayOfByte[0]) == 0)
          break label278;
        bool5 = bool1;
        if ((0x8 & paramArrayOfByte[0]) == 0)
          break label284;
        bool6 = bool1;
        label220: if ((0x4 & paramArrayOfByte[0]) == 0)
          break label290;
      }
      while (true)
      {
        if (!localDoor1.a(bool2, bool3, bool4, bool5, bool6, bool1))
          break label293;
        this.cv.a(this.aB);
        break;
        bool2 = false;
        break label171;
        bool3 = false;
        break label184;
        bool4 = false;
        break label196;
        bool5 = false;
        break label208;
        bool6 = false;
        break label220;
        bool1 = false;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ck
 * JD-Core Version:    0.6.2
 */