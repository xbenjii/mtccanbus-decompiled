package android.microntek.canbus.log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class a
  implements View.OnClickListener
{
  a(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onClick(View paramView)
  {
    CanBusLogActivity.a(this.cS, "");
    CanBusLogActivity.b(this.cS).setText(CanBusLogActivity.a(this.cS));
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.a
 * JD-Core Version:    0.6.2
 */