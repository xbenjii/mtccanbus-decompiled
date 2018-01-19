package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class di extends a
{
  public di(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 38;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label77: label108: int i;
    label126: AirCondition localAirCondition4;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label224;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label235;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label253;
      this.d.windRear = true;
      if (paramArrayOfByte[1] != 1)
        break label264;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      AirCondition localAirCondition2 = this.d;
      if ((0xF & paramArrayOfByte[2]) != 0)
        break label427;
      i = 0;
      localAirCondition2.windLevel = i;
      this.d.windLevelMax = 7;
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempLeft = x(j);
      this.d.tempRight = this.d.tempLeft;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label440;
      localAirCondition4 = this.d;
    }
    label224: label235: label253: AirCondition localAirCondition3;
    for (localAirCondition4.windLoop = 1; ; localAirCondition3.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      this.d.windRear = false;
      break label77;
      label264: if (paramArrayOfByte[1] == 2)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = true;
        break label108;
      }
      if (paramArrayOfByte[1] == 3)
      {
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = true;
        break label108;
      }
      if (paramArrayOfByte[1] == 4)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = true;
        break label108;
      }
      if (paramArrayOfByte[1] == 5)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = true;
        break label108;
      }
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label108;
      label427: i = -1 + (0xF & paramArrayOfByte[2]);
      break label126;
      label440: localAirCondition3 = this.d;
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
    case 36:
    case 54:
    case 48:
    case 40:
    case 35:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 3)
      {
        int[] arrayOfInt = new int[3];
        for (int n = 0; n < 3; n++)
          arrayOfInt[n] = (1 + (0xFF & paramArrayOfByte[(n + (paramInt1 + 3))]));
        if (this.cv.l() == 0);
        for (this.aY.zero_show = false; ; this.aY.zero_show = true)
        {
          this.aY.max = 5;
          this.aY.back_cnt = 3;
          this.aY.b1 = arrayOfInt[0];
          this.aY.b2 = arrayOfInt[1];
          this.aY.b3 = arrayOfInt[2];
          this.cv.a(this.aY);
          break;
        }
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          int m = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
          if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
            m = 0 - m;
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(m);
          String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
          Intent localIntent2 = new Intent("com.canbus.temperature");
          localIntent2.putExtra("temperature", str);
          this.mContext.sendBroadcast(localIntent2);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 2)
          {
            int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
            if (j >= 32768)
              j += 0;
            int k = j * 30 / 5600;
            Intent localIntent1 = new Intent("com.microntek.canbusbackview");
            localIntent1.putExtra("canbustype", this.e);
            localIntent1.putExtra("lfribackview", 0 - k);
            this.mContext.sendBroadcast(localIntent1);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 1)
            {
              byte[] arrayOfByte2 = new byte[1];
              arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
              n(arrayOfByte2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 4)
              {
                byte[] arrayOfByte1 = new byte[4];
                for (int i = 0; i < 4; i++)
                  arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                m(arrayOfByte1);
                this.cv.a(this.d);
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
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 16)
        i = 65535;
      else if ((paramInt >= 1) && (paramInt <= 15))
        i = 160 + paramInt * 10;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.di
 * JD-Core Version:    0.6.2
 */