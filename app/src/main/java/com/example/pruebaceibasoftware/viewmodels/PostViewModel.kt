package com.example.pruebaceibasoftware.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dominio.model.UserPostsDomain
import com.example.dominio.service.IUserPostService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel(private val iUserPostService : IUserPostService ) : ViewModel() {


    private var _lvPostUsers: MutableLiveData<List<UserPostsDomain>> = MutableLiveData()
    var lvPostUsers: LiveData<List<UserPostsDomain>> = _lvPostUsers


    fun getPostsByUser(idUser:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                _lvPostUsers.value = iUserPostService.getPostByUsers(idUser)
            }
        }
    }

}