package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class ax extends a
{
  public ax(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 39;
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
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 33:
      case 35:
      case 34:
      }
    }
    do
      while (true)
      {
        return;
        this.aY.zero_show = true;
        break;
        if (paramArrayOfByte[(paramInt1 + 2)] == 5)
        {
          byte[] arrayOfByte2 = new byte[5];
          while (i < 5)
          {
            arrayOfByte2[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.d(arrayOfByte2);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
          {
            int m = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
            if (m >= 128)
              m -= 256;
            Intent localIntent = new Intent("com.microntek.canbusbackview");
            localIntent.putExtra("canbustype", this.e);
            localIntent.putExtra("lfribackview", m);
            this.mContext.sendBroadcast(localIntent);
          }
        }
      }
    while (paramArrayOfByte[(paramInt1 + 2)] != 6);
    byte[] arrayOfByte1 = new byte[6];
    int j = 0;
    label213: int k;
    if (j < 6)
    {
      if (paramArrayOfByte[(j + (paramInt1 + 3))] != 5)
        break label350;
      k = 2;
    }
    while (true)
    {
      arrayOfByte1[j] = k;
      this.aY.max = 10;
      this.aY.back_cnt = 3;
      this.aY.b1 = arrayOfByte1[0];
      this.aY.b2 = arrayOfByte1[1];
      this.aY.b3 = arrayOfByte1[2];
      this.aY.front_cnt = 3;
      this.aY.f1 = arrayOfByte1[3];
      this.aY.f2 = arrayOfByte1[4];
      this.aY.f3 = arrayOfByte1[5];
      this.cv.a(this.aY);
      j++;
      break label213;
      break;
      label350: if (paramArrayOfByte[(j + (paramInt1 + 3))] == 4)
        k = 4;
      else if (paramArrayOfByte[(j + (paramInt1 + 3))] == 3)
        k = 6;
      else if (paramArrayOfByte[(j + (paramInt1 + 3))] == 2)
        k = 8;
      else if (paramArrayOfByte[(j + (paramInt1 + 3))] == 1)
        k = 10;
      else
        k = 0;
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ax
 * JD-Core Version:    0.6.2
 */