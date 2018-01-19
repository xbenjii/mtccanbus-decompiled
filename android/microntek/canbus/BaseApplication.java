package android.microntek.canbus;

import android.app.Application;
import android.media.AudioManager;
import android.microntek.canbus.d.a;
import android.provider.Settings.System;
import android.util.Log;

public class BaseApplication extends Application
{
  private static BaseApplication v;
  private int A = 0;
  private int e = 0;
  private o w;
  private boolean x = true;
  private int y = 0;
  private int z = 0;

  private void init()
  {
    String str3;
    if (a.aV() > 19)
      str3 = getParameters("cfg_cansub_1=");
    try
    {
      this.y = Integer.parseInt(str3);
      try
      {
        label25: this.z = Integer.parseInt(getParameters("cfg_cansub_3="));
        try
        {
          label38: this.A = Integer.parseInt(getParameters("cfg_cansub_7="));
          while (true)
          {
            label51: String str2 = getParameters("cfg_canbus=");
            try
            {
              this.e = Integer.parseInt(str2);
              return;
              str1 = getParameters("cfg_canbus_cfg=");
            }
            catch (Exception localException2)
            {
              try
              {
                String str1;
                this.y = Integer.parseInt(str1);
                label82: this.y >>= 4;
                continue;
                localException2 = localException2;
              }
              catch (Exception localException1)
              {
                break label82;
              }
            }
          }
        }
        catch (Exception localException5)
        {
          break label51;
        }
      }
      catch (Exception localException4)
      {
        break label38;
      }
    }
    catch (Exception localException3)
    {
      break label25;
    }
  }

  public static BaseApplication k()
  {
    return v;
  }

  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public boolean c(int paramInt)
  {
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 58) || (paramInt == 47) || (paramInt == 60) || (paramInt == 59) || (paramInt == 64) || (paramInt == 16) || (paramInt == 32));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String getParameters(String paramString)
  {
    return ((AudioManager)getSystemService("audio")).getParameters(paramString);
  }

  public int l()
  {
    return Settings.System.getInt(getContentResolver(), "microntek.backview.state", 0);
  }

  public int m()
  {
    return this.A;
  }

  public int n()
  {
    return this.y;
  }

  public int o()
  {
    return this.z;
  }

  public void onCreate()
  {
    super.onCreate();
    v = this;
    this.w = new o();
    init();
    Log.i("CanBusServer", "CanBus Application  onCreate! ");
  }

  public int p()
  {
    return this.e;
  }

  public void q()
  {
    this.w.b(v);
  }

  public boolean r()
  {
    return this.x;
  }

  public void setParameters(String paramString)
  {
    ((AudioManager)getSystemService("audio")).setParameters(paramString);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.BaseApplication
 * JD-Core Version:    0.6.2
 */