package android.microntek.canbus;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.microntek.canbus.serializable.AirCondition;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint({"NewApi"})
public class AirServer extends Service
{
  public static int e = 1;
  private View a;
  private WindowManager.LayoutParams b;
  private AirCondition d;
  private boolean g = false;
  private boolean h = false;
  private Handler handler = new a(this);
  private WindowManager mWindowManager;

  private void a(int paramInt)
  {
    int j;
    ImageView localImageView6;
    label52: View localView2;
    ImageView localImageView7;
    if (paramInt == 1)
      if (this.g)
      {
        j = this.d.tempRight;
        localImageView6 = (ImageView)this.a.findViewById(2131230758);
        if (!this.d.tempUnit)
          break label122;
        localImageView6.setImageResource(2130837608);
        localView2 = this.a.findViewById(2131230753);
        localImageView7 = (ImageView)this.a.findViewById(2131230761);
        if (j != 65535)
          break label132;
        localView2.setVisibility(8);
        localImageView7.setImageResource(2130837614);
        localImageView7.setVisibility(0);
      }
    while (true)
    {
      return;
      j = this.d.tempLeft;
      break;
      label122: localImageView6.setImageResource(2130837560);
      break label52;
      label132: if (j == 0)
      {
        localView2.setVisibility(8);
        localImageView7.setImageResource(2130837731);
        localImageView7.setVisibility(0);
      }
      else if ((j == -1) || (j >= 1000))
      {
        localView2.setVisibility(8);
        localImageView7.setVisibility(8);
      }
      else
      {
        localImageView7.setVisibility(8);
        ImageView localImageView8 = (ImageView)this.a.findViewById(2131230755);
        ImageView localImageView9 = (ImageView)this.a.findViewById(2131230756);
        ImageView localImageView10 = (ImageView)this.a.findViewById(2131230760);
        localImageView8.setImageResource(2130837582 + j / 100);
        localImageView9.setImageResource(2130837582 + j % 100 / 10);
        localImageView10.setImageResource(2130837592 + j % 10);
        localView2.setVisibility(0);
        continue;
        int i;
        label316: ImageView localImageView1;
        View localView1;
        ImageView localImageView2;
        if (this.g)
        {
          i = this.d.tempLeft;
          localImageView1 = (ImageView)this.a.findViewById(2131230788);
          localView1 = this.a.findViewById(2131230783);
          localImageView2 = (ImageView)this.a.findViewById(2131230791);
          if (!this.d.tempUnit)
            break label415;
          localImageView1.setImageResource(2130837608);
        }
        while (true)
        {
          if (i != 65535)
            break label424;
          localView1.setVisibility(8);
          localImageView2.setImageResource(2130837614);
          localImageView2.setVisibility(0);
          break;
          i = this.d.tempRight;
          break label316;
          label415: localImageView1.setImageResource(2130837560);
        }
        label424: if (i == 0)
        {
          localView1.setVisibility(8);
          localImageView2.setImageResource(2130837731);
          localImageView2.setVisibility(0);
        }
        else if ((i == -1) || (i >= 1000))
        {
          localView1.setVisibility(8);
          localImageView2.setVisibility(8);
        }
        else
        {
          localImageView2.setVisibility(8);
          ImageView localImageView3 = (ImageView)this.a.findViewById(2131230785);
          ImageView localImageView4 = (ImageView)this.a.findViewById(2131230786);
          ImageView localImageView5 = (ImageView)this.a.findViewById(2131230790);
          localImageView3.setImageResource(2130837582 + i / 100);
          localImageView4.setImageResource(2130837582 + i % 100 / 10);
          localImageView5.setImageResource(2130837592 + i % 10);
          localView1.setVisibility(0);
        }
      }
    }
  }

