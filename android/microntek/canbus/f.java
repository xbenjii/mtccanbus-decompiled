package android.microntek.canbus;

import android.microntek.serial.SerialReceiver;
import android.os.Handler;
import android.os.Message;

class f
  implements SerialReceiver
{
  f(CanBusServer paramCanBusServer)
  {
  }

  public void onSerialReceived(byte[] paramArrayOfByte)
  {
    Message localMessage = CanBusServer.c(this.am).obtainMessage();
    localMessage.what = 5;
    localMessage.obj = paramArrayOfByte;
    CanBusServer.c(this.am).sendMessage(localMessage);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.f
 * JD-Core Version:    0.6.2
 */