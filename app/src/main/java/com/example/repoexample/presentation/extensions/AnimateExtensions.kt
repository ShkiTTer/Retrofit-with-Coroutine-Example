package com.example.repoexample.presentation.extensions

import android.view.View
import android.view.ViewPropertyAnimator

fun View.translateAnimation(x: Float, y: Float): ViewPropertyAnimator {
    return this
        .animate()
        .setDuration(1000L)
        .x(x)
        .y(y)
}