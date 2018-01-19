package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class h extends a
{
  private byte[] cB = new byte[5];

  public h(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 8;
    this.d = new AirCondition();
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    AirCondition localAirCondition1 = this.d;
    localAirCondition1.windLoop = -1;
    label58: label84: label100: label118: int k;
    label135: label153: label170: label187: int m;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label316;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label327;
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label347;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label358;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label369;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label380;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label391;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label402;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      if ((0x1 & paramArrayOfByte[4]) != 0)
        break label625;
      this.d.tempUnit = false;
      k = 0xFF & paramArrayOfByte[2];
      if (k != 0)
        break label413;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.tempLeft = 0;
      label256: m = 0xFF & paramArrayOfByte[3];
      if (m != 0)
        break label519;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempRight = 0;
      label287: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label786;
    }
    label391: label786: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label316: this.d.modeAc = false;
      break label58;
      label327: AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeAuto = 0;
      break label84;
      label347: this.d.modeDual = 0;
      break label100;
      label358: this.d.windFrontMax = false;
      break label118;
      label369: this.d.windRear = false;
      break label135;
      label380: this.d.windUp = false;
      break label153;
      this.d.windMid = false;
      break label170;
      label402: this.d.windDown = false;
      break label187;
      label413: if (k == 31)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.tempLeft = 65535;
        break label256;
      }
      if ((k >= 1) && (k <= 29))
      {
        this.d.tempLeft = (5 * (k + 35));
        break label256;
      }
      if ((k >= 32) && (k <= 35))
      {
        this.d.tempLeft = (k * 5);
        break label256;
      }
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.tempLeft = -1;
      break label256;
      if (m == 31)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempRight = 65535;
        break label287;
      }
      if ((m >= 1) && (m <= 29))
      {
        this.d.tempRight = (5 * (m + 35));
        break label287;
      }
      if ((m >= 32) && (m <= 35))
      {
        this.d.tempRight = (m * 5);
        break label287;
      }
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.tempRight = -1;
      break label287;
      label625: this.d.tempUnit = true;
      int i = 0xFF & paramArrayOfByte[2];
      if (i == 0)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.tempLeft = 0;
      }
      int j;
      while (true)
      {
        j = 0xFF & paramArrayOfByte[3];
        if (j != 0)
          break label742;
        AirCondition localAirCondition4 = this.d;
        localAirCondition4.tempRight = 0;
        break;
        if (i == 255)
        {
          AirCondition localAirCondition5 = this.d;
          localAirCondition5.tempLeft = 65535;
        }
        else
        {
          this.d.tempLeft = (i * 10);
        }
      }
      label742: if (j == 255)
      {
        AirCondition localAirCondition3 = this.d;
        localAirCondition3.tempRight = 65535;
        break label287;
      }
      this.d.tempRight = (j * 10);
      break label287;
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
    this.cv.d(1);
    this.cv.e(1);
    ai();
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      this.cv.a((byte)-125, new byte[] { 36, 0 }, 2);
    while (true)
    {
      return;
      if (str.equals("en"))
        this.cv.a((byte)-125, new byte[] { 36, 1 }, 2);
    }
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
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 40:
    case 36:
    case 49:
    case 50:
    case 30:
    case 29:
    case 31:
    case 33:
    case 34:
    case 35:
    case 37:
    case 38:
    case 39:
    case 41:
    case 80:
    case 26:
    case 65:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 5)
      {
        byte[] arrayOfByte13 = new byte[5];
        for (int i1 = 0; i1 < 5; i1++)
        {
          arrayOfByte13[i1] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
          if (arrayOfByte13[i1] != this.cB[i1])
            i = 1;
          this.cB[i1] = arrayOfByte13[i1];
        }
        if ((i != 0) && ((0x10 & arrayOfByte13[1]) != 0))
        {
          m(arrayOfByte13);
          this.cv.a(this.d);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 2)
          {
            byte[] arrayOfByte11 = new byte[2];
            for (int n = 0; n < 2; n++)
              arrayOfByte11[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
            n(arrayOfByte11);
            byte[] arrayOfByte12 = new byte[3];
            arrayOfByte12[0] = 36;
            arrayOfByte12[1] = 1;
            arrayOfByte12[2] = arrayOfByte11[1];
            this.cv.d(arrayOfByte12);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 5)
            {
              continue;
              e(paramArrayOfByte, paramInt1, paramInt2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 5)
              {
                e(paramArrayOfByte, paramInt1, paramInt2);
                if (this.cv.l() != 0)
                {
                  byte[] arrayOfByte10 = new byte[4];
                  for (int m = 0; m < 4; m++)
                    arrayOfByte10[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
                  this.aY.max = 4;
                  this.aY.back_cnt = 4;
                  this.aY.b1 = arrayOfByte10[0];
                  this.aY.b2 = arrayOfByte10[1];
                  this.aY.b3 = arrayOfByte10[2];
                  this.aY.b4 = arrayOfByte10[3];
                  this.cv.a(this.aY);
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 4) && (this.cv.l() != 0))
                  {
                    byte[] arrayOfByte9 = new byte[4];
                    for (int k = 0; k < 4; k++)
                      arrayOfByte9[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
                    this.aY.max = 4;
                    this.aY.front_cnt = 4;
                    this.aY.f1 = arrayOfByte9[0];
                    this.aY.f2 = arrayOfByte9[1];
                    this.aY.f3 = arrayOfByte9[2];
                    this.aY.f4 = arrayOfByte9[3];
                    this.cv.a(this.aY);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                    {
                      byte[] arrayOfByte8 = new byte[4];
                      arrayOfByte8[0] = 31;
                      arrayOfByte8[1] = 2;
                      while (i < 2)
                      {
                        arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.d(arrayOfByte8);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 7)
                      {
                        byte[] arrayOfByte7 = new byte[9];
                        arrayOfByte7[0] = 33;
                        arrayOfByte7[1] = 7;
                        while (i < 7)
                        {
                          arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte7);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                        {
                          byte[] arrayOfByte6 = new byte[5];
                          arrayOfByte6[0] = 34;
                          arrayOfByte6[1] = 3;
                          while (i < 3)
                          {
                            arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.d(arrayOfByte6);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] == 13)
                          {
                            byte[] arrayOfByte5 = new byte[15];
                            arrayOfByte5[0] = 35;
                            arrayOfByte5[1] = 13;
                            while (i < 13)
                            {
                              arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.d(arrayOfByte5);
                            continue;
                            if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                            {
                              byte[] arrayOfByte4 = new byte[8];
                              arrayOfByte4[0] = 37;
                              arrayOfByte4[1] = 6;
                              while (i < 6)
                              {
                                arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.d(arrayOfByte4);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                              {
                                byte[] arrayOfByte3 = new byte[6];
                                arrayOfByte3[0] = 38;
                                arrayOfByte3[1] = 4;
                                while (i < 4)
                                {
                                  arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.d(arrayOfByte3);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] == 31)
                                {
                                  byte[] arrayOfByte2 = new byte[33];
                                  arrayOfByte2[0] = 39;
                                  arrayOfByte2[1] = 31;
                                  while (i < 31)
                                  {
                                    arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.d(arrayOfByte2);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                                  {
                                    int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                                    if (j >= 2048)
                                      j -= 4096;
                                    Intent localIntent = new Intent("com.microntek.canbusbackview");
                                    localIntent.putExtra("canbustype", this.e);
                                    localIntent.putExtra("lfribackview", (0 - j) / 10);
                                    this.mContext.sendBroadcast(localIntent);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                                    {
                                      byte[] arrayOfByte1 = new byte[2];
                                      arrayOfByte1[0] = 80;
                                      arrayOfByte1[1] = paramArrayOfByte[(paramInt1 + 3)];
                                      this.cv.d(arrayOfByte1);
                                      continue;
                                      e(paramArrayOfByte, paramInt1, paramInt2);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.h
 * JD-Core Version:    0.6.2
 */