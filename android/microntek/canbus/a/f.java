package android.microntek.canbus.a;

import android.os.IBinder;
import android.os.Parcel;

class f
  implements d
{
  private IBinder br;

  f(IBinder paramIBinder)
  {
    this.br = paramIBinder;
  }

  public IBinder asBinder()
  {
    return this.br;
  }

  public void h(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      localParcel1.writeByteArray(paramArrayOfByte);
      this.br.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public void x()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.microntek.canbus.aidl.ICanBusAidlCallBack");
      this.br.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:           C:\Users\Ben\AppData\Local\Temp\MTCCanbus-dex2jar.jar
 * Qualified Name:     android.microntek.canbus.a.f
 * JD-Core Version:    0.6.2
 */