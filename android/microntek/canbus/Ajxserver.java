package android.microntek.canbus;

import a.a.a;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.microntek.canbus.view.MyButton;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.Locale;

public class Ajxserver extends Service
{
  private View a;
  private WindowManager.LayoutParams b;
  private int e = 0;
  private Handler handler = new b(this);
  private TextView j;
  private TextView k;
  private ImageView l;
  private StringBuffer m = new StringBuffer(32);
  private WindowManager mWindowManager;
  private byte[] n = null;
  private String o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private BroadcastReceiver s = new c(this);
  View.OnClickListener t = new d(this);

  private void a(byte paramByte)
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = ((byte)(0xFF & paramByte + 128));
    a((byte)-123, arrayOfByte, 1);
  }

  private void a(char paramChar)
  {
    if (this.m.length() >= 20);
    while (true)
    {
      return;
      this.m.append(paramChar);
      a(this.m.toString());
    }
  }

  public static void a(Context paramContext)
  {
    try
    {
      Object localObject1 = paramContext.getSystemService("statusbar");
      if (Build.VERSION.SDK_INT <= 16);
      Method localMethod;
      for (Object localObject2 = localObject1.getClass().getMethod("collapse", new Class[0]); ; localObject2 = localMethod)
      {
        ((Method)localObject2).invoke(localObject1, new Object[0]);
        break;
        localMethod = localObject1.getClass().getMethod("collapsePanels", new Class[0]);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void a(View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131230861);
    if ((this.o != null) && (this.o.equals("TZY")))
      localLinearLayout.setBackgroundResource(2130837534);
    while (true)
    {
      this.j = ((TextView)paramView.findViewById(2131230863));
      this.l = ((ImageView)paramView.findViewById(2131230862));
      this.k = ((TextView)paramView.findViewById(2131230864));
      MyButton localMyButton1 = (MyButton)paramView.findViewById(2131230877);
      MyButton localMyButton2 = (MyButton)paramView.findViewById(2131230878);
      MyButton localMyButton3 = (MyButton)paramView.findViewById(2131230879);
      MyButton localMyButton4 = (MyButton)paramView.findViewById(2131230880);
      MyButton localMyButton5 = (MyButton)paramView.findViewById(2131230875);
      MyButton localMyButton6 = (MyButton)paramView.findViewById(2131230865);
      MyButton localMyButton7 = (MyButton)paramView.findViewById(2131230866);
      MyButton localMyButton8 = (MyButton)paramView.findViewById(2131230867);
      MyButton localMyButton9 = (MyButton)paramView.findViewById(2131230868);
      MyButton localMyButton10 = (MyButton)paramView.findViewById(2131230869);
      MyButton localMyButton11 = (MyButton)paramView.findViewById(2131230870);
      MyButton localMyButton12 = (MyButton)paramView.findViewById(2131230871);
      MyButton localMyButton13 = (MyButton)paramView.findViewById(2131230872);
      MyButton localMyButton14 = (MyButton)paramView.findViewById(2131230873);
      MyButton localMyButton15 = (MyButton)paramView.findViewById(2131230874);
      MyButton localMyButton16 = (MyButton)paramView.findViewById(2131230876);
      localMyButton1.setOnClickListener(this.t);
      localMyButton2.setOnClickListener(this.t);
      localMyButton3.setOnClickListener(this.t);
      localMyButton4.setOnClickListener(this.t);
      localMyButton5.setOnClickListener(this.t);
      localMyButton6.setOnClickListener(this.t);
      localMyButton7.setOnClickListener(this.t);
      localMyButton8.setOnClickListener(this.t);
      localMyButton9.setOnClickListener(this.t);
      localMyButton10.setOnClickListener(this.t);
      localMyButton11.setOnClickListener(this.t);
      localMyButton12.setOnClickListener(this.t);
      localMyButton13.setOnClickListener(this.t);
      localMyButton14.setOnClickListener(this.t);
      localMyButton15.setOnClickListener(this.t);
      localMyButton16.setOnClickListener(this.t);
      return;
      if ((this.o != null) && (this.o.equals("TZY2")))
        localLinearLayout.setBackgroundResource(2130837538);
      else
        localLinearLayout.setBackgroundColor(-16777216);
    }
  }

  private void a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int i1 = paramArrayOfByte.length;
    if (i1 <= 2);
    while (true)
    {
      return;
      if (i == 8)
      {
        this.n = new byte[i1 - 2];
        for (int i3 = 0; i3 < i1; i3++)
          if (i3 >= 2)
            this.n[(i3 - 2)] = paramArrayOfByte[i3];
        String str = "";
        int i4 = 0;
        if (i4 < this.n.length)
        {
          if ((byte)(0xFF & this.n[i4]) != -1)
            if ((byte)(0xF & this.n[i4]) != 15)
              break label158;
          label158: for (str = str + "" + Integer.toHexString((0xFF & this.n[i4]) >> 4); ; str = str + "" + Integer.toHexString((0xF0 & this.n[i4]) >> 4) + "" + Integer.toHexString(0xF & this.n[i4]))
          {
            i4++;
            break;
          }
        }
        this.j.setText(str);
      }
      if (i == 9)
      {
        this.n = new byte[i1 - 2];
        for (int i2 = 0; i2 < i1; i2++)
          if (i2 >= 2)
            this.n[(i2 - 2)] = paramArrayOfByte[i2];
        this.k.setVisibility(0);
        if (this.n[0] == 4)
        {
          this.r = true;
          this.q = false;
          this.p = false;
          this.k.setText(getString(2131099659));
        }
        else if (this.n[0] == 3)
        {
          this.q = true;
          this.r = false;
          this.p = false;
          this.k.setText(getString(2131099658));
        }
        else if (this.n[0] == 2)
        {
          this.r = false;
          this.q = false;
          this.p = true;
          this.k.setText(getString(2131099657));
        }
        else
        {
          this.r = false;
          this.q = false;
          this.p = false;
          this.k.setText("");
          this.k.setVisibility(4);
        }
      }
    }
  }

  private void b()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2007;
    this.b.format = 1;
    this.b.flags = 56;
    this.b.gravity = 81;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -1;
    this.b.height = -1;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903043, null);
    if (this.e != 12)
      this.a.findViewById(2131230834).setBackgroundResource(2130837668);
    this.mWindowManager.addView(this.a, this.b);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }

  private void e()
  {
    this.b = new WindowManager.LayoutParams();
    Application localApplication = getApplication();
    getApplication();
    this.mWindowManager = ((WindowManager)localApplication.getSystemService("window"));
    this.b.type = 2007;
    this.b.format = 1;
    this.b.flags = 40;
    this.b.gravity = 81;
    this.b.x = 0;
    this.b.y = 0;
    this.b.width = -1;
    this.b.height = -1;
    this.a = LayoutInflater.from(getApplication()).inflate(2130903048, null);
    this.mWindowManager.addView(this.a, this.b);
    a(this.a);
    this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
  }

  private void f()
  {
    this.e = BaseApplication.k().p();
  }

  private void g()
  {
    if (this.m.length() > 0)
    {
      this.m.deleteCharAt(-1 + this.m.length());
      a(this.m.toString());
    }
  }

  private void h()
  {
    a((byte)-123, new byte[] { 3 }, 1);
  }

  private void i()
  {
    a((byte)-123, new byte[] { 2 }, 1);
  }

  private void j()
  {
    int i = 0;
    byte[] arrayOfByte = new byte[10];
    for (int i1 = 0; i1 < arrayOfByte.length; i1++)
      arrayOfByte[i1] = -1;
    StringBuffer localStringBuffer = new StringBuffer(32);
    if (this.m.length() == 0);
    while (true)
    {
      return;
      int i2 = 0;
      if (i2 < this.m.length())
      {
        if (this.m.charAt(i2) == '*')
          localStringBuffer.append('A');
        while (true)
        {
          i2++;
          break;
          if (this.m.charAt(i2) == '#')
            localStringBuffer.append('B');
          else if (this.m.charAt(i2) != ' ')
            localStringBuffer.append(this.m.charAt(i2));
          else
            localStringBuffer.append(this.m.charAt(70));
        }
      }
      String str1 = "";
      for (int i3 = 0; i3 < localStringBuffer.length(); i3++)
        str1 = str1 + String.valueOf(localStringBuffer.charAt(i3));
      if (str1.length() % 2 != 0);
      for (String str2 = str1 + "FFF"; ; str2 = str1 + "FF")
      {
        int i4 = 0;
        while (i < -2 + str2.length())
        {
          if ((i != 0) && (i % 2 != 0))
          {
            arrayOfByte[i4] = ((byte)Integer.parseInt(str2.substring(i - 1, i + 1), 16));
            i4++;
          }
          i++;
        }
      }
      a((byte)-122, arrayOfByte, 10);
    }
  }

  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 4];
    arrayOfByte[0] = 46;
    arrayOfByte[1] = paramByte;
    arrayOfByte[2] = ((byte)(paramInt & 0xFF));
    int i1 = (short)(arrayOfByte[1] + arrayOfByte[2]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 3)] = paramArrayOfByte[i];
      i1 = (short)(i1 + arrayOfByte[(i + 3)]);
      i++;
    }
    arrayOfByte[(paramInt + 3)] = ((byte)(0xFF ^ i1 & 0xFF));
    b(arrayOfByte);
  }

  public void a(String paramString)
  {
    if (this.j == null);
    while (true)
    {
      return;
      if (paramString != null)
        this.j.setText(paramString);
    }
  }

  public void b(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = paramArrayOfByte.length;
    for (int i1 = 0; i1 < i; i1++)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(0xFF & paramArrayOfByte[i1]);
      str = String.format(localLocale, "%d", arrayOfObject);
      if (i1 < i - 1)
        str = str + ",";
    }
    BaseApplication.k().setParameters("canbus_rsp=" + str);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    Settings.System.putInt(getContentResolver(), "canbus.ajx.state", 1);
    f();
    this.o = a.get("ro.product.customer", "HCT");
    if ((this.e == 5) || (this.e == 55) || (this.e == 69))
      e();
    while (true)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.microntek.ajx");
      localIntentFilter.addAction("com.microntek.sync");
      registerReceiver(this.s, localIntentFilter);
      a(this);
      return;
      b();
    }
  }

  public void onDestroy()
  {
    if (((this.e == 5) || (this.e == 55) || (this.e == 69)) && ((this.p) || (this.q) || (this.r)))
      h();
    unregisterReceiver(this.s);
    if (this.a != null)
      this.mWindowManager.removeView(this.a);
    Settings.System.putInt(getContentResolver(), "canbus.ajx.state", 0);
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.Ajxserver
 * JD-Core Version:    0.6.2
 */