package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Log;
import java.util.Locale;

public class cz extends a
{
  private static long de = 0L;
  private boolean dU = false;

  public cz(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void B(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.microntek.controlinfo", "com.microntek.controlinfo.canbus83carinfo"));
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

  private boolean aK()
  {
    long l = SystemClock.uptimeMillis();
    if (l - de > 1000L)
      de = l;
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 14, paramByte };
    this.cv.a((byte)-128, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label70: label104: label239: if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label356;
      this.d.modeAc = true;
      if ((0x3 & paramArrayOfByte[0] >> 4) == 0)
        break label367;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.modeAuto = 2;
      AirCondition localAirCondition2 = this.d;
      localAirCondition2.modeDual = -1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label385;
      this.d.windFrontMax = true;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label396;
      this.d.windRear = true;
      label120: switch (0xF & paramArrayOfByte[1] >> 4)
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        this.d.windLevelMax = 8;
        if ((0xF & paramArrayOfByte[2]) == 0)
        {
          this.d.windLevel = 0;
          AirCondition localAirCondition7 = this.d;
          localAirCondition7.modeAuto = 1;
          if (this.cv.y != 1)
            break label612;
          this.d.tempLeft = G(0x7F & paramArrayOfByte[3]);
          this.d.tempRight = G(0x7F & paramArrayOfByte[4]);
          if ((0x3 & paramArrayOfByte[0]) != 1)
            break label649;
          AirCondition localAirCondition6 = this.d;
          localAirCondition6.windLoop = 1;
          AirCondition localAirCondition4 = this.d;
          localAirCondition4.rearLock = -1;
          if ((0x10 & paramArrayOfByte[0]) == 0)
            break label698;
        }
        break;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
    }
    label196: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label356: this.d.modeAc = false;
      break label43;
      label367: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label70;
      this.d.windFrontMax = false;
      break label104;
      this.d.windRear = false;
      break label120;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label196;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label196;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label196;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label196;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label196;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = false;
      break label196;
      this.d.windUp = true;
      this.d.windMid = true;
      this.d.windDown = true;
      break label196;
      this.d.windLevel = (0xF & paramArrayOfByte[2]);
      break label239;
      label612: this.d.tempLeft = x(0x7F & paramArrayOfByte[3]);
      this.d.tempRight = x(0x7F & paramArrayOfByte[4]);
      break label284;
      if ((0x3 & paramArrayOfByte[0]) == 2)
      {
        AirCondition localAirCondition5 = this.d;
        localAirCondition5.windLoop = 0;
        break label310;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.windLoop = -1;
      break label310;
    }
  }

  int G(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 30)
        i = 65535;
      else if ((paramInt >= 1) && (paramInt <= 29))
      {
        if (this.dU)
          i = 135 + paramInt * 5;
        else
          i = 150 + paramInt * 10;
      }
      else
        i = -1;
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
    this.cv.a((byte)-127, new byte[] { 1 }, 1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    this.dU = false;
    if (str.equals("zh"))
      c((byte)2);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)0);
      else if (str.equals("fr"))
        c((byte)1);
      else if ((str.equals("ru")) || (str.equals("tr")))
        this.dU = true;
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
      case 56:
      case 98:
      case 31:
      case 50:
      case 66:
      case 54:
      case 59:
      case 6:
      case 51:
      case 52:
      case 53:
      case 2:
      case 65:
      case 1:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      int i5 = 0xF & paramArrayOfByte[(paramInt1 + 2)];
      if (i5 >= 3)
      {
        byte[] arrayOfByte8 = new byte[2];
        arrayOfByte8[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte8);
        byte[] arrayOfByte9 = new byte[8];
        arrayOfByte9[0] = 56;
        arrayOfByte9[1] = ((byte)i5);
        while (i < i5)
        {
          arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.d(arrayOfByte9);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
        {
          int i3 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          if (i3 >= 128)
            i3 = 128 - i3;
          int i4 = i3 * 30 / 127;
          Intent localIntent3 = new Intent("com.microntek.canbusbackview");
          localIntent3.putExtra("canbustype", this.e);
          localIntent3.putExtra("lfribackview", 0 - i4);
          this.mContext.sendBroadcast(localIntent3);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
          {
            int i2 = 30 * (-127 + (0xFF & paramArrayOfByte[(paramInt1 + 3)])) / 127;
            Intent localIntent2 = new Intent("com.microntek.canbusbackview");
            localIntent2.putExtra("canbustype", this.e);
            localIntent2.putExtra("lfribackview", i2);
            this.mContext.sendBroadcast(localIntent2);
            continue;
            int n = 0xF & paramArrayOfByte[(paramInt1 + 2)];
            if (((n == 7) || (n == 4)) && (paramArrayOfByte[(paramInt1 + 3)] == 2))
            {
              byte[] arrayOfByte7 = new byte[7];
              for (int i1 = 0; i1 < n; i1++)
                arrayOfByte7[i1] = ((byte)(0xF & 0 - (-5 + paramArrayOfByte[(i1 + (paramInt1 + 3))])));
              this.aY.max = 5;
              this.aY.back_cnt = 3;
              this.aY.b1 = arrayOfByte7[1];
              this.aY.b2 = arrayOfByte7[2];
              this.aY.b3 = arrayOfByte7[3];
              if ((arrayOfByte7[4] == 0) && (arrayOfByte7[5] == 0) && (arrayOfByte7[6] == 0));
              for (this.aY.front_cnt = 0; ; this.aY.front_cnt = 3)
              {
                this.aY.f1 = arrayOfByte7[4];
                this.aY.f2 = arrayOfByte7[5];
                this.aY.f3 = arrayOfByte7[6];
                this.cv.a(this.aY);
                break;
              }
              if (((0xF & paramArrayOfByte[(paramInt1 + 2)]) >= 4) && (paramArrayOfByte[(paramInt1 + 3)] == 2))
              {
                byte[] arrayOfByte6 = new byte[4];
                while (i < 4)
                {
                  arrayOfByte6[i] = ((byte)(0xF & 0 - (-5 + paramArrayOfByte[(i + (paramInt1 + 3))])));
                  i++;
                }
                this.aY.max = 5;
                this.aY.front_cnt = 3;
                this.aY.f1 = arrayOfByte6[1];
                this.aY.f2 = arrayOfByte6[2];
                this.aY.f3 = arrayOfByte6[3];
                this.cv.a(this.aY);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                {
                  int m = 0x7F & paramArrayOfByte[(paramInt1 + 3)];
                  if ((0x80 & paramArrayOfByte[(paramInt1 + 3)]) != 0)
                    m = 0 - m;
                  StringBuilder localStringBuilder = new StringBuilder();
                  Locale localLocale = Locale.US;
                  Object[] arrayOfObject = new Object[1];
                  arrayOfObject[0] = Integer.valueOf(m);
                  String str = String.format(localLocale, " %d", arrayOfObject) + this.mContext.getString(2131099651);
                  Intent localIntent1 = new Intent("com.canbus.temperature");
                  localIntent1.putExtra("temperature", str);
                  this.mContext.sendBroadcast(localIntent1);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                  {
                    byte[] arrayOfByte5 = new byte[7];
                    arrayOfByte5[0] = 59;
                    while (i < 6)
                    {
                      arrayOfByte5[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.d(arrayOfByte5);
                    continue;
                    if ((paramArrayOfByte[(paramInt1 + 2)] == 6) && (goto 148) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
                    {
                      byte[] arrayOfByte4 = new byte[8];
                      arrayOfByte4[0] = 51;
                      arrayOfByte4[1] = 6;
                      while (i < 6)
                      {
                        arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.d(arrayOfByte4);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                      {
                        byte[] arrayOfByte3 = new byte[8];
                        arrayOfByte3[0] = 52;
                        arrayOfByte3[1] = 6;
                        while (i < 6)
                        {
                          arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte3);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 6)
                        {
                          byte[] arrayOfByte2 = new byte[8];
                          arrayOfByte2[0] = 53;
                          arrayOfByte2[1] = 6;
                          while (i < 6)
                          {
                            arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.d(arrayOfByte2);
                          continue;
                          if (((paramArrayOfByte[(paramInt1 + 2)] == 1) || (paramArrayOfByte[(paramInt1 + 2)] == 2)) && (paramArrayOfByte[(paramInt1 + 3)] == 32) && (aK()))
                          {
                            B(1);
                            continue;
                            int j = 0xF & paramArrayOfByte[(paramInt1 + 2)];
                            if (j >= 5)
                            {
                              byte[] arrayOfByte1 = new byte[6];
                              for (int k = 0; k < j; k++)
                                arrayOfByte1[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
                              m(arrayOfByte1);
                              this.cv.a(this.d);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] != 3);
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 63)
        i = 65535;
      else if ((paramInt >= 11) && (paramInt <= 44))
        i = 150 + 10 * (paramInt - 11) / 2;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cz
 * JD-Core Version:    0.6.2
 */