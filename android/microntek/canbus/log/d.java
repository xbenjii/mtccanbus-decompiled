package android.microntek.canbus.log;

import java.io.FileOutputStream;

class d
  implements Runnable
{
  d(c paramc)
  {
  }

  public void run()
  {
    String str = CanBusLogActivity.d(this.cT.cS);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      localFileOutputStream.write(CanBusLogActivity.a(this.cT.cS).toString().getBytes());
      localFileOutputStream.close();
      label44: return;
    }
    catch (Exception localException)
    {
      break label44;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.d
 * JD-Core Version:    0.6.2
 */