package android.microntek.canbus.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.microntek.canbus.BaseApplication;
import android.microntek.canbus.CanBusServer;
import android.microntek.canbus.b.a;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Warning;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.util.Log;
import java.util.Locale;

public class bt extends a
{
  private int dE = 51;
  private byte[] dF = new byte[''];

  public bt(CanBusServer paramCanBusServer, Context paramContext)
  {
    super(paramCanBusServer, paramContext);
    this.e = 61;
  }

  private void B(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.microntek.controlinfo", "com.microntek.controlinfo.canbus61carinfo"));
    localIntent.addFlags(807600128);
    localIntent.putExtra("cftype", paramInt);
    try
    {
      this.cv.startActivityAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        Log.e("Canbus50", "controlinfo activity not found! " + localActivityNotFoundException.getMessage());
    }
  }

  private int E(int paramInt)
  {
    return 60 * (paramInt / 1000 / 60 / 60) + paramInt / 1000 / 60 % 60;
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

  private int c(byte paramByte, int paramInt)
  {
    if ((0x1 & paramByte >> paramInt) == 1);
    for (int i = 61441; ; i = 0)
      return i;
  }

  private void c(byte paramByte)
  {
    byte[] arrayOfByte = { 11, paramByte };
    this.cv.a((byte)-128, arrayOfByte, 2);
  }

  private int d(byte paramByte, int paramInt)
  {
    if ((0x7 & paramByte >> 4) == paramInt);
    for (int i = 61441; ; i = 0)
      return i;
  }

  private void m(byte[] paramArrayOfByte)
  {
    this.d.seatShow = false;
    AirCondition localAirCondition1 = this.d;
    localAirCondition1.modeAuto = 0;
    label58: label74: label92: label108: boolean bool;
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      this.d.onOff = true;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label430;
      this.d.modeAc = true;
      if ((0x4 & paramArrayOfByte[0]) == 0)
        break label441;
      this.d.modeDual = 1;
      if ((0x80 & paramArrayOfByte[4]) == 0)
        break label452;
      this.d.windFrontMax = true;
      if ((0x1 & paramArrayOfByte[0]) == 0)
        break label463;
      this.d.windRear = true;
      int i = paramArrayOfByte[1];
      if ((i & 0x80) == 0)
        break label474;
      this.d.windUp = true;
      label130: if ((i & 0x40) == 0)
        break label485;
      this.d.windMid = true;
      label146: if ((i & 0x20) == 0)
        break label496;
      this.d.windDown = true;
      label162: if (((i & 0xE0) == 0) || ((0x8 & paramArrayOfByte[0]) != 0))
      {
        AirCondition localAirCondition2 = this.d;
        localAirCondition2.modeAuto = 1;
      }
      this.d.windLevel = (0xF & paramArrayOfByte[1]);
      if (this.d.windLevel == 0)
      {
        AirCondition localAirCondition9 = this.d;
        localAirCondition9.modeAuto = 1;
      }
      if (this.d.windLevel >= 1)
        this.d.windLevel = (-1 + this.d.windLevel);
      this.d.windLevelMax = 8;
      AirCondition localAirCondition3 = this.d;
      if ((0x1 & paramArrayOfByte[4]) != 1)
        break label507;
      bool = true;
      label291: localAirCondition3.tempUnit = bool;
      if ((0x2 & paramArrayOfByte[4]) != 0)
        break label513;
      int j = 0xFF & paramArrayOfByte[2];
      this.d.tempLeft = v(j);
      int k = 0xFF & paramArrayOfByte[3];
      this.d.tempRight = v(k);
      label350: if ((0x20 & paramArrayOfByte[0]) == 0)
        break label570;
      if ((0x20 & paramArrayOfByte[4]) == 0)
        break label550;
      AirCondition localAirCondition8 = this.d;
      localAirCondition8.windLoop = 2;
      label385: if ((0x4 & paramArrayOfByte[4]) == 0)
        break label590;
      this.d.rearLock = 1;
      label401: if ((0x8 & paramArrayOfByte[4]) == 0)
        break label601;
    }
    label430: label441: label452: label463: label601: for (this.d.acMax = 1; ; this.d.acMax = 0)
    {
      return;
      this.d.onOff = false;
      break;
      this.d.modeAc = false;
      break label58;
      this.d.modeDual = 0;
      break label74;
      this.d.windFrontMax = false;
      break label92;
      this.d.windRear = false;
      break label108;
      label474: this.d.windUp = false;
      break label130;
      label485: this.d.windMid = false;
      break label146;
      label496: this.d.windDown = false;
      break label162;
      label507: bool = false;
      break label291;
      AirCondition localAirCondition4 = this.d;
      localAirCondition4.tempLeft = -1;
      AirCondition localAirCondition5 = this.d;
      localAirCondition5.tempRight = -1;
      break label350;
      AirCondition localAirCondition7 = this.d;
      localAirCondition7.windLoop = 1;
      break label385;
      AirCondition localAirCondition6 = this.d;
      localAirCondition6.windLoop = 0;
      break label385;
      this.d.rearLock = 0;
      break label401;
    }
  }

