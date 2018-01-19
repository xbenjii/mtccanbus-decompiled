package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class az extends a
{
  public az(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 38;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
  }

  public void a(String paramString, int paramInt)
  {
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
  }

  public void al()
  {
  }

  public void am()
  {
  }

  public void an()
  {
  }

  public void ao()
  {
  }

  public void ap()
  {
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 36:
    case 39:
    case 41:
    case 57:
    case 22:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte3 = new byte[1];
        arrayOfByte3[0] = ((byte)((byte)(0x80 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x40 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x20 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x10 & paramArrayOfByte[(paramInt1 + 3)]) + (byte)(0x8 & paramArrayOfByte[(paramInt1 + 3)])));
        n(arrayOfByte3);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
        {
          int m = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          StringBuilder localStringBuilder2;
          Locale localLocale2;
          Object[] arrayOfObject2;
          if ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 4)]) == 1)
          {
            if ((byte)(0x2 & paramArrayOfByte[(paramInt1 + 4)]) == 2)
              m = 0 - m;
            localStringBuilder2 = new StringBuilder();
            localLocale2 = Locale.US;
            arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = Integer.valueOf(m);
          }
          StringBuilder localStringBuilder1;
          Locale localLocale1;
          Object[] arrayOfObject1;
          for (String str = String.format(localLocale2, " %d", arrayOfObject2) + " " + this.mContext.getString(2131099652); ; str = String.format(localLocale1, " %d", arrayOfObject1) + " " + this.mContext.getString(2131099651))
          {
            Intent localIntent2 = new Intent("com.canbus.temperature");
            localIntent2.putExtra("temperature", str);
            this.mContext.sendBroadcast(localIntent2);
            break;
            if ((byte)(0x2 & paramArrayOfByte[(paramInt1 + 4)]) == 2)
              m -= 256;
            localStringBuilder1 = new StringBuilder();
            localLocale1 = Locale.US;
            arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Integer.valueOf(m);
          }
          if (paramArrayOfByte[(paramInt1 + 2)] == 2)
          {
            int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
            if (j >= 32768)
              j += 0;
            int k = j * 38 / 8500;
            Intent localIntent1 = new Intent("com.microntek.canbusbackview");
            localIntent1.putExtra("canbustype", this.e);
            localIntent1.putExtra("lfribackview", k);
            this.mContext.sendBroadcast(localIntent1);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 1)
            {
              byte[] arrayOfByte2 = new byte[2];
              arrayOfByte2[0] = 57;
              arrayOfByte2[1] = paramArrayOfByte[(paramInt1 + 3)];
              this.cv.d(arrayOfByte2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte1 = new byte[3];
                arrayOfByte1[0] = 22;
                for (int i = 0; i < 2; i++)
                  arrayOfByte1[(i + 1)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                this.cv.d(arrayOfByte1);
              }
            }
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
 * Qualified Name:     android.microntek.canbus.c.az
 * JD-Core Version:    0.6.2
 */