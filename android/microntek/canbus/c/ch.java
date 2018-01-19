package android.microntek.canbus.c;

import android.microntek.canbus.CanBusServer;
import android.os.Handler;
import android.os.Message;

class ch extends Handler
{
  ch(cg paramcg)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    cg.a(this.dK).removeMessages(0);
    cg.a(this.dK).sendEmptyMessageDelayed(0, 180L);
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 38;
    this.dK.cv.a((byte)-112, arrayOfByte, 2);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ch
 * JD-Core Version:    0.6.2
 */