package com.example.repoexample.presentation.main

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.repoexample.presentation.extensions.dp

class RepoItemDecoration(
    private val separator: Drawable
) : RecyclerView.ItemDecoration() {

    private val verticalMargin = 8.dp
    private val horizontalMargin = 16.dp

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.children.forEach { child ->
            val top = child.bottom + verticalMargin
            val bottom = top + separator.intrinsicHeight
            val left = horizontalMargin
            val right = parent.right

            separator.setBounds(left, top, right, bottom)
            separator.draw(canvas)
        }
    }
}