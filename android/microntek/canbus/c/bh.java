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

public class bh extends a
{
  private byte[] cB = new byte[8];
  private boolean cV = true;
  private boolean cW = true;
  private boolean dw = true;

  public bh(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 49;
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { -92, paramByte };
    this.cv.a((byte)-58, arrayOfByte, 2);
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

  private void s(byte[] paramArrayOfByte)
  {
    label35: label61: label77: label93: label109: label127: int i;
    label144: label161: label239: int j;
    label279: label321: label347: label363: label379: int k;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label539;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label550;
      AirCondition localAirCondition22 = this.d;
      localAirCondition22.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label568;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label579;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label590;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label601;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label612;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label623;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      i = 0xFF & paramArrayOfByte[6];
      if ((i < 30) || (i > 60))
        break label690;
      this.d.tempUnit = false;
      if (i != 30)
        break label634;
      AirCondition localAirCondition21 = this.d;
      localAirCondition21.tempRight = 0;
      j = 0xFF & paramArrayOfByte[2];
      if ((0x8 & paramArrayOfByte[4]) != 0)
        break label926;
      if (j != 0)
        break label825;
      AirCondition localAirCondition17 = this.d;
      localAirCondition17.tempLeft = 0;
      this.d.seatShow = false;
      AirCondition localAirCondition14 = this.d;
      localAirCondition14.modeAuto = -1;
      AirCondition localAirCondition15 = this.d;
      localAirCondition15.modeDual = -1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label1158;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.windLoop = 1;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label1178;
      this.d.rearLock = 1;
      if ((0x4 & paramArrayOfByte[4]) == 0)
        break label1189;
      this.d.acMax = 1;
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[7]);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[7] >> 2);
      this.d.b_seatShow = false;
      this.d.b_ariStateShow = false;
      this.d.b_wind_FrameShow = false;
      this.d.b_rightShow = false;
      this.d.b_windLevel = (0x7 & paramArrayOfByte[3] >> 4);
      this.d.b_windLevelMax = 7;
      k = 0xF & paramArrayOfByte[3];
      if (k != 0)
        break label1200;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.b_tempLeft = 0;
      label493: if ((0x80 & paramArrayOfByte[3]) == 0)
        break label1300;
      this.d.b_modeAc = true;
      label511: if ((0x1 & paramArrayOfByte[4]) == 0)
        break label1311;
    }
    label539: label926: label1311: for (this.d.b_onOff = true; ; this.d.b_onOff = false)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      label550: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label568: this.d.modeDual = 0;
      break label77;
      label579: this.d.windFrontMax = false;
      break label93;
      label590: this.d.windRear = false;
      break label109;
      label601: this.d.windUp = false;
      break label127;
      label612: this.d.windMid = false;
      break label144;
      label623: this.d.windDown = false;
      break label161;
      label634: if (i == 60)
      {
        AirCondition localAirCondition20 = this.d;
        localAirCondition20.tempRight = 65535;
        break label239;
      }
      if ((i < 31) || (i > 59))
        break label239;
      this.d.tempRight = (i * 5);
      break label239;
      label690: if ((i >= 119) && (i <= 171))
      {
        this.d.tempUnit = true;
        if (i == 119)
        {
          AirCondition localAirCondition19 = this.d;
          localAirCondition19.tempRight = 0;
          break label239;
        }
        if (i == 171)
        {
          AirCondition localAirCondition18 = this.d;
          localAirCondition18.tempRight = 65535;
          break label239;
        }
        if ((i < 120) || (i > 170) || (i % 2 != 0))
          break label239;
        this.d.tempRight = (i * 5);
        break label239;
      }
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.tempRight = -1;
      break label239;
      label825: if (j == 15)
      {
        this.d.tempLeft = 220;
        if (!this.d.tempUnit)
          break label279;
        this.d.tempLeft = (320 + 9 * this.d.tempLeft / 5);
        break label279;
      }
      if (j == 30)
      {
        AirCondition localAirCondition16 = this.d;
        localAirCondition16.tempLeft = 65535;
        break label279;
      }
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.tempLeft = -1;
      break label279;
      this.d.seatShow = true;
      if ((j >= 30) && (j <= 60))
      {
        if (j == 30)
        {
          AirCondition localAirCondition12 = this.d;
          localAirCondition12.tempLeft = 0;
          break label321;
        }
        if (j == 60)
        {
          AirCondition localAirCondition11 = this.d;
          localAirCondition11.tempLeft = 65535;
          break label321;
        }
        if ((j < 31) || (j > 59))
          break label321;
        this.d.tempLeft = (j * 5);
        break label321;
      }
      if ((j >= 119) && (j <= 171))
      {
        if (j == 119)
        {
          AirCondition localAirCondition10 = this.d;
          localAirCondition10.tempLeft = 0;
          break label321;
        }
        if (j == 171)
        {
          AirCondition localAirCondition9 = this.d;
          localAirCondition9.tempLeft = 65535;
          break label321;
        }
        if ((j < 120) || (j > 170) || (j % 2 != 0))
          break label321;
        this.d.tempLeft = (j * 5);
        break label321;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label321;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 0;
      break label347;
      this.d.rearLock = 0;
      break label363;
      label1189: this.d.acMax = 0;
      break label379;
      label1200: if (k == 8)
      {
        AirCondition localAirCondition6 = this.d;
        localAirCondition6.b_tempLeft = 65535;
        break label493;
      }
      if (k == 4)
      {
        this.d.b_tempLeft = 220;
        if (!this.d.tempUnit)
          break label493;
        this.d.b_tempLeft = (320 + 9 * this.d.b_tempLeft / 5);
        break label493;
      }
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.b_tempLeft = -1;
      break label493;
      this.d.b_modeAc = false;
      break label511;
    }
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 0);
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

  public void aq()
  {
    this.dw = false;
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 1);
  }

  public void ar()
  {
    this.dw = true;
    byte[] arrayOfByte = { -1, -1, 0 };
    this.cv.c(arrayOfByte);
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 0);
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
      case 0:
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
      case 41:
      case 20:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 6)
      {
        byte[] arrayOfByte18 = new byte[6];
        while (i < 6)
        {
          arrayOfByte18[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        m(arrayOfByte18);
        this.cv.a(this.d);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
        {
          byte[] arrayOfByte17 = new byte[4];
          int i5 = 0;
          if (i5 < 4)
          {
            if (paramArrayOfByte[(i5 + (paramInt1 + 3))] == 0)
              arrayOfByte17[i5] = 0;
            while (true)
            {
              i5++;
              break;
              if (paramArrayOfByte[(i5 + (paramInt1 + 3))] < 3)
                arrayOfByte17[i5] = 1;
              else
                arrayOfByte17[i5] = ((byte)(paramArrayOfByte[(i5 + (paramInt1 + 3))] / 2));
            }
          }
          this.aY.max = 15;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfByte17[0];
          this.aY.b2 = arrayOfByte17[1];
          this.aY.b3 = arrayOfByte17[2];
          this.aY.b4 = arrayOfByte17[3];
          if (!this.cV)
          {
            this.aY.front_cnt = 0;
            this.aY.f1 = 0;
            this.aY.f2 = 0;
            this.aY.f3 = 0;
            this.aY.f4 = 0;
            this.aY.f5 = 0;
            this.aY.f6 = 0;
          }
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 6)
          {
            byte[] arrayOfByte16 = new byte[6];
            int i4 = 0;
            if (i4 < 6)
            {
              if (paramArrayOfByte[(i4 + (paramInt1 + 3))] == 0)
                arrayOfByte16[i4] = 0;
              while (true)
              {
                i4++;
                break;
                if (paramArrayOfByte[(i4 + (paramInt1 + 3))] < 3)
                  arrayOfByte16[i4] = 1;
                else
                  arrayOfByte16[i4] = ((byte)(paramArrayOfByte[(i4 + (paramInt1 + 3))] / 2));
              }
            }
            this.aY.max = 15;
            this.aY.front_cnt = 6;
            this.aY.f1 = arrayOfByte16[5];
            this.aY.f2 = arrayOfByte16[0];
            this.aY.f3 = arrayOfByte16[1];
            this.aY.f4 = arrayOfByte16[2];
            this.aY.f5 = arrayOfByte16[3];
            this.aY.f6 = arrayOfByte16[4];
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
            if (paramArrayOfByte[(paramInt1 + 2)] == 5)
            {
              byte[] arrayOfByte15 = new byte[2];
              while (i < 2)
              {
                arrayOfByte15[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              n(arrayOfByte15);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                if ((0x4 & paramArrayOfByte[(paramInt1 + 3)]) == 4)
                {
                  this.cV = true;
                  label809: if ((0x8 & paramArrayOfByte[(paramInt1 + 3)]) != 8)
                    break label936;
                  this.cW = true;
                }
                while (true)
                {
                  if ((this.cW) || (this.cV))
                    break label991;
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
                  this.aY.f5 = 0;
                  this.aY.f6 = 0;
                  break label809;
                  label936: this.cW = false;
                  this.aY.max = 15;
                  this.aY.back_cnt = 0;
                  this.aY.b1 = 0;
                  this.aY.b2 = 0;
                  this.aY.b3 = 0;
                  this.aY.b4 = 0;
                }
                label991: continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                {
                  int i2 = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                  if (i2 >= 32768)
                    i2 += 0;
                  int i3 = i2 * 30 / 450;
                  Intent localIntent = new Intent("com.microntek.canbusbackview");
                  localIntent.putExtra("canbustype", this.e);
                  localIntent.putExtra("lfribackview", 0 - i3);
                  this.mContext.sendBroadcast(localIntent);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                  {
                    byte[] arrayOfByte14 = new byte[5];
                    arrayOfByte14[0] = 39;
                    arrayOfByte14[1] = paramArrayOfByte[(paramInt1 + 3)];
                    arrayOfByte14[2] = 0;
                    arrayOfByte14[3] = 0;
                    arrayOfByte14[4] = 0;
                    this.cv.d(arrayOfByte14);
                    continue;
                    if ((paramArrayOfByte[(paramInt1 + 2)] == 16) && (goto 204) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
                    {
                      byte[] arrayOfByte13 = new byte[8];
                      arrayOfByte13[0] = -126;
                      arrayOfByte13[1] = 6;
                      while (i < 6)
                      {
                        arrayOfByte13[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.c(arrayOfByte13);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                      {
                        byte[] arrayOfByte12 = new byte[22];
                        arrayOfByte12[0] = 112;
                        arrayOfByte12[1] = 20;
                        while (i < 20)
                        {
                          arrayOfByte12[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.c(arrayOfByte12);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                        {
                          byte[] arrayOfByte11 = new byte[22];
                          arrayOfByte11[0] = 113;
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
                            arrayOfByte10[0] = 114;
                            arrayOfByte10[1] = 20;
                            while (i < 20)
                            {
                              arrayOfByte10[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte10);
                            continue;
                            if (paramArrayOfByte[(paramInt1 + 2)] == 5)
                            {
                              byte[] arrayOfByte9 = new byte[7];
                              arrayOfByte9[0] = 120;
                              arrayOfByte9[1] = 5;
                              while (i < 5)
                              {
                                arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.c(arrayOfByte9);
                            }
                            else if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                            {
                              byte[] arrayOfByte8 = new byte[7];
                              arrayOfByte8[0] = 120;
                              arrayOfByte8[1] = 3;
                              while (i < 3)
                              {
                                arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.c(arrayOfByte8);
                              continue;
                              if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (this.dw))
                              {
                                byte[] arrayOfByte7 = new byte[3];
                                arrayOfByte7[0] = 121;
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
                                  arrayOfByte6[0] = 64;
                                  arrayOfByte6[1] = 1;
                                  while (i < 1)
                                  {
                                    arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte6);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                  {
                                    byte[] arrayOfByte5 = new byte[10];
                                    arrayOfByte5[0] = 80;
                                    arrayOfByte5[1] = 8;
                                    while (i < 8)
                                    {
                                      arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.c(arrayOfByte5);
                                    continue;
                                    int i1 = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
                                    byte[] arrayOfByte4 = new byte[i1 + 2];
                                    arrayOfByte4[0] = 81;
                                    arrayOfByte4[1] = paramArrayOfByte[(paramInt1 + 2)];
                                    while (i < i1)
                                    {
                                      arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.c(arrayOfByte4);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                    {
                                      byte[] arrayOfByte3 = new byte[5];
                                      arrayOfByte3[0] = 82;
                                      arrayOfByte3[1] = 3;
                                      while (i < 3)
                                      {
                                        arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                        i++;
                                      }
                                      this.cv.c(arrayOfByte3);
                                      continue;
                                      if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                      {
                                        byte[] arrayOfByte2 = new byte[5];
                                        arrayOfByte2[0] = 83;
                                        arrayOfByte2[1] = 3;
                                        while (i < 3)
                                        {
                                          arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                          i++;
                                        }
                                        this.cv.c(arrayOfByte2);
                                        continue;
                                        if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                        {
                                          byte[] arrayOfByte1 = new byte[8];
                                          int k = 0;
                                          int m = 0;
                                          if (k < 8)
                                          {
                                            if (k == 5);
                                            while (true)
                                            {
                                              k++;
                                              break;
                                              arrayOfByte1[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
                                              if (arrayOfByte1[k] != this.cB[k])
                                                m = 1;
                                              this.cB[k] = arrayOfByte1[k];
                                            }
                                          }
                                          s(arrayOfByte1);
                                          if (((0x10 & arrayOfByte1[1]) != 0) && (m != 0))
                                            this.cv.a(this.d);
                                          int n = 0xFF & paramArrayOfByte[(paramInt1 + 8)];
                                          String str = "";
                                          if (n >= 128)
                                            n -= 256;
                                          StringBuilder localStringBuilder1;
                                          Locale localLocale1;
                                          Object[] arrayOfObject1;
                                          if ((n >= -40) && (n <= 86))
                                          {
                                            if ((byte)(0x40 & paramArrayOfByte[(paramInt1 + 7)]) != 64)
                                              break label2261;
                                            localStringBuilder1 = new StringBuilder();
                                            localLocale1 = Locale.US;
                                            arrayOfObject1 = new Object[1];
                                            arrayOfObject1[0] = Float.valueOf(32 + n * 9 / 5);
                                          }
                                          label2261: StringBuilder localStringBuilder2;
                                          Locale localLocale2;
                                          Object[] arrayOfObject2;
                                          for (str = String.format(localLocale1, " %.0f", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099651))
                                          {
                                            f(str);
                                            arrayOfByte1[0] = 41;
                                            arrayOfByte1[1] = paramArrayOfByte[(paramInt1 + 7)];
                                            this.cv.d(arrayOfByte1);
                                            break;
                                            localStringBuilder2 = new StringBuilder();
                                            localLocale2 = Locale.US;
                                            arrayOfObject2 = new Object[1];
                                            arrayOfObject2[0] = Integer.valueOf(n);
                                          }
                                          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                                          {
                                            int j = paramArrayOfByte[(paramInt1 + 3)];
                                            new Intent("com.microntek.light").putExtra("keyCode", j & 0xFF);
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
 * Qualified Name:     android.microntek.canbus.c.bh
 * JD-Core Version:    0.6.2
 */