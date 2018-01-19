package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.os.UserHandle;

public class do extends a
{
  private boolean dY = false;
  private boolean dZ = true;

  public do(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void aS()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.android.launcher", "com.android.launcher2.CarLogoActivity"));
    localIntent.addFlags(807600128);
    try
    {
      this.cv.startActivityAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      label44: return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      break label44;
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label60: label77: label93: label109: label125: AirCondition localAirCondition3;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label252;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label263;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label281;
      this.d.windFrontMax = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label292;
      this.d.windRear = true;
      if ((0x4 & paramArrayOfByte[4]) == 0)
        break label303;
      this.d.windUp = true;
      if ((0x2 & paramArrayOfByte[4]) == 0)
        break label314;
      this.d.windMid = true;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label325;
      this.d.windDown = true;
      label141: this.d.windLevel = (0xF & paramArrayOfByte[3]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[1];
      this.d.tempLeft = x(i);
      int j = 0xFF & paramArrayOfByte[2];
      this.d.tempRight = x(j);
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label336;
      localAirCondition3 = this.d;
    }
    label252: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      label263: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      label281: this.d.windFrontMax = false;
      break label77;
      label292: this.d.windRear = false;
      break label93;
      label303: this.d.windUp = false;
      break label109;
      label314: this.d.windMid = false;
      break label125;
      label325: this.d.windDown = false;
      break label141;
      label336: localAirCondition2 = this.d;
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
    if (paramInt == 1)
      if (this.dZ)
      {
        this.dZ = false;
        byte[] arrayOfByte2 = { 85, -86, 3, 17, 18, 1, 39 };
        this.cv.b(arrayOfByte2);
      }
    while (true)
    {
      return;
      if (!this.dZ)
      {
        this.dZ = true;
        byte[] arrayOfByte1 = { 85, -86, 3, 17, 18, 0, 38 };
        this.cv.b(arrayOfByte1);
      }
    }
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    byte[] arrayOfByte = { 85, -86, 3, 17, -1, -1, 18 };
    this.cv.b(arrayOfByte);
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
    case 9:
    case 11:
    case 14:
    case 50:
    case 18:
    case 19:
    case 32:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
      {
        int m = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
        if (m <= 80)
        {
          o(30 * (m - 40) / 40);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 8)
          {
            int[] arrayOfInt;
            int k;
            if (this.cv.l() == 0)
            {
              this.aY.zero_show = false;
              arrayOfInt = new int[8];
              k = 0;
              label159: if (k >= 8)
                break label229;
              arrayOfInt[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
              if (arrayOfInt[k] <= 2)
                break label220;
              arrayOfInt[k] = (0 - (-10 + arrayOfInt[k]));
            }
            while (true)
            {
              k++;
              break label159;
              this.aY.zero_show = true;
              break;
              label220: arrayOfInt[k] = 0;
            }
            label229: this.aY.max = 7;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfInt[4];
            this.aY.b2 = arrayOfInt[5];
            this.aY.b3 = arrayOfInt[6];
            this.aY.b4 = arrayOfInt[7];
            this.aY.front_cnt = 4;
            this.aY.f1 = arrayOfInt[0];
            this.aY.f2 = arrayOfInt[1];
            this.aY.f3 = arrayOfInt[2];
            this.aY.f4 = arrayOfInt[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
            {
              byte[] arrayOfByte = new byte[5];
              while (i < 5)
              {
                arrayOfByte[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              m(arrayOfByte);
              this.cv.a(this.d);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
              {
                Intent localIntent2 = new Intent("com.microntek.canbus.speed");
                int j = ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 3)]) / 16;
                localIntent2.putExtra("speed", "" + j / 10);
                this.mContext.sendBroadcast(localIntent2);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                  switch (0xFF & paramArrayOfByte[(paramInt1 + 3)])
                  {
                  default:
                    break;
                  case 233:
                    if (!this.cv.w().equals("com.android.launcher2.CarLogoActivity"))
                      aS();
                    break;
                  case 234:
                    Intent localIntent1 = new Intent("com.microntek.hla.car");
                    this.mContext.sendBroadcast(localIntent1);
                    break;
                  case 235:
                    e("av_mute=true");
                    break;
                  case 236:
                    e("av_mute=false");
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                      switch (0xFF & paramArrayOfByte[(paramInt1 + 3)])
                      {
                      default:
                        break;
                      case 231:
                        if (!this.dY)
                          e("ctl_key=13");
                        break;
                      case 232:
                        if (this.dY)
                        {
                          e("ctl_key=13");
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] >= 0)
                            k(f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 3 + (0xFF & paramArrayOfByte[(paramInt1 + 2)])));
                        }
                        break;
                      }
                    break;
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

  public void m(int paramInt)
  {
    if (paramInt == 1)
    {
      this.dY = true;
      byte[] arrayOfByte2 = { 85, -86, 3, 17, 19, 1, 40 };
      this.cv.b(arrayOfByte2);
    }
    while (true)
    {
      return;
      this.dY = false;
      byte[] arrayOfByte1 = { 85, -86, 3, 17, 19, 0, 39 };
      this.cv.b(arrayOfByte1);
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
      if (paramInt == 255)
        i = 65535;
      else if ((paramInt >= 16) && (paramInt <= 28))
        i = paramInt * 10;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.do
 * JD-Core Version:    0.6.2
 */