package com.example.pruebaceibasoftware

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dominio.service.IUserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val service: IUserService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        buttonLLamadaApi.setOnClickListener {
            //Si necesitamos un ambito muy amplio como el de Application podemos utilizar un globalScope
            // ya que este se seguira ejecutando o estara vivo mientras la aplicacion se este ejecuctando o continue
            //launch es el constructor por defecto , y dentro podremos ejecutar funciones de suspension que bloquean la ejecucion de la corrutina
            //pero que si se hacen bien no bloquean el hilo en el que se este ejecutando.
            GlobalScope.launch() {
                val users = service.getUsers()

                users.map {
                    print(it)
                }
            }

        }

    }


}