package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class f extends a
{
  private boolean cV = true;
  private boolean cW = true;

  public f(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 6;
    this.d = new AirCondition();
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 2, paramByte };
    this.cv.a((byte)39, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label101: label119: boolean bool;
    label136: label153: label193: int i;
    label231: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label333;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label344;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label362;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label373;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label384;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label395;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label406;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label417;
      bool = true;
      localAirCondition2.tempUnit = bool;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label423;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label532;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempRight = 0;
      label262: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label641;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.windLoop = 1;
      label288: AirCondition localAirCondition6 = this.d;
      localAirCondition6.rearLock = -1;
      if ((0x4 & paramArrayOfByte[4]) == 0)
        break label661;
    }
    label384: label395: label532: label661: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label333: this.d.modeAc = false;
      break label43;
      label344: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label362: this.d.modeDual = 0;
      break label85;
      label373: this.d.windFrontMax = false;
      break label101;
      this.d.windUp = false;
      break label119;
      this.d.windMid = false;
      break label136;
      label406: this.d.windDown = false;
      break label153;
      label417: bool = false;
      break label193;
      label423: if (i == 127)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempLeft = 65535;
        break label231;
      }
      if ((i >= 31) && (i <= 59))
      {
        this.d.tempLeft = (i * 5);
        if (!this.d.tempUnit)
          break label231;
        this.d.tempLeft = (320 + 9 * this.d.tempLeft / 5);
        break label231;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label231;
      if (j == 127)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempRight = 65535;
        break label262;
      }
      if ((j >= 31) && (j <= 59))
      {
        this.d.tempRight = (j * 5);
        if (!this.d.tempUnit)
          break label262;
        this.d.tempRight = (320 + 9 * this.d.tempRight / 5);
        break label262;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label262;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 0;
      break label288;
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
    ai();
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)27);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)2);
      else if (str.equals("de"))
        c((byte)4);
      else if (str.equals("it"))
        c((byte)5);
      else if (str.equals("fr"))
        c((byte)6);
      else if (str.equals("es"))
        c((byte)8);
      else if (str.equals("tr"))
        c((byte)10);
      else if (str.equals("ru"))
        c((byte)11);
      else if (str.equals("nl"))
        c((byte)12);
      else if (str.equals("pl"))
        c((byte)14);
      else if (str.equals("sv"))
        c((byte)18);
      else if (str.equals("pt"))
        c((byte)22);
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
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 48:
      case -126:
      case 112:
      case 113:
      case 114:
      case 120:
      case 121:
      case 64:
      case 80:
      case 81:
      case 82:
      case 83:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 6)
      {
        byte[] arrayOfByte16 = new byte[6];
        while (i < 6)
        {
          arrayOfByte16[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        m(arrayOfByte16);
        this.cv.a(this.d);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
        {
          byte[] arrayOfByte15 = new byte[4];
          int m = 0;
          if (m < 4)
          {
            if (paramArrayOfByte[(m + (paramInt1 + 3))] == 0)
              arrayOfByte15[m] = 0;
            while (true)
            {
              m++;
              break;
              if (paramArrayOfByte[(m + (paramInt1 + 3))] < 3)
                arrayOfByte15[m] = 1;
              else
                arrayOfByte15[m] = ((byte)(paramArrayOfByte[(m + (paramInt1 + 3))] / 2));
            }
          }
          this.aY.max = 15;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfByte15[0];
          this.aY.b2 = arrayOfByte15[1];
          this.aY.b3 = arrayOfByte15[2];
          this.aY.b4 = arrayOfByte15[3];
          if (!this.cV)
          {
            this.aY.front_cnt = 0;
            this.aY.f1 = 0;
            this.aY.f2 = 0;
            this.aY.f3 = 0;
            this.aY.f4 = 0;
          }
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 6)
          {
            byte[] arrayOfByte14 = new byte[4];
            int k = 0;
            if (k < 4)
            {
              if (paramArrayOfByte[(k + (paramInt1 + 3))] == 0)
                arrayOfByte14[k] = 0;
              while (true)
              {
                k++;
                break;
                if (paramArrayOfByte[(k + (paramInt1 + 3))] < 3)
                  arrayOfByte14[k] = 1;
                else
                  arrayOfByte14[k] = ((byte)(paramArrayOfByte[(k + (paramInt1 + 3))] / 2));
              }
            }
            this.aY.max = 15;
            this.aY.front_cnt = 4;
            this.aY.f1 = arrayOfByte14[0];
            this.aY.f2 = arrayOfByte14[1];
            this.aY.f3 = arrayOfByte14[2];
            this.aY.f4 = arrayOfByte14[3];
            if (!this.cW)
            {
              this.aY.back_cnt = 0;
              this.aY.b1 = 0;
              this.aY.b2 = 0;
              this.aY.b3 = 0;
              this.aY.b4 = 0;
            }
            this.cv.a(this.aY);
            continue;
            if ((paramArrayOfByte[(paramInt1 + 2)] == 2) || (paramArrayOfByte[(paramInt1 + 2)] == 5))
            {
              byte[] arrayOfByte13 = new byte[2];
              while (i < 2)
              {
                arrayOfByte13[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              n(arrayOfByte13);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                if ((0x4 & paramArrayOfByte[(paramInt1 + 3)]) == 4)
                {
                  this.cV = true;
                  label761: if ((0x8 & paramArrayOfByte[(paramInt1 + 3)]) != 8)
                    break label872;
                  this.cW = true;
                }
                while (true)
                {
                  if ((this.cW) || (this.cV))
                    break label927;
                  this.aY.zero_show = false;
                  this.cv.a(this.aY);
                  break;
                  this.cV = false;
                  this.aY.max = 15;
                  this.aY.front_cnt = 0;
                  this.aY.f1 = 0;
                  this.aY.f2 = 0;
                  this.aY.f3 = 0;
                  this.aY.f4 = 0;
                  break label761;
                  label872: this.cW = false;
                  this.aY.max = 15;
                  this.aY.back_cnt = 0;
                  this.aY.b1 = 0;
                  this.aY.b2 = 0;
                  this.aY.b3 = 0;
                  this.aY.b4 = 0;
                }
                label927: continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 6) && (goto 188) && (paramArrayOfByte[(paramInt1 + 2)] >= 1))
                {
                  paramArrayOfByte[(paramInt1 + 3)];
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 16) && (goto 188) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
                  {
                    byte[] arrayOfByte12 = new byte[8];
                    arrayOfByte12[0] = -126;
                    arrayOfByte12[1] = 6;
                    while (i < 6)
                    {
                      arrayOfByte12[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.c(arrayOfByte12);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                    {
                      byte[] arrayOfByte11 = new byte[22];
                      arrayOfByte11[0] = 112;
                      arrayOfByte11[1] = 20;
                      while (i < 20)
                      {
                        arrayOfByte11[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.c(arrayOfByte11);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                      {
                        byte[] arrayOfByte10 = new byte[22];
                        arrayOfByte10[0] = 113;
                        arrayOfByte10[1] = 20;
                        while (i < 20)
                        {
                          arrayOfByte10[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.c(arrayOfByte10);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                        {
                          byte[] arrayOfByte9 = new byte[22];
                          arrayOfByte9[0] = 114;
                          arrayOfByte9[1] = 20;
                          while (i < 20)
                          {
                            arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.c(arrayOfByte9);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] == 5)
                          {
                            byte[] arrayOfByte8 = new byte[7];
                            arrayOfByte8[0] = 120;
                            arrayOfByte8[1] = 5;
                            while (i < 5)
                            {
                              arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte8);
                          }
                          else if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                          {
                            byte[] arrayOfByte7 = new byte[7];
                            arrayOfByte7[0] = 120;
                            arrayOfByte7[1] = 3;
                            while (i < 3)
                            {
                              arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte7);
                            continue;
                            if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                            {
                              byte[] arrayOfByte6 = new byte[3];
                              arrayOfByte6[0] = 121;
                              arrayOfByte6[1] = 1;
                              while (i < 1)
                              {
                                arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.c(arrayOfByte6);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                              {
                                byte[] arrayOfByte5 = new byte[3];
                                arrayOfByte5[0] = 64;
                                arrayOfByte5[1] = 1;
                                while (i < 1)
                                {
                                  arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.c(arrayOfByte5);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                {
                                  byte[] arrayOfByte4 = new byte[10];
                                  arrayOfByte4[0] = 80;
                                  arrayOfByte4[1] = 8;
                                  while (i < 8)
                                  {
                                    arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte4);
                                  continue;
                                  int j = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
                                  byte[] arrayOfByte3 = new byte[j + 2];
                                  arrayOfByte3[0] = 81;
                                  arrayOfByte3[1] = paramArrayOfByte[(paramInt1 + 2)];
                                  while (i < j)
                                  {
                                    arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte3);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                  {
                                    byte[] arrayOfByte2 = new byte[5];
                                    arrayOfByte2[0] = 82;
                                    arrayOfByte2[1] = 3;
                                    while (i < 3)
                                    {
                                      arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.c(arrayOfByte2);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                    {
                                      byte[] arrayOfByte1 = new byte[5];
                                      arrayOfByte1[0] = 83;
                                      arrayOfByte1[1] = 3;
                                      while (i < 3)
                                      {
                                        arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                        i++;
                                      }
                                      this.cv.c(arrayOfByte1);
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
 * Qualified Name:     android.microntek.canbus.c.f
 * JD-Core Version:    0.6.2
 */