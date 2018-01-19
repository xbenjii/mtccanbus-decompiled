package android.microntek.canbus.c;

import android.os.Handler;
import android.os.Message;

class cr extends Handler
{
  cr(cq paramcq)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    cq.a(this.dS).removeMessages(0);
    cq.a(this.dS, true);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cr
 * JD-Core Version:    0.6.2
 */