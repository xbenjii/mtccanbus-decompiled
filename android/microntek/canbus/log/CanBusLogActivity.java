package android.microntek.canbus.log;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.microntek.canbus.BaseApplication;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CanBusLogActivity extends Activity
{
  private boolean cH = false;
  private boolean cI = true;
  private TextView cJ;
  private String cK = "";
  private Button cL;
  private Button cM;
  private Button cN;
  private Button cO;
  private Spinner cP;
  private int cQ = 0;
  private BroadcastReceiver cR = new g(this);

  private String aD()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm:ss:SSS");
    return localSimpleDateFormat.format(new Date()) + ": \t";
  }

  private String aE()
  {
    String str = BaseApplication.k().getParameters("cfg_canbus=");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    return "/mnt/sdcard/canbus " + str + " " + localSimpleDateFormat.format(new Date()) + ".log";
  }

  private List<String> getList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("NO");
    for (int i = 1; i < 256; i++)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      localArrayList.add(String.format(localLocale, "%02x ", arrayOfObject));
    }
    return localArrayList;
  }

  private void l(byte[] paramArrayOfByte)
  {
    if ((this.cQ == 0) || (this.cQ == (0xFF & paramArrayOfByte[1])))
    {
      String str = "";
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(str);
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(paramArrayOfByte[i]);
        str = String.format(localLocale, "%02x ", arrayOfObject) + "\t\t";
      }
      if (this.cI)
      {
        this.cK = (this.cK + aD() + str + "\n");
        this.cJ.setText(this.cK);
      }
      if (((0xFF & paramArrayOfByte[1]) == 255) && (this.cH))
      {
        this.cH = false;
        Toast.makeText(this, "TX RX Test OK !", 1000).show();
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    this.cJ = ((TextView)findViewById(2131230855));
    this.cL = ((Button)findViewById(2131230858));
    this.cM = ((Button)findViewById(2131230857));
    this.cN = ((Button)findViewById(2131230859));
    this.cP = ((Spinner)findViewById(2131230856));
    this.cO = ((Button)findViewById(2131230860));
    this.cL.setText("Start");
    this.cM.setText("Clear");
    this.cN.setText("Save");
    this.cO.setText("TX RX");
    this.cM.setOnClickListener(new a(this));
    this.cL.setOnClickListener(new b(this));
    this.cN.setOnClickListener(new c(this));
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367048, getList());
    localArrayAdapter.setDropDownViewResource(17367049);
    this.cP.setAdapter(localArrayAdapter);
    this.cP.setSelection(0);
    this.cP.setOnItemSelectedListener(new e(this));
    this.cO.setOnClickListener(new f(this));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.hiworld.canbus.receiver");
    registerReceiver(this.cR, localIntentFilter);
    android.microntek.canbus.d.a.eb = true;
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.cR);
    android.microntek.canbus.d.a.eb = false;
    super.onDestroy();
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.log.CanBusLogActivity
 * JD-Core Version:    0.6.2
 */