package com.servicedemo.server;

import android.os.RemoteException;
import android.util.Log;

public class BinderAImpl extends IBinderA.Stub{
    @Override
    public void methodA(String paramA) throws RemoteException {
        Log.e("lzw","methodA");
    }
}
