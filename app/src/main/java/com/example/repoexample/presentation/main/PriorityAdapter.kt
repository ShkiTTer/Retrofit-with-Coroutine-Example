package com.example.repoexample.presentation.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repoexample.R
import com.example.repoexample.data.net.priority.model.Priority
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_priority.*

class PriorityAdapter : RecyclerView.Adapter<PriorityAdapter.ViewHolder>() {

    private val items = mutableListOf<Priority>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_priority, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<Priority>) {
        this.items.apply {
            clear()
            addAll(items)
        }

        notifyDataSetChanged()
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(data: Priority) {
            priorityNameText.text = data.name
            priorityColorView.setBackgroundColor(Color.parseColor(data.color))
        }
    }
}