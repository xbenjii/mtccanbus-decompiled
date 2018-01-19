package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class t extends a
{
  public t(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.onOff = true;
    label156: if ((0x2 & paramArrayOfByte[4]) != 0)
    {
      this.d.modeAc = true;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label277;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 2;
      label49: if ((0x20 & paramArrayOfByte[4]) == 0)
        break label295;
      this.d.windFrontMax = true;
      label66: if ((0x40 & paramArrayOfByte[4]) == 0)
        break label306;
      this.d.windRear = true;
      label83: switch (0xF & paramArrayOfByte[3])
      {
      default:
        this.d.windMid = false;
        this.d.windUp = false;
        this.d.windDown = false;
        this.d.windLevel = (0xF & paramArrayOfByte[1]);
        this.d.windLevelMax = 7;
        this.d.tempLeft = v(0xFF & paramArrayOfByte[0]);
        this.d.tempRight = v(0xFF & paramArrayOfByte[1]);
        if ((0xC & paramArrayOfByte[0]) == 0)
        {
          AirCondition localAirCondition4 = this.d;
          localAirCondition4.windLoop = -1;
          label240: if ((0x10 & paramArrayOfByte[4]) == 0)
            break label554;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    }
    label277: label295: label554: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.modeAc = false;
      break;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label49;
      this.d.windFrontMax = false;
      break label66;
      label306: this.d.windRear = false;
      break label83;
      this.d.windMid = true;
      this.d.windUp = false;
      this.d.windDown = false;
      break label156;
      this.d.windMid = true;
      this.d.windUp = false;
      this.d.windDown = true;
      break label156;
      this.d.windMid = false;
      this.d.windUp = false;
      this.d.windDown = true;
      break label156;
      this.d.windMid = false;
      this.d.windUp = true;
      this.d.windDown = true;
      break label156;
      this.d.windMid = false;
      this.d.windUp = true;
      this.d.windDown = false;
      break label156;
      this.d.windMid = true;
      this.d.windUp = true;
      this.d.windDown = true;
      break label156;
      this.d.windMid = true;
      this.d.windUp = true;
      this.d.windDown = false;
      break label156;
      if ((0x4 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition3 = this.d;
        localAirCondition3.windLoop = 0;
        break label240;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 1;
      break label240;
    }
  }

  private int v(int paramInt)
  {
    int i = 0;
    int j;
    if ((paramInt & 0x1) != 0)
    {
      j = 5;
      if (paramInt > 36)
        break label28;
    }
    while (true)
    {
      return i;
      j = 0;
      break;
      label28: if (paramInt >= 66)
        i = 65535;
      else
        i = j + 10 * (paramInt >> 1);
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
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 3:
    case 50:
    case 56:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
      {
        byte[] arrayOfByte2 = f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 8);
        if (j(arrayOfByte2))
        {
          m(arrayOfByte2);
          this.cv.a(this.d);
        }
        int j = -40 + (0xFF & paramArrayOfByte[(paramInt1 + 8)]);
        String str = "";
        if ((j >= -40) && (j <= 86))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(j);
          str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
        }
        f(str);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
        {
          ax();
          int[] arrayOfInt = new int[3];
          int i = 0;
          if (i < 3)
          {
            arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 4))]);
            if (arrayOfInt[i] >= 5)
              arrayOfInt[i] = 0;
            while (true)
            {
              i++;
              break;
              arrayOfInt[i] = (1 + arrayOfInt[i]);
            }
          }
          this.aY.max = 5;
          this.aY.back_cnt = 3;
          this.aY.b1 = arrayOfInt[0];
          this.aY.b2 = arrayOfInt[1];
          this.aY.b3 = arrayOfInt[2];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
          {
            byte[] arrayOfByte1 = new byte[1];
            arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte1);
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
      label68: if ((0x1 & paramArrayOfByte[0]) == 0)
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
 * Qualified Name:     android.microntek.canbus.c.t
 * JD-Core Version:    0.6.2
 */