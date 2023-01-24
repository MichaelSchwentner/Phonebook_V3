package com.example.phonebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phonebook.databinding.FragmentDetailBinding
import com.example.phonebook.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val imageResource = requireArguments().getInt()
        val name = requireArguments().getString("name", "not found")
        val number = requireArguments().getString("number", "not found")

        binding.detailNameText.text = name
        binding.detailNumberText.text = number


    }
}