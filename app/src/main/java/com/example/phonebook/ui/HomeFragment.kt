package com.example.phonebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phonebook.adapter.PhonebookAdapter
import com.example.phonebook.data.Datasource
import com.example.phonebook.data.model.PhonebookItem
import com.example.phonebook.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private  lateinit var phonebookList: MutableList<PhonebookItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val datasource = Datasource()
        phonebookList = datasource.getPhonebookList()

        val deletePhone = { position: PhonebookItem ->
            //phonebookList.remove(position)
            deleteItem(position)
        }


        val phonebookAdapter = PhonebookAdapter(phonebookList, deletePhone)
        binding.homePhonebookRecycler.adapter = phonebookAdapter

        binding.homeAddButton.setOnClickListener {
            addPhonebookItem(phonebookAdapter)
        }
        // Logo in Actionbar
/*        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_launcher_background)
        supportActionBar?.setDisplayUseLogoEnabled(true)*/
    }

    //Number delete
/*    private fun deleteNumberItem(adapter: PhonebookAdapter, item: PhonebookItem) {
        val position = phonebookList.indexOf(item)
        phonebookList.remove(item)
        adapter.notifyItemRemoved(position)
    }*/

    //Number delete
    fun deleteItem(position: PhonebookItem){
        phonebookList.remove(position)
    }

    private fun addPhonebookItem(adapter: PhonebookAdapter) {
        val name = binding.homeNameEdit.text.toString()
        val number = binding.homeNumberEdit.text.toString()

        if (!name.isNullOrEmpty()){
            val newNumber = PhonebookItem(name, number)
            phonebookList.add(0,newNumber)
            adapter.notifyItemInserted(0)

        }
    }
}