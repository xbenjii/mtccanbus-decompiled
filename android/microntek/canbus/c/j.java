package android.microntek.canbus.c;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import java.util.Locale;

public class j extends a
{
  private static long de = 0L;
  private View a;
  private WindowManager.LayoutParams b;
  private TextView cY;
  private boolean cZ = false;
  private boolean da = false;
  private boolean db = false;
  private Object dc = new Object();
  private boolean dd;
  byte df = 1;
  private WindowManager mWindowManager;

  public j(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 10;
  }

  private boolean aK()
  {
    long l = SystemClock.uptimeMillis();
    if (l - de > 800L)
      de = l;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void aL()
  {
    if ((this.a != null) && (!this.cZ))
    {
      this.cZ = true;
      this.cY.setText(2131099718);
      this.mWindowManager.addView(this.a, this.b);
    }
  }

  private void ad()
  {
    if ((this.a != null) && (this.cZ))
    {
      this.cZ = false;
      this.mWindowManager.removeView(this.a);
    }
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = this.cv.getApplication();
    this.cv.getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2002;
    this.b.format = 1;
    this.b.flags = 40;
    this.b.gravity = 81;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -1;
    this.b.height = -1;
    this.a = LayoutInflater.from(this.cv.getApplication()).inflate(2130903044, null);
    this.cY = ((TextView)this.a.findViewById(2131230836));
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 49, paramByte };
    this.cv.a((byte)-125, arrayOfByte, 2);
  }

