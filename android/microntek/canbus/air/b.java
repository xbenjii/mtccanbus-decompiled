package android.microntek.canbus.air;

import android.microntek.canbus.a.e;
import android.os.Handler;
import android.os.Message;

class b extends e
{
  b(AirControlActivity paramAirControlActivity)
  {
  }

  public void h(byte[] paramArrayOfByte)
  {
    Message localMessage = AirControlActivity.c(this.bK).obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramArrayOfByte;
    AirControlActivity.c(this.bK).sendMessage(localMessage);
  }

  public void x()
  {
    AirControlActivity.c(this.bK).removeMessages(0);
    AirControlActivity.c(this.bK).sendEmptyMessageDelayed(0, 5L);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.air.b
 * JD-Core Version:    0.6.2
 */