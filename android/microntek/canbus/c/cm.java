package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.os.Handler;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class cm extends android.microntek.canbus.b.a
{
  private boolean dN = false;
  byte[] di = new byte[16];
  private Handler mHandler = null;

  public cm(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 77;
  }

  private String a(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong / 60L / 60L;
    long l2 = paramLong / 60L % 60L;
    long l3 = paramLong % 60L;
    if (paramBoolean);
    for (String str = b(l1) + ":" + b(l2) + ":" + b(l3); ; str = b(l2) + ":" + b(l3))
      return str;
  }

  private boolean a(long paramLong)
  {
    if (paramLong / 60L / 60L > 0L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private String b(long paramLong)
  {
    long l1 = paramLong / 10L;
    long l2 = paramLong % 10L;
    return "" + l1 + l2;
  }

  private byte[] i(String paramString)
  {
    String str = paramString + "                            ";
    byte[] arrayOfByte3;
    byte[] arrayOfByte1;
    try
    {
      byte[] arrayOfByte2 = str.getBytes("unicode");
      arrayOfByte3 = new byte[16];
      if (arrayOfByte2 != null)
        for (int i = 1; i < arrayOfByte3.length; i++)
          arrayOfByte3[i] = arrayOfByte2[(i + 1)];
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      arrayOfByte1 = this.di;
    }
    while (true)
    {
      return arrayOfByte1;
      arrayOfByte1 = arrayOfByte3;
    }
  }

  private int l(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2);
    for (int i = 1 + (paramInt2 - paramInt1); ; i = 0)
      return i;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = { 1, 45, 1, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = ((byte)(paramByte1 + 1));
      arrayOfByte[1] = 48;
      arrayOfByte[2] = ((byte)(paramByte2 + 49));
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
        this.cv.b((byte)-45, i(""), 16);
        return;
        arrayOfByte[5] = ((byte)(48 + paramInt / 1000));
        arrayOfByte[6] = ((byte)(48 + paramInt / 100 % 10));
        arrayOfByte[7] = 46;
        arrayOfByte[8] = ((byte)(48 + paramInt / 10 % 10));
        arrayOfByte[9] = ((byte)(48 + paramInt % 10));
      }
    arrayOfByte[0] = ((byte)(paramByte1 + 1));
    arrayOfByte[1] = 48;
    arrayOfByte[2] = ((byte)(paramByte2 + 49));
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
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    this.cv.b((byte)-45, i(""), 16);
    this.mHandler = new cn(this);
    ai();
    this.cv.d(1);
    this.cv.e(1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      this.cv.b((byte)-102, new byte[] { 1, 2 }, 2);
    while (true)
    {
      return;
      if (str.equals("en"))
        this.cv.b((byte)-102, new byte[] { 1, 1 }, 2);
    }
  }

  public void aj()
  {
    int i = 1;
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[3] = ((byte)(0x7F & this.hour));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    int j;
    if (bool)
    {
      j = i;
      arrayOfByte[5] = ((byte)j);
      if (this.hour <= 12)
        break label119;
    }
    while (true)
    {
      arrayOfByte[6] = ((byte)i);
      this.cv.b((byte)-53, arrayOfByte, 10);
      return;
      j = 0;
      break;
      label119: i = 0;
    }
  }

  public void ak()
  {
    byte[] arrayOfByte = { 12, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void al()
  {
    byte[] arrayOfByte = { 8, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void am()
  {
    byte[] arrayOfByte = { 8, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void ap()
  {
    byte[] arrayOfByte = { 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(""), 16);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[13];
    if (paramInt3 == 2);
    for (int i = 7; ; i = 6)
    {
      arrayOfByte[0] = i;
      arrayOfByte[1] = 32;
      arrayOfByte[2] = 32;
      arrayOfByte[3] = 32;
      arrayOfByte[4] = 32;
      arrayOfByte[5] = 32;
      arrayOfByte[6] = 32;
      arrayOfByte[7] = 32;
      arrayOfByte[8] = 32;
      arrayOfByte[9] = 32;
      arrayOfByte[10] = 32;
      arrayOfByte[11] = 32;
      arrayOfByte[12] = 32;
      this.cv.b((byte)-46, arrayOfByte, 13);
      this.cv.b((byte)-45, i(a(paramInt2, a(paramInt2))), 16);
      return;
    }
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 13, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    arrayOfByte[1] = ((byte)(48 + paramInt1 / 100 % 10));
    arrayOfByte[2] = ((byte)(48 + paramInt1 / 10 % 10));
    arrayOfByte[3] = ((byte)(48 + paramInt1 % 10));
    arrayOfByte[6] = ((byte)(48 + paramInt2 / 100 % 10));
    arrayOfByte[7] = ((byte)(48 + paramInt2 / 10 % 10));
    arrayOfByte[8] = ((byte)(48 + paramInt2 % 10));
    this.cv.b((byte)-46, arrayOfByte, 13);
    this.cv.b((byte)-45, i(a(paramInt3 / 1000, a(paramInt3 / 1000))), 16);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 114:
    case 65:
    }
    do
      while (true)
      {
        return;
        if (paramArrayOfByte[(paramInt1 + 2)] == 14)
        {
          if ((android.microntek.canbus.d.a.aV() <= 19) && (this.cv.y == 2) && (this.mHandler != null))
          {
            if (this.dN)
            {
              this.dN = false;
              this.mHandler.removeMessages(0);
              this.mHandler.sendEmptyMessageDelayed(0, 120L);
            }
            if (paramArrayOfByte[(paramInt1 + 5)] == 15)
              this.dN = true;
          }
          int j = (0xFF & paramArrayOfByte[(paramInt1 + 8)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 7)]) << 8);
          if (j >= 32768)
            j += 0;
          int k = j * 30 / 500;
          Intent localIntent = new Intent("com.microntek.canbusbackview");
          localIntent.putExtra("canbustype", this.e);
          localIntent.putExtra("lfribackview", k);
          this.mContext.sendBroadcast(localIntent);
        }
      }
    while (paramArrayOfByte[(paramInt1 + 2)] != 12);
    int[] arrayOfInt = new int[12];
    for (int i = 0; i < 12; i++)
      arrayOfInt[i] = (0xFF & paramArrayOfByte[(i + (paramInt1 + 3))]);
    this.aY.mode = 1;
    this.aY.back_cnt = 4;
    this.aY.bmax1 = 3;
    this.aY.bmax2 = 4;
    this.aY.bmax3 = 4;
    this.aY.bmax4 = 3;
    this.aY.b1 = l(arrayOfInt[0], 3);
    this.aY.b2 = l(arrayOfInt[1], 4);
    this.aY.b3 = l(arrayOfInt[2], 4);
    this.aY.b4 = l(arrayOfInt[3], 3);
    this.aY.bc1 = -65536;
    this.aY.bc2 = -65536;
    this.aY.bc3 = -65536;
    this.aY.bc4 = -65536;
    this.aY.front_cnt = 4;
    this.aY.fmax1 = 3;
    this.aY.fmax2 = 4;
    this.aY.fmax3 = 4;
    this.aY.fmax4 = 3;
    this.aY.f1 = l(arrayOfInt[4], 3);
    this.aY.f2 = l(arrayOfInt[5], 4);
    this.aY.f3 = l(arrayOfInt[6], 4);
    this.aY.f4 = l(arrayOfInt[7], 3);
    this.aY.fc1 = -65536;
    this.aY.fc2 = -65536;
    this.aY.fc3 = -65536;
    this.aY.fc4 = -65536;
    if (this.cv.l() == 0);
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
    {
      this.cv.a(this.aY);
      break;
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.cm
 * JD-Core Version:    0.6.2
 */