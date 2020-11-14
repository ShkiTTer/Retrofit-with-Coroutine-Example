package com.example.repoexample.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repoexample.R
import com.example.repoexample.domain.repo.model.Repo
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repo.*

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    private val items = mutableListOf<Repo>()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<Repo>) {
        this.items.apply {
            clear()
            addAll(items)
        }

        notifyDataSetChanged()
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(item: Repo) {
            repoNameText.text = item.name
            repoFullNameText.text = item.fullName
            repoOwnerNameText.text = item.owner.login

            Glide
                .with(ownerAvatarImage)
                .load(item.owner.avatarUrl)
                .into(ownerAvatarImage)
        }
    }
}