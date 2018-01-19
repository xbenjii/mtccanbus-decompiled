package android.microntek.canbus.c;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.Window;
import java.util.Locale;

public class cu extends a
{
  private AlertDialog dP = null;
  private Ringtone dQ;
  private boolean dR = true;
  private Handler mHandler;

  public cu(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 81;
    Uri localUri = RingtoneManager.getDefaultUri(4);
    this.dQ = RingtoneManager.getRingtone(this.mContext.getApplicationContext(), localUri);
    this.mHandler = new cv(this);
  }

  private void aR()
  {
    this.mHandler.removeMessages(0);
    this.mHandler.sendEmptyMessageDelayed(0, 20000L);
    this.dR = false;
  }

  private void d(boolean paramBoolean)
  {
    if (this.dP == null)
    {
      this.dP = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(2131099713)).setCancelable(false).setMessage(this.mContext.getString(2131099714)).setPositiveButton(this.mContext.getString(2131099715), new cx(this)).setNegativeButton(this.mContext.getString(2131099716), new cw(this)).create();
      this.dP.getWindow().setType(2003);
    }
    if ((paramBoolean) || (this.cv.w().equals("com.microntek.controlinfo.canbus81tpmsinfo")))
    {
      this.dQ.stop();
      this.dP.cancel();
    }
    while (true)
    {
      return;
      if (!this.dP.isShowing())
      {
        this.dQ.play();
        this.dP.show();
      }
    }
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label60: label76: AirCondition localAirCondition3;
    if ((0xF & paramArrayOfByte[2]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label252;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label263;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 2;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label281;
      this.d.windRear = true;
      switch (0x7 & paramArrayOfByte[1])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        label140: this.d.windLevel = (0xF & paramArrayOfByte[2]);
        this.d.windLevelMax = 8;
        int i = 0xFF & paramArrayOfByte[3];
        this.d.tempLeft = x(i);
        int j = 0xFF & paramArrayOfByte[4];
        this.d.tempRight = x(j);
        if ((0x20 & paramArrayOfByte[0]) != 0)
          localAirCondition3 = this.d;
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    label252: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      label263: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      label281: this.d.windRear = false;
      break label76;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label140;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label140;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label140;
      localAirCondition2 = this.d;
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
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    if (!DateFormat.is24HourFormat(this.mContext))
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
    }
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = ((byte)(0xFF & localTime.year));
    arrayOfByte[1] = ((byte)(0xF & localTime.year >> 8 | 1 + localTime.month << 4));
    arrayOfByte[2] = ((byte)(0xFF & localTime.monthDay));
    arrayOfByte[3] = ((byte)(0xFF & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-126, arrayOfByte, 6);
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
    case 56:
    case 57:
    case 17:
    case 34:
    case 35:
    case 48:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        byte[] arrayOfByte4 = new byte[1];
        arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte4);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 8)
        {
          byte[] arrayOfByte3 = new byte[10];
          arrayOfByte3[0] = 56;
          arrayOfByte3[1] = 8;
          while (i < 8)
          {
            arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.d(arrayOfByte3);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
          {
            byte[] arrayOfByte2 = new byte[6];
            arrayOfByte2[0] = 57;
            arrayOfByte2[1] = 4;
            int i2 = 0;
            boolean bool = true;
            while (i2 < 4)
            {
              arrayOfByte2[(i2 + 2)] = paramArrayOfByte[(i2 + (paramInt1 + 3))];
              if (paramArrayOfByte[(i2 + (paramInt1 + 3))] != 0)
                bool = false;
              i2++;
            }
            this.cv.d(arrayOfByte2);
            int i3 = Settings.System.getInt(this.cv.getContentResolver(), "tpms_alarm_prompt", 1);
            if ((this.dR) && (i3 == 1))
            {
              d(bool);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
              {
                byte[] arrayOfByte1 = f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 8);
                if (j(arrayOfByte1))
                {
                  m(arrayOfByte1);
                  this.cv.a(this.d);
                }
                int n = 0xFF & paramArrayOfByte[(paramInt1 + 8)];
                String str = "";
                if (n < 254)
                {
                  int i1 = n - 40;
                  StringBuilder localStringBuilder = new StringBuilder();
                  Locale localLocale = Locale.US;
                  Object[] arrayOfObject = new Object[1];
                  arrayOfObject[0] = Integer.valueOf(i1);
                  str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
                }
                Intent localIntent = new Intent("com.canbus.temperature");
                localIntent.putExtra("temperature", str);
                this.mContext.sendBroadcast(localIntent);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
                {
                  if (this.cv.l() == 0);
                  int[] arrayOfInt2;
                  for (this.aY.zero_show = false; ; this.aY.zero_show = true)
                  {
                    arrayOfInt2 = new int[4];
                    for (int m = 0; m < 4; m++)
                    {
                      arrayOfInt2[m] = (0xF & paramArrayOfByte[(m + (paramInt1 + 3))]);
                      if (arrayOfInt2[m] != 0)
                        arrayOfInt2[m] = (0 - (-5 + arrayOfInt2[m]));
                    }
                  }
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
                    if (this.cv.l() == 0);
                    int[] arrayOfInt1;
                    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
                    {
                      arrayOfInt1 = new int[4];
                      for (int k = 0; k < 4; k++)
                      {
                        arrayOfInt1[k] = (0xF & paramArrayOfByte[(k + (paramInt1 + 3))]);
                        if (arrayOfInt1[k] != 0)
                          arrayOfInt1[k] = (0 - (-5 + arrayOfInt1[k]));
                      }
                    }
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
                      int j = (0x7F & paramArrayOfByte[(paramInt1 + 3)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 4)];
                      if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) == 0)
                        j = 0 - j;
                      o(j * 30 / 12000);
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 30)
        i = 65535;
      else if ((paramInt > 0) && (paramInt < 30))
        i = 170 + paramInt * 5;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cu
 * JD-Core Version:    0.6.2
 */