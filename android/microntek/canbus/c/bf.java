package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;

public class bf extends a
{
  byte[] dv = new byte[12];

  public bf(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 47;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    this.d.windRearShow = false;
    this.d.wind_FrameShow = false;
    label74: label108: int i;
    label440: label497: int j;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      this.d.modeAc = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label580;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.modeAuto = 2;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.DIS_IMG = 1;
      if ((0x8 & paramArrayOfByte[1]) == 0)
        break label626;
      this.d.modeDual = 1;
      if ((paramArrayOfByte[4] != 3) && (paramArrayOfByte[4] != 5) && (paramArrayOfByte[4] != 6) && (paramArrayOfByte[4] != 11) && (paramArrayOfByte[4] != 12) && (paramArrayOfByte[4] != 13) && (paramArrayOfByte[4] != 14))
        break label637;
      if (paramArrayOfByte[4] == 14)
      {
        this.d.windDown = true;
        this.d.windRear = false;
        this.d.windUp = true;
        this.d.windMid = true;
      }
      if (paramArrayOfByte[4] == 13)
      {
        this.d.windDown = false;
        this.d.windRear = false;
        this.d.windUp = true;
        this.d.windMid = true;
      }
      if (paramArrayOfByte[4] == 12)
      {
        this.d.windDown = true;
        this.d.windRear = false;
        this.d.windUp = true;
        this.d.windMid = false;
      }
      if (paramArrayOfByte[4] == 11)
      {
        this.d.windDown = false;
        this.d.windRear = false;
        this.d.windUp = true;
        this.d.windMid = false;
      }
      if (paramArrayOfByte[4] == 6)
      {
        this.d.windDown = false;
        this.d.windRear = false;
        this.d.windUp = false;
        this.d.windMid = true;
      }
      if (paramArrayOfByte[4] == 5)
      {
        this.d.windDown = true;
        this.d.windRear = false;
        this.d.windUp = false;
        this.d.windMid = true;
      }
      if (paramArrayOfByte[4] == 3)
      {
        this.d.windDown = true;
        this.d.windRear = false;
        this.d.windUp = false;
        this.d.windMid = false;
      }
      this.d.windLevel = (0xF & paramArrayOfByte[5]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[6];
      if (i != 254)
        break label672;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[7];
      if (j != 254)
        break label715;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.tempRight = 0;
      label532: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label778;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label758;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 2;
    }
    while (true)
    {
      return;
      this.d.onOff = false;
      break;
      label580: if ((0x1 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.modeAuto = 1;
        break label74;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label74;
      label626: this.d.modeDual = 0;
      break label108;
      label637: this.d.windDown = false;
      this.d.windRear = false;
      this.d.windUp = false;
      this.d.windMid = false;
      break label440;
      label672: if (i == 255)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempLeft = 65535;
        break label497;
      }
      this.d.tempLeft = (i * 5);
      break label497;
      label715: if (j == 255)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempRight = 65535;
        break label532;
      }
      this.d.tempRight = (j * 5);
      break label532;
      label758: AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      continue;
      label778: AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
        arrayOfByte[10] = 77;
        arrayOfByte[11] = 72;
        arrayOfByte[12] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-31, arrayOfByte, 13);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 + 1));
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 32;
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[9] = 75;
      arrayOfByte[10] = 72;
      arrayOfByte[11] = 90;
      break;
      arrayOfByte[5] = ((byte)(48 + paramInt / 100));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 11, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
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
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[0] = -128;
    arrayOfByte[1] = ((byte)(0xFF & this.hour));
    arrayOfByte[2] = ((byte)(0xFF & this.minute));
    if (bool)
      arrayOfByte[5] = 1;
    while (true)
    {
      arrayOfByte[6] = ((byte)(0xFF & 208 + (-2000 + localTime.year)));
      arrayOfByte[7] = ((byte)(0xFF & 1 + localTime.month));
      arrayOfByte[8] = ((byte)(0xFF & localTime.monthDay));
      arrayOfByte[9] = 2;
      this.cv.f((byte)-53, arrayOfByte, 10);
      return;
      arrayOfByte[5] = 0;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 32, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 13, 32, 109, 111, 118, 105, 101, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    arrayOfByte[0] = 7;
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    arrayOfByte[7] = 58;
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    arrayOfByte[10] = 58;
    arrayOfByte[11] = ((byte)(48 + paramInt2 % 60 / 10));
    arrayOfByte[12] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 13, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-31, arrayOfByte, 13);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.cv.l();
    int j;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      j = paramInt2 - paramInt1;
      if ((j > 3) && (j <= 20))
        break;
    case 17:
    case 49:
    case 65:
    case 6:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] != 10)
        break;
      byte[] arrayOfByte4 = new byte[1];
      arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 12)];
      n(arrayOfByte4);
      int i2 = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8);
      if (i2 >= 32768)
        i2 += 0;
      int i3 = i2 * 35 / 480;
      Intent localIntent = new Intent("com.microntek.canbusbackview");
      localIntent.putExtra("canbustype", this.e);
      localIntent.putExtra("lfribackview", i3);
      this.mContext.sendBroadcast(localIntent);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] != 12)
        break;
      byte[] arrayOfByte3 = new byte[12];
      int n = 0;
      int i1 = 0;
      while (n < 12)
      {
        arrayOfByte3[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
        if (arrayOfByte3[n] != this.dv[n])
          i1 = 1;
        this.dv[n] = arrayOfByte3[n];
        n++;
      }
      if (i1 == 0)
        break;
      m(arrayOfByte3);
      this.cv.a(this.d);
      break;
      if ((i == 0) || (paramArrayOfByte[(paramInt1 + 2)] != 16))
        break;
      byte[] arrayOfByte2 = new byte[8];
      for (int m = 0; m < 8; m++)
        arrayOfByte2[m] = ((byte)(10 * (0xFF & paramArrayOfByte[(m + (paramInt1 + 3))]) / 255));
      this.aY.max = 10;
      this.aY.back_cnt = 4;
      this.aY.b1 = arrayOfByte2[0];
      this.aY.b2 = arrayOfByte2[1];
      this.aY.b3 = arrayOfByte2[3];
      this.aY.b4 = arrayOfByte2[2];
      this.aY.front_cnt = 4;
      this.aY.f1 = arrayOfByte2[4];
      this.aY.f2 = arrayOfByte2[5];
      this.aY.f3 = arrayOfByte2[7];
      this.aY.f4 = arrayOfByte2[6];
      this.cv.a(this.aY);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] != 2)
        break;
      break;
      byte[] arrayOfByte1 = new byte[j];
      for (int k = 0; k < j; k++)
        arrayOfByte1[k] = paramArrayOfByte[(k + (paramInt1 + 1))];
      this.cv.d(arrayOfByte1);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bf
 * JD-Core Version:    0.6.2
 */