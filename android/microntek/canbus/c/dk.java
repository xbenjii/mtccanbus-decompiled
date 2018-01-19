package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class dk extends a
{
  public dk(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.onOff = true;
    label41: label57: label120: int i;
    label139: int j;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.modeAc = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label262;
      this.d.windFrontMax = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label273;
      this.d.windRear = true;
      switch (0xF & paramArrayOfByte[1])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        AirCondition localAirCondition1 = this.d;
        if ((0xF & paramArrayOfByte[2]) > 7)
        {
          i = 7;
          localAirCondition1.windLevel = i;
          this.d.windLevelMax = 7;
          j = 0xFF & paramArrayOfByte[3];
          if (j != 17)
            break label429;
          AirCondition localAirCondition6 = this.d;
          localAirCondition6.tempLeft = 0;
          label186: this.d.tempRight = this.d.tempLeft;
          if ((0x20 & paramArrayOfByte[0]) == 0)
            break label506;
          AirCondition localAirCondition4 = this.d;
          localAirCondition4.windLoop = 1;
          label226: if ((0x4 & paramArrayOfByte[0]) == 0)
            break label526;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    label262: label526: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.modeAc = false;
      break;
      this.d.windFrontMax = false;
      break label41;
      label273: this.d.windRear = false;
      break label57;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label120;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label120;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label120;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label120;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label120;
      i = 0xF & paramArrayOfByte[2];
      break label139;
      label429: if (j == 32)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.tempLeft = 65535;
        break label186;
      }
      if ((j >= 18) && (j <= 31))
      {
        this.d.tempLeft = (j * 10);
        break label186;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label186;
      label506: AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label226;
    }
  }

  public void ah()
  {
    this.cv.d(1);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 40:
    case 54:
    case 35:
    case 36:
    case 37:
    case 99:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        byte[] arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
        {
          int m = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
          if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
            m = 0 - m;
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(m);
          String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
          Intent localIntent = new Intent("com.canbus.temperature");
          localIntent.putExtra("temperature", str);
          this.mContext.sendBroadcast(localIntent);
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
            if (j(arrayOfByte1))
            {
              this.cv.a(this.d);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
              {
                int[] arrayOfInt2;
                int k;
                if (this.cv.l() == 0)
                {
                  this.aY.zero_show = false;
                  arrayOfInt2 = new int[2];
                  k = 0;
                  label334: if (k >= 2)
                    break label465;
                  arrayOfInt2[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
                  if ((arrayOfInt2[k] < 80) || (arrayOfInt2[k] > 120))
                    break label400;
                  arrayOfInt2[k] = 3;
                }
                while (true)
                {
                  k++;
                  break label334;
                  this.aY.zero_show = true;
                  break;
                  label400: if ((arrayOfInt2[k] >= 40) && (arrayOfInt2[k] <= 70))
                    arrayOfInt2[k] = 2;
                  else if ((arrayOfInt2[k] >= 0) && (arrayOfInt2[k] <= 30))
                    arrayOfInt2[k] = 1;
                  else
                    arrayOfInt2[k] = 0;
                }
                label465: this.aY.max = 3;
                this.aY.back_cnt = 2;
                this.aY.b1 = arrayOfInt2[0];
                this.aY.b2 = arrayOfInt2[1];
                this.cv.a(this.aY);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                {
                  int[] arrayOfInt1;
                  int j;
                  if (this.cv.l() == 0)
                  {
                    this.aY.zero_show = false;
                    arrayOfInt1 = new int[4];
                    j = 0;
                    label552: if (j >= 4)
                      break label622;
                    arrayOfInt1[j] = (0xF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                    if (arrayOfInt1[j] <= 10)
                      break label607;
                    arrayOfInt1[j] = 0;
                  }
                  while (true)
                  {
                    j++;
                    break label552;
                    this.aY.zero_show = true;
                    break;
                    label607: arrayOfInt1[j] = (1 + arrayOfInt1[j]);
                  }
                  label622: this.aY.max = 10;
                  this.aY.back_cnt = 4;
                  this.aY.b1 = arrayOfInt1[0];
                  this.aY.b2 = arrayOfInt1[1];
                  this.aY.b3 = arrayOfInt1[2];
                  this.aY.b4 = arrayOfInt1[3];
                  this.cv.a(this.aY);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] != 2);
                }
              }
            }
          }
        }
      }
    }
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
 * Qualified Name:     android.microntek.canbus.c.dk
 * JD-Core Version:    0.6.2
 */