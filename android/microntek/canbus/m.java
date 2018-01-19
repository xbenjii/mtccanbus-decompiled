package android.microntek.canbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class m extends BroadcastReceiver
{
  m(Canbus20Activity paramCanbus20Activity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals(Canbus20Activity.d(this.az)))
    {
      this.az.av = paramIntent.getByteArrayExtra("syncdata");
      if (this.az.av != null)
        break label41;
    }
    while (true)
    {
      return;
      label41: Canbus20Activity.a(this.az, this.az.av);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.m
 * JD-Core Version:    0.6.2
 */