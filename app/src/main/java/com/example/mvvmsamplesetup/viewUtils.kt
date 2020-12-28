package com.example.mvvmsamplesetup

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.view.*


fun Context.toast(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    visibility = VISIBLE
}

fun ProgressBar.hide(){
    visibility = GONE
}
