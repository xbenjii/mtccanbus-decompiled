package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class dq extends a
{
  int ea = 16777215;

  public dq(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 99;
  }

  // ERROR //
  private byte[] aU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_5
    //   3: newarray byte
    //   5: astore_2
    //   6: aload_0
    //   7: getfield 24	android/microntek/canbus/c/dq:cv	Landroid/microntek/canbus/CanBusServer;
    //   10: invokevirtual 30	android/microntek/canbus/CanBusServer:getContentResolver	()Landroid/content/ContentResolver;
    //   13: ldc 32
    //   15: invokestatic 38	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +32 -> 55
    //   26: aload_3
    //   27: ldc 46
    //   29: invokevirtual 52	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: aload 5
    //   39: arraylength
    //   40: istore 7
    //   42: iload 6
    //   44: iload 7
    //   46: if_icmpge +9 -> 55
    //   49: iload 6
    //   51: iconst_5
    //   52: if_icmplt +7 -> 59
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: areturn
    //   59: aload_2
    //   60: iload 6
    //   62: aload 5
    //   64: iload 6
    //   66: aaload
    //   67: invokestatic 58	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   70: i2b
    //   71: bastore
    //   72: iinc 6 1
    //   75: goto -38 -> 37
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore 4
    //   85: goto -30 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	78	finally
    //   19	42	78	finally
    //   59	72	78	finally
    //   19	42	83	java/lang/Exception
    //   59	72	83	java/lang/Exception
  }

  private void u(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 5)
    {
      String str = (0xFF & paramArrayOfByte[0]) + "," + (0xFF & paramArrayOfByte[1]) + "," + (0xFF & paramArrayOfByte[2]) + "," + (0xFF & paramArrayOfByte[3]) + "," + (0xFF & paramArrayOfByte[4]) + ",";
      Settings.System.putString(this.cv.getContentResolver(), "Setting_0x82_CMD", str);
    }
  }

  void aT()
  {
    if (this.ea == 16777215)
      return;
    if (this.ea > 32768)
      this.ea -= 65536;
    StringBuilder localStringBuilder1;
    Locale localLocale1;
    Object[] arrayOfObject1;
    if (!this.d.tempUnit)
    {
      localStringBuilder1 = new StringBuilder();
      localLocale1 = Locale.US;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Float.valueOf(this.ea / 2.0F);
    }
    StringBuilder localStringBuilder2;
    Locale localLocale2;
    Object[] arrayOfObject2;
    for (String str = String.format(localLocale1, " %.1f", arrayOfObject1) + this.mContext.getString(2131099651); ; str = String.format(localLocale2, " %.0f", arrayOfObject2) + this.mContext.getString(2131099652))
    {
      f(str);
      break;
      localStringBuilder2 = new StringBuilder();
      localLocale2 = Locale.US;
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Float.valueOf(this.ea);
    }
  }

  public void ah()
  {
    this.cv.e(1);
    this.cv.d(1);
    ai();
  }

  public void ai()
  {
    Locale localLocale = this.cv.getResources().getConfiguration().locale;
    String str1 = localLocale.getLanguage();
    String str2 = localLocale.getCountry();
    byte[] arrayOfByte = aU();
    if ((str1.equals("zh")) && (str2.equalsIgnoreCase("CN")))
      arrayOfByte[1] = 10;
    while (true)
    {
      this.cv.a((byte)-126, arrayOfByte, 5);
      u(arrayOfByte);
      return;
      if (str1.equals("zh"))
        arrayOfByte[1] = 9;
      else if (str1.equals("en"))
        arrayOfByte[1] = 1;
      else
        arrayOfByte[1] = 0;
    }
  }

  public void aj()
  {
    int i = 1;
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte1 = new byte[5];
    arrayOfByte1[0] = ((byte)(0x7F & this.hour));
    arrayOfByte1[i] = ((byte)(0xFF & this.minute));
    arrayOfByte1[2] = ((byte)(0xFF & localTime.monthDay));
    arrayOfByte1[3] = ((byte)(0xFF & 1 + localTime.month));
    arrayOfByte1[4] = ((byte)(0xFF & -2000 + localTime.year));
    this.cv.a((byte)-122, arrayOfByte1, 5);
    byte[] arrayOfByte2 = aU();
    if (bool);
    while (true)
    {
      arrayOfByte2[4] = ((byte)i);
      this.cv.a((byte)-126, arrayOfByte2, 5);
      u(arrayOfByte2);
      return;
      i = 0;
    }
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
      e(paramArrayOfByte, paramInt1, paramInt2);
    case 15:
    case 36:
    case 8:
    case 3:
    case 4:
    case 27:
    case 5:
    case 60:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == i)
      {
        p(0xFF & paramArrayOfByte[(paramInt1 + 3)]);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= i)
        {
          int k = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          if (k >= 128)
            k = 128 - k;
          o(0 - k * 30 / 40);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= i)
          {
            byte[] arrayOfByte = new byte[i];
            arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 8)
            {
              this.ea = ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 4)]);
              aT();
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
              {
                String str3 = (0xFF & paramArrayOfByte[(paramInt1 + 1)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 2)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 4)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 5)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 6)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 7)]);
                Settings.System.putString(this.cv.getContentResolver(), "canbus99_cmd_0x04", str3);
                AirCondition localAirCondition = this.d;
                if (paramArrayOfByte[(paramInt1 + 6)] == i);
                while (true)
                {
                  localAirCondition.tempUnit = i;
                  e(paramArrayOfByte, paramInt1, paramInt2);
                  aT();
                  break;
                  i = 0;
                }
                if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                {
                  int j;
                  if (this.cv.l() == 0)
                  {
                    this.aY.zero_show = false;
                    this.aY.max = 10;
                    j = 0;
                    label484: if (j >= 4)
                      break label577;
                    this.cw[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                    if (this.cw[j] >= 253)
                      break label566;
                    this.cw[j] = (this.cw[j] * this.aY.max / 253);
                  }
                  while (true)
                  {
                    j++;
                    break label484;
                    this.aY.zero_show = i;
                    break;
                    label566: this.cw[j] = 0;
                  }
                  label577: this.aY.back_cnt = 4;
                  this.aY.b1 = this.cw[0];
                  this.aY.b2 = this.cw[i];
                  this.aY.b3 = this.cw[2];
                  this.aY.b4 = this.cw[3];
                  this.cv.a(this.aY);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                  {
                    String str2 = (0xFF & paramArrayOfByte[(paramInt1 + 1)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 2)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 4)]);
                    Settings.System.putString(this.cv.getContentResolver(), "canbus99_cmd_0x05", str2);
                    e(paramArrayOfByte, paramInt1, paramInt2);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 3)
                    {
                      String str1 = (0xFF & paramArrayOfByte[(paramInt1 + 1)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 2)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 4)]) + "," + (0xFF & paramArrayOfByte[(paramInt1 + 5)]);
                      Settings.System.putString(this.cv.getContentResolver(), "canbus99_cmd_0x3C", str1);
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
 * Qualified Name:     android.microntek.canbus.c.dq
 * JD-Core Version:    0.6.2
 */