package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import java.util.Arrays;
import java.util.Locale;

public class as extends a
{
  public as(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 34;
    this.d = new AirCondition();
  }

  private int i(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
      paramInt2 = 20;
    while (true)
    {
      return paramInt2;
      if (paramInt2 > 30)
        paramInt2 = 30;
    }
  }

  private int j(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 1)
    {
      i = 0;
      if (paramInt2 < 254)
        i = paramInt2 * 20 / 254;
    }
    while (true)
    {
      return i;
      i = 0;
      if (paramInt1 == 0)
        if (paramInt2 <= 29)
        {
          i = paramInt2 + 1;
        }
        else
        {
          i = 0;
          if (paramInt2 < 254)
            i = paramInt2 * 30 / 254;
        }
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    this.d.onOff = true;
    if ((0x1 & paramArrayOfByte[1]) != 0)
    {
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[1]) == 0)
        break label261;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      label57: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label279;
      this.d.windFrontMax = true;
      label74: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label290;
      this.d.windRear = true;
      label91: if ((0x8 & paramArrayOfByte[1]) == 0)
        break label301;
      this.d.windMid = true;
      label108: if ((0x10 & paramArrayOfByte[1]) == 0)
        break label312;
      this.d.windDown = true;
      label125: this.d.windLevel = (0xF & paramArrayOfByte[2]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[0];
      this.d.tempLeft = k(i, 0xF & paramArrayOfByte[3]);
      this.d.tempRight = this.d.tempLeft;
      if ((0x80 & paramArrayOfByte[1]) != 0)
        break label323;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      label216: AirCondition localAirCondition3 = this.d;
      localAirCondition3.DIS_IMG1 = 1;
      if ((0x2 & paramArrayOfByte[1]) == 0)
        break label343;
    }
    label261: label279: label290: label301: label312: label323: label343: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      return;
      this.d.modeAc = false;
      break;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label57;
      this.d.windFrontMax = false;
      break label74;
      this.d.windRear = false;
      break label91;
      this.d.windMid = false;
      break label108;
      this.d.windDown = false;
      break label125;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label216;
    }
  }

  private void q(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    if ((0xF & paramArrayOfByte[2]) != 0)
    {
      this.d.onOff = true;
      if ((0x1 & paramArrayOfByte[1]) == 0)
        break label304;
      this.d.modeAc = true;
      label41: if ((0x4 & paramArrayOfByte[1]) == 0)
        break label315;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      label66: if ((0x20 & paramArrayOfByte[2]) == 0)
        break label333;
      this.d.modeDual = 1;
      label83: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label344;
      this.d.windFrontMax = true;
      label100: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label355;
      this.d.windRear = true;
      label117: if ((0x8 & paramArrayOfByte[1]) == 0)
        break label366;
      this.d.windMid = true;
      label134: if ((0x10 & paramArrayOfByte[1]) == 0)
        break label377;
      this.d.windDown = true;
      label151: this.d.windLevel = (0xF & paramArrayOfByte[2]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[0];
      this.d.tempLeft = k(i, 0xF & paramArrayOfByte[3]);
      int j = 0xFF & paramArrayOfByte[6];
      this.d.tempRight = k(j, 0xF & paramArrayOfByte[3] >> 4);
      if ((0x80 & paramArrayOfByte[1]) != 0)
        break label388;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      label259: AirCondition localAirCondition3 = this.d;
      localAirCondition3.DIS_IMG1 = 1;
      if ((0x2 & paramArrayOfByte[1]) == 0)
        break label408;
    }
    label388: label408: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label304: this.d.modeAc = false;
      break label41;
      label315: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label66;
      label333: this.d.modeDual = 0;
      break label83;
      label344: this.d.windFrontMax = false;
      break label100;
      label355: this.d.windRear = false;
      break label117;
      label366: this.d.windMid = false;
      break label134;
      label377: this.d.windDown = false;
      break label151;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label259;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 1, 45, 1, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = 70;
      arrayOfByte[1] = 77;
      arrayOfByte[2] = ((byte)(paramByte1 + 49));
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = 77;
        arrayOfByte[10] = 72;
        arrayOfByte[11] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.e((byte)7, arrayOfByte, 12);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
      }
    arrayOfByte[0] = 65;
    arrayOfByte[1] = 77;
    arrayOfByte[2] = ((byte)(paramByte1 + 46));
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[9] = 75;
      arrayOfByte[10] = 72;
      arrayOfByte[11] = 90;
      break;
      arrayOfByte[5] = ((byte)(48 + paramInt / 100));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 73, 80, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[5] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[6] = 58;
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[8] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[9] = 58;
    arrayOfByte[10] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[11] = ((byte)(48 + i % 60 % 10));
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 32, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = { 32, 32, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void al()
  {
    byte[] arrayOfByte = { 32, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void am()
  {
    byte[] arrayOfByte = { 32, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void an()
  {
    byte[] arrayOfByte = { 32, 32, 65, 50, 68, 80, 32, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 32, 32, 77, 79, 86, 73, 69, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    arrayOfByte[2] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    arrayOfByte[3] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    arrayOfByte[4] = 58;
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    arrayOfByte[7] = 58;
    arrayOfByte[8] = ((byte)(48 + paramInt2 % 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 83, 68, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.e((byte)7, arrayOfByte, 12);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder1;
    Locale localLocale1;
    Object[] arrayOfObject1;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 16:
    case 19:
      do
        while (true)
        {
          return;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
          {
            byte[] arrayOfByte2 = Arrays.copyOfRange(paramArrayOfByte, paramInt1 + 3, paramInt2);
            if ((0x80 & arrayOfByte2[2]) != 0)
            {
              float f = (0xFF & arrayOfByte2[0]) + 0.1F * (0xF & arrayOfByte2[3]);
              StringBuilder localStringBuilder2 = new StringBuilder();
              Locale localLocale2 = Locale.US;
              Object[] arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = Float.valueOf(f - 100.0F);
              String str2 = String.format(localLocale2, " %.0f", arrayOfObject2) + this.mContext.getString(2131099651);
              Intent localIntent2 = new Intent("com.canbus.temperature");
              localIntent2.putExtra("temperature", str2);
              this.mContext.sendBroadcast(localIntent2);
            }
            else if (j(arrayOfByte2))
            {
              m(arrayOfByte2);
              this.cv.a(this.d);
            }
          }
        }
      while (paramArrayOfByte[(paramInt1 + 2)] < 6);
      int k = 0xF & paramArrayOfByte[(paramInt1 + 2)];
      byte[] arrayOfByte1 = new byte[k + 3];
      int m = 0;
      if (m < k)
      {
        if (m == 5);
        while (true)
        {
          m++;
          break;
          arrayOfByte1[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
        }
      }
      if (j(arrayOfByte1))
      {
        q(arrayOfByte1);
        this.cv.a(this.d);
      }
      int n = 0x7F & paramArrayOfByte[(5 + (paramInt1 + 2))];
      if (n != 127)
      {
        if ((0x80 & paramArrayOfByte[(5 + (paramInt1 + 2))]) != 0)
          n = 0 - n;
        localStringBuilder1 = new StringBuilder();
        localLocale1 = Locale.US;
        arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(n);
      }
      break;
    case 41:
    case 50:
    }
    for (String str1 = String.format(localLocale1, " %d", arrayOfObject1) + this.mContext.getString(2131099651); ; str1 = "")
    {
      Intent localIntent1 = new Intent("com.canbus.temperature");
      localIntent1.putExtra("temperature", str1);
      this.mContext.sendBroadcast(localIntent1);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] < 2)
        break;
      int j = (0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 3)];
      if ((j < 2064) || (j > 13424))
        break;
      o(0 - 30 * (-5680 + (j - 2063)) / 5680);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] < 6)
        break;
      for (int i = 0; i < 6; i++)
        this.cw[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
      this.aY.max = i(0xFF & this.cw[0], 0xFF & this.cw[1]);
      this.aY.back_cnt = 4;
      this.aY.b1 = j(0xFF & this.cw[0], 0xFF & this.cw[2]);
      this.aY.b2 = j(0xFF & this.cw[0], 0xFF & this.cw[3]);
      this.aY.b3 = j(0xFF & this.cw[0], 0xFF & this.cw[4]);
      this.aY.b4 = j(0xFF & this.cw[0], 0xFF & this.cw[5]);
      this.cv.a(this.aY);
      break;
    }
  }

  int k(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt1 == 255)
        i = 65535;
      else if ((paramInt1 >= 0) && (paramInt1 < 100))
        i = paramInt2 + paramInt1 * 10;
      else if (paramInt1 == 254);
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.as
 * JD-Core Version:    0.6.2
 */