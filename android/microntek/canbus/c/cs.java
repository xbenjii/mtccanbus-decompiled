package android.microntek.canbus.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.Ringtone;

class cs
  implements DialogInterface.OnClickListener
{
  cs(cq paramcq)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    cq.b(this.dS).stop();
    cq.c(this.dS);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cs
 * JD-Core Version:    0.6.2
 */