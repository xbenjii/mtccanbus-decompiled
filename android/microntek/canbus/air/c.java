package android.microntek.canbus.air;

import android.os.Handler;
import android.os.Message;

class c extends Handler
{
  c(AirControlActivity paramAirControlActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      AirControlActivity.d(this.bK).ag();
      continue;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      AirControlActivity.a(this.bK, arrayOfByte);
      continue;
      this.bK.W();
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.air.c
 * JD-Core Version:    0.6.2
 */