package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class i extends a
{
  public i(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 9;
  }

  private void aJ()
  {
    byte[] arrayOfByte = { 0 };
    this.cv.c((byte)4, arrayOfByte, 1);
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[12];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = 70;
      arrayOfByte[1] = 77;
      arrayOfByte[2] = ((byte)(paramByte1 + 49));
      arrayOfByte[3] = 58;
      i = paramInt / 10;
      if (i > 999)
      {
        arrayOfByte[4] = ((byte)(48 + i / 1000));
        arrayOfByte[5] = ((byte)(48 + i / 100 % 10));
        arrayOfByte[6] = ((byte)(48 + i / 10 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + i % 10));
        arrayOfByte[9] = 77;
        arrayOfByte[10] = 72;
        arrayOfByte[11] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        int i;
        this.cv.c((byte)0, arrayOfByte, 12);
        return;
        arrayOfByte[4] = 32;
        arrayOfByte[5] = ((byte)(48 + i / 100));
        arrayOfByte[6] = ((byte)(48 + i / 10 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + i % 10));
      }
    arrayOfByte[0] = 65;
    arrayOfByte[1] = 77;
    arrayOfByte[2] = ((byte)(-3 + (paramByte1 + 49)));
    arrayOfByte[3] = 58;
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[8] = 75;
      arrayOfByte[9] = 72;
      arrayOfByte[10] = 90;
      arrayOfByte[11] = 32;
      break;
      arrayOfByte[4] = 32;
      arrayOfByte[5] = ((byte)(48 + paramInt / 100));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 73, 80, 79, 68 };
    this.cv.c((byte)0, arrayOfByte, 4);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 66, 108, 117, 101, 84, 111, 111, 116, 104 };
    this.cv.c((byte)0, arrayOfByte, 9);
  }

  public void ah()
  {
    ap();
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = { 65, 86, 73, 90 };
    this.cv.c((byte)0, arrayOfByte, 4);
  }

  public void al()
  {
    byte[] arrayOfByte = { 84, 86 };
    this.cv.c((byte)0, arrayOfByte, 2);
  }

  public void am()
  {
    byte[] arrayOfByte = { 84, 86 };
    this.cv.c((byte)0, arrayOfByte, 2);
  }

  public void an()
  {
    byte[] arrayOfByte = { 65, 50, 68, 80, 32, 32, 32, 32, 32 };
    this.cv.c((byte)0, arrayOfByte, 9);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 111, 116, 104, 101, 114 };
    this.cv.c((byte)0, arrayOfByte, 5);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 68, 86, 68, 58, 32, 32, 58, 32, 32, 58, 32, 32 };
    arrayOfByte[4] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    arrayOfByte[7] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    arrayOfByte[10] = ((byte)(48 + paramInt2 % 60 / 10));
    arrayOfByte[11] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.c((byte)0, arrayOfByte, 12);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 77, 85, 83, 73, 67, 58, 32, 32, 58, 32, 32 };
    arrayOfByte[6] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 % 10));
    arrayOfByte[9] = ((byte)(48 + paramInt3 / 1000 % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + paramInt3 / 1000 % 60 % 10));
    this.cv.c((byte)0, arrayOfByte, 11);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 86, 73, 68, 69, 79, 58, 32, 32, 58, 32, 32 };
    arrayOfByte[6] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 % 10));
    arrayOfByte[9] = ((byte)(48 + paramInt3 / 1000 % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + paramInt3 / 1000 % 60 % 10));
    this.cv.c((byte)0, arrayOfByte, 11);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  public void i(byte[] paramArrayOfByte)
  {
    aJ();
    this.cv.b(paramArrayOfByte);
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.i
 * JD-Core Version:    0.6.2
 */