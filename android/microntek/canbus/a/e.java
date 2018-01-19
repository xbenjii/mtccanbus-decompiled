package android.microntek.canbus.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class e extends Binder
  implements d
{
  public e()
  {
    attachInterface(this, "android.microntek.canbus.aidl.ICanBusAidlCallBack");
  }

  public static d b(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null)
      localObject = null;
    while (true)
    {
      return localObject;
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      if ((localIInterface != null) && ((localIInterface instanceof d)))
        localObject = (d)localIInterface;
      else
        localObject = new f(paramIBinder);
    }
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default:
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
    case 1:
    case 2:
    }
    while (true)
    {
      return bool;
      paramParcel2.writeString("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      h(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      continue;
      paramParcel1.enforceInterface("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      x();
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.a.e
 * JD-Core Version:    0.6.2
 */