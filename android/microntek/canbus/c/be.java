package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class be extends a
{
  public be(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 46;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 1));
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
    }
    if ((paramByte1 >= 3) && (paramByte1 <= 4))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 14));
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
    }
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    ak();
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[8];
    this.cv.a((byte)-64, arrayOfByte, 8);
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
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 7;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void al()
  {
    ak();
  }

  public void am()
  {
    ak();
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[8];
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ao()
  {
    ak();
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ak();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    ak();
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 38:
    case 39:
    case 40:
    default:
    case 36:
    case 41:
    case 37:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte = new byte[2];
        for (int k = 0; k < 2; k++)
          arrayOfByte[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
        if ((0x1 & arrayOfByte[0]) != 0)
          n(arrayOfByte);
      }
      else if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        int i = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
        if (i >= 32768)
          i += 0;
        int j = i * 35 / 1000;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", j);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] != 2);
      }
    }
  }

  public void l(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 2;
    arrayOfByte[1] = ((byte)(0xFF & paramInt * 38 / 30));
    this.cv.a((byte)-124, arrayOfByte, 2);
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
    if ((0x40 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x80 & paramArrayOfByte[0]) == 0)
        break label112;
      bool3 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
        break label118;
      bool4 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label124;
      bool5 = bool1;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label130;
      bool6 = bool1;
      label68: if ((0x0 & paramArrayOfByte[0]) == 0)
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
 * Qualified Name:     android.microntek.canbus.c.be
 * JD-Core Version:    0.6.2
 */