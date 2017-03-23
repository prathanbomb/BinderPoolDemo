package com.binderpooldemo.client;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.servicedemo.server.IBinderA;
import com.servicedemo.server.IBinderB;

public class MainActivity extends AppCompatActivity {

    private BinderPoolTool pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pool = BinderPoolTool.getInstance(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn3:
                IBinderA a = IBinderA.Stub.asInterface(pool.getBinder(1));
                try {
                    a.methodA("");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn4:
                IBinderB b = IBinderB.Stub.asInterface(pool.getBinder(0));
                try {
                    b.methodB("");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
