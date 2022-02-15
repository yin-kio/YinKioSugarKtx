package com.yinkio.shugar_ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStateAtLeast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

fun <T>Fragment.observe(
    flow: SharedFlow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    block: CoroutineScope.(T) -> Unit
){
    lifecycleScope.launch {
        lifecycle.whenStateAtLeast(state){
            flow.collect{
                block(it)
            }
        }
    }
}

fun <T>AppCompatActivity.observe(
    flow: SharedFlow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    block: CoroutineScope.(T) -> Unit
){
    lifecycleScope.launch {
        lifecycle.whenStateAtLeast(state){
            flow.collect{
                block(it)
            }
        }
    }
}