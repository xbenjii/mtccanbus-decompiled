package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class de extends a
{
  private byte dW = 0;

  public de(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 87;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label60: label77: label124: int i;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label263;
      this.d.modeAc = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label274;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 2;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label292;
      this.d.windRear = true;
      switch (paramArrayOfByte[1] >> 4)
      {
      default:
        AirCondition localAirCondition2 = this.d;
        if ((0xF & paramArrayOfByte[1]) <= 7)
        {
          i = 0xF & paramArrayOfByte[1];
          label149: localAirCondition2.windLevel = i;
          this.d.windLevelMax = 7;
          int j = 0xFF & paramArrayOfByte[2];
          this.d.tempLeft = x(j);
          int k = 0xFF & paramArrayOfByte[3];
          this.d.tempRight = x(k);
          if ((0x20 & paramArrayOfByte[0]) == 0)
            break label503;
          AirCondition localAirCondition4 = this.d;
          localAirCondition4.windLoop = 1;
          label235: if ((0x4 & paramArrayOfByte[0]) == 0)
            break label523;
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    label263: label523: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      label274: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      label292: this.d.windRear = false;
      break label77;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label124;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label124;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label124;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label124;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label124;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label124;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label124;
      i = -1;
      break label149;
      label503: AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label235;
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
    this.cv.d(1);
    this.cv.a((byte)-126, new byte[] { 1 }, 1);
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
    case 2:
    case 10:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 127:
    case 113:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
      {
        byte[] arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
        {
          byte[] arrayOfByte1 = new byte[4];
          while (i < 4)
          {
            arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          if (j(arrayOfByte1))
          {
            m(arrayOfByte1);
            this.cv.a(this.d);
            continue;
            if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] >= 1))
            {
              float f = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) / 2.0F - 40.0F;
              String str = "";
              if ((f >= -40.0F) && (f <= 87.5D))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                Locale localLocale = Locale.US;
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = Float.valueOf(f);
                str = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651);
              }
              Intent localIntent2 = new Intent("com.canbus.temperature");
              localIntent2.putExtra("temperature", str);
              this.mContext.sendBroadcast(localIntent2);
              continue;
              if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] >= 1) && (paramArrayOfByte[(paramInt1 + 3)] != this.dW))
              {
                this.dW = paramArrayOfByte[(paramInt1 + 3)];
                this.d.seatHotLeft = ((0x30 & paramArrayOfByte[(paramInt1 + 3)]) >> 4);
                this.d.seatHotRight = (0x3 & paramArrayOfByte[(paramInt1 + 3)]);
                this.cv.a(this.d);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] == 1) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] >= 1))
                {
                  int k = 30 * (-128 + (0xFF & paramArrayOfByte[(paramInt1 + 3)])) / 128;
                  Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                  localIntent1.putExtra("canbustype", this.e);
                  localIntent1.putExtra("lfribackview", k);
                  this.mContext.sendBroadcast(localIntent1);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                  {
                    if (this.cv.l() == 0);
                    int[] arrayOfInt;
                    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
                    {
                      arrayOfInt = new int[4];
                      for (int j = 0; j < 4; j++)
                      {
                        arrayOfInt[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                        if (arrayOfInt[j] > 7)
                          arrayOfInt[j] = 0;
                        arrayOfInt[j] = (0 - (-7 + arrayOfInt[j]));
                      }
                    }
                    this.aY.max = 7;
                    this.aY.back_cnt = 2;
                    this.aY.front_cnt = 2;
                    this.aY.f1 = arrayOfInt[0];
                    this.aY.f2 = arrayOfInt[1];
                    this.aY.b1 = arrayOfInt[2];
                    this.aY.b2 = arrayOfInt[3];
                    this.cv.a(this.aY);
                    continue;
                    if ((paramArrayOfByte[(paramInt1 + 2)] != 1) || (goto 148) || (paramArrayOfByte[(paramInt1 + 2)] != 1) || (goto 148) || (paramArrayOfByte[(paramInt1 + 2)] != 1));
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 14)
        i = 65535;
      else if ((paramInt >= 1) && (paramInt <= 45))
        i = 150 + paramInt * 10;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.de
 * JD-Core Version:    0.6.2
 */