package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;

public class l extends a
{
  public l(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label50: label66: AirCondition localAirCondition4;
    if ((0xF & paramArrayOfByte[1]) > 0)
    {
      this.d.onOff = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label238;
      this.d.modeAc = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label249;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label260;
      this.d.windRear = true;
      switch (0xFF & paramArrayOfByte[2])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        label132: this.d.windLevel = (0xF & paramArrayOfByte[1]);
        this.d.windLevelMax = 8;
        int i = 0xFF & paramArrayOfByte[3];
        AirCondition localAirCondition1 = this.d;
        AirCondition localAirCondition2 = this.d;
        int j = t(i);
        localAirCondition2.tempLeft = j;
        localAirCondition1.tempRight = j;
        if ((0x4 & paramArrayOfByte[0]) != 0)
          localAirCondition4 = this.d;
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    label238: label249: AirCondition localAirCondition3;
    for (localAirCondition4.windLoop = 1; ; localAirCondition3.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      this.d.windFrontMax = false;
      break label50;
      label260: this.d.windRear = false;
      break label66;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label132;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label132;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label132;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label132;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label132;
      localAirCondition3 = this.d;
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
    CanBusServer localCanBusServer = this.cv;
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)getInt("mParking_mode"));
    arrayOfByte[1] = ((byte)getInt("mMaintenance"));
    localCanBusServer.a((byte)-123, arrayOfByte, 2);
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
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 58:
    case 22:
    case 34:
    case 35:
    case 33:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 3)
      {
        byte[] arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte2);
        continue;
        if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && (goto 60) && (paramArrayOfByte[(paramInt1 + 2)] >= 4))
        {
          if (this.cv.l() == 0);
          for (this.aY.zero_show = false; ; this.aY.zero_show = true)
          {
            this.aY.max = 3;
            for (int k = 0; k < 4; k++)
            {
              this.cw[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
              this.cw[k] = (0 - (-4 + this.cw[k]));
            }
          }
          this.aY.back_cnt = 4;
          this.aY.b1 = this.cw[0];
          this.aY.b2 = this.cw[1];
          this.aY.b3 = this.cw[2];
          this.aY.b4 = this.cw[3];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
          {
            if (this.cv.l() == 0);
            for (this.aY.zero_show = false; ; this.aY.zero_show = true)
            {
              this.aY.max = 3;
              for (int j = 0; j < 4; j++)
              {
                this.cw[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                this.cw[j] = (0 - (-4 + this.cw[j]));
              }
            }
            this.aY.front_cnt = 2;
            this.aY.f1 = this.cw[0];
            this.aY.f2 = this.cw[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
            {
              byte[] arrayOfByte1 = new byte[4];
              while (i < 4)
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
  }

  public int getInt(String paramString)
  {
    return Settings.System.getInt(this.cv.getContentResolver(), paramString, 0);
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
    label31: boolean bool4;
    label42: boolean bool5;
    label54: boolean bool6;
    if ((0x10 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label109;
      bool3 = bool1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label115;
      bool4 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label121;
      bool5 = bool1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label127;
      bool6 = bool1;
      label65: if ((0x1 & paramArrayOfByte[0]) == 0)
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
      break label31;
      label115: bool4 = false;
      break label42;
      label121: bool5 = false;
      break label54;
      label127: bool6 = false;
      break label65;
      label133: bool1 = false;
    }
  }

  int t(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 16));
    for (int i = 150 + paramInt * 10; ; i = -1)
      return i;
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.l
 * JD-Core Version:    0.6.2
 */