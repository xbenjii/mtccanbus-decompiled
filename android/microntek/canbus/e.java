package android.microntek.canbus;

import android.microntek.canbus.b.a;
import android.os.Handler;
import android.os.Message;

class e extends Handler
{
  e(CanBusServer paramCanBusServer)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 4:
    default:
    case 5:
    case 1:
    case 2:
    case 3:
    case 6:
    case 7:
    }
    while (true)
    {
      return;
      byte[] arrayOfByte2 = (byte[])paramMessage.obj;
      CanBusServer.a(this.am, arrayOfByte2);
      continue;
      if (CanBusServer.a(this.am) != null)
      {
        byte[] arrayOfByte1 = (byte[])paramMessage.obj;
        CanBusServer.a(this.am).i(arrayOfByte1);
        continue;
        if (CanBusServer.a(this.am) != null)
        {
          CanBusServer.a(this.am).aj();
          continue;
          int i = paramMessage.arg1;
          if (CanBusServer.a(this.am) != null)
            CanBusServer.a(this.am).l(i);
          if (CanBusServer.b(this.am) != null)
          {
            CanBusServer.b(this.am).l(i);
            continue;
            if (CanBusServer.b(this.am) != null)
            {
              String str = (String)paramMessage.obj;
              CanBusServer.b(this.am).d(str);
              continue;
              if ((CanBusServer.a(this.am) != null) && (this.am.l() == 1))
                CanBusServer.a(this.am).as();
              CanBusServer.c(this.am).removeMessages(7);
              CanBusServer.c(this.am).sendEmptyMessageDelayed(7, 400L);
            }
          }
        }
      }
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.e
 * JD-Core Version:    0.6.2
 */