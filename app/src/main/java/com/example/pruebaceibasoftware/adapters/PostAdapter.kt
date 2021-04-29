package com.example.pruebaceibasoftware.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dominio.model.UserPostsDomain
import com.example.pruebaceibasoftware.R
import com.example.pruebaceibasoftware.viewHolder.PostViewHolder
import com.example.pruebaceibasoftware.viewHolder.UserPostItemDiffCallback

class PostAdapter : ListAdapter<UserPostsDomain, PostViewHolder>(
    UserPostItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

}

