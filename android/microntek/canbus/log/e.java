package android.microntek.canbus.log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class e
  implements AdapterView.OnItemSelectedListener
{
  e(CanBusLogActivity paramCanBusLogActivity)
  {
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CanBusLogActivity.a(this.cS, paramInt);
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.e
 * JD-Core Version:    0.6.2
 */