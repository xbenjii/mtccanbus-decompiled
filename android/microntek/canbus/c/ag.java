package android.microntek.canbus.c;

import android.content.Context;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;

public class ag extends a
{
  private int jdField_do = 0;

  public ag(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 22;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    String str = paramInt + "";
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    if (str.length() == 1)
    {
      str = "000" + paramInt;
      arrayOfByte1 = str.getBytes();
      arrayOfByte2 = new byte[12];
      if ((paramByte1 >= 0) && (paramByte1 <= 4))
      {
        arrayOfByte2[0] = ((byte)(paramByte1 + 17));
        arrayOfByte2[1] = z(this.jdField_do);
        arrayOfByte2[2] = 8;
        if (str.length() != 5)
          break label332;
        if ((paramByte1 != 3) || (paramByte1 > 4))
          break label268;
        arrayOfByte2[3] = arrayOfByte1[0];
        arrayOfByte2[4] = arrayOfByte1[1];
        arrayOfByte2[5] = arrayOfByte1[2];
        arrayOfByte2[6] = arrayOfByte1[3];
        arrayOfByte2[7] = arrayOfByte1[4];
        arrayOfByte2[8] = 75;
        arrayOfByte2[9] = 72;
        arrayOfByte2[10] = 90;
        label182: arrayOfByte2[11] = 0;
      }
    }
    while (true)
    {
      this.cv.d((byte)-86, arrayOfByte2, 12);
      return;
      if (str.length() == 2)
      {
        str = "00" + paramInt;
        break;
      }
      if (str.length() != 3)
        break;
      str = "0" + paramInt;
      break;
      label268: arrayOfByte2[3] = arrayOfByte1[0];
      arrayOfByte2[4] = arrayOfByte1[1];
      arrayOfByte2[5] = arrayOfByte1[2];
      arrayOfByte2[6] = 46;
      arrayOfByte2[7] = arrayOfByte1[3];
      arrayOfByte2[8] = 77;
      arrayOfByte2[9] = 72;
      arrayOfByte2[10] = 90;
      break label182;
      label332: if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte2[3] = arrayOfByte1[0];
        arrayOfByte2[4] = arrayOfByte1[1];
        arrayOfByte2[5] = arrayOfByte1[2];
        arrayOfByte2[6] = arrayOfByte1[3];
        arrayOfByte2[7] = 75;
        arrayOfByte2[8] = 72;
        arrayOfByte2[9] = 90;
        arrayOfByte2[10] = 32;
      }
      else
      {
        arrayOfByte2[3] = arrayOfByte1[0];
        arrayOfByte2[4] = arrayOfByte1[1];
        arrayOfByte2[5] = 46;
        arrayOfByte2[6] = arrayOfByte1[2];
        arrayOfByte2[7] = arrayOfByte1[3];
        arrayOfByte2[8] = 77;
        arrayOfByte2[9] = 72;
        arrayOfByte2[10] = 90;
        arrayOfByte2[11] = 0;
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 82;
    arrayOfByte[1] = z(this.jdField_do);
    arrayOfByte[2] = 8;
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 64;
    arrayOfByte[1] = z(this.jdField_do);
    arrayOfByte[2] = 8;
    arrayOfByte[3] = 66;
    arrayOfByte[4] = 108;
    arrayOfByte[5] = 117;
    arrayOfByte[6] = 101;
    arrayOfByte[7] = 84;
    arrayOfByte[8] = 111;
    arrayOfByte[9] = 111;
    arrayOfByte[10] = 116;
    arrayOfByte[11] = 104;
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void ah()
  {
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 83;
    arrayOfByte[1] = z(this.jdField_do);
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 81;
    arrayOfByte[1] = z(this.jdField_do);
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void am()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 81;
    arrayOfByte[1] = z(this.jdField_do);
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 64;
    arrayOfByte[1] = z(this.jdField_do);
    arrayOfByte[2] = 8;
    arrayOfByte[3] = 66;
    arrayOfByte[4] = 108;
    arrayOfByte[5] = 117;
    arrayOfByte[6] = 101;
    arrayOfByte[7] = 84;
    arrayOfByte[8] = 111;
    arrayOfByte[9] = 111;
    arrayOfByte[10] = 116;
    arrayOfByte[11] = 104;
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void ao()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 85;
    arrayOfByte[1] = z(this.jdField_do);
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = z(this.jdField_do);
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 33;
    arrayOfByte[1] = z(this.jdField_do);
    arrayOfByte[2] = 8;
    arrayOfByte[3] = ((byte)(48 + paramInt2 / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + paramInt2 / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + paramInt2 / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + paramInt2 % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + paramInt2 % 60 % 10));
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[12];
    arrayOfByte[0] = 85;
    arrayOfByte[1] = z(this.jdField_do);
    arrayOfByte[2] = 8;
    int i = paramInt3 / 1000;
    arrayOfByte[3] = ((byte)(48 + i / 60 / 60 / 10));
    arrayOfByte[4] = ((byte)(48 + i / 60 / 60 % 10));
    arrayOfByte[5] = 58;
    arrayOfByte[6] = ((byte)(48 + i / 60 % 60 / 10));
    arrayOfByte[7] = ((byte)(48 + i / 60 % 60 % 10));
    arrayOfByte[8] = 58;
    arrayOfByte[9] = ((byte)(48 + i % 60 / 10));
    arrayOfByte[10] = ((byte)(48 + i % 60 % 10));
    this.cv.d((byte)-86, arrayOfByte, 12);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  public void l(int paramInt)
  {
    this.jdField_do = paramInt;
    if (this.cv.ae != null)
    {
      int i = this.cv.state;
      this.cv.getClass();
      if (i != 0)
        this.cv.a(this.cv.ae);
    }
    while (true)
    {
      return;
      byte[] arrayOfByte2 = new byte[12];
      arrayOfByte2[0] = 0;
      arrayOfByte2[1] = z(this.jdField_do);
      this.cv.d((byte)-86, arrayOfByte2, 12);
      continue;
      byte[] arrayOfByte1 = new byte[12];
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = z(this.jdField_do);
      this.cv.d((byte)-86, arrayOfByte1, 12);
    }
  }

  public byte z(int paramInt)
  {
    String str = paramInt + "";
    byte b;
    if (str.length() == 1)
      b = (byte)paramInt;
    while (true)
    {
      return b;
      int i = Integer.parseInt(str.substring(1));
      if (paramInt < 20)
        b = (byte)(i + 16);
      else if (paramInt < 30)
        b = (byte)(i + 32);
      else
        b = 48;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.ag
 * JD-Core Version:    0.6.2
 */