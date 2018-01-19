package android.microntek.canbus;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class u
  implements View.OnClickListener
{
  u(t paramt, Message paramMessage)
  {
  }

  public void onClick(View paramView)
  {
    WarningServer.h(this.bq.bo);
    WarningServer.a(this.bq.bo).sendMessageDelayed(this.bp, 100L);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.u
 * JD-Core Version:    0.6.2
 */