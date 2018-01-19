package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class ao extends a
{
  public ao(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 30;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = { 1 };
    this.cv.a((byte)-112, arrayOfByte1, 1);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      int j = 1 + (paramInt - 8750) / 10;
      arrayOfByte2[0] = 0;
      arrayOfByte2[1] = ((byte)(0xFF & j >> 8));
      arrayOfByte2[2] = ((byte)(j & 0xFF));
    }
    while (true)
    {
      this.cv.a((byte)-111, arrayOfByte2, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        int i = 1 + (paramInt - 522) / 9;
        arrayOfByte2[0] = 1;
        arrayOfByte2[1] = ((byte)(0xFF & i >> 8));
        arrayOfByte2[2] = ((byte)(i & 0xFF));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
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
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void al()
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void am()
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void an()
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 2 };
    this.cv.a((byte)-112, arrayOfByte1, 1);
    byte[] arrayOfByte2 = new byte[3];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte2[2] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-110, arrayOfByte2, 3);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 3 };
    this.cv.a((byte)-112, arrayOfByte, 1);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 4:
    default:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 3)
      {
        byte[] arrayOfByte2 = new byte[3];
        while (i < 3)
        {
          arrayOfByte2[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        this.cv.d(arrayOfByte2);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
        {
          int j = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          if (j >= 128);
          for (int k = j - 128; ; k = j - 127)
          {
            o(k);
            break;
          }
          if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
          {
            byte[] arrayOfByte1 = new byte[1];
            arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 3)];
            n(arrayOfByte1);
          }
        }
      }
    }
  }

  public void l(int paramInt)
  {
  }

  void n(byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    Door localDoor = this.aB;
    boolean bool2;
    boolean bool3;
    label32: boolean bool4;
    label44: boolean bool5;
    label56: boolean bool6;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label112;
      bool3 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label118;
      bool4 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label124;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label130;
      bool6 = bool1;
      label68: if ((0x4 & paramArrayOfByte[0]) == 0)
        break label136;
    }
    while (true)
    {
      if (localDoor.a(bool2, bool3, bool4, bool5, bool6, bool1))
        this.cv.a(this.aB);
      return;
      bool2 = false;
      break;
      label112: bool3 = false;
      break label32;
      label118: bool4 = false;
      break label44;
      label124: bool5 = false;
      break label56;
      label130: bool6 = false;
      break label68;
      label136: bool1 = false;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ao
 * JD-Core Version:    0.6.2
 */