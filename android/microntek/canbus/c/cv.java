package android.microntek.canbus.c;

import android.os.Handler;
import android.os.Message;

class cv extends Handler
{
  cv(cu paramcu)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    cu.a(this.dT).removeMessages(0);
    cu.a(this.dT, true);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cv
 * JD-Core Version:    0.6.2
 */