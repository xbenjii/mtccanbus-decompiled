package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;

public class g extends a
{
  private boolean cX = true;

  public g(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 7;
  }

  private void aI()
  {
    if (this.cX)
    {
      this.cX = false;
      byte[] arrayOfByte = new byte[2];
      arrayOfByte[0] = 2;
      this.cv.a((byte)-59, arrayOfByte, 2);
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 1, 1 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[4];
    if (paramByte1 == 0)
      arrayOfByte2[0] = 1;
    while (true)
    {
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte2[3] = ((byte)(paramByte2 + 1));
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if (paramByte1 == 1)
        arrayOfByte2[0] = 2;
      else if (paramByte1 == 2)
        arrayOfByte2[0] = 0;
      else
        arrayOfByte2[0] = 16;
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 6, 18 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[4] = paramByte;
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void a(String paramString, int paramInt)
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 5, 48 };
    byte[] arrayOfByte2 = { 1, 99, 0, 0, 0, 0 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void ah()
  {
    aI();
    aj();
    if (this.cv.y == 1)
    {
      this.cv.d(1);
      this.cv.e(1);
    }
  }

  public void aj()
  {
    int i = 12;
    int j;
    int k;
    byte[] arrayOfByte2;
    if ((this.cv.o != null) && (this.cv.o.startsWith("HH")))
    {
      Time localTime2 = new Time();
      localTime2.setToNow();
      j = localTime2.hour;
      k = localTime2.minute;
      boolean bool2 = DateFormat.is24HourFormat(this.mContext);
      arrayOfByte2 = new byte[3];
      if (bool2)
        break label218;
      if (j > i)
        j -= 12;
      if (j != 0)
        break label218;
    }
    while (true)
    {
      arrayOfByte2[0] = ((byte)i);
      arrayOfByte2[1] = ((byte)k);
      this.cv.b((byte)-75, arrayOfByte2, 3);
      return;
      Time localTime1 = new Time();
      localTime1.setToNow();
      this.hour = localTime1.hour;
      this.minute = localTime1.minute;
      boolean bool1 = DateFormat.is24HourFormat(this.mContext);
      byte[] arrayOfByte1 = new byte[4];
      arrayOfByte1[0] = 0;
      if (bool1)
        arrayOfByte1[1] = 0;
      while (true)
      {
        arrayOfByte1[2] = ((byte)(0x7F & this.hour));
        arrayOfByte1[3] = ((byte)(0xFF & this.minute));
        this.cv.a((byte)-56, arrayOfByte1, 4);
        break;
        arrayOfByte1[1] = 1;
      }
      label218: i = j;
    }
  }

  public void ak()
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 7, 48 };
    byte[] arrayOfByte2 = { 1, 90, 35, 5 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    this.cv.a((byte)-61, arrayOfByte2, 4);
  }

  public void al()
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 10, 48 };
    byte[] arrayOfByte2 = { 1, 99, 0, 0, 0, 0 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void am()
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 3, 48 };
    byte[] arrayOfByte2 = { 1, 99, 0, 0, 0, 0 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void an()
  {
    this.cX = true;
    byte[] arrayOfByte = { 11, 48 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void ap()
  {
    this.cX = true;
    byte[] arrayOfByte = { 0, 0 };
    this.cv.a((byte)-64, arrayOfByte, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cX = true;
    byte[] arrayOfByte1 = { 2, 16 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = 0;
    arrayOfByte2[1] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[4] = ((byte)(paramInt2 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt2 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = { 8, 17 };
    this.cv.a((byte)-64, arrayOfByte1, 2);
    byte[] arrayOfByte2 = new byte[6];
    arrayOfByte2[0] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte2[1] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte2[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte2[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte2[4] = ((byte)(paramInt3 / 1000 / 60 % 60));
    arrayOfByte2[5] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-61, arrayOfByte2, 6);
    aI();
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.cv.l() == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 36:
      case 33:
      case 48:
      case 34:
      case 35:
      case 38:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        byte[] arrayOfByte4 = new byte[2];
        while (i < 2)
        {
          arrayOfByte4[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
          i++;
        }
        n(arrayOfByte4);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 11)
        {
          byte[] arrayOfByte3 = new byte[13];
          arrayOfByte3[0] = 33;
          arrayOfByte3[1] = 11;
          while (i < 11)
          {
            arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
            i++;
          }
          this.cv.e(arrayOfByte3);
          continue;
          if ((paramArrayOfByte[(paramInt1 + 2)] == 16) && (goto 84) && (paramArrayOfByte[(paramInt1 + 2)] == 4))
          {
            byte[] arrayOfByte2 = new byte[4];
            for (int n = 0; n < 4; n++)
              arrayOfByte2[n] = paramArrayOfByte[(n + (paramInt1 + 3))];
            this.aY.max = 10;
            this.aY.back_cnt = 4;
            this.aY.b1 = arrayOfByte2[0];
            this.aY.b2 = arrayOfByte2[1];
            this.aY.b3 = arrayOfByte2[2];
            this.aY.b4 = arrayOfByte2[3];
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 4)
            {
              byte[] arrayOfByte1 = new byte[4];
              for (int m = 0; m < 4; m++)
                arrayOfByte1[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
              this.aY.max = 10;
              this.aY.front_cnt = 4;
              this.aY.f1 = arrayOfByte1[0];
              this.aY.f2 = arrayOfByte1[1];
              this.aY.f3 = arrayOfByte1[2];
              this.aY.f4 = arrayOfByte1[3];
              this.cv.a(this.aY);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                if (j >= 32768)
                  j += 0;
                int k = j * 30 / 450;
                Intent localIntent = new Intent("com.microntek.canbusbackview");
                localIntent.putExtra("canbustype", this.e);
                localIntent.putExtra("lfribackview", 0 - k);
                this.mContext.sendBroadcast(localIntent);
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
 * Qualified Name:     android.microntek.canbus.c.g
 * JD-Core Version:    0.6.2
 */