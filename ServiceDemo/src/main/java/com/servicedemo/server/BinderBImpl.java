package com.servicedemo.server;

import android.os.RemoteException;
import android.util.Log;

public class BinderBImpl extends IBinderB.Stub{
    @Override
    public void methodB(String paramB) throws RemoteException {
        Log.e("lzw","methodB");
    }
}