  private int[][][] t(byte[] paramArrayOfByte)
  {
    int[][][] arrayOfInt = new int[17][][];
    int[][] arrayOfInt1 = new int[8][];
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = b(paramArrayOfByte[0], 0);
    arrayOfInt2[1] = 2131099719;
    arrayOfInt2[2] = 2130837846;
    arrayOfInt1[0] = arrayOfInt2;
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = b(paramArrayOfByte[0], 1);
    arrayOfInt3[1] = 2131099720;
    arrayOfInt3[2] = 2130837828;
    arrayOfInt1[1] = arrayOfInt3;
    int[] arrayOfInt4 = new int[3];
    arrayOfInt4[0] = b(paramArrayOfByte[0], 2);
    arrayOfInt4[1] = 2131099721;
    arrayOfInt4[2] = 2130837841;
    arrayOfInt1[2] = arrayOfInt4;
    int[] arrayOfInt5 = new int[3];
    arrayOfInt5[0] = b(paramArrayOfByte[0], 3);
    arrayOfInt5[1] = 2131099722;
    arrayOfInt5[2] = 2130837841;
    arrayOfInt1[3] = arrayOfInt5;
    int[] arrayOfInt6 = new int[3];
    arrayOfInt6[0] = b(paramArrayOfByte[0], 4);
    arrayOfInt6[1] = 2131099723;
    arrayOfInt6[2] = 2130837828;
    arrayOfInt1[4] = arrayOfInt6;
    int[] arrayOfInt7 = new int[3];
    arrayOfInt7[0] = b(paramArrayOfByte[0], 5);
    arrayOfInt7[1] = 2131099724;
    arrayOfInt7[2] = 2130837828;
    arrayOfInt1[5] = arrayOfInt7;
    int[] arrayOfInt8 = new int[3];
    arrayOfInt8[0] = b(paramArrayOfByte[0], 6);
    arrayOfInt8[1] = 2131099725;
    arrayOfInt8[2] = 2130837828;
    arrayOfInt1[6] = arrayOfInt8;
    int[] arrayOfInt9 = new int[3];
    arrayOfInt9[0] = b(paramArrayOfByte[0], 7);
    arrayOfInt9[1] = 2131099726;
    arrayOfInt9[2] = 2130837842;
    arrayOfInt1[7] = arrayOfInt9;
    arrayOfInt[0] = arrayOfInt1;
    int[][] arrayOfInt10 = new int[8][];
    int[] arrayOfInt11 = new int[3];
    arrayOfInt11[0] = b(paramArrayOfByte[1], 0);
    arrayOfInt11[1] = 2131099727;
    arrayOfInt11[2] = 2130837828;
    arrayOfInt10[0] = arrayOfInt11;
    int[] arrayOfInt12 = new int[3];
    arrayOfInt12[0] = b(paramArrayOfByte[1], 1);
    arrayOfInt12[1] = 2131099728;
    arrayOfInt12[2] = 2130837825;
    arrayOfInt10[1] = arrayOfInt12;
    int[] arrayOfInt13 = new int[3];
    arrayOfInt13[0] = b(paramArrayOfByte[1], 2);
    arrayOfInt13[1] = 2131099729;
    arrayOfInt13[2] = 2130837828;
    arrayOfInt10[2] = arrayOfInt13;
    int[] arrayOfInt14 = new int[3];
    arrayOfInt14[0] = b(paramArrayOfByte[1], 3);
    arrayOfInt14[1] = 2131099730;
    arrayOfInt14[2] = 2130837828;
    arrayOfInt10[3] = arrayOfInt14;
    int[] arrayOfInt15 = new int[3];
    arrayOfInt15[0] = b(paramArrayOfByte[1], 4);
    arrayOfInt15[1] = 2131099731;
    arrayOfInt15[2] = 2130837819;
    arrayOfInt10[4] = arrayOfInt15;
    int[] arrayOfInt16 = new int[3];
    arrayOfInt16[0] = b(paramArrayOfByte[1], 5);
    arrayOfInt16[1] = 2131099732;
    arrayOfInt16[2] = 2130837820;
    arrayOfInt10[5] = arrayOfInt16;
    int[] arrayOfInt17 = new int[3];
    arrayOfInt17[0] = b(paramArrayOfByte[1], 6);
    arrayOfInt17[1] = 2131099733;
    arrayOfInt17[2] = 2130837828;
    arrayOfInt10[6] = arrayOfInt17;
    int[] arrayOfInt18 = new int[3];
    arrayOfInt18[0] = b(paramArrayOfByte[1], 7);
    arrayOfInt18[1] = 2131099734;
    arrayOfInt18[2] = 2130837842;
    arrayOfInt10[7] = arrayOfInt18;
    arrayOfInt[1] = arrayOfInt10;
    int[][] arrayOfInt19 = new int[8][];
    int[] arrayOfInt20 = new int[3];
    arrayOfInt20[0] = b(paramArrayOfByte[2], 0);
    arrayOfInt20[1] = 2131099735;
    arrayOfInt20[2] = 2130837847;
    arrayOfInt19[0] = arrayOfInt20;
    int[] arrayOfInt21 = new int[3];
    arrayOfInt21[0] = b(paramArrayOfByte[2], 1);
    arrayOfInt21[1] = 2131099736;
    arrayOfInt21[2] = 2130837828;
    arrayOfInt19[1] = arrayOfInt21;
    int[] arrayOfInt22 = new int[3];
    arrayOfInt22[0] = b(paramArrayOfByte[2], 2);
    arrayOfInt22[1] = 2131099737;
    arrayOfInt22[2] = 2130837822;
    arrayOfInt19[2] = arrayOfInt22;
    int[] arrayOfInt23 = new int[3];
    arrayOfInt23[0] = b(paramArrayOfByte[2], 3);
    arrayOfInt23[1] = 2131099738;
    arrayOfInt23[2] = 2130837828;
    arrayOfInt19[3] = arrayOfInt23;
    int[] arrayOfInt24 = new int[3];
    arrayOfInt24[0] = b(paramArrayOfByte[2], 4);
    arrayOfInt24[1] = 2131099739;
    arrayOfInt24[2] = 2130837824;
    arrayOfInt19[4] = arrayOfInt24;
    int[] arrayOfInt25 = new int[3];
    arrayOfInt25[0] = b(paramArrayOfByte[2], 5);
    arrayOfInt25[1] = 2131099740;
    arrayOfInt25[2] = 2130837833;
    arrayOfInt19[5] = arrayOfInt25;
    int[] arrayOfInt26 = new int[3];
    arrayOfInt26[0] = b(paramArrayOfByte[2], 6);
    arrayOfInt26[1] = 2131099741;
    arrayOfInt26[2] = 2130837828;
    arrayOfInt19[6] = arrayOfInt26;
    int[] arrayOfInt27 = new int[3];
    arrayOfInt27[0] = b(paramArrayOfByte[2], 7);
    arrayOfInt27[1] = 2131099742;
    arrayOfInt27[2] = 2130837848;
    arrayOfInt19[7] = arrayOfInt27;
    arrayOfInt[2] = arrayOfInt19;
    int[][] arrayOfInt28 = new int[8][];
    arrayOfInt28[0] = { 0, 2131099743, 2130837828 };
    int[] arrayOfInt29 = new int[3];
    arrayOfInt29[0] = b(paramArrayOfByte[3], 1);
    arrayOfInt29[1] = 2131099744;
    arrayOfInt29[2] = 2130837828;
    arrayOfInt28[1] = arrayOfInt29;
    int[] arrayOfInt30 = new int[3];
    arrayOfInt30[0] = b(paramArrayOfByte[3], 2);
    arrayOfInt30[1] = 2131099745;
    arrayOfInt30[2] = 2130837828;
    arrayOfInt28[2] = arrayOfInt30;
    int[] arrayOfInt31 = new int[3];
    arrayOfInt31[0] = b(paramArrayOfByte[3], 3);
    arrayOfInt31[1] = 2131099746;
    arrayOfInt31[2] = 2130837849;
    arrayOfInt28[3] = arrayOfInt31;
    int[] arrayOfInt32 = new int[3];
    arrayOfInt32[0] = b(paramArrayOfByte[3], 4);
    arrayOfInt32[1] = 2131099747;
    arrayOfInt32[2] = 2130837828;
    arrayOfInt28[4] = arrayOfInt32;
    int[] arrayOfInt33 = new int[3];
    arrayOfInt33[0] = b(paramArrayOfByte[3], 5);
    arrayOfInt33[1] = 2131099748;
    arrayOfInt33[2] = 2130837828;
    arrayOfInt28[5] = arrayOfInt33;
    int[] arrayOfInt34 = new int[3];
    arrayOfInt34[0] = b(paramArrayOfByte[3], 6);
    arrayOfInt34[1] = 2131099749;
    arrayOfInt34[2] = 2130837828;
    arrayOfInt28[6] = arrayOfInt34;
    int[] arrayOfInt35 = new int[3];
    arrayOfInt35[0] = b(paramArrayOfByte[3], 7);
    arrayOfInt35[1] = 2131099750;
    arrayOfInt35[2] = 2130837828;
    arrayOfInt28[7] = arrayOfInt35;
    arrayOfInt[3] = arrayOfInt28;
    int[][] arrayOfInt36 = new int[8][];
    int[] arrayOfInt37 = new int[3];
    arrayOfInt37[0] = b(paramArrayOfByte[4], 0);
    arrayOfInt37[1] = 2131099751;
    arrayOfInt37[2] = 2130837828;
    arrayOfInt36[0] = arrayOfInt37;
    int[] arrayOfInt38 = new int[3];
    arrayOfInt38[0] = b(paramArrayOfByte[4], 1);
    arrayOfInt38[1] = 2131099752;
    arrayOfInt38[2] = 2130837828;
    arrayOfInt36[1] = arrayOfInt38;
    int[] arrayOfInt39 = new int[3];
    arrayOfInt39[0] = b(paramArrayOfByte[4], 2);
    arrayOfInt39[1] = 2131099753;
    arrayOfInt39[2] = 2130837828;
    arrayOfInt36[2] = arrayOfInt39;
    int[] arrayOfInt40 = new int[3];
    arrayOfInt40[0] = b(paramArrayOfByte[4], 3);
    arrayOfInt40[1] = 2131099754;
    arrayOfInt40[2] = 2130837828;
    arrayOfInt36[3] = arrayOfInt40;
    int[] arrayOfInt41 = new int[3];
    arrayOfInt41[0] = b(paramArrayOfByte[4], 4);
    arrayOfInt41[1] = 2131099755;
    arrayOfInt41[2] = 2130837828;
    arrayOfInt36[4] = arrayOfInt41;
    int[] arrayOfInt42 = new int[3];
    arrayOfInt42[0] = b(paramArrayOfByte[4], 5);
    arrayOfInt42[1] = 2131099756;
    arrayOfInt42[2] = 2130837828;
    arrayOfInt36[5] = arrayOfInt42;
    int[] arrayOfInt43 = new int[3];
    arrayOfInt43[0] = b(paramArrayOfByte[4], 6);
    arrayOfInt43[1] = 2131099757;
    arrayOfInt43[2] = 2130837828;
    arrayOfInt36[6] = arrayOfInt43;
    arrayOfInt36[7] = { 0, 2131099758, 2130837828 };
    arrayOfInt[4] = arrayOfInt36;
    int[][] arrayOfInt44 = new int[8][];
    int[] arrayOfInt45 = new int[3];
    arrayOfInt45[0] = b(paramArrayOfByte[5], 0);
    arrayOfInt45[1] = 2131099759;
    arrayOfInt45[2] = 2130837828;
    arrayOfInt44[0] = arrayOfInt45;
    int[] arrayOfInt46 = new int[3];
    arrayOfInt46[0] = b(paramArrayOfByte[5], 1);
    arrayOfInt46[1] = 2131099760;
    arrayOfInt46[2] = 2130837828;
    arrayOfInt44[1] = arrayOfInt46;
    int[] arrayOfInt47 = new int[3];
    arrayOfInt47[0] = b(paramArrayOfByte[5], 2);
    arrayOfInt47[1] = 2131099761;
    arrayOfInt47[2] = 2130837828;
    arrayOfInt44[2] = arrayOfInt47;
    int[] arrayOfInt48 = new int[3];
    arrayOfInt48[0] = b(paramArrayOfByte[5], 3);
    arrayOfInt48[1] = 2131099762;
    arrayOfInt48[2] = 2130837828;
    arrayOfInt44[3] = arrayOfInt48;
    int[] arrayOfInt49 = new int[3];
    arrayOfInt49[0] = b(paramArrayOfByte[5], 4);
    arrayOfInt49[1] = 2131099763;
    arrayOfInt49[2] = 2130837828;
    arrayOfInt44[4] = arrayOfInt49;
    int[] arrayOfInt50 = new int[3];
    arrayOfInt50[0] = b(paramArrayOfByte[5], 5);
    arrayOfInt50[1] = 2131099764;
    arrayOfInt50[2] = 2130837828;
    arrayOfInt44[5] = arrayOfInt50;
    int[] arrayOfInt51 = new int[3];
    arrayOfInt51[0] = b(paramArrayOfByte[5], 6);
    arrayOfInt51[1] = 2131099765;
    arrayOfInt51[2] = 2130837828;
    arrayOfInt44[6] = arrayOfInt51;
    int[] arrayOfInt52 = new int[3];
    arrayOfInt52[0] = b(paramArrayOfByte[5], 7);
    arrayOfInt52[1] = 2131099766;
    arrayOfInt52[2] = 2130837828;
    arrayOfInt44[7] = arrayOfInt52;
    arrayOfInt[5] = arrayOfInt44;
    int[][] arrayOfInt53 = new int[8][];
    int[] arrayOfInt54 = new int[3];
    arrayOfInt54[0] = b(paramArrayOfByte[6], 0);
    arrayOfInt54[1] = 2131099767;
    arrayOfInt54[2] = 2130837828;
    arrayOfInt53[0] = arrayOfInt54;
    int[] arrayOfInt55 = new int[3];
    arrayOfInt55[0] = b(paramArrayOfByte[6], 1);
    arrayOfInt55[1] = 2131099768;
    arrayOfInt55[2] = 2130837828;
    arrayOfInt53[1] = arrayOfInt55;
    int[] arrayOfInt56 = new int[3];
    arrayOfInt56[0] = b(paramArrayOfByte[6], 2);
    arrayOfInt56[1] = 2131099769;
    arrayOfInt56[2] = 2130837828;
    arrayOfInt53[2] = arrayOfInt56;
    int[] arrayOfInt57 = new int[3];
    arrayOfInt57[0] = b(paramArrayOfByte[6], 3);
    arrayOfInt57[1] = 2131099770;
    arrayOfInt57[2] = 2130837828;
    arrayOfInt53[3] = arrayOfInt57;
    int[] arrayOfInt58 = new int[3];
    arrayOfInt58[0] = b(paramArrayOfByte[6], 4);
    arrayOfInt58[1] = 2131099771;
    arrayOfInt58[2] = 2130837828;
    arrayOfInt53[4] = arrayOfInt58;
    int[] arrayOfInt59 = new int[3];
    arrayOfInt59[0] = b(paramArrayOfByte[6], 5);
    arrayOfInt59[1] = 2131099772;
    arrayOfInt59[2] = 2130837828;
    arrayOfInt53[5] = arrayOfInt59;
    int[] arrayOfInt60 = new int[3];
    arrayOfInt60[0] = b(paramArrayOfByte[6], 6);
    arrayOfInt60[1] = 2131099773;
    arrayOfInt60[2] = 2130837828;
    arrayOfInt53[6] = arrayOfInt60;
    int[] arrayOfInt61 = new int[3];
    arrayOfInt61[0] = b(paramArrayOfByte[6], 7);
    arrayOfInt61[1] = 2131099774;
    arrayOfInt61[2] = 2130837828;
    arrayOfInt53[7] = arrayOfInt61;
    arrayOfInt[6] = arrayOfInt53;
    int[][] arrayOfInt62 = new int[8][];
    int[] arrayOfInt63 = new int[3];
    arrayOfInt63[0] = b(paramArrayOfByte[7], 0);
    arrayOfInt63[1] = 2131099775;
    arrayOfInt63[2] = 2130837850;
    arrayOfInt62[0] = arrayOfInt63;
    int[] arrayOfInt64 = new int[3];
    arrayOfInt64[0] = b(paramArrayOfByte[7], 1);
    arrayOfInt64[1] = 2131099776;
    arrayOfInt64[2] = 2130837828;
    arrayOfInt62[1] = arrayOfInt64;
    int[] arrayOfInt65 = new int[3];
    arrayOfInt65[0] = b(paramArrayOfByte[7], 2);
    arrayOfInt65[1] = 2131099777;
    arrayOfInt65[2] = 2130837828;
    arrayOfInt62[2] = arrayOfInt65;
    int[] arrayOfInt66 = new int[3];
    arrayOfInt66[0] = b(paramArrayOfByte[7], 3);
    arrayOfInt66[1] = 2131099778;
    arrayOfInt66[2] = 2130837828;
    arrayOfInt62[3] = arrayOfInt66;
    int[] arrayOfInt67 = new int[3];
    arrayOfInt67[0] = b(paramArrayOfByte[7], 4);
    arrayOfInt67[1] = 2131099779;
    arrayOfInt67[2] = 2130837828;
    arrayOfInt62[4] = arrayOfInt67;
    int[] arrayOfInt68 = new int[3];
    arrayOfInt68[0] = b(paramArrayOfByte[7], 5);
    arrayOfInt68[1] = 2131099780;
    arrayOfInt68[2] = 2130837828;
    arrayOfInt62[5] = arrayOfInt68;
    int[] arrayOfInt69 = new int[3];
    arrayOfInt69[0] = b(paramArrayOfByte[7], 6);
    arrayOfInt69[1] = 2131099781;
    arrayOfInt69[2] = 2130837828;
    arrayOfInt62[6] = arrayOfInt69;
    int[] arrayOfInt70 = new int[3];
    arrayOfInt70[0] = b(paramArrayOfByte[7], 7);
    arrayOfInt70[1] = 2131099782;
    arrayOfInt70[2] = 2130837828;
    arrayOfInt62[7] = arrayOfInt70;
    arrayOfInt[7] = arrayOfInt62;
    int[][] arrayOfInt71 = new int[8][];
    int[] arrayOfInt72 = new int[3];
    arrayOfInt72[0] = b(paramArrayOfByte[8], 0);
    arrayOfInt72[1] = 2131099783;
    arrayOfInt72[2] = 2130837828;
    arrayOfInt71[0] = arrayOfInt72;
    int[] arrayOfInt73 = new int[3];
    arrayOfInt73[0] = b(paramArrayOfByte[8], 1);
    arrayOfInt73[1] = 2131099784;
    arrayOfInt73[2] = 2130837828;
    arrayOfInt71[1] = arrayOfInt73;
    int[] arrayOfInt74 = new int[3];
    arrayOfInt74[0] = b(paramArrayOfByte[8], 2);
    arrayOfInt74[1] = 2131099785;
    arrayOfInt74[2] = 2130837828;
    arrayOfInt71[2] = arrayOfInt74;
    int[] arrayOfInt75 = new int[3];
    arrayOfInt75[0] = b(paramArrayOfByte[8], 3);
    arrayOfInt75[1] = 2131099786;
    arrayOfInt75[2] = 2130837828;
    arrayOfInt71[3] = arrayOfInt75;
    int[] arrayOfInt76 = new int[3];
    arrayOfInt76[0] = b(paramArrayOfByte[8], 4);
    arrayOfInt76[1] = 2131099787;
    arrayOfInt76[2] = 2130837828;
    arrayOfInt71[4] = arrayOfInt76;
    int[] arrayOfInt77 = new int[3];
    arrayOfInt77[0] = b(paramArrayOfByte[8], 5);
    arrayOfInt77[1] = 2131099788;
    arrayOfInt77[2] = 2130837828;
    arrayOfInt71[5] = arrayOfInt77;
    int[] arrayOfInt78 = new int[3];
    arrayOfInt78[0] = b(paramArrayOfByte[8], 6);
    arrayOfInt78[1] = 2131099789;
    arrayOfInt78[2] = 2130837828;
    arrayOfInt71[6] = arrayOfInt78;
    int[] arrayOfInt79 = new int[3];
    arrayOfInt79[0] = b(paramArrayOfByte[8], 7);
    arrayOfInt79[1] = 2131099790;
    arrayOfInt79[2] = 2130837828;
    arrayOfInt71[7] = arrayOfInt79;
    arrayOfInt[8] = arrayOfInt71;
    int[][] arrayOfInt80 = new int[8][];
    int[] arrayOfInt81 = new int[3];
    arrayOfInt81[0] = b(paramArrayOfByte[9], 0);
    arrayOfInt81[1] = 2131099791;
    arrayOfInt81[2] = 2130837828;
    arrayOfInt80[0] = arrayOfInt81;
    int[] arrayOfInt82 = new int[3];
    arrayOfInt82[0] = b(paramArrayOfByte[9], 1);
    arrayOfInt82[1] = 2131099792;
    arrayOfInt82[2] = 2130837828;
    arrayOfInt80[1] = arrayOfInt82;
    int[] arrayOfInt83 = new int[3];
    arrayOfInt83[0] = b(paramArrayOfByte[9], 2);
    arrayOfInt83[1] = 2131099793;
    arrayOfInt83[2] = 2130837828;
    arrayOfInt80[2] = arrayOfInt83;
    int[] arrayOfInt84 = new int[3];
    arrayOfInt84[0] = b(paramArrayOfByte[9], 3);
    arrayOfInt84[1] = 2131099794;
    arrayOfInt84[2] = 2130837828;
    arrayOfInt80[3] = arrayOfInt84;
    int[] arrayOfInt85 = new int[3];
    arrayOfInt85[0] = b(paramArrayOfByte[9], 4);
    arrayOfInt85[1] = 2131099795;
    arrayOfInt85[2] = 2130837828;
    arrayOfInt80[4] = arrayOfInt85;
    int[] arrayOfInt86 = new int[3];
    arrayOfInt86[0] = b(paramArrayOfByte[9], 5);
    arrayOfInt86[1] = 2131099796;
    arrayOfInt86[2] = 2130837828;
    arrayOfInt80[5] = arrayOfInt86;
    int[] arrayOfInt87 = new int[3];
    arrayOfInt87[0] = b(paramArrayOfByte[9], 6);
    arrayOfInt87[1] = 2131099797;
    arrayOfInt87[2] = 2130837828;
    arrayOfInt80[6] = arrayOfInt87;
    int[] arrayOfInt88 = new int[3];
    arrayOfInt88[0] = b(paramArrayOfByte[9], 7);
    arrayOfInt88[1] = 2131099798;
    arrayOfInt88[2] = 2130837828;
    arrayOfInt80[7] = arrayOfInt88;
    arrayOfInt[9] = arrayOfInt80;
    int[][] arrayOfInt89 = new int[8][];
    int[] arrayOfInt90 = new int[3];
    arrayOfInt90[0] = b(paramArrayOfByte[10], 0);
    arrayOfInt90[1] = 2131099799;
    arrayOfInt90[2] = 2130837828;
    arrayOfInt89[0] = arrayOfInt90;
    int[] arrayOfInt91 = new int[3];
    arrayOfInt91[0] = b(paramArrayOfByte[10], 1);
    arrayOfInt91[1] = 2131099800;
    arrayOfInt91[2] = 2130837828;
    arrayOfInt89[1] = arrayOfInt91;
    int[] arrayOfInt92 = new int[3];
    arrayOfInt92[0] = b(paramArrayOfByte[10], 2);
    arrayOfInt92[1] = 2131099801;
    arrayOfInt92[2] = 2130837828;
    arrayOfInt89[2] = arrayOfInt92;
    int[] arrayOfInt93 = new int[3];
    arrayOfInt93[0] = b(paramArrayOfByte[10], 3);
    arrayOfInt93[1] = 2131099802;
    arrayOfInt93[2] = 2130837828;
    arrayOfInt89[3] = arrayOfInt93;
    int[] arrayOfInt94 = new int[3];
    arrayOfInt94[0] = b(paramArrayOfByte[10], 4);
    arrayOfInt94[1] = 2131099803;
    arrayOfInt94[2] = 2130837828;
    arrayOfInt89[4] = arrayOfInt94;
    int[] arrayOfInt95 = new int[3];
    arrayOfInt95[0] = b(paramArrayOfByte[10], 5);
    arrayOfInt95[1] = 2131099804;
    arrayOfInt95[2] = 2130837828;
    arrayOfInt89[5] = arrayOfInt95;
    int[] arrayOfInt96 = new int[3];
    arrayOfInt96[0] = b(paramArrayOfByte[10], 6);
    arrayOfInt96[1] = 2131099805;
    arrayOfInt96[2] = 2130837828;
    arrayOfInt89[6] = arrayOfInt96;
    int[] arrayOfInt97 = new int[3];
    arrayOfInt97[0] = b(paramArrayOfByte[10], 7);
    arrayOfInt97[1] = 2131099806;
    arrayOfInt97[2] = 2130837828;
    arrayOfInt89[7] = arrayOfInt97;
    arrayOfInt[10] = arrayOfInt89;
    int[][] arrayOfInt98 = new int[8][];
    int[] arrayOfInt99 = new int[3];
    arrayOfInt99[0] = b(paramArrayOfByte[11], 0);
    arrayOfInt99[1] = 2131099807;
    arrayOfInt99[2] = 2130837828;
    arrayOfInt98[0] = arrayOfInt99;
    int[] arrayOfInt100 = new int[3];
    arrayOfInt100[0] = b(paramArrayOfByte[11], 1);
    arrayOfInt100[1] = 2131099808;
    arrayOfInt100[2] = 2130837828;
    arrayOfInt98[1] = arrayOfInt100;
    int[] arrayOfInt101 = new int[3];
    arrayOfInt101[0] = b(paramArrayOfByte[11], 2);
    arrayOfInt101[1] = 2131099809;
    arrayOfInt101[2] = 2130837828;
    arrayOfInt98[2] = arrayOfInt101;
    int[] arrayOfInt102 = new int[3];
    arrayOfInt102[0] = b(paramArrayOfByte[11], 3);
    arrayOfInt102[1] = 2131099810;
    arrayOfInt102[2] = 2130837828;
    arrayOfInt98[3] = arrayOfInt102;
    int[] arrayOfInt103 = new int[3];
    arrayOfInt103[0] = b(paramArrayOfByte[11], 4);
    arrayOfInt103[1] = 2131099811;
    arrayOfInt103[2] = 2130837849;
    arrayOfInt98[4] = arrayOfInt103;
    int[] arrayOfInt104 = new int[3];
    arrayOfInt104[0] = b(paramArrayOfByte[11], 5);
    arrayOfInt104[1] = 2131099812;
    arrayOfInt104[2] = 2130837825;
    arrayOfInt98[5] = arrayOfInt104;
    int[] arrayOfInt105 = new int[3];
    arrayOfInt105[0] = b(paramArrayOfByte[11], 6);
    arrayOfInt105[1] = 2131099813;
    arrayOfInt105[2] = 2130837828;
    arrayOfInt98[6] = arrayOfInt105;
    int[] arrayOfInt106 = new int[3];
    arrayOfInt106[0] = b(paramArrayOfByte[11], 7);
    arrayOfInt106[1] = 2131099814;
    arrayOfInt106[2] = 2130837848;
    arrayOfInt98[7] = arrayOfInt106;
    arrayOfInt[11] = arrayOfInt98;
    int[][] arrayOfInt107 = new int[8][];
    int[] arrayOfInt108 = new int[3];
    arrayOfInt108[0] = b(paramArrayOfByte[12], 0);
    arrayOfInt108[1] = 2131099815;
    arrayOfInt108[2] = 2130837828;
    arrayOfInt107[0] = arrayOfInt108;
    int[] arrayOfInt109 = new int[3];
    arrayOfInt109[0] = b(paramArrayOfByte[12], 1);
    arrayOfInt109[1] = 2131099816;
    arrayOfInt109[2] = 2130837828;
    arrayOfInt107[1] = arrayOfInt109;
    int[] arrayOfInt110 = new int[3];
    arrayOfInt110[0] = b(paramArrayOfByte[12], 2);
    arrayOfInt110[1] = 2131099817;
    arrayOfInt110[2] = 2130837828;
    arrayOfInt107[2] = arrayOfInt110;
    int[] arrayOfInt111 = new int[3];
    arrayOfInt111[0] = b(paramArrayOfByte[12], 3);
    arrayOfInt111[1] = 2131099818;
    arrayOfInt111[2] = 2130837828;
    arrayOfInt107[3] = arrayOfInt111;
    int[] arrayOfInt112 = new int[3];
    arrayOfInt112[0] = b(paramArrayOfByte[12], 4);
    arrayOfInt112[1] = 2131099819;
    arrayOfInt112[2] = 2130837828;
    arrayOfInt107[4] = arrayOfInt112;
    int[] arrayOfInt113 = new int[3];
    arrayOfInt113[0] = b(paramArrayOfByte[12], 5);
    arrayOfInt113[1] = 2131099820;
    arrayOfInt113[2] = 2130837828;
    arrayOfInt107[5] = arrayOfInt113;
    int[] arrayOfInt114 = new int[3];
    arrayOfInt114[0] = b(paramArrayOfByte[12], 6);
    arrayOfInt114[1] = 2131099821;
    arrayOfInt114[2] = 2130837828;
    arrayOfInt107[6] = arrayOfInt114;
    int[] arrayOfInt115 = new int[3];
    arrayOfInt115[0] = b(paramArrayOfByte[12], 7);
    arrayOfInt115[1] = 2131099822;
    arrayOfInt115[2] = 2130837828;
    arrayOfInt107[7] = arrayOfInt115;
    arrayOfInt[12] = arrayOfInt107;
    int[][] arrayOfInt116 = new int[8][];
    int[] arrayOfInt117 = new int[3];
    arrayOfInt117[0] = b(paramArrayOfByte[13], 0);
    arrayOfInt117[1] = 2131099823;
    arrayOfInt117[2] = 2130837828;
    arrayOfInt116[0] = arrayOfInt117;
    int[] arrayOfInt118 = new int[3];
    arrayOfInt118[0] = b(paramArrayOfByte[13], 1);
    arrayOfInt118[1] = 2131099824;
    arrayOfInt118[2] = 2130837828;
    arrayOfInt116[1] = arrayOfInt118;
    int[] arrayOfInt119 = new int[3];
    arrayOfInt119[0] = b(paramArrayOfByte[13], 2);
    arrayOfInt119[1] = 2131099825;
    arrayOfInt119[2] = 2130837828;
    arrayOfInt116[2] = arrayOfInt119;
    arrayOfInt116[3] = { 0, 2131099826, 2130837828 };
    arrayOfInt116[4] = { 0, 2131099827, 2130837828 };
    arrayOfInt116[5] = { 0, 2131099828, 2130837828 };
    arrayOfInt116[6] = { 0, 2131099829, 2130837828 };
    arrayOfInt116[7] = { 0, 2131099830, 2130837828 };
    arrayOfInt[13] = arrayOfInt116;
    int[][] arrayOfInt120 = new int[8][];
    int[] arrayOfInt121 = new int[3];
    arrayOfInt121[0] = c(paramArrayOfByte[21], 0);
    arrayOfInt121[1] = 2131099831;
    arrayOfInt121[2] = 2130837828;
    arrayOfInt120[0] = arrayOfInt121;
    int[] arrayOfInt122 = new int[3];
    arrayOfInt122[0] = c(paramArrayOfByte[21], 1);
    arrayOfInt122[1] = 2131099832;
    arrayOfInt122[2] = 2130837828;
    arrayOfInt120[1] = arrayOfInt122;
    int[] arrayOfInt123 = new int[3];
    arrayOfInt123[0] = c(paramArrayOfByte[21], 2);
    arrayOfInt123[1] = 2131099833;
    arrayOfInt123[2] = 2130837828;
    arrayOfInt120[2] = arrayOfInt123;
    int[] arrayOfInt124 = new int[3];
    arrayOfInt124[0] = c(paramArrayOfByte[21], 3);
    arrayOfInt124[1] = 2131099834;
    arrayOfInt124[2] = 2130837828;
    arrayOfInt120[3] = arrayOfInt124;
    int[] arrayOfInt125 = new int[3];
    arrayOfInt125[0] = c(paramArrayOfByte[21], 4);
    arrayOfInt125[1] = 2131099835;
    arrayOfInt125[2] = 2130837828;
    arrayOfInt120[4] = arrayOfInt125;
    int[] arrayOfInt126 = new int[3];
    arrayOfInt126[0] = c(paramArrayOfByte[21], 5);
    arrayOfInt126[1] = 2131099836;
    arrayOfInt126[2] = 2130837828;
    arrayOfInt120[5] = arrayOfInt126;
    int[] arrayOfInt127 = new int[3];
    arrayOfInt127[0] = c(paramArrayOfByte[21], 6);
    arrayOfInt127[1] = 2131099837;
    arrayOfInt127[2] = 2130837828;
    arrayOfInt120[6] = arrayOfInt127;
    int[] arrayOfInt128 = new int[3];
    arrayOfInt128[0] = c(paramArrayOfByte[21], 7);
    arrayOfInt128[1] = 2131099838;
    arrayOfInt128[2] = 2130837828;
    arrayOfInt120[7] = arrayOfInt128;
    arrayOfInt[14] = arrayOfInt120;
    int[][] arrayOfInt129 = new int[8][];
    int[] arrayOfInt130 = new int[3];
    arrayOfInt130[0] = c(paramArrayOfByte[22], 0);
    arrayOfInt130[1] = 2131099839;
    arrayOfInt130[2] = 2130837828;
    arrayOfInt129[0] = arrayOfInt130;
    int[] arrayOfInt131 = new int[3];
    arrayOfInt131[0] = c(paramArrayOfByte[22], 1);
    arrayOfInt131[1] = 2131099840;
    arrayOfInt131[2] = 2130837828;
    arrayOfInt129[1] = arrayOfInt131;
    int[] arrayOfInt132 = new int[3];
    arrayOfInt132[0] = c(paramArrayOfByte[22], 2);
    arrayOfInt132[1] = 2131099841;
    arrayOfInt132[2] = 2130837828;
    arrayOfInt129[2] = arrayOfInt132;
    int[] arrayOfInt133 = new int[3];
    arrayOfInt133[0] = c(paramArrayOfByte[22], 3);
    arrayOfInt133[1] = 2131099842;
    arrayOfInt133[2] = 2130837828;
    arrayOfInt129[3] = arrayOfInt133;
    int[] arrayOfInt134 = new int[3];
    arrayOfInt134[0] = d(paramArrayOfByte[22], 1);
    arrayOfInt134[1] = 2131099843;
    arrayOfInt134[2] = 2130837828;
    arrayOfInt129[4] = arrayOfInt134;
    int[] arrayOfInt135 = new int[3];
    arrayOfInt135[0] = d(paramArrayOfByte[22], 2);
    arrayOfInt135[1] = 2131099844;
    arrayOfInt135[2] = 2130837828;
    arrayOfInt129[5] = arrayOfInt135;
    int[] arrayOfInt136 = new int[3];
    arrayOfInt136[0] = d(paramArrayOfByte[22], 3);
    arrayOfInt136[1] = 2131099845;
    arrayOfInt136[2] = 2130837828;
    arrayOfInt129[6] = arrayOfInt136;
    int[] arrayOfInt137 = new int[3];
    arrayOfInt137[0] = d(paramArrayOfByte[22], 4);
    arrayOfInt137[1] = 2131099846;
    arrayOfInt137[2] = 2130837828;
    arrayOfInt129[7] = arrayOfInt137;
    arrayOfInt[15] = arrayOfInt129;
    int[][] arrayOfInt138 = new int[8][];
    int[] arrayOfInt139 = new int[3];
    arrayOfInt139[0] = c(paramArrayOfByte[23], 0);
    arrayOfInt139[1] = 2131099847;
    arrayOfInt139[2] = 2130837845;
    arrayOfInt138[0] = arrayOfInt139;
    int[] arrayOfInt140 = new int[3];
    arrayOfInt140[0] = c(paramArrayOfByte[23], 1);
    arrayOfInt140[1] = 2131099848;
    arrayOfInt140[2] = 2130837845;
    arrayOfInt138[1] = arrayOfInt140;
    int[] arrayOfInt141 = new int[3];
    arrayOfInt141[0] = c(paramArrayOfByte[23], 2);
    arrayOfInt141[1] = 2131099849;
    arrayOfInt141[2] = 2130837828;
    arrayOfInt138[2] = arrayOfInt141;
    int[] arrayOfInt142 = new int[3];
    arrayOfInt142[0] = c(paramArrayOfByte[23], 3);
    arrayOfInt142[1] = 2131099850;
    arrayOfInt142[2] = 2130837828;
    arrayOfInt138[3] = arrayOfInt142;
    arrayOfInt138[4] = { 0 };
    arrayOfInt138[5] = { 0 };
    arrayOfInt138[6] = { 0 };
    arrayOfInt138[7] = { 0 };
    arrayOfInt[16] = arrayOfInt138;
    return arrayOfInt;
  }

