package com.example.myapplication;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("text")
        if (!text.isNullOrBlank())
            binding.textView.text = text

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text", binding.editTextTextPersonName.text.toString())
            startActivity(intent)
        }
    }
}
