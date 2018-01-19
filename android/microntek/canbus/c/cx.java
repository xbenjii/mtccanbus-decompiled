package android.microntek.canbus.c;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.Ringtone;
import android.microntek.canbus.CanBusServer;

class cx
  implements DialogInterface.OnClickListener
{
  cx(cu paramcu)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cu.b(this.dT).stop();
    cu.c(this.dT);
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.microntek.controlinfo", "com.microntek.controlinfo.canbus81tpmsinfo"));
    localIntent.setFlags(268435456);
    this.dT.cv.startActivity(localIntent);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cx
 * JD-Core Version:    0.6.2
 */