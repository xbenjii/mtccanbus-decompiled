package android.microntek.canbus.c;

import android.microntek.canbus.CanBusServer;
import android.os.Handler;
import android.os.Message;

class dc extends Handler
{
  dc(db paramdb)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (db.a(this.dV) <= 5)
    {
      db.b(this.dV);
      this.dV.mHandler.removeMessages(0);
      this.dV.mHandler.sendEmptyMessageDelayed(0, 1000L);
      byte[] arrayOfByte = { 7, 1 };
      this.dV.cv.f((byte)-14, arrayOfByte, 2);
    }
    while (true)
    {
      return;
      this.dV.mHandler.removeMessages(0);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dc
 * JD-Core Version:    0.6.2
 */