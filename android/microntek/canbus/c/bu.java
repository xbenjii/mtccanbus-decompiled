package android.microntek.canbus.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Warning;
import android.provider.Settings.System;
import java.util.Locale;

public class bu extends a
{
  private static final String[] aG = { "com.microntek.sync" };
  private byte[] cB = new byte[6];
  private boolean cV = true;
  private boolean cW = true;
  private boolean dG = true;

  public bu(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 62;
  }

  private void aP()
  {
    int i = Settings.System.getInt(this.cv.getContentResolver(), "panel_LED", 7);
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = -94;
    arrayOfByte[1] = ((byte)i);
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  private int b(byte paramByte, int paramInt)
  {
    int i = 1;
    if ((0x1 & paramByte >> paramInt) == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { -92, paramByte };
    this.cv.a((byte)-58, arrayOfByte, 2);
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    label43: label69: label85: label101: label119: boolean bool;
    label136: label153: label193: int i;
    label231: int j;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label333;
      this.d.modeAc = true;
      if ((0x8 & paramArrayOfByte[0]) == 0)
        break label344;
      AirCondition localAirCondition12 = this.d;
      localAirCondition12.modeAuto = 1;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label362;
      this.d.modeDual = 1;
      if ((0x2 & paramArrayOfByte[0]) == 0)
        break label373;
      this.d.windFrontMax = true;
      if ((0x80 & paramArrayOfByte[1]) == 0)
        break label384;
      this.d.windUp = true;
      if ((0x40 & paramArrayOfByte[1]) == 0)
        break label395;
      this.d.windMid = true;
      if ((0x20 & paramArrayOfByte[1]) == 0)
        break label406;
      this.d.windDown = true;
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      this.d.windLevelMax = 7;
      AirCondition localAirCondition2 = this.d;
      if ((0x40 & paramArrayOfByte[4]) == 0)
        break label417;
      bool = true;
      localAirCondition2.tempUnit = bool;
      i = 0xFF & paramArrayOfByte[2];
      if (i != 0)
        break label423;
      AirCondition localAirCondition11 = this.d;
      localAirCondition11.tempLeft = 0;
      j = 0xFF & paramArrayOfByte[3];
      if (j != 0)
        break label532;
      AirCondition localAirCondition9 = this.d;
      localAirCondition9.tempRight = 0;
      label262: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label641;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.windLoop = 1;
      label288: AirCondition localAirCondition6 = this.d;
      localAirCondition6.rearLock = -1;
      if ((0x4 & paramArrayOfByte[4]) == 0)
        break label661;
    }
    label384: label395: label532: label661: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      label333: this.d.modeAc = false;
      break label43;
      label344: AirCondition localAirCondition1 = this.d;
      localAirCondition1.modeAuto = 0;
      break label69;
      label362: this.d.modeDual = 0;
      break label85;
      label373: this.d.windFrontMax = false;
      break label101;
      this.d.windUp = false;
      break label119;
      this.d.windMid = false;
      break label136;
      label406: this.d.windDown = false;
      break label153;
      label417: bool = false;
      break label193;
      label423: if (i == 127)
      {
        AirCondition localAirCondition10 = this.d;
        localAirCondition10.tempLeft = 65535;
        break label231;
      }
      if ((i >= 31) && (i <= 59))
      {
        this.d.tempLeft = (i * 5);
        if (!this.d.tempUnit)
          break label231;
        this.d.tempLeft = (320 + 9 * this.d.tempLeft / 5);
        break label231;
      }
      AirCondition localAirCondition3 = this.d;
      localAirCondition3.tempLeft = -1;
      break label231;
      if (j == 127)
      {
        AirCondition localAirCondition8 = this.d;
        localAirCondition8.tempRight = 65535;
        break label262;
      }
      if ((j >= 31) && (j <= 59))
      {
        this.d.tempRight = (j * 5);
        if (!this.d.tempUnit)
          break label262;
        this.d.tempRight = (320 + 9 * this.d.tempRight / 5);
        break label262;
      }
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempRight = -1;
      break label262;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.windLoop = 0;
      break label288;
    }
  }

