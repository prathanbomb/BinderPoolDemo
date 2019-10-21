package th.co.digio.aidl_module

import android.os.RemoteException
import android.util.Log

class BinderBImpl : IBinderB.Stub() {
    @Throws(RemoteException::class)
    override fun methodB(paramB: String) {
        Log.e("lzw", "methodB $paramB")
    }
}