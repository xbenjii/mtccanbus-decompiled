package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import android.provider.Settings.System;

public class cf extends a
{
  private byte[] cB = new byte[8];
  private boolean cV = true;
  private boolean cW = true;
  private boolean dw = true;

  public cf(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 72;
  }

  public void ah()
  {
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 0);
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
      case 36:
      case 112:
      case 113:
      case 114:
      case 120:
      case 121:
      case 20:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte6 = new byte[2];
        while (i < 2)
        {
          arrayOfByte6[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        n(arrayOfByte6);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 20)
        {
          byte[] arrayOfByte5 = new byte[22];
          arrayOfByte5[0] = 112;
          arrayOfByte5[1] = 20;
          while (i < 20)
          {
            arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.c(arrayOfByte5);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 20)
          {
            byte[] arrayOfByte4 = new byte[22];
            arrayOfByte4[0] = 113;
            arrayOfByte4[1] = 20;
            while (i < 20)
            {
              arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            this.cv.c(arrayOfByte4);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 5)
            {
              byte[] arrayOfByte3 = new byte[7];
              arrayOfByte3[0] = 114;
              arrayOfByte3[1] = 5;
              while (i < 5)
              {
                arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.c(arrayOfByte3);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 5)
              {
                byte[] arrayOfByte2 = new byte[7];
                arrayOfByte2[0] = 120;
                arrayOfByte2[1] = 5;
                while (i < 5)
                {
                  arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.c(arrayOfByte2);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (this.dw))
                {
                  byte[] arrayOfByte1 = new byte[3];
                  arrayOfByte1[0] = 121;
                  arrayOfByte1[1] = 1;
                  while (i < 1)
                  {
                    arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.c(arrayOfByte1);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                  {
                    int j = paramArrayOfByte[(paramInt1 + 3)];
                    Intent localIntent = new Intent("com.microntek.light");
                    localIntent.putExtra("keyCode", j & 0xFF);
                    this.mContext.sendBroadcast(localIntent);
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
 * Qualified Name:     android.microntek.canbus.c.cf
 * JD-Core Version:    0.6.2
 */