package com.bshpanchuk.apimocker.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bshpanchuk.apimocker.data.model.PostItem

object PostDiffUtils : DiffUtil.ItemCallback<PostItem>() {
    override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
        return oldItem == newItem
    }

}