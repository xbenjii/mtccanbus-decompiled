package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class aa extends a
{
  public aa(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 16;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 1, 45, 1, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 48;
      arrayOfByte[2] = ((byte)(paramByte2 + 49));
      if (this.e == 26)
      {
        arrayOfByte[1] = 32;
        arrayOfByte[2] = 32;
      }
      if (paramInt > 9999)
      {
        arrayOfByte[4] = ((byte)(48 + paramInt / 10000));
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000 % 10));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
        arrayOfByte[10] = 77;
        arrayOfByte[11] = 72;
        arrayOfByte[12] = 90;
      }
    }
    while ((paramByte1 < 3) || (paramByte1 > 4))
      while (true)
      {
        this.cv.b((byte)-46, arrayOfByte, 13);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 - 2));
    arrayOfByte[1] = 48;
    arrayOfByte[2] = ((byte)(paramByte2 + 49));
    if (this.e == 26)
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
    }
    if (paramInt > 999)
    {
      arrayOfByte[4] = ((byte)(48 + paramInt / 1000));
      arrayOfByte[5] = ((byte)(48 + paramInt / 100 % 10));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
    while (true)
    {
      arrayOfByte[9] = 75;
      arrayOfByte[10] = 72;
      arrayOfByte[11] = 90;
      break;
      arrayOfByte[5] = ((byte)(48 + paramInt / 100));
      arrayOfByte[6] = ((byte)(48 + paramInt / 10 % 10));
      arrayOfByte[7] = ((byte)(48 + paramInt % 10));
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 11, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void ah()
  {
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 65, 86, 73, 78, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 84, 86, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 66, 108, 117, 101, 84, 111, 111, 116, 104, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 14, 77, 101, 100, 105, 97, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 7, 68, 86, 68, 58, 32, 32, 58, 32, 32, 32, 32, 32 };
    arrayOfByte[5] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 % 60 % 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 / 60 / 10));
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 14, 77, 85, 83, 73, 67, 58, 32, 32, 58, 32, 32, 32 };
    arrayOfByte[7] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 / 10));
    arrayOfByte[8] = ((byte)(48 + paramInt3 / 1000 / 60 % 60 % 10));
    arrayOfByte[10] = ((byte)(48 + paramInt3 / 1000 % 60 / 10));
    arrayOfByte[11] = ((byte)(48 + paramInt3 / 1000 % 60 % 10));
    this.cv.b((byte)-46, arrayOfByte, 13);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 114:
    case -90:
    }
    while (true)
    {
      return;
      if ((paramArrayOfByte[(paramInt1 + 2)] == 14) && (goto 32) && (paramArrayOfByte[(paramInt1 + 2)] == 8));
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.aa
 * JD-Core Version:    0.6.2
 */