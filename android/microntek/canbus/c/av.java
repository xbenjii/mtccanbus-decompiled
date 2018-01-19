package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;

public class av extends j
{
  public av(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case -108:
    case -107:
    }
    while (true)
    {
      return;
      if (a(paramArrayOfByte[(paramInt1 + 2)], 4))
      {
        byte[] arrayOfByte2 = new byte[2 + this.mLength];
        arrayOfByte2[0] = -108;
        arrayOfByte2[1] = ((byte)this.mLength);
        while (i < this.mLength)
        {
          arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.d(arrayOfByte2);
        continue;
        if (a(paramArrayOfByte[(paramInt1 + 2)], 1))
        {
          byte[] arrayOfByte1 = new byte[2 + this.mLength];
          arrayOfByte1[0] = -107;
          arrayOfByte1[1] = ((byte)this.mLength);
          while (i < this.mLength)
          {
            arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.d(arrayOfByte1);
        }
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.av
 * JD-Core Version:    0.6.2
 */