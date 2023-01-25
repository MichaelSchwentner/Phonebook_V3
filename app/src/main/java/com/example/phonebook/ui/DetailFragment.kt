package com.example.phonebook.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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

        //holder.phonebookNumber.text = "+49 ${phonebookItem.number}"

        binding.detailNameText.text = name
        binding.detailNumberText.text = "+49 $number"

        binding.detailCallbuttonImage.setOnClickListener {
            call(number)
        }

        binding.editButton.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToEditFragment(
                    name,
                    number
                ))
        }

        binding.backButton.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToHomeFragment(

                ))
        }

    }

    fun call(number: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + number)
        startActivity(dialIntent)
    }
}