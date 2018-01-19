package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;

public class y extends a
{
  public y(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 14;
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
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 34:
    case 35:
    case 36:
    case 50:
    case 51:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 4)
      {
        byte[] arrayOfByte5 = new byte[4];
        for (int k = 0; k < 4; k++)
          arrayOfByte5[k] = paramArrayOfByte[(k + (paramInt1 + 3))];
        this.aY.max = 4;
        this.aY.back_cnt = 4;
        this.aY.b1 = arrayOfByte5[0];
        this.aY.b2 = arrayOfByte5[1];
        this.aY.b3 = arrayOfByte5[2];
        this.aY.b4 = arrayOfByte5[3];
        this.cv.a(this.aY);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
        {
          byte[] arrayOfByte4 = new byte[4];
          for (int j = 0; j < 4; j++)
            arrayOfByte4[j] = paramArrayOfByte[(j + (paramInt1 + 3))];
          this.aY.max = 4;
          this.aY.front_cnt = 4;
          this.aY.f1 = arrayOfByte4[0];
          this.aY.f2 = arrayOfByte4[1];
          this.aY.f3 = arrayOfByte4[2];
          this.aY.f4 = arrayOfByte4[3];
          this.cv.a(this.aY);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] == 2) && ((byte)(0x1 & paramArrayOfByte[(paramInt1 + 3)]) == 1))
          {
            byte[] arrayOfByte3 = new byte[2];
            while (i < 2)
            {
              arrayOfByte3[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            n(arrayOfByte3);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 3)
            {
              byte[] arrayOfByte2 = new byte[5];
              arrayOfByte2[0] = 50;
              arrayOfByte2[1] = 3;
              while (i < 3)
              {
                arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte2);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                byte[] arrayOfByte1 = new byte[4];
                arrayOfByte1[0] = 51;
                arrayOfByte1[1] = 2;
                while (i < 2)
                {
                  arrayOfByte1[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
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
 * Qualified Name:     android.microntek.canbus.c.y
 * JD-Core Version:    0.6.2
 */