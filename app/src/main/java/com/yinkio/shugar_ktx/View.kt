package com.yinkio.shugar_ktx

import android.content.res.ColorStateList
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun TextView.setTextAfter(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    scope: CoroutineScope = CoroutineScope(dispatcher),
    crossinline getString: CoroutineScope.() -> String){
    scope.launch {
        val str = getString()
        onMain {
            text = str
        }
    }
}

inline fun CompoundButton.setCheckedAfter(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    scope: CoroutineScope = CoroutineScope(dispatcher),
    crossinline getBoolean: CoroutineScope.() -> Boolean
){
    scope.launch {
        val boolean = getBoolean()
        onMain {
            isChecked = boolean
        }
    }
}

fun SearchView.doOnTextChange(action: (String) -> Unit){
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }
        override fun onQueryTextChange(newText: String?): Boolean {
            action(newText.toString())
            return true
        }
    })
}

inline fun <T : View> T.onClick(crossinline action: (T) -> Unit){
    setOnClickListener {action(this)}
}

fun View.getColorStateList(colorId: Int) : ColorStateList {
    return ColorStateList.valueOf(ContextCompat.getColor(context, colorId))
}

fun View.getColor(colorId: Int) : Int{
    return ContextCompat.getColor(context, colorId)
}