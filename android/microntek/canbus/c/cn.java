package android.microntek.canbus.c;

import android.microntek.canbus.CanBusServer;
import android.os.Handler;
import android.os.Message;

class cn extends Handler
{
  cn(cm paramcm)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.dO.cv.b((byte)-3, new byte[] { 1, 0 }, 2);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cn
 * JD-Core Version:    0.6.2
 */