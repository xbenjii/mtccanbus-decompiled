package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;

class q extends Handler
{
  q(RadarServer paramRadarServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
      this.bf.stopSelf();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.q
 * JD-Core Version:    0.6.2
 */