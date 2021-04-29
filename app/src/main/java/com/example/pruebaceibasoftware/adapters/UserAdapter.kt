package com.example.pruebaceibasoftware.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dominio.model.UserDomain
import com.example.pruebaceibasoftware.R
import com.example.pruebaceibasoftware.activities.IViewPublication
import com.example.pruebaceibasoftware.viewHolder.UserItemDiffCallback
import com.example.pruebaceibasoftware.viewHolder.UserViewHolder

class UserAdapter(private val iViewPublication: IViewPublication) : ListAdapter<UserDomain, UserViewHolder>(UserItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)

        return UserViewHolder(view,iViewPublication)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

}

