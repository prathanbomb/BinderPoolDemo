package th.co.digio.client

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import th.co.digio.aidl_module.IBinderPool

//import com.servicedemo.server.IBinderPool
//import com.servicedemo.server.IBinderPool.Stub

class BinderPoolTool private constructor(c: Context) {
    private val context: Context = c.applicationContext
    private var pool: IBinderPool? = null
    private val mBinderConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e("lzw", "onServiceConnected")
            pool = IBinderPool.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e("lzw", "onServiceDisconnected")
        }
    }

    private fun bindAidl() {
        val i = Intent("com.binderpool")
        i.setPackage("th.co.digio.service")
        context.bindService(i, mBinderConnection, Context.BIND_AUTO_CREATE)
    }

    fun getBinder(type: Int): IBinder? {
        var binder: IBinder? = null
        try {
            binder = pool!!.getBinder(type)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return binder
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: BinderPoolTool? = null

        fun getInstance(c: Context): BinderPoolTool? {
            if (INSTANCE == null) {
                synchronized(ServiceConnection::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = BinderPoolTool(c)
                    }
                }
            }
            return INSTANCE
        }
    }

    init {
        bindAidl()
    }
}