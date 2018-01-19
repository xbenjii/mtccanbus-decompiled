package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import java.util.Locale;

public class ak extends a
{
  byte[] cB = new byte[8];
  private boolean dp = true;
  private boolean dq = true;

  public ak(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 26;
    this.d = new AirCondition();
    this.aB = new Door();
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
    label34: label59: label75: label92: label109: label126: int i;
    label143: label160: label214: int j;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label356;
      this.d.modeAc = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label367;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 2;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label414;
      this.d.modeDual = 1;
      if ((0x10 & paramArrayOfByte[1]) == 0)
        break label425;
      this.d.windFrontMax = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label436;
      this.d.windRear = true;
      if ((0x10 & paramArrayOfByte[4]) == 0)
        break label447;
      this.d.windUp = true;
      if ((0x20 & paramArrayOfByte[4]) == 0)
        break label458;
      this.d.windMid = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label469;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[4]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 1)
        break label480;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 1)
        break label558;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = 0;
      label246: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label636;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 2;
      label272: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label685;
      this.d.rearLock = 1;
      label290: if ((0x2 & paramArrayOfByte[0]) == 0)
        break label696;
    }
    label414: label425: label436: label696: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = ((0xC & paramArrayOfByte[1]) >> 2);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[1]);
      this.cv.a(this.d);
      return;
      this.d.onOff = false;
      break;
      label356: this.d.modeAc = false;
      break label34;
      label367: if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.modeAuto = 1;
        break label59;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label59;
      this.d.modeDual = 0;
      break label75;
      this.d.windFrontMax = false;
      break label92;
      this.d.windRear = false;
      break label109;
      label447: this.d.windUp = false;
      break label126;
      label458: this.d.windMid = false;
      break label143;
      label469: this.d.windDown = false;
      break label160;
      label480: if (i == 255)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempLeft = 65535;
        break label214;
      }
      if ((i >= 2) && (i <= 254))
      {
        this.d.tempLeft = (i * 10);
        break label214;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempLeft = -1;
      break label214;
      if (j == 255)
      {
        AirCondition localAirCondition7 = this.d;
        localAirCondition7.tempRight = 65535;
        break label246;
      }
      if ((j >= 2) && (j <= 254))
      {
        this.d.tempRight = (j * 10);
        break label246;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempRight = -1;
      break label246;
      label636: if ((0x10 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.windLoop = 1;
        break label272;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 0;
      break label272;
      this.d.rearLock = 0;
      break label290;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 1, 45, 1, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 48;
      arrayOfByte[2] = ((byte)(paramByte2 + 49));
      if (this.e == 26)
      {
        arrayOfByte[1] = 32;
        arrayOfByte[2] = 32;
      }
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
        this.cv.b((byte)-46, arrayOfByte, 13);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 - 2));
    arrayOfByte[1] = 48;
    arrayOfByte[2] = ((byte)(paramByte2 + 49));
    if (this.e == 26)
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
    }
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
    byte[] arrayOfByte = new byte[13];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 32;
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    arrayOfByte[11] = 32;
    arrayOfByte[12] = 32;
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
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
    byte[] arrayOfByte = { 12, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 13, 32, 109, 111, 118, 105, 101, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 7, 68, 86, 68, 58, 32, 32, 58, 32, 32, 32, 32, 32 };
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 % 60 % 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[13];
    arrayOfByte[0] = 13;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = 32;
    arrayOfByte[3] = 32;
    arrayOfByte[4] = 32;
    int i = paramInt3 / 1000;
    arrayOfByte[5] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[6] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[7] = 58;
    arrayOfByte[8] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[9] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[10] = 58;
    arrayOfByte[11] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[12] = ((byte)(48 + i % 60 % 10));
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    byte[] arrayOfByte4;
    int i4;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      if (paramArrayOfByte[(paramInt1 + 2)] == 10)
      {
        arrayOfByte4 = new byte[11];
        arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 1)];
        i4 = 0;
      }
      break;
    case 114:
      while (true)
        if (i4 < 10)
        {
          arrayOfByte4[(i4 + 1)] = paramArrayOfByte[(i4 + (paramInt1 + 3))];
          i4++;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 14)
          {
            int m = 0xFF & paramArrayOfByte[(paramInt1 + 7)];
            int n = 0xFF & paramArrayOfByte[(paramInt1 + 8)];
            if ((m != 255) || (n != 255))
            {
              int i1 = 256;
              if (m == 255)
                i1 = n;
              if (n == 255)
                i1 = 0 - m;
              if (i1 != 256)
              {
                int i3 = i1 * 30 / 135;
                Intent localIntent2 = new Intent("com.microntek.canbusbackview");
                localIntent2.putExtra("canbustype", this.e);
                localIntent2.putExtra("lfribackview", i3);
                this.mContext.sendBroadcast(localIntent2);
              }
            }
            if ((byte)(0x20 & paramArrayOfByte[(paramInt1 + 3)]) == 32)
            {
              for (int i2 = 0; i2 <= 7; i2++)
                this.cw[i2] = paramArrayOfByte[(i2 + (paramInt1 + 9))];
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
              if (this.cv.l() != 0)
                break label486;
              this.aY.zero_show = false;
              c(this.aY);
            }
          }
        }
    case 115:
    case 71:
    case -16:
    }
    while (true)
    {
      return;
      label486: this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 8)
      {
        byte[] arrayOfByte3 = new byte[8];
        int j = 0;
        int k = 0;
        while (j < 8)
        {
          arrayOfByte3[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
          if (arrayOfByte3[j] != this.cB[j])
            k = 1;
          this.cB[j] = arrayOfByte3[j];
          j++;
        }
        if ((k != 0) && ((0x80 & arrayOfByte3[0]) != 0))
          m(arrayOfByte3);
        if ((0x1 & arrayOfByte3[7]) != 0)
          n(arrayOfByte3);
        float f = 0.5F * (0xFF & arrayOfByte3[6]) - 40.0F;
        StringBuilder localStringBuilder = new StringBuilder();
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(f);
        String str = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651);
        Intent localIntent1 = new Intent("com.canbus.temperature");
        localIntent1.putExtra("temperature", str);
        this.mContext.sendBroadcast(localIntent1);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 14)
        {
          byte[] arrayOfByte2 = new byte[2];
          arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 1)];
          arrayOfByte2[1] = paramArrayOfByte[(paramInt1 + 16)];
          this.cv.d(arrayOfByte2);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 17)
          {
            byte[] arrayOfByte1 = new byte[18];
            arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 1)];
            while (i < 17)
            {
              arrayOfByte1[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            this.cv.d(arrayOfByte1);
            continue;
            this.cv.d(arrayOfByte4);
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
    label34: boolean bool4;
    label47: boolean bool5;
    label60: boolean bool6;
    if ((0x40 & paramArrayOfByte[7]) != 0)
    {
      bool2 = bool1;
      if ((0x80 & paramArrayOfByte[7]) == 0)
        break label118;
      bool3 = bool1;
      if ((0x20 & paramArrayOfByte[7]) == 0)
        break label124;
      bool4 = bool1;
      if ((0x10 & paramArrayOfByte[7]) == 0)
        break label130;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[7]) == 0)
        break label136;
      bool6 = bool1;
      label73: if ((0x4 & paramArrayOfByte[7]) == 0)
        break label142;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label118: bool3 = false;
      break label34;
      label124: bool4 = false;
      break label47;
      label130: bool5 = false;
      break label60;
      label136: bool6 = false;
      break label73;
      label142: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ak
 * JD-Core Version:    0.6.2
 */