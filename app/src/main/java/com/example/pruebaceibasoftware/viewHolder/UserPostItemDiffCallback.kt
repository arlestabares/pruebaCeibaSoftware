package com.example.pruebaceibasoftware.viewHolder

import androidx.recyclerview.widget.DiffUtil
import com.example.dominio.model.UserPostsDomain

class UserPostItemDiffCallback : DiffUtil.ItemCallback<UserPostsDomain>() {
    override fun areItemsTheSame(oldItem: UserPostsDomain, newItem: UserPostsDomain): Boolean {

        return oldItem == newItem

    }

    override fun areContentsTheSame(oldItem: UserPostsDomain, newItem: UserPostsDomain): Boolean {
        return oldItem.id == newItem.id
    }


}
