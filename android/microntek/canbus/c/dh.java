package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class dh extends a
{
  public dh(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
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
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 33:
    case 17:
    case 19:
    case 65:
    case -63:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 12)
      {
        int[] arrayOfInt = new int[12];
        int i = 0;
        if (i < 12)
        {
          arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]);
          if (arrayOfInt[i] >= 150)
            arrayOfInt[i] = 0;
          while (true)
          {
            i++;
            break;
            arrayOfInt[i] = (15 * arrayOfInt[i] / 150);
          }
        }
        if (this.cv.l() == 0);
        for (this.aY.zero_show = false; ; this.aY.zero_show = true)
        {
          this.aY.max = 15;
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
          break;
        }
        if ((paramArrayOfByte[(paramInt1 + 2)] != 14) || (goto 56) || (paramArrayOfByte[(paramInt1 + 2)] != 14) || (goto 56) || (paramArrayOfByte[(paramInt1 + 2)] != 14) || (goto 56) || (paramArrayOfByte[(paramInt1 + 2)] != 14));
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dh
 * JD-Core Version:    0.6.2
 */