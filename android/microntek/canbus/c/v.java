package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;

public class v extends a
{
  public v(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 11;
  }

  private void aN()
  {
    byte[] arrayOfByte = { 7, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    this.d.windRearShow = false;
    label60: label86: label102: label118: AirCondition localAirCondition3;
    if (((0x80 & paramArrayOfByte[0]) != 0) || ((0x10 & paramArrayOfByte[1]) != 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label317;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label328;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label375;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label386;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label397;
      this.d.windRear = true;
      label134: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label408;
      this.d.windUp = true;
      label152: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label419;
      this.d.windMid = true;
      label169: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label430;
      this.d.windDown = true;
      label186: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = w(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = w(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label441;
      localAirCondition3 = this.d;
    }
    label317: label328: label375: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatHotLeft = ((0x30 & paramArrayOfByte[4]) >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[4]);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label60;
      if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition4 = this.d;
        localAirCondition4.modeAuto = 1;
        break label86;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label86;
      this.d.modeDual = 0;
      break label102;
      label386: this.d.windFrontMax = false;
      break label118;
      label397: this.d.windRear = false;
      break label134;
      label408: this.d.windUp = false;
      break label152;
      label419: this.d.windMid = false;
      break label169;
      label430: this.d.windDown = false;
      break label186;
      label441: localAirCondition2 = this.d;
    }
  }

  private int w(int paramInt)
  {
    int i;
    if (paramInt == 31)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 57)
        i = 65535;
      else if ((paramInt >= 32) && (paramInt <= 56))
        i = paramInt * 10 / 2;
      else
        i = -1;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte2[0] = 16;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    aN();
  }

  public void a(String paramString, int paramInt)
  {
    aN();
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
    aN();
  }

  public void al()
  {
    aN();
  }

  public void am()
  {
    aN();
  }

  public void an()
  {
    aN();
  }

  public void ao()
  {
    aN();
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[2];
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 2, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    aN();
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
      case 34:
      case 35:
      case 33:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 4)
      {
        byte[] arrayOfByte3 = new byte[4];
        int k = 0;
        if (k < 4)
        {
          if (paramArrayOfByte[(k + (paramInt1 + 3))] == 0)
            arrayOfByte3[k] = 0;
          while (true)
          {
            k++;
            break;
            if (paramArrayOfByte[(k + (paramInt1 + 3))] < 3)
              arrayOfByte3[k] = 1;
            else
              arrayOfByte3[k] = ((byte)(paramArrayOfByte[(k + (paramInt1 + 3))] / 2));
          }
        }
        this.aY.max = 15;
        this.aY.back_cnt = 4;
        this.aY.b1 = arrayOfByte3[0];
        this.aY.b2 = arrayOfByte3[1];
        this.aY.b3 = arrayOfByte3[2];
        this.aY.b4 = arrayOfByte3[3];
        this.cv.a(this.aY);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 6)
        {
          byte[] arrayOfByte2 = new byte[4];
          int j = 0;
          if (j < 4)
          {
            if (paramArrayOfByte[(j + (paramInt1 + 3))] == 0)
              arrayOfByte2[j] = 0;
            while (true)
            {
              j++;
              break;
              if (paramArrayOfByte[(j + (paramInt1 + 3))] < 3)
                arrayOfByte2[j] = 1;
              else
                arrayOfByte2[j] = ((byte)(paramArrayOfByte[(j + (paramInt1 + 3))] / 2));
            }
          }
          this.aY.max = 15;
          this.aY.front_cnt = 4;
          this.aY.f1 = arrayOfByte2[0];
          this.aY.f2 = arrayOfByte2[1];
          this.aY.f3 = arrayOfByte2[2];
          this.aY.f4 = arrayOfByte2[3];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 9)
          {
            byte[] arrayOfByte1 = new byte[9];
            while (i < 9)
            {
              arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            m(arrayOfByte1);
            this.cv.a(this.d);
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
 * Qualified Name:     android.microntek.canbus.c.v
 * JD-Core Version:    0.6.2
 */