package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import java.util.Locale;

public class al extends a
{
  public al(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 27;
  }

  private int A(int paramInt)
  {
    int i = 10;
    int j = paramInt & 0xFF;
    if ((j > 150) || (j == 0))
      i = 0;
    while (true)
    {
      return i / 10;
      if (j >= i)
        i = j;
    }
  }

  private void c(Radar paramRadar)
  {
    this.cv.a(paramRadar);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label49: label77: label94: label111: int i;
    label204: label225: AirCondition localAirCondition4;
    if (((byte)(0x40 & paramArrayOfByte[0]) == 64) && ((byte)(0x80 & paramArrayOfByte[0]) == -128))
    {
      this.d.onOff = true;
      if ((0x3 & paramArrayOfByte[0]) == 0)
        break label351;
      this.d.modeAc = true;
      if ((0x1F & paramArrayOfByte[5]) != 19)
        break label362;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 2;
      if ((0x10 & paramArrayOfByte[2]) == 0)
        break label380;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[2]) == 0)
        break label391;
      this.d.windRear = true;
      switch (0xF & paramArrayOfByte[4])
      {
      case 4:
      case 7:
      case 8:
      case 9:
      case 10:
      default:
        this.d.windUp = false;
        this.d.windDown = false;
        this.d.windMid = false;
        AirCondition localAirCondition2 = this.d;
        if ((0x1F & paramArrayOfByte[5]) >= 8)
        {
          i = 7;
          localAirCondition2.windLevel = i;
          this.d.windLevelMax = 7;
          int j = 0xFF & paramArrayOfByte[6];
          this.d.tempLeft = x(j);
          int k = 0xFF & paramArrayOfByte[7];
          this.d.tempRight = x(k);
          if ((0x10 & paramArrayOfByte[1]) == 0)
            break label602;
          localAirCondition4 = this.d;
        }
        break;
      case 3:
      case 5:
      case 6:
      case 11:
      case 12:
      case 13:
      case 14:
      }
    }
    label351: label362: label380: AirCondition localAirCondition3;
    for (localAirCondition4.windLoop = 1; ; localAirCondition3.windLoop = 0)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[2] >> 2);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[2]);
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label49;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label77;
      this.d.windFrontMax = false;
      break label94;
      label391: this.d.windRear = false;
      break label111;
      this.d.windUp = false;
      this.d.windDown = true;
      this.d.windMid = false;
      break label204;
      this.d.windUp = false;
      this.d.windDown = true;
      this.d.windMid = true;
      break label204;
      this.d.windUp = false;
      this.d.windDown = false;
      this.d.windMid = true;
      break label204;
      this.d.windUp = true;
      this.d.windDown = false;
      this.d.windMid = false;
      break label204;
      this.d.windUp = true;
      this.d.windDown = true;
      this.d.windMid = false;
      break label204;
      this.d.windUp = true;
      this.d.windDown = false;
      this.d.windMid = true;
      break label204;
      this.d.windUp = true;
      this.d.windDown = true;
      this.d.windMid = true;
      break label204;
      i = 0xF & paramArrayOfByte[5];
      break label225;
      label602: localAirCondition3 = this.d;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 1, 45, 1, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
        arrayOfByte[10] = 77;
        arrayOfByte[11] = 72;
        arrayOfByte[12] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.f((byte)-111, arrayOfByte, 14);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 + 1));
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 32;
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
    byte[] arrayOfByte = { 11, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void ah()
  {
    ai();
    this.cv.e(1);
    this.cv.d(1);
  }

  public void ai()
  {
    if (this.cv.getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
    {
      byte[] arrayOfByte1 = { 1, 2 };
      this.cv.f((byte)-102, arrayOfByte1, 2);
    }
    while (true)
    {
      return;
      byte[] arrayOfByte2 = { 1, 1 };
      this.cv.f((byte)-102, arrayOfByte2, 2);
    }
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 32, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 32, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 65, 50, 68, 80, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 13, 32, 109, 111, 118, 105, 101, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 7, 0, 32, 68, 58, 32, 32, 58, 32, 32, 32, 32, 32, 32 };
    if (paramInt1 > 0)
      arrayOfByte[1] = 1;
    arrayOfByte[2] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    arrayOfByte[3] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    arrayOfByte[4] = 58;
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    arrayOfByte[7] = 58;
    arrayOfByte[8] = ((byte)(48 + paramInt2 % 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 13, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.f((byte)-111, arrayOfByte, 14);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    byte[] arrayOfByte5;
    int i1;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      if (paramInt2 > 16)
        paramInt2 = 16;
      arrayOfByte5 = new byte[paramInt2];
      arrayOfByte5[0] = paramArrayOfByte[(paramInt1 + 1)];
      i1 = 3;
    case 18:
      while (true)
        if (i1 < paramInt2)
        {
          arrayOfByte5[(i1 - 2)] = paramArrayOfByte[(paramInt1 + i1)];
          i1++;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 10)
          {
            byte[] arrayOfByte3 = new byte[1];
            arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 5)];
            n(arrayOfByte3);
            byte[] arrayOfByte4 = new byte[11];
            arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 1)];
            while (i < 10)
            {
              arrayOfByte4[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            this.cv.d(arrayOfByte4);
          }
        }
    case 17:
    case 65:
    case 49:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 10)
      {
        int m = ((0xFF & paramArrayOfByte[(paramInt1 + 9)]) << 8) + (0xFF & paramArrayOfByte[(paramInt1 + 10)]);
        if (m >= 32768)
          m += 0;
        int n = m * 30 / 450;
        Intent localIntent2 = new Intent("com.microntek.canbusbackview");
        localIntent2.putExtra("canbustype", this.e);
        localIntent2.putExtra("lfribackview", n);
        this.mContext.sendBroadcast(localIntent2);
        byte[] arrayOfByte2 = new byte[11];
        arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 1)];
        while (i < 10)
        {
          arrayOfByte2[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.d(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 12)
        {
          for (int k = 0; k < 8; k++)
            this.cw[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
          this.aY.max = 15;
          this.aY.front_cnt = 4;
          this.aY.f1 = A(this.cw[4]);
          this.aY.f2 = A(this.cw[5]);
          this.aY.f3 = A(this.cw[6]);
          this.aY.f4 = A(this.cw[7]);
          this.aY.back_cnt = 4;
          this.aY.b1 = A(this.cw[0]);
          this.aY.b2 = A(this.cw[1]);
          this.aY.b3 = A(this.cw[2]);
          this.aY.b4 = A(this.cw[3]);
          if (this.cv.l() == 0);
          for (this.aY.zero_show = false; ; this.aY.zero_show = true)
          {
            c(this.aY);
            break;
          }
          if (paramArrayOfByte[(paramInt1 + 2)] == 12)
          {
            byte[] arrayOfByte1 = new byte[12];
            for (int j = 0; j < 12; j++)
              arrayOfByte1[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
            float f = 0.5F * (0xFF & paramArrayOfByte[(paramInt1 + 14)]) - 40.0F;
            StringBuilder localStringBuilder = new StringBuilder();
            Locale localLocale = Locale.US;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Float.valueOf(f);
            String str = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651);
            if ((byte)(0x40 & arrayOfByte1[0]) != 64)
              str = "";
            Intent localIntent1 = new Intent("com.canbus.temperature");
            localIntent1.putExtra("temperature", str);
            this.mContext.sendBroadcast(localIntent1);
            m(arrayOfByte1);
            this.cv.a(this.d);
            continue;
            this.cv.d(arrayOfByte5);
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
    if (paramInt == 254)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 255)
        i = 65535;
      else
        i = paramInt * 10 / 2;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.al
 * JD-Core Version:    0.6.2
 */