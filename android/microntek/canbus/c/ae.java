package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.Canbus20Activity;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import java.util.Locale;

public class ae extends a
{
  public ae(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 20;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = paramByte1;
    arrayOfByte[2] = 32;
    arrayOfByte[3] = 32;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      int i = paramInt / 10;
      arrayOfByte[5] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & i >> 8));
    }
    while (true)
    {
      this.cv.a((byte)-109, arrayOfByte, 6);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[1] = 6;
        arrayOfByte[5] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void ah()
  {
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 3;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void aq()
  {
    byte[] arrayOfByte = { -128 };
    this.cv.a((byte)-110, arrayOfByte, 1);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 2;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[3] = 2;
    arrayOfByte[4] = 2;
    arrayOfByte[5] = 2;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = 4;
    arrayOfByte[1] = 32;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = 2;
    arrayOfByte[4] = 32;
    arrayOfByte[5] = 32;
    this.cv.a((byte)-109, arrayOfByte, 6);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    case 19:
    case 21:
    default:
    case 20:
    case 22:
    case 18:
    case 23:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 1)
      {
        byte[] arrayOfByte3 = new byte[1];
        arrayOfByte3[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte3);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
        {
          int i = paramArrayOfByte[(paramInt1 + 4)];
          float f1 = paramArrayOfByte[(paramInt1 + 3)];
          float f2;
          label120: String str;
          if (f1 > 0.0F)
          {
            f2 = Math.abs(f1 / 2.0F) - 39.5F;
            if (f1 != 0.0F)
              break label188;
            str = "---";
          }
          while (true)
          {
            Intent localIntent4 = new Intent("com.canbus.temperature");
            localIntent4.putExtra("temperature", str);
            this.mContext.sendBroadcast(localIntent4);
            break;
            f2 = 0.5F + (24.0F + Math.abs(Math.abs(f1 / 2.0F) - 64.0F));
            break label120;
            label188: if ((byte)(i & 0x1) == 1)
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
          if (paramArrayOfByte[(paramInt1 + 2)] == 1)
          {
            byte[] arrayOfByte2 = new byte[3];
            arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 1)];
            arrayOfByte2[1] = paramArrayOfByte[(paramInt1 + 3)];
            arrayOfByte2[2] = paramArrayOfByte[(paramInt1 + 4)];
            if (((byte)(0x1 & arrayOfByte2[1]) == 1) && (Canbus20Activity.ax == 1))
            {
              Canbus20Activity.ax = 0;
            }
            else
            {
              Intent localIntent2 = new Intent(this.cv.getApplicationContext(), Canbus20Activity.class);
              localIntent2.setFlags(268435456);
              localIntent2.putExtra("syncdata", arrayOfByte2);
              this.cv.startActivity(localIntent2);
              Intent localIntent3 = new Intent("com.microntek.canbus20activity");
              localIntent3.putExtra("syncdata", arrayOfByte2);
              this.mContext.sendBroadcast(localIntent3);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte1 = new byte[3];
                arrayOfByte1[0] = paramArrayOfByte[(paramInt1 + 1)];
                arrayOfByte1[1] = paramArrayOfByte[(paramInt1 + 3)];
                arrayOfByte1[2] = paramArrayOfByte[(paramInt1 + 4)];
                Intent localIntent1 = new Intent("com.microntek.canbus20activity");
                localIntent1.putExtra("syncdata", arrayOfByte1);
                this.mContext.sendBroadcast(localIntent1);
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
 * Qualified Name:     android.microntek.canbus.c.ae
 * JD-Core Version:    0.6.2
 */