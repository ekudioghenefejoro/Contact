package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel> // a mutable list is dynamic while a list is static

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        myContactList = mutableListOf()

        myContactAdapter= ContactAdapter(myContactList){
            val intent = Intent(this, ContactProfile::class.java)
            intent.putExtra("contactName", it.contactName)
            intent.putExtra("phoneNumber", it.phoneNumber)
            startActivity(intent)
        } // empty list
        binding.recyclerView.adapter =myContactAdapter


        binding.button3.setOnClickListener {
            val contactName : String = binding.editText.text.toString() //.text return eitable so add to string
            val phoneNumber : String = binding.editText2.text.toString() //.text return eitable so add to string
            val contactItem = ContactModel(contactName, phoneNumber)
            myContactList.add(contactItem) //if you run now it wont show so you need to notify your recycler
            myContactAdapter.notifyDataSetChanged()

            //read uo save data in a local database using Room developer.andrios.com/training/data-storage/room
        }

    }
}