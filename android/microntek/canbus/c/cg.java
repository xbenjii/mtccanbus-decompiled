package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.os.Handler;
import java.util.Locale;

public class cg extends a
{
  byte[] cB = new byte[6];
  private Handler mHandler = null;

  public cg(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label102: label119: int i;
    label137: label154: label171: label224: label246: AirCondition localAirCondition8;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label318;
      this.d.modeAc = true;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label329;
      AirCondition localAirCondition14 = this.d;
      localAirCondition14.modeAuto = 2;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeDual = -1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label376;
      this.d.windFrontMax = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label387;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label398;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label409;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label420;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label431;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.tempLeft = 0;
      if (i != 0)
        break label509;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempRight = 0;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label587;
      localAirCondition8 = this.d;
    }
    label318: label329: label376: label509: AirCondition localAirCondition5;
    for (localAirCondition8.windLoop = 1; ; localAirCondition5.windLoop = 0)
    {
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.rearLock = -1;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label43;
      if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition13 = this.d;
        localAirCondition13.modeAuto = 1;
        break label69;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      this.d.windFrontMax = false;
      break label102;
      label387: this.d.windRear = false;
      break label119;
      label398: this.d.windUp = false;
      break label137;
      label409: this.d.windMid = false;
      break label154;
      label420: this.d.windDown = false;
      break label171;
      label431: if (i == 31)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.tempLeft = 65535;
        break label224;
      }
      if ((i >= 1) && (i <= 17))
      {
        this.d.tempLeft = (5 * (i + 35));
        break label224;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label224;
      if (i == 31)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempRight = 65535;
        break label246;
      }
      if ((i >= 1) && (i <= 17))
      {
        this.d.tempRight = (5 * (i + 35));
        break label246;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label246;
      label587: localAirCondition5 = this.d;
    }
  }

  public void ah()
  {
    this.cv.e(1);
    this.mHandler = new ch(this);
  }

  public void aj()
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 34:
    case 35:
    case 37:
    default:
    case 33:
    case 36:
    case 38:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 5)
      {
        byte[] arrayOfByte2 = new byte[5];
        int m = 0;
        int n = 0;
        while (m < 5)
        {
          arrayOfByte2[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
          if ((arrayOfByte2[m] != this.cB[m]) && (m != 3))
            n = 1;
          this.cB[m] = arrayOfByte2[m];
          m++;
        }
        if (((0x10 & arrayOfByte2[1]) != 0) && (n != 0))
        {
          m(arrayOfByte2);
          this.cv.a(this.d);
        }
        int i1 = -40 + (0xFF & arrayOfByte2[3]);
        StringBuilder localStringBuilder1;
        Locale localLocale1;
        Object[] arrayOfObject1;
        if ((0xF0 & arrayOfByte2[4]) != 240)
        {
          localStringBuilder1 = new StringBuilder();
          localLocale1 = Locale.US;
          arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(i1);
        }
        StringBuilder localStringBuilder2;
        Locale localLocale2;
        Object[] arrayOfObject2;
        for (String str = String.format(localLocale1, " %d", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099651))
        {
          Intent localIntent2 = new Intent("com.canbus.temperature");
          localIntent2.putExtra("temperature", str);
          this.mContext.sendBroadcast(localIntent2);
          break;
          localStringBuilder2 = new StringBuilder();
          localLocale2 = Locale.US;
          arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(i1);
        }
        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
        {
          byte[] arrayOfByte1 = new byte[2];
          for (int k = 0; k < 2; k++)
            arrayOfByte1[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
          n(arrayOfByte1);
          if (this.mHandler != null)
            if ((0x1 & arrayOfByte1[0]) != 0)
            {
              this.mHandler.removeMessages(0);
              this.mHandler.sendEmptyMessageDelayed(0, 10L);
            }
            else
            {
              this.mHandler.removeMessages(0);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int i = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                if (i >= 32768)
                  i += 0;
                int j = i * 30 / 450;
                Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                localIntent1.putExtra("canbustype", this.e);
                localIntent1.putExtra("lfribackview", 0 - j);
                this.mContext.sendBroadcast(localIntent1);
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
    label29: boolean bool4;
    label40: boolean bool5;
    label52: boolean bool6;
    if ((0x1 & paramArrayOfByte[bool1]) != 0)
    {
      bool2 = bool1;
      if ((0x2 & paramArrayOfByte[bool1]) == 0)
        break label108;
      bool3 = bool1;
      if ((0x4 & paramArrayOfByte[bool1]) == 0)
        break label114;
      bool4 = bool1;
      if ((0x8 & paramArrayOfByte[bool1]) == 0)
        break label120;
      bool5 = bool1;
      if ((0x10 & paramArrayOfByte[bool1]) == 0)
        break label126;
      bool6 = bool1;
      label64: if ((0x0 & paramArrayOfByte[bool1]) == 0)
        break label132;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label108: bool3 = false;
      break label29;
      label114: bool4 = false;
      break label40;
      label120: bool5 = false;
      break label52;
      label126: bool6 = false;
      break label64;
      label132: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cg
 * JD-Core Version:    0.6.2
 */