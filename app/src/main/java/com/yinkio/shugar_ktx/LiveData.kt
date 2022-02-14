package com.yinkio.shugar_ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T> AppCompatActivity.after(liveData: LiveData<T>, updating: (T) -> Unit){
    liveData.observe(this, updating)
}

fun <T> Fragment.after(liveData: LiveData<T>, updating: (T) -> Unit){
    liveData.observe(viewLifecycleOwner, updating)
}