package android.microntek.canbus.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.text.format.DateFormat;
import android.text.format.Time;
import java.util.Locale;

public class dp extends a
{
  public dp(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 0, paramByte };
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    label34: label60: label76: label92: label108: AirCondition localAirCondition3;
    if ((0x7 & paramArrayOfByte[2]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label284;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label295;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label313;
      this.d.modeDual = 1;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label324;
      this.d.windFrontMax = true;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label335;
      this.d.windRear = true;
      switch (0x7 & paramArrayOfByte[1])
      {
      default:
        this.d.windUp = false;
        this.d.windMid = false;
        this.d.windDown = false;
        label172: this.d.windLevel = (0x7 & paramArrayOfByte[2]);
        this.d.windLevelMax = 7;
        int i = 0xFF & paramArrayOfByte[3];
        this.d.tempLeft = x(i);
        int j = 0xFF & paramArrayOfByte[4];
        this.d.tempRight = x(j);
        if ((0x10 & paramArrayOfByte[0]) != 0)
          localAirCondition3 = this.d;
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    label284: label295: label313: label324: label335: AirCondition localAirCondition2;
    for (localAirCondition3.windLoop = 1; ; localAirCondition2.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label34;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label60;
      this.d.modeDual = 0;
      break label76;
      this.d.windFrontMax = false;
      break label92;
      this.d.windRear = false;
      break label108;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = false;
      break label172;
      this.d.windUp = false;
      this.d.windMid = true;
      this.d.windDown = true;
      break label172;
      this.d.windUp = false;
      this.d.windMid = false;
      this.d.windDown = true;
      break label172;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = true;
      break label172;
      this.d.windUp = true;
      this.d.windMid = false;
      this.d.windDown = false;
      break label172;
      localAirCondition2 = this.d;
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte[2] = ((byte)(paramByte1 + 1));
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte[5] = ((byte)(paramByte2 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-64, arrayOfByte, 8);
      return;
      if ((paramByte1 >= 3) && (paramByte1 <= 4))
      {
        arrayOfByte[2] = ((byte)(16 + (paramByte1 - 2)));
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[4] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte[5] = ((byte)(paramByte2 + 1));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void a(String paramString, int paramInt)
  {
    int i = 0;
    int j = 1;
    if ((paramInt == j) || (paramInt == 2));
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("gb2312");
      byte[] arrayOfByte2 = new byte[2 + arrayOfByte1.length];
      if (paramInt == j)
      {
        arrayOfByte2[0] = j;
        arrayOfByte2[1] = 1;
        while (i < arrayOfByte1.length)
        {
          arrayOfByte2[(i + 2)] = arrayOfByte1[i];
          i++;
        }
        this.cv.a((byte)-59, arrayOfByte2, 2 + arrayOfByte1.length);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        continue;
        j = 2;
      }
    }
  }

  public int[][] aA()
  {
    int[][] arrayOfInt = new int[32][];
    arrayOfInt[0] = { 3842, 46, 43010, 1, 0 };
    arrayOfInt[1] = { 3842, 46, 43010, 1, 1 };
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = 3845;
    arrayOfInt1[1] = 46;
    arrayOfInt1[2] = 43010;
    int i = this.d.windLoop;
    int j;
    int[] arrayOfInt2;
    if (i == 1)
    {
      j = 5;
      arrayOfInt1[3] = j;
      arrayOfInt1[4] = 0;
      arrayOfInt[2] = arrayOfInt1;
      arrayOfInt2 = new int[5];
      arrayOfInt2[0] = 3845;
      arrayOfInt2[1] = 46;
      arrayOfInt2[2] = 43010;
      int k = this.d.windLoop;
      if (k != 1)
        break label1079;
    }
    label1079: for (int m = 5; ; m = 4)
    {
      arrayOfInt2[3] = m;
      arrayOfInt2[4] = 1;
      arrayOfInt[3] = arrayOfInt2;
      arrayOfInt[4] = { 3846, 46, 43010, 2, 0 };
      arrayOfInt[5] = { 3846, 46, 43010, 2, 1 };
      arrayOfInt[6] = { 3847, 46, 43010, 13, 0 };
      arrayOfInt[7] = { 3847, 46, 43010, 13, 1 };
      arrayOfInt[8] = { 3848, 46, 43010, 14, 0 };
      arrayOfInt[9] = { 3848, 46, 43010, 14, 1 };
      arrayOfInt[10] = { 3849, 46, 43010, 15, 0 };
      arrayOfInt[11] = { 3849, 46, 43010, 15, 1 };
      arrayOfInt[12] = { 3850, 46, 43010, 16, 0 };
      arrayOfInt[13] = { 3850, 46, 43010, 16, 1 };
      arrayOfInt[14] = { 3853, 46, 43010, 0, 0 };
      arrayOfInt[15] = { 3853, 46, 43010, 0, 1 };
      arrayOfInt[16] = { 3855, 46, 43010, 12, 0 };
      arrayOfInt[17] = { 3855, 46, 43010, 12, 1 };
      arrayOfInt[18] = { 3856, 46, 43010, 11, 0 };
      arrayOfInt[19] = { 3856, 46, 43010, 11, 1 };
      arrayOfInt[20] = { 3857, 46, 43010, 3, 0 };
      arrayOfInt[21] = { 3857, 46, 43010, 3, 1 };
      arrayOfInt[22] = { 3858, 46, 43010, 9, 0 };
      arrayOfInt[23] = { 3858, 46, 43010, 9, 1 };
      arrayOfInt[24] = { 3859, 46, 43010, 6, 0 };
      arrayOfInt[25] = { 3859, 46, 43010, 6, 1 };
      arrayOfInt[26] = { 3860, 46, 43010, 7, 0 };
      arrayOfInt[27] = { 3860, 46, 43010, 7, 1 };
      arrayOfInt[28] = { 3861, 46, 43010, 10, 0 };
      arrayOfInt[29] = { 3861, 46, 43010, 10, 1 };
      arrayOfInt[30] = { 3863, 46, 43010, 8, 0 };
      arrayOfInt[31] = { 3863, 46, 43010, 8, 1 };
      return arrayOfInt;
      j = 4;
      break;
    }
  }

  public void ah()
  {
    this.cv.d(1);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)0);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)1);
    }
  }

