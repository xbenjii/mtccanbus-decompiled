package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class ad extends a
{
  public ad(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 19;
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
    case 0:
    case 66:
    case 31:
    case 34:
    case 37:
    case 4:
    case 5:
    case 54:
    case 11:
    case 113:
    }
    while (true)
    {
      return;
      if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && (goto 100) && (paramArrayOfByte[(paramInt1 + 2)] == 31))
      {
        byte[] arrayOfByte7 = new byte[33];
        arrayOfByte7[0] = 66;
        arrayOfByte7[1] = 31;
        while (i < 31)
        {
          arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.d(arrayOfByte7);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 3)
        {
          int k = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
          int m = 30 * ((0xFF & paramArrayOfByte[(paramInt1 + 5)]) + k * 256) / 450;
          if (paramArrayOfByte[(paramInt1 + 3)] == 0)
            m = 0 - m;
          Intent localIntent = new Intent("com.microntek.canbusbackview");
          localIntent.putExtra("canbustype", this.e);
          localIntent.putExtra("lfribackview", m);
          this.mContext.sendBroadcast(localIntent);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 8)
          {
            byte[] arrayOfByte6 = new byte[8];
            for (int j = 0; j < 8; j++)
              arrayOfByte6[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
            this.aY.max = 4;
            this.aY.back_cnt = 3;
            this.aY.b1 = arrayOfByte6[2];
            this.aY.b2 = arrayOfByte6[6];
            this.aY.b3 = arrayOfByte6[3];
            this.aY.front_cnt = 3;
            this.aY.f1 = arrayOfByte6[0];
            this.aY.f2 = arrayOfByte6[4];
            this.aY.f3 = arrayOfByte6[1];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 2)
            {
              byte[] arrayOfByte5 = new byte[4];
              arrayOfByte5[0] = 31;
              arrayOfByte5[1] = 2;
              while (i < 2)
              {
                arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte5);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 3)
              {
                byte[] arrayOfByte4 = new byte[1];
                arrayOfByte4[0] = paramArrayOfByte[(paramInt1 + 3)];
                n(arrayOfByte4);
                continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 5) && (goto 100) && (paramArrayOfByte[(paramInt1 + 2)] == 7))
                {
                  byte[] arrayOfByte3 = new byte[9];
                  arrayOfByte3[0] = 54;
                  arrayOfByte3[1] = 7;
                  while (i < 7)
                  {
                    arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                    i++;
                  }
                  this.cv.d(arrayOfByte3);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                  {
                    byte[] arrayOfByte2 = new byte[4];
                    arrayOfByte2[0] = 11;
                    arrayOfByte2[1] = 2;
                    while (i < 2)
                    {
                      arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.d(arrayOfByte2);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 9)
                    {
                      byte[] arrayOfByte1 = new byte[11];
                      arrayOfByte1[0] = 113;
                      arrayOfByte1[1] = 9;
                      while (i < 9)
                      {
                        arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
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
 * Qualified Name:     android.microntek.canbus.c.ad
 * JD-Core Version:    0.6.2
 */