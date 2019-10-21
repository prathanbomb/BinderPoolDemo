package th.co.digio.service

import android.os.RemoteException
import android.util.Log
import th.co.digio.aidl_module.IBinderB

class BinderBImpl : IBinderB.Stub() {
    @Throws(RemoteException::class)
    override fun methodB(paramB: String) {
        Log.e("lzw", "methodB $paramB")
    }
}