  private int v(int paramInt)
  {
    int i = 0;
    if (BaseApplication.k().m() == 3)
      if (paramInt != 0);
    while (true)
    {
      return i;
      if (paramInt == 255)
      {
        i = 65535;
      }
      else if ((!this.d.tempUnit) && (paramInt >= 32) && (paramInt <= 60))
      {
        i = -20 + paramInt * 10 / 2;
      }
      else if ((this.d.tempUnit) && (paramInt <= 99))
      {
        i = paramInt * 10;
      }
      else
      {
        i = -1;
        continue;
        if (paramInt == 0)
          i = 0;
        else if (paramInt == 255)
          i = 65535;
        else if ((!this.d.tempUnit) && (paramInt >= 1) && (paramInt <= 254))
          i = paramInt * 10 / 2;
        else if ((this.d.tempUnit) && (paramInt <= 99))
          i = paramInt * 10;
        else
          i = -1;
      }
    }
  }

  public void a(byte paramByte1, int paramInt, byte paramByte2)
  {
    byte[] arrayOfByte1 = new byte[8];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = 1;
    this.cv.a((byte)-64, arrayOfByte1, 8);
    byte[] arrayOfByte2 = new byte[4];
    if ((paramByte1 >= 0) && (paramByte1 <= 2))
    {
      arrayOfByte2[0] = 1;
      arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
      arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
      arrayOfByte2[3] = ((byte)(paramByte2 + 1));
    }
    while (true)
    {
      this.cv.a((byte)-62, arrayOfByte2, 4);
      return;
      if ((paramByte1 == 3) || (paramByte1 == 4))
      {
        arrayOfByte2[0] = 16;
        arrayOfByte2[1] = ((byte)(paramInt & 0xFF));
        arrayOfByte2[2] = ((byte)(0xFF & paramInt >> 8));
        arrayOfByte2[3] = ((byte)(paramByte2 + 1));
      }
    }
  }

  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 5;
    arrayOfByte[1] = 64;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public int[][] aA()
  {
    int[][] arrayOfInt = new int[13][];
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = 3841;
    arrayOfInt1[1] = 46;
    arrayOfInt1[2] = 35330;
    arrayOfInt1[3] = 3;
    int i;
    int j;
    label95: int k;
    label150: int m;
    label397: int n;
    label453: int i1;
    label509: int[] arrayOfInt7;
    int i2;
    if (this.d.acMax == 1)
    {
      i = 0;
      arrayOfInt1[4] = i;
      arrayOfInt[0] = arrayOfInt1;
      int[] arrayOfInt2 = new int[5];
      arrayOfInt2[0] = 3842;
      arrayOfInt2[1] = 46;
      arrayOfInt2[2] = 35330;
      arrayOfInt2[3] = 2;
      if (!this.d.modeAc)
        break label588;
      j = 0;
      arrayOfInt2[4] = j;
      arrayOfInt[1] = arrayOfInt2;
      int[] arrayOfInt3 = new int[5];
      arrayOfInt3[0] = 3846;
      arrayOfInt3[1] = 46;
      arrayOfInt3[2] = 35330;
      arrayOfInt3[3] = 1;
      if (this.d.modeAuto != 1)
        break label594;
      k = 0;
      arrayOfInt3[4] = k;
      arrayOfInt[2] = arrayOfInt3;
      arrayOfInt[3] = { 3847, 46, 35330, 4, 1 };
      arrayOfInt[4] = { 3848, 46, 35330, 4, 2 };
      arrayOfInt[5] = { 3849, 46, 35330, 5, 1 };
      arrayOfInt[6] = { 3850, 46, 35330, 5, 2 };
      arrayOfInt[7] = { 3855, 46, 35330, 10, 2 };
      arrayOfInt[8] = { 3856, 46, 35330, 10, 1 };
      int[] arrayOfInt4 = new int[5];
      arrayOfInt4[0] = 3857;
      arrayOfInt4[1] = 46;
      arrayOfInt4[2] = 35330;
      arrayOfInt4[3] = 11;
      if (this.d.modeDual != 1)
        break label600;
      m = 0;
      arrayOfInt4[4] = m;
      arrayOfInt[9] = arrayOfInt4;
      int[] arrayOfInt5 = new int[5];
      arrayOfInt5[0] = 3858;
      arrayOfInt5[1] = 46;
      arrayOfInt5[2] = 35330;
      arrayOfInt5[3] = 8;
      if (!this.d.windDown)
        break label606;
      n = 0;
      arrayOfInt5[4] = n;
      arrayOfInt[10] = arrayOfInt5;
      int[] arrayOfInt6 = new int[5];
      arrayOfInt6[0] = 3859;
      arrayOfInt6[1] = 46;
      arrayOfInt6[2] = 35330;
      arrayOfInt6[3] = 7;
      if (!this.d.windUp)
        break label612;
      i1 = 0;
      arrayOfInt6[4] = i1;
      arrayOfInt[11] = arrayOfInt6;
      arrayOfInt7 = new int[5];
      arrayOfInt7[0] = 3860;
      arrayOfInt7[1] = 46;
      arrayOfInt7[2] = 35330;
      arrayOfInt7[3] = 6;
      boolean bool = this.d.windMid;
      i2 = 0;
      if (!bool)
        break label618;
    }
    while (true)
    {
      arrayOfInt7[4] = i2;
      arrayOfInt[12] = arrayOfInt7;
      return arrayOfInt;
      i = 1;
      break;
      label588: j = 1;
      break label95;
      label594: k = 1;
      break label150;
      label600: m = 1;
      break label397;
      label606: n = 1;
      break label453;
      label612: i1 = 1;
      break label509;
      label618: i2 = 1;
    }
  }

