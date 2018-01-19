package android.microntek.canbus;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.microntek.canbus.c.aa;
import android.microntek.canbus.c.ab;
import android.microntek.canbus.c.ac;
import android.microntek.canbus.c.ad;
import android.microntek.canbus.c.ae;
import android.microntek.canbus.c.af;
import android.microntek.canbus.c.ag;
import android.microntek.canbus.c.ah;
import android.microntek.canbus.c.ai;
import android.microntek.canbus.c.aj;
import android.microntek.canbus.c.ak;
import android.microntek.canbus.c.al;
import android.microntek.canbus.c.am;
import android.microntek.canbus.c.an;
import android.microntek.canbus.c.ao;
import android.microntek.canbus.c.ap;
import android.microntek.canbus.c.aq;
import android.microntek.canbus.c.ar;
import android.microntek.canbus.c.as;
import android.microntek.canbus.c.at;
import android.microntek.canbus.c.au;
import android.microntek.canbus.c.av;
import android.microntek.canbus.c.aw;
import android.microntek.canbus.c.ax;
import android.microntek.canbus.c.ay;
import android.microntek.canbus.c.az;
import android.microntek.canbus.c.ba;
import android.microntek.canbus.c.bb;
import android.microntek.canbus.c.bc;
import android.microntek.canbus.c.bd;
import android.microntek.canbus.c.be;
import android.microntek.canbus.c.bf;
import android.microntek.canbus.c.bg;
import android.microntek.canbus.c.bh;
import android.microntek.canbus.c.bi;
import android.microntek.canbus.c.bj;
import android.microntek.canbus.c.bk;
import android.microntek.canbus.c.bl;
import android.microntek.canbus.c.bm;
import android.microntek.canbus.c.bn;
import android.microntek.canbus.c.bo;
import android.microntek.canbus.c.bp;
import android.microntek.canbus.c.bq;
import android.microntek.canbus.c.br;
import android.microntek.canbus.c.bs;
import android.microntek.canbus.c.bt;
import android.microntek.canbus.c.bu;
import android.microntek.canbus.c.bv;
import android.microntek.canbus.c.bw;
import android.microntek.canbus.c.by;
import android.microntek.canbus.c.bz;
import android.microntek.canbus.c.c;
import android.microntek.canbus.c.ca;
import android.microntek.canbus.c.cb;
import android.microntek.canbus.c.cc;
import android.microntek.canbus.c.cd;
import android.microntek.canbus.c.ce;
import android.microntek.canbus.c.cf;
import android.microntek.canbus.c.cg;
import android.microntek.canbus.c.ci;
import android.microntek.canbus.c.cj;
import android.microntek.canbus.c.ck;
import android.microntek.canbus.c.cm;
import android.microntek.canbus.c.co;
import android.microntek.canbus.c.cp;
import android.microntek.canbus.c.cq;
import android.microntek.canbus.c.cu;
import android.microntek.canbus.c.cy;
import android.microntek.canbus.c.cz;
import android.microntek.canbus.c.da;
import android.microntek.canbus.c.db;
import android.microntek.canbus.c.dd;
import android.microntek.canbus.c.de;
import android.microntek.canbus.c.df;
import android.microntek.canbus.c.dg;
import android.microntek.canbus.c.dh;
import android.microntek.canbus.c.di;
import android.microntek.canbus.c.dj;
import android.microntek.canbus.c.dk;
import android.microntek.canbus.c.dl;
import android.microntek.canbus.c.dm;
import android.microntek.canbus.c.dn;
import android.microntek.canbus.c.do;
import android.microntek.canbus.c.dp;
import android.microntek.canbus.c.dq;
import android.microntek.canbus.c.j;
import android.microntek.canbus.c.l;
import android.microntek.canbus.c.m;
import android.microntek.canbus.c.n;
import android.microntek.canbus.c.o;
import android.microntek.canbus.c.p;
import android.microntek.canbus.c.q;
import android.microntek.canbus.c.r;
import android.microntek.canbus.c.s;
import android.microntek.canbus.c.t;
import android.microntek.canbus.c.u;
import android.microntek.canbus.c.v;
import android.microntek.canbus.c.w;
import android.microntek.canbus.c.x;
import android.microntek.canbus.c.y;
import android.microntek.canbus.c.z;
import android.microntek.canbus.serializable.AirCondition;
import android.microntek.canbus.serializable.Door;
import android.microntek.canbus.serializable.Radar;
import android.microntek.serial.SerialManager;
import android.microntek.serial.SerialReceiver;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.UserHandle;
import android.provider.Settings.System;
import android.util.Log;
import java.util.List;
import java.util.Locale;

