package com.example.repoexample.presentation.pin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.repoexample.R
import com.example.repoexample.presentation.extensions.translateAnimation
import kotlinx.android.synthetic.main.activity_pin.*

class PinActivity : AppCompatActivity(R.layout.activity_pin) {
    companion object {
        private const val MAX_ANIM_COUNT = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        randomSort()

        pinGroup.referencedIds
            .map { findViewById<View>(it) }
            .forEach { it.setOnClickListener { randomSort() } }
    }

    private fun randomSort() {
        root.post {
            val pinButtons = pinGroup.referencedIds.map { findViewById<View>(it) }
            val positions = pinButtons.map { Pair(it.x, it.y) }.toMutableList()
            val animatedViews = mutableListOf<View>()

            while (positions.isNotEmpty()) {
                val view = pinButtons.random()

                if (view in animatedViews) continue

                animatedViews.add(view)

                val position = positions.random()
                positions.remove(position)
                view.translateAnimation(position.first, position.second).start()
            }
        }
    }
}