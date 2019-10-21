package com.binderpooldemo.client

import android.os.Bundle
import android.os.RemoteException
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.binderpooldemo.client.R.id
import com.binderpooldemo.client.R.layout
import com.servicedemo.server.IBinderA
import com.servicedemo.server.IBinderA.Stub
import com.servicedemo.server.IBinderB

class MainActivity : AppCompatActivity() {
    private var pool: BinderPoolTool? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        pool = BinderPoolTool.getInstance(this)
    }

    fun onClick(v: View) {
        when (v.id) {
            id.btn3 -> {
                val a: IBinderA = Stub.asInterface(pool!!.getBinder(1))
                try {
                    a.methodA("test")
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
            id.btn4 -> {
                val b: IBinderB = IBinderB.Stub.asInterface(pool!!.getBinder(0))
                try {
                    b.methodB("")
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
        }
    }
}