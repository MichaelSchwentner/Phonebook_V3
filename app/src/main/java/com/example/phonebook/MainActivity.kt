package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.phonebook.adapter.PhonebookAdapter
import com.example.phonebook.data.Datasource
import com.example.phonebook.data.model.PhonebookItem
import com.example.phonebook.databinding.ActivityMainBinding


/*import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity*/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var contacts = Datasource().getPhonebookList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
/*    fun call(view: View) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "8344814819")
        startActivity(dialIntent)
    }*/
}