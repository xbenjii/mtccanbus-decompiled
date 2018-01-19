package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;

class n extends Handler
{
  n(DoorServer paramDoorServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
      this.aC.stopSelf();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.n
 * JD-Core Version:    0.6.2
 */