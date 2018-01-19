package android.microntek.canbus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;

public class Canbus20Activity extends Activity
{
  public static int ax = 0;
  private String TAG = "Canbus20Activity";
  private LinearLayout an;
  private ImageButton ao;
  private ImageButton ap;
  private ImageButton aq;
  private ImageButton ar;
  private TextView as;
  private boolean at = true;
  private SharedPreferences au;
  byte[] av = null;
  private String aw = "com.microntek.canbus20activity";
  private BroadcastReceiver ay = new m(this);
  private int minute = 0;
  private byte[] n = new byte[3];
  private int second = 0;

  private void a(String paramString, byte[] paramArrayOfByte)
  {
    String str = " ";
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Byte.valueOf(paramArrayOfByte[i]);
      str = String.format(localLocale, "%02x ", arrayOfObject);
    }
    Log.i(this.TAG, str);
  }

  private void a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    if (i == 18)
    {
      this.an.setVisibility(8);
      this.as.setVisibility(8);
      for (int k = 0; k < 3; k++)
        this.n[k] = paramArrayOfByte[k];
      if ((byte)(0x8 & this.n[1]) != 8)
        break label129;
      BaseApplication.k().setParameters("av_channel_exit=line");
      this.ar.setBackgroundResource(2130837667);
      ax = 0;
      this.at = false;
      b((byte)-128);
    }
    while (true)
    {
      int j = 0;
      if (i != 23)
        break label438;
      while (j < 3)
      {
        this.n[j] = paramArrayOfByte[j];
        j++;
      }
      label129: if ((byte)(0x4 & this.n[1]) == 4)
      {
        BaseApplication.k().setParameters("av_channel_enter=line");
        this.ar.setBackgroundResource(2130837668);
        ax = 0;
        this.at = false;
        b((byte)-128);
      }
      else if ((byte)(0x2 & this.n[1]) == 2)
      {
        BaseApplication.k().setParameters("av_channel_enter=line");
        this.ar.setBackgroundResource(2130837669);
        this.an.setVisibility(0);
        this.as.setVisibility(0);
        this.ap.setImageResource(2130837664);
        ax = 1;
      }
      else if ((byte)(0x1 & this.n[1]) == 1)
      {
        this.ar.setBackgroundResource(2130837669);
        this.an.setVisibility(0);
        this.as.setVisibility(0);
        this.ap.setImageResource(2130837665);
        ax = 0;
      }
      else
      {
        ax = 0;
        BaseApplication.k().setParameters("av_channel_exit=line");
        finish();
      }
    }
    this.minute = (0xFF & this.n[1]);
    this.second = (0xFF & this.n[2]);
    String str1;
    if (this.minute < 10)
    {
      str1 = "0" + this.minute;
      if (this.second >= 10)
        break label466;
    }
    label438: label466: for (String str2 = "0" + this.second; ; str2 = "" + this.second)
    {
      this.as.setText(str1 + ":" + str2);
      return;
      str1 = "" + this.minute;
      break;
    }
  }

  private void b(byte paramByte)
  {
    g((byte)-110, new byte[] { paramByte }, 1);
  }

  private void b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    String str = "";
    for (int j = 0; j < i; j++)
    {
      str = str + h(0xFF & paramArrayOfByte[j]);
      if (j < i - 1)
        str = str + ",";
    }
    Log.i(this.TAG, "canbus_rsp=" + str);
    BaseApplication.k().setParameters("canbus_rsp=" + str);
  }

  private void g(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 4];
    arrayOfByte[0] = 46;
    arrayOfByte[1] = paramByte;
    arrayOfByte[2] = ((byte)(paramInt & 0xFF));
    int j = (short)(arrayOfByte[1] + arrayOfByte[2]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 3)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 3)]);
      i++;
    }
    arrayOfByte[(paramInt + 3)] = ((byte)(0xFF ^ j & 0xFF));
    b(arrayOfByte);
    a("write:", arrayOfByte);
  }

  private String h(int paramInt)
  {
    int i = paramInt / 10;
    int j = paramInt % 10;
    if (i == 0);
    for (String str = "" + j; ; str = "" + i + j)
      return str;
  }

  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903045);
    this.av = getIntent().getByteArrayExtra("syncdata");
    this.au = getSharedPreferences("status1", 0);
    this.at = this.au.getBoolean("status", true);
    this.an = ((LinearLayout)findViewById(2131230839));
    this.ao = ((ImageButton)findViewById(2131230840));
    this.ap = ((ImageButton)findViewById(2131230841));
    this.aq = ((ImageButton)findViewById(2131230842));
    this.as = ((TextView)findViewById(2131230837));
    this.ar = ((ImageButton)findViewById(2131230838));
    if (this.at)
      this.ap.setImageResource(2130837664);
    while (true)
    {
      this.aq.setOnClickListener(new j(this));
      this.ao.setOnClickListener(new k(this));
      this.ap.setOnClickListener(new l(this));
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction(this.aw);
      registerReceiver(this.ay, localIntentFilter);
      if (this.av != null)
        a(this.av);
      return;
      this.ap.setImageResource(2130837665);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplication.k().setParameters("av_channel_exit=line");
  }

  protected void onStop()
  {
    super.onStop();
    b((byte)-128);
    this.ap.setImageResource(2130837665);
    BaseApplication.k().setParameters("av_channel_exit=line");
    this.at = false;
    this.au.edit().putBoolean("status", this.at).commit();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.Canbus20Activity
 * JD-Core Version:    0.6.2
 */