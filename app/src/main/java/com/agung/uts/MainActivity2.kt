package com.agung.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agung.uts.databinding.ActivityLoginBinding
import com.agung.uts.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.searchRv)
    }

    override fun onStart() {
        super.onStart()
    }
}