package android.microntek.canbus.log;

import android.content.Intent;
import android.os.UserHandle;
import android.view.View;
import android.view.View.OnClickListener;

class f
  implements View.OnClickListener
{
  f(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onClick(View paramView)
  {
    CanBusLogActivity.b(this.cS, true);
    byte[] arrayOfByte = { 46, -1, 1, 0, -1 };
    Intent localIntent = new Intent("com.hiworld.canbus.send");
    localIntent.putExtra("com.hiworld.sendkey", arrayOfByte);
    this.cS.sendBroadcastAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.f
 * JD-Core Version:    0.6.2
 */