  public void ah()
  {
    this.cv.d(1);
    this.cv.e(1);
    int i;
    if (av() == 7)
      i = 1;
    while (true)
    {
      this.cv.a((byte)-54, new byte[] { i }, 1);
      ai();
      return;
      if (av() == 10)
        i = 2;
      else
        i = 0;
    }
  }

  public void ai()
  {
    String str = this.cv.getResources().getConfiguration().locale.getLanguage();
    if (str.equals("zh"))
      c((byte)1);
    while (true)
    {
      return;
      if (str.equals("en"))
        c((byte)0);
      else if (str.equals("de"))
        c((byte)4);
      else if (str.equals("it"))
        c((byte)6);
      else if (!str.equals("sv"))
        if (str.equals("es"))
          c((byte)5);
        else if (str.equals("nl"))
          c((byte)7);
        else if (str.equals("pt"))
          c((byte)16);
        else if (!str.equals("nb"))
          if (str.equals("fi"))
            c((byte)13);
          else if (!str.equals("da"))
            if (str.equals("pl"))
              c((byte)8);
            else if (str.equals("tr"))
              c((byte)9);
            else if (!str.equals("ar"))
              if (str.equals("ru"))
                c((byte)2);
              else if ((!str.equals("uk")) && (!str.equals("sk")) && (!str.equals("cs")) && (!str.equals("hu")) && (!str.equals("el")) && (!str.equals("ko")) && (str.equals("fr")))
                c((byte)3);
    }
  }

