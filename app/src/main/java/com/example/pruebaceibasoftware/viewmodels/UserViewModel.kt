package com.example.pruebaceibasoftware.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dominio.model.UserDomain
import com.example.dominio.service.IUserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val iUserService: IUserService) : ViewModel() {

    private var _lvUsers: MutableLiveData<List<UserDomain>> = MutableLiveData()
    var lvUsers: LiveData<List<UserDomain>> = _lvUsers

    init {
        getAllUsers()
    }

    private fun getAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                _lvUsers.value = iUserService.getUsers()
            }
        }
    }

     fun GetUsersByName(name:String){
         CoroutineScope(Dispatchers.IO).launch {
             withContext(Dispatchers.Main){
                 _lvUsers.value = iUserService.getUsersBySearch(name)
             }
         }
    }
}