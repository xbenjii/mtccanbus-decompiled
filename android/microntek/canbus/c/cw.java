package android.microntek.canbus.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.Ringtone;

class cw
  implements DialogInterface.OnClickListener
{
  cw(cu paramcu)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    cu.b(this.dT).stop();
    cu.c(this.dT);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cw
 * JD-Core Version:    0.6.2
 */