  public void aj()
  {
  }

  public void ak()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 7;
    arrayOfByte[1] = 48;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void al()
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 12;
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void am()
  {
    al();
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
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void az()
  {
    this.cv.a((byte)-112, new byte[] { 33, 0, 0, 0 }, 4);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    ap();
  }

  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[0] = 8;
    arrayOfByte[1] = 19;
    arrayOfByte[2] = ((byte)(paramInt2 & 0xFF));
    arrayOfByte[3] = ((byte)(0xFF & paramInt2 >> 8));
    arrayOfByte[4] = ((byte)(paramInt1 & 0xFF));
    arrayOfByte[5] = ((byte)(0xFF & paramInt1 >> 8));
    arrayOfByte[6] = ((byte)(0xFF & E(paramInt3)));
    arrayOfByte[7] = ((byte)(paramInt3 / 1000 % 60));
    this.cv.a((byte)-64, arrayOfByte, 8);
  }

  public void d(int paramInt1, int paramInt2, int paramInt3)
  {
    c(paramInt1, paramInt2, paramInt3);
  }

  public void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramArrayOfByte[(paramInt1 + 1)])
    {
    default:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 57:
    case 56:
    case 58:
    case 59:
    case 60:
    case 61:
    case 74:
    case 33:
    case 62:
    case 41:
    case -22:
    case 68:
    case 32:
    }
    while (true)
    {
      return;
      if (paramArrayOfByte[(paramInt1 + 2)] >= 7)
      {
        int[] arrayOfInt = new int[7];
        int i6 = 1;
        if (i6 < 7)
        {
          arrayOfInt[i6] = (0xFF & paramArrayOfByte[(i6 + (paramInt1 + 3))]);
          if (arrayOfInt[i6] >= 5)
            arrayOfInt[i6] = 0;
          while (true)
          {
            i6++;
            break;
            arrayOfInt[i6] = (5 - arrayOfInt[i6]);
          }
        }
        ax();
        this.aY.max = 5;
        this.aY.back_cnt = 3;
        this.aY.b1 = arrayOfInt[1];
        this.aY.b2 = arrayOfInt[2];
        this.aY.b3 = arrayOfInt[3];
        this.aY.front_cnt = 3;
        this.aY.f1 = arrayOfInt[4];
        this.aY.f2 = arrayOfInt[5];
        this.aY.f3 = arrayOfInt[6];
        if (paramArrayOfByte[(paramInt1 + 3)] == 2)
        {
          this.cv.a(this.aY);
          continue;
          if (paramArrayOfByte[(paramInt1 + 2)] >= 9)
          {
            byte[] arrayOfByte11 = new byte[11];
            arrayOfByte11[0] = 51;
            arrayOfByte11[1] = 9;
            while (i < 9)
            {
              arrayOfByte11[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
              i++;
            }
            this.cv.d(arrayOfByte11);
            continue;
            if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
            {
              byte[] arrayOfByte10 = new byte[8];
              arrayOfByte10[0] = 52;
              arrayOfByte10[1] = 6;
              while (i < 6)
              {
                arrayOfByte10[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                i++;
              }
              this.cv.d(arrayOfByte10);
              continue;
              if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
              {
                byte[] arrayOfByte9 = new byte[8];
                arrayOfByte9[0] = 53;
                arrayOfByte9[1] = 6;
                while (i < 6)
                {
                  arrayOfByte9[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                  i++;
                }
                this.cv.d(arrayOfByte9);
                continue;
                if (paramArrayOfByte[(paramInt1 + 2)] >= 1)
                {
                  int i5 = 0xFF & paramArrayOfByte[(paramInt1 + 3)];
                  if ((i5 & 0x80) != 0)
                    i5 = 0 - (i5 & 0x7F);
                  StringBuilder localStringBuilder1;
                  Locale localLocale1;
                  Object[] arrayOfObject1;
                  if (this.d.tempUnit)
                  {
                    localStringBuilder1 = new StringBuilder();
                    localLocale1 = Locale.US;
                    arrayOfObject1 = new Object[1];
                    arrayOfObject1[0] = Integer.valueOf((int)(32.0D + 1.8D * i5));
                  }
                  StringBuilder localStringBuilder2;
                  Locale localLocale2;
                  Object[] arrayOfObject2;
                  for (String str = String.format(localLocale1, " %d", arrayOfObject1) + this.mContext.getString(2131099652); ; str = String.format(localLocale2, " %d", arrayOfObject2) + this.mContext.getString(2131099651))
                  {
                    Intent localIntent2 = new Intent("com.canbus.temperature");
                    localIntent2.putExtra("temperature", str);
                    this.mContext.sendBroadcast(localIntent2);
                    break;
                    localStringBuilder2 = new StringBuilder();
                    localLocale2 = Locale.US;
                    arrayOfObject2 = new Object[1];
                    arrayOfObject2[0] = Integer.valueOf(i5);
                  }
                  if ((paramArrayOfByte[(paramInt1 + 2)] >= 21) && (Settings.System.getInt(this.cv.getContentResolver(), "mOff_Warning_infor", 1) == 1))
                  {
                    for (int i3 = 0; i3 < 21; i3++)
                      this.dF[i3] = paramArrayOfByte[(i3 + (paramInt1 + 3))];
                    this.bn.b(t(this.dF));
                    this.bn.r(t(this.dF).length);
                    ay();
                    for (int i4 = 0; i4 < 21; i4++)
                      this.dF[i4] = 0;
                    continue;
                    if (paramArrayOfByte[(paramInt1 + 2)] >= 8)
                    {
                      for (int i1 = 0; i1 < 8; i1++)
                        this.dF[(i1 + 21)] = paramArrayOfByte[(i1 + (paramInt1 + 3))];
                      this.bn.b(t(this.dF));
                      this.bn.r(t(this.dF).length);
                      ay();
                      for (int i2 = 0; i2 < 8; i2++)
                        this.dF[(i2 + 21)] = 0;
                      continue;
                      if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                      {
                        byte[] arrayOfByte7 = new byte[1];
                        arrayOfByte7[0] = paramArrayOfByte[(paramInt1 + 3)];
                        n(arrayOfByte7);
                        byte[] arrayOfByte8 = new byte[8];
                        arrayOfByte8[0] = 56;
                        arrayOfByte8[1] = 6;
                        while (i < 6)
                        {
                          arrayOfByte8[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                          i++;
                        }
                        this.cv.d(arrayOfByte8);
                        continue;
                        int n = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
                        if (n >= 2)
                        {
                          byte[] arrayOfByte6 = new byte[n + 2];
                          arrayOfByte6[0] = 58;
                          arrayOfByte6[1] = ((byte)n);
                          while (i < n)
                          {
                            arrayOfByte6[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                            i++;
                          }
                          this.cv.d(arrayOfByte6);
                          continue;
                          if (paramArrayOfByte[(paramInt1 + 2)] >= 6)
                          {
                            byte[] arrayOfByte5 = new byte[8];
                            arrayOfByte5[0] = 59;
                            arrayOfByte5[1] = 6;
                            while (i < 6)
                            {
                              arrayOfByte5[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                              i++;
                            }
                            this.cv.d(arrayOfByte5);
                            continue;
                            if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
                            {
                              byte[] arrayOfByte4 = new byte[4];
                              arrayOfByte4[0] = 60;
                              arrayOfByte4[1] = 2;
                              while (i < 2)
                              {
                                arrayOfByte4[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                i++;
                              }
                              this.cv.d(arrayOfByte4);
                              continue;
                              if (paramArrayOfByte[(paramInt1 + 2)] >= 12)
                              {
                                byte[] arrayOfByte3 = new byte[14];
                                arrayOfByte3[0] = 59;
                                arrayOfByte3[1] = 12;
                                while (i < 12)
                                {
                                  arrayOfByte3[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                  i++;
                                }
                                this.cv.d(arrayOfByte3);
                                continue;
                                if (paramArrayOfByte[(paramInt1 + 2)] >= 21)
                                {
                                  byte[] arrayOfByte2 = new byte[23];
                                  arrayOfByte2[0] = 74;
                                  arrayOfByte2[1] = 21;
                                  while (i < 21)
                                  {
                                    arrayOfByte2[(i + 2)] = paramArrayOfByte[(i + (paramInt1 + 3))];
                                    i++;
                                  }
                                  this.cv.d(arrayOfByte2);
                                  continue;
                                  if (paramArrayOfByte[(paramInt1 + 2)] >= 9)
                                  {
                                    byte[] arrayOfByte1 = new byte[9];
                                    for (int m = 0; m < 9; m++)
                                      arrayOfByte1[m] = paramArrayOfByte[(m + (paramInt1 + 3))];
                                    m(arrayOfByte1);
                                    this.cv.a(this.d);
                                    e(paramArrayOfByte, paramInt1, paramInt2);
                                    continue;
                                    if ((paramArrayOfByte[(paramInt1 + 2)] >= 1) && (goto 172) && (paramArrayOfByte[(paramInt1 + 2)] >= 2))
                                    {
                                      int j = (0xFF & paramArrayOfByte[(paramInt1 + 3)]) + ((0xFF & paramArrayOfByte[(paramInt1 + 4)]) << 8);
                                      if (j >= 32768)
                                        j += 0;
                                      int k = j * 30 / 5450;
                                      Intent localIntent1 = new Intent("com.microntek.canbusbackview");
                                      localIntent1.putExtra("canbustype", this.e);
                                      localIntent1.putExtra("lfribackview", 0 - k);
                                      this.mContext.sendBroadcast(localIntent1);
                                      continue;
                                      if ((paramArrayOfByte[(paramInt1 + 2)] >= 2) && (goto 172) && (paramArrayOfByte[(paramInt1 + 2)] >= 1) && (goto 172) && (paramArrayOfByte[(paramInt1 + 2)] >= 2) && (paramArrayOfByte[(paramInt1 + 3)] == 32) && (paramArrayOfByte[(paramInt1 + 4)] == 1))
                                      {
                                        if (this.dE == 54)
                                          this.dE = 51;
                                        B(this.dE);
                                        this.dE = (1 + this.dE);
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

  public void l(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)paramInt);
    if (paramInt == 0)
      arrayOfByte[0] = ((byte)(0x80 | arrayOfByte[0]));
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
    if ((0x80 & paramArrayOfByte[0]) != 0)
    {
      bool2 = bool1;
      if ((0x40 & paramArrayOfByte[0]) == 0)
        break label112;
      bool3 = bool1;
      if ((0x20 & paramArrayOfByte[0]) == 0)
        break label118;
      bool4 = bool1;
      if ((0x10 & paramArrayOfByte[0]) == 0)
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
 * Qualified Name:     android.microntek.canbus.c.bt
 * JD-Core Version:    0.6.2
 */