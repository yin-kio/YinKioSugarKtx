package com.yinkio.shugar_ktx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

inline fun ViewModel.onIO(crossinline action: suspend CoroutineScope.() -> Unit) : Job{
    return viewModelScope.onIO(action)
}

inline fun CoroutineScope.onIO(crossinline action: suspend CoroutineScope.() -> Unit) : Job{
    return launch(Dispatchers.IO) {
        action()
    }
}

suspend inline fun CoroutineScope.onMain(crossinline action: CoroutineScope.() -> Unit){
    withContext(Dispatchers.Main){action()}
}

inline fun ViewModel.onDefault(crossinline action: suspend CoroutineScope.() -> Unit) : Job{
    return viewModelScope.onDefault(action)
}

inline fun CoroutineScope.onDefault(crossinline action: suspend CoroutineScope.() -> Unit) : Job{
    return launch(Dispatchers.Default) {
        action()
    }
}