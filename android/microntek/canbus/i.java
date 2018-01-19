package android.microntek.canbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.b.a;
import android.os.Handler;
import android.os.Message;

class i extends BroadcastReceiver
{
  i(CanBusServer paramCanBusServer)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((str.equals("android.intent.action.TIME_SET")) || (str.equals("android.intent.action.TIME_TICK")))
    {
      CanBusServer.c(this.am).removeMessages(2);
      CanBusServer.c(this.am).sendEmptyMessageDelayed(2, 10L);
    }
    while (true)
    {
      return;
      if (str.equals("com.microntek.VOLUME_CHANGED"))
      {
        int j = paramIntent.getIntExtra("volume", 15);
        Message localMessage = CanBusServer.c(this.am).obtainMessage();
        localMessage.what = 3;
        localMessage.arg1 = j;
        CanBusServer.c(this.am).removeMessages(3);
        CanBusServer.c(this.am).sendMessageDelayed(localMessage, 10L);
      }
      else if (str.equals("android.intent.action.LOCALE_CHANGED"))
      {
        if (CanBusServer.a(this.am) != null)
          CanBusServer.a(this.am).ai();
      }
      else if (str.equals("com.microntek.irkeyDown"))
      {
        int i = paramIntent.getIntExtra("keyCode", -1);
        CanBusServer.a(this.am, i);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.i
 * JD-Core Version:    0.6.2
 */