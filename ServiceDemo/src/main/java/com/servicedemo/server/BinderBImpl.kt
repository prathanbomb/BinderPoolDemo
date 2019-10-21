package com.servicedemo.server

import android.os.RemoteException
import android.util.Log
import com.servicedemo.server.IBinderB.Stub

class BinderBImpl : Stub() {
    @Throws(RemoteException::class)
    override fun methodB(paramB: String) {
        Log.e("lzw", "methodB")
    }
}