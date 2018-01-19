package android.microntek.canbus.c;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.text.format.Time;
import java.util.Locale;

public class an extends a
{
  private int dr = 0;
  private NotificationManager ds;
  private Notification dt;

  public an(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 29;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[0] = 1;
      int i = paramInt / 10;
      arrayOfByte[1] = ((byte)(0xFF & i >> 8));
      arrayOfByte[2] = ((byte)(i & 0xFF));
    }
    while (true)
    {
      this.cv.a((byte)-126, arrayOfByte, 4);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[0] = 2;
        arrayOfByte[1] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[2] = ((byte)(paramInt & 0xFF));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 5;
    arrayOfByte[1] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = 32;
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = { 10, 32, 32, 32 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void ah()
  {
    this.ds = ((NotificationManager)this.cv.getSystemService("notification"));
    this.dt = new Notification(2130837781, null, 0L);
    Notification localNotification1 = this.dt;
    localNotification1.flags = (0x20 | localNotification1.flags);
    Notification localNotification2 = this.dt;
    localNotification2.flags = (0x1 | localNotification2.flags);
    this.cv.e(1);
  }

  public void ai()
  {
    String str1 = this.cv.getString(2131099655);
    String str2 = this.dr + " Km";
    this.dt.setLatestEventInfo(this.cv, str1, str2, null);
    this.ds.notify(1, this.dt);
  }

  @SuppressLint({"NewApi"})
  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(0xFF & this.hour));
    arrayOfByte[1] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-125, arrayOfByte, 2);
  }

  public void ak()
  {
    byte[] arrayOfByte = { 9, 32, 32, 32 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void al()
  {
    byte[] arrayOfByte = { 11, 32, 32, 32 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void am()
  {
    byte[] arrayOfByte = { 11, 32, 32, 32 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void an()
  {
    byte[] arrayOfByte = { 10, 32, 32, 32 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void ao()
  {
    byte[] arrayOfByte = { 3, -1, -1, -1 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 15;
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void aq()
  {
    byte[] arrayOfByte = new byte[4];
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = { 6, -1, -1, -1 };
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = 3;
    arrayOfByte[1] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = 32;
    this.cv.a((byte)-126, arrayOfByte, 4);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    Locale localLocale;
    Object[] arrayOfObject;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 2:
      do
        return;
      while (paramArrayOfByte[(paramInt1 + 2)] != 4);
      int k = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) << 8;
      int m = 0xFF & paramArrayOfByte[(paramInt1 + 4)];
      if (this.dr != k + m)
      {
        this.dr = (k + m);
        String str2 = this.cv.getString(2131099655);
        String str3 = this.dr + " Km";
        this.dt.setLatestEventInfo(this.cv, str2, str3, null);
        this.ds.notify(1, this.dt);
      }
      float f = ((0xFF & paramArrayOfByte[(paramInt1 + 5)]) << 8) + (0xFF & paramArrayOfByte[(paramInt1 + 6)]);
      if ((f < 33269.0F) && (f >= 32769.0F))
        f = 32769.0F - f - 1.0F;
      if (f <= -500.0F)
        f = -499.0F;
      if ((f >= -500.0F) && (f <= 770.0F))
      {
        localStringBuilder = new StringBuilder();
        localLocale = Locale.US;
        arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(f * 0.1F);
      }
      break;
    case 5:
    case 4:
    case 49:
    case 50:
    }
    for (String str1 = String.format(localLocale, " %.1f", arrayOfObject) + this.mContext.getString(2131099651); ; str1 = "")
    {
      Intent localIntent2 = new Intent("com.canbus.temperature");
      localIntent2.putExtra("temperature", str1);
      this.mContext.sendBroadcast(localIntent2);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] != 1)
        break;
      int j = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
      if ((j == 0) || (j == 128))
        j = 0;
      if (j > 128)
        j = 128 - j;
      Intent localIntent1 = new Intent("com.microntek.canbusbackview");
      localIntent1.putExtra("canbustype", this.e);
      localIntent1.putExtra("lfribackview", 0 - j);
      this.mContext.sendBroadcast(localIntent1);
      break;
      if ((paramArrayOfByte[(paramInt1 + 2)] != 3) || (goto 56) || (paramArrayOfByte[(paramInt1 + 2)] != 9))
        break;
      byte[] arrayOfByte2 = new byte[11];
      arrayOfByte2[0] = 49;
      arrayOfByte2[1] = 9;
      for (int i = 0; i < 9; i++)
        arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
      this.cv.d(arrayOfByte2);
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] != 1)
        break;
      byte[] arrayOfByte1 = new byte[3];
      arrayOfByte1[0] = 50;
      arrayOfByte1[1] = 1;
      arrayOfByte1[2] = paramArrayOfByte[(paramInt1 + 3)];
      this.cv.d(arrayOfByte1);
      break;
    }
  }

  public void l(int paramInt)
  {
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.an
 * JD-Core Version:    0.6.2
 */