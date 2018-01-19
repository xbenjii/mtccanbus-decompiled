package android.microntek.canbus.air;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;

public class AirControlActivity extends Activity
{
  private final int aa = 1;
  public int bA = 7;
  public int bB = 8;
  public int bC = 9;
  private final String bD = "android.microntek.canbus";
  private final String bE = "android.microntek.canbus.CanBusServer";
  private final int bF = 0;
  private final int bG = 2;
  private android.microntek.canbus.a.a bH;
  private ServiceConnection bI = new a(this);
  private android.microntek.canbus.a.d bJ = new b(this);
  private d bs;
  public int bt = 0;
  public int bu = 1;
  public int bv = 2;
  public int bw = 3;
  public int bx = 4;
  public int by = 5;
  public int bz = 6;
  private Handler mHandler = new c(this);

  private void a(byte[] paramArrayOfByte)
  {
    for (int i = 0; ; i++)
      if ((i >= this.bs.af().length) || (this.bs.af()[i] == paramArrayOfByte[this.bt]))
        return;
  }

  public int A()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.A();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int B()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.B();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int C()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.C();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public boolean D()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.D();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean E()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.E();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean F()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.F();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean G()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.G();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean H()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.H();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public int I()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.I();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int J()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.J();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int L()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.L();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int M()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.M();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public boolean N()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.N();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public boolean O()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.O();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public int P()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.P();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int Q()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.Q();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int R()
  {
    try
    {
      if (this.bH != null)
      {
        int j = this.bH.R();
        i = j;
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int i = 0;
    }
  }

  public int[] V()
  {
    try
    {
      if (this.bH != null)
      {
        int[] arrayOfInt2 = this.bH.V();
        arrayOfInt1 = arrayOfInt2;
        return arrayOfInt1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        int[] arrayOfInt1 = { 0 };
    }
  }

  public void W()
  {
    try
    {
      this.bH.W();
      label9: return;
    }
    catch (RemoteException localRemoteException)
    {
      break label9;
    }
  }

  public void b(boolean paramBoolean)
  {
    try
    {
      if (this.bH != null)
        this.bH.b(paramBoolean);
      label17: return;
    }
    catch (RemoteException localRemoteException)
    {
      break label17;
    }
  }

  public void e(int paramInt1, int paramInt2)
  {
    try
    {
      this.bH.b(paramInt1, paramInt2);
      label11: return;
    }
    catch (RemoteException localRemoteException)
    {
      break label11;
    }
  }

  public void finish()
  {
    b(true);
    super.finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("CanBus", "AirControlActivity onCreate");
    this.bs = new d(this);
    setContentView(this.bs.ae());
    this.bs.init();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.CanBusServer"));
    bindService(localIntent, this.bI, 1);
  }

  protected void onDestroy()
  {
    this.mHandler.removeCallbacks(null);
    try
    {
      b(true);
      if (this.bH != null)
        this.bH.b(this.bJ);
      unbindService(this.bI);
      label41: super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }

  protected void onPause()
  {
    b(true);
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
    W();
  }

  protected void onResume()
  {
    super.onResume();
    b(false);
  }

  public boolean y()
  {
    try
    {
      if (this.bH != null)
      {
        boolean bool2 = this.bH.y();
        bool1 = bool2;
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        boolean bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.air.AirControlActivity
 * JD-Core Version:    0.6.2
 */