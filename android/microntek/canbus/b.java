package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;

class b extends Handler
{
  b(Ajxserver paramAjxserver)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
      this.u.stopSelf();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.b
 * JD-Core Version:    0.6.2
 */