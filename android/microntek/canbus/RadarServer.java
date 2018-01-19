package android.microntek.canbus;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.microntek.canbus.serializable.Radar;
import android.microntek.canbus.view.Cicleview;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;

public class RadarServer extends Service
{
  public static int e = 1;
  private View a;
  private Radar aY;
  private View aZ;
  private SharedPreferences au;
  private WindowManager.LayoutParams b;
  private Cicleview ba;
  private ImageButton bb;
  private boolean bc;
  private WindowManager.LayoutParams bd;
  private WindowManager be;
  private Handler handler = new q(this);
  private WindowManager mWindowManager;

  private void aa()
  {
    this.bd = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.be = ((WindowManager)localApplication.getSystemService("window"));
    this.bd.type = 2002;
    this.bd.format = 1;
    this.bd.flags = 40;
    this.bd.gravity = 83;
    this.bd.x = 0;
    this.bd.y = 0;
    this.bd.width = -2;
    this.bd.height = -2;
    this.aZ = LayoutInflater.from(getApplication()).inflate(2130903051, null);
    this.be.addView(this.aZ, this.bd);
    this.bb = ((ImageButton)this.aZ.findViewById(2131230889));
    this.bb.setOnClickListener(new s(this));
  }

  private void ab()
  {
    if (this.a == null)
    {
      b();
      aa();
    }
    this.ba.d(this.aY);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2002;
    this.b.format = 1;
    this.b.flags = 56;
    this.b.gravity = 83;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -2;
    this.b.height = -2;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903050, null);
    if (this.bc)
      this.mWindowManager.addView(this.a, this.b);
    this.ba = ((Cicleview)this.a.findViewById(2131230887));
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.au = getSharedPreferences("spRadarService", 0);
    this.bc = this.au.getBoolean("isRadarDisplay", true);
  }

  public void onDestroy()
  {
    if (this.a != null)
    {
      if (this.bc)
        this.mWindowManager.removeView(this.a);
      this.be.removeView(this.aZ);
    }
    super.onDestroy();
  }

  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    e = paramIntent.getIntExtra("canbustype", 1);
    this.aY = ((Radar)paramIntent.getSerializableExtra("radardata"));
    this.handler.removeMessages(0);
    if ((this.aY.zero_show) || (this.aY.f1 != 0) || (this.aY.f2 != 0) || (this.aY.f3 != 0) || (this.aY.f4 != 0) || (this.aY.f5 != 0) || (this.aY.f6 != 0) || (this.aY.b1 != 0) || (this.aY.b2 != 0) || (this.aY.b3 != 0) || (this.aY.b4 != 0))
      if (!this.aY.view_show)
      {
        this.handler.removeMessages(0);
        ab();
      }
    while (true)
    {
      return;
      this.handler.sendEmptyMessageDelayed(0, 3000L);
      break;
      this.handler.sendEmptyMessage(0);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.RadarServer
 * JD-Core Version:    0.6.2
 */