package android.microntek.canbus.air;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.microntek.canbus.a.b;
import android.os.Handler;
import android.os.IBinder;

class a
  implements ServiceConnection
{
  a(AirControlActivity paramAirControlActivity)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      AirControlActivity.a(this.bK, b.a(paramIBinder));
      if (AirControlActivity.a(this.bK) != null)
        AirControlActivity.a(this.bK).a(AirControlActivity.b(this.bK));
      AirControlActivity.c(this.bK).removeMessages(0);
      AirControlActivity.c(this.bK).sendEmptyMessageDelayed(0, 0L);
      this.bK.b(false);
      this.bK.W();
      label80: return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AirControlActivity.a(this.bK, null);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.air.a
 * JD-Core Version:    0.6.2
 */