package android.microntek.canbus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class k
  implements View.OnClickListener
{
  k(Canbus20Activity paramCanbus20Activity)
  {
  }

  public void onClick(View paramView)
  {
    Canbus20Activity.a(this.az, (byte)-127);
    Canbus20Activity.a(this.az, (byte)4);
    Canbus20Activity.a(this.az).setImageResource(2130837664);
    Canbus20Activity.a(this.az, true);
    Canbus20Activity.c(this.az).edit().putBoolean("status", Canbus20Activity.b(this.az)).commit();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.k
 * JD-Core Version:    0.6.2
 */