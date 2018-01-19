package android.microntek.canbus.c;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.Window;
import java.util.Locale;

public class cq extends a
{
  private AlertDialog dP = null;
  private Ringtone dQ;
  private boolean dR = true;
  private Handler mHandler;

  public cq(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 80;
    Uri localUri = RingtoneManager.getDefaultUri(4);
    this.dQ = RingtoneManager.getRingtone(this.mContext.getApplicationContext(), localUri);
    this.mHandler = new cr(this);
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
      this.dP = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(2131099713)).setCancelable(false).setMessage(this.mContext.getString(2131099714)).setPositiveButton(this.mContext.getString(2131099715), new ct(this)).setNegativeButton(this.mContext.getString(2131099716), new cs(this)).create();
      this.dP.getWindow().setType(2003);
    }
    if ((paramBoolean) || (this.cv.w().equals("com.microntek.controlinfo.canbus80tpmsinfo")))
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
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label299;
      this.d.modeAc = true;
      label35: if ((0x10 & paramArrayOfByte[0]) == 0)
        break label310;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.modeAuto = 2;
      label61: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label357;
      this.d.modeDual = 1;
      label77: if ((0x2 & paramArrayOfByte[0]) == 0)
        break label368;
      this.d.windFrontMax = true;
      label93: if ((0x1 & paramArrayOfByte[0]) == 0)
        break label379;
      this.d.windRear = true;
      label109: if ((0x80 & paramArrayOfByte[1]) == 0)
        break label390;
      this.d.windUp = true;
      label127: if ((0x40 & paramArrayOfByte[1]) == 0)
        break label401;
      this.d.windMid = true;
      label144: if ((0x20 & paramArrayOfByte[1]) == 0)
        break label412;
      this.d.windDown = true;
      label161: this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = v(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = v(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label443;
      if ((0x20 & paramArrayOfByte[4]) == 0)
        break label423;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.windLoop = 2;
      label262: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label463;
    }
    label299: label310: label443: label463: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      if ((0x8 & paramArrayOfByte[0]) != 0)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.modeAuto = 1;
        break label61;
      }
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      label357: this.d.modeDual = 0;
      break label77;
      label368: this.d.windFrontMax = false;
      break label93;
      label379: this.d.windRear = false;
      break label109;
      this.d.windUp = false;
      break label127;
      this.d.windMid = false;
      break label144;
      this.d.windDown = false;
      break label161;
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = 1;
      break label262;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.windLoop = 0;
      break label262;
    }
  }

  private int v(int paramInt)
  {
    int i = -1;
    int j;
    int k;
    if ((paramInt & 0x80) == 0)
    {
      j = 1;
      k = paramInt & 0x7F;
      if (j == 0)
        break label60;
      if ((k < 1) || (k > 15))
        break label52;
      i = 150 + k * 10;
    }
    while (true)
    {
      return i;
      j = 0;
      break;
      label52: continue;
      label60: if (k == 0)
        i = 0;
      else if (k == 31)
        i = 65535;
      else if ((k >= 1) && (k <= 28))
        i = 175 + k * 5;
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
    case 33:
    case 36:
    case 56:
    case 57:
    case 39:
    case 34:
    case 35:
    case 41:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
      {
        byte[] arrayOfByte4 = f(paramArrayOfByte, paramInt1 + 3, paramInt1 + 8);
        if (j(arrayOfByte4))
        {
          m(arrayOfByte4);
          this.cv.a(this.d);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && ((0x1 & paramArrayOfByte[(paramInt1 + 3)]) != 0))
          {
            byte[] arrayOfByte3 = new byte[1];
            arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte3);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 8)
            {
              String str3 = "56,8,";
              byte[] arrayOfByte2 = new byte[10];
              arrayOfByte2[0] = 56;
              arrayOfByte2[1] = 8;
              while (i < 8)
              {
                str3 = str3 + (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]) + ",";
                arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte2);
              Settings.System.putString(this.cv.getContentResolver(), "Canbus80Data38", str3);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte1 = new byte[10];
                arrayOfByte1[0] = 57;
                arrayOfByte1[1] = 2;
                int m = 0;
                String str2 = "57,2,";
                boolean bool = true;
                while (m < 2)
                {
                  str2 = str2 + (0xFF & paramArrayOfByte[(m + (paramInt1 + 3))]) + ",";
                  arrayOfByte1[(m + 2)] = paramArrayOfByte[(m + (paramInt1 + 3))];
                  if (paramArrayOfByte[(m + (paramInt1 + 3))] != 0)
                    bool = false;
                  m++;
                }
                this.cv.d(arrayOfByte1);
                int n = Settings.System.getInt(this.cv.getContentResolver(), "tpms_alarm_prompt", 1);
                if ((this.dR) && (n == 1))
                  d(bool);
                Settings.System.putString(this.cv.getContentResolver(), "Canbus80Data39", str2);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 3)
                {
                  float f = 0.5F * (0xFF & paramArrayOfByte[(paramInt1 + 4)]) - 35.0F;
                  String str1 = "";
                  StringBuilder localStringBuilder1;
                  Locale localLocale1;
                  Object[] arrayOfObject1;
                  if ((f >= -35.0F) && (f <= 50.0F))
                  {
                    if ((0x1 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
                      break label618;
                    localStringBuilder1 = new StringBuilder();
                    localLocale1 = Locale.US;
                    arrayOfObject1 = new Object[1];
                    arrayOfObject1[0] = Float.valueOf(f);
                  }
                  label618: StringBuilder localStringBuilder2;
                  Locale localLocale2;
                  Object[] arrayOfObject2;
                  for (str1 = String.format(localLocale1, " %.1f", arrayOfObject1) + this.mContext.getString(2131099651); ; str1 = String.format(localLocale2, " %.1f", arrayOfObject2) + this.mContext.getString(2131099652))
                  {
                    f(str1);
                    break;
                    localStringBuilder2 = new StringBuilder();
                    localLocale2 = Locale.US;
                    arrayOfObject2 = new Object[1];
                    arrayOfObject2[0] = Float.valueOf(f);
                  }
                  if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                  {
                    ax();
                    int[] arrayOfInt2 = new int[6];
                    for (int k = 0; k < 6; k++)
                    {
                      arrayOfInt2[k] = (0xFF & paramArrayOfByte[(k + (paramInt1 + 3))]);
                      if ((arrayOfInt2[k] != 0) && (arrayOfInt2[k] <= 32))
                        arrayOfInt2[k] = (15 * arrayOfInt2[k] / 32);
                    }
                    this.aY.max = 15;
                    this.aY.back_cnt = 4;
                    this.aY.b1 = arrayOfInt2[0];
                    this.aY.b2 = arrayOfInt2[1];
                    this.aY.b3 = arrayOfInt2[2];
                    this.aY.b4 = arrayOfInt2[3];
                    this.cv.a(this.aY);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                    {
                      ax();
                      int[] arrayOfInt1 = new int[6];
                      for (int j = 0; j < 6; j++)
                      {
                        arrayOfInt1[j] = (0xFF & paramArrayOfByte[(j + (paramInt1 + 3))]);
                        if ((arrayOfInt1[j] != 0) && (arrayOfInt1[j] <= 32))
                          arrayOfInt1[j] = (15 * arrayOfInt1[j] / 32);
                      }
                      this.aY.max = 15;
                      this.aY.front_cnt = 4;
                      this.aY.f1 = arrayOfInt1[0];
                      this.aY.f2 = arrayOfInt1[1];
                      this.aY.f3 = arrayOfInt1[2];
                      this.aY.f4 = arrayOfInt1[3];
                      this.cv.a(this.aY);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
                        o(30 * (32768 - ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 3)])) / 8874);
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
 * Qualified Name:     android.microntek.canbus.c.cq
 * JD-Core Version:    0.6.2
 */