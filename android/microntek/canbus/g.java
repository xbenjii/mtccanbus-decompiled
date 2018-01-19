package android.microntek.canbus;

import android.microntek.canbus.a.b;
import android.microntek.canbus.a.d;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.os.RemoteCallbackList;

class g extends b
{
  g(CanBusServer paramCanBusServer)
  {
  }

  public int A()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).seatHotLeft; ; i = 0)
      return i;
  }

  public int B()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).seatHotRight; ; i = 0)
      return i;
  }

  public int C()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).windLoop; ; i = 0)
      return i;
  }

  public boolean D()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windUp; ; bool = false)
      return bool;
  }

  public boolean E()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windMid; ; bool = false)
      return bool;
  }

  public boolean F()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windDown; ; bool = false)
      return bool;
  }

  public boolean G()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windFrontMax; ; bool = false)
      return bool;
  }

  public boolean H()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windRear; ; bool = false)
      return bool;
  }

  public int I()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).modeAuto; ; i = 0)
      return i;
  }

  public int J()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).windLevel; ; i = 0)
      return i;
  }

  public int K()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).windLevelMax; ; i = 0)
      return i;
  }

  public int L()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).tempLeft; ; i = -1)
      return i;
  }

  public int M()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).tempRight; ; i = -1)
      return i;
  }

  public boolean N()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).tempUnit; ; bool = false)
      return bool;
  }

  public boolean O()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).modeAc; ; bool = false)
      return bool;
  }

  public int P()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).rearLock; ; i = 0)
      return i;
  }

  public int Q()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).acMax; ; i = 0)
      return i;
  }

  public int R()
  {
    if (CanBusServer.e(this.am) != null);
    for (int i = CanBusServer.e(this.am).modeDual; ; i = 0)
      return i;
  }

  public boolean S()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).windRearShow; ; bool = false)
      return bool;
  }

  public boolean T()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).wind_FrameShow; ; bool = false)
      return bool;
  }

  public boolean U()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).ariStateShow; ; bool = false)
      return bool;
  }

  public int[] V()
  {
    int[] arrayOfInt2;
    if (CanBusServer.a(this.am) != null)
    {
      arrayOfInt2 = new int[CanBusServer.a(this.am).aA().length];
      for (int i = 0; i < CanBusServer.a(this.am).aA().length; i++)
        arrayOfInt2[i] = CanBusServer.a(this.am).aA()[i][0];
    }
    for (int[] arrayOfInt1 = arrayOfInt2; ; arrayOfInt1 = new int[] { 0 })
      return arrayOfInt1;
  }

  public void W()
  {
    if (CanBusServer.a(this.am) != null)
      CanBusServer.a(this.am).az();
  }

  public void a(d paramd)
  {
    CanBusServer.d(this.am).register(paramd);
  }

  public void b(int paramInt1, int paramInt2)
  {
    if (CanBusServer.a(this.am) != null)
      CanBusServer.a(this.am).g(paramInt1, paramInt2);
  }

  public void b(d paramd)
  {
    CanBusServer.d(this.am).unregister(paramd);
  }

  public void b(boolean paramBoolean)
  {
    CanBusServer.a(this.am, paramBoolean);
  }

  public boolean y()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).onOff; ; bool = false)
      return bool;
  }

  public boolean z()
  {
    if (CanBusServer.e(this.am) != null);
    for (boolean bool = CanBusServer.e(this.am).seatShow; ; bool = false)
      return bool;
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.g
 * JD-Core Version:    0.6.2
 */