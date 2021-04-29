package com.example.pruebaceibasoftware.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.dominio.model.UserDomain
import com.example.pruebaceibasoftware.R
import com.example.pruebaceibasoftware.adapters.UserAdapter
import com.example.pruebaceibasoftware.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), IViewPublication {

    val viewModelUser: UserViewModel by viewModel()

    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userAdapter = UserAdapter(this)
        recyclerViewSearchResults.adapter = userAdapter

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModelUser.GetUsersByName(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }

        editTextSearch.addTextChangedListener(textWatcher)


        getAllUsers()


    }

    private fun getAllUsers() {
        viewModelUser.lvUsers.observe(this, {
            userAdapter.submitList(it)
        })
    }

    override fun onClick(userDomain: UserDomain) {
        val bundle = Bundle()
        bundle.putInt("iduser", userDomain.id)
        bundle.putString("name", userDomain.name)
        bundle.putString("email", userDomain.mail)
        bundle.putString("phone", userDomain.phone)
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}