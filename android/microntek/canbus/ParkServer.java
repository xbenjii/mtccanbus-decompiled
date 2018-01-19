package android.microntek.canbus;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint({"NewApi"})
public class ParkServer extends Service
{
  public static int e = 1;
  private View a;
  private FrameLayout aM;
  private LinearLayout aN;
  private ImageView aO;
  private ImageView aP;
  private ImageView aQ;
  private ImageView aR;
  private ImageView aS;
  private TextView aT;
  private TextView aU;
  private TextView aV;
  private TextView aW;
  private WindowManager.LayoutParams b;
  private byte[] buf = null;
  private Handler handler = new p(this);
  private Context mContext;
  private WindowManager mWindowManager;
  private int time = 0;

  private void Y()
  {
    this.handler.removeMessages(0);
    this.handler.sendEmptyMessage(0);
  }

  private void Z()
  {
    if (BaseApplication.k().l() == 0)
    {
      this.aO.setVisibility(8);
      this.aP.setVisibility(8);
      this.aR.setVisibility(0);
      this.aS.setVisibility(0);
    }
    while (true)
    {
      return;
      this.aR.setVisibility(4);
      this.aS.setVisibility(8);
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aO.setVisibility(8);
    this.aP.setVisibility(8);
    this.aV.setVisibility(paramInt2);
    this.aN.setVisibility(0);
    this.aQ.setVisibility(paramInt4);
    this.aT.setText(this.mContext.getString(paramInt3));
    this.aW.setVisibility(8);
    this.aR.setBackgroundResource(paramInt1);
    this.time = 0;
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2003;
    this.b.format = 1;
    this.b.flags = 40;
    this.b.gravity = 80;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -1;
    this.b.height = -1;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903046, null);
    this.mWindowManager.addView(this.a, this.b);
    b(this.a);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }

  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aO.setVisibility(8);
    this.aP.setVisibility(8);
    this.aV.setVisibility(paramInt2);
    this.aN.setVisibility(0);
    this.aQ.setVisibility(paramInt4);
    this.aT.setText(this.mContext.getString(paramInt3));
    if (this.time <= 9)
    {
      this.aW.setText(this.time + " S");
      this.time = (1 + this.time);
    }
    this.aW.setVisibility(0);
    this.aR.setBackgroundResource(paramInt1);
  }

  private void b(View paramView)
  {
    this.aM = ((FrameLayout)paramView.findViewById(2131230843));
    this.aN = ((LinearLayout)paramView.findViewById(2131230850));
    this.aO = ((ImageView)paramView.findViewById(2131230846));
    this.aP = ((ImageView)paramView.findViewById(2131230847));
    this.aQ = ((ImageView)paramView.findViewById(2131230851));
    this.aT = ((TextView)paramView.findViewById(2131230853));
    this.aU = ((TextView)paramView.findViewById(2131230849));
    this.aV = ((TextView)paramView.findViewById(2131230852));
    this.aW = ((TextView)paramView.findViewById(2131230854));
    this.aR = ((ImageView)paramView.findViewById(2131230845));
    this.aS = ((ImageView)paramView.findViewById(2131230844));
  }

  private void c(int paramInt1, int paramInt2)
  {
    this.aN.setVisibility(8);
    this.aO.setVisibility(0);
    this.aP.setVisibility(8);
    this.aO.setImageResource(paramInt2);
    this.time = 0;
    this.aR.setBackgroundResource(paramInt1);
  }

  private void d(int paramInt1, int paramInt2)
  {
    this.aN.setVisibility(8);
    this.aO.setVisibility(8);
    this.aP.setVisibility(0);
    this.aP.setImageResource(paramInt2);
    this.time = 0;
    this.aR.setBackgroundResource(paramInt1);
  }

  private void g(byte[] paramArrayOfByte)
  {
    if ((this.aM == null) || (paramArrayOfByte == null));
    while (true)
    {
      return;
      if ((paramArrayOfByte.length > 2) && (paramArrayOfByte[0] == 40))
      {
        if ((0x1 & paramArrayOfByte[1]) != 0)
        {
          int i = 0x7F & paramArrayOfByte[2];
          if (i > 39)
            i = 0;
          this.aU.setText(this.mContext.getString(2131099661 + i));
          switch (i)
          {
          default:
            label236: if ((i >= 2) && (i <= 39))
              this.aM.setVisibility(0);
            break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          case 12:
          case 13:
          case 14:
          case 15:
          case 16:
          case 17:
          case 18:
          case 19:
          case 20:
          case 21:
          case 22:
          case 23:
          case 24:
          case 25:
          case 26:
          case 27:
          case 28:
          case 29:
          case 30:
          case 31:
          case 32:
          case 33:
          case 34:
          case 35:
          case 36:
          case 37:
          case 38:
          case 39:
          }
          while (true)
          {
            Z();
            break;
            a(2130837561, 8, 2131099702, 0);
            break label236;
            a(2130837561, 0, 2131099703, 0);
            break label236;
            d(2130837561, 2130837793);
            break label236;
            c(2130837572, 2130837728);
            break label236;
            a(2130837561, 0, 2131099704, 0);
            break label236;
            c(2130837571, 2130837513);
            break label236;
            c(2130837570, 2130837513);
            break label236;
            c(2130837571, 2130837513);
            break label236;
            c(2130837570, 2130837513);
            break label236;
            c(2130837576, 2130837537);
            break label236;
            c(2130837575, 2130837537);
            break label236;
            c(2130837576, 2130837536);
            break label236;
            c(2130837575, 2130837536);
            break label236;
            c(2130837574, 2130837512);
            break label236;
            c(2130837569, 2130837512);
            break label236;
            c(2130837574, 2130837512);
            break label236;
            c(2130837569, 2130837512);
            break label236;
            c(2130837568, 2130837537);
            break label236;
            c(2130837567, 2130837537);
            break label236;
            c(2130837566, 2130837513);
            break label236;
            c(2130837565, 2130837513);
            break label236;
            c(2130837564, 2130837537);
            break label236;
            c(2130837563, 2130837537);
            break label236;
            c(2130837562, 2130837512);
            break label236;
            c(2130837573, 2130837512);
            break label236;
            a(2130837561, 8, 2131099705, 8);
            break label236;
            b(2130837561, 8, 2131099706, 8);
            break label236;
            a(2130837561, 0, 2131099707, 0);
            break label236;
            a(2130837561, 0, 2131099708, 0);
            break label236;
            a(2130837561, 0, 2131099709, 0);
            break label236;
            a(2130837561, 0, 2131099710, 0);
            break label236;
            a(2130837561, 0, 2131099711, 0);
            break label236;
            a(2130837561, 0, 2131099712, 0);
            break label236;
            c(2130837566, 2130837513);
            break label236;
            c(2130837565, 2130837513);
            break label236;
            c(2130837562, 2130837512);
            break label236;
            c(2130837573, 2130837512);
            break label236;
            a(2130837561, 0, 2131099707, 0);
            break label236;
            Y();
          }
        }
        Y();
      }
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    this.mContext = getApplicationContext();
    super.onCreate();
    Log.i("ParkServer", "ParkServer onCreate");
  }

  public void onDestroy()
  {
    if (this.a != null)
      this.mWindowManager.removeView(this.a);
    this.handler.removeMessages(1);
    super.onDestroy();
    Log.i("ParkServer", "ParkServer onDestroy");
  }

  @Deprecated
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    e = paramIntent.getIntExtra("canbustype", 0);
    this.buf = ((byte[])paramIntent.getSerializableExtra("park"));
    if (this.a == null)
      b();
    g(this.buf);
    this.handler.sendEmptyMessage(1);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.ParkServer
 * JD-Core Version:    0.6.2
 */