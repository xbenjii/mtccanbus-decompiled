package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class by extends a
{
  public by(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 65;
  }

  public void ah()
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 36:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte = new byte[1];
        arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
        if ((0x1 & arrayOfByte[0]) != 0)
          n(arrayOfByte);
      }
    }
  }

  void n(byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    Door localDoor = this.aB;
    boolean bool2;
    boolean bool3;
    label32: boolean bool4;
    label43: boolean bool5;
    label54: boolean bool6;
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x80 & paramArrayOfByte[0]) == 0)
        break label109;
      bool3 = bool1;
      if ((0x0 & paramArrayOfByte[0]) == 0)
        break label115;
      bool4 = bool1;
      if ((0x0 & paramArrayOfByte[0]) == 0)
        break label121;
      bool5 = bool1;
      if ((0x0 & paramArrayOfByte[0]) == 0)
        break label127;
      bool6 = bool1;
      label65: if ((0x0 & paramArrayOfByte[0]) == 0)
        break label133;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label109: bool3 = false;
      break label32;
      label115: bool4 = false;
      break label43;
      label121: bool5 = false;
      break label54;
      label127: bool6 = false;
      break label65;
      label133: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.by
 * JD-Core Version:    0.6.2
 */