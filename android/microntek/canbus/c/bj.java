package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class bj extends a
{
  public bj(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 51;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[1] = ((byte)(paramByte1 + 1));
      arrayOfByte[2] = ((byte)(paramInt & 0xFF));
      arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte[4] = ((byte)(paramByte2 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 5);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[1] = ((byte)(16 + (paramByte1 - 2)));
        arrayOfByte[2] = ((byte)(paramInt & 0xFF));
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[4] = ((byte)(paramByte2 + 1));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    new byte[6];
    switch (paramInt)
    {
    case 1:
    case 2:
    }
    ak();
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
    byte[] arrayOfByte = { 7 };
    this.cv.a((byte)-64, arrayOfByte, 1);
  }

  public void al()
  {
    ak();
  }

  public void am()
  {
    ak();
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 11;
    arrayOfByte[1] = 18;
    this.cv.a((byte)-64, arrayOfByte, 6);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[3];
    this.cv.a((byte)-64, arrayOfByte, 3);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ak();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = 18;
    this.cv.a((byte)-64, arrayOfByte, 6);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 48:
      case 40:
      case 38:
      case 39:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
      {
        int k = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
        if (k >= 32768)
          k += 0;
        int m = k * 35 / 9829;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", m);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
        {
          byte[] arrayOfByte3 = new byte[1];
          arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 3)];
          n(arrayOfByte3);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
          {
            byte[] arrayOfByte2 = new byte[4];
            for (int j = 0; j < 4; j++)
              arrayOfByte2[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
            this.aY.max = 4;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte2[0];
            this.aY.b2 = arrayOfByte2[1];
            this.aY.b3 = arrayOfByte2[2];
            this.aY.b4 = arrayOfByte2[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 4)
            {
              byte[] arrayOfByte1 = new byte[4];
              for (int i = 0; i < 4; i++)
                arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              this.aY.max = 4;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte1[0];
              this.aY.f2 = arrayOfByte1[1];
              this.aY.f3 = arrayOfByte1[2];
              this.aY.f4 = arrayOfByte1[3];
              this.cv.a(this.aY);
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
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bj
 * JD-Core Version:    0.6.2
 */