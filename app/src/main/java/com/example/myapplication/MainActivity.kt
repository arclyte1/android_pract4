package com.example.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.sql.Time
import java.sql.Timestamp
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView3.text = ("SDK version: " + Build.VERSION.SDK_INT.toString())

        val text = intent.getStringExtra("text")
        if (!text.isNullOrBlank())
            binding.textView.text = text

        binding.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", binding.editTextTextPersonName.text.toString())
            startActivity(intent)
        }
    }

    fun addLog(text: String) {
        binding.textView3.text = (binding.textView3.text.toString() + "\n" + text + " " + Timestamp(System.currentTimeMillis()))
    }

    override fun onStart() {
        super.onStart()
        addLog("Activity started")
    }

    override fun onRestart() {
        super.onRestart()
        addLog("Activity restarted")
    }

    override fun onPause() {
        super.onPause()
        addLog("Activity paused")
    }

    override fun onResume() {
        super.onResume()
        addLog("Activity resumed")
    }
}