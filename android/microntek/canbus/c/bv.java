package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.text.format.DateFormat;
import android.text.format.Time;

public class bv extends a
{
  public bv(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 63;
  }

  private int F(int paramInt)
  {
    if ((paramInt >= 25) && (paramInt <= 127));
    for (int i = 25 * (paramInt - 25) / 102; ; i = 255)
      return i;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label41: label66: label83: label100: label117: int i;
    label134: label151: label205: int j;
    if ((0xF & paramArrayOfByte[2]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[1]) == 0)
        break label311;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[1]) == 0)
        break label322;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.modeAuto = 1;
      if ((0x40 & paramArrayOfByte[2]) == 0)
        break label340;
      this.d.modeDual = 1;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label351;
      this.d.windRear = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label362;
      this.d.windUp = true;
      if ((0x8 & paramArrayOfByte[1]) == 0)
        break label373;
      this.d.windMid = true;
      if ((0x10 & paramArrayOfByte[1]) == 0)
        break label384;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[2]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[3];
      if (i != 1)
        break label395;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[4];
      if (j != 1)
        break label487;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
      label237: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label579;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 0;
      label264: AirCondition localAirCondition5 = this.d;
      localAirCondition5.rearLock = -1;
      if ((0x80 & paramArrayOfByte[2]) == 0)
        break label599;
    }
    label311: label322: label340: label599: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label41;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label66;
      this.d.modeDual = 0;
      break label83;
      label351: this.d.windRear = false;
      break label100;
      label362: this.d.windUp = false;
      break label117;
      label373: this.d.windMid = false;
      break label134;
      this.d.windDown = false;
      break label151;
      if (i == 57)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label205;
      }
      if ((i >= 3) && (i <= 55))
      {
        if (i % 2 == 0)
          break label205;
        this.d.tempLeft = ((int)(180.0F + 10.0F * (i / 2 / 2.0F)));
        break label205;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label205;
      label487: if (j == 57)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
        break label237;
      }
      if ((j >= 3) && (j <= 55))
      {
        if (j % 2 == 0)
          break label237;
        this.d.tempRight = ((int)(180.0F + 10.0F * (j / 2 / 2.0F)));
        break label237;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label237;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      break label264;
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

  public int[][] aA()
  {
    return new int[][] { { 3842, 46, 43010, 1, 0 }, { 3842, 46, 43010, 1, 1 }, { 3844, 46, 43010, 27, 0 }, { 3844, 46, 43010, 27, 1 }, { 3845, 46, 43010, 21, 0 }, { 3845, 46, 43010, 21, 1 }, { 3846, 46, 43010, 2, 0 }, { 3846, 46, 43010, 2, 1 }, { 3847, 46, 43010, 13, 0 }, { 3847, 46, 43010, 13, 1 }, { 3848, 46, 43010, 14, 0 }, { 3848, 46, 43010, 14, 1 }, { 3849, 46, 43010, 15, 0 }, { 3849, 46, 43010, 15, 1 }, { 3850, 46, 43010, 16, 0 }, { 3850, 46, 43010, 16, 1 }, { 3853, 46, 43010, 0, 0 }, { 3853, 46, 43010, 0, 1 }, { 3855, 46, 43010, 12, 0 }, { 3855, 46, 43010, 12, 1 }, { 3856, 46, 43010, 11, 0 }, { 3856, 46, 43010, 11, 1 }, { 3857, 46, 43010, 3, 0 }, { 3857, 46, 43010, 3, 0 }, { 3859, 46, 43010, 6, 0 }, { 3859, 46, 43010, 6, 1 }, { 3865, 46, 43010, 17, 0 }, { 3865, 46, 43010, 17, 1 } };
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
    byte[] arrayOfByte = new byte[4];
    if (this.hour > 12)
      arrayOfByte[3] = 1;
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
    }
    while (true)
    {
      arrayOfByte[0] = ((byte)(0xFF & this.minute));
      arrayOfByte[1] = ((byte)(0xFF & this.hour));
      this.cv.a((byte)-56, arrayOfByte, 4);
      return;
      arrayOfByte[2] = 1;
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
    this.cv.l();
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 36:
    case 49:
    case 50:
    case 16:
    case 64:
    case 82:
    case 0:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        byte[] arrayOfByte4 = new byte[1];
        arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte4);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
        {
          int m = (0xFF & paramArrayOfByte[(paramInt1 + 4)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8);
          if ((m >= 2816) && (m <= 12544))
          {
            int n = 35 * (m - 7680) / 4864;
            Intent localIntent = new Intent("com.microntek.canbusbackview");
            localIntent.putExtra("canbustype", this.e);
            localIntent.putExtra("lfribackview", n);
            this.mContext.sendBroadcast(localIntent);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
            {
              int[] arrayOfInt = new int[6];
              for (int j = 0; j < 6; j++)
                arrayOfInt[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
              if (arrayOfInt[0] == 0)
              {
                Radar localRadar = this.aY;
                if (arrayOfInt[1] > 30);
                for (int k = 30; ; k = arrayOfInt[1])
                {
                  localRadar.max = k;
                  this.aY.back_cnt = 4;
                  this.aY.b1 = (1 + arrayOfInt[2]);
                  this.aY.b2 = (1 + arrayOfInt[3]);
                  this.aY.b3 = (1 + arrayOfInt[4]);
                  this.aY.b4 = (1 + arrayOfInt[5]);
                  this.cv.a(this.aY);
                  break;
                }
              }
              if (arrayOfInt[0] == 1)
              {
                this.aY.max = 25;
                this.aY.back_cnt = 4;
                this.aY.b1 = F(arrayOfInt[2]);
                this.aY.b2 = F(arrayOfInt[3]);
                this.aY.b3 = F(arrayOfInt[4]);
                this.aY.b4 = F(arrayOfInt[5]);
                if ((this.aY.b1 != 255) || (this.aY.b2 != 255) || (this.aY.b3 != 255) || (this.aY.b4 != 255))
                {
                  this.cv.a(this.aY);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
                  {
                    byte[] arrayOfByte3 = new byte[5];
                    while (i < 5)
                    {
                      arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    m(arrayOfByte3);
                    this.cv.a(this.d);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                    {
                      byte[] arrayOfByte2 = new byte[3];
                      arrayOfByte2[0] = 64;
                      arrayOfByte2[1] = 1;
                      arrayOfByte2[2] = paramArrayOfByte[(paramInt1 + 3)];
                      this.cv.d(arrayOfByte2);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                      {
                        byte[] arrayOfByte1 = new byte[4];
                        arrayOfByte1[0] = 82;
                        arrayOfByte1[1] = 2;
                        arrayOfByte1[2] = paramArrayOfByte[(paramInt1 + 3)];
                        arrayOfByte1[3] = paramArrayOfByte[(paramInt1 + 4)];
                        this.cv.d(arrayOfByte1);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] != 6);
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
 * Qualified Name:     android.microntek.canbus.c.bv
 * JD-Core Version:    0.6.2
 */