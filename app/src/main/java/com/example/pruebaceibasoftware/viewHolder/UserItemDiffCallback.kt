package com.example.pruebaceibasoftware.viewHolder

import androidx.recyclerview.widget.DiffUtil
import com.example.dominio.model.UserDomain

class UserItemDiffCallback : DiffUtil.ItemCallback<UserDomain>() {
    override fun areItemsTheSame(oldItem: UserDomain, newItem: UserDomain): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: UserDomain, newItem: UserDomain): Boolean = oldItem.id == newItem.id

}