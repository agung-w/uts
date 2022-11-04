package com.agung.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.agung.uts.databinding.ActivityLoginBinding
import com.agung.uts.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            if (binding.emailET.editText?.text.toString()=="agung@gmail.com"&&binding.passwordET.editText?.text.toString()=="1972050"){
                val intent= Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@LoginActivity,R.string.invalid_login,Toast.LENGTH_SHORT).show()
            }

        }

    }
}