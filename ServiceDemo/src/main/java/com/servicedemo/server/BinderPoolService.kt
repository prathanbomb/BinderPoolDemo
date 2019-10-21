package com.servicedemo.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import com.servicedemo.server.IBinderPool.Stub

class BinderPoolService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return object : Stub() {
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