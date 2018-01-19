package android.microntek.canbus.log;

import android.view.View;
import android.view.View.OnClickListener;

class c
  implements View.OnClickListener
{
  c(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onClick(View paramView)
  {
    if ((CanBusLogActivity.a(this.cS) != null) && (!CanBusLogActivity.a(this.cS).equals("")))
      new Thread(new d(this)).run();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.c
 * JD-Core Version:    0.6.2
 */