package th.co.digio.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import th.co.digio.aidl_module.BinderAImpl
import th.co.digio.aidl_module.BinderBImpl
import th.co.digio.aidl_module.IBinderPool

class BinderPoolService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return object : IBinderPool.Stub() {
            @Throws(RemoteException::class)
            override fun getBinder(type: Int): IBinder {
                return when (type) {
                    1 -> BinderAImpl()
                    else -> BinderBImpl()
                }
            }
        }
    }
}