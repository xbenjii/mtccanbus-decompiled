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
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class co extends a
{
  private boolean dL = false;
  byte[] di = new byte[31];

  public co(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 78;
  }

  private void aQ()
  {
    if (this.cv.l() == 0);
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
    {
      this.cv.a(this.aY);
      return;
    }
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 0, paramByte };
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label77: label95: label112: boolean bool;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label342;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label353;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label371;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label382;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label393;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label404;
      this.d.windUp = true;
      label130: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label415;
      this.d.windMid = true;
      label147: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label426;
      this.d.windDown = true;
      label164: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 8;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label437;
      bool = true;
      label203: localAirCondition2.tempUnit = bool;
      int i = 0x1 & paramArrayOfByte[4] >> 1;
      this.d.tempLeft = m(i, 0xFF & paramArrayOfByte[2]);
      this.d.tempRight = m(i, 0xFF & paramArrayOfByte[3]);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label443;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      label285: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label463;
    }
    label393: label404: label415: label426: label437: label443: label463: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatHotLeft = (0x3 & paramArrayOfByte[5] >> 4);
      this.d.seatHotRight = (0x3 & paramArrayOfByte[5] >> 0);
      return;
      this.d.onOff = false;
      break;
      label342: this.d.modeAc = false;
      break label35;
      label353: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label371: this.d.modeDual = 0;
      break label77;
      label382: this.d.windFrontMax = false;
      break label95;
      this.d.windRear = false;
      break label112;
      this.d.windUp = false;
      break label130;
      this.d.windMid = false;
      break label147;
      this.d.windDown = false;
      break label164;
      bool = false;
      break label203;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 0;
      break label285;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 1));
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte[5] = ((byte)(paramByte2 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 8);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[2] = ((byte)(16 + (paramByte1 - 2)));
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[5] = ((byte)(paramByte2 + 1));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 6;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = 0;
    int i = paramInt3 / 1000;
    arrayOfByte[5] = ((byte)(i / 60 / 60));
    arrayOfByte[6] = ((byte)(i / 60 % 60));
    arrayOfByte[7] = ((byte)(i % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void a(String paramString, int paramInt)
  {
    ap();
  }

  public int[][] aA()
  {
    return new int[][] { { 3841, 46, 33282, 1, 15 }, { 3842, 46, 33282, 1, 1 }, { 3844, 46, 33282, 1, 14 }, { 3845, 46, 33282, 1, 3 }, { 3846, 46, 33282, 1, 2 }, { 3847, 46, 33282, 1, 4 }, { 3848, 46, 33282, 1, 5 }, { 3849, 46, 33282, 1, 20 }, { 3850, 46, 33282, 1, 21 }, { 3851, 46, 33282, 1, 17 }, { 3852, 46, 33282, 1, 18 }, { 3853, 46, 33282, 1, 16 }, { 3855, 46, 33282, 1, 7 }, { 3856, 46, 33282, 1, 6 }, { 3857, 46, 33282, 1, 13 }, { 3858, 46, 33282, 1, 10 }, { 3860, 46, 33282, 1, 8 }, { 3861, 46, 33282, 1, 11 }, { 3863, 46, 33282, 1, 9 }, { 3872, 46, 33282, 1, 12 } };
  }

  public void ah()
  {
    ai();
    this.cv.d(1);
    this.cv.e(1);
    int i = Settings.System.getInt(this.cv.getContentResolver(), "mCar_type", -1);
    if (i != -1)
    {
      CanBusServer localCanBusServer = this.cv;
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)i);
      localCanBusServer.a((byte)-54, arrayOfByte, 1);
    }
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)10);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)1);
      else if (str.equals("de"))
        c((byte)3);
      else if (str.equals("it"))
        c((byte)5);
      else if (str.equals("fr"))
        c((byte)2);
      else if (!str.equals("sv"))
        if (str.equals("es"))
          c((byte)4);
        else if (str.equals("nl"))
          c((byte)6);
        else if (str.equals("pt"))
          c((byte)8);
        else if ((!str.equals("nb")) && (!str.equals("fi")) && (!str.equals("da")))
          if (str.equals("pl"))
            c((byte)7);
          else if (str.equals("tr"))
            c((byte)9);
          else if ((!str.equals("ar")) && (str.equals("ru")))
            c((byte)13);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[6];
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
      this.hour = (0x80 | this.hour);
    }
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
    arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    this.cv.a((byte)-57, arrayOfByte, 6);
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 7;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void az()
  {
    this.cv.a((byte)-112, new byte[] { 33, 0, 0, 0 }, 4);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 16;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[5] = ((byte)(paramInt2 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = 0;
    int i = paramInt3 / 1000;
    arrayOfByte[5] = ((byte)(i / 60 / 60));
    arrayOfByte[6] = ((byte)(i / 60 % 60));
    arrayOfByte[7] = ((byte)(i % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 36:
    case 33:
    case 41:
    case 7:
    case 11:
    case 16:
    case 17:
    case 34:
    case 39:
    case 64:
    case 66:
    case 67:
    case 68:
    case 51:
    }
    while (true)
    {
      return;
      if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && ((0x1 & paramArrayOfByte[(paramInt1 + 3)]) != 0))
      {
        byte[] arrayOfByte5 = new byte[1];
        arrayOfByte5[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte5);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
        {
          byte[] arrayOfByte4 = new byte[7];
          while (i < 7)
          {
            arrayOfByte4[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          if (((0x10 & arrayOfByte4[1]) != 0) && (j(arrayOfByte4)))
          {
            m(arrayOfByte4);
            this.cv.a(this.d);
          }
          e(paramArrayOfByte, paramInt1, paramInt2);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
          {
            int i1 = ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8) + (0xFF & paramArrayOfByte[(paramInt1 + 3)]);
            if (i1 >= 32768)
              i1 += 0;
            o(i1 * 30 / 4600);
          }
          if (a(paramArrayOfByte[(paramInt1 + 2)], 12))
          {
            byte[] arrayOfByte3 = new byte[2 + this.mLength];
            arrayOfByte3[0] = 7;
            arrayOfByte3[1] = ((byte)this.mLength);
            for (int m = 0; m < this.mLength; m++)
              arrayOfByte3[(m + 2)] = paramArrayOfByte[(m + (paramInt1 + 3))];
            this.cv.d(arrayOfByte3);
            if (this.mLength >= 12)
            {
              int n = 0x10 & arrayOfByte3[12];
              boolean bool = false;
              if (n != 0)
                bool = true;
              this.dL = bool;
              continue;
              if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && (goto 132) && (paramArrayOfByte[(paramInt1 + 2)] == 10))
              {
                byte[] arrayOfByte2 = new byte[12];
                arrayOfByte2[0] = 16;
                arrayOfByte2[1] = 10;
                while (i < 10)
                {
                  arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte2);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] >= 3) && (paramArrayOfByte[(paramInt1 + 2)] <= 67))
                {
                  int k = 0x7F & paramArrayOfByte[(paramInt1 + 2)];
                  byte[] arrayOfByte1 = new byte[k + 2];
                  arrayOfByte1[0] = 17;
                  arrayOfByte1[1] = ((byte)k);
                  while (i < k)
                  {
                    arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.d(arrayOfByte1);
                  continue;
                  if (a(paramArrayOfByte[(paramInt1 + 2)], 4))
                  {
                    int[] arrayOfInt = new int[6 + this.mLength];
                    for (int j = 0; j < this.mLength; j++)
                      arrayOfInt[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
                    this.aY.max = 6;
                    this.aY.back_cnt = 4;
                    this.aY.b1 = arrayOfInt[0];
                    this.aY.b2 = arrayOfInt[1];
                    this.aY.b3 = arrayOfInt[2];
                    this.aY.b4 = arrayOfInt[3];
                    if (this.mLength == 6)
                    {
                      this.aY.front_cnt = 2;
                      this.aY.f1 = arrayOfInt[4];
                      this.aY.f2 = arrayOfInt[5];
                    }
                    aQ();
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                    {
                      float f1 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
                      String str = "";
                      float f2;
                      StringBuilder localStringBuilder1;
                      Locale localLocale1;
                      Object[] arrayOfObject1;
                      if (f1 >= 1.0F)
                      {
                        f2 = f1 / 2.0F - 39.5F;
                        if ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) != 0)
                          break label927;
                        localStringBuilder1 = new StringBuilder();
                        localLocale1 = Locale.US;
                        arrayOfObject1 = new Object[1];
                        arrayOfObject1[0] = Float.valueOf(f2);
                      }
                      label927: StringBuilder localStringBuilder2;
                      Locale localLocale2;
                      Object[] arrayOfObject2;
                      for (str = String.format(localLocale1, " %.1f", arrayOfObject1) + this.mContext.getString(2131099651); ; str = String.format(localLocale2, " %.0f", arrayOfObject2) + this.mContext.getString(2131099652))
                      {
                        Intent localIntent = new Intent("com.canbus.temperature");
                        localIntent.putExtra("temperature", str);
                        this.mContext.sendBroadcast(localIntent);
                        break;
                        localStringBuilder2 = new StringBuilder();
                        localLocale2 = Locale.US;
                        arrayOfObject2 = new Object[1];
                        arrayOfObject2[0] = Float.valueOf((float)(32.0D + 1.8D * f2));
                      }
                      e(paramArrayOfByte, paramInt1, paramInt2);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] != 8);
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

  int m(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt1 == 0)
      if (paramInt2 == 0)
        i = 0;
    while (true)
    {
      return i;
      if (paramInt2 == 255)
        i = 65535;
      else if ((paramInt2 >= 1) && (paramInt2 <= 254))
      {
        if (this.d.tempUnit == true)
          i = paramInt2 * 10;
        else
          i = paramInt2 * 5;
      }
      else;
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
 * Qualified Name:     android.microntek.canbus.c.co
 * JD-Core Version:    0.6.2
 */