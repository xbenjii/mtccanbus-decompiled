package android.microntek.canbus.air;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class d
  implements View.OnClickListener, View.OnTouchListener
{
  protected AirControlActivity bL;
  protected byte bM = 0;
  protected byte bN = 0;
  protected byte bO = 0;
  protected byte bP = 0;
  protected byte bQ = 0;
  private int bR = -1;
  private int bS = 0;
  private ImageButton bT;
  private ImageButton bU;
  private ImageButton bV;
  private ImageButton bW;
  private ImageButton bX;
  private ImageButton bY;
  private ImageButton bZ;
  private ImageButton ca;
  private ImageButton cb;
  private ImageButton cc;
  private ImageButton cd;
  private ImageButton ce;
  private ImageButton cf;
  private ImageButton cg;
  private ImageButton ch;
  private ImageButton ci;
  private ImageButton cj;
  private ImageButton ck;
  private ImageButton cl;
  private ImageButton cm;
  private ImageButton cn;
  private ImageButton co;
  private ImageButton cp;
  private ImageButton cq;
  private ImageButton cr;
  private View cs;
  private TextView ct;
  private TextView cu;
  private int state = this.bR;

  public d(AirControlActivity paramAirControlActivity)
  {
    this.bL = paramAirControlActivity;
  }

  private void f(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2131230733:
    case 2131230741:
    case 2131230745:
    case 2131230749:
    default:
    case 2131230724:
    case 2131230725:
    case 2131230727:
    case 2131230729:
    case 2131230730:
    case 2131230731:
    case 2131230732:
    case 2131230734:
    case 2131230744:
    case 2131230746:
    case 2131230742:
    case 2131230743:
    case 2131230747:
    case 2131230748:
    case 2131230750:
    case 2131230751:
    case 2131230735:
    case 2131230736:
    case 2131230737:
    case 2131230739:
    case 2131230738:
    case 2131230740:
    case 2131230726:
    case 2131230728:
    }
    while (true)
    {
      return;
      this.bL.e(3841, paramInt2);
      continue;
      this.bL.e(3842, paramInt2);
      continue;
      this.bL.e(3843, paramInt2);
      continue;
      this.bL.e(3844, paramInt2);
      continue;
      this.bL.e(3845, paramInt2);
      continue;
      this.bL.e(3846, paramInt2);
      continue;
      this.bL.e(3847, paramInt2);
      continue;
      this.bL.e(3848, paramInt2);
      continue;
      this.bL.e(3849, paramInt2);
      continue;
      this.bL.e(3850, paramInt2);
      continue;
      this.bL.e(3851, paramInt2);
      continue;
      this.bL.e(3852, paramInt2);
      continue;
      this.bL.e(3853, paramInt2);
      continue;
      this.bL.e(3855, paramInt2);
      continue;
      this.bL.e(3856, paramInt2);
      continue;
      this.bL.e(3857, paramInt2);
      continue;
      this.bL.e(3858, paramInt2);
      continue;
      this.bL.e(3860, paramInt2);
      continue;
      this.bL.e(3859, paramInt2);
      continue;
      this.bL.e(3861, paramInt2);
      continue;
      this.bL.e(3863, paramInt2);
      continue;
      this.bL.e(3862, paramInt2);
      continue;
      this.bL.e(3865, paramInt2);
      continue;
      this.bL.e(3872, paramInt2);
    }
  }

  private View i(int paramInt)
  {
    View localView = this.bL.findViewById(paramInt);
    localView.setOnClickListener(this);
    localView.setOnTouchListener(this);
    return localView;
  }

  private boolean k(int paramInt)
  {
    int[] arrayOfInt = this.bL.V();
    int i = arrayOfInt.length;
    boolean bool = false;
    if (i > 1);
    for (int j = 0; ; j++)
    {
      int k = arrayOfInt.length;
      bool = false;
      if (j < k)
      {
        if ((0xFFFF & arrayOfInt[j]) == paramInt)
          bool = true;
      }
      else
        return bool;
    }
  }

  public int ae()
  {
    return 2130903041;
  }

  public byte[] af()
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = this.bM;
    arrayOfByte[1] = this.bN;
    arrayOfByte[2] = this.bO;
    arrayOfByte[3] = this.bP;
    arrayOfByte[4] = this.bQ;
    return arrayOfByte;
  }

  public void ag()
  {
    int[] arrayOfInt = this.bL.V();
    if (arrayOfInt.length > 1)
    {
      int m = 0;
      if (m < arrayOfInt.length)
      {
        switch (0xFFFF & arrayOfInt[m])
        {
        case 3854:
        case 3864:
        case 3866:
        case 3867:
        case 3868:
        case 3869:
        case 3870:
        case 3871:
        default:
        case 3841:
        case 3843:
        case 3844:
        case 3845:
        case 3846:
        case 3847:
        case 3848:
        case 3849:
        case 3850:
        case 3851:
        case 3852:
        case 3853:
        case 3855:
        case 3856:
        case 3857:
        case 3861:
        case 3863:
        case 3862:
        case 3859:
        case 3860:
        case 3858:
        case 3865:
        case 3872:
        case 3842:
        }
        while (true)
        {
          m++;
          break;
          this.bT.setVisibility(0);
          continue;
          this.bV.setVisibility(0);
          continue;
          this.bW.setVisibility(0);
          continue;
          this.bX.setVisibility(0);
          continue;
          this.bY.setVisibility(0);
          continue;
          this.bZ.setVisibility(0);
          this.cu.setVisibility(0);
          this.ca.setVisibility(0);
          continue;
          this.cb.setVisibility(0);
          this.ct.setVisibility(0);
          this.cc.setVisibility(0);
          continue;
          this.cd.setVisibility(0);
          this.ce.setVisibility(0);
          this.cs.setVisibility(0);
          continue;
          this.cf.setVisibility(0);
          continue;
          this.cj.setVisibility(0);
          this.cg.setVisibility(0);
          this.ch.setVisibility(0);
          continue;
          this.ci.setVisibility(0);
          continue;
          this.cn.setVisibility(0);
          continue;
          this.co.setVisibility(0);
          continue;
          this.cp.setVisibility(0);
          continue;
          this.cm.setVisibility(0);
          continue;
          this.cl.setVisibility(0);
          continue;
          this.ck.setVisibility(0);
          continue;
          this.cq.setVisibility(0);
          continue;
          this.cr.setVisibility(0);
          continue;
          this.bU.setVisibility(0);
        }
      }
    }
    this.cf.setSelected(this.bL.y());
    ImageButton localImageButton1 = this.bT;
    boolean bool1;
    boolean bool2;
    label533: label588: boolean bool3;
    label641: boolean bool4;
    if (this.bL.Q() == 1)
    {
      bool1 = true;
      localImageButton1.setSelected(bool1);
      this.bU.setSelected(this.bL.O());
      ImageButton localImageButton2 = this.bV;
      if (this.bL.P() != 1)
        break label835;
      bool2 = true;
      localImageButton2.setSelected(bool2);
      this.bW.setSelected(this.bL.H());
      switch (this.bL.C())
      {
      default:
        int i = this.bL.J();
        if ((i >= 0) && (i <= 8))
          this.cj.setImageResource(i + 2130837675);
        ImageButton localImageButton3 = this.bY;
        if (this.bL.I() >= 1)
        {
          bool3 = true;
          localImageButton3.setSelected(bool3);
          ImageButton localImageButton4 = this.ci;
          if (this.bL.R() != 1)
            break label883;
          bool4 = true;
          label668: localImageButton4.setSelected(bool4);
          this.cr.setSelected(this.bL.G());
          this.ct.setText(j(this.bL.M()));
          this.cu.setText(j(this.bL.L()));
          if ((!k(3864)) || (!this.bL.D()) || (!this.bL.E()) || (!this.bL.F()))
            break label889;
        }
        break;
      case 2:
      case 1:
      case 0:
      }
    }
    while (true)
    {
      int j = this.bL.A();
      if ((j >= 0) && (j <= 3))
        this.cd.setImageResource(j + 2130837690);
      int k = this.bL.B();
      if ((k >= 0) && (k <= 3))
        this.ce.setImageResource(k + 2130837694);
      return;
      bool1 = false;
      break;
      label835: bool2 = false;
      break label533;
      this.bX.setImageResource(2130837684);
      break label588;
      this.bX.setImageResource(2130837685);
      break label588;
      this.bX.setImageResource(2130837686);
      break label588;
      bool3 = false;
      break label641;
      label883: bool4 = false;
      break label668;
      label889: if ((k(3862)) && (this.bL.D()) && (this.bL.E()))
      {
        this.cl.setSelected(false);
        this.cm.setSelected(false);
        this.ck.setSelected(false);
        this.cp.setSelected(true);
        this.cn.setSelected(false);
        this.co.setSelected(false);
      }
      else if ((k(3861)) && (this.bL.D()) && (this.bL.F()))
      {
        this.cl.setSelected(false);
        this.cm.setSelected(false);
        this.ck.setSelected(false);
        this.cp.setSelected(false);
        this.cn.setSelected(true);
        this.co.setSelected(false);
      }
      else if ((k(3863)) && (this.bL.E()) && (this.bL.F()))
      {
        this.cl.setSelected(false);
        this.cm.setSelected(false);
        this.ck.setSelected(false);
        this.cp.setSelected(false);
        this.cn.setSelected(false);
        this.co.setSelected(true);
      }
      else
      {
        this.cl.setSelected(this.bL.E());
        this.cm.setSelected(this.bL.D());
        this.ck.setSelected(this.bL.F());
        this.cp.setSelected(false);
        this.cn.setSelected(false);
        this.co.setSelected(false);
      }
    }
  }

  public void init()
  {
    this.bT = ((ImageButton)i(2131230724));
    this.bU = ((ImageButton)i(2131230725));
    this.bV = ((ImageButton)i(2131230727));
    this.bW = ((ImageButton)i(2131230729));
    this.bX = ((ImageButton)i(2131230730));
    this.bY = ((ImageButton)i(2131230731));
    this.bZ = ((ImageButton)i(2131230732));
    this.ca = ((ImageButton)i(2131230734));
    this.cb = ((ImageButton)i(2131230744));
    this.cc = ((ImageButton)i(2131230746));
    this.cd = ((ImageButton)i(2131230742));
    this.ce = ((ImageButton)i(2131230743));
    this.cf = ((ImageButton)i(2131230747));
    this.cg = ((ImageButton)i(2131230748));
    this.ch = ((ImageButton)i(2131230750));
    this.ci = ((ImageButton)i(2131230751));
    this.cr = ((ImageButton)i(2131230728));
    this.ck = ((ImageButton)i(2131230735));
    this.cl = ((ImageButton)i(2131230736));
    this.cm = ((ImageButton)i(2131230737));
    this.cn = ((ImageButton)i(2131230739));
    this.co = ((ImageButton)i(2131230738));
    this.cp = ((ImageButton)i(2131230740));
    this.cq = ((ImageButton)i(2131230726));
    this.cj = ((ImageButton)this.bL.findViewById(2131230749));
    this.cs = this.bL.findViewById(2131230741);
    this.ct = ((TextView)this.bL.findViewById(2131230745));
    this.cu = ((TextView)this.bL.findViewById(2131230733));
  }

  public String j(int paramInt)
  {
    String str2;
    if (paramInt == 0)
      str2 = "LO";
    while (true)
    {
      return str2;
      if (paramInt == 65535)
      {
        str2 = "HI";
      }
      else if (paramInt == -1)
      {
        str2 = "";
      }
      else
      {
        if (this.bL.N());
        for (String str1 = this.bL.getString(2131099652); ; str1 = this.bL.getString(2131099651))
        {
          if (paramInt % 2 == 0)
            break label103;
          str2 = paramInt / 10.0F + str1;
          break;
        }
        label103: str2 = paramInt / 10 + str1;
      }
    }
  }

  public void onClick(View paramView)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = paramView.getId();
    if ((this.state == this.bR) || (this.state == j))
    {
      if ((i != 3) && (i != 1))
        break label63;
      this.state = this.bR;
      this.bS = 0;
      f(j, 0);
    }
    while (true)
    {
      return false;
      label63: if (i == 0)
      {
        this.state = j;
        this.bS = 0;
        f(j, 1);
      }
      else if (i == 2)
      {
        this.state = j;
        this.bS = (1 + this.bS);
        if (this.bS == 70)
          f(j, 2);
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.air.d
 * JD-Core Version:    0.6.2
 */