package android.microntek.canbus.c;

import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;

public class bk extends a
{
  public bk(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 52;
  }

  private void m(byte[] paramArrayOfByte)
  {
    label35: label61: label79: label96: label114: boolean bool;
    label131: label148: label187: AirCondition localAirCondition4;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label284;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label295;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.modeAuto = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label313;
      this.d.windFrontMax = true;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label324;
      this.d.windRear = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label335;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label346;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label357;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x1 & paramArrayOfByte[4]) == 0)
        break label368;
      bool = true;
      localAirCondition2.tempUnit = bool;
      int i = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = x(i);
      int j = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = x(j);
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label374;
      localAirCondition4 = this.d;
    }
    label284: label295: label313: label324: label335: label346: label357: label368: label374: AirCondition localAirCondition3;
    for (localAirCondition4.windLoop = 1; ; localAirCondition3.windLoop = 0)
    {
      this.d.seatShow = false;
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label35;
      AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label61;
      this.d.windFrontMax = false;
      break label79;
      this.d.windRear = false;
      break label96;
      this.d.windUp = false;
      break label114;
      this.d.windMid = false;
      break label131;
      this.d.windDown = false;
      break label148;
      bool = false;
      break label187;
      localAirCondition3 = this.d;
    }
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

  public void as()
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 48;
    this.cv.a((byte)-126, arrayOfByte, 2);
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
    case 48:
    case 40:
    case 35:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] == 2)
      {
        int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
        if (j >= 32768)
          j += 0;
        int k = j * 30 / 6144;
        Intent localIntent = new Intent("com.microntek.canbusbackview");
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("lfribackview", k);
        this.mContext.sendBroadcast(localIntent);
        continue;
        if (paramArrayOfByte[(paramInt1 + 2)] == 2)
        {
          byte[] arrayOfByte2 = new byte[1];
          arrayOfByte2[0] = paramArrayOfByte[(paramInt1 + 3)];
          if ((0x1 & arrayOfByte2[0]) != 0)
          {
            n(arrayOfByte2);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
            {
              byte[] arrayOfByte1 = new byte[7];
              while (i < 7)
              {
                arrayOfByte1[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              if ((0x10 & arrayOfByte1[1]) != 0)
              {
                m(arrayOfByte1);
                this.cv.a(this.d);
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

  int x(int paramInt)
  {
    if (paramInt == 0)
      paramInt = 0;
    while (true)
    {
      return paramInt;
      if (paramInt == 31)
        paramInt = 65535;
      else if ((paramInt >= 1) && (paramInt <= 28))
      {
        if (!this.d.tempUnit)
          paramInt = 155 + paramInt * 10 / 2;
        else
          paramInt = 590 + paramInt * 10;
      }
      else if ((paramInt >= 32) && (paramInt <= 36))
      {
        if (!this.d.tempUnit)
          paramInt = 160 + paramInt * 10 / 2;
      }
      else
        paramInt = -1;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.c.bk
 * JD-Core Version:    0.6.2
 */