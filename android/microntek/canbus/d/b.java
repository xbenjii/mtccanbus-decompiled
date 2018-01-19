package android.microntek.canbus.d;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

public class b
{
  public static void a(String[] paramArrayOfString, boolean paramBoolean, PackageManager paramPackageManager)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str;
      if (a(paramArrayOfString[j], paramPackageManager))
      {
        str = paramArrayOfString[j];
        if (!paramBoolean)
          break label51;
      }
      label51: for (int k = 1; ; k = 2)
      {
        paramPackageManager.setApplicationEnabledSetting(str, k, 1);
        j++;
        break;
      }
    }
  }

  public static boolean a(String paramString, PackageManager paramPackageManager)
  {
    List localList = paramPackageManager.getInstalledPackages(8192);
    int i = localList.size();
    int j = 0;
    if (j < i)
      if (!paramString.equalsIgnoreCase(((PackageInfo)localList.get(j)).packageName));
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j++;
      break;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.d.b
 * JD-Core Version:    0.6.2
 */