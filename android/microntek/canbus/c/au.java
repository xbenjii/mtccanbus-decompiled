package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;

public class au extends a
{
  byte[] cB = new byte[9];
  private boolean dn = false;

  public au(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 36;
    this.d = new AirCondition();
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label103: label121: boolean bool;
    label138: label155: label194: int i;
    label232: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label334;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label345;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label363;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label374;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label385;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label396;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label407;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label418;
      bool = true;
      localAirCondition2.tempUnit = bool;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label424;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label506;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.tempRight = 0;
      label263: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label587;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 1;
      label289: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label607;
    }
    label334: label345: label607: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label43;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label363: this.d.modeDual = 0;
      break label85;
      label374: this.d.windFrontMax = false;
      break label103;
      this.d.windUp = false;
      break label121;
      this.d.windMid = false;
      break label138;
      this.d.windDown = false;
      break label155;
      bool = false;
      break label194;
      if (i == 255)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempLeft = 65535;
        break label232;
      }
      if ((i < 1) || (i > 254))
        break label232;
      if (this.d.tempUnit)
      {
        this.d.tempLeft = (i * 10);
        break label232;
      }
      this.d.tempLeft = (i * 5);
      break label232;
      label506: if (j == 31)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempRight = 65535;
        break label263;
      }
      if ((j < 1) || (j > 254))
        break label263;
      if (this.d.tempUnit)
      {
        this.d.tempRight = (j * 10);
        break label263;
      }
      this.d.tempRight = (j * 5);
      break label263;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label289;
    }
  }

  private void r(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label52: label78: label94: label112: boolean bool;
    label130: label147: label164: label203: int i;
    label249: int j;
    if (((0x80 & paramArrayOfByte[0]) != 0) && ((0x10 & paramArrayOfByte[1]) != 0))
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label351;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label362;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label380;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label391;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label402;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label413;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label424;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label435;
      bool = true;
      localAirCondition2.tempUnit = bool;
      if ((0x2 & paramArrayOfByte[4]) != 0)
        break label604;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label441;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label523;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempRight = 0;
      label280: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label641;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.windLoop = 1;
      label306: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label661;
    }
    label391: label402: label661: for (this.d.rearLock = 1; ; this.d.rearLock = 0)
    {
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.acMax = -1;
      return;
      this.d.onOff = false;
      break;
      label351: this.d.modeAc = false;
      break label52;
      label362: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label78;
      label380: this.d.modeDual = 0;
      break label94;
      this.d.windFrontMax = false;
      break label112;
      this.d.windUp = false;
      break label130;
      label413: this.d.windMid = false;
      break label147;
      label424: this.d.windDown = false;
      break label164;
      label435: bool = false;
      break label203;
      label441: if (i == 255)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempLeft = 65535;
        break label249;
      }
      if ((i < 1) || (i > 254))
        break label249;
      if (this.d.tempUnit)
      {
        this.d.tempLeft = (i * 10);
        break label249;
      }
      this.d.tempLeft = (i * 5);
      break label249;
      if (j == 31)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempRight = 65535;
        break label280;
      }
      if ((j < 1) || (j > 254))
        break label280;
      if (this.d.tempUnit)
      {
        this.d.tempRight = (j * 10);
        break label280;
      }
      this.d.tempRight = (j * 5);
      break label280;
      label604: AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label280;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 0;
      break label306;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 1))
    {
      arrayOfByte2[0] = ((byte)(paramByte1 + 1));
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte2[3] = ((byte)(paramByte1 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      byte[] arrayOfByte3 = { 1 };
      this.cv.a((byte)-126, arrayOfByte3, 1);
      return;
      if (paramByte1 == 2)
      {
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte2[3] = ((byte)(paramByte1 + 1));
      }
      else if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte2[0] = 16;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte2[3] = ((byte)(paramByte1 - 2));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte1 = { 6, 18 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[4] = -1;
    this.cv.a((byte)-61, arrayOfByte2, 6);
    byte[] arrayOfByte3 = { 7 };
    this.cv.a((byte)-126, arrayOfByte3, 1);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte1 = { 5, 64 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 5 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 80;
    if (!bool)
      if (this.hour <= 12)
        break label113;
    label113: for (this.hour = (128 + (-12 + this.hour)); ; this.hour = (128 + this.hour))
    {
      arrayOfByte[1] = ((byte)(0xFF & this.hour));
      arrayOfByte[2] = ((byte)(0xFF & this.minute));
      arrayOfByte[3] = 0;
      this.cv.a((byte)-58, arrayOfByte, 4);
      return;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte1 = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 3 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void al()
  {
    byte[] arrayOfByte1 = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 0 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void am()
  {
    byte[] arrayOfByte1 = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 0 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void an()
  {
    byte[] arrayOfByte1 = { 11, 48 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 6 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void ao()
  {
    byte[] arrayOfByte1 = { 8, 32 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 4 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void ap()
  {
    byte[] arrayOfByte1 = { 0, 32 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = { 0 };
    this.cv.a((byte)-126, arrayOfByte2, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 2, 16 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 0;
    arrayOfByte2[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[4] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 8, 17 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[4] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
    byte[] arrayOfByte3 = { 4 };
    this.cv.a((byte)-126, arrayOfByte3, 1);
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
      case 36:
      case 34:
      case 35:
      case 33:
      case 51:
      case 41:
      case -48:
      case 50:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte8 = new byte[1];
        arrayOfByte8[0] = ((byte)((byte)(0x80 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x40 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x20 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x10 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x8 & paramArrayOfByte[(paramInt1 + 3)])));
        n(arrayOfByte8);
        if ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 4)]) == 1)
        {
          this.dn = true;
        }
        else
        {
          this.dn = false;
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte7 = new byte[4];
            for (int i2 = 0; i2 < 4; i2++)
              arrayOfByte7[i2] = paramArrayOfByte[(i2 + (paramInt1 + 3))];
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte7[0];
            this.aY.b2 = arrayOfByte7[1];
            this.aY.b3 = arrayOfByte7[2];
            this.aY.b4 = arrayOfByte7[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte6 = new byte[4];
              for (int i1 = 0; i1 < 4; i1++)
                arrayOfByte6[i1] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte6[0];
              this.aY.f2 = arrayOfByte6[1];
              this.aY.f3 = arrayOfByte6[2];
              this.aY.f4 = arrayOfByte6[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 6)
              {
                byte[] arrayOfByte5 = new byte[6];
                while (i < 6)
                {
                  arrayOfByte5[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                m(arrayOfByte5);
                this.cv.a(this.d);
              }
              else if (paramArrayOfByte[(paramInt1 + 2)] == 9)
              {
                byte[] arrayOfByte4 = new byte[9];
                int n = 0;
                if (n < 9)
                {
                  arrayOfByte4[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
                  if (n >= 6);
                  while (true)
                  {
                    n++;
                    break;
                    if (arrayOfByte4[n] != this.cB[n])
                      i = 1;
                    this.cB[n] = arrayOfByte4[n];
                  }
                }
                if (i != 0)
                {
                  r(arrayOfByte4);
                  this.cv.a(this.d);
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 15) || (paramArrayOfByte[(paramInt1 + 2)] == 18))
                  {
                    byte[] arrayOfByte3 = new byte[1 + paramArrayOfByte[(paramInt1 + 2)]];
                    while (i < 1 + paramArrayOfByte[(paramInt1 + 2)])
                    {
                      arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 2))];
                      i++;
                    }
                    this.cv.d(arrayOfByte3);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                    {
                      int k = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                      if (k >= 32768)
                        k += 0;
                      int m = k * 30 / 4500;
                      Intent localIntent = new Intent("com.microntek.canbusbackview");
                      localIntent.putExtra("canbustype", this.e);
                      localIntent.putExtra("lfribackview", m);
                      this.mContext.sendBroadcast(localIntent);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                      {
                        byte[] arrayOfByte2 = new byte[4];
                        arrayOfByte2[0] = -48;
                        arrayOfByte2[1] = 2;
                        while (i < 2)
                        {
                          arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte2);
                        continue;
                        int j = 0xF & paramArrayOfByte[(paramInt1 + 2)];
                        byte[] arrayOfByte1 = new byte[j + 2];
                        arrayOfByte1[0] = 50;
                        arrayOfByte1[1] = ((byte)j);
                        while (i < j)
                        {
                          arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte1);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.au
 * JD-Core Version:    0.6.2
 */