package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import java.util.Locale;

public class dm extends a
{
  public dm(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    if ((0x10 & paramArrayOfByte[4]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[3]) == 0)
        break label289;
      this.d.modeAc = true;
      label33: if ((0x80 & paramArrayOfByte[4]) == 0)
        break label300;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      label60: if ((0x40 & paramArrayOfByte[4]) == 0)
        break label318;
      this.d.modeDual = 1;
      label77: if ((0x8 & paramArrayOfByte[3]) == 0)
        break label329;
      this.d.windFrontMax = true;
      label94: if ((0x4 & paramArrayOfByte[3]) == 0)
        break label340;
      this.d.windRear = true;
      label110: if ((0x40 & paramArrayOfByte[3]) == 0)
        break label351;
      this.d.windUp = true;
      label127: if ((0x10 & paramArrayOfByte[3]) == 0)
        break label362;
      this.d.windMid = true;
      label144: if ((0x20 & paramArrayOfByte[3]) == 0)
        break label373;
      this.d.windDown = true;
      label161: this.d.windLevel = (0xF & paramArrayOfByte[2]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[0];
      this.d.tempLeft = x(i);
      int j = 0xFF & paramArrayOfByte[1];
      this.d.tempRight = x(j);
      if ((0x2 & paramArrayOfByte[3]) != 0)
        break label384;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 1;
      label252: if ((0x20 & paramArrayOfByte[4]) == 0)
        break label404;
    }
    label384: label404: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      label289: this.d.modeAc = false;
      break label33;
      label300: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      label318: this.d.modeDual = 0;
      break label77;
      label329: this.d.windFrontMax = false;
      break label94;
      label340: this.d.windRear = false;
      break label110;
      label351: this.d.windUp = false;
      break label127;
      label362: this.d.windMid = false;
      break label144;
      label373: this.d.windDown = false;
      break label161;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label252;
    }
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 1:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
      {
        byte[] arrayOfByte = new byte[6];
        for (int i = 0; i < 5; i++)
          arrayOfByte[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
        if (j(arrayOfByte))
        {
          m(arrayOfByte);
          this.cv.a(this.d);
        }
        int j = 0xFF & paramArrayOfByte[(5 + (paramInt1 + 3))];
        String str = "";
        if (j != 255)
        {
          int k = j - 128;
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(k);
          str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
        }
        Intent localIntent = new Intent("com.canbus.temperature");
        localIntent.putExtra("temperature", str);
        this.mContext.sendBroadcast(localIntent);
      }
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
      else if ((paramInt >= 18) && (paramInt <= 32))
        i = paramInt * 10;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dm
 * JD-Core Version:    0.6.2
 */