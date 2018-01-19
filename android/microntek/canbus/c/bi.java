package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import java.util.Locale;

public class bi extends a
{
  private boolean dx;

  public bi(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 50;
  }

  private void B(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.microntek.controlinfo", "com.microntek.controlinfo.canbus61carinfo"));
    localIntent.addFlags(807600128);
    localIntent.putExtra("cftype", paramInt);
    try
    {
      this.cv.startActivityAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        Log.e("Canbus50", "controlinfo activity not found! " + localActivityNotFoundException.getMessage());
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label59: label77: label93: label111: int i;
    label128: label145: boolean bool;
    label207: int k;
    label245: int m;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label348;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label359;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label370;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label381;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label392;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label403;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label414;
      this.d.windDown = true;
      this.d.windLevelMax = 8;
      i = 0xF & paramArrayOfByte[1];
      if (i != 0)
        break label425;
      this.d.windLevel = 0;
      AirCondition localAirCondition13 = this.d;
      localAirCondition13.modeAuto = 1;
      AirCondition localAirCondition3 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label472;
      bool = true;
      localAirCondition3.tempUnit = bool;
      k = 0xFF & paramArrayOfByte[2];
      if (k != 0)
        break label478;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.tempLeft = 0;
      m = 0xFF & paramArrayOfByte[3];
      if (m != 0)
        break label588;
      AirCondition localAirCondition10 = this.d;
      localAirCondition10.tempRight = 0;
      label276: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label698;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.windLoop = 1;
      label302: AirCondition localAirCondition7 = this.d;
      localAirCondition7.rearLock = -1;
      if ((0x8 & paramArrayOfByte[4]) == 0)
        break label718;
    }
    label392: label403: label414: label425: label588: label718: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label348: this.d.modeAc = false;
      break label43;
      label359: this.d.modeDual = 0;
      break label59;
      label370: this.d.windFrontMax = false;
      break label77;
      label381: this.d.windRear = false;
      break label93;
      this.d.windUp = false;
      break label111;
      this.d.windMid = false;
      break label128;
      this.d.windDown = false;
      break label145;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = -1;
      AirCondition localAirCondition2 = this.d;
      if (i <= 1);
      for (int j = 0; ; j = i - 1)
      {
        localAirCondition2.windLevel = j;
        break;
      }
      label472: bool = false;
      break label207;
      label478: if (k == 255)
      {
        AirCondition localAirCondition11 = this.d;
        localAirCondition11.tempLeft = 65535;
        break label245;
      }
      if ((k >= 30) && (k <= 64))
      {
        this.d.tempLeft = (k * 5);
        if (!this.d.tempUnit)
          break label245;
        this.d.tempLeft = (320 + 9 * this.d.tempLeft / 5);
        break label245;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempLeft = -1;
      break label245;
      if (m == 255)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.tempRight = 65535;
        break label276;
      }
      if ((m >= 30) && (m <= 64))
      {
        this.d.tempRight = (m * 5);
        if (!this.d.tempUnit)
          break label276;
        this.d.tempRight = (320 + 9 * this.d.tempRight / 5);
        break label276;
      }
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.tempRight = -1;
      break label276;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 0;
      break label302;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 2;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[1] = ((byte)(paramByte1 + 0));
      arrayOfByte[2] = ((byte)(0xFF & paramInt / 100));
      arrayOfByte[3] = ((byte)(0xFF & paramInt % 100));
    }
    while (true)
    {
      this.cv.e((byte)9, arrayOfByte, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[1] = ((byte)(paramByte1 + 0));
        arrayOfByte[2] = ((byte)(0xFF & paramInt / 100));
        arrayOfByte[3] = ((byte)(0xFF & paramInt % 100));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 11 };
    this.cv.e((byte)9, arrayOfByte, 1);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
  }

