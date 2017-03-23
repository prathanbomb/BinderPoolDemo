package com.servicedemo.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BinderPoolService extends Service {
    public BinderPoolService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IBinderPool.Stub() {
            @Override
            public IBinder getBinder(int type) throws RemoteException {
                switch (type) {
                    case 1:
                        return new BinderAImpl();
                    default:
                        return new BinderBImpl();
                }
            }
        };
    }

}
