package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;

public class dn extends a
{
  public dn(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label245;
      this.d.modeAc = true;
      label35: if ((0x2 & paramArrayOfByte[0]) == 0)
        break label256;
      this.d.windFrontMax = true;
      label51: if ((0x40 & paramArrayOfByte[4]) == 0)
        break label267;
      this.d.windRear = true;
      label68: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label278;
      this.d.windUp = true;
      label86: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label289;
      this.d.windMid = true;
      label103: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label300;
      this.d.windDown = true;
      label120: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 8;
      int i = 0xFF & paramArrayOfByte[2];
      AirCondition localAirCondition1 = this.d;
      AirCondition localAirCondition2 = this.d;
      int j = x(i);
      localAirCondition2.tempLeft = j;
      localAirCondition1.tempRight = j;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label311;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      label207: if ((0x80 & paramArrayOfByte[4]) == 0)
        break label331;
    }
    label256: label267: label278: label289: label300: label311: label331: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      label245: this.d.modeAc = false;
      break label35;
      this.d.windFrontMax = false;
      break label51;
      this.d.windRear = false;
      break label68;
      this.d.windUp = false;
      break label86;
      this.d.windMid = false;
      break label103;
      this.d.windDown = false;
      break label120;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label207;
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
    case 20:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    case 41:
    case 48:
    }
    while (true)
    {
      return;
      if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && (goto 84) && (paramArrayOfByte[(paramInt1 + 2)] >= 2) && (goto 84) && (paramArrayOfByte[(paramInt1 + 2)] >= 7))
      {
        byte[] arrayOfByte2 = new byte[7];
        while (i < 7)
        {
          arrayOfByte2[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        if ((0x10 & arrayOfByte2[1]) != 0)
        {
          m(arrayOfByte2);
          this.cv.a(this.d);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
          {
            int[] arrayOfInt2 = new int[4];
            for (int k = 0; k < 4; k++)
            {
              arrayOfInt2[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
              if (arrayOfInt2[k] != 0)
                arrayOfInt2[k] = (0 - (-5 + arrayOfInt2[k]));
            }
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfInt2[0];
            this.aY.b2 = arrayOfInt2[1];
            this.aY.b3 = arrayOfInt2[2];
            this.aY.b4 = arrayOfInt2[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
            {
              int[] arrayOfInt1 = new int[4];
              for (int j = 0; j < 4; j++)
              {
                arrayOfInt1[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                if (arrayOfInt1[j] != 0)
                  arrayOfInt1[j] = (0 - (-5 + arrayOfInt1[j]));
              }
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfInt1[0];
              this.aY.f2 = arrayOfInt1[1];
              this.aY.f3 = arrayOfInt1[2];
              this.aY.f4 = arrayOfInt1[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
              {
                byte[] arrayOfByte1 = new byte[1];
                arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 3)];
                n(arrayOfByte1);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                {
                  o(30 * (2816 + (-5120 + ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8)))) / 5120);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] < 2);
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

  int x(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 15));
    for (int i = 150 + paramInt * 10; ; i = -1)
      return i;
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dn
 * JD-Core Version:    0.6.2
 */