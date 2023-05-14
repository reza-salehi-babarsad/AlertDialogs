package com.rezoo.alertdialogs

import android.content.Context
import android.content.DialogInterface
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
        //First Dialog
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
        //Second Dialog
        val option= arrayOf("Red","Blue","Green")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one og these items")
            .setSingleChoiceItems(option,0){ _, i ->
                Toast.makeText(this,"you select ${option[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _ , _ ->
                Toast.makeText(this,"You  Accepted",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this,"You  Cancelled",Toast.LENGTH_LONG).show()
            }.create()
        binding.button2.setOnClickListener {
            singleChoiceDialog.show()
        }
        // Third Dialog
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one og these items")
            .setMultiChoiceItems(option, booleanArrayOf(false,false,false)){ _,i,isChecked ->
                if (isChecked){
                    Toast.makeText(this,"you Checked ${option[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"you UnChecked ${option[i]}",Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept"){ _ , _ ->
                Toast.makeText(this,"You  Accepted the MultiChoiceDialog",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this,"You  Cancelled the MultiChoiceDialog",Toast.LENGTH_LONG).show()
            }.create()
        binding.button3.setOnClickListener {
            multiChoiceDialog.show()
        }



    }
}