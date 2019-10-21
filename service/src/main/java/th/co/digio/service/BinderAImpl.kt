package th.co.digio.service

import android.os.RemoteException
import android.util.Log
import th.co.digio.aidl_module.IBinderA.Stub

class BinderAImpl : Stub() {
    @Throws(RemoteException::class)
    override fun methodA(paramA: String) {
        Log.e("lzw", "methodA $paramA")
    }
}