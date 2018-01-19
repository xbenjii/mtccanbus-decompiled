package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;

public class da extends a
{
  public da(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 84;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label148: if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label270;
      this.d.modeAc = true;
      label41: if ((0x8 & paramArrayOfByte[0]) == 0)
        break label281;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      label67: if ((0xFF & paramArrayOfByte[4]) != 7)
        break label299;
      this.d.windFrontMax = true;
      label87: if ((0xFF & paramArrayOfByte[4]) != 8)
        break label310;
      this.d.windRear = true;
      label107: switch (0xFF & paramArrayOfByte[4])
      {
      default:
        this.d.windLevel = (0x7 & paramArrayOfByte[5]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[6];
        this.d.tempLeft = x(i);
        int j = 0xFF & paramArrayOfByte[7];
        this.d.tempRight = x(j);
        if ((0x10 & paramArrayOfByte[1]) != 0)
        {
          AirCondition localAirCondition3 = this.d;
          localAirCondition3.windLoop = 1;
          label242: if ((0x4 & paramArrayOfByte[4]) == 0)
            break label476;
        }
        break;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    label270: label281: label299: label310: label476: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label41;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label67;
      this.d.windFrontMax = false;
      break label87;
      this.d.windRear = false;
      break label107;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label148;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label148;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label148;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label148;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label148;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label242;
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
    int i1;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      i1 = paramInt2 - paramInt1;
      if ((i1 > 3) && (i1 <= 40))
        break;
    case 17:
    case 18:
    case 49:
    case 65:
    case 19:
    case 81:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 14)
      {
        int k = 0xFF & paramArrayOfByte[(paramInt1 + 9)];
        int m = (0xFF & paramArrayOfByte[(paramInt1 + 10)]) + 256 * (k & 0x7F);
        if ((k & 0x80) == 0)
          m = 0 - m;
        int n = m * 30 / 5000;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", n);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 10)
        {
          byte[] arrayOfByte2 = new byte[1];
          arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 5)];
          n(arrayOfByte2);
          continue;
          if (a(paramArrayOfByte[(paramInt1 + 2)], 12))
          {
            byte[] arrayOfByte1 = new byte[this.mLength];
            while (i < this.mLength)
            {
              arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            if (j(arrayOfByte1))
            {
              m(arrayOfByte1);
              this.cv.a(this.d);
              continue;
              if (a(paramArrayOfByte[(paramInt1 + 2)], 12))
              {
                int[] arrayOfInt = new int[this.mLength];
                for (int j = 0; j < this.mLength; j++)
                {
                  arrayOfInt[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                  if (arrayOfInt[j] > 4)
                    arrayOfInt[j] = 0;
                }
                if (arrayOfInt[10] == 1)
                {
                  if (this.cv.l() == 0);
                  for (this.aY.zero_show = false; ; this.aY.zero_show = true)
                  {
                    this.aY.max = 4;
                    this.aY.back_cnt = 4;
                    this.aY.b1 = arrayOfInt[0];
                    this.aY.b2 = arrayOfInt[1];
                    this.aY.b3 = arrayOfInt[2];
                    this.aY.b4 = arrayOfInt[3];
                    this.cv.a(this.aY);
                    break;
                  }
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 14) && (goto 86) && (paramArrayOfByte[(paramInt1 + 2)] == 14))
                  {
                    continue;
                    byte[] arrayOfByte3 = new byte[i1];
                    while (i < i1)
                    {
                      arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 1))];
                      i++;
                    }
                    this.cv.d(arrayOfByte3);
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 254)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 255)
        i = 65535;
      else if (paramInt < 100)
        i = paramInt * 10;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.da
 * JD-Core Version:    0.6.2
 */