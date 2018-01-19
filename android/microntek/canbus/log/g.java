package android.microntek.canbus.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class g extends BroadcastReceiver
{
  g(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.hiworld.canbus.receiver"))
    {
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("com.hiworld.receiverkey");
      if ((arrayOfByte != null) && (arrayOfByte.length > 2))
        CanBusLogActivity.a(this.cS, arrayOfByte);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.g
 * JD-Core Version:    0.6.2
 */