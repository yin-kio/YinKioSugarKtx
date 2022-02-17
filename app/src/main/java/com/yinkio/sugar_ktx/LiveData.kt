package com.yinkio.sugar_ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <T> AppCompatActivity.observe(liveData: LiveData<T>, crossinline updating: (T) -> Unit){
    liveData.observe(this){updating(it)}
}

inline fun <T> Fragment.observe(liveData: LiveData<T>, crossinline updating: (T) -> Unit){
    liveData.observe(viewLifecycleOwner){updating(it)}
}

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline updating: (T) -> Unit){
    liveData.observe(this){updating(it)}
}