package com.servicedemo.server

import android.os.RemoteException
import android.util.Log
import com.servicedemo.server.IBinderA.Stub

class BinderAImpl : Stub() {
    @Throws(RemoteException::class)
    override fun methodA(paramA: String) {
        Log.e("lzw", "methodA $paramA")
    }
}