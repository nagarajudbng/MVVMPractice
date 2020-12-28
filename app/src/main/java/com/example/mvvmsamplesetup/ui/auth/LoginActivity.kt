package com.example.mvvmsamplesetup.ui.auth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsamplesetup.R
import com.example.mvvmsamplesetup.databinding.ActivityLoginBinding
import com.example.mvvmsamplesetup.hide
import com.example.mvvmsamplesetup.show
import com.example.mvvmsamplesetup.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
        toast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}