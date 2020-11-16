package com.example.pruebaceibasoftware

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dominio.service.IUserService
import com.example.dominio.service.UserService
import com.example.dominio.service.model.UserDomain
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

   val service : IUserService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        boton.setOnClickListener {
            val id = 6
            val nombre = "lola"
            val telefono = "telefono"
            val mail = "mail"

            try {

                service.insertUser(id, nombre, telefono, mail)
            }catch (e:Exception){
                e.message
            }
        }


    }

}