public class CanBusServer extends Service
{
  private static int S = 0;
  private static byte[] T = new byte[1024];
  private final boolean B = false;
  private android.microntek.canbus.b.a C = null;
  private android.microntek.canbus.b.a D = null;
  private final int E = 1;
  private final int F = 2;
  private final int G = 3;
  private final int H = 4;
  private final int I = 5;
  private final int J = 6;
  private final int K = 7;
  private final int L = 8;
  private final int M = 9;
  private final int N = 10;
  private final int O = 11;
  private final int P = 12;
  private boolean Q = false;
  private String R = "88888888888";
  public final int STATE_OFF = 0;
  private SerialManager U = null;
  private SerialReceiver V;
  private final int W = 1;
  private final int X = 2;
  private final int Y = 3;
  private final int Z = 4;
  private final int aa = 5;
  private final int ab = 6;
  private final int ad = 7;
  public Intent ae = null;
  private RemoteCallbackList<android.microntek.canbus.a.d> af = new RemoteCallbackList();
  private boolean ag = true;
  public String ah = "";
  private android.microntek.canbus.a.b ai = new g(this);
  private BroadcastReceiver aj = new h(this);
  private BroadcastReceiver ak = new i(this);
  private long al = -1L;
  private AirCondition d;
  private int e = 0;
  private Context mContext;
  private Handler mHandler = new e(this);
  public String o = "";
  public int state = 0;
  public int y = 0;

  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    while (true)
    {
      if (paramInt1 < paramInt2)
      {
        if (paramArrayOfByte[paramInt1] != 46)
          break label60;
        if (paramInt2 - paramInt1 > 3)
        {
          int j = 4 + paramArrayOfByte[(paramInt1 + 2)];
          int k = -1 + (j + paramInt1);
          if (paramInt2 - paramInt1 >= j)
            i = paramInt1 | k << 16;
        }
      }
      return i;
      label60: paramInt1++;
    }
  }

  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (int j = 1; j < paramInt2 - paramInt1; j++)
      i = (short)(i + paramArrayOfByte[(paramInt1 + j)]);
    if ((byte)(0xFF ^ i & 0xFF) != paramArrayOfByte[paramInt2]);
    while (true)
    {
      return;
      if (this.C != null)
        this.C.d(paramArrayOfByte, paramInt1, paramInt2);
      c(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  private void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    int j = 0xFF & paramArrayOfByte[(paramInt1 + 2)];
    if ((i <= 3) || (i >= 100));
    while (true)
    {
      return;
      if (((a()) || (android.microntek.canbus.d.a.eb)) && (j >= 1))
      {
        byte[] arrayOfByte = new byte[i + 1];
        for (int k = 0; k <= i; k++)
          if (paramInt1 + k < 1024)
            arrayOfByte[k] = paramArrayOfByte[(paramInt1 + k)];
        Intent localIntent = new Intent("com.hiworld.canbus.receiver");
        localIntent.putExtra("com.hiworld.receiverkey", arrayOfByte);
        this.mContext.sendBroadcastAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
      }
    }
  }

  private void f()
  {
    this.y = BaseApplication.k().n();
    this.e = BaseApplication.k().p();
    if (android.microntek.canbus.d.a.aV() <= 23)
      BaseApplication.k().q();
    switch (this.e)
    {
    default:
    case 1:
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
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 46:
    case 47:
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 57:
    case 58:
    case 59:
    case 60:
    case 61:
    case 62:
    case 63:
    case 64:
    case 65:
    case 66:
    case 67:
    case 68:
    case 69:
    case 70:
    case 71:
    case 72:
    case 73:
    case 74:
    case 75:
    case 76:
    case 77:
    case 78:
    case 79:
    case 80:
    case 81:
    case 82:
    case 83:
    case 84:
    case 85:
    case 86:
    case 87:
    case 88:
    case 89:
    case 90:
    case 91:
    case 92:
    case 93:
    case 94:
    case 95:
    case 96:
    case 97:
    case 98:
    case 99:
    case 100:
    case 101:
    case 102:
    case 103:
    case 104:
    case 105:
    case 106:
    case 107:
    case 108:
    case 109:
    }
    while (true)
    {
      this.ah = BaseApplication.k().getParameters("sta_mcu_version=");
      this.o = a.a.a.get("ro.product.customer", "HCT");
      if (((this.o != null) && (this.o.startsWith("KLD"))) || (this.ah.contains("KLD")))
        this.D = new android.microntek.canbus.b.b(this, this.mContext);
      s();
      u();
      d(0);
      e(0);
      b("");
      return;
      this.C = new android.microntek.canbus.c.a(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.b(this, this.mContext);
      continue;
      this.C = new c(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.d(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.e(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.f(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.g(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.h(this, this.mContext);
      continue;
      this.C = new android.microntek.canbus.c.i(this, this.mContext);
      continue;
      this.C = new j(this, this.mContext);
      continue;
      this.C = new v(this, this.mContext);
      continue;
      this.C = new w(this, this.mContext);
      continue;
      this.C = new x(this, this.mContext);
      continue;
      this.C = new y(this, this.mContext);
      continue;
      this.C = new z(this, this.mContext);
      continue;
      this.C = new aa(this, this.mContext);
      continue;
      this.C = new ab(this, this.mContext);
      continue;
      this.C = new ac(this, this.mContext);
      continue;
      this.C = new ad(this, this.mContext);
      continue;
      this.C = new ae(this, this.mContext);
      continue;
      this.C = new af(this, this.mContext);
      continue;
      this.C = new ag(this, this.mContext);
      continue;
      this.C = new ah(this, this.mContext);
      continue;
      this.C = new ai(this, this.mContext);
      continue;
      this.C = new aj(this, this.mContext);
      continue;
      this.C = new ak(this, this.mContext);
      continue;
      this.C = new al(this, this.mContext);
      continue;
      this.C = new am(this, this.mContext);
      continue;
      this.C = new an(this, this.mContext);
      continue;
      this.C = new ao(this, this.mContext);
      continue;
      this.C = new ap(this, this.mContext);
      continue;
      this.C = new aq(this, this.mContext);
      continue;
      this.C = new ar(this, this.mContext);
      continue;
      this.C = new as(this, this.mContext);
      continue;
      this.C = new at(this, this.mContext);
      continue;
      this.C = new au(this, this.mContext);
      continue;
      this.C = new av(this, this.mContext);
      continue;
      this.C = new aw(this, this.mContext);
      continue;
      this.C = new ax(this, this.mContext);
      continue;
      this.C = new ay(this, this.mContext);
      continue;
      this.C = new az(this, this.mContext);
      continue;
      this.C = new ba(this, this.mContext);
      continue;
      this.C = new bb(this, this.mContext);
      continue;
      this.C = new bc(this, this.mContext);
      continue;
      this.C = new bd(this, this.mContext);
      continue;
      this.C = new be(this, this.mContext);
      continue;
      this.C = new bf(this, this.mContext);
      continue;
      this.C = new bg(this, this.mContext);
      continue;
      this.C = new bh(this, this.mContext);
      continue;
      this.C = new bi(this, this.mContext);
      continue;
      this.C = new bj(this, this.mContext);
      continue;
      this.C = new bk(this, this.mContext);
      continue;
      this.C = new bl(this, this.mContext);
      continue;
      this.C = new bm(this, this.mContext);
      continue;
      this.C = new bn(this, this.mContext);
      continue;
      this.C = new bo(this, this.mContext);
      continue;
      this.C = new bp(this, this.mContext);
      continue;
      this.C = new bq(this, this.mContext);
      continue;
      this.C = new br(this, this.mContext);
      continue;
      this.C = new bs(this, this.mContext);
      continue;
      this.C = new bt(this, this.mContext);
      continue;
      this.C = new bu(this, this.mContext);
      continue;
      this.C = new bv(this, this.mContext);
      continue;
      this.C = new bw(this, this.mContext);
      continue;
      this.C = new by(this, this.mContext);
      continue;
      this.C = new bz(this, this.mContext);
      continue;
      this.C = new ca(this, this.mContext);
      continue;
      this.C = new cb(this, this.mContext);
      continue;
      this.C = new cc(this, this.mContext);
      continue;
      this.C = new cd(this, this.mContext);
      continue;
      this.C = new ce(this, this.mContext);
      continue;
      this.C = new cf(this, this.mContext);
      continue;
      this.C = new cg(this, this.mContext);
      continue;
      this.C = new ci(this, this.mContext);
      continue;
      this.C = new cj(this, this.mContext);
      continue;
      this.C = new ck(this, this.mContext);
      continue;
      this.C = new cm(this, this.mContext);
      continue;
      this.C = new co(this, this.mContext);
      continue;
      this.C = new cp(this, this.mContext);
      continue;
      this.C = new cq(this, this.mContext);
      continue;
      this.C = new cu(this, this.mContext);
      continue;
      this.C = new cy(this, this.mContext);
      continue;
      this.C = new cz(this, this.mContext);
      continue;
      this.C = new da(this, this.mContext);
      continue;
      this.C = new db(this, this.mContext);
      continue;
      this.C = new dd(this, this.mContext);
      continue;
      this.C = new de(this, this.mContext);
      continue;
      this.C = new df(this, this.mContext);
      continue;
      this.C = new dg(this, this.mContext);
      continue;
      this.C = new dh(this, this.mContext);
      continue;
      this.C = new di(this, this.mContext);
      continue;
      this.C = new dj(this, this.mContext);
      continue;
      this.C = new dk(this, this.mContext);
      continue;
      this.C = new dl(this, this.mContext);
      continue;
      this.C = new dm(this, this.mContext);
      continue;
      this.C = new dn(this, this.mContext);
      continue;
      this.C = new do(this, this.mContext);
      continue;
      this.C = new dp(this, this.mContext);
      continue;
      this.C = new dq(this, this.mContext);
      continue;
      this.C = new l(this, this.mContext);
      continue;
      this.C = new m(this, this.mContext);
      continue;
      this.C = new n(this, this.mContext);
      continue;
      this.C = new o(this, this.mContext);
      continue;
      this.C = new p(this, this.mContext);
      continue;
      this.C = new q(this, this.mContext);
      continue;
      this.C = new r(this, this.mContext);
      continue;
      this.C = new s(this, this.mContext);
      continue;
      this.C = new t(this, this.mContext);
      continue;
      this.C = new u(this, this.mContext);
    }
  }

  private void f(int paramInt)
  {
    if (this.C != null)
      this.C.n(paramInt);
  }

  private void f(byte[] paramArrayOfByte)
  {
    int i = 1024;
    int j = paramArrayOfByte.length;
    if (j + S >= i)
    {
      S = 0;
      if (j < i);
    }
    while (true)
    {
      for (int k = 0; k < i; k++)
        T[(k + S)] = paramArrayOfByte[k];
      int m = i + S;
      int i5;
      for (int n = 0; ; n = i5)
      {
        int i2;
        if (n < m)
        {
          i2 = a(T, n, m);
          if (i2 != -1);
        }
        else
        {
          S = m - n;
          for (int i1 = 0; i1 < S; i1++)
            T[i1] = T[(i1 + n)];
        }
        int i3 = i2 & 0xFFFF;
        int i4 = 0xFFFF & i2 >> 16;
        i5 = i4 + 1;
        b(T, i3, i4);
      }
      return;
      i = j;
    }
  }

  private byte g(int paramInt)
  {
    int i = 0xF & paramInt >> 4;
    int j = paramInt & 0xF;
    byte b;
    if ((i == 7) && (j >= 3) && (j <= 4))
      b = 2;
    while (true)
    {
      return b;
      if ((i == 7) && (j >= 5))
        b = (byte)(j - 2);
      else
        b = (byte)j;
    }
  }

  private void s()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName("com.microntek.tpms", "com.microntek.tpms.MyService"));
      this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      label38: return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }

  private void u()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName("com.microntek.kglradiowritexml", "com.microntek.kglradiowritexml.XMLSercice"));
      this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      label38: return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }

  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt)
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
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = 14;
    String str = Settings.System.getString(getContentResolver(), "KeyBalance");
    String[] arrayOfString;
    if (str != null)
      arrayOfString = str.split(",");
    while (true)
    {
      try
      {
        int n = Integer.parseInt(arrayOfString[0]);
        k = n;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          int k;
          int i1 = Integer.parseInt(arrayOfString[1]);
          i = k;
          j = i1;
          if (paramInt1 != -1)
            if (paramInt2 != -1)
            {
              Settings.System.putString(getContentResolver(), "KeyBalance", paramInt1 + "," + paramInt2);
              this.mContext.sendBroadcast(new Intent("com.microntek.balancechange"));
              return;
              localNumberFormatException1 = localNumberFormatException1;
              k = i;
              int m = i;
              i = k;
              j = m;
              continue;
            }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          continue;
          paramInt2 = j;
          continue;
          paramInt1 = i;
          continue;
        }
      }
      int j = i;
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 10;
    Settings.System.putInt(getContentResolver(), "KeyEQmode", 0);
    String str = Settings.System.getString(getContentResolver(), "KeyCustomEQ");
    String[] arrayOfString;
    if (str != null)
      arrayOfString = str.split(",");
    while (true)
    {
      try
      {
        int i1 = Integer.parseInt(arrayOfString[0]);
        j = i1;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          int i2 = Integer.parseInt(arrayOfString[1]);
          m = i2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            int m;
            int i3 = Integer.parseInt(arrayOfString[2]);
            int i4 = m;
            k = i3;
            i = i4;
            if (paramInt1 != -1)
              if (paramInt2 != -1)
                if (paramInt3 != -1)
                {
                  Settings.System.putInt(getContentResolver(), "KeyEQmode", 0);
                  Settings.System.putString(getContentResolver(), "KeyCustomEQ", paramInt3 + "," + paramInt2 + "," + paramInt1);
                  this.mContext.sendBroadcast(new Intent("com.microntek.eqchange"));
                  return;
                  localNumberFormatException1 = localNumberFormatException1;
                  j = i;
                  m = i;
                  int n = m;
                  k = i;
                  i = n;
                  continue;
                  localNumberFormatException2 = localNumberFormatException2;
                  m = i;
                  continue;
                }
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            continue;
            paramInt3 = j;
            continue;
            paramInt2 = i;
            continue;
            paramInt1 = k;
            continue;
          }
        }
      }
      int j = i;
      int k = i;
    }
  }

  public void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("type");
    if (str != null)
    {
      if ((!str.equals("radio")) || (this.state != 9))
        break label148;
      this.ae = paramIntent;
      int i14 = paramIntent.getIntExtra("group", 0);
      int i15 = paramIntent.getIntExtra("fre", 87500);
      int i16 = paramIntent.getByteExtra("index", (byte)0);
      long l6 = i16 + (i14 + i15);
      if ((!this.Q) && (this.al != l6))
      {
        this.al = l6;
        if (this.C != null)
          this.C.a(g(i14), i15, i16);
        if (this.D != null)
          this.D.a((byte)i14, i15, i16);
      }
    }
    while (true)
    {
      return;
      label148: if ((str.equals("dvd")) && (this.state == 10))
      {
        this.ae = paramIntent;
        int i10 = paramIntent.getIntExtra("item", 0);
        int i11 = paramIntent.getIntExtra("all", 0);
        int i12 = paramIntent.getIntExtra("time", 0);
        int i13 = paramIntent.getIntExtra("mDiskType", -1);
        long l5 = i13 + (i12 + (i11 + i10));
        if ((!this.Q) && (this.al != l5))
        {
          if (this.C != null)
            this.C.b(i10, i12, i13);
          if (this.D != null)
            this.D.b(i10, i12, i13);
        }
      }
      else if ((str.equals("music")) && (this.state == 3))
      {
        this.ae = paramIntent;
        int i7 = paramIntent.getIntExtra("all", 0);
        int i8 = paramIntent.getIntExtra("cur", 0);
        int i9 = paramIntent.getIntExtra("time", 0);
        long l4 = i9 + (i7 + i8);
        if ((!this.Q) && (this.al != l4))
        {
          if (this.C != null)
            this.C.c(i7, i8, i9);
          if (this.D != null)
            this.D.c(i7, i8, i9);
        }
      }
      else if ((str.equals("usb")) && (this.state == 12))
      {
        this.ae = paramIntent;
        int i4 = paramIntent.getIntExtra("all", 0);
        int i5 = paramIntent.getIntExtra("cur", 0);
        int i6 = paramIntent.getIntExtra("time", 0);
        long l3 = i6 + (i4 + i5);
        if ((!this.Q) && (this.al != l3))
        {
          if (this.C != null)
            this.C.c(i4, i5, i6);
          if (this.D != null)
            this.D.c(i4, i5, i6);
        }
      }
      else if ((str.equals("movie")) && (this.state == 4))
      {
        this.ae = paramIntent;
        int i1 = paramIntent.getIntExtra("all", 0);
        int i2 = paramIntent.getIntExtra("cur", 0);
        int i3 = paramIntent.getIntExtra("time", 0);
        long l2 = i2 + (i3 + i1);
        if ((!this.Q) && (this.al != l2))
        {
          this.al = l2;
          if (this.C != null)
          {
            this.C.ao();
            this.C.d(i1, i2, i3);
          }
          if (this.D != null)
            this.D.ao();
        }
      }
      else if ((str.equals("bluetooth")) && (this.state == 2))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.a(this.R, 0);
          if (this.D != null)
            this.D.a(this.R, 0);
        }
      }
      else if ((str.equals("a2dp")) && (this.state == 11))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.an();
          if (this.D != null)
            this.D.an();
        }
      }
      else if ((str.equals("avin")) && (this.state == 1))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ak();
          if (this.D != null)
            this.D.ak();
        }
      }
      else if ((str.equals("dtv")) && (this.state == 7))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.al();
          if (this.D != null)
            this.D.al();
        }
      }
      else if ((str.equals("ntv")) && (this.state == 8))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.al();
          if (this.D != null)
            this.D.al();
        }
      }
      else if ((str.equals("atv")) && (this.state == 6))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.am();
          if (this.D != null)
            this.D.am();
        }
      }
      else if ((str.equals("ipod")) && (this.state == 5))
      {
        this.ae = paramIntent;
        int i = paramIntent.getIntExtra("all", 0);
        int j = paramIntent.getIntExtra("cur", 0);
        int k = paramIntent.getIntExtra("time", 0);
        int m = paramIntent.getIntExtra("musicposition", 0);
        int n = paramIntent.getByteExtra("bili", (byte)0);
        long l1 = n + (m + (k + (i + j)));
        if ((!this.Q) && (this.al != l1))
        {
          if (this.C != null)
            this.C.a(i, j, n, m, k);
          if (this.D != null)
            this.D.a(i, j, n, m, k);
        }
      }
      else if (str.equals("ipod-on"))
      {
        this.ae = paramIntent;
        this.state = 5;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.a(0, 0, (byte)0, 0, 0);
          if (this.D != null)
            this.D.a(0, 0, (byte)0, 0, 0);
        }
      }
      else if (str.equals("radio-on"))
      {
        this.ae = paramIntent;
        this.state = 9;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.a((byte)0, 0, (byte)0);
          if (this.D != null)
            this.D.a((byte)0, 0, (byte)0);
        }
      }
      else if (str.equals("movie-on"))
      {
        this.ae = paramIntent;
        this.state = 4;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
          {
            this.C.ao();
            this.C.d(0, 0, 0);
          }
          if (this.D != null)
            this.D.ao();
        }
      }
      else if (str.equals("ntv-on"))
      {
        this.ae = paramIntent;
        this.state = 8;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.al();
          if (this.D != null)
            this.D.al();
        }
      }
      else if (str.equals("atv-on"))
      {
        this.ae = paramIntent;
        this.state = 6;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.am();
          if (this.D != null)
            this.D.am();
        }
      }
      else if (str.equals("dtv-on"))
      {
        this.ae = paramIntent;
        this.state = 7;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.al();
          if (this.D != null)
            this.D.al();
        }
      }
      else if (str.equals("avin-on"))
      {
        this.ae = paramIntent;
        this.state = 1;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ak();
          if (this.D != null)
            this.D.ak();
        }
      }
      else if (str.equals("bluetooth-on"))
      {
        this.ae = paramIntent;
        this.state = 2;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.a(this.R, 0);
          if (this.D != null)
            this.D.a(this.R, 0);
        }
      }
      else if (str.equals("a2dp-on"))
      {
        this.ae = paramIntent;
        this.state = 11;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.an();
          if (this.D != null)
            this.D.an();
        }
      }
      else if (str.equals("dvd-on"))
      {
        this.ae = paramIntent;
        this.state = 10;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.b(0, 0, 0);
          if (this.D != null)
            this.D.b(0, 0, -1);
        }
      }
      else if (str.equals("music-on"))
      {
        this.ae = paramIntent;
        this.state = 3;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.c(0, 0, 0);
          if (this.D != null)
            this.D.c(0, 0, 0);
        }
      }
      else if (str.equals("usb-on"))
      {
        this.ae = paramIntent;
        this.state = 12;
        this.al = -1L;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.c(0, 0, 0);
          if (this.D != null)
            this.D.c(0, 0, 0);
        }
      }
      else if ((str.equals("ipod-off")) && (this.state == 5))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("radio-off")) && (this.state == 9))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("movie-off")) && (this.state == 4))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("ntv-off")) && (this.state == 8))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("atv-off")) && (this.state == 6))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("dtv-off")) && (this.state == 7))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("avin-off")) && (this.state == 1))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("bluetooth-off")) && (this.state == 2))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("a2dp-off")) && (this.state == 11))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("dvd-off")) && (this.state == 10))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("music-off")) && (this.state == 3))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((str.equals("usb-off")) && (this.state == 12))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if ((this.state == 0) && (str.contains("-off")))
      {
        this.ae = paramIntent;
        this.state = 0;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ap();
          if (this.D != null)
            this.D.ap();
        }
      }
      else if (str.equals("on"))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
            this.C.ar();
          if (this.D != null)
            this.D.ar();
        }
      }
      else if (str.equals("off"))
      {
        this.ae = paramIntent;
        if (!this.Q)
        {
          if (this.C != null)
          {
            this.C.ap();
            this.C.aq();
          }
          if (this.D != null)
          {
            this.D.ap();
            this.D.aq();
          }
        }
      }
    }
  }

  public void a(AirCondition paramAirCondition)
  {
    try
    {
      this.d = paramAirCondition;
      x();
      if (this.ag)
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.AirServer"));
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("airdata", this.d);
        this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      }
      label78: return;
    }
    catch (Exception localException)
    {
      break label78;
    }
  }

  public void a(Door paramDoor)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.DoorServer"));
      localIntent.putExtra("canbustype", this.e);
      localIntent.putExtra("doordata", paramDoor);
      this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      label59: return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }

  public void a(Radar paramRadar)
  {
    try
    {
      if (Settings.System.getInt(getContentResolver(), "PackingRadarEN", 1) == 1)
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("android.microntek.canbus", "android.microntek.canbus.RadarServer"));
        localIntent.putExtra("canbustype", this.e);
        localIntent.putExtra("radardata", paramRadar);
        this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      }
      label74: return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }

  public boolean a()
  {
    return BaseApplication.k().c(this.e);
  }

  public void b(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 5];
    arrayOfByte[0] = -86;
    arrayOfByte[1] = 85;
    arrayOfByte[2] = ((byte)(paramInt & 0xFF));
    arrayOfByte[3] = paramByte;
    int j = (short)(arrayOfByte[2] + arrayOfByte[3]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 4)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 4)]);
      i++;
    }
    arrayOfByte[(paramInt + 4)] = ((byte)(0xFF & j - 1));
    b(arrayOfByte);
  }

  public void b(String paramString)
  {
    Settings.System.putString(getContentResolver(), "com.microntek.canbusversion", paramString);
  }

  public void b(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(0xFF & paramArrayOfByte[j]);
      str = String.format(localLocale, "%d", arrayOfObject);
      if (j < i - 1)
        str = str + ",";
    }
    this.mHandler.removeMessages(1);
    BaseApplication.k().setParameters("canbus_rsp=" + str);
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramArrayOfByte;
    this.mHandler.sendMessageDelayed(localMessage, 300L);
  }

  public void c(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 5];
    arrayOfByte[0] = -3;
    arrayOfByte[1] = ((byte)(0xFF & paramInt + 4));
    arrayOfByte[2] = paramByte;
    int j = (short)(arrayOfByte[1] + arrayOfByte[2]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 3)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 3)]);
      i++;
    }
    arrayOfByte[(paramInt + 3)] = ((byte)(0xFF & j >> 8));
    arrayOfByte[(paramInt + 4)] = ((byte)(j & 0xFF));
    b(arrayOfByte);
  }

  public void c(String paramString)
  {
    String str = paramString + "";
    BaseApplication.k().setParameters("ctl_lcd=" + str);
    this.mHandler.removeMessages(6);
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.what = 6;
    localMessage.obj = paramString;
    this.mHandler.sendMessageDelayed(localMessage, 3000L);
  }

  public void c(byte[] paramArrayOfByte)
  {
    String str;
    if ((paramArrayOfByte[0] == 121) && (paramArrayOfByte[2] > 0) && (paramArrayOfByte[2] < 5))
    {
      if (this.e != 72)
        break label122;
      str = "com.microntek.sync.SyncCanBus72";
    }
    while (true)
    {
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.setComponent(new ComponentName("com.microntek.sync", str));
      localIntent2.addFlags(807600128);
      localIntent2.putExtra("canbus", 1);
      try
      {
        startActivityAsUser(localIntent2, UserHandle.CURRENT_OR_SELF);
        Intent localIntent1 = new Intent("com.microntek.sync");
        localIntent1.putExtra("syncdata", paramArrayOfByte);
        sendBroadcastAsUser(localIntent1, UserHandle.CURRENT_OR_SELF);
        return;
        label122: str = "com.microntek.sync.SyncCanBus6";
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        while (true)
          Log.e("CanBusServer", "SYNC activity not found!");
      }
    }
  }

  public void d(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 4];
    arrayOfByte[0] = 85;
    arrayOfByte[1] = paramByte;
    arrayOfByte[2] = ((byte)(paramInt & 0xFF));
    int j = (short)arrayOfByte[2];
    while (i < paramInt)
    {
      arrayOfByte[(i + 3)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 3)]);
      i++;
    }
    arrayOfByte[(paramInt + 3)] = ((byte)(0xFF & j - 1));
    b(arrayOfByte);
  }

  public void d(int paramInt)
  {
    Settings.System.putInt(getContentResolver(), "com.microntek.RadarViewShow", paramInt);
  }

  public void d(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("com.microntek.sync");
    localIntent.putExtra("syncdata", paramArrayOfByte);
    this.mContext.sendBroadcastAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
  }

  public void e(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 4];
    arrayOfByte[0] = -3;
    arrayOfByte[1] = ((byte)(0xFF & paramInt + 3));
    arrayOfByte[2] = paramByte;
    int j = (short)(arrayOfByte[1] + arrayOfByte[2]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 3)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 3)]);
      i++;
    }
    arrayOfByte[(paramInt + 3)] = ((byte)(j & 0xFF));
    b(arrayOfByte);
  }

  public void e(int paramInt)
  {
    Settings.System.putInt(getContentResolver(), "com.microntek.ReverseViewShow", paramInt);
  }

  public void e(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("com.microntek.sync");
    localIntent.putExtra("syncdata", paramArrayOfByte);
    this.mContext.sendBroadcastAsUser(localIntent, UserHandle.CURRENT_OR_SELF);
  }

  public void f(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt + 5];
    arrayOfByte[0] = 90;
    arrayOfByte[1] = -91;
    arrayOfByte[2] = ((byte)(paramInt & 0xFF));
    arrayOfByte[3] = paramByte;
    int j = (short)(arrayOfByte[2] + arrayOfByte[3]);
    while (i < paramInt)
    {
      arrayOfByte[(i + 4)] = paramArrayOfByte[i];
      j = (short)(j + arrayOfByte[(i + 4)]);
      i++;
    }
    arrayOfByte[(paramInt + 4)] = ((byte)(0xFF & j - 1));
    b(arrayOfByte);
  }

  public int l()
  {
    return BaseApplication.k().l();
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.ai;
  }

  public void onCreate()
  {
    super.onCreate();
    this.mContext = getApplicationContext();
    f();
    v();
    Log.i("CanBusServer", "CanBus is Start 6.0 ! " + this.e);
    Log.i("CanBusServer", "CanBus is Items ! " + this.y);
  }

  public void onDestroy()
  {
    unregisterReceiver(this.aj);
    if (this.U != null)
      this.U.closePort(4);
    this.U = null;
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
  }

  public void t()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName("com.hiworld.canbus.services", "com.hiworld.canbus.services.SeiralService"));
      this.mContext.startServiceAsUser(localIntent, UserHandle.OWNER);
      label38: return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }

  public void v()
  {
    if (this.U == null);
    try
    {
      this.U = new SerialManager();
      this.U.openPort(4, 38400);
      this.V = new f(this);
      this.U.updateReceiver(4, this.V);
      label55: IntentFilter localIntentFilter1 = new IntentFilter();
      localIntentFilter1.addAction("com.microntek.canbusdisplay");
      localIntentFilter1.addAction("com.hiworld.canbus.send");
      localIntentFilter1.addAction("com.microntek.canbus20activity");
      localIntentFilter1.addAction("com.microntek.bootcheck");
      localIntentFilter1.addAction("com.microntek.bt.report");
      localIntentFilter1.addAction("com.microntek.screenOnOff");
      registerReceiver(this.aj, localIntentFilter1);
      IntentFilter localIntentFilter2 = new IntentFilter();
      localIntentFilter2.addAction("android.intent.action.TIME_SET");
      localIntentFilter2.addAction("android.intent.action.TIME_TICK");
      localIntentFilter2.addAction("com.microntek.VOLUME_CHANGED");
      localIntentFilter2.addAction("android.intent.action.LOCALE_CHANGED");
      localIntentFilter2.addAction("com.microntek.irkeyDown");
      registerReceiver(this.ak, localIntentFilter2);
      if (this.C != null)
        this.C.ah();
      if (this.D != null)
        this.D.ah();
      this.mHandler.removeMessages(2);
      this.mHandler.sendEmptyMessageDelayed(2, 1000L);
      Settings.System.putInt(getContentResolver(), "com.microntek.hiworld.ari", 0);
      this.mHandler.removeMessages(7);
      this.mHandler.sendEmptyMessageDelayed(7, 400L);
      return;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }

  public String w()
  {
    return ((ActivityManager.RunningTaskInfo)((ActivityManager)getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
  }

  // ERROR //
  public void x()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	android/microntek/canbus/CanBusServer:af	Landroid/os/RemoteCallbackList;
    //   6: invokevirtual 1144	android/os/RemoteCallbackList:beginBroadcast	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore 4
    //   13: iload 4
    //   15: iload_3
    //   16: if_icmpge +26 -> 42
    //   19: aload_0
    //   20: getfield 135	android/microntek/canbus/CanBusServer:af	Landroid/os/RemoteCallbackList;
    //   23: iload 4
    //   25: invokevirtual 1148	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   28: checkcast 1150	android/microntek/canbus/a/d
    //   31: invokeinterface 1151 1 0
    //   36: iinc 4 1
    //   39: goto -26 -> 13
    //   42: aload_0
    //   43: getfield 135	android/microntek/canbus/CanBusServer:af	Landroid/os/RemoteCallbackList;
    //   46: invokevirtual 1154	android/os/RemoteCallbackList:finishBroadcast	()V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    //   57: astore_1
    //   58: goto -9 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
    //   2	49	57	java/lang/Exception
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.CanBusServer
 * JD-Core Version:    0.6.2
 */