package com.yinkio.shugar_ktx

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding


fun ViewBinding.getColor(colorId: Int) : Int{
    return ContextCompat.getColor(root.context, colorId)
}

fun ViewBinding.getColorStateList(colorId: Int) : ColorStateList {
    return ColorStateList.valueOf(getColor(colorId))
}

fun ViewBinding.getString(stringResId: Int) : String{
    return root.context.getString(stringResId)
}

fun ViewBinding.getDrawable(resId: Int) : Drawable?{
    return AppCompatResources.getDrawable(root.context, resId)
}
