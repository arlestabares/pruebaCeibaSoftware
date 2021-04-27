package com.example.pruebaceibasoftware.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebaceibasoftware.R
import com.example.pruebaceibasoftware.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModelUser: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllUsers()


    }

    private fun getAllUsers() {
        viewModelUser.lvUsers.observe(this, {
            val users = it
            startActivity(Intent(this@MainActivity , PostActivity::class.java))
        })
    }

}