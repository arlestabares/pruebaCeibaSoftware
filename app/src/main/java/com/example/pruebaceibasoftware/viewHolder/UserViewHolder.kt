package com.example.pruebaceibasoftware.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dominio.model.UserDomain
import com.example.pruebaceibasoftware.activities.IViewPublication
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserViewHolder(itemView: View,private val iViewPublication: IViewPublication): RecyclerView.ViewHolder(itemView) {


    fun bindTo(userDomain:UserDomain){
        itemView.name.text = userDomain.name
        itemView.phone.text = userDomain.phone
        itemView.email.text = userDomain.mail
        itemView.btn_view_post.setOnClickListener {
            iViewPublication.onClick(userDomain)
        }
    }

}