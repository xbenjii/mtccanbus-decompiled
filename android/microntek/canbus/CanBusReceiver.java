package android.microntek.canbus;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.util.Log;

public class CanBusReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    Log.i("CanBusServer", paramIntent.getAction() + "CanBus onReceive " + BaseApplication.k());
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.CanBusServer"));
    paramContext.startServiceAsUser(localIntent, UserHandle.OWNER);
    String str;
    if (BaseApplication.k() != null)
    {
      str = paramIntent.getAction();
      Log.i("chun", "CanBusReceiver action:" + str);
      if (!str.equals("android.intent.action.USER_INITIALIZE"))
        break label149;
      BaseApplication.k().a(i);
      Settings.System.putInt(paramContext.getContentResolver(), "canbus_updata", i);
    }
    while (true)
    {
      if (i != 0)
        BaseApplication.k().q();
      return;
      label149: if ((!str.equals("android.intent.action.PRE_BOOT_COMPLETED")) && (!str.equals("android.intent.action.BOOT_COMPLETED")))
        int j = 0;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.CanBusReceiver
 * JD-Core Version:    0.6.2
 */