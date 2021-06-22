package com.example.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    private var mRepository = PersonRepository()

    private var mTextWelcome = MutableLiveData<String>()
    var TextWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Hello World"
    }

    fun login(userName: String) {
        val retorno = mRepository.login(userName)
        mLogin.value = retorno
        //mTextWelcome.value = "Olá Mundo"
    }
}