  private void p(byte[] paramArrayOfByte)
  {
    new Thread(new k(this, paramArrayOfByte)).start();
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    if (this.da)
      if ((paramByte1 >= 0) && (paramByte1 <= 2))
      {
        arrayOfByte[2] = 0;
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
      }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 8);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[2] = 16;
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
        continue;
        if ((paramByte1 >= 0) && (paramByte1 <= 2))
        {
          arrayOfByte[2] = ((byte)(paramByte1 + 1));
          arrayOfByte[3] = ((byte)(paramInt & 0xFF));
          arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
          arrayOfByte[5] = ((byte)(paramByte2 + 1));
        }
        else if ((paramByte1 >= 3) && (paramByte1 <= 4))
        {
          arrayOfByte[2] = ((byte)(16 + (paramByte1 - 2)));
          arrayOfByte[3] = ((byte)(paramInt & 0xFF));
          arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
          arrayOfByte[5] = ((byte)(paramByte2 + 1));
        }
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
    int i = 0;
    int j = 1;
    if (((paramInt == j) || (paramInt == 2)) && (at().indexOf("KLD") != -1));
    while (true)
    {
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("gb2312");
        byte[] arrayOfByte3 = new byte[2 + arrayOfByte2.length];
        if (paramInt != j)
          break label147;
        arrayOfByte3[0] = j;
        arrayOfByte3[1] = 1;
        if (i < arrayOfByte2.length)
        {
          arrayOfByte3[(i + 2)] = arrayOfByte2[i];
          i++;
          continue;
        }
        this.cv.a((byte)-59, arrayOfByte3, 2 + arrayOfByte2.length);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      byte[] arrayOfByte1 = new byte[8];
      arrayOfByte1[0] = 11;
      arrayOfByte1[j] = 0;
      this.cv.a((byte)-64, arrayOfByte1, 8);
      continue;
      label147: j = 2;
    }
  }

  public void ah()
  {
    if ((at().contains("HZC")) || (au().contains("HZC")))
      this.da = true;
    label135: label153: 
    while (true)
    {
      b();
      this.cv.d(1);
      this.cv.e(1);
      ai();
      if ((this.db) && (av() == 2))
      {
        if (Settings.System.getInt(this.cv.getContentResolver(), "degrees_360", 0) != 1)
          break label135;
        p(new byte[] { 97, 1 });
      }
      while (true)
      {
        return;
        if ((!at().contains("KLD")) && (!au().contains("KLD")))
          break label153;
        this.db = true;
        break;
        p(new byte[] { 96, 0 });
      }
    }
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
        c((byte)5);
      else if (str.equals("sv"))
        c((byte)12);
      else if (str.equals("es"))
        c((byte)4);
      else if (str.equals("nl"))
        c((byte)6);
      else if (str.equals("pt"))
        c((byte)7);
      else if (str.equals("nb"))
        c((byte)14);
      else if (str.equals("fi"))
        c((byte)13);
      else if (str.equals("da"))
        c((byte)11);
      else if (str.equals("pl"))
        c((byte)15);
      else if (str.equals("tr"))
        c((byte)8);
      else if (!str.equals("ar"))
        if (str.equals("ru"))
          c((byte)9);
        else if (str.equals("uk"))
          c((byte)10);
        else if (str.equals("sk"))
          c((byte)16);
        else if (str.equals("cs"))
          c((byte)17);
        else if (str.equals("hu"))
          c((byte)18);
        else if (str.equals("el"))
          c((byte)19);
        else if (str.equals("ko"))
          c((byte)20);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte1 = new byte[4];
    arrayOfByte1[0] = 1;
    if ((this.hour > 12) && (!bool))
      this.hour = (-12 + this.hour);
    for (int i = 128; ; i = 0)
    {
      if (!bool)
        i |= 64;
      arrayOfByte1[1] = ((byte)(0x7F & this.hour));
      arrayOfByte1[2] = ((byte)(0xFF & this.minute));
      arrayOfByte1[3] = ((byte)(i & 0xFF));
      this.cv.a((byte)-58, arrayOfByte1, 4);
      byte[] arrayOfByte2 = new byte[3];
      if (bool)
        arrayOfByte2[2] = 1;
      while (true)
      {
        arrayOfByte2[1] = ((byte)(0x7F & this.hour));
        arrayOfByte2[0] = ((byte)(0xFF & this.minute));
        this.cv.a((byte)-56, arrayOfByte2, 3);
        return;
        arrayOfByte2[2] = 0;
        if (this.hour == 0)
          this.hour = 12;
      }
    }
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 10;
    arrayOfByte[1] = 48;
    if ((this.cv.o != null) && (this.cv.o.startsWith("KY")))
      ak();
    while (true)
    {
      return;
      this.cv.a((byte)-64, arrayOfByte, 8);
    }
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    if ((this.cv.o != null) && (this.cv.o.startsWith("KY")))
      ak();
    while (true)
    {
      return;
      this.cv.a((byte)-64, arrayOfByte, 8);
    }
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void as()
  {
    this.cv.a((byte)-112, new byte[] { -108, 0 }, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 2;
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
    case 32:
    case 34:
    case 35:
    case 40:
    case 41:
    case -108:
    case -107:
    }
    while (true)
    {
      return;
      if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && (this.db) && (paramArrayOfByte[(paramInt1 + 4)] == 1))
        if (paramArrayOfByte[(paramInt1 + 3)] == 35)
        {
          e("av_mute=true");
          aL();
        }
        else if (paramArrayOfByte[(paramInt1 + 3)] == 36)
        {
          e("av_mute=false");
          ad();
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
          {
            ax();
            int[] arrayOfInt2 = new int[4];
            for (int m = 0; m < 4; m++)
              arrayOfInt2[m] = (0xFF & paramArrayOfByte[(m + (paramInt1 + 3))]);
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfInt2[0];
            this.aY.b2 = arrayOfInt2[1];
            this.aY.b3 = arrayOfInt2[2];
            this.aY.b4 = arrayOfInt2[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
            {
              ax();
              int[] arrayOfInt1 = new int[4];
              for (int k = 0; k < 4; k++)
                arrayOfInt1[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfInt1[0];
              this.aY.f2 = arrayOfInt1[1];
              this.aY.f3 = arrayOfInt1[2];
              this.aY.f4 = arrayOfInt1[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
              {
                byte[] arrayOfByte2 = new byte[1];
                arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
                n(arrayOfByte2);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                {
                  int j = (0x7F & paramArrayOfByte[(paramInt1 + 3)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 4)];
                  if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) == 0)
                    j = 0 - j;
                  o(j * 30 / 5400);
                  continue;
                  if (a(paramArrayOfByte[(paramInt1 + 2)], 4))
                  {
                    byte[] arrayOfByte1 = new byte[2 + this.mLength];
                    arrayOfByte1[0] = -108;
                    arrayOfByte1[1] = ((byte)this.mLength);
                    while (i < this.mLength)
                    {
                      arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.d(arrayOfByte1);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 3)] == 1)
                      e("av_mute=true");
                    else
                      e("av_mute=false");
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
    byte[] arrayOfByte = new byte[1];
    if (paramInt == 0)
      arrayOfByte[0] = -128;
    while (true)
    {
      this.cv.a((byte)-60, arrayOfByte, 1);
      return;
      arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    }
  }

  public void n(int paramInt)
  {
    boolean bool;
    int j;
    if ((aK()) && (paramInt == 513) && (this.db) && (av() == 2))
    {
      if (this.df != 1)
        break label88;
      bool = true;
      this.dd = bool;
      byte[] arrayOfByte = new byte[2];
      arrayOfByte[0] = 101;
      arrayOfByte[1] = this.df;
      p(arrayOfByte);
      int i = this.df;
      j = 0;
      if (i != 1)
        break label93;
    }
    while (true)
    {
      this.df = ((byte)j);
      return;
      label88: bool = false;
      break;
      label93: j = 1;
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
 * Qualified Name:     android.microntek.canbus.c.j
 * JD-Core Version:    0.6.2
 */