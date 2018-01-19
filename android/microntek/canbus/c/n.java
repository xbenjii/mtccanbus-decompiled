package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;

public class n extends a
{
  public n(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label140: if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label267;
      this.d.modeAc = true;
      label34: if ((0x4 & paramArrayOfByte[1]) == 0)
        break label278;
      this.d.modeDual = 1;
      label50: if ((0x10 & paramArrayOfByte[2]) == 0)
        break label289;
      this.d.windFrontMax = true;
      label67: if ((0x20 & paramArrayOfByte[2]) == 0)
        break label300;
      this.d.windRear = true;
      label84: switch (0xF & paramArrayOfByte[4])
      {
      default:
        this.d.windLevel = (0xF & paramArrayOfByte[5]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[6];
        this.d.tempLeft = v(i);
        int j = 0xFF & paramArrayOfByte[7];
        this.d.tempRight = v(j);
        if ((0x10 & paramArrayOfByte[1]) != 0)
        {
          AirCondition localAirCondition2 = this.d;
          localAirCondition2.windLoop = 1;
          label230: if ((0x20 & paramArrayOfByte[0]) == 0)
            break label466;
        }
        break;
      case 3:
      case 5:
      case 6:
      case 12:
      case 0:
      }
    }
    label267: label278: label289: label300: label466: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      this.d.modeDual = 0;
      break label50;
      this.d.windFrontMax = false;
      break label67;
      this.d.windRear = false;
      break label84;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label140;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label140;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.windLoop = 0;
      break label230;
    }
  }

  private int v(int paramInt)
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
        i = paramInt * 5;
      else
        i = -1;
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
    return new int[][] { { 3842, 23205, 15618, 2, 0 }, { 3842, 23205, 15618, 2, 1 }, { 3845, 23205, 15618, 7, 0 }, { 3845, 23205, 15618, 7, 1 }, { 3847, 23205, 15618, 13, 0 }, { 3847, 23205, 15618, 13, 1 }, { 3848, 23205, 15618, 14, 0 }, { 3848, 23205, 15618, 14, 1 }, { 3849, 23205, 15618, 15, 0 }, { 3849, 23205, 15618, 15, 1 }, { 3850, 23205, 15618, 16, 0 }, { 3850, 23205, 15618, 16, 1 }, { 3853, 23205, 15618, 1, 0 }, { 3853, 23205, 15618, 1, 1 }, { 3855, 23205, 15618, 12, 0 }, { 3855, 23205, 15618, 12, 1 }, { 3856, 23205, 15618, 11, 0 }, { 3856, 23205, 15618, 11, 1 }, { 3865, 23205, 15618, 21, 1 }, { 3865, 23205, 15618, 21, 1 } };
  }

  public void ah()
  {
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

  public void az()
  {
    this.cv.f((byte)106, new byte[] { 5, 1, 49 }, 3);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 49:
    case 34:
    case 50:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
      {
        byte[] arrayOfByte = f(paramArrayOfByte, paramInt1 + 3, paramInt2);
        if (j(arrayOfByte))
        {
          m(arrayOfByte);
          this.cv.a(this.d);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] < 7) || (goto 40) || (paramArrayOfByte[(paramInt1 + 2)] < 7));
        }
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.n
 * JD-Core Version:    0.6.2
 */