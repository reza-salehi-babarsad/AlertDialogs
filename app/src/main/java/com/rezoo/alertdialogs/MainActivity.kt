package com.rezoo.alertdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.rezoo.alertdialogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val addContactdialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Would You Like Add This To Contacts?")
            .setIcon(R.drawable.ic_action_name)
            .setPositiveButton("Yes"){ _ , _ ->
               Toast.makeText(this,"You  Added Contact",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _,_ ->
                Toast.makeText(this,"You  Did Not Add Contact",Toast.LENGTH_LONG).show()
            }.create()
        binding.button.setOnClickListener {
            addContactdialog.show()
        }


    }
}