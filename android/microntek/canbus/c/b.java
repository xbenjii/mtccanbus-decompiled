package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class b extends a
{
  public b(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 2;
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
    case 2:
    case 3:
    case 4:
    case 6:
    case 7:
    case 8:
    case -124:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
      {
        int i1 = 2 * paramArrayOfByte[(paramInt1 + 3)];
        this.cv.a(-1, i1);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          int n = 2 * paramArrayOfByte[(paramInt1 + 3)];
          this.cv.a(n, -1);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
          {
            paramArrayOfByte[(paramInt1 + 3)];
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 1)
            {
              int m = 3 * (-2 + paramArrayOfByte[(paramInt1 + 3)]);
              this.cv.a(-1, -1, m);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 1)
              {
                int k = 3 * (-2 + paramArrayOfByte[(paramInt1 + 3)]);
                this.cv.a(k, -1, -1);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                {
                  int j = 3 * (-2 + paramArrayOfByte[(paramInt1 + 3)]);
                  this.cv.a(-1, j, -1);
                  continue;
                  if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                  {
                    int i = paramArrayOfByte[(paramInt1 + 3)];
                    String str = "";
                    if ((i >= -40) && (i <= 50))
                      str = " " + i + this.mContext.getString(2131099651);
                    Intent localIntent = new Intent("com.canbus.temperature");
                    localIntent.putExtra("temperature", str);
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

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.b
 * JD-Core Version:    0.6.2
 */