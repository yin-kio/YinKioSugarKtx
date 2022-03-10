package com.yinkio.sugar_ktx

import android.graphics.drawable.Drawable
import android.text.format.Formatter
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.formatFileSize(size: Long): String{
    return Formatter.formatFileSize(requireContext(), size)
}

fun Fragment.getDrawable(resId: Int) : Drawable?{
    return AppCompatResources.getDrawable(requireContext(), resId)
}

fun Fragment.getColor(colorId: Int) : Int{
    return ContextCompat.getColor(requireContext(), colorId)
}