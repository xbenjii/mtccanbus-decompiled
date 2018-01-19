package android.microntek.canbus.b;

import android.content.Context;
import android.microntek.canbus.CanBusServer;

public class b extends a
{
  private boolean Q = false;
  private String[] cC = { "FM1", "FM2", "FM3", "FM4", "FM5", "AM1", "AM2", "&&&", "&&&", "&&&" };
  private String cD = "-000000000";
  private boolean cE = false;
  private String cF = "OFF&&&&&&&&-000000000";
  private int cG = 256;

  public b(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void aB()
  {
    if (this.cE)
    {
      this.cE = false;
      this.cv.c("1");
    }
  }

  private void aC()
  {
    if (!this.cE)
    {
      this.cE = true;
      this.cv.c("0");
    }
  }

  private String q(int paramInt)
  {
    if (paramInt == 0);
    String str1;
    String str2;
    for (String str3 = this.cD; ; str3 = "-" + str2 + str1)
    {
      return str3;
      str1 = "" + (1 << paramInt);
      str2 = "";
      for (int i = 0; i < 9 - str1.length(); i++)
        str2 = str2 + "0";
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    int i = 0xF & paramByte1 >> 4;
    int j = paramByte1 & 0xF;
    int k;
    String str3;
    int m;
    String str1;
    if (i == 7)
    {
      k = 2;
      if ((j < 0) || (j > (byte)(k + 2)))
        break label282;
      str3 = this.cC[j];
      m = paramInt / 10;
      if (m <= 999)
        break label172;
      str1 = str3 + m / 1000 + "&" + m / 100 % 10 + "" + m / 10 % 10 + "." + m % 10 + "0&" + q(0);
    }
    label282: 
    while (true)
    {
      this.cv.c(str1);
      this.cF = str1;
      aB();
      return;
      k = 0;
      break;
      label172: if (m > 99)
      {
        str1 = str3 + "&&" + m / 100 % 10 + "" + m / 10 % 10 + "." + m % 10 + "0&" + q(0);
      }
      else
      {
        str1 = str3 + "&&&&&&&&-000000000";
        continue;
        if ((j >= (byte)(k + 3)) && (j <= (byte)(k + 4)))
        {
          String[] arrayOfString = this.cC;
          if (i == 5)
            j += 2;
          String str2 = arrayOfString[j];
          if (paramInt > 999)
            str1 = str2 + paramInt / 1000 + "&" + paramInt / 100 % 10 + "" + paramInt / 10 % 10 + "&" + paramInt % 10 + "&&" + q(0);
          else if (paramInt > 99)
            str1 = str2 + "&&" + paramInt / 100 % 10 + "" + paramInt / 10 % 10 + "&" + paramInt % 10 + "&&" + q(0);
          else
            str1 = str2 + "&&&&&&&&-000000000";
        }
        else
        {
          str1 = "&&&&&&&&&&&-000000000";
        }
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    int i = paramInt3 / 1000;
    if (paramInt1 != 0);
    for (String str = "" + paramInt2 / 100 % 10 + "" + paramInt2 / 10 % 10 + "" + paramInt2 % 10 + "&" + "&" + i / 60 % 60 / 10 + "" + i / 60 % 60 % 10 + "." + i % 60 / 10 + "" + i % 60 % 10 + "&"; ; str = "IPOD&&&&&&&")
    {
      this.cv.c(str + this.cD);
      this.cF = (str + this.cD);
      aB();
      return;
    }
  }

  public void a(String paramString, int paramInt)
  {
    if (1 == paramInt)
    {
      this.Q = true;
      String str = "BT&&&&&&&&&" + this.cD;
      this.cv.c(str);
      aB();
    }
    while (true)
    {
      return;
      this.Q = false;
    }
  }

  public void ah()
  {
    ap();
  }

  public void aj()
  {
  }

  public void ak()
  {
    String str = "AVIN&&&&&&&" + this.cD;
    this.cv.c(str);
    this.cF = str;
    aB();
  }

  public void al()
  {
    String str = "DTV&&&&&&&&" + this.cD;
    this.cv.c(str);
    this.cF = str;
    aB();
  }

  public void am()
  {
    String str = "ATV&&&&&&&&" + this.cD;
    this.cv.c(str);
    this.cF = str;
    aB();
  }

  public void an()
  {
    String str = "A2DP&&&&&&&" + this.cD;
    this.cv.c(str);
    this.cF = str;
    aB();
  }

  public void ao()
  {
    String str = "AV&&&&&&&&&" + this.cD;
    this.cv.c(str);
    this.cF = str;
    aB();
  }

  public void ap()
  {
    String str = "OFF&&&&&&&&" + q(0);
    this.cF = str;
    aC();
    this.cv.c(str);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1;
    if (paramInt3 == 2)
    {
      str1 = q(17);
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt3 == -1))
        break label182;
    }
    label182: for (String str2 = paramInt1 / 100 % 10 + "" + paramInt1 / 10 % 10 + "" + paramInt1 % 10 + "-&" + paramInt2 / 60 % 60 / 10 + "" + paramInt2 / 60 % 60 % 10 + "." + paramInt2 % 60 / 10 + "" + paramInt2 % 60 % 10 + "&" + str1; ; str2 = "DISC&&&&&&&" + this.cD)
    {
      this.cv.c(str2);
      this.cF = str2;
      aB();
      return;
      str1 = q(19);
      break;
    }
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 / 1000;
    String str2;
    if (paramInt1 != 0)
      str2 = "" + paramInt2 / 100 % 10 + "" + paramInt2 / 10 % 10 + "" + paramInt2 % 10 + "-" + "&" + i / 60 % 60 / 10 + "" + i / 60 % 60 % 10 + "." + i % 60 / 10 + "" + i % 60 % 10 + "&";
    for (String str1 = str2 + q(20); ; str1 = "MP3&&&&&&&&" + this.cD)
    {
      this.cv.c(str1);
      this.cF = str1;
      aB();
      return;
    }
  }

  public void d(String paramString)
  {
    if (this.Q);
    while (true)
    {
      return;
      if ((paramString != null) && (paramString.length() > 2))
      {
        if (!paramString.substring(0, 3).toString().equals("VOL"))
          this.cv.c(paramString);
        else
          this.cv.c(this.cF);
      }
      else
        this.cv.c(this.cF);
    }
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  public void l(int paramInt)
  {
    if (this.Q);
    while (true)
    {
      return;
      if ((paramInt != this.cG) && (this.cG != 256))
      {
        this.cG = paramInt;
        String str = "VOL&&" + paramInt / 10 + "" + paramInt % 10 + "&&&&" + this.cD;
        this.cv.c(str);
      }
      else
      {
        this.cG = paramInt;
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.b.b
 * JD-Core Version:    0.6.2
 */