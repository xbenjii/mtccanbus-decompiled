package android.microntek.canbus.c;

import android.os.Handler;
import android.os.Message;

class cl extends Handler
{
  cl(ck paramck)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ck.a(this.dM).removeMessages(0);
    ck.a(this.dM).sendEmptyMessageDelayed(0, 20000L);
    this.dM.aj();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cl
 * JD-Core Version:    0.6.2
 */