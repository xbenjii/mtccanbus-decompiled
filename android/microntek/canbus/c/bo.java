package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class bo extends a
{
  public bo(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte2[0] = ((byte)(paramByte1 + 1));
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte2[0] = ((byte)(paramByte1 + 14));
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte1 = { 6, 18 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    arrayOfByte2[0] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt2 >> 8));
    this.cv.a((byte)-61, arrayOfByte2, 4);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 5, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ah()
  {
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = { 4, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void al()
  {
    byte[] arrayOfByte = { 3, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void am()
  {
    byte[] arrayOfByte = { 3, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void an()
  {
    byte[] arrayOfByte = { 11, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 9, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[2];
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 2, 34 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 9, 16 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(paramInt2 & 0xFF));
    this.cv.a((byte)-61, arrayOfByte2, 4);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bo
 * JD-Core Version:    0.6.2
 */