  private int[][][] t(byte[] paramArrayOfByte)
  {
    int[][][] arrayOfInt = new int[16][][];
    int[][] arrayOfInt1 = new int[8][];
    arrayOfInt1[0] = { 0 };
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = b(paramArrayOfByte[0], 1);
    arrayOfInt2[1] = 2131099852;
    arrayOfInt2[2] = 2130837824;
    arrayOfInt2[3] = 2130837854;
    arrayOfInt1[1] = arrayOfInt2;
    int[] arrayOfInt3 = new int[4];
    arrayOfInt3[0] = b(paramArrayOfByte[0], 2);
    arrayOfInt3[1] = 2131099853;
    arrayOfInt3[2] = 2130837823;
    arrayOfInt3[3] = 2130837854;
    arrayOfInt1[2] = arrayOfInt3;
    int[] arrayOfInt4 = new int[4];
    arrayOfInt4[0] = b(paramArrayOfByte[0], 3);
    arrayOfInt4[1] = 2131099854;
    arrayOfInt4[2] = 2130837823;
    arrayOfInt4[3] = 2130837853;
    arrayOfInt1[3] = arrayOfInt4;
    int[] arrayOfInt5 = new int[4];
    arrayOfInt5[0] = b(paramArrayOfByte[0], 4);
    arrayOfInt5[1] = 2131099855;
    arrayOfInt5[2] = 2130837827;
    arrayOfInt5[3] = 2130837852;
    arrayOfInt1[4] = arrayOfInt5;
    int[] arrayOfInt6 = new int[4];
    arrayOfInt6[0] = b(paramArrayOfByte[0], 5);
    arrayOfInt6[1] = 2131099856;
    arrayOfInt6[2] = 2130837840;
    arrayOfInt6[3] = 2130837852;
    arrayOfInt1[5] = arrayOfInt6;
    int[] arrayOfInt7 = new int[4];
    arrayOfInt7[0] = b(paramArrayOfByte[0], 6);
    arrayOfInt7[1] = 2131099857;
    arrayOfInt7[2] = 2130837841;
    arrayOfInt7[3] = 2130837853;
    arrayOfInt1[6] = arrayOfInt7;
    int[] arrayOfInt8 = new int[4];
    arrayOfInt8[0] = b(paramArrayOfByte[0], 7);
    arrayOfInt8[1] = 2131099858;
    arrayOfInt8[2] = 2130837835;
    arrayOfInt8[3] = 2130837853;
    arrayOfInt1[7] = arrayOfInt8;
    arrayOfInt[0] = arrayOfInt1;
    int[][] arrayOfInt9 = new int[8][];
    int[] arrayOfInt10 = new int[4];
    arrayOfInt10[0] = b(paramArrayOfByte[1], 0);
    arrayOfInt10[1] = 2131099859;
    arrayOfInt10[2] = 2130837822;
    arrayOfInt10[3] = 2130837853;
    arrayOfInt9[0] = arrayOfInt10;
    int[] arrayOfInt11 = new int[4];
    arrayOfInt11[0] = b(paramArrayOfByte[1], 1);
    arrayOfInt11[1] = 2131099860;
    arrayOfInt11[2] = 2130837825;
    arrayOfInt11[3] = 2130837854;
    arrayOfInt9[1] = arrayOfInt11;
    int[] arrayOfInt12 = new int[4];
    arrayOfInt12[0] = b(paramArrayOfByte[1], 2);
    arrayOfInt12[1] = 2131099861;
    arrayOfInt12[2] = 2130837826;
    arrayOfInt12[3] = 2130837854;
    arrayOfInt9[2] = arrayOfInt12;
    int[] arrayOfInt13 = new int[4];
    arrayOfInt13[0] = b(paramArrayOfByte[1], 3);
    arrayOfInt13[1] = 2131099862;
    arrayOfInt13[2] = 2130837819;
    arrayOfInt13[3] = 2130837853;
    arrayOfInt9[3] = arrayOfInt13;
    int[] arrayOfInt14 = new int[4];
    arrayOfInt14[0] = b(paramArrayOfByte[1], 4);
    arrayOfInt14[1] = 2131099863;
    arrayOfInt14[2] = 2130837820;
    arrayOfInt14[3] = 2130837852;
    arrayOfInt9[4] = arrayOfInt14;
    int[] arrayOfInt15 = new int[4];
    arrayOfInt15[0] = b(paramArrayOfByte[1], 5);
    arrayOfInt15[1] = 2131099864;
    arrayOfInt15[2] = 2130837820;
    arrayOfInt15[3] = 2130837852;
    arrayOfInt9[5] = arrayOfInt15;
    int[] arrayOfInt16 = new int[4];
    arrayOfInt16[0] = b(paramArrayOfByte[1], 6);
    arrayOfInt16[1] = 2131099865;
    arrayOfInt16[2] = 2130837842;
    arrayOfInt16[3] = 2130837853;
    arrayOfInt9[6] = arrayOfInt16;
    arrayOfInt9[7] = { 0 };
    arrayOfInt[1] = arrayOfInt9;
    int[][] arrayOfInt17 = new int[8][];
    arrayOfInt17[0] = { 0 };
    arrayOfInt17[1] = { 0 };
    arrayOfInt17[2] = { 0 };
    arrayOfInt17[3] = { 0 };
    arrayOfInt17[4] = { 0 };
    arrayOfInt17[5] = { 0 };
    arrayOfInt17[6] = { 0 };
    int[] arrayOfInt18 = new int[4];
    arrayOfInt18[0] = b(paramArrayOfByte[2], 7);
    arrayOfInt18[1] = 2131099872;
    arrayOfInt18[2] = 2130837845;
    arrayOfInt18[3] = 2130837852;
    arrayOfInt17[7] = arrayOfInt18;
    arrayOfInt[2] = arrayOfInt17;
    int[][] arrayOfInt19 = new int[8][];
    int[] arrayOfInt20 = new int[4];
    arrayOfInt20[0] = b(paramArrayOfByte[3], 0);
    arrayOfInt20[1] = 2131099873;
    arrayOfInt20[2] = 2130837844;
    arrayOfInt20[3] = 2130837852;
    arrayOfInt19[0] = arrayOfInt20;
    int[] arrayOfInt21 = new int[4];
    arrayOfInt21[0] = b(paramArrayOfByte[3], 1);
    arrayOfInt21[1] = 2131099874;
    arrayOfInt21[2] = 2130837844;
    arrayOfInt21[3] = 2130837852;
    arrayOfInt19[1] = arrayOfInt21;
    arrayOfInt19[2] = { 0 };
    arrayOfInt19[3] = { 0 };
    arrayOfInt19[4] = { 0 };
    arrayOfInt19[5] = { 0 };
    arrayOfInt19[6] = { 0 };
    arrayOfInt19[7] = { 0 };
    arrayOfInt[3] = arrayOfInt19;
    int[][] arrayOfInt22 = new int[8][];
    int[] arrayOfInt23 = new int[4];
    arrayOfInt23[0] = b(paramArrayOfByte[4], 0);
    arrayOfInt23[1] = 2131099881;
    arrayOfInt23[2] = 2130837828;
    arrayOfInt23[3] = 2130837852;
    arrayOfInt22[0] = arrayOfInt23;
    int[] arrayOfInt24 = new int[4];
    arrayOfInt24[0] = b(paramArrayOfByte[4], 1);
    arrayOfInt24[1] = 2131099882;
    arrayOfInt24[2] = 2130837828;
    arrayOfInt24[3] = 2130837852;
    arrayOfInt22[1] = arrayOfInt24;
    int[] arrayOfInt25 = new int[4];
    arrayOfInt25[0] = b(paramArrayOfByte[4], 2);
    arrayOfInt25[1] = 2131099883;
    arrayOfInt25[2] = 2130837837;
    arrayOfInt25[3] = 2130837853;
    arrayOfInt22[2] = arrayOfInt25;
    int[] arrayOfInt26 = new int[4];
    arrayOfInt26[0] = b(paramArrayOfByte[4], 3);
    arrayOfInt26[1] = 2131099884;
    arrayOfInt26[2] = 2130837845;
    arrayOfInt26[3] = 2130837852;
    arrayOfInt22[3] = arrayOfInt26;
    int[] arrayOfInt27 = new int[4];
    arrayOfInt27[0] = b(paramArrayOfByte[4], 4);
    arrayOfInt27[1] = 2131099885;
    arrayOfInt27[2] = 2130837829;
    arrayOfInt27[3] = 2130837852;
    arrayOfInt22[4] = arrayOfInt27;
    int[] arrayOfInt28 = new int[4];
    arrayOfInt28[0] = b(paramArrayOfByte[4], 5);
    arrayOfInt28[1] = 2131099886;
    arrayOfInt28[2] = 2130837837;
    arrayOfInt28[3] = 2130837853;
    arrayOfInt22[5] = arrayOfInt28;
    int[] arrayOfInt29 = new int[4];
    arrayOfInt29[0] = b(paramArrayOfByte[4], 6);
    arrayOfInt29[1] = 2131099887;
    arrayOfInt29[2] = 2130837851;
    arrayOfInt29[3] = 2130837853;
    arrayOfInt22[6] = arrayOfInt29;
    int[] arrayOfInt30 = new int[4];
    arrayOfInt30[0] = b(paramArrayOfByte[4], 7);
    arrayOfInt30[1] = 2131099888;
    arrayOfInt30[2] = 2130837851;
    arrayOfInt30[3] = 2130837853;
    arrayOfInt22[7] = arrayOfInt30;
    arrayOfInt[4] = arrayOfInt22;
    int[][] arrayOfInt31 = new int[8][];
    int[] arrayOfInt32 = new int[4];
    arrayOfInt32[0] = b(paramArrayOfByte[5], 0);
    arrayOfInt32[1] = 2131099889;
    arrayOfInt32[2] = 2130837845;
    arrayOfInt32[3] = 2130837852;
    arrayOfInt31[0] = arrayOfInt32;
    int[] arrayOfInt33 = new int[4];
    arrayOfInt33[0] = b(paramArrayOfByte[5], 1);
    arrayOfInt33[1] = 2131099890;
    arrayOfInt33[2] = 2130837837;
    arrayOfInt33[3] = 2130837852;
    arrayOfInt31[1] = arrayOfInt33;
    int[] arrayOfInt34 = new int[4];
    arrayOfInt34[0] = b(paramArrayOfByte[5], 2);
    arrayOfInt34[1] = 2131099891;
    arrayOfInt34[2] = 2130837843;
    arrayOfInt34[3] = 2130837852;
    arrayOfInt31[2] = arrayOfInt34;
    int[] arrayOfInt35 = new int[4];
    arrayOfInt35[0] = b(paramArrayOfByte[5], 3);
    arrayOfInt35[1] = 2131099892;
    arrayOfInt35[2] = 2130837842;
    arrayOfInt35[3] = 2130837854;
    arrayOfInt31[3] = arrayOfInt35;
    int[] arrayOfInt36 = new int[4];
    arrayOfInt36[0] = b(paramArrayOfByte[5], 4);
    arrayOfInt36[1] = 2131099893;
    arrayOfInt36[2] = 2130837842;
    arrayOfInt36[3] = 2130837854;
    arrayOfInt31[4] = arrayOfInt36;
    int[] arrayOfInt37 = new int[4];
    arrayOfInt37[0] = b(paramArrayOfByte[5], 5);
    arrayOfInt37[1] = 2131099894;
    arrayOfInt37[2] = 2130837837;
    arrayOfInt37[3] = 2130837853;
    arrayOfInt31[5] = arrayOfInt37;
    int[] arrayOfInt38 = new int[4];
    arrayOfInt38[0] = b(paramArrayOfByte[5], 6);
    arrayOfInt38[1] = 2131099895;
    arrayOfInt38[2] = 2130837837;
    arrayOfInt38[3] = 2130837853;
    arrayOfInt31[6] = arrayOfInt38;
    int[] arrayOfInt39 = new int[4];
    arrayOfInt39[0] = b(paramArrayOfByte[5], 7);
    arrayOfInt39[1] = 2131099896;
    arrayOfInt39[2] = 2130837830;
    arrayOfInt39[3] = 2130837853;
    arrayOfInt31[7] = arrayOfInt39;
    arrayOfInt[5] = arrayOfInt31;
    int[][] arrayOfInt40 = new int[8][];
    int[] arrayOfInt41 = new int[4];
    arrayOfInt41[0] = b(paramArrayOfByte[6], 0);
    arrayOfInt41[1] = 2131099897;
    arrayOfInt41[2] = 2130837851;
    arrayOfInt41[3] = 2130837852;
    arrayOfInt40[0] = arrayOfInt41;
    int[] arrayOfInt42 = new int[4];
    arrayOfInt42[0] = b(paramArrayOfByte[6], 1);
    arrayOfInt42[1] = 2131099898;
    arrayOfInt42[2] = 2130837833;
    arrayOfInt42[3] = 2130837852;
    arrayOfInt40[1] = arrayOfInt42;
    int[] arrayOfInt43 = new int[4];
    arrayOfInt43[0] = b(paramArrayOfByte[6], 2);
    arrayOfInt43[1] = 2131099899;
    arrayOfInt43[2] = 2130837828;
    arrayOfInt43[3] = 2130837852;
    arrayOfInt40[2] = arrayOfInt43;
    int[] arrayOfInt44 = new int[4];
    arrayOfInt44[0] = b(paramArrayOfByte[6], 3);
    arrayOfInt44[1] = 2131099900;
    arrayOfInt44[2] = 2130837845;
    arrayOfInt44[3] = 2130837852;
    arrayOfInt40[3] = arrayOfInt44;
    int[] arrayOfInt45 = new int[4];
    arrayOfInt45[0] = b(paramArrayOfByte[6], 4);
    arrayOfInt45[1] = 2131099901;
    arrayOfInt45[2] = 2130837851;
    arrayOfInt45[3] = 2130837852;
    arrayOfInt40[4] = arrayOfInt45;
    int[] arrayOfInt46 = new int[4];
    arrayOfInt46[0] = b(paramArrayOfByte[6], 5);
    arrayOfInt46[1] = 2131099902;
    arrayOfInt46[2] = 2130837821;
    arrayOfInt46[3] = 2130837852;
    arrayOfInt40[5] = arrayOfInt46;
    int[] arrayOfInt47 = new int[4];
    arrayOfInt47[0] = b(paramArrayOfByte[6], 6);
    arrayOfInt47[1] = 2131099903;
    arrayOfInt47[2] = 2130837845;
    arrayOfInt47[3] = 2130837854;
    arrayOfInt40[6] = arrayOfInt47;
    int[] arrayOfInt48 = new int[4];
    arrayOfInt48[0] = b(paramArrayOfByte[6], 7);
    arrayOfInt48[1] = 2131099904;
    arrayOfInt48[2] = 2130837838;
    arrayOfInt48[3] = 2130837854;
    arrayOfInt40[7] = arrayOfInt48;
    arrayOfInt[6] = arrayOfInt40;
    int[][] arrayOfInt49 = new int[8][];
    int[] arrayOfInt50 = new int[4];
    arrayOfInt50[0] = b(paramArrayOfByte[7], 0);
    arrayOfInt50[1] = 2131099905;
    arrayOfInt50[2] = 2130837829;
    arrayOfInt50[3] = 2130837853;
    arrayOfInt49[0] = arrayOfInt50;
    int[] arrayOfInt51 = new int[4];
    arrayOfInt51[0] = b(paramArrayOfByte[7], 1);
    arrayOfInt51[1] = 2131099906;
    arrayOfInt51[2] = 2130837829;
    arrayOfInt51[3] = 2130837853;
    arrayOfInt49[1] = arrayOfInt51;
    int[] arrayOfInt52 = new int[4];
    arrayOfInt52[0] = b(paramArrayOfByte[7], 2);
    arrayOfInt52[1] = 2131099907;
    arrayOfInt52[2] = 2130837829;
    arrayOfInt52[3] = 2130837853;
    arrayOfInt49[2] = arrayOfInt52;
    int[] arrayOfInt53 = new int[4];
    arrayOfInt53[0] = b(paramArrayOfByte[7], 3);
    arrayOfInt53[1] = 2131099908;
    arrayOfInt53[2] = 2130837829;
    arrayOfInt53[3] = 2130837853;
    arrayOfInt49[3] = arrayOfInt53;
    int[] arrayOfInt54 = new int[4];
    arrayOfInt54[0] = b(paramArrayOfByte[7], 4);
    arrayOfInt54[1] = 2131099909;
    arrayOfInt54[2] = 2130837824;
    arrayOfInt54[3] = 2130837852;
    arrayOfInt49[4] = arrayOfInt54;
    int[] arrayOfInt55 = new int[4];
    arrayOfInt55[0] = b(paramArrayOfByte[7], 5);
    arrayOfInt55[1] = 2131099910;
    arrayOfInt55[2] = 2130837824;
    arrayOfInt55[3] = 2130837852;
    arrayOfInt49[5] = arrayOfInt55;
    int[] arrayOfInt56 = new int[4];
    arrayOfInt56[0] = b(paramArrayOfByte[7], 6);
    arrayOfInt56[1] = 2131099911;
    arrayOfInt56[2] = 2130837824;
    arrayOfInt56[3] = 2130837852;
    arrayOfInt49[6] = arrayOfInt56;
    int[] arrayOfInt57 = new int[4];
    arrayOfInt57[0] = b(paramArrayOfByte[7], 7);
    arrayOfInt57[1] = 2131099912;
    arrayOfInt57[2] = 2130837824;
    arrayOfInt57[3] = 2130837852;
    arrayOfInt49[7] = arrayOfInt57;
    arrayOfInt[7] = arrayOfInt49;
    int[][] arrayOfInt58 = new int[8][];
    int[] arrayOfInt59 = new int[4];
    arrayOfInt59[0] = b(paramArrayOfByte[8], 0);
    arrayOfInt59[1] = 2131099913;
    arrayOfInt59[2] = 2130837828;
    arrayOfInt59[3] = 2130837852;
    arrayOfInt58[0] = arrayOfInt59;
    int[] arrayOfInt60 = new int[4];
    arrayOfInt60[0] = b(paramArrayOfByte[8], 1);
    arrayOfInt60[1] = 2131099914;
    arrayOfInt60[2] = 2130837828;
    arrayOfInt60[3] = 2130837852;
    arrayOfInt58[1] = arrayOfInt60;
    int[] arrayOfInt61 = new int[4];
    arrayOfInt61[0] = b(paramArrayOfByte[8], 2);
    arrayOfInt61[1] = 2131099915;
    arrayOfInt61[2] = 2130837828;
    arrayOfInt61[3] = 2130837852;
    arrayOfInt58[2] = arrayOfInt61;
    int[] arrayOfInt62 = new int[4];
    arrayOfInt62[0] = b(paramArrayOfByte[8], 3);
    arrayOfInt62[1] = 2131099916;
    arrayOfInt62[2] = 2130837828;
    arrayOfInt62[3] = 2130837852;
    arrayOfInt58[3] = arrayOfInt62;
    int[] arrayOfInt63 = new int[4];
    arrayOfInt63[0] = b(paramArrayOfByte[8], 4);
    arrayOfInt63[1] = 2131099917;
    arrayOfInt63[2] = 2130837828;
    arrayOfInt63[3] = 2130837853;
    arrayOfInt58[4] = arrayOfInt63;
    int[] arrayOfInt64 = new int[4];
    arrayOfInt64[0] = b(paramArrayOfByte[8], 5);
    arrayOfInt64[1] = 2131099918;
    arrayOfInt64[2] = 2130837828;
    arrayOfInt64[3] = 2130837853;
    arrayOfInt58[5] = arrayOfInt64;
    int[] arrayOfInt65 = new int[4];
    arrayOfInt65[0] = b(paramArrayOfByte[8], 6);
    arrayOfInt65[1] = 2131099919;
    arrayOfInt65[2] = 2130837834;
    arrayOfInt65[3] = 2130837853;
    arrayOfInt58[6] = arrayOfInt65;
    int[] arrayOfInt66 = new int[4];
    arrayOfInt66[0] = b(paramArrayOfByte[8], 7);
    arrayOfInt66[1] = 2131099920;
    arrayOfInt66[2] = 2130837834;
    arrayOfInt66[3] = 2130837853;
    arrayOfInt58[7] = arrayOfInt66;
    arrayOfInt[8] = arrayOfInt58;
    int[][] arrayOfInt67 = new int[8][];
    arrayOfInt67[0] = { 0 };
    int[] arrayOfInt68 = new int[4];
    arrayOfInt68[0] = b(paramArrayOfByte[9], 1);
    arrayOfInt68[1] = 2131099921;
    arrayOfInt68[2] = 2130837828;
    arrayOfInt68[3] = 2130837852;
    arrayOfInt67[1] = arrayOfInt68;
    int[] arrayOfInt69 = new int[4];
    arrayOfInt69[0] = b(paramArrayOfByte[9], 2);
    arrayOfInt69[1] = 2131099922;
    arrayOfInt69[2] = 2130837828;
    arrayOfInt69[3] = 2130837852;
    arrayOfInt67[2] = arrayOfInt69;
    int[] arrayOfInt70 = new int[4];
    arrayOfInt70[0] = b(paramArrayOfByte[9], 3);
    arrayOfInt70[1] = 2131099923;
    arrayOfInt70[2] = 2130837828;
    arrayOfInt70[3] = 2130837853;
    arrayOfInt67[3] = arrayOfInt70;
    arrayOfInt67[4] = { 0 };
    arrayOfInt67[5] = { 0 };
    arrayOfInt67[6] = { 0 };
    arrayOfInt67[7] = { 0 };
    arrayOfInt[9] = arrayOfInt67;
    int[][] arrayOfInt71 = new int[8][];
    int[] arrayOfInt72 = new int[4];
    arrayOfInt72[0] = b(paramArrayOfByte[10], 0);
    arrayOfInt72[1] = 2131099924;
    arrayOfInt72[2] = 2130837828;
    arrayOfInt72[3] = 2130837852;
    arrayOfInt71[0] = arrayOfInt72;
    arrayOfInt71[1] = { 0 };
    arrayOfInt71[2] = { 0 };
    arrayOfInt71[3] = { 0 };
    arrayOfInt71[4] = { 0 };
    arrayOfInt71[5] = { 0 };
    arrayOfInt71[6] = { 0 };
    arrayOfInt71[7] = { 0 };
    arrayOfInt[10] = arrayOfInt71;
    int[][] arrayOfInt73 = new int[8][];
    int[] arrayOfInt74 = new int[4];
    arrayOfInt74[0] = b(paramArrayOfByte[11], 0);
    arrayOfInt74[1] = 2131099925;
    arrayOfInt74[2] = 2130837828;
    arrayOfInt74[3] = 2130837852;
    arrayOfInt73[0] = arrayOfInt74;
    int[] arrayOfInt75 = new int[4];
    arrayOfInt75[0] = b(paramArrayOfByte[11], 1);
    arrayOfInt75[1] = 2131099926;
    arrayOfInt75[2] = 2130837828;
    arrayOfInt75[3] = 2130837852;
    arrayOfInt73[1] = arrayOfInt75;
    arrayOfInt73[2] = { 0 };
    arrayOfInt73[3] = { 0 };
    arrayOfInt73[4] = { 0 };
    arrayOfInt73[5] = { 0 };
    arrayOfInt73[6] = { 0 };
    arrayOfInt73[7] = { 0 };
    arrayOfInt[11] = arrayOfInt73;
    int[][] arrayOfInt76 = new int[8][];
    int[] arrayOfInt77 = new int[4];
    arrayOfInt77[0] = b(paramArrayOfByte[12], 0);
    arrayOfInt77[1] = 2131099927;
    arrayOfInt77[2] = 2130837828;
    arrayOfInt77[3] = 2130837852;
    arrayOfInt76[0] = arrayOfInt77;
    int[] arrayOfInt78 = new int[4];
    arrayOfInt78[0] = b(paramArrayOfByte[12], 1);
    arrayOfInt78[1] = 2131099928;
    arrayOfInt78[2] = 2130837828;
    arrayOfInt78[3] = 2130837852;
    arrayOfInt76[1] = arrayOfInt78;
    arrayOfInt76[2] = { 0 };
    arrayOfInt76[3] = { 0 };
    arrayOfInt76[4] = { 0 };
    arrayOfInt76[5] = { 0 };
    arrayOfInt76[6] = { 0 };
    arrayOfInt76[7] = { 0 };
    arrayOfInt[12] = arrayOfInt76;
    int[][] arrayOfInt79 = new int[8][];
    arrayOfInt79[0] = { 0 };
    arrayOfInt79[1] = { 0 };
    arrayOfInt79[2] = { 0 };
    int[] arrayOfInt80 = new int[4];
    arrayOfInt80[0] = b(paramArrayOfByte[13], 3);
    arrayOfInt80[1] = 2131099929;
    arrayOfInt80[2] = 2130837851;
    arrayOfInt80[3] = 2130837852;
    arrayOfInt79[3] = arrayOfInt80;
    arrayOfInt79[4] = { 0 };
    arrayOfInt79[5] = { 0 };
    int[] arrayOfInt81 = new int[4];
    arrayOfInt81[0] = b(paramArrayOfByte[13], 6);
    arrayOfInt81[1] = 2131099930;
    arrayOfInt81[2] = 2130837828;
    arrayOfInt81[3] = 2130837852;
    arrayOfInt79[6] = arrayOfInt81;
    int[] arrayOfInt82 = new int[4];
    arrayOfInt82[0] = b(paramArrayOfByte[13], 7);
    arrayOfInt82[1] = 2131099931;
    arrayOfInt82[2] = 2130837828;
    arrayOfInt82[3] = 2130837852;
    arrayOfInt79[7] = arrayOfInt82;
    arrayOfInt[13] = arrayOfInt79;
    int[][] arrayOfInt83 = new int[8][];
    int[] arrayOfInt84 = new int[4];
    arrayOfInt84[0] = b(paramArrayOfByte[14], 0);
    arrayOfInt84[1] = 2131099932;
    arrayOfInt84[2] = 2130837825;
    arrayOfInt84[3] = 2130837853;
    arrayOfInt83[0] = arrayOfInt84;
    arrayOfInt83[1] = { 0 };
    arrayOfInt83[2] = { 0 };
    arrayOfInt83[3] = { 0 };
    arrayOfInt83[4] = { 0 };
    arrayOfInt83[5] = { 0 };
    arrayOfInt83[6] = { 0 };
    arrayOfInt83[7] = { 0 };
    arrayOfInt[14] = arrayOfInt83;
    int[][] arrayOfInt85 = new int[8][];
    arrayOfInt85[0] = { 0 };
    arrayOfInt85[1] = { 0 };
    arrayOfInt85[2] = { 0 };
    arrayOfInt85[3] = { 0 };
    arrayOfInt85[4] = { 0 };
    int[] arrayOfInt86 = new int[4];
    arrayOfInt86[0] = b(paramArrayOfByte[15], 5);
    arrayOfInt86[1] = 2131099933;
    arrayOfInt86[2] = 2130837825;
    arrayOfInt86[3] = 2130837852;
    arrayOfInt85[5] = arrayOfInt86;
    arrayOfInt85[6] = { 0 };
    int[] arrayOfInt87 = new int[4];
    arrayOfInt87[0] = b(paramArrayOfByte[15], 7);
    arrayOfInt87[1] = 2131099934;
    arrayOfInt87[2] = 2130837828;
    arrayOfInt87[3] = 2130837854;
    arrayOfInt85[7] = arrayOfInt87;
    arrayOfInt[15] = arrayOfInt85;
    return arrayOfInt;
  }

