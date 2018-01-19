package android.microntek.canbus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

class s
  implements View.OnClickListener
{
  s(RadarServer paramRadarServer)
  {
  }

  public void onClick(View paramView)
  {
    if (RadarServer.a(this.bf))
    {
      RadarServer.a(this.bf, false);
      if (RadarServer.b(this.bf) != null)
      {
        RadarServer.c(this.bf).removeView(RadarServer.b(this.bf));
        RadarServer.d(this.bf).edit().putBoolean("isRadarDisplay", false).commit();
      }
    }
    while (true)
    {
      return;
      RadarServer.a(this.bf, true);
      if (RadarServer.b(this.bf) != null)
      {
        RadarServer.c(this.bf).addView(RadarServer.b(this.bf), RadarServer.e(this.bf));
        RadarServer.d(this.bf).edit().putBoolean("isRadarDisplay", true).commit();
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.s
 * JD-Core Version:    0.6.2
 */