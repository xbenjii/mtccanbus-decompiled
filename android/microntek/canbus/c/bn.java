package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class bn extends a
{
  private byte[] cB = new byte[6];
  private boolean dy = false;

  public bn(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 55;
    this.d = new AirCondition();
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { paramByte };
    this.cv.a((byte)-121, arrayOfByte, 1);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label67: label206: int i;
    label173: label237: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label367;
      this.d.modeAc = true;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeDual = -1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label378;
      this.d.windRear = true;
      switch (0xF & paramArrayOfByte[1])
      {
      default:
        AirCondition localAirCondition22 = this.d;
        localAirCondition22.modeAuto = 0;
        this.d.windFrontMax = false;
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        this.d.windLevel = (0x7 & paramArrayOfByte[0]);
        if (this.cv.y == 1)
        {
          this.d.windLevelMax = 6;
          i = 0xFF & paramArrayOfByte[2];
          if (i != 0)
            break label887;
          AirCondition localAirCondition13 = this.d;
          localAirCondition13.tempLeft = 0;
          j = 0xFF & paramArrayOfByte[3];
          if (j != 0)
            break label1065;
          AirCondition localAirCondition11 = this.d;
          localAirCondition11.tempRight = 0;
          label268: if ((0x8 & paramArrayOfByte[0]) == 0)
            break label1243;
          AirCondition localAirCondition9 = this.d;
          localAirCondition9.windLoop = 2;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
    }
    while (true)
    {
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.rearLock = -1;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.acMax = -1;
      this.d.seatHotLeft = ((0x30 & paramArrayOfByte[4]) >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[4]);
      return;
      this.d.onOff = false;
      break;
      label367: this.d.modeAc = false;
      break label35;
      label378: this.d.windRear = false;
      break label67;
      AirCondition localAirCondition21 = this.d;
      localAirCondition21.modeAuto = 1;
      this.d.windFrontMax = false;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label173;
      AirCondition localAirCondition20 = this.d;
      localAirCondition20.modeAuto = 0;
      this.d.windFrontMax = true;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = false;
      break label173;
      AirCondition localAirCondition19 = this.d;
      localAirCondition19.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label173;
      AirCondition localAirCondition18 = this.d;
      localAirCondition18.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label173;
      AirCondition localAirCondition17 = this.d;
      localAirCondition17.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label173;
      AirCondition localAirCondition16 = this.d;
      localAirCondition16.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label173;
      AirCondition localAirCondition15 = this.d;
      localAirCondition15.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label173;
      AirCondition localAirCondition14 = this.d;
      localAirCondition14.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label173;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeAuto = 0;
      this.d.windFrontMax = false;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label173;
      if ((0x10 & paramArrayOfByte[1]) != 0)
        this.d.windLevel = 8;
      this.d.windLevelMax = 8;
      break label206;
      label887: if (i == 30)
      {
        AirCondition localAirCondition12 = this.d;
        localAirCondition12.tempLeft = 65535;
        break label237;
      }
      if ((i >= 1) && (i <= 28))
      {
        this.d.tempLeft = (5 * (i + 33));
        break label237;
      }
      if (i == 29)
      {
        this.d.tempLeft = 160;
        break label237;
      }
      if (i == 31)
      {
        this.d.tempLeft = 165;
        break label237;
      }
      if (i == 32)
      {
        this.d.tempLeft = 150;
        break label237;
      }
      if (i == 33)
      {
        this.d.tempLeft = 155;
        break label237;
      }
      if (i == 34)
      {
        this.d.tempLeft = 310;
        break label237;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label237;
      label1065: if (j == 30)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempRight = 65535;
        break label268;
      }
      if ((j >= 1) && (j <= 28))
      {
        this.d.tempRight = (5 * (j + 33));
        break label268;
      }
      if (j == 29)
      {
        this.d.tempRight = 160;
        break label268;
      }
      if (j == 31)
      {
        this.d.tempRight = 165;
        break label268;
      }
      if (j == 32)
      {
        this.d.tempRight = 150;
        break label268;
      }
      if (j == 33)
      {
        this.d.tempRight = 155;
        break label268;
      }
      if (j == 34)
      {
        this.d.tempRight = 310;
        break label268;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label268;
      label1243: if ((0x20 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.windLoop = 1;
      }
      else
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.windLoop = 0;
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
    ai();
    this.cv.d(1);
    this.cv.e(1);
    this.cv.a((byte)-112, new byte[] { 3 }, 1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)0);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)1);
      else if (str.equals("de"))
        c((byte)2);
      else if (str.equals("it"))
        c((byte)3);
      else if (str.equals("fr"))
        c((byte)4);
      else if (str.equals("sv"))
        c((byte)5);
      else if (str.equals("es"))
        c((byte)6);
      else if (str.equals("nl"))
        c((byte)7);
      else if (str.equals("pt"))
        c((byte)8);
      else if (str.equals("nb"))
        c((byte)9);
      else if (str.equals("fi"))
        c((byte)10);
      else if (str.equals("da"))
        c((byte)11);
      else if (str.equals("pl"))
        c((byte)12);
      else if (str.equals("tr"))
        c((byte)13);
      else if (str.equals("ar"))
        c((byte)14);
      else if (str.equals("ru"))
        c((byte)15);
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

  public void as()
  {
    this.cv.a((byte)-112, new byte[] { 38 }, 1);
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
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 3:
      case 34:
      case 35:
      case 36:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 13:
      case 38:
      case 10:
      case 26:
      case 49:
      case 50:
      case 51:
      case -46:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
      {
        byte[] arrayOfByte18 = new byte[6];
        int n = 0;
        if (n < 6)
        {
          arrayOfByte18[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
          if (n == 5);
          while (true)
          {
            n++;
            break;
            if (arrayOfByte18[n] != this.cB[n])
              i = 1;
            this.cB[n] = arrayOfByte18[n];
          }
        }
        if ((i != 0) && (this.dy))
        {
          m(arrayOfByte18);
          this.cv.a(this.d);
        }
        this.dy = true;
        if (this.cv.y != 1)
        {
          int i1 = arrayOfByte18[5];
          String str = "";
          if ((i1 >= -40) && (i1 <= 87))
            str = " " + i1 + this.mContext.getString(2131099651);
          f(str);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 4)
          {
            byte[] arrayOfByte17 = new byte[4];
            for (int m = 0; m < 4; m++)
              arrayOfByte17[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
            this.aY.max = 7;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte17[0];
            this.aY.b2 = arrayOfByte17[1];
            this.aY.b3 = arrayOfByte17[2];
            this.aY.b4 = arrayOfByte17[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte16 = new byte[4];
              for (int k = 0; k < 4; k++)
                arrayOfByte16[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
              this.aY.max = 7;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte16[0];
              this.aY.f2 = arrayOfByte16[1];
              this.aY.f3 = arrayOfByte16[2];
              this.aY.f4 = arrayOfByte16[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte15 = new byte[2];
                arrayOfByte15[0] = paramArrayOfByte[(paramInt1 + 3)];
                arrayOfByte15[1] = paramArrayOfByte[(paramInt1 + 4)];
                n(arrayOfByte15);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                {
                  byte[] arrayOfByte14 = new byte[3];
                  arrayOfByte14[0] = 4;
                  arrayOfByte14[1] = 1;
                  while (i < 1)
                  {
                    arrayOfByte14[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.c(arrayOfByte14);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                  {
                    byte[] arrayOfByte13 = new byte[4];
                    arrayOfByte13[0] = 5;
                    arrayOfByte13[1] = 1;
                    while (i < 2)
                    {
                      arrayOfByte13[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.c(arrayOfByte13);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                    {
                      byte[] arrayOfByte12 = new byte[4];
                      arrayOfByte12[0] = 6;
                      arrayOfByte12[1] = 2;
                      while (i < 2)
                      {
                        arrayOfByte12[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.c(arrayOfByte12);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                      {
                        byte[] arrayOfByte11 = new byte[3];
                        arrayOfByte11[0] = 7;
                        arrayOfByte11[1] = 1;
                        while (i < 1)
                        {
                          arrayOfByte11[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.c(arrayOfByte11);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 10)
                        {
                          byte[] arrayOfByte10 = new byte[12];
                          arrayOfByte10[0] = 8;
                          arrayOfByte10[1] = 10;
                          while (i < 10)
                          {
                            arrayOfByte10[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.c(arrayOfByte10);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                          {
                            byte[] arrayOfByte9 = new byte[3];
                            arrayOfByte9[0] = 9;
                            arrayOfByte9[1] = 1;
                            while (i < 1)
                            {
                              arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte9);
                            continue;
                            if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                            {
                              byte[] arrayOfByte8 = new byte[4];
                              arrayOfByte8[0] = 11;
                              arrayOfByte8[1] = 2;
                              while (i < 2)
                              {
                                arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.c(arrayOfByte8);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                              {
                                byte[] arrayOfByte7 = new byte[3];
                                arrayOfByte7[0] = 12;
                                arrayOfByte7[1] = 1;
                                while (i < 1)
                                {
                                  arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.c(arrayOfByte7);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                                {
                                  byte[] arrayOfByte6 = new byte[3];
                                  arrayOfByte6[0] = 13;
                                  arrayOfByte6[1] = 1;
                                  while (i < 1)
                                  {
                                    arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte6);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                                  {
                                    int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                                    if (j >= 32768)
                                      j += 0;
                                    o(0 - j * 35 / 7800);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                    {
                                      byte[] arrayOfByte5 = new byte[5];
                                      arrayOfByte5[0] = 10;
                                      arrayOfByte5[1] = 3;
                                      while (i < 3)
                                      {
                                        arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                        i++;
                                      }
                                      this.cv.c(arrayOfByte5);
                                      continue;
                                      if (paramArrayOfByte[(paramInt1 + 2)] == 4)
                                      {
                                        byte[] arrayOfByte4 = new byte[6];
                                        arrayOfByte4[0] = 26;
                                        arrayOfByte4[1] = 4;
                                        while (i < 4)
                                        {
                                          arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                          i++;
                                        }
                                        this.cv.d(arrayOfByte4);
                                        continue;
                                        if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                        {
                                          byte[] arrayOfByte3 = new byte[16];
                                          arrayOfByte3[0] = 49;
                                          arrayOfByte3[1] = 8;
                                          while (i < 8)
                                          {
                                            arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                            i++;
                                          }
                                          this.cv.d(arrayOfByte3);
                                          continue;
                                          if (paramArrayOfByte[(paramInt1 + 2)] == 5)
                                          {
                                            byte[] arrayOfByte2 = new byte[7];
                                            arrayOfByte2[0] = 50;
                                            arrayOfByte2[1] = 5;
                                            while (i < 5)
                                            {
                                              arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                              i++;
                                            }
                                            this.cv.d(arrayOfByte2);
                                            continue;
                                            if (paramArrayOfByte[(paramInt1 + 2)] == 15)
                                            {
                                              byte[] arrayOfByte1 = new byte[17];
                                              arrayOfByte1[0] = 51;
                                              arrayOfByte1[1] = 15;
                                              while (i < 15)
                                              {
                                                arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                                i++;
                                              }
                                              this.cv.d(arrayOfByte1);
                                              continue;
                                              if (paramArrayOfByte[(paramInt1 + 2)] != 2);
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
        break label114;
      bool3 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label120;
      bool4 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label126;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label132;
      bool6 = bool1;
      label68: if ((0x80 & paramArrayOfByte[bool1]) == 0)
        break label138;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label114: bool3 = false;
      break label32;
      label120: bool4 = false;
      break label44;
      label126: bool5 = false;
      break label56;
      label132: bool6 = false;
      break label68;
      label138: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bn
 * JD-Core Version:    0.6.2
 */