  public void ah()
  {
    this.cv.d(1);
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 0);
    aP();
    ai();
    byte[] arrayOfByte = { 120, 0 };
    this.cv.a((byte)-112, arrayOfByte, 2);
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)27);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)2);
      else if (str.equals("de"))
        c((byte)4);
      else if (str.equals("it"))
        c((byte)5);
      else if (str.equals("fr"))
        c((byte)6);
      else if (str.equals("es"))
        c((byte)8);
      else if (str.equals("tr"))
        c((byte)10);
      else if (str.equals("ru"))
        c((byte)11);
      else if (str.equals("nl"))
        c((byte)12);
      else if (str.equals("pl"))
        c((byte)14);
      else if (str.equals("sv"))
        c((byte)18);
      else if (str.equals("pt"))
        c((byte)22);
    }
  }

  public void aq()
  {
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 1);
  }

  public void ar()
  {
    Settings.System.putInt(this.cv.getContentResolver(), "PowerState", 0);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = this.cv.l();
    if (j == 0)
    {
      this.aY.zero_show = false;
      switch (paramArrayOfByte[(paramInt1 + 1)])
      {
      default:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 48:
      case -126:
      case 112:
      case 113:
      case 114:
      case 120:
      case 121:
      case 64:
      case 80:
      case 81:
      case 82:
      case 83:
      case 41:
      case 40:
      case 42:
      case 32:
      }
    }
    while (true)
    {
      return;
      this.aY.zero_show = true;
      break;
      if (paramArrayOfByte[(paramInt1 + 2)] == 6)
      {
        byte[] arrayOfByte21 = new byte[6];
        int i2 = 0;
        int i3 = 0;
        if (i2 < 6)
        {
          arrayOfByte21[i2] = paramArrayOfByte[(i2 + (paramInt1 + 3))];
          if (i2 == 5);
          while (true)
          {
            i2++;
            break;
            if (arrayOfByte21[i2] != this.cB[i2])
              i3 = 1;
            this.cB[i2] = arrayOfByte21[i2];
          }
        }
        if (((0x10 & arrayOfByte21[1]) != 0) && (i3 != 0))
        {
          m(arrayOfByte21);
          this.cv.a(this.d);
        }
        int i4 = 0xFF & arrayOfByte21[5];
        String str = "";
        if (i4 >= 128)
          i4 -= 256;
        StringBuilder localStringBuilder1;
        Locale localLocale1;
        Object[] arrayOfObject1;
        if ((i4 >= -40) && (i4 <= 86))
        {
          if ((byte)(0x40 & arrayOfByte21[4]) != 64)
            break label540;
          localStringBuilder1 = new StringBuilder();
          localLocale1 = Locale.US;
          arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Float.valueOf(32 + i4 * 9 / 5);
        }
        label540: StringBuilder localStringBuilder2;
        Locale localLocale2;
        Object[] arrayOfObject2;
        for (str = String.format(localLocale1, " %.0f", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099651))
        {
          Intent localIntent2 = new Intent("com.canbus.temperature");
          localIntent2.putExtra("temperature", str);
          this.mContext.sendBroadcast(localIntent2);
          arrayOfByte21[0] = 41;
          arrayOfByte21[1] = arrayOfByte21[4];
          this.cv.d(arrayOfByte21);
          break;
          localStringBuilder2 = new StringBuilder();
          localLocale2 = Locale.US;
          arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(i4);
        }
        if (paramArrayOfByte[(paramInt1 + 2)] == 4)
        {
          byte[] arrayOfByte20 = new byte[4];
          int i1 = 0;
          if (i1 < 4)
          {
            if (paramArrayOfByte[(i1 + (paramInt1 + 3))] == 0)
              arrayOfByte20[i1] = 0;
            while (true)
            {
              i1++;
              break;
              if (paramArrayOfByte[(i1 + (paramInt1 + 3))] < 3)
                arrayOfByte20[i1] = 1;
              else
                arrayOfByte20[i1] = ((byte)(paramArrayOfByte[(i1 + (paramInt1 + 3))] / 2));
            }
          }
          this.aY.max = 15;
          this.aY.back_cnt = 4;
          this.aY.b1 = arrayOfByte20[0];
          this.aY.b2 = arrayOfByte20[1];
          this.aY.b3 = arrayOfByte20[2];
          this.aY.b4 = arrayOfByte20[3];
          if (!this.cV)
          {
            this.aY.front_cnt = 0;
            this.aY.f1 = 0;
            this.aY.f2 = 0;
            this.aY.f3 = 0;
            this.aY.f4 = 0;
          }
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] == 6)
          {
            byte[] arrayOfByte19 = new byte[4];
            int n = 0;
            if (n < 4)
            {
              if (paramArrayOfByte[(n + (paramInt1 + 3))] == 0)
                arrayOfByte19[n] = 0;
              while (true)
              {
                n++;
                break;
                if (paramArrayOfByte[(n + (paramInt1 + 3))] < 3)
                  arrayOfByte19[n] = 1;
                else
                  arrayOfByte19[n] = ((byte)(paramArrayOfByte[(n + (paramInt1 + 3))] / 2));
              }
            }
            this.aY.max = 15;
            this.aY.front_cnt = 4;
            this.aY.f1 = arrayOfByte19[0];
            this.aY.f2 = arrayOfByte19[1];
            this.aY.f3 = arrayOfByte19[2];
            this.aY.f4 = arrayOfByte19[3];
            if (!this.cW)
            {
              this.aY.back_cnt = 0;
              this.aY.b1 = 0;
              this.aY.b2 = 0;
              this.aY.b3 = 0;
              this.aY.b4 = 0;
            }
            this.cv.a(this.aY);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] == 6)
            {
              byte[] arrayOfByte17 = new byte[1];
              arrayOfByte17[0] = paramArrayOfByte[(paramInt1 + 3)];
              n(arrayOfByte17);
              byte[] arrayOfByte18 = new byte[8];
              arrayOfByte18[0] = 36;
              arrayOfByte18[1] = 6;
              while (i < 6)
              {
                arrayOfByte18[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte18);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] == 2)
              {
                if ((0x4 & paramArrayOfByte[(paramInt1 + 3)]) == 4)
                {
                  this.cV = true;
                  label1135: if ((0x8 & paramArrayOfByte[(paramInt1 + 3)]) != 8)
                    break label1246;
                  this.cW = true;
                }
                while (true)
                {
                  if ((this.cW) || (this.cV))
                    break label1301;
                  this.aY.zero_show = false;
                  this.cv.a(this.aY);
                  break;
                  this.cV = false;
                  this.aY.max = 15;
                  this.aY.front_cnt = 0;
                  this.aY.f1 = 0;
                  this.aY.f2 = 0;
                  this.aY.f3 = 0;
                  this.aY.f4 = 0;
                  break label1135;
                  label1246: this.cW = false;
                  this.aY.max = 15;
                  this.aY.back_cnt = 0;
                  this.aY.b1 = 0;
                  this.aY.b2 = 0;
                  this.aY.b3 = 0;
                  this.aY.b4 = 0;
                }
                label1301: continue;
                if ((paramArrayOfByte[(paramInt1 + 2)] == 6) && (goto 224) && (paramArrayOfByte[(paramInt1 + 2)] >= 2))
                {
                  byte[] arrayOfByte16 = new byte[5];
                  arrayOfByte16[0] = 39;
                  arrayOfByte16[1] = paramArrayOfByte[(paramInt1 + 3)];
                  arrayOfByte16[2] = 0;
                  arrayOfByte16[3] = 0;
                  arrayOfByte16[4] = 0;
                  this.cv.d(arrayOfByte16);
                  continue;
                  if ((paramArrayOfByte[(paramInt1 + 2)] == 16) && (goto 224) && (paramArrayOfByte[(paramInt1 + 2)] == 6))
                  {
                    byte[] arrayOfByte15 = new byte[8];
                    arrayOfByte15[0] = -126;
                    arrayOfByte15[1] = 6;
                    while (i < 6)
                    {
                      arrayOfByte15[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                      i++;
                    }
                    this.cv.c(arrayOfByte15);
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                    {
                      byte[] arrayOfByte14 = new byte[22];
                      arrayOfByte14[0] = 112;
                      arrayOfByte14[1] = 20;
                      while (i < 20)
                      {
                        arrayOfByte14[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                        i++;
                      }
                      this.cv.c(arrayOfByte14);
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                      {
                        byte[] arrayOfByte13 = new byte[22];
                        arrayOfByte13[0] = 113;
                        arrayOfByte13[1] = 20;
                        while (i < 20)
                        {
                          arrayOfByte13[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.c(arrayOfByte13);
                        continue;
                        if (paramArrayOfByte[(paramInt1 + 2)] == 20)
                        {
                          byte[] arrayOfByte12 = new byte[22];
                          arrayOfByte12[0] = 114;
                          arrayOfByte12[1] = 20;
                          while (i < 20)
                          {
                            arrayOfByte12[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.c(arrayOfByte12);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] == 5)
                          {
                            byte[] arrayOfByte11 = new byte[7];
                            arrayOfByte11[0] = 120;
                            arrayOfByte11[1] = 5;
                            while (i < 5)
                            {
                              arrayOfByte11[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte11);
                          }
                          else if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                          {
                            byte[] arrayOfByte10 = new byte[7];
                            arrayOfByte10[0] = 120;
                            arrayOfByte10[1] = 3;
                            while (i < 3)
                            {
                              arrayOfByte10[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.c(arrayOfByte10);
                            continue;
                            if ((paramArrayOfByte[(paramInt1 + 2)] == 1) && (j == 0))
                            {
                              byte[] arrayOfByte9 = new byte[3];
                              arrayOfByte9[0] = 121;
                              arrayOfByte9[1] = 1;
                              while (i < 1)
                              {
                                arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.c(arrayOfByte9);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] == 1)
                              {
                                byte[] arrayOfByte8 = new byte[3];
                                arrayOfByte8[0] = 64;
                                arrayOfByte8[1] = 1;
                                while (i < 1)
                                {
                                  arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.c(arrayOfByte8);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] == 8)
                                {
                                  byte[] arrayOfByte7 = new byte[10];
                                  arrayOfByte7[0] = 80;
                                  arrayOfByte7[1] = 8;
                                  while (i < 8)
                                  {
                                    arrayOfByte7[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte7);
                                  continue;
                                  int m = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
                                  byte[] arrayOfByte6 = new byte[m + 2];
                                  arrayOfByte6[0] = 81;
                                  arrayOfByte6[1] = paramArrayOfByte[(paramInt1 + 2)];
                                  while (i < m)
                                  {
                                    arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.c(arrayOfByte6);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                  {
                                    byte[] arrayOfByte5 = new byte[5];
                                    arrayOfByte5[0] = 82;
                                    arrayOfByte5[1] = 3;
                                    while (i < 3)
                                    {
                                      arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                      i++;
                                    }
                                    this.cv.c(arrayOfByte5);
                                    continue;
                                    if (paramArrayOfByte[(paramInt1 + 2)] == 3)
                                    {
                                      byte[] arrayOfByte4 = new byte[5];
                                      arrayOfByte4[0] = 83;
                                      arrayOfByte4[1] = 3;
                                      while (i < 3)
                                      {
                                        arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                        i++;
                                      }
                                      this.cv.c(arrayOfByte4);
                                      continue;
                                      if ((paramArrayOfByte[(paramInt1 + 2)] == 8) && (goto 224) && (paramArrayOfByte[(paramInt1 + 2)] == 2))
                                      {
                                        byte[] arrayOfByte3 = new byte[3];
                                        arrayOfByte3[0] = 40;
                                        arrayOfByte3[1] = paramArrayOfByte[(paramInt1 + 3)];
                                        arrayOfByte3[2] = paramArrayOfByte[(paramInt1 + 4)];
                                        Intent localIntent1 = new Intent();
                                        localIntent1.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.ParkServer"));
                                        localIntent1.putExtra("canbustype", this.e);
                                        localIntent1.putExtra("park", arrayOfByte3);
                                        if ((0x1 & arrayOfByte3[1]) != 0)
                                        {
                                          this.mContext.startService(localIntent1);
                                        }
                                        else
                                        {
                                          this.mContext.stopService(localIntent1);
                                          continue;
                                          if ((paramArrayOfByte[(paramInt1 + 2)] >= 16) && (Settings.System.getInt(this.cv.getContentResolver(), "mOff_Warning_infor", 1) == 1))
                                          {
                                            byte[] arrayOfByte2 = new byte[16];
                                            while (i < 16)
                                            {
                                              arrayOfByte2[i] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                              i++;
                                            }
                                            this.bn.b(t(arrayOfByte2));
                                            this.bn.r(16);
                                            ay();
                                            continue;
                                            if (paramArrayOfByte[(paramInt1 + 2)] == 2)
                                            {
                                              byte[] arrayOfByte1 = new byte[4];
                                              arrayOfByte1[0] = 32;
                                              arrayOfByte1[1] = 2;
                                              for (int k = 0; k < 2; k++)
                                                arrayOfByte1[(k + 2)] = paramArrayOfByte[(k + (paramInt1 + 3))];
                                              this.cv.c(arrayOfByte1);
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
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
 * Qualified Name:     android.microntek.canbus.c.bu
 * JD-Core Version:    0.6.2
 */