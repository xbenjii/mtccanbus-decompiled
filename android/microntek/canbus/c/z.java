package android.microntek.canbus.c;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.util.Locale;

public class z extends android.microntek.canbus.b.a
{
  private View a;
  private WindowManager.LayoutParams b;
  private boolean cZ = false;
  private boolean db = false;
  private int dk = 0;
  private View dl;
  private View dm;
  private WindowManager mWindowManager;

  public z(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 15;
    this.d = new AirCondition();
  }

  private void aL()
  {
    if ((this.a != null) && (!this.cZ))
    {
      this.cZ = true;
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
    this.dl = this.a.findViewById(2131230835);
    this.dm = this.a.findViewById(2131230836);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label290;
      this.d.modeAc = true;
      label43: if ((0x8 & paramArrayOfByte[0]) == 0)
        break label301;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      label69: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label319;
      this.d.modeDual = 1;
      label85: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label330;
      this.d.windFrontMax = true;
      label101: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label341;
      this.d.windUp = true;
      label119: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label352;
      this.d.windMid = true;
      label136: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label363;
      this.d.windDown = true;
      label153: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 8;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = x(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = x(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label374;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 1;
      label245: AirCondition localAirCondition3 = this.d;
      localAirCondition3.rearLock = -1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label394;
    }
    label394: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label290: this.d.modeAc = false;
      break label43;
      label301: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label319: this.d.modeDual = 0;
      break label85;
      label330: this.d.windFrontMax = false;
      break label101;
      label341: this.d.windUp = false;
      break label119;
      label352: this.d.windMid = false;
      break label136;
      label363: this.d.windDown = false;
      break label153;
      label374: AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label245;
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
    arrayOfByte[5] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void a(String paramString, int paramInt)
  {
    int i = 0;
    if (((paramInt == 1) || (paramInt == 2)) && (aw() == 3));
    while (true)
    {
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("gb2312");
        byte[] arrayOfByte3 = new byte[18];
        arrayOfByte3[0] = 5;
        arrayOfByte3[1] = 64;
        if (paramInt != 1)
          break label151;
        j = 3;
        arrayOfByte3[2] = j;
        if (i < arrayOfByte2.length)
        {
          if (i + 3 >= 18)
            break label145;
          arrayOfByte3[(i + 3)] = arrayOfByte2[i];
          break label145;
        }
        this.cv.a((byte)-64, arrayOfByte3, 18);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      byte[] arrayOfByte1 = new byte[8];
      arrayOfByte1[0] = 11;
      arrayOfByte1[1] = 48;
      this.cv.a((byte)-64, arrayOfByte1, 8);
      continue;
      label145: i++;
      continue;
      label151: int j = 0;
    }
  }

  public void ah()
  {
    this.cv.d(1);
    if (android.microntek.canbus.d.a.aV() <= 19)
      if (this.cv.y == 4)
      {
        this.dk = 2;
        this.cv.a((byte)-54, new byte[] { 2 }, 1);
      }
    while (true)
    {
      if (at().contains("KLD"))
        this.db = true;
      b();
      return;
      CanBusServer localCanBusServer = this.cv;
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)this.cv.y);
      localCanBusServer.a((byte)-54, arrayOfByte, 1);
      this.dk = this.cv.y;
    }
  }

  public void ai()
  {
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[8];
    if (!bool)
    {
      if (this.hour <= 12)
        break label118;
      this.hour = (-12 + this.hour);
    }
    while (true)
    {
      this.hour = (0x80 | this.hour);
      arrayOfByte[0] = 1;
      arrayOfByte[4] = ((byte)(0xFF & this.hour));
      arrayOfByte[5] = ((byte)(0xFF & this.minute));
      this.cv.a((byte)-58, arrayOfByte, 8);
      return;
      label118: if (this.hour == 0)
        this.hour = 12;
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
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 12;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
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
    arrayOfByte[0] = 19;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[5] = ((byte)(paramInt3 / 1000 / 60 / 60));
    arrayOfByte[6] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      case 37:
      case 38:
      default:
      case 33:
      case 39:
      case 36:
      case 34:
      case 35:
      case 32:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 5)
      {
        byte[] arrayOfByte4 = new byte[5];
        while (i < 5)
        {
          arrayOfByte4[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        m(arrayOfByte4);
        this.cv.a(this.d);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          int m = paramArrayOfByte[(paramInt1 + 3)];
          String str2 = "";
          if ((m >= -40) && (m <= 80))
            str2 = " " + m + this.mContext.getString(2131099651);
          Intent localIntent = new Intent("com.canbus.temperature");
          localIntent.putExtra("temperature", str2);
          this.mContext.sendBroadcast(localIntent);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 2)
          {
            byte[] arrayOfByte3 = new byte[1];
            arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 4)];
            n(arrayOfByte3);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte2 = new byte[4];
              for (int k = 0; k < 4; k++)
                arrayOfByte2[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
              this.aY.max = 3;
              this.aY.back_cnt = 4;
              this.aY.b1 = arrayOfByte2[0];
              this.aY.b2 = arrayOfByte2[1];
              this.aY.b3 = arrayOfByte2[2];
              this.aY.b4 = arrayOfByte2[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 4)
              {
                byte[] arrayOfByte1 = new byte[4];
                for (int j = 0; j < 4; j++)
                  arrayOfByte1[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
                this.aY.max = 3;
                this.aY.front_cnt = 4;
                this.aY.f1 = arrayOfByte1[0];
                this.aY.f2 = arrayOfByte1[1];
                this.aY.f3 = arrayOfByte1[2];
                this.aY.f4 = arrayOfByte1[3];
                this.cv.a(this.aY);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && (this.db) && (paramArrayOfByte[(paramInt1 + 4)] == 1))
                  switch (0xFF & paramArrayOfByte[(paramInt1 + 3)])
                  {
                  default:
                    break;
                  case 35:
                    e("av_mute=true");
                    aL();
                    if (this.cZ)
                    {
                      this.dm.setVisibility(0);
                      this.dl.setBackgroundResource(2130837715);
                    }
                    break;
                  case 36:
                    e("av_mute=false");
                    ad();
                    break;
                  case 37:
                    e("av_mute=true");
                    aL();
                    if (this.cZ)
                    {
                      String str1 = this.cv.getResources().getConfiguration().locale.getLanguage();
                      this.dm.setVisibility(8);
                      if (str1.equals("ru"))
                        this.dl.setBackgroundResource(2130837717);
                      else
                        this.dl.setBackgroundResource(2130837716);
                    }
                    break;
                  case 38:
                    e("av_mute=false");
                    ad();
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
    label29: boolean bool4;
    label40: boolean bool5;
    label52: boolean bool6;
    if ((0x1 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label108;
      bool3 = bool1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label114;
      bool4 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label120;
      bool5 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label126;
      bool6 = bool1;
      label64: if ((0x0 & paramArrayOfByte[0]) == 0)
        break label132;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label108: bool3 = false;
      break label29;
      label114: bool4 = false;
      break label40;
      label120: bool5 = false;
      break label52;
      label126: bool6 = false;
      break label64;
      label132: bool1 = false;
    }
  }

  int x(int paramInt)
  {
    int i = 0;
    if (this.dk == 2)
      if (paramInt != 0);
    while (true)
    {
      return i;
      if (paramInt == 34)
      {
        i = 65535;
      }
      else if ((paramInt >= 1) && (paramInt <= 33))
      {
        i = 5 * (paramInt + 30);
      }
      else
      {
        i = -1;
        continue;
        if (paramInt == 0)
          i = 0;
        else if (paramInt == 30)
          i = 65535;
        else if ((paramInt >= 1) && (paramInt <= 29))
          i = 5 * (paramInt + 34);
        else
          i = -1;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.z
 * JD-Core Version:    0.6.2
 */