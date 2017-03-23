package com.binderpooldemo.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.servicedemo.server.IBinderPool;

public class BinderPoolTool {

    private Context c;
    private static BinderPoolTool INSTANCE;
    private IBinderPool pool;

    private ServiceConnection mBinderConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("lzw","onServiceConnected");
            pool = IBinderPool.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("lzw","onServiceDisconnected");
        }
    };

    private BinderPoolTool(Context c){
        this.c = c.getApplicationContext();
        bindAidl();
    }

    public static BinderPoolTool getInstance(Context c){
        if(INSTANCE == null){
            synchronized (ServiceConnection.class){
                if(INSTANCE == null){
                    INSTANCE = new BinderPoolTool(c);
                }
            }

        }
        return INSTANCE;
    }

    private void bindAidl(){
        Intent i = new Intent("com.binderpool");
        i.setPackage("com.servicedemo.server");
        c.bindService(i,mBinderConnection,Context.BIND_AUTO_CREATE);
    }

    public IBinder getBinder(int type){
        IBinder binder = null;
        try {
            binder = pool.getBinder(type);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return binder;
    }

}
