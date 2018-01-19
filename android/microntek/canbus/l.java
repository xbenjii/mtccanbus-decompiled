package android.microntek.canbus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class l
  implements View.OnClickListener
{
  l(Canbus20Activity paramCanbus20Activity)
  {
  }

  public void onClick(View paramView)
  {
    if (!Canbus20Activity.b(this.az))
    {
      Canbus20Activity.a(this.az, true);
      Canbus20Activity.a(this.az, (byte)-127);
      Canbus20Activity.ax = 1;
      BaseApplication.k().setParameters("av_channel_enter=line");
      Canbus20Activity.a(this.az).setImageResource(2130837664);
      Canbus20Activity.c(this.az).edit().putBoolean("status", Canbus20Activity.b(this.az)).commit();
    }
    while (true)
    {
      return;
      Canbus20Activity.a(this.az, false);
      Canbus20Activity.a(this.az, (byte)-128);
      Canbus20Activity.a(this.az).setImageResource(2130837665);
      Canbus20Activity.c(this.az).edit().putBoolean("status", Canbus20Activity.b(this.az)).commit();
      Canbus20Activity.ax = 0;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.l
 * JD-Core Version:    0.6.2
 */