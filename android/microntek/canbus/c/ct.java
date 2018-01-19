package android.microntek.canbus.c;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.Ringtone;
import android.microntek.canbus.CanBusServer;

class ct
  implements DialogInterface.OnClickListener
{
  ct(cq paramcq)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cq.b(this.dS).stop();
    cq.c(this.dS);
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.microntek.controlinfo", "com.microntek.controlinfo.canbus80tpmsinfo"));
    localIntent.setFlags(268435456);
    this.dS.cv.startActivity(localIntent);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ct
 * JD-Core Version:    0.6.2
 */