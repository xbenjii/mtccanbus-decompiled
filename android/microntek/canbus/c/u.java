package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class u extends a
{
  public u(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label44: label70: label86: label103: label121: AirCondition localAirCondition3;
    if (((0x80 & paramArrayOfByte[0]) != 0) && ((0x10 & paramArrayOfByte[1]) != 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label267;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label278;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label296;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label307;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label318;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label329;
      this.d.windMid = true;
      label138: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label340;
      this.d.windDown = true;
      label155: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 8;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = v(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = v(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label351;
      localAirCondition3 = this.d;
    }
    label267: label278: label296: label307: label318: label329: label340: label351: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label44;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label70;
      this.d.windFrontMax = false;
      break label86;
      this.d.windRear = false;
      break label103;
      this.d.windUp = false;
      break label121;
      this.d.windMid = false;
      break label138;
      this.d.windDown = false;
      break label155;
      localAirCondition2 = this.d;
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
      if (paramInt == 255)
        i = 65535;
      else if (paramInt <= 99)
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
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 34:
    case 35:
    case 37:
    case 38:
    case 40:
    default:
    case 39:
    case 36:
    case 33:
    case 41:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        int j = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
        if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
          j = 0 - j;
        StringBuilder localStringBuilder = new StringBuilder();
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(j / 2.0F);
        f(String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651));
        continue;
        if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && ((0x1 & paramArrayOfByte[(paramInt1 + 3)]) != 0))
        {
          byte[] arrayOfByte2 = new byte[1];
          arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
          n(arrayOfByte2);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
          {
            byte[] arrayOfByte1 = f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 9);
            if (j(arrayOfByte1))
            {
              m(arrayOfByte1);
              this.cv.a(this.d);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
              {
                int i = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                if (i >= 32768)
                  i += 0;
                o(i * 30 / 5888);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.u
 * JD-Core Version:    0.6.2
 */