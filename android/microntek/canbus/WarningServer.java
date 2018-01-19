package android.microntek.canbus;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.microntek.canbus.serializable.Warning;
import android.microntek.canbus.view.MyTextView;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

public class WarningServer extends Service
{
  private View a;
  private WindowManager.LayoutParams b;
  private final int bh = 256;
  private ImageView bi;
  private ImageView bj;
  private MyTextView bk;
  private boolean bl = false;
  private Button bm;
  private Warning bn = null;
  private Handler mHandler = new t(this);
  private WindowManager mWindowManager;
  private int[][][] warningInfo = (int[][][])null;

  private boolean a(int[][][] paramArrayOfInt)
  {
    boolean bool;
    if ((this.warningInfo == null) || (paramArrayOfInt.length != this.warningInfo.length))
    {
      bool = true;
      return bool;
    }
    label95: label101: for (int i = 0; ; i++)
    {
      int j = paramArrayOfInt.length;
      bool = false;
      if (i >= j)
        break;
      for (int k = 0; ; k++)
      {
        if (k >= paramArrayOfInt[i].length)
          break label101;
        for (int m = 0; ; m++)
        {
          if (m >= paramArrayOfInt[i][k].length)
            break label95;
          if (paramArrayOfInt[i][k][0] != this.warningInfo[i][k][0])
          {
            bool = true;
            break;
          }
        }
      }
    }
  }

  private void ac()
  {
    if (!this.bl)
    {
      this.bl = true;
      this.mWindowManager.addView(this.a, this.b);
      this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
  }

  private void ad()
  {
    if (this.bl)
    {
      this.bl = false;
      this.mWindowManager.removeView(this.a);
    }
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2002;
    this.b.format = 1;
    this.b.flags = 40;
    this.b.gravity = 1;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -2;
    this.b.height = -2;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903052, null);
    this.bm = ((Button)this.a.findViewById(2131230892));
    this.bi = ((ImageView)this.a.findViewById(2131230890));
    this.bj = ((ImageView)this.a.findViewById(2131230893));
    this.bk = ((MyTextView)this.a.findViewById(2131230891));
    this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    Log.i("CanBusServer", "CanBus>>WarningServer>>onCreate>>");
    b();
  }

  public void onDestroy()
  {
    this.mHandler.removeMessages(256);
    if ((this.a != null) && (this.bl))
      this.mWindowManager.removeView(this.a);
    super.onDestroy();
    Log.i("CanBusServer", "CanBus>>WarningServer>>onDestroy>>");
  }

  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    this.bn = ((Warning)paramIntent.getSerializableExtra("warningdata"));
    if (this.bn == null);
    while (true)
    {
      return;
      if (a(this.bn.aG()))
      {
        this.warningInfo = this.bn.aG();
        this.mHandler.removeMessages(256);
        Message localMessage = this.mHandler.obtainMessage();
        localMessage.what = 256;
        localMessage.arg1 = 0;
        this.mHandler.sendMessageDelayed(localMessage, 50L);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.WarningServer
 * JD-Core Version:    0.6.2
 */