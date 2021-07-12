package com.example.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.databinding.ContactItemBinding

class ContactAdapter(val contactItems: List<ContactModel>,
var clickfnx:(ContactModel)-> Unit): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

  inner  class ViewHolder(val binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (contactItem: ContactModel){
            binding.contactName.text = contactItem.contactName
            binding.phoneNumber.text = contactItem.phoneNumber //you describe you logic here
            binding.root.setOnClickListener {
                clickfnx(contactItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactItemBinding = ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactItems.get(position))
    }

    override fun getItemCount()=contactItems.size //another way to implement return
}