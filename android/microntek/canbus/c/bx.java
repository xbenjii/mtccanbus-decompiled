package android.microntek.canbus.c;

import android.microntek.canbus.CanBusServer;
import android.os.Handler;
import android.os.Message;

class bx extends Handler
{
  bx(bw parambw)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (bw.a(this.dJ) <= 5)
    {
      bw.b(this.dJ);
      this.dJ.mHandler.removeMessages(0);
      this.dJ.mHandler.sendEmptyMessageDelayed(0, 1000L);
      byte[] arrayOfByte = { 7, 1 };
      this.dJ.cv.f((byte)-14, arrayOfByte, 2);
    }
    while (true)
    {
      return;
      this.dJ.mHandler.removeMessages(0);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bx
 * JD-Core Version:    0.6.2
 */