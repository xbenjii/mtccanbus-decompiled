package android.microntek.canbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class c extends BroadcastReceiver
{
  c(Ajxserver paramAjxserver)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("com.microntek.ajx"))
      Ajxserver.a(this.u).sendEmptyMessage(0);
    while (true)
    {
      return;
      if (str.equals("com.microntek.sync"))
      {
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("syncdata");
        if ((arrayOfByte != null) && ((Ajxserver.b(this.u) == 5) || (Ajxserver.b(this.u) == 55) || (Ajxserver.b(this.u) == 69)))
          Ajxserver.a(this.u, arrayOfByte);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c
 * JD-Core Version:    0.6.2
 */