  public void aj()
  {
    int i = 12;
    Time localTime = new Time();
    localTime.setToNow();
    int j = localTime.hour;
    int k = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[5];
    if (!bool)
    {
      if (j > i)
        j -= 12;
      if (j != 0);
    }
    while (true)
    {
      arrayOfByte[0] = ((byte)(0xFF & -2000 + localTime.year));
      arrayOfByte[1] = ((byte)(0xFF & 1 + localTime.month));
      arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(k & 0xFF));
      this.cv.e((byte)-90, arrayOfByte, 5);
      return;
      i = j;
    }
  }

  public void ak()
  {
    ap();
  }

  public void al()
  {
    am();
  }

  public void am()
  {
    byte[] arrayOfByte = { 11 };
    this.cv.e((byte)9, arrayOfByte, 1);
  }

  public void an()
  {
    byte[] arrayOfByte = { 11 };
    this.cv.e((byte)9, arrayOfByte, 1);
  }

  public void ap()
  {
    byte[] arrayOfByte = { -128 };
    this.cv.e((byte)9, arrayOfByte, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 1;
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = ((byte)(paramInt2 / 60 % 60 * (paramInt2 / 60 / 60)));
    arrayOfByte[4] = ((byte)(paramInt2 % 60));
    this.cv.e((byte)9, arrayOfByte, 5);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 / 1000;
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 13;
    arrayOfByte[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    int j = i / 60 / 60;
    arrayOfByte[3] = ((byte)(0xFF & i / 60 % 60 + j * 60));
    arrayOfByte[4] = ((byte)(i % 60));
    this.cv.e((byte)9, arrayOfByte, 5);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = this.cv.l();
    if (j == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 56:
      case 41:
      case 50:
      case 48:
      case 8:
      case 54:
      case 33:
      case 59:
      case 6:
      case 51:
      case 52:
      case 53:
      case 2:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
      {
        byte[] arrayOfByte9 = new byte[2];
        arrayOfByte9[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte9);
        byte[] arrayOfByte10 = new byte[8];
        arrayOfByte10[0] = 56;
        arrayOfByte10[1] = 6;
        for (int i5 = 0; i5 < 6; i5++)
          arrayOfByte10[(i5 + 2)] = paramArrayOfByte[(i5 + (paramInt1 + 3))];
        if ((j == 0) && (this.dx))
        {
          this.dx = false;
          B(51 + (0x3 & arrayOfByte10[3]));
        }
        this.cv.d(arrayOfByte10);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
        {
          int i3 = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
          if (i3 >= 32768)
            i3 += 0;
          int i4 = i3 * 35 / 5450;
          Intent localIntent2 = new Intent("com.microntek.canbusbackview");
          localIntent2.putExtra("canbustype", this.e);
          localIntent2.putExtra("lfribackview", 0 - i4);
          this.mContext.sendBroadcast(localIntent2);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] >= 7) && (paramArrayOfByte[(paramInt1 + 3)] == 2))
          {
            byte[] arrayOfByte8 = new byte[7];
            for (int i2 = 0; i2 < 7; i2++)
              arrayOfByte8[i2] = ((byte)(0xF & 0 - (-5 + paramArrayOfByte[(i2 + (paramInt1 + 3))])));
            this.aY.max = 5;
            this.aY.back_cnt = 3;
            this.aY.b1 = arrayOfByte8[1];
            this.aY.b2 = arrayOfByte8[2];
            this.aY.b3 = arrayOfByte8[3];
            if ((arrayOfByte8[4] == 0) && (arrayOfByte8[5] == 0) && (arrayOfByte8[6] == 0));
            for (this.aY.front_cnt = 0; ; this.aY.front_cnt = 3)
            {
              this.aY.f1 = arrayOfByte8[4];
              this.aY.f2 = arrayOfByte8[5];
              this.aY.f3 = arrayOfByte8[6];
              this.cv.a(this.aY);
              break;
            }
            if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
            {
              byte[] arrayOfByte7 = new byte[6];
              for (int i1 = 0; i1 < 6; i1++)
                arrayOfByte7[i1] = ((byte)(0xF & 0 - (-5 + paramArrayOfByte[(i1 + (paramInt1 + 3))])));
              this.aY.max = 5;
              this.aY.back_cnt = 3;
              this.aY.b1 = arrayOfByte7[3];
              this.aY.b2 = arrayOfByte7[4];
              this.aY.b3 = arrayOfByte7[5];
              this.aY.front_cnt = 3;
              this.aY.f1 = arrayOfByte7[0];
              this.aY.f2 = arrayOfByte7[1];
              this.aY.f3 = arrayOfByte7[2];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
              {
                byte[] arrayOfByte6 = new byte[6];
                for (int n = 0; n < 6; n++)
                  if (paramArrayOfByte[(n + (paramInt1 + 3))] != 0)
                    arrayOfByte6[n] = ((byte)(0xF & 0 - (-5 + paramArrayOfByte[(n + (paramInt1 + 3))])));
                this.aY.max = 4;
                this.aY.back_cnt = 3;
                this.aY.b1 = arrayOfByte6[3];
                this.aY.b2 = arrayOfByte6[4];
                this.aY.b3 = arrayOfByte6[5];
                this.aY.front_cnt = 3;
                this.aY.f1 = arrayOfByte6[0];
                this.aY.f2 = arrayOfByte6[1];
                this.aY.f3 = arrayOfByte6[2];
                this.cv.a(this.aY);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                {
                  int m = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
                  String str = "";
                  if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
                    m = 0 - m;
                  if ((m >= -40) && (m <= 85))
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    Locale localLocale = Locale.US;
                    Object[] arrayOfObject = new Object[1];
                    arrayOfObject[0] = Integer.valueOf(m);
                    str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
                  }
                  Intent localIntent1 = new Intent("com.canbus.temperature");
                  localIntent1.putExtra("temperature", str);
                  this.mContext.sendBroadcast(localIntent1);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
                  {
                    byte[] arrayOfByte5 = new byte[7];
                    while (i < 7)
                    {
                      arrayOfByte5[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    m(arrayOfByte5);
                    this.cv.a(this.d);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                    {
                      byte[] arrayOfByte4 = new byte[7];
                      arrayOfByte4[0] = 59;
                      while (i < 6)
                      {
                        arrayOfByte4[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.d(arrayOfByte4);
                      continue;
                      if ((paramArrayOfByte[(paramInt1 + 2)] >= 6) && (goto 144) && (paramArrayOfByte[(paramInt1 + 2)] >= 6))
                      {
                        byte[] arrayOfByte3 = new byte[8];
                        arrayOfByte3[0] = 51;
                        arrayOfByte3[1] = 6;
                        while (i < 6)
                        {
                          arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte3);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                        {
                          byte[] arrayOfByte2 = new byte[8];
                          arrayOfByte2[0] = 52;
                          arrayOfByte2[1] = 6;
                          while (i < 6)
                          {
                            arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.d(arrayOfByte2);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                          {
                            byte[] arrayOfByte1 = new byte[8];
                            arrayOfByte1[0] = 53;
                            arrayOfByte1[1] = 6;
                            for (int k = 0; k < 6; k++)
                              arrayOfByte1[(k + 2)] = paramArrayOfByte[(k + (paramInt1 + 3))];
                            this.cv.d(arrayOfByte1);
                            continue;
                            if ((paramArrayOfByte[(paramInt1 + 2)] >= 1) && (paramArrayOfByte[(paramInt1 + 3)] == 32))
                              this.dx = true;
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bi
 * JD-Core Version:    0.6.2
 */