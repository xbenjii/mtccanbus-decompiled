package android.microntek.canbus;

import android.microntek.canbus.serializable.Warning;
import android.microntek.canbus.view.MyTextView;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;

class t extends Handler
{
  t(WarningServer paramWarningServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i;
    int j;
    if (paramMessage.what == 256)
    {
      WarningServer.a(this.bo).removeMessages(256);
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      if (i >= WarningServer.b(this.bo).aF())
        this.bo.stopSelf();
    }
    else
    {
      return;
    }
    int k = WarningServer.c(this.bo)[i].length;
    int m = WarningServer.c(this.bo)[i][j].length;
    int n = WarningServer.c(this.bo)[i][j][0];
    if (k > 1)
      if ((m <= 1) || ((n & 0xFF) != 1))
        break label508;
    label146: label239: label508: for (int i4 = 1; ; i4 = 0)
    {
      int i2 = j + 1;
      int i3;
      if (i2 > 7)
      {
        i3 = i + 1;
        i2 = 0;
      }
      while (true)
      {
        Message localMessage = WarningServer.a(this.bo).obtainMessage();
        localMessage.what = 256;
        localMessage.arg1 = i3;
        localMessage.arg2 = i2;
        if (i >= WarningServer.b(this.bo).aF())
          break;
        if (i4 != 0)
        {
          if (m >= 3)
          {
            WarningServer.d(this.bo).setVisibility(0);
            WarningServer.d(this.bo).setImageResource(WarningServer.c(this.bo)[i][j][2]);
            if (m < 4)
              break label448;
            WarningServer.e(this.bo).setVisibility(0);
            WarningServer.e(this.bo).setImageResource(WarningServer.c(this.bo)[i][j][3]);
            if (m < 2)
              break label462;
            WarningServer.f(this.bo).setVisibility(0);
            WarningServer.f(this.bo).setText(this.bo.getString(WarningServer.c(this.bo)[i][j][1]));
            WarningServer.f(this.bo).j(this.bo.getString(WarningServer.c(this.bo)[i][j][1]));
          }
          while (true)
          {
            WarningServer.g(this.bo);
            WarningServer.i(this.bo).setOnClickListener(new u(this, localMessage));
            if ((0xFF00 & n) != 61440)
              break;
            WarningServer.a(this.bo).sendMessageDelayed(localMessage, 5000L);
            break;
            int i1 = i + 1;
            i2 = j;
            i3 = i1;
            i = 0;
            j = 0;
            i4 = 0;
            break label146;
            WarningServer.d(this.bo).setVisibility(4);
            break label239;
            WarningServer.e(this.bo).setVisibility(4);
            break label279;
            WarningServer.f(this.bo).setVisibility(4);
          }
        }
        WarningServer.h(this.bo);
        WarningServer.a(this.bo).sendMessageDelayed(localMessage, 2L);
        break;
        i3 = i;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.t
 * JD-Core Version:    0.6.2
 */