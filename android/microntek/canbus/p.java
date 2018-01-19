package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;

class p extends Handler
{
  p(ParkServer paramParkServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
      this.aX.stopSelf();
    while (true)
    {
      return;
      if (1 == paramMessage.what)
      {
        ParkServer.a(this.aX, ParkServer.a(this.aX));
        ParkServer.b(this.aX).removeMessages(1);
        ParkServer.b(this.aX).sendEmptyMessageDelayed(1, 500L);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.p
 * JD-Core Version:    0.6.2
 */