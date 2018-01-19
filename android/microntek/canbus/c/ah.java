package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class ah extends a
{
  public ah(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 23;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 17));
      arrayOfByte[4] = ((byte)(paramInt & 0xFF));
      arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-126, arrayOfByte, 9);
      return;
      if ((paramByte1 == 3) && (paramByte1 <= 4))
      {
        arrayOfByte[2] = 33;
        arrayOfByte[4] = ((byte)(paramInt & 0xFF));
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
      }
      else if (paramByte1 == 4)
      {
        arrayOfByte[2] = 34;
        arrayOfByte[4] = ((byte)(paramInt & 0xFF));
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 5;
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[8] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 9;
    arrayOfByte[6] = 0;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void ah()
  {
    this.cv.e(1);
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 7;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 10;
    arrayOfByte[1] = -1;
    arrayOfByte[2] = -1;
    arrayOfByte[3] = -1;
    arrayOfByte[4] = -1;
    arrayOfByte[5] = -1;
    arrayOfByte[6] = -1;
    arrayOfByte[7] = -1;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 0;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 9;
    arrayOfByte[6] = 0;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 3, -1, -1, -1, -1, -1, -1, -1, -1 };
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 0;
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 2;
    arrayOfByte[3] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[4] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[7] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte[8] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-126, arrayOfByte, 9);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[9];
    arrayOfByte[0] = 3;
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte[8] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-126, arrayOfByte, 9);
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
      if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
      {
        int i = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
        if (i >= 128)
          i -= 128;
        o(0 - i * 30 / 50);
      }
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ah
 * JD-Core Version:    0.6.2
 */