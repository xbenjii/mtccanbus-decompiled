package android.microntek.canbus.log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class b
  implements View.OnClickListener
{
  b(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onClick(View paramView)
  {
    if (CanBusLogActivity.c(this.cS).getText().equals("Start"))
    {
      CanBusLogActivity.a(this.cS, false);
      CanBusLogActivity.c(this.cS).setText("Stop");
    }
    while (true)
    {
      return;
      if (CanBusLogActivity.c(this.cS).getText().equals("Stop"))
      {
        CanBusLogActivity.a(this.cS, true);
        CanBusLogActivity.c(this.cS).setText("Start");
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.b
 * JD-Core Version:    0.6.2
 */