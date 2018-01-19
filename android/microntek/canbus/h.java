package android.microntek.canbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.microntek.canbus.b.a;
import android.text.TextUtils;

class h extends BroadcastReceiver
{
  h(CanBusServer paramCanBusServer)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    String str1 = paramIntent.getAction();
    if (str1.equals("com.microntek.canbusdisplay"))
      this.am.a(paramIntent);
    String str2;
    do
    {
      do
        while (true)
        {
          return;
          if (str1.equals("com.hiworld.canbus.send"))
          {
            byte[] arrayOfByte = paramIntent.getByteArrayExtra("com.hiworld.sendkey");
            if ((arrayOfByte != null) && (arrayOfByte.length > 4))
              this.am.b(arrayOfByte);
          }
          else
          {
            if (!str1.equals("com.microntek.bt.report"))
              break;
            if (paramIntent.hasExtra("connect_state"))
            {
              int k = paramIntent.getIntExtra("connect_state", 0);
              if ((k == 2) || (k == 3) || (k == 5))
              {
                CanBusServer.b(this.am, i);
                CanBusServer.a(this.am, paramIntent.getStringExtra("phone_number"));
                if (TextUtils.isEmpty(CanBusServer.f(this.am)))
                  CanBusServer.a(this.am, "00000000000");
                if (CanBusServer.a(this.am) != null)
                  CanBusServer.a(this.am).a(CanBusServer.f(this.am), i);
                if (CanBusServer.b(this.am) != null)
                  CanBusServer.b(this.am).a(CanBusServer.f(this.am), i);
              }
              else if (CanBusServer.g(this.am))
              {
                CanBusServer.b(this.am, false);
                if (CanBusServer.a(this.am) != null)
                  CanBusServer.a(this.am).a(CanBusServer.f(this.am), 2);
                if (CanBusServer.b(this.am) != null)
                  CanBusServer.b(this.am).a(CanBusServer.f(this.am), 2);
                if (this.am.ae != null)
                {
                  CanBusServer.a(this.am, -1L);
                  this.am.a(this.am.ae);
                }
                else
                {
                  if (CanBusServer.a(this.am) != null)
                    CanBusServer.a(this.am).ap();
                  if (CanBusServer.b(this.am) != null)
                    CanBusServer.b(this.am).ap();
                }
              }
            }
          }
        }
      while (!str1.equals("com.microntek.screenOnOff"));
      str2 = paramIntent.getStringExtra("state");
    }
    while ((CanBusServer.a(this.am) == null) || (str2 == null));
    a locala = CanBusServer.a(this.am);
    if (str2.equals("true"));
    while (true)
    {
      locala.m(i);
      break;
      int j = 0;
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.h
 * JD-Core Version:    0.6.2
 */