package com.bshpanchuk.apimocker.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bshpanchuk.apimocker.data.model.PostItem
import com.bshpanchuk.apimocker.databinding.PostItemBinding

class PostViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostItem) {
        with(binding) {
            title.text = item.title
            post.text = item.body
        }
    }
}