  public void aj()
  {
    Time localTime = new Time();
    localTime.setToNow();
    this.hour = localTime.hour;
    this.minute = localTime.minute;
    boolean bool = DateFormat.is24HourFormat(this.mContext);
    byte[] arrayOfByte = new byte[7];
    if (!bool)
    {
      if (this.hour > 12)
        this.hour = (-12 + this.hour);
      if (this.hour == 0)
        this.hour = 12;
    }
    arrayOfByte[3] = ((byte)((0x3F & this.hour) << 1));
    arrayOfByte[4] = ((byte)(0xFF & this.minute));
    this.cv.a((byte)-90, arrayOfByte, 7);
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 7;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void al()
  {
  }

  public void am()
  {
    ap();
  }

  public void an()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 11;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void ap()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void az()
  {
    this.cv.a((byte)-112, new byte[] { -88, 0 }, 2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ap();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 9;
    this.cv.a((byte)-64, arrayOfByte, 8);
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
    case 33:
    case 36:
    case 41:
    case 64:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
      {
        m(f(paramArrayOfByte, paramInt1 + 3, paramInt2));
        this.cv.a(this.d);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
        {
          byte[] arrayOfByte = new byte[1];
          arrayOfByte[0] = paramArrayOfByte[(paramInt1 + 3)];
          n(arrayOfByte);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 2)
          {
            o(0 - 30 * (-32768 + ((0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8))) / 8076);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 5)
              this.cv.d(f(paramArrayOfByte, paramInt1 + 1, paramInt2));
          }
        }
      }
    }
  }

  public void l(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)paramInt);
    this.cv.a((byte)-60, arrayOfByte, 1);
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

  int x(int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = 0;
    while (true)
    {
      return i;
      if (paramInt == 30)
        i = 65535;
      else if ((paramInt >= 0) && (paramInt <= 30))
        i = 175 + paramInt * 5;
      else
        i = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.dp
 * JD-Core Version:    0.6.2
 */