package android.microntek.canbus.c;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.text.format.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ai extends a
{
  public ai(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 24;
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
    String str = Settings.System.getString(this.cv.getContentResolver(), "TimeZone");
    if ((str != null) && (!str.equals("")))
      ((AlarmManager)this.cv.getSystemService("alarm")).setTimeZone(str);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.getTime();
    localCalendar.setTime(new Date(112, 2, 31, 0, 0));
    long l = Settings.System.getLong(this.cv.getContentResolver(), "getTimeInMillis", localCalendar.getTimeInMillis());
    SystemClock.setCurrentTimeMillis(l);
    this.cv.sendBroadcastAsUser(new Intent("android.intent.action.TIME_SET"), UserHandle.CURRENT_OR_SELF);
    SystemClock.setCurrentTimeMillis(l);
    this.cv.sendBroadcastAsUser(new Intent("android.intent.action.TIME_SET"), UserHandle.CURRENT_OR_SELF);
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = ((byte)(0x7F & this.hour));
    arrayOfByte[1] = ((byte)(0xFF & this.minute));
    arrayOfByte[2] = ((byte)localTime.monthDay);
    arrayOfByte[3] = ((byte)(1 + localTime.month));
    arrayOfByte[4] = ((byte)(-2000 + localTime.year));
    this.cv.a((byte)-125, arrayOfByte, 5);
    long l = Calendar.getInstance().getTimeInMillis();
    Settings.System.putLong(this.cv.getContentResolver(), "getTimeInMillis", l);
    TimeZone localTimeZone = TimeZone.getDefault();
    Settings.System.putString(this.cv.getContentResolver(), "TimeZone", localTimeZone.getID());
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
      case 8:
      case 28:
      case 36:
      case 4:
      case 7:
      case 3:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
      {
        byte[] arrayOfByte4 = new byte[1];
        arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte4);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 8)
        {
          int[] arrayOfInt = new int[8];
          for (int i2 = 0; i2 < 8; i2++)
          {
            arrayOfInt[i2] = (0xF & paramArrayOfByte[(i2 + (paramInt1 + 3))]);
            if (arrayOfInt[i2] != 0)
              arrayOfInt[i2] = (0 - (-11 + arrayOfInt[i2]));
          }
          this.aY.max = 10;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfInt[0];
          this.aY.b2 = arrayOfInt[1];
          this.aY.b3 = arrayOfInt[2];
          this.aY.b4 = arrayOfInt[3];
          this.aY.front_cnt = 4;
          this.aY.f1 = arrayOfInt[4];
          this.aY.f2 = arrayOfInt[5];
          this.aY.f3 = arrayOfInt[6];
          this.aY.f4 = arrayOfInt[7];
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
          {
            int n = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
            if (n >= 128)
              n = 128 - n;
            int i1 = n * 35 / 50;
            Intent localIntent2 = new Intent("com.microntek.canbusbackview");
            localIntent2.putExtra("canbustype", this.e);
            localIntent2.putExtra("lfribackview", 0 - i1);
            this.mContext.sendBroadcast(localIntent2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 5)
            {
              byte[] arrayOfByte3 = new byte[6];
              arrayOfByte3[0] = 4;
              for (int m = 0; m < 5; m++)
                arrayOfByte3[(m + 1)] = paramArrayOfByte[(m + (paramInt1 + 3))];
              this.cv.d(arrayOfByte3);
              if (arrayOfByte3[4] == 1)
              {
                this.cA = false;
              }
              else
              {
                this.cA = true;
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                {
                  byte[] arrayOfByte2 = new byte[3];
                  arrayOfByte2[0] = 7;
                  while (i < 2)
                  {
                    arrayOfByte2[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.d(arrayOfByte2);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                  {
                    int j = ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8) + (0xFF & paramArrayOfByte[(paramInt1 + 4)]);
                    if (j >= 32768)
                      j += 0;
                    StringBuilder localStringBuilder1;
                    Locale localLocale1;
                    Object[] arrayOfObject1;
                    if (this.cA)
                    {
                      localStringBuilder1 = new StringBuilder();
                      localLocale1 = Locale.US;
                      arrayOfObject1 = new Object[1];
                      arrayOfObject1[0] = Float.valueOf(0.5F * j);
                    }
                    byte[] arrayOfByte1;
                    StringBuilder localStringBuilder2;
                    Locale localLocale2;
                    Object[] arrayOfObject2;
                    for (String str = String.format(localLocale1, " %.1f", arrayOfObject1) + this.mContext.getString(2131099651); ; str = String.format(localLocale2, " %.0f", arrayOfObject2) + this.mContext.getString(2131099652))
                    {
                      Intent localIntent1 = new Intent("com.canbus.temperature");
                      localIntent1.putExtra("temperature", str);
                      this.mContext.sendBroadcast(localIntent1);
                      arrayOfByte1 = new byte[9];
                      arrayOfByte1[0] = 3;
                      for (int k = 0; k < 8; k++)
                        arrayOfByte1[(k + 1)] = paramArrayOfByte[(k + (paramInt1 + 3))];
                      localStringBuilder2 = new StringBuilder();
                      localLocale2 = Locale.US;
                      arrayOfObject2 = new Object[1];
                      arrayOfObject2[0] = Float.valueOf(1.0F * j);
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

  public void l(int paramInt)
  {
  }

  void n(byte[] paramArrayOfByte)
  {
    int i = 1;
    if (this.cv.y == i)
    {
      Door localDoor2 = this.aB;
      if ((0x40 & paramArrayOfByte[0]) != 0)
      {
        int j = i;
        if ((0x80 & paramArrayOfByte[0]) == 0)
          break label125;
        int m = i;
        label44: if ((0x10 & paramArrayOfByte[0]) == 0)
          break label131;
        int i1 = i;
        label56: if ((0x20 & paramArrayOfByte[0]) == 0)
          break label137;
        int i3 = i;
        label68: if ((0x8 & paramArrayOfByte[0]) == 0)
          break label143;
        int i5 = i;
        label80: if ((0x0 & paramArrayOfByte[0]) == 0)
          break label149;
        label88: if (localDoor2.a(j, m, i1, i3, i5, i))
          this.cv.a(this.aB);
      }
    }
    label131: label137: label143: label149: label278: label284: label290: label293: 
    while (true)
    {
      return;
      int k = 0;
      break;
      label125: int n = 0;
      break label44;
      int i2 = 0;
      break label56;
      int i4 = 0;
      break label68;
      int i6 = 0;
      break label80;
      boolean bool1 = false;
      break label88;
      Door localDoor1 = this.aB;
      boolean bool2;
      label172: boolean bool3;
      label184: boolean bool4;
      label196: boolean bool5;
      label208: boolean bool6;
      if ((0x80 & paramArrayOfByte[0]) != 0)
      {
        bool2 = bool1;
        if ((0x40 & paramArrayOfByte[0]) == 0)
          break label266;
        bool3 = bool1;
        if ((0x20 & paramArrayOfByte[0]) == 0)
          break label272;
        bool4 = bool1;
        if ((0x10 & paramArrayOfByte[0]) == 0)
          break label278;
        bool5 = bool1;
        if ((0x8 & paramArrayOfByte[0]) == 0)
          break label284;
        bool6 = bool1;
        label220: if ((0x0 & paramArrayOfByte[0]) == 0)
          break label290;
      }
      while (true)
      {
        if (!localDoor1.a(bool2, bool3, bool4, bool5, bool6, bool1))
          break label293;
        this.cv.a(this.aB);
        break;
        bool2 = false;
        break label172;
        bool3 = false;
        break label184;
        bool4 = false;
        break label196;
        bool5 = false;
        break label208;
        bool6 = false;
        break label220;
        bool1 = false;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ai
 * JD-Core Version:    0.6.2
 */