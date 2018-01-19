package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class am extends a
{
  public am(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 28;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 1;
    arrayOfByte[2] = 32;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
      if (paramByte1 == 2)
      {
        arrayOfByte[1] = 6;
        int i = paramInt / 10;
        arrayOfByte[3] = ((byte)(0xFF & i >> 8));
        arrayOfByte[4] = ((byte)(i & 0xFF));
      }
    while (true)
    {
      this.cv.a((byte)-126, arrayOfByte, 5);
      return;
      arrayOfByte[1] = paramByte1;
      break;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[1] = 5;
        arrayOfByte[3] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[4] = ((byte)(paramInt & 0xFF));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void ah()
  {
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void aq()
  {
    byte[] arrayOfByte = new byte[5];
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 2;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = ((byte)(paramInt1 & 0x63));
    arrayOfByte[3] = 32;
    arrayOfByte[4] = 32;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 5);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 5:
    default:
    case 4:
    case 6:
    }
    do
      while (true)
      {
        return;
        if (paramArrayOfByte[(paramInt1 + 2)] == 1)
        {
          byte[] arrayOfByte = new byte[1];
          arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
          n(arrayOfByte);
        }
      }
    while (paramArrayOfByte[(paramInt1 + 2)] != 2);
    float f1 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
    String str;
    if (f1 == 0.0F)
      str = "---";
    while (true)
    {
      Intent localIntent = new Intent("com.canbus.temperature");
      localIntent.putExtra("temperature", str);
      this.mContext.sendBroadcast(localIntent);
      break;
      float f2 = f1 / 2.0F - 40.0F;
      if ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 4)]) == 1)
      {
        float f3 = 32.0F + f2 * 9.0F / 5.0F;
        StringBuilder localStringBuilder2 = new StringBuilder();
        Locale localLocale2 = Locale.US;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Float.valueOf(f3);
        str = String.format(localLocale2, " %.1f", arrayOfObject2) + this.mContext.getString(2131099652);
      }
      else
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        Locale localLocale1 = Locale.US;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Float.valueOf(f2);
        str = String.format(localLocale1, " %.1f", arrayOfObject1) + this.mContext.getString(2131099651);
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
 * Qualified Name:     android.microntek.canbus.c.am
 * JD-Core Version:    0.6.2
 */