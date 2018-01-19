package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import java.util.Locale;

public class x extends a
{
  public x(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 13;
    this.d = new AirCondition();
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label78: label95: label111: int i;
    label128: label145: label162: label179: label240: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label374;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label385;
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.modeAuto = 1;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label403;
      this.d.modeDual = 0;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label414;
      this.d.windFrontMax = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label425;
      this.d.windRear = true;
      if ((0x40 & paramArrayOfByte[2]) == 0)
        break label436;
      this.d.windUp = true;
      if ((0x20 & paramArrayOfByte[2]) == 0)
        break label447;
      this.d.windMid = true;
      if ((0x10 & paramArrayOfByte[1]) == 0)
        break label458;
      this.d.windDown = true;
      if ((0x10 & paramArrayOfByte[1]) == 0)
        break label469;
      this.d.windLevel = 0;
      if (this.d.windLevel == 8)
        this.d.windLevel = 7;
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[3];
      if (i != 0)
        break label485;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[4];
      if (j != 0)
        break label564;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempRight = 0;
      label271: if ((0x8 & paramArrayOfByte[0]) == 0)
        break label643;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.windLoop = 2;
    }
    while (true)
    {
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.rearLock = -1;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.acMax = -1;
      this.d.seatHotLeft = ((0xE0 & paramArrayOfByte[5]) >> 5);
      this.d.seatHotRight = ((0x1D & paramArrayOfByte[5]) >> 2);
      return;
      this.d.onOff = false;
      break;
      label374: this.d.modeAc = false;
      break label35;
      label385: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label403: this.d.modeDual = 1;
      break label78;
      label414: this.d.windFrontMax = false;
      break label95;
      label425: this.d.windRear = false;
      break label111;
      label436: this.d.windUp = false;
      break label128;
      label447: this.d.windMid = false;
      break label145;
      label458: this.d.windDown = false;
      break label162;
      label469: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      break label179;
      label485: if (i == 63)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.tempLeft = 65535;
        break label240;
      }
      if ((i >= 11) && (i <= 44))
      {
        this.d.tempLeft = (5 * (i + 19));
        break label240;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label240;
      label564: if (j == 63)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempRight = 65535;
        break label271;
      }
      if ((j >= 11) && (j <= 44))
      {
        this.d.tempRight = (5 * (j + 19));
        break label271;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label271;
      label643: if ((0x4 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.windLoop = 1;
      }
      else
      {
        AirCondition localAirCondition4 = this.d;
        localAirCondition4.windLoop = 0;
      }
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
    default:
    case 8:
    case 31:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 7)
      {
        byte[] arrayOfByte = new byte[7];
        for (int i = 0; i < 7; i++)
          arrayOfByte[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
        m(arrayOfByte);
        this.cv.a(this.d);
        float f = (0xFF & arrayOfByte[6]) - 100.0F;
        StringBuilder localStringBuilder = new StringBuilder();
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(f * 0.5F);
        String str = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651);
        Intent localIntent = new Intent("com.canbus.temperature");
        localIntent.putExtra("temperature", str);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] != 3);
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.x
 * JD-Core Version:    0.6.2
 */