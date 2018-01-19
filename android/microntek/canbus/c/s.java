package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class s extends a
{
  public s(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
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
    this.cv.d(1);
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
      e(paramArrayOfByte, paramInt1, paramInt2);
    case 2:
    case 7:
    case 8:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 3)
      {
        byte[] arrayOfByte = new byte[1];
        arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
        n(arrayOfByte);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
        {
          int j = (0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8 | 0xFF & paramArrayOfByte[(paramInt1 + 3)];
          if (j >= 32768)
            j += 0;
          o(j * 30 / 4608);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
          {
            ax();
            int[] arrayOfInt = new int[7];
            for (int i = 0; i < 7; i++)
            {
              arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]);
              if (arrayOfInt[i] > 4)
                arrayOfInt[i] = 0;
            }
            this.aY.max = 4;
            this.aY.back_cnt = 3;
            this.aY.b1 = arrayOfInt[4];
            this.aY.b2 = arrayOfInt[5];
            this.aY.b3 = arrayOfInt[6];
            this.aY.front_cnt = 3;
            this.aY.f1 = arrayOfInt[1];
            this.aY.f2 = arrayOfInt[2];
            this.aY.f3 = arrayOfInt[3];
            if (av() != 1)
              this.cv.a(this.aY);
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
 * Qualified Name:     android.microntek.canbus.c.s
 * JD-Core Version:    0.6.2
 */