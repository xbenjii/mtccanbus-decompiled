package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;

class a extends Handler
{
  a(AirServer paramAirServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
      this.i.stopSelf();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.a
 * JD-Core Version:    0.6.2
 */