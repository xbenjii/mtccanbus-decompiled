package android.microntek.canbus.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder
  implements a
{
  public b()
  {
    attachInterface(this, "android.microntek.canbus.aidl.CanBusServiceInf");
  }

  public static a a(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      if ((localIInterface != null) && ((localIInterface instanceof a)))
        localObject = (a)localIInterface;
      else
        localObject = new c(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 1;
    switch (paramInt1)
    {
    default:
      i = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
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
    }
    while (true)
    {
      return i;
      paramParcel2.writeString("android.microntek.canbus.aidl.CanBusServiceInf");
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      b(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      a(e.b(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      b(e.b(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      W();
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int[] arrayOfInt = V();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(arrayOfInt);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool13 = y();
      paramParcel2.writeNoException();
      int i20 = 0;
      if (bool13)
        i20 = i;
      paramParcel2.writeInt(i20);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool12 = z();
      paramParcel2.writeNoException();
      int i19 = 0;
      if (bool12)
        i19 = i;
      paramParcel2.writeInt(i19);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i18 = A();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i18);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i17 = B();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i17);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i16 = C();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i16);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool11 = D();
      paramParcel2.writeNoException();
      int i15 = 0;
      if (bool11)
        i15 = i;
      paramParcel2.writeInt(i15);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool10 = E();
      paramParcel2.writeNoException();
      int i14 = 0;
      if (bool10)
        i14 = i;
      paramParcel2.writeInt(i14);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool9 = F();
      paramParcel2.writeNoException();
      int i13 = 0;
      if (bool9)
        i13 = i;
      paramParcel2.writeInt(i13);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool8 = G();
      paramParcel2.writeNoException();
      int i12 = 0;
      if (bool8)
        i12 = i;
      paramParcel2.writeInt(i12);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool7 = H();
      paramParcel2.writeNoException();
      int i11 = 0;
      if (bool7)
        i11 = i;
      paramParcel2.writeInt(i11);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i10 = I();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i10);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i9 = J();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i9);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i8 = K();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i8);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i7 = L();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i7);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i6 = M();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i6);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool6 = N();
      paramParcel2.writeNoException();
      int i5 = 0;
      if (bool6)
        i5 = i;
      paramParcel2.writeInt(i5);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool5 = O();
      paramParcel2.writeNoException();
      int i4 = 0;
      if (bool5)
        i4 = i;
      paramParcel2.writeInt(i4);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i3 = P();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i3);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i2 = Q();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i2);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int i1 = R();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i1);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool4 = S();
      paramParcel2.writeNoException();
      int n = 0;
      if (bool4)
        n = i;
      paramParcel2.writeInt(n);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool3 = T();
      paramParcel2.writeNoException();
      int m = 0;
      if (bool3)
        m = i;
      paramParcel2.writeInt(m);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      boolean bool2 = U();
      paramParcel2.writeNoException();
      int k = 0;
      if (bool2)
        k = i;
      paramParcel2.writeInt(k);
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.CanBusServiceInf");
      int j = paramParcel1.readInt();
      boolean bool1 = false;
      if (j != 0)
        bool1 = i;
      b(bool1);
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.a.b
 * JD-Core Version:    0.6.2
 */