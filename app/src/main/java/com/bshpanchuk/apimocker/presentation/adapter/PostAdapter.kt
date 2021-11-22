package com.bshpanchuk.apimocker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bshpanchuk.apimocker.data.model.PostItem
import com.bshpanchuk.apimocker.databinding.PostItemBinding

class PostAdapter :
    ListAdapter<PostItem, PostViewHolder>(PostDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
