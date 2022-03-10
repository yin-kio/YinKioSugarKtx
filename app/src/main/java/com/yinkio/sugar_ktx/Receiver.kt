package com.yinkio.sugar_ktx

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_PAUSE
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.LifecycleEventObserver


inline fun AppCompatActivity.registerReceiver(
    intentFilter: IntentFilter,
    registerOn: Lifecycle.Event = ON_RESUME,
    unregisterOn: Lifecycle.Event = ON_PAUSE,
    crossinline block: (context: Context?, intent: Intent?) -> Unit
){
    val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) =
            block(context, intent)
    }

    lifecycle.addObserver(LifecycleEventObserver{source, event ->
        if (event == registerOn){
            registerReceiver(receiver, intentFilter)
        } else if (event == unregisterOn) {
            unregisterReceiver(receiver)
        }
    })

}

inline fun Fragment.registerReceiver(
    intentFilter: IntentFilter,
    registerOn: Lifecycle.Event = ON_RESUME,
    unregisterOn: Lifecycle.Event = ON_PAUSE,
    crossinline block: (context: Context?, intent: Intent?) -> Unit
){
    val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) =
            block(context, intent)
    }

    lifecycle.addObserver(LifecycleEventObserver{ _, event ->
        if (event == registerOn){
            requireContext().registerReceiver(receiver, intentFilter)
        } else if (event == unregisterOn) {
            requireContext().unregisterReceiver(receiver)
        }
    })
}


