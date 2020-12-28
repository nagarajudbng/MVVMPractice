package com.example.mvvmsamplesetup.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsamplesetup.data.respositories.UserRepository

class AuthViewModel : ViewModel() {

    var email : String? = null
    var password : String? = null
    var authListener : AuthListener? = null

    fun onLoginButtonClick(view : View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            //show notification
            authListener?.onFailure("Login Failed")
            return
        }
        val loginResponse = UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)
    }

}