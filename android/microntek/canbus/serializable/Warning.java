package android.microntek.canbus.serializable;

import java.io.Serializable;

public class Warning
  implements Serializable
{
  private int warningCount = 0;
  private int[][][] warningInfo = { { { 0, 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } } };

  public int aF()
  {
    return this.warningCount;
  }

  public int[][][] aG()
  {
    return this.warningInfo;
  }

  public void b(int[][][] paramArrayOfInt)
  {
    this.warningInfo = paramArrayOfInt;
  }

  public void r(int paramInt)
  {
    this.warningCount = paramInt;
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.serializable.Warning
 * JD-Core Version:    0.6.2
 */