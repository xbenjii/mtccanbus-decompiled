package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;
import java.util.Locale;

public class cy extends a
{
  public cy(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 82;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label42: label68: label84: label100: label116: int i;
    label132: label148: label169: boolean bool;
    label202: AirCondition localAirCondition6;
    if ((0xF & paramArrayOfByte[2]) > 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label308;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label319;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.modeAuto = 1;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label337;
      this.d.windFrontMax = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label348;
      this.d.windRear = true;
      if ((0x1 & paramArrayOfByte[1]) == 0)
        break label359;
      this.d.windUp = true;
      if ((0x2 & paramArrayOfByte[1]) == 0)
        break label370;
      this.d.windMid = true;
      if ((0x4 & paramArrayOfByte[1]) == 0)
        break label381;
      this.d.windDown = true;
      AirCondition localAirCondition2 = this.d;
      if ((0xF & paramArrayOfByte[2]) != 8)
        break label392;
      i = 7;
      localAirCondition2.windLevel = i;
      this.d.windLevelMax = 7;
      AirCondition localAirCondition3 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label403;
      bool = true;
      localAirCondition3.tempUnit = bool;
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempLeft = x(j);
      int k = 0xFF & paramArrayOfByte[4];
      this.d.tempRight = x(k);
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label409;
      localAirCondition6 = this.d;
    }
    label308: label319: label337: label348: label359: label370: label381: AirCondition localAirCondition4;
    for (localAirCondition6.windLoop = 1; ; localAirCondition4.windLoop = 0)
    {
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label42;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label68;
      this.d.windFrontMax = false;
      break label84;
      this.d.windRear = false;
      break label100;
      this.d.windUp = false;
      break label116;
      this.d.windMid = false;
      break label132;
      this.d.windDown = false;
      break label148;
      label392: i = 0xF & paramArrayOfByte[2];
      break label169;
      label403: bool = false;
      break label202;
      label409: localAirCondition4 = this.d;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 1;
    arrayOfByte[4] = ((byte)(paramByte2 + 1));
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[1] = ((byte)(paramByte1 + 1));
      arrayOfByte[2] = ((byte)(paramInt & 0xFF));
      arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 5);
      return;
      if (paramByte1 == 3)
      {
        arrayOfByte[1] = 17;
        arrayOfByte[2] = ((byte)(paramInt & 0xFF));
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
      }
      else if (paramByte1 == 4)
      {
        arrayOfByte[1] = 18;
        arrayOfByte[2] = ((byte)(paramInt & 0xFF));
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 5, 4, 1, 66, 84 };
    this.cv.a((byte)-64, arrayOfByte, 5);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    ai();
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      this.cv.a((byte)-125, new byte[] { 13, 0 }, 2);
    while (true)
    {
      return;
      if (str.equals("en"))
        this.cv.a((byte)-125, new byte[] { 13, 1 }, 2);
    }
  }

  public void aj()
  {
  }

  public void ak()
  {
    this.cv.a((byte)-64, new byte[] { 7 }, 1);
  }

  public void al()
  {
    ak();
  }

  public void am()
  {
    ak();
  }

  public void an()
  {
    ak();
  }

  public void ap()
  {
    this.cv.a((byte)-64, new byte[] { 0 }, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ak();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[5] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 40:
      case 56:
      case 34:
      case 35:
      case 48:
      case 113:
      case -127:
      case 33:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte7 = new byte[1];
        arrayOfByte7[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte7);
        int i5 = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
        String str2 = "";
        if ((i5 != 255) && (i5 != 254))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(i5 - 40);
          str2 = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
        }
        Intent localIntent2 = new Intent("com.canbus.temperature");
        localIntent2.putExtra("temperature", str2);
        this.mContext.sendBroadcast(localIntent2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 8)
        {
          byte[] arrayOfByte6 = new byte[10];
          arrayOfByte6[0] = 56;
          arrayOfByte6[1] = 8;
          while (i < 8)
          {
            arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.d(arrayOfByte6);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte5 = new byte[4];
            int i3 = 0;
            if (i3 < 4)
            {
              if (paramArrayOfByte[(i3 + (paramInt1 + 3))] == 0);
              for (int i4 = 0; ; i4 = 5 - paramArrayOfByte[(i3 + (paramInt1 + 3))])
              {
                arrayOfByte5[i3] = ((byte)i4);
                i3++;
                break;
              }
            }
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte5[0];
            this.aY.b2 = arrayOfByte5[1];
            this.aY.b3 = arrayOfByte5[2];
            this.aY.b4 = arrayOfByte5[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte4 = new byte[4];
              int i1 = 0;
              if (i1 < 4)
              {
                if (paramArrayOfByte[(i1 + (paramInt1 + 3))] == 0);
                for (int i2 = 0; ; i2 = 5 - paramArrayOfByte[(i1 + (paramInt1 + 3))])
                {
                  arrayOfByte4[i1] = ((byte)i2);
                  i1++;
                  break;
                }
              }
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte4[0];
              this.aY.f2 = arrayOfByte4[1];
              this.aY.f3 = arrayOfByte4[2];
              this.aY.f4 = arrayOfByte4[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int k = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
                int m = 0xFF & paramArrayOfByte[(paramInt1 + 4)] | (k & 0x7F) << 8;
                if ((k & 0x80) == 0)
                  m = 0 - m;
                int n = m * 30 / 5400;
                Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                localIntent1.putExtra("canbustype", this.e);
                localIntent1.putExtra("lfribackview", n);
                this.mContext.sendBroadcast(localIntent1);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 7)
                {
                  byte[] arrayOfByte3 = new byte[9];
                  arrayOfByte3[0] = 113;
                  arrayOfByte3[1] = 7;
                  while (i < 7)
                  {
                    arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.d(arrayOfByte3);
                  continue;
                  int j = 0xF & paramArrayOfByte[(paramInt1 + 2)];
                  if ((j == 7) || (j == 8))
                  {
                    String str1 = "129,8,";
                    byte[] arrayOfByte2 = new byte[j + 2];
                    arrayOfByte2[0] = -127;
                    arrayOfByte2[1] = ((byte)j);
                    while (i < j)
                    {
                      str1 = str1 + (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]) + ",";
                      arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.d(arrayOfByte2);
                    Settings.System.putString(this.cv.getContentResolver(), "Canbus82Data81", str1);
                    continue;
                    if ((0xF & paramArrayOfByte[(paramInt1 + 2)]) >= 5)
                    {
                      byte[] arrayOfByte1 = new byte[5];
                      while (i < 5)
                      {
                        arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      m(arrayOfByte1);
                      if (j(arrayOfByte1))
                        this.cv.a(this.d);
                    }
                  }
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
    if (paramInt == 254)
      paramInt = 0;
    while (true)
    {
      return paramInt;
      if (paramInt == 255)
        paramInt = 65535;
      else if ((paramInt >= 36) && (paramInt <= 52))
        paramInt = paramInt * 10 / 2;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cy
 * JD-Core Version:    0.6.2
 */