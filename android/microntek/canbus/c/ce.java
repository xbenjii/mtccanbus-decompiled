package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;

public class ce extends a
{
  private byte[] cB = new byte[6];

  public ce(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 71;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    this.d.onOff = true;
    label57: label101: int i;
    label160: label177: label194: label249: int j;
    if ((0x2 & paramArrayOfByte[4]) != 0)
    {
      this.d.modeAc = true;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label320;
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.modeAuto = 2;
      if (this.cv.y != 0)
        break label349;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.acMax = -1;
      if ((0x10 & paramArrayOfByte[4]) == 0)
        break label338;
      this.d.modeDual = 1;
      switch (0x7 & paramArrayOfByte[3])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        if ((0x20 & paramArrayOfByte[4]) != 0)
        {
          this.d.windFrontMax = true;
          if ((0x40 & paramArrayOfByte[4]) == 0)
            break label527;
          this.d.windRear = true;
          this.d.windLevel = (0x7 & paramArrayOfByte[2]);
          this.d.windLevelMax = 7;
          i = 0xFF & paramArrayOfByte[0];
          if (i != 36)
            break label538;
          AirCondition localAirCondition11 = this.d;
          localAirCondition11.tempLeft = 0;
          j = 0xFF & paramArrayOfByte[1];
          if (j != 36)
            break label617;
          AirCondition localAirCondition9 = this.d;
          localAirCondition9.tempRight = 0;
          label282: if ((0x8 & paramArrayOfByte[4]) == 0)
            break label696;
          AirCondition localAirCondition7 = this.d;
          localAirCondition7.windLoop = 1;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    while (true)
    {
      return;
      this.d.modeAc = false;
      break;
      label320: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label57;
      label338: this.d.modeDual = 0;
      break label101;
      label349: if (this.cv.y != 1)
        break label101;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeDual = -1;
      if ((0x10 & paramArrayOfByte[4]) != 0)
      {
        this.d.acMax = 1;
        break label101;
      }
      this.d.acMax = 0;
      break label101;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label160;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label160;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label160;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label160;
      this.d.windFrontMax = false;
      break label177;
      label527: this.d.windRear = false;
      break label194;
      label538: if (i == 64)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempLeft = 65535;
        break label249;
      }
      if ((i >= 34) && (i <= 62))
      {
        this.d.tempLeft = (i * 10 / 2);
        break label249;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label249;
      label617: if (j == 64)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempRight = 65535;
        break label282;
      }
      if ((j >= 34) && (j <= 62))
      {
        this.d.tempRight = (j * 10 / 2);
        break label282;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label282;
      label696: if ((0x4 & paramArrayOfByte[4]) != 0)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.windLoop = 0;
      }
      else
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.windLoop = -1;
      }
    }
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 0:
    }
    byte[] arrayOfByte;
    do
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] != 6)
        break;
      arrayOfByte = new byte[5];
      int j = 0;
      int k = 0;
      while (j < 5)
      {
        arrayOfByte[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
        if (arrayOfByte[j] != this.cB[j])
          k = i;
        this.cB[j] = arrayOfByte[j];
        j++;
      }
      if (k != 0)
      {
        m(arrayOfByte);
        this.cv.a(this.d);
      }
    }
    while (this.cv.y != 0);
    label149: int m;
    String str;
    if ((0x80 & arrayOfByte[4]) != 0)
    {
      m = 0xFF & paramArrayOfByte[(5 + (paramInt1 + 3))];
      if (i == 0)
        break label210;
      str = " OUT";
    }
    while (true)
    {
      Intent localIntent = new Intent("com.canbus.temperature");
      localIntent.putExtra("temperature", str);
      this.mContext.sendBroadcast(localIntent);
      break;
      break;
      i = 0;
      break label149;
      label210: if (m >= 200)
        str = " " + (0 - (255 - m)) + this.mContext.getString(2131099651);
      else
        str = " " + m + this.mContext.getString(2131099651);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ce
 * JD-Core Version:    0.6.2
 */