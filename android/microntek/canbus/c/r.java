package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class r extends a
{
  public r(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label281;
      this.d.modeAc = true;
      label35: if ((0x8 & paramArrayOfByte[0]) == 0)
        break label292;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      label61: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label310;
      this.d.modeDual = 1;
      label77: if ((0x2 & paramArrayOfByte[0]) == 0)
        break label321;
      this.d.windFrontMax = true;
      label93: this.d.windRearShow = false;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label332;
      this.d.windUp = true;
      label119: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label343;
      this.d.windMid = true;
      label136: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label354;
      this.d.windDown = true;
      label153: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = v(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = v(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label365;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 1;
      label245: if ((0x4 & paramArrayOfByte[4]) == 0)
        break label385;
    }
    label385: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      label281: this.d.modeAc = false;
      break label35;
      label292: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label310: this.d.modeDual = 0;
      break label77;
      label321: this.d.windFrontMax = false;
      break label93;
      label332: this.d.windUp = false;
      break label119;
      label343: this.d.windMid = false;
      break label136;
      label354: this.d.windDown = false;
      break label153;
      label365: AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label245;
    }
  }

  private int v(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 127)
        i = 65535;
      else if ((paramInt >= 31) && (paramInt <= 59))
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
    case 35:
    default:
    case 36:
    case 34:
    case 33:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
      {
        byte[] arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
        {
          ax();
          int[] arrayOfInt = new int[4];
          for (int j = 0; j < 4; j++)
          {
            arrayOfInt[j] = ((0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]) / 2);
            if (arrayOfInt[j] > 15)
              arrayOfInt[j] = 0;
          }
          this.aY.max = 15;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfInt[0];
          this.aY.b2 = arrayOfInt[1];
          this.aY.b3 = arrayOfInt[2];
          this.aY.b4 = arrayOfInt[3];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
          {
            byte[] arrayOfByte1 = f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 8);
            if ((j(arrayOfByte1)) && ((0x10 & arrayOfByte1[1]) != 0))
            {
              m(arrayOfByte1);
              this.cv.a(this.d);
            }
            int i = paramArrayOfByte[(paramInt1 + 8)];
            String str = "";
            if ((i >= -40) && (i <= 86))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              Locale localLocale = Locale.US;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Integer.valueOf(i);
              str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
            }
            f(str);
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
        break label111;
      bool3 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label117;
      bool4 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label123;
      bool5 = bool1;
      if ((0x0 & paramArrayOfByte[0]) == 0)
        break label129;
      bool6 = bool1;
      label67: if ((0x0 & paramArrayOfByte[0]) == 0)
        break label135;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label111: bool3 = false;
      break label32;
      label117: bool4 = false;
      break label44;
      label123: bool5 = false;
      break label56;
      label129: bool6 = false;
      break label67;
      label135: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.r
 * JD-Core Version:    0.6.2
 */