package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.TextWelcome.observe(this, Observer {
            textWelcome.text = it
        })

        viewModel.login.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
        })

        buttonLogin.setOnClickListener {
            val userName = editName.text.toString()
            viewModel.login(userName)
        }
    }
}