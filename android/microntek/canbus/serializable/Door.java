package android.microntek.canbus.serializable;

import java.io.Serializable;

public class Door
  implements Serializable
{
  public boolean front = false;
  public boolean frontDriver = false;
  public boolean frontPassenger = false;
  public boolean rearLeft = false;
  public boolean rearRight = false;
  public boolean roof = false;
  public boolean trunk = false;

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    boolean bool1;
    if ((this.frontDriver == paramBoolean1) && (this.frontPassenger == paramBoolean2) && (this.rearLeft == paramBoolean3) && (this.rearRight == paramBoolean4) && (this.trunk == paramBoolean5))
    {
      boolean bool2 = this.front;
      bool1 = false;
      if (bool2 == paramBoolean6);
    }
    else
    {
      bool1 = true;
    }
    this.frontDriver = paramBoolean1;
    this.frontPassenger = paramBoolean2;
    this.rearLeft = paramBoolean3;
    this.rearRight = paramBoolean4;
    this.trunk = paramBoolean5;
    this.front = paramBoolean6;
    return bool1;
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.serializable.Door
 * JD-Core Version:    0.6.2
 */