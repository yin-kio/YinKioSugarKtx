package com.yinkio.shugar_ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStateAtLeast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


inline fun <T>CoroutineScope.observe(flow: Flow<T>, crossinline block: CoroutineScope.(T) -> Unit){
    launch {
        flow.collect{
            block(it)
        }
    }
}


inline fun <T>Fragment.observe(
    flow: Flow<T>,
    scope: CoroutineScope = lifecycleScope,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: CoroutineScope.(T) -> Unit
) : Job{
    return scope.launch {
        lifecycle.whenStateAtLeast(state){
            flow.collect{
                block(it)
            }
        }
    }
}

inline fun <T>AppCompatActivity.observe(
    flow: Flow<T>,
    scope: CoroutineScope = lifecycleScope,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: CoroutineScope.(T) -> Unit
) : Job{
    return scope.launch {
        lifecycle.whenStateAtLeast(state){
            flow.collect{
                block(it)
            }
        }
    }
}