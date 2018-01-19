package android.microntek.canbus;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.microntek.canbus.d.a;
import android.microntek.canbus.serializable.Door;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

public class DoorServer extends Service
{
  private View a;
  private boolean aA = false;
  private Door aB;
  private WindowManager.LayoutParams b;
  private int e = 1;
  private boolean g = false;
  private Handler handler = new n(this);
  private WindowManager mWindowManager;

  private void X()
  {
    if (this.aB == null);
    while (true)
    {
      return;
      ImageView localImageView1 = (ImageView)this.a.findViewById(2131230883);
      ImageView localImageView2 = (ImageView)this.a.findViewById(2131230884);
      ImageView localImageView3 = (ImageView)this.a.findViewById(2131230885);
      ImageView localImageView4 = (ImageView)this.a.findViewById(2131230886);
      ImageView localImageView5 = (ImageView)this.a.findViewById(2131230881);
      ImageView localImageView6 = (ImageView)this.a.findViewById(2131230882);
      if (this.g)
        if (this.aB.frontPassenger)
        {
          localImageView1.setImageResource(2130837727);
          label112: if (!this.aB.frontDriver)
            break label213;
          localImageView3.setImageResource(2130837792);
          label128: if (!this.aA)
            break label294;
          if (!this.aB.rearRight)
            break label275;
          localImageView2.setImageResource(2130837733);
          label151: if (!this.aB.rearLeft)
            break label284;
          localImageView4.setImageResource(2130837810);
          label168: if (!this.aB.trunk)
            break label349;
          localImageView5.setImageResource(2130837579);
        }
      while (true)
      {
        if (!this.aB.front)
          break label359;
        localImageView6.setVisibility(0);
        break;
        localImageView1.setImageResource(2130837726);
        break label112;
        label213: localImageView3.setImageResource(2130837791);
        break label128;
        if (this.aB.frontDriver)
          localImageView1.setImageResource(2130837727);
        while (true)
        {
          if (!this.aB.frontPassenger)
            break label266;
          localImageView3.setImageResource(2130837792);
          break;
          localImageView1.setImageResource(2130837726);
        }
        label266: localImageView3.setImageResource(2130837791);
        break label128;
        label275: localImageView2.setImageResource(2130837732);
        break label151;
        label284: localImageView4.setImageResource(2130837809);
        break label168;
        label294: if (this.aB.rearLeft)
          localImageView2.setImageResource(2130837733);
        while (true)
        {
          if (!this.aB.rearRight)
            break label339;
          localImageView4.setImageResource(2130837810);
          break;
          localImageView2.setImageResource(2130837732);
        }
        label339: localImageView4.setImageResource(2130837809);
        break label168;
        label349: localImageView5.setImageResource(2130837578);
      }
      label359: localImageView6.setVisibility(8);
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
    this.b.flags = 56;
    this.b.gravity = 81;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -2;
    this.b.height = -2;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903049, null);
    this.mWindowManager.addView(this.a, this.b);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  @SuppressLint({"NewApi"})
  public void onCreate()
  {
    super.onCreate();
    b();
    if (a.aV() > 19)
    {
      if (BaseApplication.k().getParameters("cfg_cansub_6=").equals("1"))
        this.g = true;
      if (BaseApplication.k().getParameters("cfg_cansub_8=").equals("1"))
        this.aA = true;
    }
    while (true)
    {
      return;
      if (BaseApplication.k().getParameters("cfg_rudder=").equals("1"))
        this.g = true;
    }
  }

  public void onDestroy()
  {
    if (this.a != null)
      this.mWindowManager.removeView(this.a);
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    this.e = paramIntent.getIntExtra("canbustype", 1);
    this.aB = ((Door)paramIntent.getSerializableExtra("doordata"));
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessageDelayed(0, 3000L);
    X();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.DoorServer
 * JD-Core Version:    0.6.2
 */