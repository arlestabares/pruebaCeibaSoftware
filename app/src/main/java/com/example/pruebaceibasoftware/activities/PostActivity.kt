package com.example.pruebaceibasoftware.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebaceibasoftware.viewmodels.PostViewModel
import com.example.pruebaceibasoftware.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostActivity : AppCompatActivity() {

    val postViewModel:PostViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getAllpost()



    }

    private fun getAllpost() {
        postViewModel.getPostsByUser(1)
        postViewModel.lvPostUsers.observe(this, {
            var post = it
        })
    }
}