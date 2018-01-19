package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class cd extends a
{
  private byte[] dB = new byte[11];

  public cd(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 70;
  }

  private void m(byte[] paramArrayOfByte)
  {
    AirCondition localAirCondition1 = this.d;
    localAirCondition1.modeDual = -1;
    AirCondition localAirCondition2 = this.d;
    localAirCondition2.rearLock = -1;
    this.d.wind_FrameShow = false;
    this.d.windRearShow = false;
    this.d.seatShow = false;
    label89: label115: int i;
    label131: label150: label180: int j;
    label237: int k;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x3 & paramArrayOfByte[0]) == 0)
        break label301;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label312;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label332;
      this.d.modeDual = 1;
      i = paramArrayOfByte[4];
      if (i != 2)
        break label343;
      this.d.windFrontMax = true;
      if (i != 3)
        break label354;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[5]);
      this.d.windLevelMax = 8;
      j = 0xFF & paramArrayOfByte[6];
      if (j != 254)
        break label584;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      k = 0xFF & paramArrayOfByte[7];
      if (k != 254)
        break label664;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
      label272: if ((0x10 & paramArrayOfByte[2]) == 0)
        break label744;
    }
    label301: label312: label332: label343: label354: label744: AirCondition localAirCondition6;
    for (this.d.acMax = 1; ; localAirCondition6.acMax = -1)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label89;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.modeAuto = 0;
      break label115;
      this.d.modeDual = 0;
      break label131;
      this.d.windFrontMax = false;
      break label150;
      if (i == 5)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = true;
        break label180;
      }
      if (i == 6)
      {
        this.d.windUp = false;
        this.d.windMid = true;
        this.d.windDown = false;
        break label180;
      }
      if (i == 11)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = false;
        break label180;
      }
      if (i == 12)
      {
        this.d.windUp = true;
        this.d.windMid = false;
        this.d.windDown = true;
        break label180;
      }
      if (i == 13)
      {
        this.d.windUp = true;
        this.d.windMid = true;
        this.d.windDown = false;
        break label180;
      }
      if (i == 14)
      {
        this.d.windUp = true;
        this.d.windMid = true;
        this.d.windDown = true;
        break label180;
      }
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label180;
      label584: if (j == 255)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label237;
      }
      if ((j >= 34) && (j <= 64))
      {
        this.d.tempLeft = (j * 10 / 2);
        break label237;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempLeft = -1;
      break label237;
      label664: if (k == 255)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
        break label272;
      }
      if ((k >= 34) && (k <= 64))
      {
        this.d.tempRight = (k * 10 / 2);
        break label272;
      }
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.tempRight = -1;
      break label272;
      localAirCondition6 = this.d;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      if (paramInt > 9999)
      {
        arrayOfByte[1] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[2] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[3] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[4] = 46;
        arrayOfByte[5] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt % 10));
        arrayOfByte[7] = 77;
        arrayOfByte[8] = 72;
        arrayOfByte[9] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-46, arrayOfByte, 13);
        return;
        arrayOfByte[2] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[3] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[4] = 46;
        arrayOfByte[5] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 + 1));
    if (paramInt > 999)
    {
      arrayOfByte[2] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[3] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[4] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[5] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[6] = 75;
      arrayOfByte[7] = 72;
      arrayOfByte[8] = 90;
      break;
      arrayOfByte[3] = ((byte)(48 + paramInt / 100));
      arrayOfByte[4] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[5] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 11, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void ah()
  {
    if (this.cv.y != 0)
    {
      CanBusServer localCanBusServer = this.cv;
      byte[] arrayOfByte = new byte[2];
      arrayOfByte[0] = ((byte)(31 + this.cv.y));
      arrayOfByte[1] = 0;
      localCanBusServer.f((byte)36, arrayOfByte, 2);
    }
  }

  public void ai()
  {
  }

  public void aj()
  {
    int i = 1;
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[i] = ((byte)this.hour);
    arrayOfByte[2] = ((byte)this.minute);
    if (bool);
    while (true)
    {
      arrayOfByte[5] = ((byte)i);
      this.cv.f((byte)-53, arrayOfByte, 10);
      return;
      i = 0;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 21, 65, 50, 68, 80, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[13];
    if (paramInt3 == 2);
    for (int i = 7; ; i = 6)
    {
      arrayOfByte[0] = i;
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
      arrayOfByte[3] = 32;
      arrayOfByte[4] = 32;
      arrayOfByte[5] = 32;
      arrayOfByte[6] = 32;
      arrayOfByte[7] = 32;
      arrayOfByte[8] = 32;
      arrayOfByte[9] = 32;
      arrayOfByte[10] = 32;
      arrayOfByte[11] = 32;
      arrayOfByte[12] = 32;
      arrayOfByte[2] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
      arrayOfByte[3] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
      arrayOfByte[4] = 58;
      arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 10));
      arrayOfByte[6] = ((byte)(48 + paramInt2 % 60 % 10));
      arrayOfByte[7] = 58;
      arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 / 10));
      arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
      this.cv.f((byte)-46, arrayOfByte, 13);
      return;
    }
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 13, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[1] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[2] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[3] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[4] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[5] = ((byte)(48 + i % 60 % 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 1000));
    arrayOfByte[7] = ((byte)(48 + paramInt2 / 100 % 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 10 % 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 10));
    this.cv.f((byte)-46, arrayOfByte, 13);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 49:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
      {
        byte[] arrayOfByte = new byte[11];
        int i = 0;
        int j = 0;
        while (i < 11)
        {
          arrayOfByte[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          if (arrayOfByte[i] != this.dB[i])
            j = 1;
          this.dB[i] = arrayOfByte[i];
          i++;
        }
        if (j != 0)
        {
          m(arrayOfByte);
          this.cv.a(this.d);
        }
        int k = 0xFF & paramArrayOfByte[(11 + (paramInt1 + 3))];
        String str = "";
        if (k <= 250)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Float.valueOf(k / 2.0F - 40.0F);
          str = String.format(localLocale, "  %.1f", arrayOfObject) + this.mContext.getString(2131099651);
        }
        f(str);
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cd
 * JD-Core Version:    0.6.2
 */