package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact.databinding.ActivityContactProfileBinding

class ContactProfile : AppCompatActivity() {
    private lateinit var binding: ActivityContactProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = intent.getStringExtra("contactName")
        binding.textView1.text = intent.getStringExtra("phoneNumber")

    }
}