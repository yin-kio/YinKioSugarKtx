package com.yinkio.sugar_ktx

import android.animation.Animator
import android.animation.AnimatorListenerAdapter

inline fun Animator.addListener(
    crossinline onStart: (Animator?) -> Unit = {},
    crossinline onEnd: (Animator?) -> Unit = {},
    crossinline onCancel: (Animator?) -> Unit = {},
    crossinline onRepeat: (Animator?) -> Unit = {},
    crossinline onPause: (Animator?) -> Unit = {},
    crossinline onResume: (Animator?) -> Unit = {},
){
    addListener(object: AnimatorListenerAdapter(){
        override fun onAnimationStart(animation: Animator?) {
            onStart(animation)
        }

        override fun onAnimationEnd(animation: Animator?) {
            onEnd(animation)
        }

        override fun onAnimationCancel(animation: Animator?) {
            onCancel(animation)
        }

        override fun onAnimationRepeat(animation: Animator?) {
            onRepeat(animation)
        }

        override fun onAnimationPause(animation: Animator?) {
            onPause(animation)
        }

        override fun onAnimationResume(animation: Animator?) {
            onResume(animation)
        }
    })
}