  private boolean a()
  {
    int i = Settings.System.getInt(getContentResolver(), "com.microntek.hiworld.ari", 0);
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2002;
    this.b.format = 1;
    this.b.flags = 56;
    this.b.gravity = 83;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -1;
    this.b.height = -2;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903042, null);
    this.mWindowManager.addView(this.a, this.b);
  }

  private void b(int paramInt)
  {
    int j;
    ImageView localImageView6;
    label52: View localView2;
    ImageView localImageView7;
    if (paramInt == 1)
      if (this.g)
      {
        j = this.d.b_tempRight;
        localImageView6 = (ImageView)this.a.findViewById(2131230799);
        if (!this.d.b_tempUnit)
          break label122;
        localImageView6.setImageResource(2130837608);
        localView2 = this.a.findViewById(2131230794);
        localImageView7 = (ImageView)this.a.findViewById(2131230802);
        if (j != 65535)
          break label132;
        localView2.setVisibility(8);
        localImageView7.setImageResource(2130837614);
        localImageView7.setVisibility(0);
      }
    while (true)
    {
      return;
      j = this.d.b_tempLeft;
      break;
      label122: localImageView6.setImageResource(2130837560);
      break label52;
      label132: if (j == 0)
      {
        localView2.setVisibility(8);
        localImageView7.setImageResource(2130837731);
        localImageView7.setVisibility(0);
      }
      else if ((j == -1) || (j >= 1000))
      {
        localView2.setVisibility(8);
        localImageView7.setVisibility(8);
      }
      else
      {
        localImageView7.setVisibility(8);
        ImageView localImageView8 = (ImageView)this.a.findViewById(2131230796);
        ImageView localImageView9 = (ImageView)this.a.findViewById(2131230797);
        ImageView localImageView10 = (ImageView)this.a.findViewById(2131230801);
        localImageView8.setImageResource(2130837582 + j / 100);
        localImageView9.setImageResource(2130837582 + j % 100 / 10);
        localImageView10.setImageResource(2130837592 + j % 10);
        localView2.setVisibility(0);
        continue;
        int i;
        label316: ImageView localImageView1;
        View localView1;
        ImageView localImageView2;
        if (this.g)
        {
          i = this.d.b_tempLeft;
          localImageView1 = (ImageView)this.a.findViewById(2131230829);
          localView1 = this.a.findViewById(2131230824);
          localImageView2 = (ImageView)this.a.findViewById(2131230832);
          if (!this.d.b_tempUnit)
            break label415;
          localImageView1.setImageResource(2130837608);
        }
        while (true)
        {
          if (i != 65535)
            break label424;
          localView1.setVisibility(8);
          localImageView2.setImageResource(2130837614);
          localImageView2.setVisibility(0);
          break;
          i = this.d.b_tempRight;
          break label316;
          label415: localImageView1.setImageResource(2130837560);
        }
        label424: if (i == 0)
        {
          localView1.setVisibility(8);
          localImageView2.setImageResource(2130837731);
          localImageView2.setVisibility(0);
        }
        else if ((i == -1) || (i >= 1000))
        {
          localView1.setVisibility(8);
          localImageView2.setVisibility(8);
        }
        else
        {
          localImageView2.setVisibility(8);
          ImageView localImageView3 = (ImageView)this.a.findViewById(2131230826);
          ImageView localImageView4 = (ImageView)this.a.findViewById(2131230827);
          ImageView localImageView5 = (ImageView)this.a.findViewById(2131230831);
          localImageView3.setImageResource(2130837582 + i / 100);
          localImageView4.setImageResource(2130837582 + i % 100 / 10);
          localImageView5.setImageResource(2130837592 + i % 10);
          localView1.setVisibility(0);
        }
      }
    }
  }

  private void c()
  {
    if (this.a == null)
      return;
    FrameLayout localFrameLayout1 = (FrameLayout)this.a.findViewById(2131230762);
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131230765);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131230766);
    ImageView localImageView3 = (ImageView)this.a.findViewById(2131230777);
    ImageView localImageView4 = (ImageView)this.a.findViewById(2131230767);
    ImageView localImageView5 = (ImageView)this.a.findViewById(2131230768);
    label164: ImageView localImageView6;
    ImageView localImageView7;
    ImageView localImageView8;
    ImageView localImageView9;
    FrameLayout localFrameLayout2;
    label266: label303: ImageView localImageView10;
    ImageView localImageView11;
    label365: ImageView localImageView12;
    FrameLayout localFrameLayout3;
    if (!this.d.seatShow)
    {
      localFrameLayout1.setVisibility(8);
      int k = this.d.windLoop;
      if (k != -1)
        break label715;
      localImageView3.setVisibility(4);
      int i1 = this.d.modeAuto;
      if (i1 != 2)
        break label794;
      localImageView4.setImageResource(2130837539);
      localImageView5.setVisibility(0);
      localImageView4.setVisibility(0);
      a(1);
      a(2);
      localImageView6 = (ImageView)this.a.findViewById(2131230775);
      localImageView7 = (ImageView)this.a.findViewById(2131230772);
      localImageView8 = (ImageView)this.a.findViewById(2131230773);
      localImageView9 = (ImageView)this.a.findViewById(2131230774);
      localFrameLayout2 = (FrameLayout)this.a.findViewById(2131230770);
      if (!this.d.ariStateShow)
        break label848;
      localFrameLayout2.setVisibility(0);
      if (!this.d.windFrontMax)
        break label858;
      localImageView7.setVisibility(8);
      localImageView8.setVisibility(8);
      localImageView9.setVisibility(8);
      localImageView6.setVisibility(0);
      localImageView10 = (ImageView)this.a.findViewById(2131230771);
      if (this.d.windRearShow)
        break label973;
      localImageView10.setVisibility(8);
      localImageView11 = (ImageView)this.a.findViewById(2131230780);
      if (!this.d.modeAc)
        break label1011;
      localImageView11.setImageResource(2130837505);
      localImageView12 = (ImageView)this.a.findViewById(2131230778);
      int i3 = this.d.modeDual;
      if (i3 != -1)
        break label1022;
      localImageView12.setVisibility(4);
      localFrameLayout3 = (FrameLayout)this.a.findViewById(2131230776);
      if (this.d.wind_FrameShow)
        break label1114;
      localFrameLayout3.setVisibility(8);
    }
    ImageView localImageView13;
    ImageView localImageView14;
    ImageView localImageView15;
    while (true)
    {
      localImageView13 = (ImageView)this.a.findViewById(2131230779);
      int i5 = this.d.rearLock;
      if (i5 != -1)
        break label1123;
      localImageView13.setVisibility(4);
      localImageView14 = (ImageView)this.a.findViewById(2131230781);
      int i7 = this.d.acMax;
      if (i7 != -1)
        break label1215;
      localImageView14.setVisibility(4);
      localImageView15 = (ImageView)this.a.findViewById(2131230769);
      if ((this.d.windLevel >= 0) && (this.d.windLevel <= this.d.windLevelMax))
        break label1254;
      localImageView15.setVisibility(4);
      this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      break;
      int i;
      label599: label625: int j;
      if (this.g)
      {
        i = this.d.seatHotRight;
        if ((i < 0) || (i > 3))
          break label687;
        localImageView1.setImageResource(i + 2130837721);
        localImageView1.setVisibility(0);
        if (!this.g)
          break label695;
        j = this.d.seatHotLeft;
        label641: if ((j < 0) || (j > 3))
          break label707;
        localImageView2.setImageResource(j + 2130837805);
        localImageView2.setVisibility(0);
      }
      while (true)
      {
        localFrameLayout1.setVisibility(0);
        break;
        i = this.d.seatHotLeft;
        break label599;
        label687: localImageView1.setVisibility(4);
        break label625;
        label695: j = this.d.seatHotRight;
        break label641;
        label707: localImageView2.setVisibility(4);
      }
      label715: int m = this.d.windLoop;
      if (m == 1)
        localImageView3.setImageResource(2130837867);
      while (true)
      {
        localImageView3.setVisibility(0);
        break;
        int n = this.d.windLoop;
        if (n == 2)
          localImageView3.setImageResource(2130837856);
        else
          localImageView3.setImageResource(2130837869);
      }
      label794: int i2 = this.d.modeAuto;
      if (i2 == 1)
      {
        localImageView4.setImageResource(2130837817);
        localImageView5.setVisibility(0);
        break label164;
      }
      localImageView4.setImageResource(2130837776);
      localImageView5.setVisibility(4);
      break label164;
      label848: localFrameLayout2.setVisibility(8);
      break label266;
      label858: localImageView6.setVisibility(8);
      localImageView7.setVisibility(0);
      localImageView8.setVisibility(0);
      localImageView9.setVisibility(0);
      if (this.d.windUp)
      {
        localImageView7.setImageResource(2130837871);
        label901: if (!this.d.windMid)
          break label951;
        localImageView8.setImageResource(2130837860);
      }
      while (true)
      {
        if (!this.d.windDown)
          break label962;
        localImageView9.setImageResource(2130837864);
        break;
        localImageView7.setImageResource(2130837870);
        break label901;
        label951: localImageView8.setImageResource(2130837858);
      }
      label962: localImageView9.setImageResource(2130837862);
      break label303;
      label973: if (this.d.windRear)
        localImageView10.setImageResource(2130837509);
      while (true)
      {
        localImageView10.setVisibility(0);
        break;
        localImageView10.setImageResource(2130837508);
      }
      label1011: localImageView11.setImageResource(2130837504);
      break label365;
      label1022: int i4 = this.d.DIS_IMG;
      if (i4 == 1)
        if (this.d.modeDual == 1)
          localImageView12.setImageResource(2130837714);
      while (true)
      {
        localImageView12.setVisibility(0);
        break;
        localImageView12.setImageResource(2130837713);
        continue;
        if (this.d.modeDual == 1)
          localImageView12.setImageResource(2130837607);
        else
          localImageView12.setImageResource(2130837606);
      }
      label1114: localFrameLayout3.setVisibility(0);
    }
    label1123: int i6 = this.d.DIS_IMG1;
    if (i6 == 1)
      if (this.d.rearLock == 1)
        localImageView13.setImageResource(2130837718);
    while (true)
    {
      localImageView13.setVisibility(0);
      break;
      localImageView13.setImageResource(2130837719);
      continue;
      if (this.d.rearLock == 1)
        localImageView13.setImageResource(2130837788);
      else
        localImageView13.setImageResource(2130837787);
    }
    label1215: if (this.d.acMax == 1)
      localImageView14.setImageResource(2130837507);
    while (true)
    {
      localImageView14.setVisibility(0);
      break;
      localImageView14.setImageResource(2130837506);
    }
    label1254: if (this.d.windLevelMax == 7)
      localImageView15.setImageResource(2130837652 + this.d.windLevel);
    while (true)
    {
      localImageView15.setVisibility(0);
      break;
      if (this.d.windLevelMax == 4)
        localImageView15.setImageResource(2130837631 + this.d.windLevel);
      else if (this.d.windLevelMax == 6)
        localImageView15.setImageResource(2130837636 + this.d.windLevel);
      else if (this.d.windLevelMax == 15)
      {
        if (this.d.windLevel <= 9)
          localImageView15.setImageResource(2130837621 + this.d.windLevel);
        else
          localImageView15.setImageResource(-10 + (2130837615 + this.d.windLevel));
      }
      else if (this.d.windLevelMax == 8)
        localImageView15.setImageResource(2130837643 + this.d.windLevel);
    }
  }

  private void d()
  {
    if (this.a == null);
    LinearLayout localLinearLayout;
    while (true)
    {
      return;
      localLinearLayout = (LinearLayout)this.a.findViewById(2131230792);
      if (this.d.b_onOff)
        break;
      localLinearLayout.setVisibility(8);
    }
    localLinearLayout.setVisibility(0);
    FrameLayout localFrameLayout1 = (FrameLayout)this.a.findViewById(2131230793);
    FrameLayout localFrameLayout2 = (FrameLayout)this.a.findViewById(2131230823);
    label89: label104: FrameLayout localFrameLayout3;
    ImageView localImageView1;
    ImageView localImageView2;
    ImageView localImageView3;
    ImageView localImageView4;
    ImageView localImageView5;
    label270: ImageView localImageView6;
    ImageView localImageView7;
    ImageView localImageView8;
    ImageView localImageView9;
    FrameLayout localFrameLayout4;
    label377: ImageView localImageView10;
    label414: ImageView localImageView11;
    label478: ImageView localImageView12;
    FrameLayout localFrameLayout5;
    if (this.d.b_leftShow)
    {
      localFrameLayout1.setVisibility(0);
      if (!this.d.b_rightShow)
        break label710;
      localFrameLayout2.setVisibility(0);
      localFrameLayout3 = (FrameLayout)this.a.findViewById(2131230803);
      localImageView1 = (ImageView)this.a.findViewById(2131230806);
      localImageView2 = (ImageView)this.a.findViewById(2131230807);
      localImageView3 = (ImageView)this.a.findViewById(2131230818);
      localImageView4 = (ImageView)this.a.findViewById(2131230808);
      localImageView5 = (ImageView)this.a.findViewById(2131230809);
      if (this.d.b_seatShow)
        break label719;
      localFrameLayout3.setVisibility(8);
      int k = this.d.b_windLoop;
      if (k != -1)
        break label858;
      localImageView3.setVisibility(4);
      int i1 = this.d.b_modeAuto;
      if (i1 != 2)
        break label937;
      localImageView4.setImageResource(2130837539);
      localImageView5.setVisibility(0);
      localImageView4.setVisibility(0);
      b(1);
      b(2);
      localImageView6 = (ImageView)this.a.findViewById(2131230816);
      localImageView7 = (ImageView)this.a.findViewById(2131230813);
      localImageView8 = (ImageView)this.a.findViewById(2131230814);
      localImageView9 = (ImageView)this.a.findViewById(2131230815);
      localFrameLayout4 = (FrameLayout)this.a.findViewById(2131230811);
      if (!this.d.b_ariStateShow)
        break label991;
      localFrameLayout4.setVisibility(0);
      if (!this.d.b_windFrontMax)
        break label1001;
      localImageView7.setVisibility(8);
      localImageView8.setVisibility(8);
      localImageView9.setVisibility(8);
      localImageView6.setVisibility(0);
      localImageView10 = (ImageView)this.a.findViewById(2131230812);
      if (this.d.b_windRearShow)
        break label1116;
      localImageView10.setVisibility(8);
      localImageView11 = (ImageView)this.a.findViewById(2131230821);
      if (!this.d.b_modeAc)
        break label1154;
      localImageView11.setImageResource(2130837505);
      localImageView12 = (ImageView)this.a.findViewById(2131230819);
      int i3 = this.d.b_modeDual;
      if (i3 != -1)
        break label1165;
      localImageView12.setVisibility(4);
      localFrameLayout5 = (FrameLayout)this.a.findViewById(2131230817);
      if (this.d.b_wind_FrameShow)
        break label1257;
      localFrameLayout5.setVisibility(8);
    }
    ImageView localImageView13;
    ImageView localImageView14;
    ImageView localImageView15;
    while (true)
    {
      localImageView13 = (ImageView)this.a.findViewById(2131230820);
      int i5 = this.d.b_rearLock;
      if (i5 != -1)
        break label1266;
      localImageView13.setVisibility(4);
      localImageView14 = (ImageView)this.a.findViewById(2131230822);
      int i6 = this.d.b_acMax;
      if (i6 != -1)
        break label1305;
      localImageView14.setVisibility(4);
      localImageView15 = (ImageView)this.a.findViewById(2131230810);
      if ((this.d.b_windLevel >= 0) && (this.d.b_windLevel <= this.d.b_windLevelMax))
        break label1344;
      localImageView15.setVisibility(4);
      this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      break;
      localFrameLayout1.setVisibility(8);
      break label89;
      label710: localFrameLayout2.setVisibility(8);
      break label104;
      label719: int i;
      label735: label763: int j;
      if (this.g)
      {
        i = this.d.b_seatHotRight;
        if ((i < 0) || (i > 3))
          break label828;
        localImageView1.setImageResource(i + 2130837721);
        localImageView1.setVisibility(0);
        if (!this.g)
          break label837;
        j = this.d.b_seatHotLeft;
        label779: if ((j < 0) || (j > 3))
          break label849;
        localImageView2.setImageResource(j + 2130837805);
        localImageView2.setVisibility(0);
      }
      while (true)
      {
        localFrameLayout3.setVisibility(0);
        break;
        i = this.d.b_seatHotLeft;
        break label735;
        label828: localImageView1.setVisibility(4);
        break label763;
        label837: j = this.d.b_seatHotRight;
        break label779;
        label849: localImageView2.setVisibility(4);
      }
      label858: int m = this.d.b_windLoop;
      if (m == 1)
        localImageView3.setImageResource(2130837867);
      while (true)
      {
        localImageView3.setVisibility(0);
        break;
        int n = this.d.b_windLoop;
        if (n == 2)
          localImageView3.setImageResource(2130837856);
        else
          localImageView3.setImageResource(2130837869);
      }
      label937: int i2 = this.d.b_modeAuto;
      if (i2 == 1)
      {
        localImageView4.setImageResource(2130837817);
        localImageView5.setVisibility(0);
        break label270;
      }
      localImageView4.setImageResource(2130837776);
      localImageView5.setVisibility(4);
      break label270;
      label991: localFrameLayout4.setVisibility(8);
      break label377;
      label1001: localImageView6.setVisibility(8);
      localImageView7.setVisibility(0);
      localImageView8.setVisibility(0);
      localImageView9.setVisibility(0);
      if (this.d.b_windUp)
      {
        localImageView7.setImageResource(2130837871);
        label1044: if (!this.d.b_windMid)
          break label1094;
        localImageView8.setImageResource(2130837860);
      }
      while (true)
      {
        if (!this.d.b_windDown)
          break label1105;
        localImageView9.setImageResource(2130837864);
        break;
        localImageView7.setImageResource(2130837870);
        break label1044;
        label1094: localImageView8.setImageResource(2130837858);
      }
      label1105: localImageView9.setImageResource(2130837862);
      break label414;
      label1116: if (this.d.b_windRear)
        localImageView10.setImageResource(2130837509);
      while (true)
      {
        localImageView10.setVisibility(0);
        break;
        localImageView10.setImageResource(2130837508);
      }
      label1154: localImageView11.setImageResource(2130837504);
      break label478;
      label1165: int i4 = this.d.B_DIS_IMG;
      if (i4 == 1)
        if (this.d.b_modeDual == 1)
          localImageView12.setImageResource(2130837714);
      while (true)
      {
        localImageView12.setVisibility(0);
        break;
        localImageView12.setImageResource(2130837713);
        continue;
        if (this.d.b_modeDual == 1)
          localImageView12.setImageResource(2130837607);
        else
          localImageView12.setImageResource(2130837606);
      }
      label1257: localFrameLayout5.setVisibility(0);
    }
    label1266: if (this.d.b_rearLock == 1)
      localImageView13.setImageResource(2130837788);
    while (true)
    {
      localImageView13.setVisibility(0);
      break;
      localImageView13.setImageResource(2130837787);
    }
    label1305: if (this.d.acMax == 1)
      localImageView14.setImageResource(2130837507);
    while (true)
    {
      localImageView14.setVisibility(0);
      break;
      localImageView14.setImageResource(2130837506);
    }
    label1344: if (this.d.b_windLevelMax == 7)
      localImageView15.setImageResource(2130837652 + this.d.b_windLevel);
    while (true)
    {
      localImageView15.setVisibility(0);
      break;
      if (this.d.b_windLevelMax == 4)
        localImageView15.setImageResource(2130837631 + this.d.b_windLevel);
      else if (this.d.b_windLevelMax == 15)
      {
        if (this.d.b_windLevel <= 9)
          localImageView15.setImageResource(2130837621 + this.d.b_windLevel);
        else
          localImageView15.setImageResource(-10 + (2130837615 + this.d.b_windLevel));
      }
      else if (this.d.b_windLevelMax == 8)
        localImageView15.setImageResource(2130837643 + this.d.b_windLevel);
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    int i;
    if (android.microntek.canbus.d.a.aV() > 19)
    {
      i = BaseApplication.k().m();
      if (i == 1)
        this.g = true;
    }
    while (true)
    {
      return;
      if (i == 2)
      {
        this.h = true;
        continue;
        if (BaseApplication.k().getParameters("cfg_rudder=").equals("1"))
          this.g = true;
      }
    }
  }

  public void onDestroy()
  {
    if (this.a != null)
      this.mWindowManager.removeView(this.a);
    super.onDestroy();
  }

  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((a()) && (!this.h))
    {
      e = paramIntent.getIntExtra("canbustype", 1);
      this.d = ((AirCondition)paramIntent.getSerializableExtra("airdata"));
      if (this.d != null);
    }
    while (true)
    {
      return;
      if (!this.d.onOff)
      {
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessage(0);
      }
      else
      {
        if (this.a == null)
          b();
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 3000L);
        c();
        d();
        continue;
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessage(0);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.AirServer
 * JD-Core Version:    0.6.2
 */