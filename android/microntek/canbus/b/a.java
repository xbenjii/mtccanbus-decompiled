package android.microntek.canbus.b;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.BaseApplication;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.microntek.canbus.serializable.Warning;
import android.os.UserHandle;
import java.util.Arrays;

public class a
{
  protected Door aB = new Door();
  protected Radar aY = new Radar();
  protected Warning bn = new Warning();
  public boolean cA = true;
  private byte[] cB = new byte['ÿ'];
  public CanBusServer cv;
  public int[] cw = new int[16];
  public int cx = 256;
  public byte cy = -1;
  public boolean cz = true;
  protected AirCondition d = new AirCondition();
  public int e;
  protected int hour = 0;
  public Context mContext;
  protected int mLength = 0;
  protected int minute = 0;

  public a(CanBusServer paramCanBusServer, Context paramContext)
  {
    this.cv = paramCanBusServer;
    this.mContext = paramContext;
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
  }

  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 == 46)
      this.cv.a((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
    while (true)
    {
      return;
      if (paramInt1 == 43605)
        this.cv.b((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
      else if (paramInt1 == 253)
        this.cv.c((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
      else if (paramInt1 == 85)
        this.cv.d((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
      else if (paramInt1 == 4048)
        this.cv.e((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
      else if (paramInt1 == 23205)
        this.cv.f((byte)paramInt2, paramArrayOfByte, paramArrayOfByte.length);
    }
  }

  public void a(String paramString, int paramInt)
  {
  }

  protected boolean a(byte paramByte, int paramInt)
  {
    this.mLength = (paramByte & 0xFF);
    if ((this.mLength >= paramInt - 3) && (this.mLength <= paramInt + 5));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int[][] aA()
  {
    return new int[][] { { 3841, 46, 43010, 1, 0 }, { 3842 }, { 3843 }, { 3844 }, { 3845 }, { 3846 }, { 3847 }, { 3848 }, { 3849 }, { 3850 }, { 3851 }, { 3852 }, { 3853 }, { 3855 }, { 3856 }, { 3857 }, { 3858 }, { 3859 }, { 3860 }, { 3861 }, { 3862 }, { 3863 }, { 3864 }, { 3865 }, { 3872 } };
  }

  public void ah()
  {
  }

  public void ai()
  {
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

  public void aq()
  {
  }

  public void ar()
  {
    ap();
  }

  public void as()
  {
  }

  protected String at()
  {
    return BaseApplication.k().getParameters("sta_mcu_version=");
  }

  protected String au()
  {
    if (this.cv.o == null);
    for (String str = ""; ; str = this.cv.o)
      return str;
  }

  protected int av()
  {
    return this.cv.y;
  }

  protected int aw()
  {
    return BaseApplication.k().o();
  }

  public void ax()
  {
    if (this.cv.l() == 0);
    for (this.aY.zero_show = false; ; this.aY.zero_show = true)
      return;
  }

  public void ay()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.WarningServer"));
    localIntent.putExtra("warningdata", this.bn);
    this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
  }

  public void az()
  {
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void d(String paramString)
  {
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  protected void e(String paramString)
  {
    BaseApplication.k().setParameters(paramString);
  }

  protected void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
    byte[] arrayOfByte = new byte[j + 2];
    arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 1)];
    arrayOfByte[1] = ((byte)j);
    while (i < j)
    {
      arrayOfByte[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
      i++;
    }
    this.cv.d(arrayOfByte);
  }

  protected void f(String paramString)
  {
    Intent localIntent = new Intent("com.canbus.temperature");
    localIntent.putExtra("temperature", paramString);
    this.mContext.sendBroadcastAsUser(localIntent, UserHandle.ALL);
  }

  @SuppressLint({"NewApi"})
  protected byte[] f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void g(int paramInt1, int paramInt2)
  {
    int i = 0;
    for (int j = 0; ; j++)
    {
      if ((j >= aA().length) || (aA()[j].length < 3));
      while (true)
      {
        return;
        if ((paramInt2 == 1) && (j + 1 < aA().length) && (paramInt1 == aA()[j][0]) && (paramInt1 == aA()[(j + 1)][0]))
        {
          int i1 = aA()[(j + 1)][1];
          int i2 = 0xFF & aA()[(j + 1)][2] >> 8;
          int i3 = 0xFF & aA()[(j + 1)][2];
          byte[] arrayOfByte2 = new byte[i3];
          while (i < i3)
          {
            arrayOfByte2[i] = ((byte)aA()[(j + 1)][(i + 3)]);
            i++;
          }
          a(i1, i2, arrayOfByte2);
        }
        else
        {
          if ((paramInt2 != 0) || (paramInt1 != aA()[j][0]))
            break;
          int k = aA()[j][1];
          int m = 0xFF & aA()[j][2] >> 8;
          int n = 0xFF & aA()[j][2];
          byte[] arrayOfByte1 = new byte[n];
          while (i < n)
          {
            arrayOfByte1[i] = ((byte)aA()[j][(i + 3)]);
            i++;
          }
          a(k, m, arrayOfByte1);
        }
      }
    }
  }

  public void i(byte[] paramArrayOfByte)
  {
  }

  protected boolean j(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = this.cB.length;
    boolean bool = false;
    if (i < j)
      for (int k = 0; k < i; k++)
      {
        if (paramArrayOfByte[k] != this.cB[k])
          bool = true;
        this.cB[k] = paramArrayOfByte[k];
      }
    return bool;
  }

  protected void k(byte[] paramArrayOfByte)
  {
    try
    {
      str = new String(paramArrayOfByte, "gb2312");
      this.cv.b(str);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        String str = "";
    }
  }

  public void l(int paramInt)
  {
  }

  public void m(int paramInt)
  {
  }

  public void n(int paramInt)
  {
  }

  protected void o(int paramInt)
  {
    Intent localIntent = new Intent("com.microntek.canbusbackview");
    localIntent.putExtra("canbustype", this.e);
    localIntent.putExtra("lfribackview", paramInt);
    this.mContext.sendBroadcastAsUser(localIntent, UserHandle.ALL);
  }

  protected void p(int paramInt)
  {
    Intent localIntent = new Intent("com.microntek.canbus.speed");
    localIntent.putExtra("speed", "" + paramInt);
    this.mContext.sendBroadcastAsUser(localIntent, UserHandle.ALL);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.b.a
 * JD-Core Version:    0.6.2
 */