package com.example.pruebaceibasoftware.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebaceibasoftware.R
import com.example.pruebaceibasoftware.adapters.PostAdapter
import com.example.pruebaceibasoftware.viewmodels.PostViewModel
import kotlinx.android.synthetic.main.activity_post.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostActivity : AppCompatActivity() {

    lateinit var postAdapter: PostAdapter
    val postViewModel: PostViewModel by viewModel()
    private var idUser = 0
    lateinit var user_name: String
    lateinit var user_email: String
    lateinit var user_phone: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_post)

        getUserExtras()

        setData()

        if (idUser == 0) {
            finish()
        }

        postAdapter = PostAdapter()
        recyclerViewPostsResults.adapter = postAdapter

        getAllpost()

    }

    private fun setData() {
         name.text = user_name
         email.text = user_email
         phone.text = user_phone
    }

    private fun getUserExtras() {
        idUser = intent.extras?.getInt("iduser") ?: 0
        user_name = intent.extras?.getString("name") ?: ""
        user_email = intent.extras?.getString("email") ?: ""
        user_phone = intent.extras?.getString("phone") ?: ""
    }

    private fun getAllpost() {
        postViewModel.getPostsByUser(idUser)
        postViewModel.lvPostUsers.observe(this, {
            postAdapter.submitList(it)
        })
    }
}