package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;

public class ca extends a
{
  public ca(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 67;
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
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 33:
      case 34:
      case 35:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 5)
      {
        byte[] arrayOfByte3 = new byte[5];
        while (i < 5)
        {
          arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        if ((0x10 & arrayOfByte3[1]) != 0)
        {
          m(arrayOfByte3);
          this.cv.a(this.d);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte2 = new byte[4];
            for (int k = 0; k < 4; k++)
              arrayOfByte2[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
            this.aY.max = 10;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte2[0];
            this.aY.b2 = arrayOfByte2[1];
            this.aY.b3 = arrayOfByte2[2];
            this.aY.b4 = arrayOfByte2[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte1 = new byte[4];
              for (int j = 0; j < 4; j++)
                arrayOfByte1[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
              this.aY.max = 10;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte1[0];
              this.aY.f2 = arrayOfByte1[1];
              this.aY.f3 = arrayOfByte1[2];
              this.aY.f4 = arrayOfByte1[3];
              this.cv.a(this.aY);
            }
          }
        }
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ca
 * JD-Core Version:    0.6.2
 */