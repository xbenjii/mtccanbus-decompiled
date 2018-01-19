package android.microntek.canbus;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.microntek.canbus.air.AirControlActivity;
import android.microntek.canbus.d.b;
import android.provider.Settings.System;
import android.util.Log;

public class o
{
  private static final String[] aD = { "com.microntek.controlsettings" };
  private static final String[] aE = { "com.microntek.controlinfo" };
  private static final String[] aF = { "com.microntek.civxusb" };
  private static final String[] aG = { "com.microntek.sync" };
  private static final String[] aH = { "com.microntek.mtcztcarsettings" };
  private static final String[] aI = { "com.microntek.carcd" };
  private static final String[] aJ = { "com.hiworld.carset.noencry" };
  private static final String[] aK = { "com.hiworld.carcomputer" };
  private static final String[] aL = { "com.hiworld.canbus.services" };

  private void a(Context paramContext, PackageManager paramPackageManager, boolean paramBoolean)
  {
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), AirControlActivity.class.getName());
    if (!paramBoolean)
      paramPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
    while (true)
    {
      return;
      paramPackageManager.setComponentEnabledSetting(localComponentName, 0, 1);
    }
  }

  public void b(Context paramContext)
  {
    int i = BaseApplication.k().p();
    int j = BaseApplication.k().n();
    int k = Settings.System.getInt(paramContext.getContentResolver(), "canbus_updata", 1);
    Log.i("CanBusServer", "CanBus initCanBusApp ");
    PackageManager localPackageManager;
    if ((k != 0) && (BaseApplication.k().r()))
    {
      BaseApplication.k().a(false);
      Settings.System.putInt(paramContext.getContentResolver(), "canbus_updata", 0);
      localPackageManager = paramContext.getPackageManager();
      if ((i != 8) && (i != 33) && (i != 42) && (i != 5) && (i != 9) && (i != 14) && (i != 17) && (i != 35) && (i != 19) && (i != 26) && (i != 27) && (i != 24) && (i != 44) && (i != 47) && (i != 50) && (i != 49) && (i != 55) && (i != 4) && (i != 58) && (i != 60) && ((i != 62) || (j == 1)) && (i != 61) && (i != 63) && (i != 64) && (i != 36) && (i != 21) && (i != 68) && (i != 69) && (i != 75) && (i != 76) && ((i != 7) || (j != 1)) && (i != 79) && (i != 82) && (i != 83) && (i != 84) && (i != 85) && (i != 37) && (i != 88) && (i != 92) && (i != 94) && (i != 98) && (i != 78) && (i != 99) && (i != 100) && (i != 103) && (i != 105) && (i != 107))
        break label774;
      b.a(aD, true, localPackageManager);
      if ((i != 1) && (i != 8) && (i != 33) && (i != 42) && (i != 19) && (i != 21) && (i != 36) && (i != 26) && (i != 27) && (i != 30) && (i != 24) && (i != 17) && (i != 35) && (i != 47) && (i != 55) && (i != 58) && (i != 60) && (i != 61) && (i != 50) && (i != 64) && (i != 76) && (i != 80) && (i != 81) && (i != 82) && (i != 83) && (i != 84) && (i != 85) && (i != 54) && (i != 99) && (i != 104) && (i != 107))
        break label786;
      b.a(aE, true, localPackageManager);
      label565: if ((i != 7) && (i != 66))
        break label798;
      b.a(aF, true, localPackageManager);
      label586: if ((i != 6) && (i != 49) && (i != 62) && (i != 72))
        break label810;
      b.a(aG, true, localPackageManager);
      label619: if (i != 25)
        break label822;
      b.a(aH, true, localPackageManager);
      label634: if (i != 59)
        break label834;
      b.a(aJ, true, localPackageManager);
      label649: if (i != 59)
        break label846;
      b.a(aK, true, localPackageManager);
      label664: if (((i != 75) || (j != 0)) && (i != 74) && ((i != 78) || (j != 0)))
        break label858;
      b.a(aI, true, localPackageManager);
      label699: if (!BaseApplication.k().c(i))
        break label870;
      b.a(aL, true, localPackageManager);
      label718: if ((i != 103) && ((i != 78) || (j != 0)) && (i != 98) && (i != 105) && ((i != 61) || (j != 1)))
        break label882;
      a(paramContext, localPackageManager, true);
    }
    while (true)
    {
      Log.i("CanBusServer", "CanBus initCanBusApp end !");
      return;
      label774: b.a(aD, false, localPackageManager);
      break;
      label786: b.a(aE, false, localPackageManager);
      break label565;
      label798: b.a(aF, false, localPackageManager);
      break label586;
      label810: b.a(aG, false, localPackageManager);
      break label619;
      label822: b.a(aH, false, localPackageManager);
      break label634;
      label834: b.a(aJ, false, localPackageManager);
      break label649;
      label846: b.a(aK, false, localPackageManager);
      break label664;
      label858: b.a(aI, false, localPackageManager);
      break label699;
      label870: b.a(aL, false, localPackageManager);
      break label718;
      label882: a(paramContext, localPackageManager, false);
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.o
 * JD-Core Version:    0.6.2
 */