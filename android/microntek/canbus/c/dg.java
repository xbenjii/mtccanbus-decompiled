package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class dg extends a
{
  public dg(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 89;
  }

  public void ah()
  {
    this.cv.e(1);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 14:
    default:
    case 15:
    case 13:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
      {
        Intent localIntent2 = new Intent("com.microntek.canbus.speed");
        int j = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
        localIntent2.putExtra("speed", "" + j);
        this.mContext.sendBroadcast(localIntent2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          int i = 30 * (-127 + (0xFF & paramArrayOfByte[(paramInt1 + 3)])) / 127;
          Intent localIntent1 = new Intent("com.microntek.canbusbackview");
          localIntent1.putExtra("canbustype", this.e);
          localIntent1.putExtra("lfribackview", i);
          this.mContext.sendBroadcast(localIntent1);
        }
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dg
 * JD-Core Version:    0.6.2
 */