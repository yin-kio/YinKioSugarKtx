package com.yinkio.shugar_ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

inline fun AppCompatActivity.onIO(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return lifecycle.coroutineScope.launch(Dispatchers.IO) { action() }
}

inline fun Fragment.onIO(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return lifecycle.coroutineScope.launch(Dispatchers.IO) { action() }
}


inline fun ViewModel.onIO(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return viewModelScope.onIO(action)
}

inline fun CoroutineScope.onIO(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return launch(Dispatchers.IO) {
        action()
    }
}

suspend inline fun CoroutineScope.onMain(crossinline action: CoroutineScope.() -> Unit) {
    withContext(Dispatchers.Main) { action() }
}

inline fun ViewModel.onDefault(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return viewModelScope.onDefault(action)
}

inline fun CoroutineScope.onDefault(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return launch(Dispatchers.Default) {
        action()
    }
}

inline fun Fragment.onDefault(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return lifecycle.coroutineScope.launch(Dispatchers.Default) { action() }
}

inline fun AppCompatActivity.onDefault(crossinline action: suspend CoroutineScope.() -> Unit): Job {
    return lifecycle.coroutineScope.launch(Dispatchers.Default) { action() }
}